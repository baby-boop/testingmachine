package selenium.testingmachine.projects.hr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class testClassTwo {
    private WebDriver driver;

    public testClassTwo(WebDriver driver) {
        this.driver = driver;
    }

    public void test() {

        try {

            Thread.sleep(2000);

            // configController.subMenu(driver, "Ажилтны лавлах");
            // WebElement menuTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Ажилтны лавлах')]")));
            // menuTitleElement.click();

            Thread.sleep(2000);

            // configController.dataStepId(driver, "17054781096129"); //Шагналын төрөл

            // Click add button
            configController.clickAddButton(driver);

            // Input text by CSS selector
            configController.inputTextByCss(driver, "REWARD_TYPE_NAME", "test1");

            // Save
            configController.saveByXpath(driver, "btn btn-sm green-meadow bp-btn-save ");

            // Wait and check for error messages
           

            // Close checklist
            Thread.sleep(4000);

            // configController.closeForm(driver, "btn btn-sm blue-hoki bp-btn-close");


            ClassCounter.registerWorkingClass(this.getClass());

        } catch (Exception e) {
            System.out.println("Error in class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Finished: " + this.getClass().getSimpleName());
        }
    }
}
