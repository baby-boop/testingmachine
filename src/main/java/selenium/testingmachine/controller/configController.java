package selenium.testingmachine.controller;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

            WebElement moduleTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-modulename='" + moduleName + "']")));
            moduleTitleElement.click();
        } catch (Exception e) {
            log.info("Error in setModule:", e);
        }
    }

    public static void setMenu(WebDriver driver, String menuName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement menuTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + menuName + "']")));
            menuTitleElement.click();

        } catch (Exception e) {
            System.err.println("Error in setMenu: " + e.getMessage());
        }
    }

    public static void setMenuStepId(WebDriver driver, String stepid) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-stepid='" + stepid + ""))); //Тусламж, дэмжлэг
            menu.click();

        } catch (Exception e) {
            System.err.println("Error in setMenuStepId: " + e.getMessage());
        }
    }


    public static void clickAddButton(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            addButton.click();
        } catch (Exception e) {
            System.err.println("Error in clickAddButton: " + e.getMessage());
        }
    }

    public static void inputTextByCss(WebDriver driver, String inputPath, String inputData) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement inputDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='" + inputPath + "']")));
            inputDataElement.clear(); 
            inputDataElement.sendKeys(inputData);

        } catch (Exception e) {
            System.err.println("Error in inputTextByCss: " + e.getMessage());
        }
    }

    public static void inputTextName(WebDriver driver, String inputPath, String inputData) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement inputDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(inputPath)));
            inputDataElement.clear(); 
            inputDataElement.sendKeys(inputData);

        } catch (Exception e) {
            System.err.println("Error in inputTextName: " + e.getMessage());
        }
    }

    public static void inputTextFromDisable(WebDriver driver, String inputPath, String inputData) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

            WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(inputData)));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].removeAttribute('readonly')", codeField);
            codeField.sendKeys(inputData);

        } catch (Exception e) {
            System.err.println("Error in inputTextFromDisable: " + e.getMessage());
        }
    }

    public static void clickCheckBoxId(WebDriver driver, String inputPath) {
        try {
            // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

            WebElement checkbox = driver.findElement(By.id(inputPath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

        } catch (Exception e) {
            System.err.println("Error in clickCheckBoxId: " + e.getMessage());
        }
    }

    public static void selectOption(WebDriver driver, String inputPath, String inputData) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement inputDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-s-path='" + inputPath + "']")));
            inputDataElement.click();
            Thread.sleep(500);
            WebElement optionDataField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='" + inputData + "']")));
            optionDataField.click();

        } catch (Exception e) {
            System.err.println("Error in selectOption: " + e.getMessage());
        }
    }

    public static void lookupFieldName(WebDriver driver, String inputPath, String inputData) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement lookupField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(inputPath)));
            lookupField.sendKeys(inputData);
            lookupField.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

        } catch (Exception e) {
            System.err.println("Error in lookupFieldName: " + e.getMessage());
        }
    }

    public static void saveByXpath(WebDriver driver, String className) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement saveDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, '" + className + "')]")));
            saveDataElement.click();

        } catch (Exception e) {
            System.err.println("Error in saveByXpath: " + e.getMessage());

        }
    }

    public static void saveChecklist(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement saveDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveDataElement.click();

        } catch (Exception e) {
            System.err.println("Error in saveByXpath: " + e.getMessage());

        }
    }

    public static void nextSaveChecklist(WebDriver driver, String id) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement dialogDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-valuemap-" + id + "")));
            WebElement nextSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(dialogDiv.findElement(By.xpath(".//button[contains(text(), 'Хадгалах')]"))));            
            nextSaveBtn.click();

        } catch (Exception e) {
            System.err.println("Error in saveByXpath: " + e.getMessage());

        }
    }

    public static void closeChecklistById(WebDriver driver, String checklistId) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement closeCheckListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dialog-valuemap-" + checklistId + " .mb-1 .far")));
            closeCheckListElement.click();

        } catch (Exception e) {
            System.err.println("Error in closeChecklistById: " + e.getMessage());

        }
    }
    //Process
    public static void closeProcess(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm blue-hoki bp-btn-close')]")));
            cnclBtn.click();

        } catch (Exception e) {
            System.err.println("Error in closeProcess: " + e.getMessage());

        }
    }
    public static void saveProcess(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            saveBtn.click();

        } catch (Exception e) {
            System.err.println("Error in saveProcess: " + e.getMessage());

        }
    }


    // Бусад функцууд дээр төстэй хүлээлтийг нэмж оруулах хэрэгтэй
}
