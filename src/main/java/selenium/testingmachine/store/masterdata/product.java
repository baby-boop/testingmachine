package selenium.testingmachine.store.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class product {
    public static String message;

    private WebDriver driver;

    public product(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='16911711539839']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ITEM_NAME]")));
            name.sendKeys("test1");

            // WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ITEM_CODE]")));
            // code.sendKeys("4");

            WebElement group = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[ITEM_CATEGORY_ID]_nameField")));
            group.sendKeys("test1");
            group.sendKeys(Keys.ENTER);

            WebElement measure = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='UNIT_MEASURE_ID']")));
            measure.click();
            Thread.sleep(500);
            WebElement measureOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='метр']")));
            measureOption.click();

            Thread.sleep(1000);

            WebElement barcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[BARCODE]")));
            barcode.sendKeys("4");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();
            Thread.sleep(1000);

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16911711539839 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);
            
            WebElement measureBlockField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='L1_MEASURE_ID']")));
            measureBlockField.click();
            Thread.sleep(500);
            WebElement measureBlockOptionField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='метр']")));
            measureBlockOptionField.click();

            WebElement measureBoxField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='L2_MEASURE_ID']")));
            measureBoxField.click();
            Thread.sleep(500);
            WebElement measureBoxOptionField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='метр']")));
            measureBoxOptionField.click();

            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement blockNumberField = driver.findElement(By.name("mvParam[L1_QTY]"));
            js.executeScript("arguments[0].value='10';", blockNumberField);

            WebElement boxNumberField = driver.findElement(By.name("mvParam[L2_QTY]"));
            js.executeScript("arguments[0].value='15';", boxNumberField);

            WebElement productMainId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-valuemap-16911711539839")));

            WebElement productNextSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(productMainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            productNextSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16911711539839 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);

            WebElement barcodeMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='187723396']")));
            barcodeMenu.click(); 
            
            Thread.sleep(2000);

            WebElement barcodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[L0_BARCODE]")));
            barcodeField.sendKeys("1");

            WebElement blockBarcodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[L1_BARCODE]")));
            blockBarcodeField.sendKeys("1");

            WebElement boxBarcodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[L2_BARCODE]")));
            boxBarcodeField.sendKeys("1");     
            
            WebElement barcodeSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(productMainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            barcodeSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16911711539839 .mb-1 .far")));
                closeBtn.click();
                return;
            }
            Thread.sleep(4000);

            WebElement generalMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='187744620']")));
            generalMenu.click(); 
            
            Thread.sleep(2000);

            WebElement shortNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[SHORT_NAME]")));
            shortNameField.sendKeys("test");

            WebElement foreignNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[FOREIGN_NAME]")));
            foreignNameField.sendKeys("1");

            WebElement oldCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[OLD_ITEM_CODE]")));
            oldCodeField.sendKeys("1");     
            
            WebElement generalSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(productMainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            generalSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16911711539839 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);

            WebElement equivalentMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='187744620']")));
            equivalentMenu.click(); 
            
            Thread.sleep(2000);

            WebElement equivalentField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='EQUIVALENT_MEASURE_ID']")));
            equivalentField.click();
            Thread.sleep(500);
            WebElement equivalentOptionField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='метр']")));
            equivalentOptionField.click();

            WebElement equivalentCoefField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[EQUIVALENT_COEF]")));
            equivalentCoefField.sendKeys("3");

            WebElement equivalentProductField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[EQUIVALENT_ITEM_ID_DESCNAME]")));
            equivalentProductField.sendKeys("test1");
            equivalentProductField.sendKeys(Keys.ENTER);
            Thread.sleep(500);

            WebElement equivalentSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(productMainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            equivalentSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16911711539839 .mb-1 .far")));
                closeBtn.click();
                return;
            }
            Thread.sleep(4000);

            WebElement priceMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='187744759']")));
            priceMenu.click(); 
            
            Thread.sleep(2000);

            WebElement unitCostField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[UNIT_COST]")));
            unitCostField.sendKeys("150000");

            WebElement purchasePriceField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[PURCHASE_PRICE]")));
            purchasePriceField.sendKeys("1500000");

            WebElement salePriceField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[SALE_PRICE]")));
            salePriceField.sendKeys("15000");

            WebElement priceSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(productMainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            priceSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16911711539839 .mb-1 .far")));
                closeBtn.click();
                return;
            }
            Thread.sleep(4000);

            WebElement warehouseMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='187744759']")));
            warehouseMenu.click(); 
            
            Thread.sleep(2000);

            WebElement lengthField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LENGTH]")));
            lengthField.sendKeys("150");

            WebElement widthField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[WIDTH]")));
            widthField.sendKeys("15");

            WebElement heightField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[HEIGHT]")));
            heightField.sendKeys("150");

            WebElement tempratureField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[TEMPERATURE]")));
            tempratureField.sendKeys("10");

            WebElement wetnessPercentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[HEIGHT]")));
            wetnessPercentField.sendKeys("10");

            WebElement volumeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[VOLUME]")));
            volumeField.sendKeys("150");

            WebElement stogareMonthField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STORAGE_MONTH]")));
            stogareMonthField.sendKeys("150");

            WebElement reorderQtyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[REORDER_QTY]")));
            reorderQtyField.sendKeys("9");

            WebElement minQtyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[MIN_QTY]")));
            minQtyField.sendKeys("2");

            WebElement maxQtyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[MAX_QTY]")));
            maxQtyField.sendKeys("19");

            WebElement warehouseSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(productMainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            warehouseSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16911711539839 .mb-1 .far")));
                closeBtn.click();
                return;
            }
            Thread.sleep(4000);

            
            WebElement additionalMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='187744843']")));
            additionalMenu.click(); 
            
            Thread.sleep(2000);

            WebElement isManufactureDateField = driver.findElement(By.id("mvParam[IS_KEY_MANUFACTURE_DATE]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", isManufactureDateField);

            WebElement isNeedBestBeforeModeField = driver.findElement(By.id("mvParam[IS_NEED_BEST_BEFORE_MODE]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", isNeedBestBeforeModeField);

            WebElement isUseSerialField = driver.findElement(By.id("mvParam[IS_USE_SERIAL]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", isUseSerialField);

            WebElement isDepreciationField = driver.findElement(By.id("mvParam[IS_DEPRECIATION]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", isDepreciationField);

            WebElement isUseItemField = driver.findElement(By.id("mvParam[IS_SUL_ITEM]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", isUseItemField);

            WebElement isKeyCostField = driver.findElement(By.id("mvParam[IS_KEY_COST]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", isKeyCostField);

            WebElement lotItemQtyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LOT_ITEM_QTY]")));
            lotItemQtyField.sendKeys("6");

            WebElement usageYearField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[USAGE_YEAR]")));
            usageYearField.sendKeys("15");

            WebElement additionalSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(productMainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            additionalSaveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16911711539839 .mb-1 .far")));
                closeBtn.click();
                return;
            }
            Thread.sleep(4000);

            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16911711539839 .mb-1 .far")));
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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Бараа" +"<br>Алдаа: " + errorText;
                            
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
