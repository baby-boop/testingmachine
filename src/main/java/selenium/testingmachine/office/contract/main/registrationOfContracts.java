package selenium.testingmachine.office.contract.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registrationOfContracts {

    public static String message;

    private WebDriver driver;

    public registrationOfContracts(WebDriver driver) {
        this.driver = driver;
    }
    public void main(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(500);

            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Бүртгэл')]")));
            openField.click();

            Thread.sleep(1000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='CONTRACT_NAME']")));
            name.sendKeys("test1");

            WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='CONTRACT_CODE']")));
            code.sendKeys("test1");

            WebElement CLASSIFICATION = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CLASSIFICATION_ID_DESCNAME]")));
            CLASSIFICATION.sendKeys("test1");
            CLASSIFICATION.sendKeys(Keys.ENTER);

            WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CUSTOMER_ID_DESCNAME]")));
            customer.sendKeys("testgul");
            customer.sendKeys(Keys.ENTER);

            WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DESCRIPTION]")));
            desc.sendKeys("testshuu");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
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
            System.out.println("Error class-registrationOfContracts : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished registrationOfContracts");
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = ("class-registrationOfContracts: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }    
}
