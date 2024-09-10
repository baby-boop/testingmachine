package selenium.testingmachine.testJson;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class lastRowEditAndDelete {
    private WebDriver driver;

    public lastRowEditAndDelete(WebDriver driver) {
        this.driver = driver;
    }
    

    public void crud() {
        try{
            WebDriverWait wait = configController.getWebDriverWait(driver);

            Thread.sleep(2000);

            WebElement addSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            addSaveBtn.click();

            Thread.sleep(3000);
            

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            if (!rows.isEmpty()) {
                Thread.sleep(500);
                WebElement firstRow = rows.get(0);
                Actions actions = new Actions(driver);
                System.out.println("Last row text: " + firstRow.getText());

                Thread.sleep(1000);
        
                WebElement cell = firstRow.findElement(By.xpath(".//td[1]")); 
        
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                 actions.moveToElement(cell).click().perform();
        
                WebElement rowSelectBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
                rowSelectBtn.click();

                Thread.sleep(2000);

                WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
                saveBtn.click();

                Thread.sleep(2000);

                if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                    System.out.println("Error message found after saving. Exiting...");
                    Thread.sleep(3500);
                    
                    WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm blue-hoki bp-btn-close')]")));
                    cnclBtn.click();
                }
            }else {
                System.out.println("No rows found.");
            }

            Thread.sleep(2000);
            WebElement rowDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Устгах")));
            rowDelete.click();

            Thread.sleep(3000);

            if (isDelete(wait)) {

                if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                    System.out.println("Error message found after saving. Exiting...");
                    Thread.sleep(3500);
                }
                return;
            }

            Thread.sleep(3500);

        }catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        } finally {
            System.out.println("Finished processing last row.");
        }
    }

    private boolean isDelete(WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-describedby='dialog-kpiindicatorvalue-confirm']")));
    
            WebElement noButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Тийм')]")));
            noButton.click();
    
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
