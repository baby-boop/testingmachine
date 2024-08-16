package selenium.testingmachine.projects.store.masterdata;

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

public class customer {

    private WebDriver driver;

    public customer(WebDriver driver) {
        this.driver = driver;
    }
    public void data(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17138547812201']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            Thread.sleep(2000);

            WebElement customerCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CUSTOMER_CODE]")));
            customerCodeField.sendKeys("10022");

            WebElement lastnameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[LAST_NAME]")));
            lastnameField.sendKeys("test1");

            WebElement firstnameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[CUSTOMER_NAME]")));
            firstnameField.sendKeys("test1");

            WebElement parentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[PARENT_ID_DESCNAME]")));
            parentField.sendKeys("test1");
            parentField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

            WebElement customerGroup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='CUSTOMER_GROUP_ID']")));
            customerGroup.click();
            Thread.sleep(500);
            WebElement customerGroupOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Бусад']")));
            customerGroupOption.click();

            Thread.sleep(500);

            WebElement register = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[STATE_REG_NUMBER]")));
            register.sendKeys("4");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();
            Thread.sleep(1000);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17138547812201 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);

            WebElement openOther = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Бусад')]")));
            openOther.click();

            Thread.sleep(2000);

            WebElement vatNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.VAT_NUMBER]")));
            vatNumberField.sendKeys("112211");

            // WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='C2.COUNTRY_ID']")));
            // cityField.click();
            // Thread.sleep(500); //data bhgu
            // WebElement cityFieldOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Бусад']")));
            // cityFieldOption.click();

            WebElement englishNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.NAME_ENGLISH]")));
            englishNameField.sendKeys("test");

            WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.PHONE_NUMBER]")));
            phoneNumberField.sendKeys("99119911");

            WebElement phoneNumber1Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.PHONE_NUMBER1]")));
            phoneNumber1Field.sendKeys("99119911");

            WebElement phoneNumber2Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.PHONE_NUMBER2]")));
            phoneNumber2Field.sendKeys("99119911");
           
            WebElement registrationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.REGISTRATION_NUMBER]")));
            registrationField.sendKeys("112211");

            WebElement faxField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.FAX]")));
            faxField.sendKeys("test@gmail.com");

            WebElement webField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.WEBSITE]")));
            webField.sendKeys("test");

            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.EMAIL]")));
            emailField.sendKeys("test@gmail.com");

            WebElement birthdayField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.BIRTH_DATE]")));
            birthdayField.sendKeys("2002-05-01");

            WebElement genderField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.GENDER]")));
            genderField.sendKeys("gender");

            WebElement startDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.ACTIVITY_START_DATE]")));
            startDateField.sendKeys("2024-07-02");

            WebElement establishedDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.ESTABLISHED_DATE]")));
            establishedDateField.sendKeys("2002-05-01");

            WebElement MainId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-valuemap-17138547812201")));

            WebElement productNextSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(MainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            productNextSaveBtn.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17138547812201 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);

            WebElement bankInformationMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='191725252']")));
            bankInformationMenu.click();
                        
            Thread.sleep(2000);
            
            WebElement addRow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action-path='C2']")));
            addRow.click();

            Thread.sleep(1000);

            WebElement bankTypeField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='C2.BANK_ID']")));
            bankTypeField.click();
            Thread.sleep(500);
            WebElement bankTypeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='ХАС БАНК']")));
            bankTypeOption.click();
            Thread.sleep(500);

            // WebElement bankNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C159][3]")));
            // bankNumberField.sendKeys("");

            // WebElement accountTypeField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='C2.BANK_ACCOUNT_TYPE_ID']")));
            // accountTypeField.click();
            // Thread.sleep(500); 
            // WebElement accountTypeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='ХАС БАНК']")));
            // accountTypeOption.click();
            // Thread.sleep(500);

            WebElement bankDescriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.DESCRIPTION][0]")));
            bankDescriptionField.sendKeys("testshuu");

            WebElement customerNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.CUSTOMER_NAME][0]")));
            customerNameField.sendKeys("test");

            WebElement currencyField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='C2.CURRENCY_ID']")));
            currencyField.click();
            Thread.sleep(500); 
            WebElement currencyOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Зээлжих тусгай эрх']")));
            currencyOption.click();
            
            Thread.sleep(1000);

            WebElement nextSaveBtn1 = wait.until(ExpectedConditions.elementToBeClickable(MainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            nextSaveBtn1.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17138547812201 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);

            WebElement relatedPersonMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='191725252']")));
            relatedPersonMenu.click();
                        
            Thread.sleep(2000);
            
            WebElement addRowPerson = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action-path='C2']")));
            addRowPerson.click();

            Thread.sleep(1000);

            WebElement personLastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.LAST_NAME][0]")));
            personLastNameField.sendKeys("test");

            WebElement personFirstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.FIRST_NAME][0]")));
            personFirstNameField.sendKeys("test");

            WebElement personPhoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.PHONE_NUMBER1][0]")));
            personPhoneField.sendKeys("99119911");

            WebElement personEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.EMAIL1][0]")));
            personEmailField.sendKeys("test@gmail.com");

            // WebElement personPositionField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='C2.POSITION_ID']")));
            // personPositionField.click();
            // Thread.sleep(500); 
            // WebElement personPositionOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Зээлжих тусгай эрх']")));
            // personPositionOption.click();
            
            Thread.sleep(1000);

            WebElement nextSaveBtn2 = wait.until(ExpectedConditions.elementToBeClickable(MainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            nextSaveBtn2.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17138547812201 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);


            WebElement typenMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='191731474']")));
            typenMenu.click();
                        
            Thread.sleep(2000);
            
            WebElement addRowType = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action-path='C2']")));
            addRowType.click();

            Thread.sleep(1000);

            WebElement typeField1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='C2.CUSTOMER_TYPE_ID']")));
            typeField1.click();
            Thread.sleep(500); 
            WebElement typeField1Option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Ажилтан']")));
            typeField1Option.click();

            Thread.sleep(500);

            WebElement nextSaveBtn3 = wait.until(ExpectedConditions.elementToBeClickable(MainId.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));          
            nextSaveBtn3.click();

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(4000);
                
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17138547812201 .mb-1 .far")));
                closeBtn.click();
                return;
            }

            Thread.sleep(4000);

            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dialog-valuemap-17138547812201 .mb-1 .far")));
            closeBtn.click();

            Thread.sleep(1000);

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

