package selenium.testingmachine.projects.hr_salary.master_data;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ErrorUtils;

public class salaryCalculatorMonth {

    private WebDriver driver;

    public salaryCalculatorMonth(WebDriver driver) {
        this.driver = driver;
    }
    public void calculatorMonth(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
            Thread.sleep(2000);

            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Мастер дата')]")));
            openField.click();

            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement order = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[calcOrder]")));
            order.sendKeys("1");

            WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='calcCode'] input[name='param[calcCode]']")));
            code.sendKeys("1");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='calcName'] input[name='param[calcName]']")));
            name.sendKeys("test");

            WebElement year = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='year']")));
            year.click();
            WebElement yearOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='2024 он']")));
            yearOption.click();

            Thread.sleep(500);

            WebElement month = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='month']")));
            month.click();
            WebElement monthOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='6-р сар']")));
            monthOption.click();

            Thread.sleep(500);

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='startDate']")));
            startDate.sendKeys("2024-06-07");

            WebElement endDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='endDate']")));
            endDate.sendKeys("2024-06-18");

            WebElement calcDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='calcDate']")));
            calcDate.sendKeys("2024-06-20");

            // WebElement shortName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[shortName]")));
            // shortName.sendKeys("test");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();    

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                
                
                WebElement cnclBtn = driver.findElement(By.className("ui-pnotify-closer"));                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.visibility='visible';", cnclBtn);
                Thread.sleep(1000);
                cnclBtn.click();

                Thread.sleep(3500);

                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn blue-madison btn-sm bp-close-btn bp-btn-close')]")));
                closeBtn.click();
                
                return;
            }
            
            
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            // List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            // if (!rows.isEmpty()) {
            //     WebElement firstRow = rows.get(0);
            //     firstRow.click();

            //     WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
            //     edit.click();

            // } else {
            //     System.out.println("No rows found.");
            // }

            // Thread.sleep(1000);

            // WebElement editSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            // editSave.click();

            // if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
            //     System.out.println("Error message found after saving. Exiting...");
            //     Thread.sleep(3500);
                
            //     WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
            //     cnclBtn.click();
            //     return;
            // }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
 }