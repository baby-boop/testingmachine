package selenium.testingmachine.projects.hr.employee_directory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class addressType {

    private WebDriver driver;

    public addressType(WebDriver driver) {
        this.driver = driver;
    }
    public void types(){
        try{

            WebDriverWait wait = configController.getWebDriverWait(driver);

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-stepid='16643583041609']"))); //Хаягийн төрөл
            menu.click(); 

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ADDRESS_TYPE_NAME]")));
            type.sendKeys("test2");

            WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            saveBtn.click();

            Thread.sleep(1000);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");

                Thread.sleep(2000);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn btn-sm blue-hoki bp-btn-close')]")));
                cnclBtn.click();

                Thread.sleep(1000);
                return;
            }

            Thread.sleep(3000);
            
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            // List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            // if (!rows.isEmpty()) {
            //     Thread.sleep(500);
            //     WebElement lastRow = rows.get(rows.size() - 1);
            //     Actions actions = new Actions(driver);
            //     System.out.println("Last row text: " + lastRow.getText());

            //     Thread.sleep(1000);
        
            //     WebElement cell = lastRow.findElement(By.xpath(".//td[1]")); 
        
            //     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
            //      actions.moveToElement(cell).click().perform();
        
            //     WebElement rowSelectBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
            //     rowSelectBtn.click();
            // }else {
            //     System.out.println("No rows found.");
            // }

            // Thread.sleep(2000);

            // WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[GLOBE_CODE]")));
            // JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript("arguments[0].removeAttribute('readonly')", name);
            // name.sendKeys("test1");

            // Thread.sleep(1000);

            // WebElement editSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            // editSave.click();

            // Thread.sleep(1000);

            // if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
            //     System.out.println("Error message found after saving. Exiting...");

            //     Thread.sleep(2000);
                
            //     WebElement cnclBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn btn-sm blue-hoki bp-btn-close')]")));
            //     cnclBtn.click();

            //     Thread.sleep(1000);
            //     return;
            // }

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
