package selenium.testingmachine.config;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

    // Хуудас шилжихийг хүлээх
    public static void waitForPageToLoad(WebDriver driver, String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(expectedUrl)); // URL-ийн хэсэг байхыг хүлээж байна
    }

    // Тухайн элементийг бүрэн ачаалагдсан эсэхийг шалгах функц
    public static WebElement waitForElementToBeFullyLoaded(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    // Хуудас ачаалж дууссан эсэхийг шалгах
    public static void waitForPageLoadComplete(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(drv -> {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) drv;
            String readyState = (String) jsExecutor.executeScript("return document.readyState");
            return "complete".equals(readyState);
        });
    }
}
