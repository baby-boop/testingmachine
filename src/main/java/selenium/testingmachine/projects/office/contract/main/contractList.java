package selenium.testingmachine.projects.office.contract.main;

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

public class contractList {

    private WebDriver driver;

    public contractList(WebDriver driver) {
        this.driver = driver;
    }
    public void main(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17138559061971']")));
            menu.click();

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();
            
            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='CONTRACT_NAME']")));
            name.sendKeys("test1");

            WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='CONTRACT_CODE']")));
            code.sendKeys("test1");

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CONTRACT_DATE]")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].removeAttribute('readonly')", date);
            date.sendKeys("2024-07-20");

            WebElement CLASSIFICATION = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CLASSIFICATION_ID_DESCNAME]")));
            CLASSIFICATION.sendKeys("test1");
            CLASSIFICATION.sendKeys(Keys.ENTER);

            WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DESCRIPTION]")));
            desc.sendKeys("testshuu");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(1000);


            // WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Дэлгэрэнгүй')]")));
            // openField.click();

            // WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CUSTOMER_ID_DESCNAME]")));
            // customer.sendKeys("testgul");
            // customer.sendKeys(Keys.ENTER);

            // WebElement register = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DESCRIPTION]")));
            // register.sendKeys("782555");

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                
                WebElement errorCloseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                errorCloseBtn.click();

                Thread.sleep(1000);

                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17138559061971 .mb-1 .far")));
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
