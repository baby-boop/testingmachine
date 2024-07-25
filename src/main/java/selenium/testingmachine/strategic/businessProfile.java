package selenium.testingmachine.strategic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class businessProfile {
    public static String message;

    private WebDriver driver;

    public businessProfile(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Thread.sleep(2000);

            WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-modulename='Бизнес профайл']")));
            menuTileElement.click();

            Thread.sleep(3000);

            WebElement register = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[REGISTER_NUMBER]")));
            register.sendKeys("112211");

            WebElement reg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STATE_REGISTER_NUMBER]")));
            reg.sendKeys("112211");    

            WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[PHONE_NUMBER]")));
            phone.sendKeys("99119911");

            WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[YEAR]")));
            year.sendKeys("2024");

            WebElement emp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[EMPLOYEE_COUNT]")));
            emp.sendKeys("11");

            WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ADDRESS]")));
            address.sendKeys("testshuu");

            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[EMAIL]")));
            email.sendKeys("testshuu@gmail.com");

            Thread.sleep(2000);
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
            System.out.println("Error class-businessProfile : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished businessProfile");
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = ("class-businessProfile: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }       
}
