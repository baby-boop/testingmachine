package selenium.testingmachine.store.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class warehouse {
    public static String message;

    private WebDriver driver;
    
    public warehouse(WebDriver driver) {
        this.driver = driver;
    }
   
    public void data() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Агуулах')]")));
            main.click();

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='16883444299539']")));
            menu.click();

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[WAREHOUSE_NAME]")));
            nameField.sendKeys("test1");

            WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[WAREHOUSE_CODE]")));
            codeField.sendKeys("1");

            WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DESCRIPTION]")));
            descriptionField.sendKeys("testshuu");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16883444299539 .mb-1 .far")));
                closeBtn.click();
                return;
            }
            Thread.sleep(3500);

            WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CITY_ID_DESCNAME]")));
            cityField.sendKeys("Улаанбаатар");
            cityField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement districtField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DISTRICT_ID_DESCNAME]")));
            districtField.sendKeys("Баянзүрх");
            districtField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement streetField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CITY_STREET_ID_DESCNAME]")));
            streetField.sendKeys("1-р баг, Ахар");
            streetField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ADDRESS]")));
            addressField.sendKeys("1-р баг, Ахар");

            Thread.sleep(500);

            WebElement dialogDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-valuemap-16883444299539")));
            WebElement nextSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(dialogDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));            
            nextSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16883444299539 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);

            WebElement basicSettingsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Үндсэн тохиргоо')]")));
            basicSettingsMenu.click();

            Thread.sleep(2000);

            WebElement warehouseStandardMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='190145527']")));
            warehouseStandardMenu.click(); 

            Thread.sleep(2000);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement temperatureField = driver.findElement(By.name("mvParam[TEMPERATURE]"));
            js.executeScript("arguments[0].value='21';", temperatureField);

            WebElement airField = driver.findElement(By.name("mvParam[AIR_HUMIDITY]"));
            js.executeScript("arguments[0].value='1';", airField);

            WebElement cleaningField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CLEANING_STATUS]")));
            cleaningField.sendKeys("test");

            WebElement addressField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ADDRESS_STATUS]")));
            addressField2.sendKeys("testshuu");

            WebElement standardSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(dialogDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));   
            standardSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16883444299539 .mb-1 .far")));
                closeBtn.click();
                return;
            }
            Thread.sleep(4000);

            WebElement warehouseTreasurerMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17085011454719']")));
            warehouseTreasurerMenu.click(); 

            Thread.sleep(2000);


            WebElement treasurerAddBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-crud-indicatorid='190194380']")));            
            treasurerAddBtn.click();

            Thread.sleep(2000);

            WebElement treasurerNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STORE_KEEPER_NAME]")));
            treasurerNameField.sendKeys("test1");

            WebElement treasurerCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STORE_KEEPER_KEY_CODE]")));
            treasurerCodeField.sendKeys("1");

            WebElement treasurerDepartmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DEPARTMENT_ID_DESCNAME]")));
            treasurerDepartmentField.sendKeys("test1");
            treasurerDepartmentField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement treasurerEmployeeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STORE_KEEPER_ID_DESCNAME]")));
            treasurerEmployeeField.sendKeys("Нярав 1");
            treasurerEmployeeField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement treasurerLocationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOCATION_ID_DESCNAME]")));
            treasurerLocationField.sendKeys("Хороолол");
            treasurerLocationField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement treasurerNextDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-valuemap-17085011454719")));

            WebElement treasurerSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(treasurerNextDiv.findElement(By.xpath(".//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]"))));
            treasurerSaveBtn.click();
            
            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17085011454719 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);

            WebElement treasurerCloseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17085011454719 .mb-1 .far")));
            treasurerCloseBtn.click();

            Thread.sleep(2000);

            //Байршил

            WebElement locationMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Байршил')]")));
            locationMenu.click();

            Thread.sleep(2000);

            WebElement locationAddBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-crud-indicatorid='183921196']")));           
            locationAddBtn.click();

            Thread.sleep(2000);

            WebElement locationCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOCATION_CODE]")));
            locationCodeField.sendKeys("1");

            WebElement locationNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOCATION_NAME]")));
            locationNameField.sendKeys("test");

            WebElement locationGroupField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOCATION_CATEGORY_ID_DESCNAME]")));
            locationGroupField.sendKeys("Төв салбар");
            locationGroupField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            // WebElement locationDescriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DESCRIPTION]")));
            // locationDescriptionField.sendKeys("testshuu");

            WebElement locationNextDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-valuemap-16883450158879")));

            WebElement locationSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(locationNextDiv.findElement(By.xpath(".//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]"))));
            locationSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16883450158879 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);
            

            WebElement locationTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOCATION_TYPE_ID_DESCNAME]")));
            locationTypeField.sendKeys("Салбар");
            locationTypeField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement locationNextSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(locationNextDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));
            locationNextSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16883450158879 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(2000);

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
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16883450158879 .mb-1 .far")));
                closeBtn.click();
                return;
            }
            Thread.sleep(4000);

            WebElement locationCloseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16883450158879 .mb-1 .far")));
            locationCloseBtn.click();

            Thread.sleep(3000);

            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16883444299539 .mb-1 .far")));
            closeBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        } finally {
            System.out.println("finished: " +   this.getClass().getSimpleName());
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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Агуулах" +"<br>Алдаа: " + errorText;
                            
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
