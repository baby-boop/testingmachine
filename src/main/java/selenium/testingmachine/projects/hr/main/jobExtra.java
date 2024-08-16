package selenium.testingmachine.projects.hr.main;


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

public class jobExtra {
    private WebDriver driver;

    public jobExtra(WebDriver driver) {
        this.driver = driver;
    }
    public void extra(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17149688793703']")));
            menu.click();

            Thread.sleep(2000);

            WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Нэмэгдэл']")));
            subMenu.click();

            Thread.sleep(2000);

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDate']")));
            date.sendKeys("2024-06-07");

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] textarea[name='param[description]']")));
            description.sendKeys("Нэмэгдэл");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldEmployeeKeyId_nameField")));
            name.sendKeys("Бат-оргил");
            name.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            startDate.sendKeys("2024-06-07"); 

            WebElement endDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.endDate']")));
            endDate.sendKeys("2024-06-17"); 

            WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='HCM_LABOUR_BOOK_DTL.amount'] input[data-path='HCM_LABOUR_BOOK_DTL.amount']")));
            amount.sendKeys("200000");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();
            
            Thread.sleep(1000);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());

                WebElement cnclBtn = driver.findElement(By.className("ui-pnotify-closer"));                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.visibility='visible';", cnclBtn);
                Thread.sleep(1000);
                cnclBtn.click();

                Thread.sleep(2000);
                return;
            }

            Thread.sleep(2000);

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