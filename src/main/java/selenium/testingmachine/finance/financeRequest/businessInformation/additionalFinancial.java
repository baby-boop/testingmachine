package selenium.testingmachine.finance.financeRequest.businessInformation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class additionalFinancial {

    public static String message;

    private WebDriver driver;

    public additionalFinancial(WebDriver driver) {
        this.driver = driver;
    }
    public void finance(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(500);

            WebElement subMain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Санхүүгийн нэмэлт мэдээлэл')]")));
            subMain.click();

            Thread.sleep(500);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                // WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                // cnclBtn.click();
                return;
            }

            Thread.sleep(1000);
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-additionalFinancial : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished additionalFinancial");
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProcess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-process-text']/div[contains(text(), 'Санхүүгийн тайлангийн мэдээлэл')]")));
            String processName = mainProcess.getText();
            message = ("class-additionalFinancial: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }      
}
