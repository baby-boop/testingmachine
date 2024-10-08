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

public class jobDismissed {

    private WebDriver driver;

    public jobDismissed(WebDriver driver) {
        this.driver = driver;
    }

    public void dismissed() {
        
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17149684951853']")));
            menu.click();

            Thread.sleep(2000);

            WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Хөдөлмөрийн гэрээ дуусгавар болгох']")));
            subMenu.click();

            Thread.sleep(2000);

            WebElement startDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDate']")));
            startDateField.sendKeys("2024-06-07");

            WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] textarea[name='param[description]']")));
            descriptionField.sendKeys("Ажлаас чөлөөлөх");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("oldEmployeeKeyId_nameField")));
            name.sendKeys("Бат-оргил");
            name.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            dateField.sendKeys("2024-06-07");

            Thread.sleep(500);

            WebElement employeeStatus = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='HCM_LABOUR_BOOK_DTL.quitjobTypeId']")));
            employeeStatus.click();
            WebElement employeeStatusOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Суралцах']")));
            employeeStatusOption.click();

            Thread.sleep(1000);

            WebElement descriptionDtlField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='HCM_LABOUR_BOOK_DTL.description'] textarea[name='param[HCM_LABOUR_BOOK_DTL.description][0][]']")));
            descriptionDtlField.sendKeys("Ажлаас чөлөөлөх");

            Thread.sleep(1000);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save ')]")));
            saveBtn.click();

            Thread.sleep(1000);

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