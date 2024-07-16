package selenium.testingmachine.finance.financeRequest.businessInformation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class businessStocks {
    public static String message;

    private WebDriver driver;

    public businessStocks(WebDriver driver) {
        this.driver = driver;
    }
    public void business(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(500);

            WebElement subMain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Бизнест ашигладаг Хөдлөх хөрөнгө')]")));
            subMain.click();

            Thread.sleep(500);

            WebElement addRow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action-path='C2']")));
            addRow.click();

            WebElement path1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C167][6]")));
            path1.sendKeys("test1");

            WebElement path2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C168][6]")));
            path2.sendKeys("2");

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='C2.C170']")));
            type.click();
            Thread.sleep(500);
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Түрээсийн']")));
            typeOption.click();
            

            WebElement path4 = driver.findElement(By.name("mvParam[C2.C171][6]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='1000000';", path4);

            WebElement path5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C12][6]")));
            path5.sendKeys("2000");

            WebElement path7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C172][6]")));
            path7.sendKeys("2024-07-10");

            WebElement path6 = driver.findElement(By.name("mvParam[C2.C173][6]"));
            js.executeScript("arguments[0].value='100000';", path6);

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
            System.out.println("Error class-businessStocks : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished businessStocks");
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = ("class-businessStocks: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }   
}
