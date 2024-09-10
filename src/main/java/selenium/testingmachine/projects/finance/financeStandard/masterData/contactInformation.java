package selenium.testingmachine.projects.finance.financeStandard.masterData;

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

public class contactInformation {

        
    private WebDriver driver;

    public contactInformation(WebDriver driver) {
        this.driver = driver;
    }
    public void data() {
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);
            
            // WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-modulename='Санхүүгийн стандарт хувилбар']")));
            // menuTileElement.click(); 

            // Thread.sleep(3500);

            // WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Мастер дата']")));
            // main.click();

            // Thread.sleep(2000);

            // WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Харилцах")));
            // openField.click();

            // Thread.sleep(2000); //

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='16880993147459']")));
            menu.click(); 

            Thread.sleep(2000);
            
            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[BANK_ACCOUNT_DESC_L]")));
            nameField.sendKeys("test");

            WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[BANK_ACCOUNT_CODE]")));
            codeField.sendKeys("1");

            WebElement numberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[BANK_ACCOUNT_NUMBER]")));
            numberField.sendKeys("test");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16880993147459 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(2500);

            WebElement settingsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Тохиргоо']")));
            settingsMenu.click();

            Thread.sleep(2000);

            WebElement accountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ACCOUNT_ID_DESCNAME]")));
            accountField.sendKeys("Бусад хөрөнгө");
            accountField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement currencyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CURRENCY_ID_DESCNAME]")));
            currencyField.sendKeys("Төгрөг");
            currencyField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement departmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DEPARTMENT_ID_DESCNAME]")));
            departmentField.sendKeys("test");
            departmentField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement bankField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[BANK_ID_DESCNAME]")));
            bankField.sendKeys("ХААН БАНК");
            bankField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement isUseEconomicClass = driver.findElement(By.id("mvParam[IS_USE_ECONOMIC_CLASS]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", isUseEconomicClass);

            Thread.sleep(500);

            WebElement isUseCashFlow = driver.findElement(By.id("mvParam[IS_USE_CASH_FLOW]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", isUseCashFlow);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16880993147459 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(3500);

            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16880993147459 .mb-1 .far")));
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
