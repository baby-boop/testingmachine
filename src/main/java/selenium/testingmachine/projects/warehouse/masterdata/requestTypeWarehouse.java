package selenium.testingmachine.projects.warehouse.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class requestTypeWarehouse {

    private WebDriver driver;

    public requestTypeWarehouse(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17152428744823']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ORDER_TYPE_CODE]")));
            codeField.sendKeys("1");

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[ORDER_TYPE_NAME]")));
            nameField.sendKeys("test");


            WebElement systemTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[BOOK_TYPE_ID_DESCNAME]")));
            systemTypeField.sendKeys("ГҮЙЛГЭЭ");
            systemTypeField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            saveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                
                WebElement cnclBtn = driver.findElement(By.className("ui-pnotify-closer"));                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.visibility='visible';", cnclBtn);
                Thread.sleep(1000);
                cnclBtn.click();

                Thread.sleep(3500);

                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm blue-hoki bp-btn-close')]")));
                closeBtn.click();
                return;
            }

            Thread.sleep(1000);

            ClassCounter.registerWorkingClass(this.getClass());


        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
}
