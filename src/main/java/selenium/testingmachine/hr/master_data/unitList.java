package selenium.testingmachine.hr.master_data;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class unitList {
    
    private WebDriver driver;

    public static @MessageField String message;

    public unitList(WebDriver driver) {
        this.driver = driver;
    }
    public void unit(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Мастер дата')]")));
            menu.click();

            Thread.sleep(2000);

            WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            edit.click();

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='DEPARTMENT_NAME']")));
            nameField.sendKeys("test1");

            WebElement parentField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='PARENT_ID']")));
            parentField.click();
            WebElement parentOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Боловсруулах цех']")));
            parentOption.click();

            WebElement classificationField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='CLASSIFICATION_ID']")));
            classificationField.click();
            WebElement classificationOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Борлуулалт']")));
            classificationOption.click();

            WebElement typeField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='TYPE_ID']")));
            typeField.click();
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Компани']")));
            typeOption.click();

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
                return;
            }


            WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='CITY_ID']")));
            city.click();
            WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Улаанбаатар']")));
            cityOption.click();

            WebElement district = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[DISTRICT_ID]_nameField")));
            district.sendKeys("Баянзүрх");
            district.sendKeys(Keys.ENTER);

            Thread.sleep(500);
            WebElement street = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[STREET_ID]_nameField")));
            street.sendKeys("28-р хороо");
            street.sendKeys(Keys.ENTER);

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='DESCRIPTION']")));
            description.sendKeys("38р гудамж");

            WebElement nxtSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            nxtSave.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
                return;
            }

            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-dialog-titlebar-close")));
            closeButton.click();

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
            WebElement errorContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme.ui-pnotify-container")));
            WebElement errorTitle = errorContainer.findElement(By.cssSelector(".ui-pnotify-title"));
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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - " +"<br>Алдаа: " + errorText;
                            
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