package selenium.testingmachine.hr.main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jobCandidates {
    private WebDriver driver;

    public jobCandidates(WebDriver driver) {
        this.driver = driver;
    }
    public void candidates(){

        try{

            Actions actions = new Actions(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Ажил горилогч')]")));
            openField.click();           

            WebElement showForm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Ажил горилогч бүртгэх')]")));
            showForm.click();

            WebElement urag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-process-id='17152424082723'] .col:nth-child(1) > .form-group:nth-child(1) .stringInit")));
            urag.sendKeys("Боржигон");

            WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-process-id='17152424082723'] .form-group:nth-child(2) .stringInit")));
            lastName.sendKeys("Болд");

            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-process-id='17152424082723'] .form-group:nth-child(3) > .col-md-9 > div > .form-control")));
            firstName.sendKeys("Мягмардорж");

            WebElement firstLetterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("stateRegNumber_firstletter")));
            firstLetterDropdown.findElement(By.xpath(".//option[. = 'Б']")).click();
            WebElement secondLetterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("stateRegNumber_secondletter")));
            secondLetterDropdown.findElement(By.xpath(".//option[. = 'Н']")).click();
            WebElement regNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("stateRegNumber_numbers")));
            regNumber.sendKeys("00251118");

            WebElement ageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[age]")));
            ageField.sendKeys("");

            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("s2id_param[driveId]")));
            searchBox.click();
            WebElement genderOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'B']")));
            genderOption.click();

            WebElement checkbox = driver.findElement(By.id("param[army]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
 
            WebElement selectPosition = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick=\"dataViewSelectableGrid('campaignKeyId', '17152424082723', '1465193884361', 'single', 'campaignKeyId', this);\"]")));
            selectPosition.click();
            // WebElement position = wait.until(ExpectedConditions.elementToBeClickable(By.id("datagrid-row-r3-2-1")));
            // actions.doubleClick(position).perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));
            if (!rows.isEmpty()) {
                WebElement lastRow = rows.get(0);
                actions.doubleClick(lastRow).perform();
           
            } else {
                System.out.println("No rows found.");
            }
  
            WebElement sourceField = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[channelId]")));
            sourceField.click();
            WebElement selectSource = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Вэб сайт']")));
            selectSource.click();

            WebElement startSalaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='startSalary']")));
            startSalaryField.sendKeys("1000000");

            WebElement endSalaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='endSalary']")));
            endSalaryField.sendKeys("2000000");

            WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='phoneNumber']")));
            phoneField.sendKeys("99119669");

            WebElement mailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='email']")));
            mailField.sendKeys("myagmar07@gmail.com");

            WebElement otherField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='mobileNumber']")));
            otherField.sendKeys("89991143");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bpMainSaveButton")));
            saveBtn.click();

            // Thread.sleep(5000);
            System.out.println("Candidates successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("error class-candidates : " + e.getMessage());
            driver.quit();
        } finally {

            System.out.println("Candidates finished");
        }
    }
}