package selenium.testingmachine.projects.store.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class salePrice {

    private WebDriver driver;

    public salePrice(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Худалдах үнэ')]")));
            main.click();

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='16921529583669']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement productField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".middle #itemId_nameField")));
            productField.sendKeys("test1");
            productField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement salePriceField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-path='salePrice']")));
            salePriceField.sendKeys("150000");

            WebElement salePriceHideField = driver.findElement(By.name("param[salePrice]"));
            js.executeScript("arguments[0].value='150000';", salePriceHideField);

            Thread.sleep(500);

            WebElement priceLocationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='whSalePriceKeyDv']")));
            priceLocationField.sendKeys("001");
            priceLocationField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement DescriptionField = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Худалдах үнийн дэлгэрэнгүй")));
            DescriptionField.click();

            Thread.sleep(1000);

            WebElement salePriceSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            salePriceSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                closeBtn.click();
                return;
            }

            Thread.sleep(1000);

            ClassCounter.registerWorkingClass(this.getClass());
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
  }