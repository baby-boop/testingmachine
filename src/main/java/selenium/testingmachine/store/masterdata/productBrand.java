package selenium.testingmachine.store.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productBrand {
     public static String message;

    private WebDriver driver;

    public productBrand(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Бараа, материал')]")));
            main.click();
            Thread.sleep(2000);
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='16881003018179']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[NAME]")));
            name.sendKeys("test1");

            WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CODE]")));
            code.sendKeys("4");

            WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DESCRIPTION]")));
            desc.sendKeys("testshuu");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(3500);

            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'far fa-times')]")));
            closeBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
                return;
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-productBrand : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished productBrand");
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = (processName+"class-productBrand: "+ this.getClass().getName() + "   processName= " + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }   
}
