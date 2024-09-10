package selenium.testingmachine.Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SampleTest {

    private final WebDriver driver;
    private final SeleniumWaitUtils wait;

    public SampleTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new SeleniumWaitUtils(driver, 30, 500); // Adjust the wait time and poll interval as needed
    }

    public void test() {
        try {
            System.out.println("Starting test...");

            // Click on Core HR menu
            clickMenuTile("Core HR");
            // Click on Мастер дата
            clickMenu("Мастер дата");

            // Navigate through different menus
            clickMenu("Бүтэц, нэгжийн лавлах");
            clickStepId("16878321532639");
            clickStepId("16878314254999");
            clickStepId("183320834");

            // Re-click on same menu for demonstration purposes
            clickMenu("Бүтэц, нэгжийн лавлах");
            clickMenu("Ажилтны лавлах");

            WebElement menuStepId3 = wait.waitForElement(By.cssSelector("li[data-stepid='16752096836064']"));
            if (menuStepId3.isDisplayed()) {
                System.out.println("Элемент харагдаж байна.");
                menuStepId3.click();

                // Check if the element is active and clickable
                WebElement activeElement = wait.waitForElement(
                        By.xpath("//a[@data-stepid='16752096836064' and contains(@class, 'active')]")
                );
                if (activeElement != null) {

                    Thread.sleep(2000);
                    System.out.println("Элемент идэвхтэй байна.");
                    clickAddButton();
                } else {
                    System.out.println("Элемент идэвхгүй байна.");
                }
            }

            // Interact with form input
            fillInputField("mvParam[FILE_TYPE_NAME]", "222");


        } catch (TimeoutException e) {
            handleError("Timeout occurred", e);
        } catch (NoSuchElementException e) {
            handleError("Element not found", e);
        } catch (Exception e) {
            handleError("An unexpected error occurred", e);
        } finally {
            driver.quit();
        }
    }

    // Method to click a menu item based on its name
    private void clickMenuTile(String moduleName) {
        try {
            WebElement menuTileElement = wait.waitForElement(By.xpath("//a[@data-modulename='" + moduleName + "']"));
            menuTileElement.click();
        } catch (Exception e) {
            handleError("Failed to click menu tile: " + moduleName, e);
        }
    }

    // Method to click a menu by text
    private void clickMenu(String menuText) {
        try {
            WebElement menu = wait.waitForElement(By.xpath("//a[contains(text(),'" + menuText + "')]"));
            menu.click();
        } catch (Exception e) {
            handleError("Failed to click menu: " + menuText, e);
        }
    }

    // Method to click a step by its step ID
    private void clickStepId(String stepId) {
        try {
            WebElement stepElement = wait.waitForElement(By.cssSelector("li[data-stepid='" + stepId + "']"));
            stepElement.click();
        } catch (Exception e) {
            handleError("Failed to click step ID: " + stepId, e);
        }
    }

    // Method to handle filling input fields
    private void fillInputField(String fieldName, String value) {
        try {
            WebElement inputField = wait.waitForElement(By.name(fieldName));
            inputField.sendKeys(value);
        } catch (Exception e) {
            handleError("Failed to fill input field: " + fieldName, e);
        }
    }

    // Method to click the "Add" button
    private void clickAddButton() {
        try {
            WebElement addButton = wait.elementToBeClickable(By.linkText("Нэмэх"));
            addButton.click();
        } catch (Exception e) {
            handleError("Failed to click 'Add' button", e);
        }
    }

    // Handle errors centrally
    private void handleError(String message, Exception e) {
        System.err.println(message + ": " + e.getMessage());
        driver.quit();
    }
}
