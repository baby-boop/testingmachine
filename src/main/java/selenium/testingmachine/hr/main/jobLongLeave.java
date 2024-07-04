package selenium.testingmachine.hr.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jobLongLeave {
    public static String message;
    private WebDriver driver;

    public jobLongLeave(WebDriver driver) {
        this.driver = driver;
    }
    public void longLeave(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            WebElement longLeave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Урт хугацааны чөлөө')]")));
            longLeave.click();

            WebElement probation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(3) > .item-icon-selection")));
            probation.click();
            
            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDate']")));
            date.sendKeys("2024-06-07");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();
            Thread.sleep(3000);

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] textarea[name='param[description]']")));
            description.sendKeys("Урт хугацааны чөлөөө");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldEmployeeKeyId_nameField")));
            name.sendKeys("Бат-оргил");
            name.sendKeys(Keys.ENTER);

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            startDate.sendKeys("2024-06-07"); 

            WebElement endDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.endDate']")));
            endDate.sendKeys("2024-06-18"); 

            WebElement descriptionDtl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='HCM_LABOUR_BOOK_DTL.description'] textarea[name='param[HCM_LABOUR_BOOK_DTL.description][0][]']")));
            descriptionDtl.sendKeys("Ажлаас чөлөөлөх");

            saveBtn.click();
            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                return;
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-jobLongLeave : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished jobLongLeave");
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='main-process-text']/span"));
            String processName = mainProccess.getText();
            message = ("class-jobDismissed: "+ this.getClass().getName() + "   processName="+processName + "   Алдаа: " + errorText);
            System.out.println(message);

            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }
}
