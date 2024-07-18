package selenium.testingmachine.supply;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class supplyLogin {
    private WebDriver driver;

    public supplyLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void login(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://cloud.veritech.mn/login");
            driver.manage().window().setSize(new Dimension(1500, 800));
            
            WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
            userNameField.sendKeys("testshuu@gmail.com");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass_word")));
            passwordField.sendKeys("VrCloud@123");
            passwordField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            String url = "https://cloud.veritech.mn/appmenu/indexnew#16745403871623";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.location.href = arguments[0];", url);
            driver.navigate().refresh();
            
        } catch (Exception e) {
            System.out.println("login: " + e.getMessage());
        }
    }
}
