package selenium.testingmachine.hr_time.masterData;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class employeeAttendanceLog {
    public static String message;

    private WebDriver driver;

    public employeeAttendanceLog(WebDriver driver) {
        this.driver = driver;
    }
    public void mData() {
        try {
            
            Thread.sleep(500);

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


                    
            driver.get("https://testshuu.veritech.mn/login");
            driver.manage().window().setSize(new Dimension(1500, 800));
            WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
            userNameField.sendKeys("admin");
    
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass_word")));
            passwordField.sendKeys("89");
            passwordField.sendKeys(Keys.ENTER);

            String url = "https://testshuu.veritech.mn/appmenu/mvmodule/16745414748303";
            driver.get(url);

            Thread.sleep(1000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Мастер дата']")));
            main.click();

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Ирц нэмэх")));
            add.click();
            Thread.sleep(500);
            WebElement selectDepartment = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".middle #employeeId_nameField")));
            selectDepartment.sendKeys("Г.Бат-оргил");
            selectDepartment.sendKeys(Keys.ENTER);
            Thread.sleep(1500);

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='attendanceDateTime'] input[data-path='attendanceDateTime']")));
            date.sendKeys("2024-06-17 13:30:00");
            date.sendKeys(Keys.ENTER);

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[data-path='causeDescription']")));
            description.sendKeys("Талбарыг заавал бөглөнө.");

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
