package selenium.testingmachine.hr_salary.salary_system;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class prlSalaryCalculator {

    public static @MessageField String message;

    private WebDriver driver;

    public prlSalaryCalculator(WebDriver driver) {
        this.driver = driver;
    }
    public void calculator() {
        try {
            
            Thread.sleep(500);

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(1000);

            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='17152417917853")));
            link.click();

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement checkBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            checkBtn.click();
            Thread.sleep(1000);

            WebElement selectEmployee = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".middle #employeeId_nameField")));
            selectEmployee.sendKeys("Галдан Бат-оргил");
            selectEmployee.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement code = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[calcId]")));
            code.click();
            WebElement codeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='2023081']")));
            codeOption.click();

            WebElement salary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f182']")));
            salary.sendKeys("1800000");

            WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f183']")));
            year.sendKeys("66");

            WebElement workYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f131']")));
            workYear.sendKeys("2");

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f189']")));
            startDate.sendKeys("2024-06-07");

            WebElement endDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f190']")));
            endDate.sendKeys("2024-06-18");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
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
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            WebElement errorTitle = driver.findElement(By.cssSelector(".ui-pnotify-title"));
            String errorTitleText = errorTitle.getText();
            if (errorTitleText.contains("warning") || errorTitleText.contains("error")) {
                try {
                    wait.withTimeout(Duration.ofSeconds(2));
                    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-pnotify-text")));
                    String errorText = errorMessage.getText();
                    
                    String processName = "";
                    try {
                        WebElement mainProcess = driver.findElement(By.cssSelector("div.mb-1.d-flex.justify-content-between > p"));
                        processName = mainProcess.getText();
                    } catch (Exception e) {
                        System.out.println("Process name element not found: " + this.getClass().getName() + e.getMessage());
                    }
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " -" +"<br>Алдаа: " + errorText;
                            
                    return errorMessage.isDisplayed();
                } catch (Exception e) {
                    System.out.println("Error while checking for error message: " + e.getMessage());
                    return false;
                } finally {
                    wait.withTimeout(Duration.ofSeconds(30));
                }
            }else{
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Error while checking for error title: " + e.getMessage());
            return false;
        }
    }
    
}
