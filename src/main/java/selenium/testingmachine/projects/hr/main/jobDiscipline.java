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

public class jobDiscipline {
     private WebDriver driver;

    public jobDiscipline(WebDriver driver) {
        this.driver = driver;
    }
    public void warning(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17149688777653']")));
            menu.click();

            Thread.sleep(2000);

            WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Анхааруулга']")));
            subMenu.click();

            Thread.sleep(2000);

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] textarea[name='param[description]']")));
            description.sendKeys("Сахилга");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldEmployeeKeyId_nameField")));
            name.sendKeys("Бат-оргил");
            name.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            // WebElement employeeStatus = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='HCM_LABOUR_BOOK_DTL.punishmentTypeId']")));
            // employeeStatus.click();
            // WebElement employeeStatusOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Зөрчил гарсан']")));
            // employeeStatusOption.click();

            WebElement descriptionDtl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='HCM_LABOUR_BOOK_DTL.description'] textarea[name='param[HCM_LABOUR_BOOK_DTL.description][0][]']")));
            descriptionDtl.sendKeys("Анхааруулга");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
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