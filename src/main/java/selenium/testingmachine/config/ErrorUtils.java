package selenium.testingmachine.config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorUtils {

    @errorMessageField
    private static List<String> errorMessages = new ArrayList<>();

    @warningMessageField
    private static List<String> warningMessages = new ArrayList<>();

    @infoMessageField
    private static List<String> infoMessages = new ArrayList<>();

    private static int errorCount = 0;
    private static int warningCount = 0;
    private static int infoCount = 0;

    public static boolean isErrorMessagePresent(WebDriver driver, WebDriverWait wait, Class<?> callingClass) {
        try {
            WebElement messageContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme.ui-pnotify-container")));
            WebElement messageTitle = messageContainer.findElement(By.cssSelector(".ui-pnotify-title"));
            String messageTitleText = messageTitle.getText().toLowerCase();

            if (messageTitleText.contains("warning")) {
                warningCount++;
                return extractErrorMessage(driver, wait, true, false, callingClass);
            } else if (messageTitleText.contains("error")) {
                errorCount++;
                return extractErrorMessage(driver, wait, false, true, callingClass);
            } else if (messageTitleText.contains("info")) {
                infoCount++;
                return extractErrorMessage(driver, wait, false, false, callingClass);
            }

            return false; 
        } catch (Exception e) {
            System.out.println("Error while checking for message title: " + e.getMessage());
            return false;
        }
    }

    private static boolean extractErrorMessage(WebDriver driver, WebDriverWait wait, boolean isWarning, boolean isError, Class<?> callingClass) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement messageContent = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-pnotify-text")));
            String messageText = messageContent.getText();

            String processName = "";
            String moduleName = "";
            try {
                WebElement mainProcess = driver.findElement(By.cssSelector("div.mb-1.d-flex.justify-content-between > p"));
                moduleName = mainProcess.getText();

                WebElement activeItem = driver.findElement(By.cssSelector(".active > .pt1"));
                processName = activeItem.getText();
            } catch (Exception e) {
                System.out.println("Process name element not found: " + e.getMessage());
            }

            String className = callingClass.getSimpleName();
            String classUrl = callingClass.getName();

            String fullMessage = (isError ? "ErrorMessage: " : (isWarning ? "WarningMessage: " : "InfoMessage: ")) +
            "&#8226;Класс: " + className + "<br>&#8226;Класс байршил: " + classUrl + "<br>&#8226;Модуль= " + moduleName + " - " + processName + "<br>&#8226;Алдаа: " + messageText;
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
