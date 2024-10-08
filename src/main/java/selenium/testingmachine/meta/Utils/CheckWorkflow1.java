package selenium.testingmachine.meta.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.testingmachine.meta.DTO.ErrorMessageDTO;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckWorkflow1 {

    private static final Logger LOGGER = Logger.getLogger(CheckWorkflow.class.getName());
    private static final int SHORT_WAIT_SECONDS = 2;
    private static final int LONG_WAIT_MILLISECONDS = 1000;

    @selenium.testingmachine.meta.Fields.ListMessageField
    private static List<ErrorMessageDTO> ListMessageField = new ArrayList<>();

    public static boolean isErrorMessagePresent(WebDriver driver, String id, String fileName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_WAIT_SECONDS));

            WebElement workflowTitle = waitForElementVisible(driver, By.linkText("Төлөв өөрчлөх"), SHORT_WAIT_SECONDS);
            if (workflowTitle == null) {
                LOGGER.log(Level.WARNING, "Workflow title not found");
                return false;
            }
            LOGGER.log(Level.INFO, "Found workflow title: {0}", workflowTitle.getText());

            List<WebElement> rows = findRows(driver);
            if (rows.isEmpty()) {
                LOGGER.log(Level.INFO, "No rows found for id: {0}, file: {1}", new Object[]{id, fileName});
                return false;
            }

            WebElement firstRow = rows.get(0);
            clickFirstRow(driver, firstRow);

            WebElement dropdownMenu = waitForElementVisible(driver,
                    By.cssSelector(".dropdown-menu.workflow-dropdown-" + id + ".show"), SHORT_WAIT_SECONDS);
            if (dropdownMenu != null) {
                clickValidMenuOption(driver, wait, dropdownMenu, id, fileName);
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while checking workflow: {0}", e.getMessage());
            return false;
        }
        return false;
    }

    private static List<WebElement> findRows(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_WAIT_SECONDS));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            return driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error finding rows: {0}", e.getMessage());
            return new ArrayList<>();
        }
    }

    private static void clickFirstRow(WebDriver driver, WebElement firstRow) throws InterruptedException {
        Actions actions = new Actions(driver);
        LOGGER.log(Level.INFO, "First row text: {0}", firstRow.getText());

        WebElement cell = firstRow.findElement(By.xpath(".//td[1]"));
        scrollToElement(driver, cell);
        actions.moveToElement(cell).click().perform();
        Thread.sleep(LONG_WAIT_MILLISECONDS);  // Replace with proper WebDriverWait if possible
    }

    private static void clickValidMenuOption(WebDriver driver, WebDriverWait wait, WebElement dropdownMenu, String id, String fileName) {
        List<WebElement> listItems = dropdownMenu.findElements(By.tagName("li"));
        for (WebElement listItem : listItems) {
            WebElement anchorTag = listItem.findElement(By.tagName("a"));
            String onclickAttr = anchorTag.getAttribute("onclick");

            if (onclickAttr != null && onclickAttr.contains("changeWfmStatusId")) {
                LOGGER.log(Level.INFO, "Clicking the list item with text: {0}", anchorTag.getText());
                scrollToElement(driver, anchorTag);
                anchorTag.click();
                if (checkForMessages(driver, wait, id, fileName)) {
                    break;
                }
            }
        }
    }

    private static boolean checkForMessages(WebDriver driver, WebDriverWait wait, String id, String fileName) {
        try {
            WebElement messageContainer = waitForElementVisible(driver, By.cssSelector(".brighttheme.ui-pnotify-container"), SHORT_WAIT_SECONDS);
            if (messageContainer != null) {
                WebElement messageTitle = messageContainer.findElement(By.cssSelector(".ui-pnotify-title"));
                String messageTitleText = messageTitle.getText().toLowerCase();
                return processMessage(driver, messageTitleText, id, fileName);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while checking messages: {0}", e.getMessage());
        }
        return false;
    }

    private static boolean processMessage(WebDriver driver, String messageTitleText, String id, String fileName) {
        if (messageTitleText.contains("warning") || messageTitleText.contains("error") ||
                messageTitleText.contains("info")) {

            if (messageTitleText.contains("error fetching http headers")) {
                LOGGER.log(Level.SEVERE, "Connection error! Last processed: {0} - {1}", new Object[]{fileName, id});
                driver.quit();
                return false;
            } else {
                return extractErrorMessage(driver, id, fileName);
            }
        }
        return false;
    }

    private static boolean extractErrorMessage(WebDriver driver, String id, String fileName) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_WAIT_SECONDS));
            WebElement messageContent = waitForElementVisible(driver, By.cssSelector(".ui-pnotify-text"), SHORT_WAIT_SECONDS);
            if (messageContent != null) {
                String messageText = messageContent.getText();
                ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(fileName, getMetaAttribute(driver, "data-process-id"),
                        getMetaAttribute(driver, "data-meta-code"), messageText);
                ListMessageField.add(errorMessageDTO);
                return true;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while extracting message: {0}", e.getMessage());
        }
        return false;
    }

    private static String getMetaAttribute(WebDriver driver, String attribute) {
        try {
            WebElement targetDiv = driver.findElement(By.cssSelector("div.main-dataview-container"));
            return targetDiv.getAttribute(attribute);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Meta attribute not found: {0}", e.getMessage());
            return "";
        }
    }

    private static WebElement waitForElementVisible(WebDriver driver, By locator, int waitSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Element not found: {0}", e.getMessage());
            return null;
        }
    }

    private static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static List<ErrorMessageDTO> getListMessages() {
        return new ArrayList<>(ListMessageField);
    }
}
