package selenium.testingmachine.projects.hr.master_data;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class unitList {
    
    private WebDriver driver;

    public unitList(WebDriver driver) {
        this.driver = driver;
    }
    public void unit(){
        try{

            WebDriverWait wait = configController.getWebDriverWait(driver);

            Thread.sleep(2000);

           WebElement menuTileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-modulename='Core HR']")));
           menuTileElement.click();

           Thread.sleep(3500);

            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Мастер дата')]")));
            menu.click();

            Thread.sleep(2000);

            WebElement addBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            addBtn.click();

            Thread.sleep(2000);

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='DEPARTMENT_NAME']")));
            nameField.sendKeys("test1");

            WebElement parentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='PARENT_ID']")));
            parentField.click();
            WebElement parentOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='Боловсруулах цех']")));
            parentOption.click();

            Thread.sleep(500);

            WebElement classificationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='CLASSIFICATION_ID']")));
            classificationField.click();
            WebElement classificationOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='Борлуулалт']")));
            classificationOption.click();

            Thread.sleep(500);

            WebElement typeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='TYPE_ID']")));
            typeField.click();
            WebElement typeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='Компани']")));
            typeOption.click();

            Thread.sleep(500);

            WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(1000);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");

                WebElement cnclAlertBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-pnotify-closer")));                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.visibility='visible';", cnclAlertBtn);
                cnclAlertBtn.click();

                Thread.sleep(1000);
                
                WebElement cancelBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dialog-valuemap-17074492102739 .mb-1 .far")));
                cancelBtn.click();

                Thread.sleep(1000);

                return;
            }

            Thread.sleep(2000);

            WebElement generalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Тохиргоо')])[2]")));
            generalElement.click();

            Thread.sleep(2000);

            WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='CITY_ID']")));
            city.click();
            WebElement cityOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='Улаанбаатар']")));
            cityOption.click();

            WebElement district = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[DISTRICT_ID]_nameField")));
            district.sendKeys("Баянзүрх");
            district.sendKeys(Keys.ENTER);

            Thread.sleep(1000);
            WebElement street = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[STREET_ID]_nameField")));
            street.sendKeys("28-р хороо");
            street.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='DESCRIPTION']")));
            description.sendKeys("38р гудамж");

            WebElement mainDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-valuemap-17074492102739")));
            WebElement nextSave = wait.until(ExpectedConditions.elementToBeClickable(mainDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));    
            nextSave.click();

            Thread.sleep(1000);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                WebElement cnclAlertBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-pnotify-closer")));                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.visibility='visible';", cnclAlertBtn);
                cnclAlertBtn.click();

                Thread.sleep(1000);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dialog-valuemap-17074492102739 .mb-1 .far")));
                cnclBtn.click();

                Thread.sleep(1000);
                return;
            }

            Thread.sleep(3500);

            WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dialog-valuemap-17074492102739 .mb-1 .far")));
            closeButton.click();
        
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