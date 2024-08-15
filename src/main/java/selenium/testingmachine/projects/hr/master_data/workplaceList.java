package selenium.testingmachine.projects.hr.master_data;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class workplaceList {
    
    private WebDriver driver;

    public workplaceList(WebDriver driver) {
        this.driver = driver;
    }
    public void workplace(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Мастер дата')]")));
            // openField.click();

            Thread.sleep(500);

            WebElement list = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Ажлын байрны жагсаалт')]")));
            list.click(); 
            Thread.sleep(1000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement test11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("departmentId_nameField")));
            test11.sendKeys("test1");
            test11.sendKeys(Keys.ENTER);
            Thread.sleep(500);

            // WebElement position = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("positionId_nameField")));
            // position.sendKeys("Хөгжүүлэгч");
            // position.sendKeys(Keys.ENTER);

            // WebElement ways = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='directionId']")));
            // ways.click();
            // WebElement waysOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Дасан зохицох хариуцсан']")));
            // waysOption.click();

            // WebElement vacancy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='vacancyCount'] input[name='param[vacancyCount]']")));
            // vacancy.sendKeys("2");

            // WebElement conditions = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='conditionId']")));
            // conditions.click();
            // WebElement conditionsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Хэвийн']")));
            // conditionsOption.click();


            // WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            // saveBtn.click();

            // Thread.sleep(1000);
            
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            // List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));
            // if (!rows.isEmpty()) {
            //     WebElement lastRow = rows.get(rows.size() - 1);
            //     lastRow.click();

            //     WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
            //     edit.click();

            // } else {
            //     System.out.println("No rows found.");
            // }

            
            // Thread.sleep(2000);

            // WebElement isActive = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='param[isActive]']")));
            // isActive.click();

            // WebElement editSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn bp-btn-save  ')]")));
            // editSave.click();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-positionList : " + e.getMessage());
            driver.quit();
        }
        finally{
            System.out.println("finished positionList");
        }
    }
}
