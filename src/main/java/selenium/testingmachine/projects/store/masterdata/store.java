package selenium.testingmachine.projects.store.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class store {

    private WebDriver driver;

    public store(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Thread.sleep(2000);

            WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-modulename='Дэлгүүрийн удирдлага']")));
            menuTileElement.click();

            Thread.sleep(3500);

            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Мастер дата')]")));
            openField.click();

            Thread.sleep(2000);
            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[name]")));
            name.sendKeys("test1");

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='priceLocationId']")));
            type.click();
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Төвийн бүс']")));
            typeOption.click();

            WebElement merchant = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[merchantId]")));
            merchant.sendKeys("11");    

            WebElement districtCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[posapiDistrictCode]")));
            districtCode.sendKeys("001");

            WebElement type1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='SM_STORE_DTL_DATAVIEW.cityId']")));
            type1.click();
            WebElement typeOption1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Улаанбаатар']")));
            typeOption1.click();

            WebElement type2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='SM_STORE_DTL_DATAVIEW.districtId']")));
            type2.click();
            WebElement typeOption2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Баянзүрх']")));
            typeOption2.click();

            WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[SM_STORE_DTL_DATAVIEW.address][0][]")));
            desc.sendKeys("testshuu");

            Thread.sleep(2000);

            WebElement coordinate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-primary mr0')]")));
            coordinate.click();
            
            Thread.sleep(2000);

            WebElement selectCoordinate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm red-sunglo')]")));
            selectCoordinate.click();

            Thread.sleep(2000);
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
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