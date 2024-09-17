package selenium.testingmachine.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class IsErrorList {

    @ListMessageField
    private static List<ErrorMessageDTO> ListMessageField = new ArrayList<>();

    public static boolean isErrorMessagePresent(WebDriver driver, String id, String fileName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement messageContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme.ui-pnotify-container")));
            WebElement messageTitle = messageContainer.findElement(By.cssSelector(".ui-pnotify-title"));
            String messageTitleText = messageTitle.getText().toLowerCase();

            if (messageTitleText.contains("warning") || messageTitleText.contains("Warning") ||
                    messageTitleText.contains("error") || messageTitleText.contains("Error") ||
                    messageTitleText.contains("info") || messageTitleText.contains("Info"))
            {
                return extractErrorMessage(driver,  id, fileName);
            }

            return false;
        } catch (Exception e) {
//            System.out.println("Error while checking for message title: " + e.getMessage());
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
