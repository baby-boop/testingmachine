package selenium.testingmachine.finance.financeRequest.businessInformation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class barterAssets {

    public static String message;

    private WebDriver driver;

    public barterAssets(WebDriver driver) {
        this.driver = driver;
    }
    public void finance(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement subMain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Бартерын хөрөнгө')]")));
            subMain.click();

            Thread.sleep(2000);

            WebElement addRow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action-path='C2']")));
            addRow.click();

            WebElement path1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C2][0]")));
            path1.sendKeys("test1");

            WebElement path2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C3][0]")));
            path2.sendKeys("2024-07-16");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement path3 = driver.findElement(By.name("mvParam[C2.C4][0]"));
            js.executeScript("arguments[0].value='1000000';", path3);

            WebElement path4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C5][0]")));
            path4.sendKeys("test4");

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C2.C6']")));
            type.click();
            Thread.sleep(500);
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Тийм']")));
            typeOption.click();

            WebElement path5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C7][0]")));
            path5.sendKeys("2024-07-17");

            WebElement path6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C8][0]")));
            path6.sendKeys("500000");

            WebElement path7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C9][0]")));
            path7.sendKeys("test");

            WebElement type1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C2.C10']")));
            type1.click();
            Thread.sleep(500);
            WebElement typeOption1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Тийм']")));
            typeOption1.click();

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
