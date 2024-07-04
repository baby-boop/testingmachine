package selenium.testingmachine.hr.main;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jobTransitionalMovement {
     private WebDriver driver;

    public jobTransitionalMovement(WebDriver driver) {
        this.driver = driver;
    }
    public void transition(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement longLeave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Шилжилт хөдөлгөөн')]")));
            longLeave.click();

            WebElement probation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(1) > .item-icon-selection")));
            probation.click();

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDate']")));
            date.sendKeys("2024-06-07");

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] textarea[name='param[description]']")));
            description.sendKeys("Шилжилт хөдөлгөөн");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldEmployeeKeyId_nameField")));
            name.sendKeys("Бат-оргил");
            name.sendKeys(Keys.ENTER);

            WebElement department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("departmentId_nameField")));
            department.sendKeys("Тооцооны төв");
            department.sendKeys(Keys.ENTER);

            WebElement position = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("positionKeyId_nameField")));
            position.sendKeys("Захирал");
            position.sendKeys(Keys.ENTER);

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            startDate.sendKeys("2024-06-07"); 

            WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='HCM_LABOUR_BOOK_DTL.amount'] input[data-path='HCM_LABOUR_BOOK_DTL.amount']")));
            amount.sendKeys("2500000");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-jobTransitionalMovement : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished labourBook");
        }
    }
}
