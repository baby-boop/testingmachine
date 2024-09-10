package selenium.testingmachine.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.testingmachine.controller.configController;

public class SeleniumLogin {

    private final WebDriver driver;
    private final SeleniumWaitUtils waitUtils;

    public SeleniumLogin(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new SeleniumWaitUtils(driver, 30, 1);
    }

    public void login() {
        try {
            driver.get(configController.URL);
            driver.manage().window().setSize(new Dimension(1500, 800));

            WebElement userNameField = waitUtils.waitForElement(By.id("user_name"));
            userNameField.sendKeys(configController.USERNAME);

            WebElement passwordField = waitUtils.waitForElement(By.name("pass_word"));
            passwordField.sendKeys(configController.PASSWORD);
            passwordField.sendKeys(Keys.ENTER);

            waitUtils.waitForUrlToBe("https://cloud.veritech.mn/appmenu/indexnew");

            String url = "https://cloud.veritech.mn/appmenu/indexnew#16745416107063";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.location.href = arguments[0];", url);
            driver.navigate().refresh();

        } catch (Exception e) {
            System.err.println("Error in login process: " + e.getMessage());
        }
    }
}
