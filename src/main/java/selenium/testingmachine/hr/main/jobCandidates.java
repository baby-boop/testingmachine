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

public class jobCandidates {
    public static @MessageField String message;

    private WebDriver driver;

    public jobCandidates(WebDriver driver) {
        this.driver = driver;
    }
    public void candidates(){

        try{

            Actions actions = new Actions(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Ажил горилогч')]")));
            openField.click();         
            
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17152424082723']")));
            menu.click(); 

            Thread.sleep(2000);

            WebElement urag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[urag]")));
            urag.sendKeys("Боржигон");

            WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[lastName]")));
            lastName.sendKeys("Болд");

            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[firstName]")));
            firstName.sendKeys("Мягмардорж");

            WebElement firstLetterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("stateRegNumber_firstletter")));
            firstLetterDropdown.findElement(By.xpath(".//option[. = 'Б']")).click();
            WebElement secondLetterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("stateRegNumber_secondletter")));
            secondLetterDropdown.findElement(By.xpath(".//option[. = 'Н']")).click();
            WebElement regNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("stateRegNumber_numbers")));
            regNumber.sendKeys("00251118");

            WebElement ageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[age]")));
            ageField.sendKeys("");

            Thread.sleep(1000);
            
            WebElement driverField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-s-path='driveId']")));
            driverField.click();
            WebElement driverOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='BC']")));
            driverOption.click();


            WebElement armyField = driver.findElement(By.id("param[army]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", armyField);
 
            WebElement positionField = wait.until(ExpectedConditions.elementToBeClickable(By.name("campaignKeyId_nameField")));
            positionField.sendKeys("Хөгжүүлэгч");
            positionField.sendKeys(Keys.ENTER);

            Thread.sleep(500);
  
            WebElement sourceField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='channelId']")));
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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Ажил горилогч бүртгэх" +"<br>Алдаа: " + errorText;
                            
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