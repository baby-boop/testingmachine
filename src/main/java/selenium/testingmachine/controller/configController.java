package selenium.testingmachine.controller;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@Slf4j
public class configController {

    public static final String URL = "https://cloud.veritech.mn/login";
    public static final String USERNAME = "testshuu@gmail.com";
    public static final String PASSWORD = "VrCloud@123";
    public static final int TIMEOUT = 10;


    public static WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public static void setModule(WebDriver driver, String moduleName) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

            WebElement moduleTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-modulename='" + moduleName + "']")));
            moduleTitleElement.click();

    }

    public static void setMenu(WebDriver driver, String menuName) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement menuTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + menuName + "']")));
            menuTitleElement.click();

    }

    public static void setMenuStepId(WebDriver driver, String stepid) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-stepid='" + stepid + "']"))); //Тусламж, дэмжлэг
            menu.click();

    }


    public static void clickAddButton(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            addButton.click();

    }

    public static void inputTextByCss(WebDriver driver, String inputPath, String inputData) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement inputDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='" + inputPath + "']")));
            inputDataElement.clear(); 
            inputDataElement.sendKeys(inputData);


    }

    public static void inputTextName(WebDriver driver, String inputPath, String inputData) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement inputDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(inputPath)));
            inputDataElement.clear(); 
            inputDataElement.sendKeys(inputData);


    }

    public static void inputTextFromDisable(WebDriver driver, String inputPath, String inputData) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

            WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(inputData)));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].removeAttribute('readonly')", codeField);
            codeField.sendKeys(inputData);
    }

    public static void clickCheckBoxId(WebDriver driver, String inputPath) {

            WebElement checkbox = driver.findElement(By.id(inputPath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

    }

    public static void selectOption(WebDriver driver, String inputPath, String inputData) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement inputDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='" + inputPath + "']")));
            inputDataElement.click();
            WebElement optionDataField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='" + inputData + "']")));
            optionDataField.click();

    }

    public static void waitForBody(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
            waitForLoadToDisappear(driver);

    }

    public static void lookupFieldName(WebDriver driver, String inputPath, String inputData) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement lookupField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(inputPath)));
            lookupField.sendKeys(inputData);
            lookupField.sendKeys(Keys.ENTER);

    }

    public static void saveByXpath(WebDriver driver, String className) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement saveDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, '" + className + "')]")));
            saveDataElement.click();


    }

    public static void saveChecklist(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement saveDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveDataElement.click();

    }

    public static void nextSaveChecklist(WebDriver driver, String id) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement dialogDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-valuemap-" + id + "")));
            WebElement nextSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(dialogDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));            
            nextSaveBtn.click();

    }

    public static void closeChecklistById(WebDriver driver, String checklistId) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement closeCheckListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dialog-valuemap-" + checklistId + " .mb-1 .far")));
            closeCheckListElement.click();


    }
    //Process
    public static void closeProcess(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm blue-hoki bp-btn-close')]")));
            cnclBtn.click();

    }
    public static void saveProcess(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            saveBtn.click();

    }
    private static void waitForLoadToDisappear(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        try {
            WebElement loadingMessages = driver.findElement(By.cssSelector("div.loading-message.loading-message-boxed"));
            if (loadingMessages.isDisplayed()) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loading-message.loading-message-boxed")));
            }
        } catch (NoSuchElementException e) {
            // Loading message not found, proceed
        } catch (TimeoutException e) {
            System.out.println("Waiting for load to disappear timed out");
        }
    }

    // Бусад функцууд дээр төстэй хүлээлтийг нэмж оруулах хэрэгтэй
}
