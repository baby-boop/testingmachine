package selenium.testingmachine.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.testingmachine.config.errorMessageField;
import selenium.testingmachine.config.infoMessageField;
import selenium.testingmachine.config.warningMessageField;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class IsErrorList {

    @errorMessageField
    private static List<String> errorMessages = new ArrayList<>();

    @warningMessageField
    private static List<String> warningMessages = new ArrayList<>();

    @infoMessageField
    private static List<String> infoMessages = new ArrayList<>();

    private static int errorCount = 0;
    private static int warningCount = 0;
    private static int infoCount = 0;

    public static boolean isErrorMessagePresent(WebDriver driver, WebDriverWait wait, String id) {
        try {
            WebElement messageContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme.ui-pnotify-container")));
            WebElement messageTitle = messageContainer.findElement(By.cssSelector(".ui-pnotify-title"));
            String messageTitleText = messageTitle.getText().toLowerCase();

            if (messageTitleText.contains("warning") || messageTitleText.contains("Warning")) {
                warningCount++;
                return extractErrorMessage(driver, wait, true, false, id);
            } else if (messageTitleText.contains("error") || messageTitleText.contains("Error")) {
                errorCount++;
                return extractErrorMessage(driver, wait, false, true, id);
            } else if (messageTitleText.contains("info") || messageTitleText.contains("Info")) {
                infoCount++;
                return extractErrorMessage(driver, wait, false, false, id);
            }

            return false;
        } catch (Exception e) {
            System.out.println("Error while checking for message title: " + e.getMessage());
            return false;
        }
    }

    private static boolean extractErrorMessage(WebDriver driver, WebDriverWait wait, boolean isWarning, boolean isError, String id) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement messageContent = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-pnotify-text")));
            String messageText = messageContent.getText();

            String processId = "";
            String processCode  = "";
            try {
                WebElement targetDiv = driver.findElement(By.cssSelector("div.main-dataview-container"));
                processId = targetDiv.getAttribute("data-process-id");
                processCode = targetDiv.getAttribute("data-meta-code");
            } catch (Exception e) {
                System.out.println("Data process ID element not found: " + e.getMessage());
            }


            String fullMessage = (isError ? "ErrorMessage: " : (isWarning ? "WarningMessage: " : "InfoMessage: ")) +
                     "<br>&#8226;Process ID= " + processId + "<br>&#8226;Process CODE= " + processCode +  "<br>&#8226;Алдаа: " + messageText;

            if (isWarning) {
                warningMessages.add(fullMessage);
            } else if (isError) {
                errorMessages.add(fullMessage);
            } else {
                infoMessages.add(fullMessage);
            }

            return messageContent.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error while extracting message: " + e.getMessage());
            return false;
        }
    }

    public static int getErrorCount() {
        return errorCount;
    }

    public static int getWarningCount() {
        return warningCount;
    }

    public static int getInfoCount() {
        return infoCount;
    }

    public static void resetCounts() {
        warningCount = 0;
        errorCount = 0;
        infoCount = 0;
    }

    public static List<String> getErrorMessages() {
        return new ArrayList<>(errorMessages);
    }

    public static List<String> getWarningMessages() {
        return new ArrayList<>(warningMessages);
    }

    public static List<String> getInfoMessages() {
        return new ArrayList<>(infoMessages);
    }


}
