package selenium.testingmachine.projects.hr.main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

public class employeeList {

    static {
            ClassCounter.registerWorkingClass(employeeList.class);
        }

    private WebDriver driver;

    public employeeList(WebDriver driver) {
        this.driver = driver;
    }

    public void employees() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            // WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-modulename='Core HR']")));
            // menuTileElement.click();//

            // Thread.sleep(3500);//

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='1683702785861905']")));
            menu.click(); 

            Thread.sleep(2000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            if (!rows.isEmpty()) {
                Thread.sleep(500);
                WebElement lastRow = rows.get(rows.size() - 1);
                Actions actions = new Actions(driver);

                Thread.sleep(1000);

                WebElement cell = lastRow.findElement(By.xpath(".//td[1]")); 
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                actions.moveToElement(cell).click().perform();

                WebElement editBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
                editBtn.click();
            }else {
                System.out.println("No rows found.");
            }

            

            Thread.sleep(3000);

            WebElement salaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HRMEMPLOYEEKEY.salary']")));
            salaryField.sendKeys("1800000");

            WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='contractStartDate']")));
            dateField.sendKeys("2021-02-04");

            Thread.sleep(2000);
            
            WebElement salaryType = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='salaryTypeId']")));
            salaryType.click();
            WebElement selectSalary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Өдрөөр']")));
            selectSalary.click();

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bpMainSaveButton")));
            saveBtn.click();

            Thread.sleep(2000);
            
            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                
                WebElement closeMessageBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".brighttheme-icon-closer")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", closeMessageBtn);
                closeMessageBtn.click();
                // return;
            }
            // Thread.sleep(2000);

            // WebElement nextWorkspace = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[span[contains(text(), 'Ерөнхий')]]")));
            // nextWorkspace.click();

            // Thread.sleep(2000);

            // if (isSaveConfirmationDialogPresent(wait)) {
            //     WebElement noButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Үгүй')]")));
            //     noButton.click();

            //     Thread.sleep(2000);
                
            //     WebElement CheckBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[span[contains(text(), 'Ерөнхий')]]")));
            //     CheckBtn.click();
            // }

            // Thread.sleep(3000);

            // WebElement socialOrgininField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='socialOriginId']")));
            // socialOrgininField.click();
            // WebElement socialOriginOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Сэхээтэн']")));
            // socialOriginOption.click();

            // WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='lastNameEng'] input[name='param[lastNameEng]']")));
            // lastname.sendKeys("Galdan");

            // WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='firstNameEng'] input[name='param[firstNameEng]']")));
            // firstname.sendKeys("Bat-orgil");

            // WebElement cityBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='birthCountryId'")));
            // cityBox.click();
            // WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Монгол']")));
            // cityOption.click();


            // WebElement countryField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='cityId'")));
            // countryField.click();
            // WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Улаанбаатар']")));
            // countryOption.click();

            // WebElement educationField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='educationLevelId'")));
            // educationField.click();
            // WebElement educationOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Дээд']")));
            // educationOption.click();

            // WebElement maritalField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='maritalStatusId'")));
            // maritalField.click();
            // WebElement maritalOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Гэрлээгүй']")));
            // maritalOption.click();

            // WebElement noOfFamilyMember = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='noOfFamilyMember'] input[name='param[noOfFamilyMember]']")));
            // noOfFamilyMember.sendKeys("3");

            // WebElement noOfChildren = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='noOfChildren'] input[name='param[noOfChildren]']")));
            // noOfChildren.sendKeys("2");

            // WebElement bloodTypeField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='bloodTypeId'")));
            // bloodTypeField.click();
            // WebElement bloodTypeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'A']")));
            // bloodTypeOption.click();

            // WebElement employeeMobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='employeeMobile'] input[name='param[employeeMobile]']")));
            // employeeMobileField.sendKeys("88899811");

            // WebElement employeePhoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='employeePhone'] input[name='param[employeePhone]']")));
            // employeePhoneField.sendKeys("77117766");

            // WebElement employeeEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='employeeEmail'] input[name='param[employeeEmail]']")));
            // employeeEmail.sendKeys("test1@gmail.com");

            // WebElement emergencyContactField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='emergencyContact'] input[name='param[emergencyContact]']")));
            // emergencyContactField.sendKeys("99119911");

            // WebElement contactNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='contactNumber'] input[name='param[contactNumber]']")));
            // contactNumberField.sendKeys("96691144");

            // WebElement postAddressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='postAddress'] input[name='param[postAddress]']")));
            // postAddressField.sendKeys("bat.orgil@gmail.com");

            // // WebElement originType = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[originId]")));
            // // originType.click();
            // // WebElement originOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Халх']")));
            // // originOption.click();

            // WebElement nextSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#bp-window-16842268181969 > #wsForm .bpMainSaveButton")));
            // nextSaveBtn.click();

            // if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
            //     System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
            //     Thread.sleep(3000);
                
            //     WebElement closeMessageBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".brighttheme-icon-closer")));
            //     closeMessageBtn.click();
            //     return;
            // }

            // Thread.sleep(4000);
            Thread.sleep(2000);

            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ui-dialog-titlebar-close")));
            closeButton.click();

            Thread.sleep(1000);

            ClassCounter.registerWorkingClass(this.getClass());

        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }

    
    private boolean isSaveConfirmationDialogPresent(WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-describedby='workspace-save-confirm']")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
