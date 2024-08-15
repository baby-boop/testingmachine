package selenium.testingmachine.projects.finance.financeStandard.masterData;

import java.time.Duration;

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

public class standardDepartment {

    private WebDriver driver;

    public standardDepartment(WebDriver driver) {
        this.driver = driver;
    }
    public void data() {
        try {
 
            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);
            
            WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-modulename='Санхүүгийн стандарт хувилбар']")));
            menuTileElement.click();

            Thread.sleep(3500);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Мастер дата']")));
            main.click();

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='departmentCode'] input[data-path='departmentCode']")));
            codeField.sendKeys("1");

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[departmentName]")));
            nameField.sendKeys("test");

            WebElement engNameField  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[departmentNameEn]")));
            engNameField.sendKeys("test");

            WebElement registerField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[registerNumber]")));
            registerField.sendKeys("1");

            WebElement classificationField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='classificationId']")));
            classificationField.click();
            WebElement classificationOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Захиргаа']")));
            classificationOption.click();

            Thread.sleep(500);

            WebElement typeField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='typeId']")));
            typeField.click();
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Групп']")));
            typeOption.click();

            Thread.sleep(500);

            WebElement segmentField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='segmentId']")));
            segmentField.click();
            WebElement segmentOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Даатгал']")));
            segmentOption.click();

            Thread.sleep(500);

            WebElement directorField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("directorEmployeeId_nameField")));
            directorField.sendKeys("test");
            directorField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement departmentDtlField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='orgDepartmentDtl.description']")));
            departmentDtlField.sendKeys("test");
            
            WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cityId_nameField")));
            cityField.sendKeys("Улаанбаатар");
            cityField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement districtField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("districtId_nameField")));
            districtField.sendKeys("Баянзүрх");
            districtField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement streetField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("streetId_nameField")));
            streetField.sendKeys("1-р хороо");
            streetField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(1000);
            
            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                
                WebElement cnclBtn = driver.findElement(By.className("ui-pnotify-closer"));                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.visibility='visible';", cnclBtn);
                Thread.sleep(1000);
                cnclBtn.click();

                Thread.sleep(3500);

                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn blue-madison btn-sm bp-close-btn bp-btn-close')]")));
                closeBtn.click();
                
                return;
            }

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
