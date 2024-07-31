package selenium.testingmachine.supply.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class productPort {
   public static @MessageField String message;
    private WebDriver driver;

    public productPort(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

            Thread.sleep(500);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Боомт')]")));
            main.click();

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Гадаад боомт')]")));
            menu.click(); 

            Thread.sleep(500);
            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(1000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[name]")));
            name.sendKeys("test1");

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-section-path='portTypeId']")));
            WebElement radioButton = type.findElement(By.xpath(".//input[@type='radio' and @value='1']"));
            radioButton.click();

            WebElement mode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-section-path='portModeId']")));
            WebElement radioButton1 = mode.findElement(By.xpath(".//input[@type='radio' and @value='1']"));
            radioButton1.click();

            WebElement category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-section-path='portCategoryId']")));
            WebElement radioButton2 = category.findElement(By.xpath(".//input[@type='radio' and @value='1']"));
            radioButton2.click();

            Thread.sleep(500);

            WebElement coordinate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-primary mr0')]")));
            coordinate.click();

            WebElement selectCoordinate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm red-sunglo')]")));
            selectCoordinate.click();

            Thread.sleep(1000);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " -" +"<br>Алдаа: " + errorText;
                            
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

