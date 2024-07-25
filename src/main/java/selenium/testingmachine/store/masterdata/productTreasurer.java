package selenium.testingmachine.store.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productTreasurer {
     public static String message;

    private WebDriver driver;

    public productTreasurer(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='16880998756919']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STORE_KEEPER_NAME]")));
            name.sendKeys("test1");

            // WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STORE_KEEPER_KEY_CODE]")));
            // code.sendKeys("4");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(3000);

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(3500);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16880998756919 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            WebElement path = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[ACCOUNT_ID]_nameField")));
            path.sendKeys("хандив тусламжийн зардал");
            path.sendKeys(Keys.ENTER);

            WebElement path1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[SALE_ACCOUNT_ID]_nameField")));
            path1.sendKeys("хандив тусламжийн зардал");
            path1.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[VAT_REC_ACCOUNT_ID]_nameField")));
            path2.sendKeys("хандив тусламжийн зардал");
            path2.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[GAIN_LOSS_ACCOUNT_ID]_nameField")));
            path3.sendKeys("хандив тусламжийн зардал");
            path3.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[DUE_AP_ACCOUNT_ID]_nameField")));
            path4.sendKeys("хандив тусламжийн зардал");
            path4.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[EXPENSE_ACCOUNT_ID]_nameField")));
            path5.sendKeys("хандив тусламжийн зардал");
            path5.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[AP_ACCOUNT_ID]_nameField")));
            path6.sendKeys("хандив тусламжийн зардал");
            path6.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[COST_ACCOUNT_ID]_nameField")));
            path7.sendKeys("хандив тусламжийн зардал");
            path7.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[POST_ACCOUNT_ID]_nameField")));
            path8.sendKeys("хандив тусламжийн зардал");
            path8.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[VAT_PAY_ACCOUNT_ID]_nameField")));
            path9.sendKeys("хандив тусламжийн зардал");
            path9.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[DUE_AR_ACCOUNT_ID]_nameField")));
            path10.sendKeys("хандив тусламжийн зардал");
            path10.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[RETURN_ACCOUNT_ID]_nameField")));
            path11.sendKeys("хандив тусламжийн зардал");
            path11.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement path12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[SALE_AR_ACCOUNT_ID]_nameField")));
            path12.sendKeys("хандив тусламжийн зардал");
            path12.sendKeys(Keys.ENTER);

            WebElement saveBtn1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn1.click();

            Thread.sleep(500);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Хүний нөөцийн тохиргоо')]")));
            main.click();

            Thread.sleep(2000);

            WebElement path13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[DEPARTMENT_ID]_nameField")));
            path13.sendKeys("test1");
            path13.sendKeys(Keys.ENTER);

            WebElement path14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[EMPLOYEE_ID]_nameField")));
            path14.sendKeys("testgul");
            path14.sendKeys(Keys.ENTER);

            WebElement saveBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn2.click();

            Thread.sleep(3500);
                
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16880998756919 .mb-1 .far")));
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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Барааны нярав" +"<br>Алдаа: " + errorText;
                            
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
