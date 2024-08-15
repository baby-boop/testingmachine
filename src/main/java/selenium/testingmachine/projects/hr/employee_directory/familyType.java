package selenium.testingmachine.projects.hr.employee_directory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class familyType {
    private WebDriver driver;

    public familyType(WebDriver driver) {
        this.driver = driver;
    }
    public void types(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(500);

            WebElement list = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Гэр бүлийн гишүүн')]")));
            list.click(); 
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CODE]")));
            type.sendKeys("test2");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
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

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[RELATIONSHIP_NAME]")));
            name.sendKeys("test1");

            Thread.sleep(1000);

            WebElement editSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            editSave.click();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-familyType : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished familyType");
        }
    }    
}
