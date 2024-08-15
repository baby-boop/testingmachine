package selenium.testingmachine.projects.hr_time.masterData;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ErrorUtils;

public class publicHolidays {

    private WebDriver driver;

    public publicHolidays(WebDriver driver) {
        this.driver = driver;
    }
    public void data() {
        try {
 
            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Баярын өдрүүд')]")));
            openField.click();

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='1588150045051")));
            menu.click();

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='holidayName'] input[name='param[holidayName]']")));
            nameField.sendKeys("test");

            WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[description]")));
            descriptionField.sendKeys("testshuu");

            Thread.sleep(1000);

            WebElement startdateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[startDate]")));
            startdateField.sendKeys("2024-08-05");

            WebElement enddateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[endDate]")));
            enddateField.sendKeys("2024-08-05");

            Thread.sleep(1000);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();
            
            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                
                WebElement cnclBtn = driver.findElement(By.className("ui-pnotify-closer"));                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.visibility='visible';", cnclBtn);
                Thread.sleep(1000);
                cnclBtn.click();

                Thread.sleep(3500);

                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn blue-madison btn-sm bp-close-btn bp-btn-close')]")));
                closeBtn.click();
                
                return;
            }
            
    
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
 }