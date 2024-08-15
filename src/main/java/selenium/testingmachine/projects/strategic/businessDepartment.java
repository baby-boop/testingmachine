package selenium.testingmachine.projects.strategic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ErrorUtils;

public class businessDepartment {

    private WebDriver driver;

    public businessDepartment(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='169114919412631']")));
            menu.click();

            Thread.sleep(3000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2]")));
            name.sendKeys("test1");

            WebElement district = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C3]")));
            district.sendKeys("test1");

            WebElement street = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C4]")));
            street.sendKeys("test1");

            WebElement apartment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C5]")));
            apartment.sendKeys("2024");

            WebElement mkb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C6]")));
            mkb.sendKeys("2024");

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C7]")));
            date.sendKeys("2024-07-24");

            WebElement payment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C8]")));
            payment.sendKeys("testshuu");

            WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C9]")));
            desc.sendKeys("testshuu");


            Thread.sleep(2000);
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            saveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
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
