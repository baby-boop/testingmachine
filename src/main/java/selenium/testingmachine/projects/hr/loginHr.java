package selenium.testingmachine.projects.hr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.controller.configController;

public class loginHr {
    private WebDriver driver;

    public loginHr(WebDriver driver) {
        this.driver = driver;
    }
    public void loginHr(){
        try{
            WebDriverWait wait = configController.getWebDriverWait(driver);
            
            driver.get(configController.URL);
            driver.manage().window().setSize(new Dimension(1500, 800));
            WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
            userNameField.sendKeys(configController.USERNAME);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass_word")));
            passwordField.sendKeys(configController.PASSWORD);
            passwordField.sendKeys(Keys.ENTER);

            Thread.sleep(3000);

            String url = "https://cloud.veritech.mn/appmenu/indexnew#16745416107063";
            driver.get(url);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.location.href = arguments[0];", url);
            driver.navigate().refresh();
            
        } catch (Exception e) {
            System.err.println("error login process: " + e.getMessage());
        } 
        
    }

}
