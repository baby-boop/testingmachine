package selenium.testingmachine.projects.supply.masterdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class productPort {
    private WebDriver driver;

    public productPort(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Боомт')]")));
            main.click();

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Гадаад боомт')]")));
            menu.click(); 

            Thread.sleep(2000);
            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[name]")));
            name.sendKeys("test1");

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-section-path='portTypeId']")));
            WebElement radioButton = type.findElement(By.xpath(".//input[@type='radio' and @value='1']"));
            radioButton.click();

            WebElement mode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-section-path='portModeId']")));
            WebElement radioButton1 = mode.findElement(By.xpath(".//input[@type='radio' and @value='1']"));
            radioButton1.click();

            WebElement category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-section-path='portCategoryId']")));
            WebElement radioButton2 = category.findElement(By.xpath(".//input[@type='radio' and @value='1']"));
            radioButton2.click();

            Thread.sleep(500);

            WebElement coordinate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-primary mr0')]")));
            coordinate.click();

            Thread.sleep(2500);

            WebElement selectCoordinate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm red-sunglo')]")));
            selectCoordinate.click();

            Thread.sleep(2000);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
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

