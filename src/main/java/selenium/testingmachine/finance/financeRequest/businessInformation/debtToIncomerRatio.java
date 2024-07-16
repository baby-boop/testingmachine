package selenium.testingmachine.finance.financeRequest.businessInformation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class debtToIncomerRatio {

    public static String message;

    private WebDriver driver;

    public debtToIncomerRatio(WebDriver driver) {
        this.driver = driver;
    }
    public void finance(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(500);

            WebElement subMain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Өр орлогын харьцаа')]")));
            subMain.click();

            Thread.sleep(500);
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // WebElement path1 = driver.findElement(By.name("mvParam[C562]"));
            // js.executeScript("arguments[0].value='1000000';", path1);

            // WebElement path2 = driver.findElement(By.name("mvParam[C563]"));
            // js.executeScript("arguments[0].value='1000000';", path2);

            // WebElement path3 = driver.findElement(By.name("mvParam[C564]"));
            // js.executeScript("arguments[0].value='1000000';", path3);

            WebElement path4 = driver.findElement(By.name("mvParam[C565]"));
            js.executeScript("arguments[0].value='1000000';", path4);

            // WebElement path5 = driver.findElement(By.name("mvParam[C566]"));
            // js.executeScript("arguments[0].value='1000000';", path5);

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
            System.out.println("Error class-debtToIncomerRatio : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished debtToIncomerRatio");
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = ("class-debtToIncomerRatio: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }    
}
