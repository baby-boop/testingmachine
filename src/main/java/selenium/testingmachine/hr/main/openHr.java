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

public class openHr {
    private WebDriver driver;

    public openHr(WebDriver driver) {
        this.driver = driver;
    }
    public void loginHr(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://testshuu.veritech.mn/login");
        driver.manage().window().setSize(new Dimension(1500, 800));
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
        userNameField.sendKeys("admin");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass_word")));
        passwordField.sendKeys("89");
        passwordField.sendKeys(Keys.ENTER);

        String url = "https://testshuu.veritech.mn/appmenu/indexnew#16745416107063";
        driver.get(url);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location.href = arguments[0];", url);
        driver.navigate().refresh();

        WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, 'javascript:;')])[9]")));
        menuTileElement.click();

        
    }

}
