package selenium.testingmachine.projects.warehouse.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ErrorUtils;


public class productMaterialWarehouse {


    private WebDriver driver;

    public productMaterialWarehouse(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            Thread.sleep(2000);
            
            WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-modulename='Агуулахын удирдлага']")));
            menuTileElement.click();

            Thread.sleep(3500);

            WebElement mains= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Мастер дата']")));
            mains.click();

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Барааны бүртгэл")));
            main.click(); 

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17089190284399']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ITEM_CODE]")));
            codeField.sendKeys("1");

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ITEM_NAME]")));
            nameField.sendKeys("test");

            WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DESCRIPTION]")));
            descriptionField.sendKeys("testshuu");

            WebElement measureField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[UNIT_MEASURE_ID_DESCNAME]")));
            measureField.sendKeys("метр");
            measureField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement mainSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            mainSaveBtn.click();
            
            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17089190284399 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(3500);

            WebElement nextPageMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Ерөнхий')]")));
            nextPageMenu.click();

            Thread.sleep(2000);

            WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='190257795']")));
            subMenu.click(); 

            Thread.sleep(2000);

            WebElement lengthField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='LENGTH']")));
            lengthField.sendKeys("230");

            WebElement widthField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='WIDTH']")));
            widthField.sendKeys("310");

            WebElement heightField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HEIGHT']")));
            heightField.sendKeys("150");

            WebElement weightField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='WEIGHT']")));
            weightField.sendKeys("120000");

            WebElement volumeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='VOLUME']")));
            volumeField.sendKeys("15");

            WebElement dialogDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-valuemap-17089190284399")));
            WebElement nextSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(dialogDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));            
            nextSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                return;
            }

            Thread.sleep(3500);

            WebElement productMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='190934143']")));
            productMenu.click(); 

            Thread.sleep(2000);

            WebElement productCategoryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ITEM_CATEGORY_ID_DESCNAME]")));
            productCategoryField.sendKeys("test1");
            productCategoryField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement productTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ITEM_TYPE_ID_DESCNAME]")));
            productTypeField.sendKeys("Эрэлттгүй бараа үйлчилгээ");
            productTypeField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement productBrandField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[BRAND_ID_DESCNAME]")));
            productBrandField.sendKeys("метр");
            productBrandField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement productSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(dialogDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));            
            productSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                return;
            }

            Thread.sleep(3500);

            WebElement resourceMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='190360543']")));
            resourceMenu.click(); 

            Thread.sleep(2000);

            WebElement maxQtyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='MAX_QTY']")));
            maxQtyField.sendKeys("200");

            WebElement minQtyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='MIN_QTY']")));
            minQtyField.sendKeys("2");

            WebElement temperatureField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='TEMPERATURE']")));
            temperatureField.sendKeys("15");

            WebElement storageDayField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STORAGE_DAY]")));
            storageDayField.sendKeys("7");


            Thread.sleep(1000);

            WebElement resourceSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(dialogDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));            
            resourceSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                return;
            }

            Thread.sleep(3500);

            WebElement mainMeasure = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Хэмжигдэхүүн тохиргоо")));
            mainMeasure.click(); 

            Thread.sleep(2000);

            WebElement equivalentMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='190161767']")));
            equivalentMenu.click(); 

            Thread.sleep(2000);

            WebElement equivalentMeasureField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[EQUIVALENT_MEASURE_ID_DESCNAME]")));
            equivalentMeasureField.sendKeys("метр");
            equivalentMeasureField.sendKeys(Keys.ENTER);

            Thread.sleep(500);
            
            WebElement equivalentQtyField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='EQUIVALENT_COEF']")));
            equivalentQtyField.sendKeys("15");

            Thread.sleep(1000);

            WebElement equivalentSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(dialogDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));            
            equivalentSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                return;
            }

            Thread.sleep(3500);


            WebElement measureMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='190161392']")));
            measureMenu.click(); 

            Thread.sleep(2000);

            WebElement submeasureField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[L2_MEASURE_ID_DESCNAME]")));
            submeasureField.sendKeys("метр");
            submeasureField.sendKeys(Keys.ENTER);

            Thread.sleep(500);
            
            WebElement qtyInBoxField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[L2_QTY]")));
            qtyInBoxField.sendKeys("15");

            Thread.sleep(1000);

            WebElement measureSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(dialogDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));            
            measureSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                return;
            }

            Thread.sleep(3500);

            WebElement salesSetupMeasure = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Борлуулах тохиргоо")));
            salesSetupMeasure.click(); 

            Thread.sleep(2000);

            WebElement salesProductMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='190313684']")));
            salesProductMenu.click(); 

            Thread.sleep(2000);

            WebElement salesProductSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(dialogDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));            
            salesProductSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                return;
            }
            Thread.sleep(3500);

            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17089190284399 .mb-1 .far")));
            closeBtn.click();
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
}
