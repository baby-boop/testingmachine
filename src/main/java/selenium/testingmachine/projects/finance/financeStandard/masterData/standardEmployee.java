package selenium.testingmachine.projects.finance.financeStandard.masterData;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class standardEmployee {

    private WebDriver driver;

    public standardEmployee(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='1683702785861905']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement uragField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[urag]")));
            uragField.sendKeys("Халх");

            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[lastName]")));
            lastNameField.sendKeys("Галдан");

            WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[firstName]")));
            firstNameField.sendKeys("Бат-оргил");

            WebElement genderField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='gender']")));
            genderField.click();
            WebElement selectGender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Бусад']")));
            selectGender.click();
            
            Thread.sleep(500);

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='dateOfBirth']")));
            date.sendKeys("2000-05-10");

            WebElement secondLetterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("stateRegNumber_secondletter")));
            secondLetterDropdown.findElement(By.xpath(".//option[. = 'Н']")).click();
            WebElement firstLetterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("stateRegNumber_firstletter")));
            firstLetterDropdown.findElement(By.xpath(".//option[. = 'Б']")).click();

            WebElement regNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("stateRegNumber_numbers")));
            regNumber.sendKeys("00151018");

            WebElement departmentField = wait.until(ExpectedConditions.elementToBeClickable(By.name("departmentId_nameField")));
            departmentField.sendKeys("Мандал");
            departmentField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement positionField = wait.until(ExpectedConditions.elementToBeClickable(By.name("positionKeyId_nameField")));
            positionField.sendKeys("Хөгжүүлэгч");
            positionField.sendKeys(Keys.ENTER);
            
            Thread.sleep(500);
            
            WebElement workStartField = wait.until(ExpectedConditions.elementToBeClickable(By.name("param[workStartDate]")));
            workStartField.sendKeys("2024-07-26");
            

            WebElement startDateField = wait.until(ExpectedConditions.elementToBeClickable(By.name("param[startdate]")));
            startDateField.sendKeys("2024-07-26");


            WebElement checkbox = driver.findElement(By.id("param[isTalent]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
            Thread.sleep(1000);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(1000);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                
                WebElement cnclBtn = driver.findElement(By.className("ui-pnotify-closer"));                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.visibility='visible';", cnclBtn);
                Thread.sleep(1000);
                cnclBtn.click();

                Thread.sleep(3500);

                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn blue-madison btn-sm bp-close-btn bp-btn-close')]")));
                closeBtn.click();
                
                return;
            }

            ClassCounter.registerWorkingClass(this.getClass());



        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
    
}

