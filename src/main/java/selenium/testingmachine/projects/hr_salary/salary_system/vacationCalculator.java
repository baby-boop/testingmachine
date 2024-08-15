package selenium.testingmachine.projects.hr_salary.salary_system;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ErrorUtils;

public class vacationCalculator {

    private WebDriver driver;

    public vacationCalculator(WebDriver driver) {
        this.driver = driver;
    }
    public void main() {
        try {
            
            Thread.sleep(500);

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Бүртгэл')]")));
            main.click();

            Thread.sleep(2000);

            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='17138573334821")));
            link.click();

            Thread.sleep(2000);

            WebElement addBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            addBtn.click();

            Thread.sleep(2000);

            WebElement employeeField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".middle #employeeId_nameField")));
            employeeField.sendKeys("Галдан Бат-оргил");
            employeeField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement numberField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='calcId']")));
            numberField.click();
            WebElement numberOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='2023081']")));
            numberOption.click();

            Thread.sleep(500);

            WebElement salaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f182']")));
            salaryField.sendKeys("1800000");

            WebElement yearField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f131']")));
            yearField.sendKeys("2");

            WebElement coupenField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f398']")));
            coupenField.sendKeys("100000");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
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