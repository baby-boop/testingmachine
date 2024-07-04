package selenium.testingmachine.hr.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class employeeManagement {
    private WebDriver driver;

    public employeeManagement(WebDriver driver) {
        this.driver = driver;
    }
    public void employee() {
        try {
            
            Thread.sleep(500);

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            WebElement uragField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[urag]")));
            uragField.sendKeys("Халх");

            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[lastName]")));
            lastNameField.sendKeys("Галдан");

            WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[firstName]")));
            firstNameField.sendKeys("Бат-оргил");

            WebElement genderField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.select2-choice")));
            genderField.click();
            WebElement selectGender = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#select2-result-label-14")));
            selectGender.click();

            // WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.input-group-btn > button")));
            // dateField.click();
            // WebElement selectDate = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("th.today")));
            // selectDate.click();
            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='dateOfBirth']")));
            date.sendKeys("2000-05-10");

            WebElement secondLetterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("stateRegNumber_secondletter")));
            secondLetterDropdown.findElement(By.xpath(".//option[. = 'Н']")).click();
            WebElement firstLetterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("stateRegNumber_firstletter")));
            firstLetterDropdown.findElement(By.xpath(".//option[. = 'Б']")).click();

            WebElement regNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("stateRegNumber_numbers")));
            regNumber.sendKeys("00151018");

            // WebElement departmentField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".form-group:nth-child(1) .far")));
            // departmentField.click();
            // WebElement downField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".tree-hit")));
            // downField.click();
            // WebElement selectDepartment = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#datagrid-row-r107-2-1718009022401629 .tree-title")));
            // actions.doubleClick(selectDepartment).perform();

            WebElement positionField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".form-group:nth-child(2) .far")));
            positionField.click();
            WebElement selectPostion = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#datagrid-row-r1-2-1 > td:nth-child(3)")));
            actions.doubleClick(selectPostion).perform();

            WebElement workStartField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".form-group:nth-child(1) .dateElement .btn")));
            workStartField.click();
            WebElement startDate = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".datepicker-days tfoot .today")));
            startDate.click();

            WebElement workEndField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-md-12:nth-child(2) .form-group:nth-child(2) .fal:nth-child(1)")));
            workEndField.click();
            WebElement endDate = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".datepicker-days tfoot .today")));
            endDate.click();

            WebElement checkbox = driver.findElement(By.id("param[isTalent]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bpMainSaveButton")));
            saveBtn.click();
            Thread.sleep(3000);
            System.out.println("HR successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error class-employeeManagement : " + e.getMessage());
            driver.quit();
        } finally {
            // driver.quit();
            System.out.println("HR finished");

        }
    }

}
