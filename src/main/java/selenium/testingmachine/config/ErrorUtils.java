package selenium.testingmachine.config;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorUtils {

    @errorMessageField
    public static String ErrorMessage;

    @warningMessageField
    public static String WarningMessage;

    public static int errorCount = 0;
    public static int warningCount = 0;


    public static boolean isErrorMessagePresent(WebDriver driver, WebDriverWait wait, Class<?> callingClass) {
        try {
            WebElement messageContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme.ui-pnotify-container")));
            WebElement messageTitle = messageContainer.findElement(By.cssSelector(".ui-pnotify-title"));
            String messageTitleText = messageTitle.getText().toLowerCase();

            if (messageTitleText.contains("warning") || messageTitleText.contains("Warning")) {
                warningCount++;
                return extractErrorMessage(driver, wait, true, callingClass);  
                
            } else if (messageTitleText.contains("error") || messageTitleText.contains("Error")) {
                errorCount++;
                return extractErrorMessage(driver, wait, false, callingClass);  
            }

            return false; 
        } catch (Exception e) {
            System.out.println("Error while checking for message title: " + e.getMessage());
            return false;
        }
    }

    private static boolean extractErrorMessage(WebDriver driver, WebDriverWait wait, boolean isWarning, Class<?> callingClass) {
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

            if (isWarning) {
                WarningMessage = "&#8226;Класс: " + className + "<br>&#8226;Класс байршил: " + classUrl + "<br>&#8226;Модуль= " + moduleName + " - " + processName + "<br>&#8226;Алдаа: " + messageText;
            } else {
                ErrorMessage = "&#8226;Класс: " + className + "<br>&#8226;Класс байршил: " + classUrl + "<br>&#8226;Модуль= " + moduleName + " - " + processName + "<br>&#8226;Алдаа: " + messageText;
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

    public static void resetCounts(){
        warningCount = 0;
        errorCount = 0;
    }

}
