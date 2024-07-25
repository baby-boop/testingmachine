package selenium.testingmachine.store.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class location {
    public static String message;

    private WebDriver driver;

    public location(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17091129291219']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement locationCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOCATION_CODE]")));
            locationCodeField.sendKeys("1");

            WebElement locationNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOCATION_NAME]")));
            locationNameField.sendKeys("test");

            WebElement locationGroupField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOCATION_CATEGORY_ID_DESCNAME]")));
            locationGroupField.sendKeys("Төв салбар");
            locationGroupField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement locationWarehouseField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[WAREHOUSE_ID_DESCNAME]")));
            locationWarehouseField.sendKeys("test1");
            locationWarehouseField.sendKeys(Keys.ENTER);

            Thread.sleep(500);


            WebElement locationNextSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            locationNextSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17091129291219 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);

            WebElement locationTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOCATION_TYPE_ID_DESCNAME]")));
            locationTypeField.sendKeys("Салбар");
            locationTypeField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement locationNextDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-valuemap-17091129291219")));

            WebElement locationCustomerMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='190277211']")));
            locationCustomerMenu.click(); 

            Thread.sleep(2000);

            WebElement locationCustomer = wait.until(ExpectedConditions.elementToBeClickable(By.name("mvParam[CUSTOMER_ID_DESCNAME]")));
            locationCustomer.sendKeys("test1");
            locationCustomer.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement locationNextSaveBtn1 = wait.until(ExpectedConditions.elementToBeClickable(locationNextDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            locationNextSaveBtn1.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17091129291219 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);

            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17091129291219 .mb-1 .far")));
            closeBtn.click();

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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Байршил" +"<br>Алдаа: " + errorText;
                            
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
