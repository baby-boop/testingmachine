package selenium.testingmachine.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class configController {

    public static final String URL = "https://cloud.veritech.mn/login";
    public static final String USERNAME = "testshuu@gmail.com";
    public static final String PASSWORD = "VrCloud@123";
    public static final int TIMEOUT = 10;

    private static Wait<WebDriver> createFluentWait(WebDriver driver) {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(TIMEOUT))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);
    }

    public static WebElement waitForElement(WebDriver driver, By locator) {
        Wait<WebDriver> wait = createFluentWait(driver);
        return wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    return element;
                } else {
                    return null;
                }
            }
        });
    }

    public static void waitForUrlContains(WebDriver driver, String expectedUrlPart) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.urlContains(expectedUrlPart));
    }

    public static void waitForTextInElement(WebDriver driver, By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    public static WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public static void setModule(WebDriver driver, String moduleName) {
        try {
            WebElement moduleTitleElement = waitForElement(driver, By.xpath("//a[@data-modulename='" + moduleName + "']"));
            moduleTitleElement.click();
            // Хүлээлт: модуль нээгдэх хүртэл хүлээнэ
            waitForUrlContains(driver, moduleName);
        } catch (Exception e) {
            System.out.println("Error in setModule: " + e.getMessage());
            throw e; // Алдааг дахин өгөх
        }
    }

    public static void setMenu(WebDriver driver, String menuName) {
        try {
            WebElement menuTitleElement = waitForElement(driver, By.xpath("//a[text()='" + menuName + "']"));
            menuTitleElement.click();
            // Хүлээлт: меню нээгдэх хүртэл хүлээнэ
            waitForElement(driver, By.xpath("//a[text()='" + menuName + "']"));
        } catch (Exception e) {
            System.out.println("Error in setMenu: " + e.getMessage());
            throw e; // Алдааг дахин өгөх
        }
    }

    public static void clickAddButton(WebDriver driver) {
        try {
            WebElement addButton = waitForElement(driver, By.linkText("Нэмэх"));
            addButton.click();
            // Хүлээлт: шинэ хуудсанд шилжих хүртэл хүлээнэ
            waitForElement(driver, By.linkText("Нэмэх"));
        } catch (Exception e) {
            System.out.println("Error in clickAddButton: " + e.getMessage());
            throw e; // Алдааг дахин өгөх
        }
    }

    public static void inputTextByCss(WebDriver driver, String inputPath, String inputData) {
        try {
            WebElement inputDataElement = waitForElement(driver, By.cssSelector("input[data-path='" + inputPath + "']"));
            inputDataElement.clear(); // Text box-ийг цэвэрлэх
            inputDataElement.sendKeys(inputData);
            // Хүлээлт: текст оруулалтын хэсэгт үүсгэх хүртэл хүлээнэ
            waitForTextInElement(driver, By.cssSelector("input[data-path='" + inputPath + "']"), inputData);
        } catch (Exception e) {
            System.out.println("Error in inputTextByCss: " + e.getMessage());
            throw e; // Алдааг дахин өгөх
        }
    }

    public static void selectOption(WebDriver driver, String inputPath, String inputData) {
        try {
            WebElement inputDataElement = waitForElement(driver, By.cssSelector("div[data-s-path='" + inputPath + "']"));
            inputDataElement.click();
            WebElement optionDataField = waitForElement(driver, By.xpath("//div[@class='select2-result-label' and text()='" + inputData + "']"));
            optionDataField.click();
            // Хүлээлт: сонгосон хувилбарын сонголт амжилттай болсон гэдгийг шалгах
            createFluentWait(driver).until(ExpectedConditions.textToBe(By.cssSelector("div[data-s-path='" + inputPath + "']"), inputData));
        } catch (Exception e) {
            System.out.println("Error in selectOption: " + e.getMessage());
            throw e; // Алдааг дахин өгөх
        }
    }

    public static void saveByXpath(WebDriver driver, String className) {
        try {
            WebElement saveDataElement = waitForElement(driver, By.xpath("//button[contains(@class, '" + className + "')]"));
            saveDataElement.click();
            // Хүлээлт: хадгалах ажиллагаа дууссан гэдгийг шалгах
            createFluentWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(@class, '" + className + "')]")));
        } catch (Exception e) {
            System.out.println("Error in saveByXpath: " + e.getMessage());
            throw e; // Алдааг дахин өгөх
        }
    }

    public static void closeChecklistById(WebDriver driver, String checklistId) {
        try {
            WebElement closeCheckListElement = waitForElement(driver, By.cssSelector("#dialog-valuemap-" + checklistId + " .mb-1 .far"));
            closeCheckListElement.click();
            // Хүлээлт: чирэх цонх хаагдсан гэдгийг шалгах
            createFluentWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#dialog-valuemap-" + checklistId + " .mb-1 .far")));
        } catch (Exception e) {
            System.out.println("Error in closeChecklistById: " + e.getMessage());
            throw e; // Алдааг дахин өгөх
        }
    }


    // Бусад функцууд дээр төстэй хүлээлтийг нэмж оруулах хэрэгтэй
}
