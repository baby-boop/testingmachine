package selenium.testingmachine.projects.finance.financeStandard.masterData;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class standardCashier {

    private WebDriver driver;

    public standardCashier(WebDriver driver) {
        this.driver = driver;
    }
    public void data() {
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement menu =  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Касс")));
            menu.click(); 

            Thread.sleep(2000);

            WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='16880991772429']")));
            subMenu.click(); 

            Thread.sleep(2000);
            
            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CASH_NYRAV_NAME]")));
            name.sendKeys("test");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16880991772429 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(2500);

            WebElement highAmountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HIGH_AMOUNT']")));
            highAmountField.sendKeys("18000000");

            WebElement lowAmountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='LOW_AMOUNT']")));
            lowAmountField.sendKeys("210000");

            WebElement amountSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            amountSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                return;
            }

            Thread.sleep(3500);

            WebElement amountMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='189812817']")));
            amountMenu.click(); 

            Thread.sleep(2000);

            WebElement cashAccountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ACCOUNT_ID_DESCNAME]")));
            cashAccountField.sendKeys("Жижиг мөнгөн сан");
            cashAccountField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement currencyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CURRENCY_ID_DESCNAME]")));
            currencyField.sendKeys("Төгрөг");
            currencyField.sendKeys(Keys.ENTER);

            Thread.sleep(500);


            WebElement depertmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DEPARTMENT_ID_DESCNAME]")));
            depertmentField.sendKeys("test");
            depertmentField.sendKeys(Keys.ENTER);

            Thread.sleep(500);


            WebElement employeeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[EMPLOYEE_ID_DESCNAME]")));
            employeeField.sendKeys("test");
            employeeField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement accountSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            accountSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                return;
            }

            Thread.sleep(3500);


            WebElement hrMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='196205985']")));
            hrMenu.click(); 

            Thread.sleep(2000);


            // WebElement depertmentField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DEPARTMENT_ID_DESCNAME]")));
            // depertmentField1.sendKeys("test");
            // depertmentField1.sendKeys(Keys.ENTER);

            // Thread.sleep(500); хадгалсан өгөгдөл үлдсэн


            // WebElement employeeField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[EMPLOYEE_ID_DESCNAME]")));
            // employeeField1.sendKeys("test");
            // employeeField1.sendKeys(Keys.ENTER);

            // Thread.sleep(1000);

            WebElement hrSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            hrSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16880991772429 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(3500);

            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16880991772429 .mb-1 .far")));
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
