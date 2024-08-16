package selenium.testingmachine.projects.supply.main;

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
public class createOrder {

    private WebDriver driver;
    private Actions actions;

    public createOrder(WebDriver driver) {
        this.driver = driver;
    }
    public void main(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(2000);


            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Бүртгэл')]")));
            openField.click();

            Thread.sleep(2000);

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("supplierId_nameField")));
            nameField.sendKeys("test1");
            nameField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement selectBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-xs green-meadow')]")));
            selectBtn.click();
            
            Thread.sleep(2500);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            if (!rows.isEmpty()) {
                Thread.sleep(500);
                WebElement lastRow = rows.get(rows.size() - 1);
                Actions actions = new Actions(driver);
                System.out.println("Last row text: " + lastRow.getText());

                Thread.sleep(1000);
        
                WebElement cell = lastRow.findElement(By.xpath(".//td[1]")); 
        
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                 actions.moveToElement(cell).doubleClick().perform();
        
                WebElement rowSelectBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn blue btn-sm datagrid-choose-btn')]")));
                
                rowSelectBtn.click();
            }else {
                System.out.println("No rows found.");
            }

            Thread.sleep(2000);

            WebElement dtlQtyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDtl.qty']")));
            dtlQtyField.sendKeys("140000");

            WebElement dtlUnitPriceField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDtl.unitPrice']")));
            dtlUnitPriceField.sendKeys("22");

            WebElement dtlDescriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[data-path='bookDtl.description']")));
            dtlDescriptionField.sendKeys("testshuu");

            WebElement dueDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDtl.dueDate']")));
            dueDateField.sendKeys("2024-09-11");

            Thread.sleep(1000);

            WebElement nextDtl = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Хөнгөлөлт & НӨАТ")));
            nextDtl.click();

            Thread.sleep(2000);

            WebElement dtlDiscoundPercentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='discountPercent']")));
            dtlDiscoundPercentField.sendKeys("20");

            WebElement dtlOtherCostField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='otherCost']")));
            dtlOtherCostField.sendKeys("5000");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save ')]")));
            saveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
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
