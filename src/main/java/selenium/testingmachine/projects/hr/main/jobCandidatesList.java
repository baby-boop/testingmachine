package selenium.testingmachine.projects.hr.main;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class jobCandidatesList {

    private WebDriver driver;

    public jobCandidatesList(WebDriver driver) {
        this.driver = driver;
    }
    public void candidate() {

        try {

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000); 

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17152424142583']")));
            menu.click();

            Thread.sleep(2000); 

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            if (!rows.isEmpty()) {
                Thread.sleep(500);
                WebElement lastRow = rows.get(rows.size() - 1);

                Thread.sleep(1000);

                WebElement cell = lastRow.findElement(By.xpath(".//td[1]")); 
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                actions.moveToElement(cell).click().perform();

                WebElement editBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
                editBtn.click();
            }else {
                System.out.println("No rows found.");
            }

            Thread.sleep(1000);

            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.bp-btn-save")));
            saveButton.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeMessageBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".brighttheme-icon-closer")));
                closeMessageBtn.click();

                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn blue-madison btn-sm bp-close-btn bp-btn-close')]")));
                closeButton.click();

                return;
            }

            Thread.sleep(1000);

            ClassCounter.registerWorkingClass(this.getClass());


        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
}