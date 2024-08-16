package selenium.testingmachine.projects.office.contract.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class registrationOfContracts {

    private WebDriver driver;

    public registrationOfContracts(WebDriver driver) {
        this.driver = driver;
    }
    public void main(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(2000);

            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Бүртгэл')]")));
            openField.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='CONTRACT_NAME']")));
            name.sendKeys("test1");

            WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='CONTRACT_CODE']")));
            code.sendKeys("test1");

            WebElement CLASSIFICATION = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CLASSIFICATION_ID_DESCNAME]")));
            CLASSIFICATION.sendKeys("test1");
            CLASSIFICATION.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CUSTOMER_ID_DESCNAME]")));
            customer.sendKeys("testgul");
            customer.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DESCRIPTION]")));
            desc.sendKeys("testshuu");

            Thread.sleep(1000);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(1000);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");

                Thread.sleep(2500);
                
                // WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                // cnclBtn.click();
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