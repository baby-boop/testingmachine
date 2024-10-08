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

public class CheckWorkflow {

    @selenium.testingmachine.meta.Fields.ListMessageField
    private static List<ErrorMessageDTO> ListMessageField = new ArrayList<>();

    public static boolean isErrorMessagePresent(WebDriver driver, String id, String fileName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

            WebElement workflowTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Төлөв өөрчлөх")));
            System.out.println( "get Text " + workflowTitle.getText());

            if(workflowTitle != null) {
                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
                 List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));
                 if (!rows.isEmpty()) {

                     Thread.sleep(500);

                     WebElement firstRow = rows.get(0);
                     Actions actions = new Actions(driver);
                     System.out.println("Last row text: " + firstRow.getText());

                     Thread.sleep(1000);

                     WebElement cell = firstRow.findElement(By.xpath(".//td[1]"));

                     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                      actions.moveToElement(cell).click().perform();

                     WebElement rowSelectBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Төлөв өөрчлөх")));
                     rowSelectBtn.click();


                     WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                             By.cssSelector(".dropdown-menu.workflow-dropdown-"+ id + ".show")
                     ));

                     List<WebElement> listItems = dropdownMenu.findElements(By.tagName("li"));

                     for (WebElement listItem : listItems) {
                         WebElement anchorTag = listItem.findElement(By.tagName("a"));
                         String onclickAttr = anchorTag.getAttribute("onclick");

                         if (onclickAttr != null && onclickAttr.contains("changeWfmStatusId")) {
                             System.out.println("Clicking the list item with text: " + anchorTag.getText());

                             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", anchorTag);
                             anchorTag.click();

                             WebElement messageContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme.ui-pnotify-container")));
                             WebElement messageTitle = messageContainer.findElement(By.cssSelector(".ui-pnotify-title"));
                             String messageTitleText = messageTitle.getText().toLowerCase();


                             if (messageTitleText.contains("warning") || messageTitleText.contains("Warning") ||
                                     messageTitleText.contains("error") || messageTitleText.contains("Error") ||
                                     messageTitleText.contains("info") || messageTitleText.contains("Info"))
                             {

                                 if(messageTitleText.contains("Error Fetching http headers")){
                                     System.out.println("Холболтоо шалгана уу!" );
                                     System.out.println("Сүүлд ажилласан: " + fileName + " - " + id);
                                     driver.quit();
                                 }
                                 else{
                                     return extractErrorMessage(driver,  id, fileName);
                                 }
                             }

                             break;
                         }
                     }


                 }else {
                     System.out.println("No rows found." + id + fileName);
                 }
            }




            System.out.println("end 1");
            return false;
        } catch (Exception e) {
            System.out.println("end 2");
            return false;
        }
    }

    private static boolean extractErrorMessage(WebDriver driver, String id, String fileName) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement messageContent = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-pnotify-text")));
            String messageText = messageContent.getText();

            String metaId = "";
            String metaCode  = "";
            try {
                WebElement targetDiv = driver.findElement(By.cssSelector("div.main-dataview-container"));
                metaId = targetDiv.getAttribute("data-process-id");
                metaCode = targetDiv.getAttribute("data-meta-code");
            } catch (Exception e) {
                System.out.println("Data process ID element not found: " + e.getMessage());
            }

            ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(fileName, metaId, metaCode, messageText);

            ListMessageField.add(errorMessageDTO);

            return messageContent.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error while extracting message: " + e.getMessage());
            return false;
        }
    }

    public static List<ErrorMessageDTO> getListMessages() {
        return new ArrayList<>(ListMessageField);
    }
}
