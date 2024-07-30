package selenium.testingmachine.hr.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class employeeManagement {
    
    public static @MessageField String message;

    private WebDriver driver;

    public employeeManagement(WebDriver driver) {
        this.driver = driver;
    }
    public void employee() {
        try {
            
            Thread.sleep(2000);

            Actions actions = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-modulename='Core HR']")));
            menuTileElement.click();

            Thread.sleep(3500);
            
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

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save ')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                // WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-16911711539839 .mb-1 .far")));
                // closeBtn.click();
                return;
            }
            Thread.sleep(4000);


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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Ажилтан бүртгэх" +"<br>Алдаа: " + errorText;
                            
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
