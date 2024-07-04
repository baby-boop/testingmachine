package selenium.testingmachine.hr.main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class employeeList {
    private WebDriver driver;

    public employeeList(WebDriver driver) {
        this.driver = driver;
    }

    public void employees() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(500);
            WebElement openFields = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Ажилтны жагсаалт')]")));
            openFields.click();

            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
            firstName.sendKeys("Галдан");
            WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname")));
            lastName.sendKeys("Бат-оргил");


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));
            if (!rows.isEmpty()) {
                WebElement lastRow = rows.get(rows.size() - 1);
                lastRow.click();
    
                WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
                edit.click();
           
            } else {
                System.out.println("No rows found.");
            }

            WebElement salary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HRMEMPLOYEEKEY.salary']")));
            salary.sendKeys("1800000");
            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='contractStartDate']")));
            date.sendKeys("2021-02-04");
            
            WebElement salaryType = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[salaryTypeId]")));
            salaryType.click();
            WebElement selectSalary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Өдрөөр']")));
            selectSalary.click();

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bpMainSaveButton")));
            saveBtn.click();
            
            // if (isErrorMessagePresent(wait)) {
            //     System.out.println("Error message found after saving. Exiting...");
            //     return;
            // }

            Thread.sleep(5000);

            WebElement nextWorkspace = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='nav-link' and span[contains(text(),'Ерөнхий')]]")));
            nextWorkspace.click();

            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[socialOriginId]")));
            searchBox.click();
            WebElement genderOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Сэхээтэн']")));
            genderOption.click();

            WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='lastNameEng'] input[name='param[lastNameEng]']")));
            lastname.sendKeys("Galdan");

            WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='firstNameEng'] input[name='param[firstNameEng]']")));
            firstname.sendKeys("Bat-orgil");

            WebElement cityBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[birthCountryId]")));
            cityBox.click();
            WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Монгол']")));
            cityOption.click();

            WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[cityId]")));
            country.click();
            WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Улаанбаатар']")));
            countryOption.click();

            WebElement education = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[educationLevelId]")));
            education.click();
            WebElement educationOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Дээд']")));
            educationOption.click();

            WebElement marital = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[maritalStatusId]")));
            marital.click();
            WebElement maritalOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Гэрлээгүй']")));
            maritalOption.click();

            WebElement noOfFamilyMember = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='noOfFamilyMember'] input[name='param[noOfFamilyMember]']")));
            noOfFamilyMember.sendKeys("3");

            WebElement noOfChildren = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='noOfChildren'] input[name='param[noOfChildren]']")));
            noOfChildren.sendKeys("2");

            WebElement bloodType = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[bloodTypeId]")));
            bloodType.click();
            WebElement bloodTypeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'A']")));
            bloodTypeOption.click();

            WebElement employeeMobile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='employeeMobile'] input[name='param[employeeMobile]']")));
            employeeMobile.sendKeys("88899811");

            WebElement employeePhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='employeePhone'] input[name='param[employeePhone]']")));
            employeePhone.sendKeys("77117766");

            WebElement employeeEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='employeeEmail'] input[name='param[employeeEmail]']")));
            employeeEmail.sendKeys("test1@gmail.com");

            WebElement emergencyContact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='emergencyContact'] input[name='param[emergencyContact]']")));
            emergencyContact.sendKeys("99119911");

            WebElement contactNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='contactNumber'] input[name='param[contactNumber]']")));
            contactNumber.sendKeys("96691144");

            WebElement postAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='postAddress'] input[name='param[postAddress]']")));
            postAddress.sendKeys("bat.orgil@gmail.com");

            // WebElement originType = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[originId]")));
            // originType.click();
            // WebElement originOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'select2-result-label') and text() = 'Халх']")));
            // originOption.click();

            WebElement nextSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#bp-window-16842268181969 > #wsForm .bpMainSaveButton")));
            nextSaveBtn.click();

            Thread.sleep(5000);

            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ui-dialog-titlebar-close")));
            closeButton.click();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error class-employeeList : " + e.getMessage());
            driver.quit();
        } finally {
            System.out.println("employeeList finished");
        }
    }
    // private boolean isErrorMessagePresent(WebDriverWait wait) {
    //     try {
    //         wait.withTimeout(Duration.ofSeconds(2));
    //         WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-pnotify.ui-pnotify-fade-fast.ui-pnotify-mobile-able.ui-pnotify-in.ui-pnotify-fade-in.ui-pnotify-move .ui-pnotify-text")));
    //         String errorText = errorMessage.getText();
    //         WebElement mainProccess = driver.findElement(By.xpath("//div[@class='ui-dialog-title']/span"));
    //         String processName = mainProccess.getText();
    //         System.out.println("class-jobDismissed: "+ this.getClass().getName() + "processName="+processName + "Алдаа: " + errorText);
    //         return errorMessage.isDisplayed();
    //     } catch (Exception e) {
    //         return false;
    //     } finally {
    //         wait.withTimeout(Duration.ofSeconds(10));
    //     }
    // }
}
