package selenium.testingmachine.office.contract.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contractList {

    public static String message;

    private WebDriver driver;

    public contractList(WebDriver driver) {
        this.driver = driver;
    }
    public void main(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(500);

            WebElement list = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Гэрээний жагсаалт')]")));
            list.click(); 

            Thread.sleep(1000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='CONTRACT_NAME']")));
            name.sendKeys("test1");

            WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='CONTRACT_CODE']")));
            code.sendKeys("test1");

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CONTRACT_DATE]")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].removeAttribute('readonly')", date);
            date.sendKeys("2024-07-20");

            WebElement CLASSIFICATION = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CLASSIFICATION_ID_DESCNAME]")));
            CLASSIFICATION.sendKeys("test1");
            CLASSIFICATION.sendKeys(Keys.ENTER);

            WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DESCRIPTION]")));
            desc.sendKeys("testshuu");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();


            // WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Дэлгэрэнгүй')]")));
            // openField.click();

            // WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CUSTOMER_ID_DESCNAME]")));
            // customer.sendKeys("testgul");
            // customer.sendKeys(Keys.ENTER);

            // WebElement register = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[DESCRIPTION]")));
            // register.sendKeys("782555");

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
                return;
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-contractList : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished contractList");
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = ("class-contractList: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }    
}
