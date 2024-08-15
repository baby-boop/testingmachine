package selenium.testingmachine.projects.hr_time.main;

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

import selenium.testingmachine.config.ErrorUtils;

public class planLongtime {
 
    private WebDriver driver;

    public planLongtime(WebDriver driver) {
        this.driver = driver;
    }
    public void main() {
        try {
            
            Thread.sleep(500);

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Төлөвлөгөө')]")));
            main.click();

            Thread.sleep(2000);

            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='17152418102593")));
            link.click();

            Thread.sleep(2000);

            WebElement typeField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='type']")));
            typeField.click();
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Салбар нэгж']")));
            typeOption.click();

            Thread.sleep(1000);

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='startDate']")));
            startDate.sendKeys("2024-06-07");

            WebElement endDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='endDate']")));
            endDate.sendKeys("2024-06-18");

            WebElement planField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tnaTimePlanId_nameField")));
            planField.sendKeys("Оффис цаг");
            planField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement departmentField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action-path='departmentIds']")));
            departmentField.click();

            Thread.sleep(2000);

            WebElement searchDepartmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("departmentname")));
            searchDepartmentField.sendKeys("Гүйцэтгэх цех");
            searchDepartmentField.sendKeys(Keys.ENTER);
            Thread.sleep(2000);


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            if (!rows.isEmpty()) {
                Thread.sleep(500);
                WebElement firstRow = rows.get(0);
                System.out.println("first row text: " + firstRow.getText());

                Thread.sleep(1000);
        
                WebElement cell = firstRow.findElement(By.xpath(".//td[1]")); 
        
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                 actions.moveToElement(cell).doubleClick().perform();
        
                WebElement rowSelectBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn blue btn-sm datagrid-choose-btn')]")));
                rowSelectBtn.click();

            }else {
                System.out.println("No rows found.");
            }

            Thread.sleep(2000);

         
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save ')]")));
            saveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                return;
            }
            
    
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
  }