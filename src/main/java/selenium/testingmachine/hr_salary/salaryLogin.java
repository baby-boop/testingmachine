package selenium.testingmachine.hr_salary;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.controller.loginController;

public class salaryLogin {
    private WebDriver driver;

    public salaryLogin(WebDriver driver) {
        this.driver = driver;
    }
    public void login(){
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

            
            String url = "https://testshuu.veritech.mn/appmenu/mvmodule/16745414747543";
            driver.get(url);

            
        } catch (Exception e) {
            System.err.println("error login process: " + e.getMessage());
        } 
        
    }

}

