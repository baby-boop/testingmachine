package selenium.testingmachine.projects.finance.financeStandard.masterData;

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



public class contractClassification {

    private WebDriver driver;

    public contractClassification(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='1666756951214561']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='name'] input[name='param[name]']")));
            nameField.sendKeys("test");

            WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='code'] input[name='param[code]']")));
            codeField.sendKeys("1");

            Thread.sleep(1000);

            WebElement classificationTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='classificationTypeId']")));
            classificationTypeField.click();
            WebElement classificationTypeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='БУСАД']")));
            classificationTypeOption.click();

            Thread.sleep(500);

            WebElement checkbox = driver.findElement(By.id("param[isMain]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
            Thread.sleep(1000);


            WebElement kpiTemplateField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".middle #kpiTemplateId_nameField")));
            kpiTemplateField.sendKeys("Тодорхойлолт");
            kpiTemplateField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(1000);

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
