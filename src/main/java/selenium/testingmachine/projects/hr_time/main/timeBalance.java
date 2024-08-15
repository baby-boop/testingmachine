package selenium.testingmachine.projects.hr_time.main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ErrorUtils;

public class timeBalance {

    private WebDriver driver;

    public timeBalance(WebDriver driver) {
        this.driver = driver;
    }
    public void main() {
        try {
            
            Thread.sleep(500);

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Цагийн баланс')]")));
            main.click();

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='16293670316521")));
            menu.click();

            Thread.sleep(2000);

            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-circle btn-sm btn-success float-left search-tms-btn')]")));
            searchBtn.click();

            Thread.sleep(4000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            if (!rows.isEmpty()) {
                Thread.sleep(500);
                WebElement firstRow = rows.get(rows.size() - 1);
                System.out.println("first row text: " + firstRow.getText());

                Thread.sleep(1000);
        
                WebElement cell = firstRow.findElement(By.xpath(".//td[1]")); 
        
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                 actions.moveToElement(cell).click().perform();
        
                 WebElement calculatorBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm blue btn-circle float-left downloadDataIO')]")));
                 calculatorBtn.click();

                 Thread.sleep(2000);

            }else {
                System.out.println("No rows found.");
            }

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                return;
            }
            
    
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
}