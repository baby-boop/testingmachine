package selenium.testingmachine.strategic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class businessDepartment {
public static String message;

    private WebDriver driver;

    public businessDepartment(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='169114919412631']")));
            menu.click();

            Thread.sleep(3000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2]")));
            name.sendKeys("test1");

            WebElement district = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C3]")));
            district.sendKeys("test1");

            WebElement street = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C4]")));
            street.sendKeys("test1");

            WebElement apartment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C5]")));
            apartment.sendKeys("2024");

            WebElement mkb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C6]")));
            mkb.sendKeys("2024");

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C7]")));
            date.sendKeys("2024-07-24");

            WebElement payment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C8]")));
            payment.sendKeys("testshuu");

            WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C9]")));
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
            System.out.println("Error class-businessDepartment : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished businessDepartment");
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = ("class-businessDepartment: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }  
}
