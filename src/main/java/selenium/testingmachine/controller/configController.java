package selenium.testingmachine.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class configController {

    public static final String URL = "https://cloud.veritech.mn/login";
    public static final String USERNAME = "testshuu@gmail.com";
    public static final String PASSWORD = "VrCloud@123";
    public static final int TIMEOUT = 30;
    public static final int POLLING_INTERVAL = 1;

    public static WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public static WebElement waitForElement(WebDriver driver, By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING_INTERVAL))
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed() && element.isEnabled()) {
                    return element;
                } else {
                    return null;
                }
            }
        });
    }

    public static boolean clickUsingJS(WebDriver driver, WebElement element) {
        try {
            if (element != null) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", element);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error in clickUsingJS: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean setModuleFunction(WebDriver driver, String moduleName) {
        try {
            WebElement menuTileElement = waitForElement(driver, By.xpath("//a[@data-modulename='" + moduleName + "']"));
            if (menuTileElement != null) {
                clickUsingJS(driver, menuTileElement);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error in setModuleFunction: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean setMenuFunction(WebDriver driver, String menuName) {
        try {
            WebElement menuTileElement = waitForElement(driver, By.cssSelector("a.nav-link[aria-expanded='false']:contains('" + menuName + "')"));
            if (menuTileElement != null) {
                clickUsingJS(driver, menuTileElement);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error in setMenuFunction: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean clickAddBtnFunction(WebDriver driver) {
        try {
            WebElement addBtn = waitForElement(driver, By.linkText("Нэмэх"));
            if (addBtn != null) {
                clickUsingJS(driver, addBtn);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error in clickAddBtnFunction: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean inputCssFunction(WebDriver driver, String inputPath, String inputData) {
        try {
            WebElement inputField = waitForElement(driver, By.cssSelector(inputPath));
            if (inputField != null) {
                inputField.sendKeys(inputData);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error in inputCssFunction: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean inputOptionFunction(WebDriver driver, String inputPath, String inputData) {
        try {
            WebElement optionPathField = waitForElement(driver, By.cssSelector("div[data-s-path='" + inputPath + "']"));
            if (optionPathField != null) {
                clickUsingJS(driver, optionPathField);
                WebElement optionDataField = waitForElement(driver, By.xpath("//div[@class='select2-result-label' and text()='" + inputData + "']"));
                if (optionDataField != null) {
                    clickUsingJS(driver, optionDataField);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error in inputOptionFunction: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean saveXpathFunction(WebDriver driver, String inputPath) {
        try {
            WebElement saveBtn = waitForElement(driver, By.xpath("//button[contains(@class, '" + inputPath + "')]"));
            if (saveBtn != null) {
                clickUsingJS(driver, saveBtn);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error in saveXpathFunction: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean closeChecklistIdFunction(WebDriver driver, String inputData) {
        try {
            WebElement cancelBtn = waitForElement(driver, By.cssSelector("#dialog-valuemap-" + inputData + " .mb-1 .far"));
            if (cancelBtn != null) {
                clickUsingJS(driver, cancelBtn);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error in closeChecklistIdFunction: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
