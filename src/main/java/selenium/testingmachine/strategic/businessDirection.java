package selenium.testingmachine.strategic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class businessDirection {
    public static @MessageField String message;

    private WebDriver driver;

    public businessDirection(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='169110970']")));
            menu.click();

            Thread.sleep(3000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement type1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C1']")));
            type1.click();
            WebElement typeOption1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Гэрээт ажил']")));
            typeOption1.click();

            WebElement type2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C2']")));
            type2.click();
            WebElement typeOption2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Бусад_Гэрээт_ажил']")));
            typeOption2.click();

            WebElement type3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C3']")));
            type3.click();
            WebElement typeOption3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Бусад_Гэрээт_ажил']")));
            typeOption3.click();

            WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C5]")));
            year.sendKeys("2024");

            WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C6]")));
            desc.sendKeys("testshuu");


            Thread.sleep(2000);
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
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
