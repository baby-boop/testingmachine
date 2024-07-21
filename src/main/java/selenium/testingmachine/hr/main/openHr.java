package selenium.testingmachine.hr.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.controller.loginController;

public class openHr {
    private WebDriver driver;

    public openHr(WebDriver driver) {
        this.driver = driver;
    }
    public void loginHr(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get(loginController.URL);
            driver.manage().window().setSize(new Dimension(1500, 800));
            WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
            userNameField.sendKeys(loginController.USERNAME);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass_word")));
            passwordField.sendKeys(loginController.PASSWORD);
            passwordField.sendKeys(Keys.ENTER);

            Thread.sleep(3000);

            String url = "https://testshuu.veritech.mn/appmenu/indexnew#16745416107063";
            driver.get(url);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.location.href = arguments[0];", url);
            driver.navigate().refresh();

            WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, 'javascript:;')])[9]")));
            menuTileElement.click();
        } catch (Exception e) {
            System.err.println("error login process: " + e.getMessage());
        } 
        
    }

}
