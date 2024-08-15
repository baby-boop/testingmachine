package selenium.testingmachine.projects.hr_time.masterData;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ErrorUtils;

public class employeeAttendanceLog {

    private WebDriver driver;

    public employeeAttendanceLog(WebDriver driver) {
        this.driver = driver;
    }
    public void data() {
        try {
 
            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Мастер дата']")));
            main.click();

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Ирц нэмэх")));
            add.click();

            Thread.sleep(2000);

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
            
            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
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