package selenium.testingmachine.hr.main;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jobSalary {

    private WebDriver driver;

    public jobSalary(WebDriver driver) {
        this.driver = driver;
    }
    public void salary(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement benefits = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Цалин хөлс')]")));
            benefits.click();

            WebElement probation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(1) > .item-icon-selection")));
            probation.click();

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDate']")));
            date.sendKeys("2024-06-07");

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] textarea[name='param[description]']")));
            description.sendKeys("Цалин хөлс");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldEmployeeKeyId_nameField")));
            name.sendKeys("Бат-оргил");
            name.sendKeys(Keys.ENTER);

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            startDate.sendKeys("2024-06-07"); 

            WebElement salaryLevel = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[HCM_LABOUR_BOOK_DTL.salaryKeyId][0][]")));
            salaryLevel.click();
            WebElement salaryLevelOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='G3']")));
            salaryLevelOption.click();

            WebElement descriptionDtl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='HCM_LABOUR_BOOK_DTL.description'] textarea[name='param[HCM_LABOUR_BOOK_DTL.description][0][]']")));
            descriptionDtl.sendKeys("Цалин");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();


        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-JobSalary : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished jobSalary");
        }
    }
}
