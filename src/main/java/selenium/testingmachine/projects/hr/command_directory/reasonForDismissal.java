package selenium.testingmachine.projects.hr.command_directory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reasonForDismissal {
    public static String message;

    private WebDriver driver;

    public reasonForDismissal(WebDriver driver) {
        this.driver = driver;
    }
    public void reason(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(1000);
            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Мастер дата')]")));
            openField.click();

            WebElement openDirectory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Тушаалын лавлах')]")));
            openDirectory.click();
            Thread.sleep(500);

            WebElement list = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Ажлаас чөлөөлөх шалтгаан')]")));
            list.click(); 
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement bookType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[BOOK_TYPE_NAME]")));
            bookType.sendKeys("Бусад");

            WebElement quitjobType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[QUITJOB_TYPE_NAME]")));
            quitjobType.sendKeys("test");

            WebElement isNeccessary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[IS_NECCESSARY]")));
            isNeccessary.sendKeys("1");

            WebElement typeId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[BOOK_TYPE_ID]")));
            typeId.sendKeys("9073");

            WebElement quitjobName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C6]")));
            quitjobName.sendKeys("test2");

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
            System.out.println("Error class-reasonForDismissal : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished reasonForDismissal");
        }
    }
    
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = ("class-reasonForDismissal: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }    
}
