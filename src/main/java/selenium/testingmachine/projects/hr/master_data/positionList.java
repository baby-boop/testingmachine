package selenium.testingmachine.projects.hr.master_data;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class positionList {

    private WebDriver driver;

    public positionList(WebDriver driver) {
        this.driver = driver;
    }
    public void position(){
        try{

            WebDriverWait wait = configController.getWebDriverWait(driver);
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-stepid='17149692930273']"))); //Албан тушаал
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='positionName'] input[name='param[positionName]']")));
            name.sendKeys("test1");

            WebElement level = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='profLevelId']")));
            level.click();
            WebElement leveloption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='Ажилтан']")));
            leveloption.click();

            Thread.sleep(500);

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='classificationId']")));
            type.click();
            WebElement typeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='Ажилтан']")));
            typeOption.click();

            Thread.sleep(500);

            WebElement levelParent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vocationGroupId_nameField")));
            levelParent.sendKeys("Программ зохиогч");
            levelParent.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement salaryType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='salaryTypeId'] div[data-s-path='salaryTypeId']")));
            salaryType.click();
            WebElement salaryTypeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='Өдрөөр']")));
            salaryTypeOption.click();

            Thread.sleep(500);

            WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(1000);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                
                Thread.sleep(2000);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn blue-madison btn-sm bp-close-btn bp-btn-close')]")));
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

            // WebElement addName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='positionName'] input[name='param[positionName]']")));
            // addName.sendKeys(" нэрийг солив");
            // Thread.sleep(2000);

            // WebElement editSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn bp-btn-save  ')]")));
            // editSave.click();

            // Thread.sleep(1000);

            // if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
            //     System.out.println("Error message found after saving. Exiting...");
                
            //     Thread.sleep(2000);
                
            //     WebElement cnclBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn blue-madison btn-sm bp-close-btn bp-btn-close')]")));
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