package selenium.testingmachine.projects.hr.unit_directory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class unitType {
 

    private final WebDriver driver;

    public unitType(WebDriver driver) {
        this.driver = driver;
    }
    public void unit(){
        try{

            WebDriverWait wait = configController.getWebDriverWait(driver);

            configController.setModule(driver, "Core HR");

            configController.waitForBody(driver);

            configController.setMenu(driver,"Мастер дата");

            configController.waitForBody(driver);

            configController.setMenu(driver, "Бүтэц, нэгжийн лавлах");

            configController.waitForBody(driver);

            configController.setMenuStepId(driver, "16878321532639"); //Нэгжийн төрөл

            configController.waitForBody(driver);

            configController.clickAddButton(driver);

            configController.waitForBody(driver);

            configController.inputTextName(driver, "mvParam[NAME]", "test");

            configController.inputTextFromDisable(driver, "mvParam[CODE]", "test1");

            configController.inputTextName(driver, "mvParam[ORDER_NUMBER]", "7");

            configController.clickCheckBoxId(driver, "mvParam[IS_ACTIVE]");

            configController.saveProcess(driver);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                configController.closeProcess(driver);

                return;
            }

            Thread.sleep(2000);


        }catch(Exception e){

            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();

        }finally{

            System.out.println("finished: "+ this.getClass().getSimpleName());
            ClassCounter.registerWorkingClass(this.getClass());

        }
    }
    
}
