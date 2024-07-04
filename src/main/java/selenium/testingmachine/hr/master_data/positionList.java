package selenium.testingmachine.hr.master_data;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class positionList {

    private WebDriver driver;

    public positionList(WebDriver driver) {
        this.driver = driver;
    }
    public void position(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(2000);

            WebElement list = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Албан тушаал')]")));
            list.click(); 
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='positionName'] input[name='param[positionName]']")));
            name.sendKeys("test1");

            WebElement level = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='profLevelId']")));
            level.click();
            WebElement leveloption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Ажилтан']")));
            leveloption.click();

            WebElement type = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='classificationId']")));
            type.click();
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Ажилтан']")));
            typeOption.click();

            WebElement levelParent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vocationGroupId_nameField")));
            levelParent.sendKeys("Программ зохиогч");
            levelParent.sendKeys(Keys.ENTER);

            WebElement salaryType = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-section-path='salaryTypeId'] div[data-s-path='salaryTypeId']")));
            salaryType.click();
            WebElement salaryTypeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Өдрөөр']")));
            salaryTypeOption.click();

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(1000);
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));
            if (!rows.isEmpty()) {
                WebElement lastRow = rows.get(rows.size() - 1);
                lastRow.click();

                WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
                edit.click();

            } else {
                System.out.println("No rows found.");
            }

            Thread.sleep(1000);

            WebElement addName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='positionName'] input[name='param[positionName]']")));
            addName.sendKeys(" нэрийг солив");
            Thread.sleep(2000);

            WebElement editSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn bp-btn-save  ')]")));
            editSave.click();

        
            // if (!rows.isEmpty()) {
            //     WebElement lastRow = rows.get(rows.size() - 1);
            //     lastRow.click();

            //     WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Устгах")));
            //     delete.click();

            // } else {
            //     System.out.println("No rows found.");
            // }
            // WebElement deletetn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm')]")));
            // deletetn.click();


        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-positionList : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished positionList");
        }
    }
}
