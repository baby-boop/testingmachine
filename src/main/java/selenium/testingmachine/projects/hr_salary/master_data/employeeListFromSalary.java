package selenium.testingmachine.projects.hr_salary.master_data;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ErrorUtils;

public class employeeListFromSalary {

    private WebDriver driver;

    public employeeListFromSalary(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='1683702785861905']")));
            menu.click(); 

            Thread.sleep(2000);

            WebElement addBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            addBtn.click();

            Thread.sleep(2000);

            WebElement ovogNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[urag]")));
            ovogNameField.sendKeys("test");

            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[lastName]")));
            lastNameField.sendKeys("test");

            WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[firstName]")));
            firstNameField.sendKeys("test");

            WebElement genderField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='gender']")));
            genderField.click();
            WebElement genderOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Бусад']")));
            genderOption.click();

            Thread.sleep(500);

            WebElement birthDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='dateOfBirth']")));
            birthDateField.sendKeys("2000-05-10");

            Thread.sleep(500);

            WebElement firstLetterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("stateRegNumber_firstletter")));
            firstLetterDropdown.findElement(By.xpath(".//option[. = 'Б']")).click();
            WebElement secondLetterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("stateRegNumber_secondletter")));
            secondLetterDropdown.findElement(By.xpath(".//option[. = 'Н']")).click();

            WebElement regNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("stateRegNumber_numbers")));
            regNumber.sendKeys("00151019");

            WebElement departmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("departmentId_nameField")));
            departmentField.sendKeys("Гүйцэтгэх цех");
            departmentField.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            WebElement positionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("positionKeyId_nameField")));
            positionField.sendKeys("Нэвтрүүлэлтийг мэргэжилтэн");
            positionField.sendKeys(Keys.ENTER);
            Thread.sleep(2000);

            WebElement workStartDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='workStartDate']")));
            workStartDate.sendKeys("2024-06-07");

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='startdate']")));
            startDate.sendKeys("2024-06-18");


            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();    

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();

                // WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn blue-madison btn-sm bp-close-btn bp-btn-close')]")));
                // closeBtn.click();
                
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