package selenium.testingmachine.projects.finance.financeRequest.firstInformation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class stocks {

    public static @MessageField String message;

    private WebDriver driver;

    public stocks(WebDriver driver) {
        this.driver = driver;
    }
    public void notice(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Зээлд барьцаалуулах хөрөнгө (хөдлөх хөрөнгө барьцаалуулах бол)')]")));
            main.click();

            Thread.sleep(2000);

            WebElement addRow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action-path='C11']")));
            addRow.click();

            Thread.sleep(1000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C11.C1][0]")));
            name.sendKeys("test1");

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C11.C2']")));
            type.click();
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Хувийн хэрэгцээнд ашигладаг']")));
            typeOption.click();

            WebElement path1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C11.C3][0]")));
            path1.sendKeys("10021000");

            WebElement path2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C11.C10][0]")));
            path2.sendKeys("test2");

            WebElement path3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C11.C5][0]")));
            path3.sendKeys("2024");

            WebElement path4 = driver.findElement(By.name("mvParam[C11.C6][0]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='1000000';", path4);

            WebElement path5 = driver.findElement(By.name("mvParam[C11.C11][0]"));
            js.executeScript("arguments[0].value='90';", path5);

            WebElement type2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C11.C7']")));
            type2.click();
            WebElement type2Option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Тийм']")));
            type2Option.click();

            WebElement path6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C11.C8][0]")));
            path6.sendKeys("test1");

            Thread.sleep(500);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
                return;
            }

            Thread.sleep(1000);
            
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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Сахилга" +"<br>Алдаа: " + errorText;
                            
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