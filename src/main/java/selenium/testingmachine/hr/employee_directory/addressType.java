package selenium.testingmachine.hr.employee_directory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class addressType {

    public static @MessageField String message;
    private WebDriver driver;

    public addressType(WebDriver driver) {
        this.driver = driver;
    }
    public void types(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            WebElement list = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Хаягийн төрөл')]")));
            list.click(); 
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ADDRESS_TYPE_NAME]")));
            type.sendKeys("test2");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            saveBtn.click();

            Thread.sleep(1000);
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));
            if (!rows.isEmpty()) {
                WebElement firstRow = rows.get(0);
                firstRow.click();

                WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
                edit.click();

            } else {
                System.out.println("No rows found.");
            }

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[GLOBE_CODE]")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].removeAttribute('readonly')", name);
            name.sendKeys("test1");

            Thread.sleep(1000);

            WebElement editSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            editSave.click();

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
