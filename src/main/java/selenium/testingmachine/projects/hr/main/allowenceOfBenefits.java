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

public class allowenceOfBenefits {
    private WebDriver driver;

    public allowenceOfBenefits(WebDriver driver) {
        this.driver = driver;
    }
    public void benefits(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17149688562173']")));
            menu.click();

            Thread.sleep(2000);

            WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Тэтгэмж хөнгөлөлт']")));
            subMenu.click();

            Thread.sleep(2000);

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDate']")));
            date.sendKeys("2024-06-07");

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] textarea[name='param[description]']")));
            description.sendKeys("Тэтгэвэр олгомж");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldEmployeeKeyId_nameField")));
            name.sendKeys("Бат-оргил");
            name.sendKeys(Keys.ENTER);

            WebElement benefitsType = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[HCM_LABOUR_BOOK_DTL.supportTypeId][0][]")));
            benefitsType.click();
            WebElement benefitsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Тусламж']")));
            benefitsOption.click();

            WebElement benefitsName= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='HCM_LABOUR_BOOK_DTL.supportSubTypeId']")));
            benefitsName.click();
            WebElement nameOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Түлээ нүүрсний тусламж']")));
            nameOption.click();

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            startDate.sendKeys("2024-06-07"); 

            WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='HCM_LABOUR_BOOK_DTL.amountextra'] input[data-path='HCM_LABOUR_BOOK_DTL.amountextra']")));
            amount.sendKeys("800000");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();
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