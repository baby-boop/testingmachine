package selenium.testingmachine.hr.main;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reassignment {
    private WebDriver driver;

    public reassignment(WebDriver driver) {
        this.driver = driver;
    }
    public void reassignment(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            Thread.sleep(500);

            WebElement benefits = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Эргүүлэн томилох')]")));
            benefits.click();

            WebElement probation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(1) > .item-icon-selection")));
            probation.click();

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDate']")));
            date.sendKeys("2024-06-07");

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] input[name='param[description]']")));
            description.sendKeys("Эргүүлэн томилох");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("oldEmployeeKeyId_nameField")));
            name.sendKeys("Наран");
            name.sendKeys(Keys.ENTER);

            Thread.sleep(500);
            WebElement department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("departmentId_nameField")));
            department.sendKeys("Гүйцэтгэх цех");
            department.sendKeys(Keys.ENTER);

            WebElement position = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("positionKeyId_nameField")));
            position.sendKeys("Нэвтрүүлэлтийг мэргэжилтэн");
            position.sendKeys(Keys.ENTER);

            WebElement empStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employeeStatusId_nameField")));
            empStatus.sendKeys("Үндсэн");
            empStatus.sendKeys(Keys.ENTER);

            WebElement status = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[HCM_LABOUR_BOOK_DTL.currentStatusId][0][]")));
            status.click();
            WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Ажиллаж байгаа']")));
            statusOption.click();

            WebElement benefitsType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("insuredTypeId_nameField")));
            benefitsType.sendKeys("Хөдөлмөрийн гэрээний дагуу ажиллаж байгаа үндсэн ажилтан");
            benefitsType.sendKeys(Keys.ENTER);

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            startDate.sendKeys("2024-06-07"); 

            WebElement endDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.endDate']")));
            endDate.sendKeys("2024-06-17"); 

            WebElement per = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.amount']")));
            per.sendKeys("1700000"); 


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
