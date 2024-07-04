package selenium.testingmachine.hr.main;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jobCandidatesList {
    private WebDriver driver;

    public jobCandidatesList(WebDriver driver) {
        this.driver = driver;
    }
    public void candidate() {

        try {

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement openFields = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Ажил горилогчын жагсаалт')]")));
            openFields.click();

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

            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.bp-btn-save")));
            saveButton.click();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("error class-candidatesList : " + e.getMessage());
            driver.quit();
        } finally {
            System.out.println("candidatesList finished");
        }
    }
}
