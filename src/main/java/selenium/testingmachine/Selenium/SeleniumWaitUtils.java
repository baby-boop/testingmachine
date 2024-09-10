package selenium.testingmachine.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaitUtils {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SeleniumWaitUtils(WebDriver driver, int timeout, int pollingInterval) {
        this.driver = driver;
        this.wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingInterval));
    }

    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement elementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForUrlToBe(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }
}