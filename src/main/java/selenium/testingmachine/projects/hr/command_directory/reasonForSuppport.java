package selenium.testingmachine.projects.hr.command_directory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class reasonForSuppport {

    private WebDriver driver;

    public reasonForSuppport(WebDriver driver) {
        this.driver = driver;
    }
    public void reason(){
        try{

            WebDriverWait wait = configController.getWebDriverWait(driver);

            Thread.sleep(2000);
            
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='16746270876894"))); //Тусламж, дэмжлэг
            menu.click();

            Thread.sleep(2000);
            
            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[SUPPORT_TYPE_ID]")));
            name.sendKeys("112211");

            WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[SUPPORT_TYPE_NAME]")));
            code.sendKeys("test1");

            WebElement subCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[SUPPORT_SUB_TYPE_NAME]")));
            subCode.sendKeys("test2");

            WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[AMOUNT]")));
            amount.sendKeys("190000");

            WebElement isLeave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[IS_LEAVE]")));
            isLeave.sendKeys("1");

            WebElement leaveDay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LEAVE_DAY]")));
            leaveDay.sendKeys("test2");

            WebElement fullname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[EMPLOYEE_FULL_NAME]")));
            fullname.sendKeys("Дорж сумлай");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            saveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm blue-hoki bp-btn-close')]")));
                closeBtn.click();

                return;
            }

            Thread.sleep(2000);

            ClassCounter.registerWorkingClass(this.getClass());
            
            // if (isErrorMessagePresent(wait)) {
            //     System.out.println("Error message found after saving. Exiting...");
            //     Thread.sleep(3500);
                
            //     WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
            //     cnclBtn.click();
            //     return;
            // }
            
            
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            // List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            // if (!rows.isEmpty()) {
            //     WebElement firstRow = rows.get(0);
            //     firstRow.click();

            //     WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
            //     edit.click();

            // } else {
            //     System.out.println("No rows found.");
            // }

            // Thread.sleep(1000);

            // WebElement editSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            // editSave.click();

            // if (isErrorMessagePresent(wait)) {
            //     System.out.println("Error message found after saving. Exiting...");
            //     Thread.sleep(3500);
                
            //     WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
            //     cnclBtn.click();
            //     return;
            // }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
}
