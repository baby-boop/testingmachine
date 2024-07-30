package selenium.testingmachine.finance.financeRequest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class request {
    public static String message;
    private WebDriver driver;
    

    public request(WebDriver driver) {
        this.driver = driver;
    }
    public void requestProcess(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(1000);
            
            WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-modulename='Зээлийн хүсэлтийн удирлага']")));
            menuTileElement.click();

            Thread.sleep(3500);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C260]")));
            name.sendKeys("test2");

            WebElement Reg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C261]")));
            Reg.sendKeys("101010");

            WebElement number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C262]")));
            number.sendKeys("1");

            WebElement gmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C263]")));
            gmail.sendKeys("test@gmail.com");

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[FIN_DATA_DATE]")));
            date.sendKeys("2024-07-02");

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C6.C568']")));
            type.click();
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Ногоон бизнесийн зээл']")));
            typeOption.click();

            Thread.sleep(500);

            // WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C6.C575]")));
            // amount.sendKeys("1000000");

            WebElement amount = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("mvParam[C6.C575]")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('value', '1000000')", amount);
            js.executeScript("arguments[0].dispatchEvent(new Event('change')); arguments[0].dispatchEvent(new Event('input'));", amount);

            WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C6.C569]")));
            year.sendKeys("3");

            WebElement month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C6.C570]")));
            month.sendKeys("36");

            WebElement dedication = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C17.C2']")));
            dedication.click();
            WebElement dedicationOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Гэрээгээр гүйцэтгэх ажлын санхүүжилт']")));
            dedicationOption.click();

            WebElement subDedication = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C17.C3']")));
            subDedication.click();
            WebElement subDedicationOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Гэрээгээр ажил гүйцэтгэх']")));
            subDedicationOption.click();

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Хүсэлт" +"<br>Алдаа: " + errorText;
                            
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