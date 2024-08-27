package selenium.testingmachine.projects.hr.command_directory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class reasonForDismissal {
    public static String message;

    private WebDriver driver;

    public reasonForDismissal(WebDriver driver) {
        this.driver = driver;
    }
    public void reason(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement openDirectory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Тушаалын лавлах')]")));
            openDirectory.click();

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17145598883101']")));
            menu.click(); 

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

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

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                
                Thread.sleep(3500);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm blue-hoki bp-btn-close')]")));
                closeBtn.click();

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

            Thread.sleep(2000);

            ClassCounter.registerWorkingClass(this.getClass());
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
}
