package selenium.testingmachine.hr_salary.salary_system;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class vacationCalculator {
    public static String message;

    private WebDriver driver;

    public vacationCalculator(WebDriver driver) {
        this.driver = driver;
    }
    public void calculator() {
        try {
            
            Thread.sleep(500);

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Бүртгэл')]")));
            main.click();

            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='17138573334821")));
            link.click();

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement checkBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            checkBtn.click();
            Thread.sleep(1000);

            // WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("employeeId_nameField")));
            // name.sendKeys("Галдан Бат-оргил");
            // name.sendKeys(Keys.ENTER);

            WebElement selectEmployee = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".middle .far")));
            selectEmployee.click();

            Thread.sleep(2000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));
            if (!rows.isEmpty()) {
                WebElement firstRow = rows.get(0);
                actions.doubleClick(firstRow).perform();
           
            } else {
                System.out.println("No rows found.");
            }

            WebElement code = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[calcId]")));
            code.click();

            WebElement codeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='2023081']")));
            codeOption.click();

            WebElement salary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f182']")));
            salary.sendKeys("1800000");

            WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f131']")));
            year.sendKeys("2");

            WebElement coupen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='f131']")));
            coupen.sendKeys("100000");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
                return;
            }
            
    
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-vacationCalculator : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished vacationCalculator");
        }

    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            
            wait.withTimeout(Duration.ofSeconds(2));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme-error .ui-pnotify-text")));
            String errorText = errorMessage.getText();
            WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/span"));
            String processName = mainProccess.getText();
            message = ("class-vacationCalculator: "+ this.getClass().getName() + "   processName= "+processName + "   Алдаа: " + errorText);
            System.out.println(message);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            wait.withTimeout(Duration.ofSeconds(10));
        }
    }       

}
