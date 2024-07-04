package selenium.testingmachine.hr.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class representativeEmployee {
    private WebDriver driver;

    public representativeEmployee(WebDriver driver) {
        this.driver = driver;
    }
    public void representative(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement benefits = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Орлон болон Хавсран')]")));
            benefits.click();

            WebElement probation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(1) > .item-icon-selection")));
            probation.click();

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDate']")));
            date.sendKeys("2024-06-07");

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] textarea[name='param[description]']")));
            description.sendKeys("Орлон");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employeeKeyId_nameField")));
            name.sendKeys("Бат-оргил");
            name.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement repEmployee = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swipeEmployeeKeyId_nameField")));
            repEmployee.sendKeys("testgul");
            repEmployee.sendKeys(Keys.ENTER);

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            startDate.sendKeys("2024-06-07"); 

            WebElement endDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.endDate']")));
            endDate.sendKeys("2024-06-17"); 

            WebElement per = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.percentage']")));
            per.sendKeys("100"); 


            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();


        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-representativeEmployee : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished representativeEmployee");
        }
    }
}
