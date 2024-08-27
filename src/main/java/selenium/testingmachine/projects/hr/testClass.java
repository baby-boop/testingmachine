package selenium.testingmachine.projects.hr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
            configController.setModule(driver, "Core HR");

            configController.setMenu(driver, "Мастер дата");

            configController.clickAddButton(driver);

            handleElementInteraction("DEPARTMENT_NAME", "test1", () -> configController.inputTextByCss(driver, "DEPARTMENT_NAME", "test1"));
            handleElementInteraction("PARENT_ID", "Боловсруулах цех", () -> configController.selectOption(driver, "PARENT_ID", "Боловсруулах цех"));
            handleElementInteraction("CLASSIFICATION_ID", "Борлуулалт", () -> configController.selectOption(driver, "CLASSIFICATION_ID", "Борлуулалт"));
            handleElementInteraction("TYPE_ID", "Компани", () -> configController.selectOption(driver, "TYPE_ID", "Компани"));


            configController.saveByXpath(driver, "ml-1 btn btn-sm btn-circle btn-success bp-btn-save");

            

            configController.closeChecklistById(driver, "17074492102739");

            ClassCounter.registerWorkingClass(this.getClass());

        } catch (Exception e) {
            System.out.println("Error in class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Finished: " + this.getClass().getSimpleName());
        }
    }
    private void handleElementInteraction(String inputPath, String inputData, Runnable interaction) {
        try {
            interaction.run();
        } catch (Exception e) {
            System.out.println("Error in element with path " + inputPath + ": " + e.getMessage());
            e.printStackTrace();
            // Системын бэрхшээлд оруулахгүй
            // Exit or skip further actions depending on requirement
            throw new RuntimeException("Aborting further actions due to error");
        }
    }
}
