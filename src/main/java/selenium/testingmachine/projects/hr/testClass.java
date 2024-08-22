package selenium.testingmachine.projects.hr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class testClass {

    private WebDriver driver;

    public testClass(WebDriver driver) {
        this.driver = driver;
    }

    public void test() {
        try {
            WebDriverWait wait = configController.getWebDriverWait(driver);

            configController.setModuleFunction(driver, "Core HR");
            configController.setMenuFunction(driver, "Мастер дата");
            configController.clickAddBtnFunction(driver);
            configController.inputCssFunction(driver, "DEPARTMENT_NAME", "test1");
            configController.inputOptionFunction(driver, "PARENT_ID", "Боловсруулах цех");
            configController.inputOptionFunction(driver, "CLASSIFICATION_ID", "Борлуулалт");
            configController.inputOptionFunction(driver, "TYPE_ID", "Компани");
            configController.saveXpathFunction(driver, "ml-1 btn btn-sm btn-circle btn-success bp-btn-save");

            // Error message-ийг шалгах
            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");

                WebElement cnclAlertBtn = ExpectedConditions.visibilityOfElementLocated(By.className("ui-pnotify-closer")).apply(driver);
                configController.clickUsingJS(driver, cnclAlertBtn);

                configController.closeChecklistIdFunction(driver, "17074492102739");
                return;
            }

            configController.closeChecklistIdFunction(driver, "17074492102739");
            ClassCounter.registerWorkingClass(this.getClass());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        } finally {
            System.out.println("finished: " + this.getClass().getSimpleName());
        }
    }
}
