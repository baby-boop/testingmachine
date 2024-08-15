package selenium.testingmachine.projects.hr_time.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ErrorUtils;

public class requestTime {

    private WebDriver driver;

    public requestTime(WebDriver driver) {
        this.driver = driver;
    }
    public void main() {
        try {
            
            Thread.sleep(500);

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Хүсэлт')]")));
            main.click();

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='16835223942649")));
            menu.click();

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement selectDepartment = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".middle #departmentId_nameField")));
            selectDepartment.sendKeys("Мандал");
            selectDepartment.sendKeys(Keys.ENTER);

            Thread.sleep(1500);

            WebElement selectEmployee = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".middle #employeeKeyId_nameField")));
            selectEmployee.sendKeys("testgul");
            selectEmployee.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement requestField = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[bookTypeId]")));
            requestField.click();
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