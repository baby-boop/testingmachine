package selenium.testingmachine.store.main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createOrderFromStore {
    public static String message;

    private WebDriver driver;
    
    public createOrderFromStore(WebDriver driver) {
        this.driver = driver;
    }
    public void main(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            
            Thread.sleep(2000);

            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Бүртгэл')]")));
            openField.click();

            Thread.sleep(2000);

            WebElement supplierField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("supplierId_nameField")));
            supplierField.sendKeys("test1");
            supplierField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[description]")));
            descriptionField.sendKeys("10022");

            WebElement selectBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-xs green-meadow')]")));
            selectBtn.click();

            Thread.sleep(2000);

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

            Thread.sleep(1000);

            WebElement dtlQtyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDtl.qty']")));
            dtlQtyField.sendKeys("140000");

            WebElement dtlUnitPriceField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDtl.unitPrice']")));
            dtlUnitPriceField.sendKeys("22");

            WebElement dtlDescriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDtl.description']")));
            dtlDescriptionField.sendKeys("testshuu");

            WebElement dueDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDtl.dueDate']")));
            dueDateField.sendKeys("2024-09-11");

            WebElement nextDtl = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Хөнгөлөлт & НӨАТ")));
            nextDtl.click();

            Thread.sleep(2000);

            WebElement dtlDiscoundPercentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='discountPercent']")));
            dtlDiscoundPercentField.sendKeys("20");

            WebElement dtlOtherCostField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='otherCost']")));
            dtlOtherCostField.sendKeys("5000");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save ')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                return;
            }

            Thread.sleep(2000);


        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            WebElement errorTitle = driver.findElement(By.cssSelector(".ui-pnotify-title"));
            String errorTitleText = errorTitle.getText();
            if (errorTitleText.contains("warning") || errorTitleText.contains("error")) {
                try {
                    wait.withTimeout(Duration.ofSeconds(2));
                    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-pnotify-text")));
                    String errorText = errorMessage.getText();
                    
                    String processName = "";
                    try {
                        WebElement mainProcess = driver.findElement(By.cssSelector("div.mb-1.d-flex.justify-content-between > p"));
                        processName = mainProcess.getText();
                    } catch (Exception e) {
                        System.out.println("Process name element not found: " + this.getClass().getName() + e.getMessage());
                    }
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Захиалга бүртгэх" +"<br>Алдаа: " + errorText;
                            
                    return errorMessage.isDisplayed();
                } catch (Exception e) {
                    System.out.println("Error while checking for error message: " + e.getMessage());
                    return false;
                } finally {
                    wait.withTimeout(Duration.ofSeconds(30));
                }
            }else{
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Error while checking for error title: " + e.getMessage());
            return false;
        }
    }
}


