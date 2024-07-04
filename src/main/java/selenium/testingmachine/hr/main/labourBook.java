package selenium.testingmachine.hr.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class labourBook {

    private WebDriver driver;

    public labourBook(WebDriver driver) {
        this.driver = driver;
    }
    public void labour(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Тушаал')]")));
            openField.click();

            WebElement labour = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Ажилд авах')]")));
            labour.click();

            WebElement probation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(1) > .item-icon-selection")));
            probation.click();

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] input[name='param[description]']")));
            description.sendKeys("Шалгалтаа амжилттай дуусгасан");

            WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("candidateKeyId_displayField")));
            firstname.sendKeys("БН00251118");
            firstname.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("departmentId_nameField")));
            department.sendKeys("Гүйцэтгэх цех");
            department.sendKeys(Keys.ENTER);

            WebElement position = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("positionKeyId_nameField")));
            position.sendKeys("Нэвтрүүлэлтийг мэргэжилтэн");
            position.sendKeys(Keys.ENTER);

            WebElement employeeStatus = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[HCM_LABOUR_BOOK_DTL.employeeStatusId][0][]")));
            employeeStatus.click();
            WebElement employeeStatusOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Туршилтын']")));
            employeeStatusOption.click();

            WebElement status = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[HCM_LABOUR_BOOK_DTL.currentStatusId][0][]")));
            status.click();
            WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Ажиллаж байгаа']")));
            statusOption.click();

            WebElement insured = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("insuredTypeId_displayField")));
            insured.sendKeys("02001");
            insured.sendKeys(Keys.ENTER);

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            startDate.sendKeys("2024-06-07");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-labourBook" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished labourBook");
        }
    }
}
