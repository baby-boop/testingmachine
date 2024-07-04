package selenium.testingmachine.hr_time;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class requestTime {

    public static String message;

    private WebDriver driver;

    public requestTime(WebDriver driver) {
        this.driver = driver;
    }
    public void time() {
        try {
            
            Thread.sleep(500);

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(1000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Мастер дата')]")));
            main.click();

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Ирц нэмэх")));
            add.click();
            Thread.sleep(500);
            WebElement selectDepartment = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".middle #departmentId_nameField")));
            selectDepartment.sendKeys("Мандал");
            selectDepartment.sendKeys(Keys.ENTER);
            Thread.sleep(1500);

            WebElement selectEmployee = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".middle #employeeKeyId_nameField")));
            selectEmployee.sendKeys("testgul");
            selectEmployee.sendKeys(Keys.ENTER);
            Thread.sleep(500);

            WebElement request = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[bookTypeId]")));
            request.click();
            WebElement requestOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Гадуур ажилласан']")));
            requestOption.click();
            Thread.sleep(2000);

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='startDate'] input[name='param[startDate]']")));
            startDate.sendKeys("2024-06-17");

            WebElement endDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='endDate'] input[data-path='endDate']")));
            endDate.sendKeys("2024-06-17");

            WebElement startTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='startTime'] input[data-path='startTime']")));
            startTime.sendKeys("09-00");

            WebElement endTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='bp_main_tab_1719374901745671'] div[data-section-path='endTime'] input[data-path='endTime']")));
            endTime.sendKeys("18-00");

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[data-path='description']")));
            description.sendKeys("Гадуур ажилласан");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();


            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                return;
            }
            
    
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-requestTime : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished requestTime");
        }

    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = ("class-requestTime: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }       
      
}
