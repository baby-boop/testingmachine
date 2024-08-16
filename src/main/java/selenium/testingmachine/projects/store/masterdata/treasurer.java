package selenium.testingmachine.projects.store.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class treasurer {

    private WebDriver driver;

    public treasurer(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17089191444929']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement treasurerNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STORE_KEEPER_NAME]")));
            treasurerNameField.sendKeys("test1");

            WebElement treasurerCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STORE_KEEPER_KEY_CODE]")));
            treasurerCodeField.sendKeys("1");

            WebElement treasurerDepartmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DEPARTMENT_ID_DESCNAME]")));
            treasurerDepartmentField.sendKeys("test1");
            treasurerDepartmentField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement treasurerWarehouseField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[WAREHOUSE_ID_DESCNAME]")));
            treasurerWarehouseField.sendKeys("test1");
            treasurerWarehouseField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement treasurerEmployeeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STORE_KEEPER_ID_DESCNAME]")));
            treasurerEmployeeField.sendKeys("Нярав 1");
            treasurerEmployeeField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement treasurerLocationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOCATION_ID_DESCNAME]")));
            treasurerLocationField.sendKeys("Хороолол");
            treasurerLocationField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement treasurerSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            treasurerSaveBtn.click();
            
            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17089191444929 .mb-1 .far")));
                closeBtn.click();
                return;
            }
            Thread.sleep(4000);

            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17089191444929 .mb-1 .far")));
            closeBtn.click();

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