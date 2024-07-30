package selenium.testingmachine.hr.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class labourBook {
    public static @MessageField String message;

    private WebDriver driver;

    public labourBook(WebDriver driver) {
        this.driver = driver;
    }
    public void labour(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Тушаал')]")));
            openField.click();

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17149684942883']")));
            menu.click();

            Thread.sleep(2000);

            WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Туршилтын ажилтнаар томилох']")));
            subMenu.click();

            Thread.sleep(2000);

            WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] input[name='param[description]']")));
            descriptionField.sendKeys("Шалгалтаа амжилттай дуусгасан");

            WebElement firstnameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("candidateKeyId_displayField")));
            firstnameField.sendKeys("БН00251118");
            firstnameField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement departmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("departmentId_nameField")));
            departmentField.sendKeys("Гүйцэтгэх цех");
            departmentField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement positionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("positionKeyId_nameField")));
            positionField.sendKeys("Нэвтрүүлэлтийг мэргэжилтэн");
            positionField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement employeeStatus = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='HCM_LABOUR_BOOK_DTL.employeeStatusId']")));
            employeeStatus.click();
            WebElement employeeStatusOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Туршилтын']")));
            employeeStatusOption.click();

            Thread.sleep(1000);

            WebElement statusField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='HCM_LABOUR_BOOK_DTL.currentStatusId']")));
            statusField.click();
            WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Ажиллаж байгаа']")));
            statusOption.click();

            Thread.sleep(500);

            WebElement insuredField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("insuredTypeId_displayField")));
            insuredField.sendKeys("02001");
            insuredField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement startDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            startDateField.sendKeys("2024-06-07");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeMessageBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".brighttheme-icon-closer")));
                closeMessageBtn.click();
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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Ажилд авах" +"<br>Алдаа: " + errorText;
                            
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