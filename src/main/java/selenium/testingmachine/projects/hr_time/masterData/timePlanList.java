package selenium.testingmachine.projects.hr_time.masterData;

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

public class timePlanList {
    
    private WebDriver driver;

    public timePlanList(WebDriver driver) {
        this.driver = driver;
    }
    public void data() {
        try {
 
            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='1496152906572")));
            menu.click();

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            // WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[code]']")));
            // codeField.sendKeys("1");

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='name'] input[name='param[name]']")));
            nameField.sendKeys("test");

            WebElement shortNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[shortName]")));
            shortNameField.sendKeys("test");

            Thread.sleep(1000);

            
            WebElement typeField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='typeId']")));
            typeField.click();
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Энгийн хуваарь']")));
            typeOption.click();

            WebElement morningStarttime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[tmsTimePlanDetail.starttime][0][]")));
            morningStarttime.sendKeys("09:30");

            WebElement approvedmorningStarttime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[tmsTimePlanDetail.startTimeLimit][0][]")));
            approvedmorningStarttime.sendKeys("07:30");

            WebElement morningEndtime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[tmsTimePlanDetail.endTime][0][]")));
            morningEndtime.sendKeys("09:30");

            WebElement approvedMorningEndtime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[tmsTimePlanDetail.endTimeLimit][0][]")));
            approvedMorningEndtime.sendKeys("09:30");

            Thread.sleep(1000);

            WebElement eveningStarttime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[tmsTimePlanDetail.starttime][1][]")));
            eveningStarttime.sendKeys("14:00");

            WebElement approvedeveningStarttime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[tmsTimePlanDetail.startTimeLimit][1][]")));
            approvedeveningStarttime.sendKeys("16:30");

            WebElement eveningEndtime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[tmsTimePlanDetail.endTime][1][]")));
            eveningEndtime.sendKeys("18:30");

            WebElement approvedEveningEndtime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[tmsTimePlanDetail.endTimeLimit][1][]")));
            approvedEveningEndtime.sendKeys("18:30");

            Thread.sleep(1000);

            WebElement departmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='TMS_TIME_PLAN_DEPARTMENT_DV']")));
            departmentField.sendKeys("003");
            departmentField.sendKeys(Keys.ENTER);

            Thread.sleep(3000);


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