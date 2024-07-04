package selenium.testingmachine.hr.employee_directory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class prizeOfType {
    public static String message;

    private WebDriver driver;

    public prizeOfType(WebDriver driver) {
        this.driver = driver;
    }
    public void prize(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
            Thread.sleep(500);
            WebElement list = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Шагналын төрөл')]")));
            list.click(); 
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CODE]")));
            code.sendKeys("1");

            WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[REWARD_TYPE_NAME]")));
            type.sendKeys("test");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[REWARD_TYPE_NAME_PATH]")));
            name.sendKeys("test1");

            WebElement dname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[REWARD_TYPE_NAME_LEVEL]")));
            dname.sendKeys("test2");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            saveBtn.click();
            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);

                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
                return;
            }
            
            
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


            // Thread.sleep(1000);

            // WebElement editSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            // editSave.click();
            // if (isErrorMessagePresent(wait)) {
            //     System.out.println("Error message found after saving. Exiting...");
            //     return;
            // }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-prizeOfType : " + e.getMessage());
            // driver.quit();
        }finally{
            System.out.println("finished prizeOfType");
        }
    }
    
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = ("class-prizeOfType: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }
}
