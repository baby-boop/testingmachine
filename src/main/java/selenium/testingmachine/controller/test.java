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

public class test {

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

        return wait.until(driver1 -> {
            WebElement element = driver1.findElement(locator);
            return element.isDisplayed() && element.isEnabled() ? element : null;
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

    public static configController setModule(WebDriver driver, String moduleName) {
        try {
            WebElement menuTileElement = waitForElement(driver, By.xpath("//a[@data-modulename='" + moduleName + "']"));
            if (menuTileElement != null) {
                clickUsingJS(driver, menuTileElement);
                Thread.sleep(3500); // Consider replacing with WebDriverWait if possible
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error in setModule: " + e.getMessage());
            e.printStackTrace();
        }
        return new configController();
    }
    public static configController setMenu(WebDriver driver, String menuName) {
        try {
            WebElement menuTileElement = waitForElement(driver, By.xpath("//a[text()='" + menuName + "']"));
            if (menuTileElement != null) {
                clickUsingJS(driver, menuTileElement);
                Thread.sleep(2000); // Consider replacing with WebDriverWait if possible
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error in setMenu: " + e.getMessage());
            e.printStackTrace();
        }
        return new configController();
    }

    public static configController clickAddButton(WebDriver driver) {
        try {
            WebElement addBtn = waitForElement(driver, By.linkText("Нэмэх"));
            if (addBtn != null) {
                clickUsingJS(driver, addBtn);
                Thread.sleep(2000); // Consider replacing with WebDriverWait if possible
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error in clickAddButton: " + e.getMessage());
            e.printStackTrace();
        }
        return new configController();
    }

    public static configController inputTextByCss(WebDriver driver, String cssSelector, String inputData) {
        try {
            WebElement inputField = waitForElement(driver, By.cssSelector(cssSelector));
            if (inputField != null) {
                inputField.sendKeys(inputData);
            }
        } catch (Exception e) {
            System.out.println("Error in inputTextByCss: " + e.getMessage());
            e.printStackTrace();
        }
        return new configController();
    }

    public static configController selectOption(WebDriver driver, String dataPath, String optionText) {
        try {
            WebElement optionPathField = waitForElement(driver, By.cssSelector("div[data-s-path='" + dataPath + "']"));
            if (optionPathField != null) {
                clickUsingJS(driver, optionPathField);
                WebElement optionDataField = waitForElement(driver, By.xpath("//div[@class='select2-result-label' and text()='" + optionText + "']"));
                if (optionDataField != null) {
                    clickUsingJS(driver, optionDataField);
                }
            }
        } catch (Exception e) {
            System.out.println("Error in selectOption: " + e.getMessage());
            e.printStackTrace();
        }
        return new configController();
    }

    public static configController saveByXpath(WebDriver driver, String xpath) {
        try {
            WebElement saveBtn = waitForElement(driver, By.xpath(xpath));
            if (saveBtn != null) {
                clickUsingJS(driver, saveBtn);
            }
        } catch (Exception e) {
            System.out.println("Error in saveByXpath: " + e.getMessage());
            e.printStackTrace();
        }
        return new configController();
    }

    public static configController closeChecklistById(WebDriver driver, String checklistId) {
        try {
            WebElement cancelBtn = waitForElement(driver, By.cssSelector("#dialog-valuemap-" + checklistId + " .mb-1 .far"));
            if (cancelBtn != null) {
                clickUsingJS(driver, cancelBtn);
            }
        } catch (Exception e) {
            System.out.println("Error in closeChecklistById: " + e.getMessage());
            e.printStackTrace();
        }
        return new configController();
    }
}
