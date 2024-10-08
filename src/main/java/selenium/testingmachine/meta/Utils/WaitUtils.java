//package selenium.testingmachine.list.Utils;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class WaitUtils {
//    public static void waitForLoadingToDisappear(WebDriver driver, String fileName, String id) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//        try {
//            WebElement loadingMessage = driver.findElement(By.xpath("//div[contains(@class, 'datagrid-mask-msg') and text()='Түр хүлээнэ үү']"));
//            if (loadingMessage.isDisplayed()) {
//                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'datagrid-mask-msg') and text()='Түр хүлээнэ үү']")));
//            }
//        }catch (NoSuchElementException e) {
////            System.out.println("Loading message not found, proceeding with ID: " + id);
//        } catch (TimeoutException e) {
//            ErrorLogger.logError(fileName, id);
//        }
//    }
//
//    public static void waitForLoadToDisappear(WebDriver driver, String fileName, String id) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//        try {
//            WebElement loadingMessages = driver.findElement(By.cssSelector("div.loading-message.loading-message-boxed"));
//            if (loadingMessages.isDisplayed()) {
//                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loading-message.loading-message-boxed")));
//            }
//        }catch (NoSuchElementException e) {
////            System.out.println("Loading message not found, proceeding with ID: " + id);
//        } catch (TimeoutException e) {
//            ErrorLogger.logError(fileName, id);
//        }
//    }
//
//}
