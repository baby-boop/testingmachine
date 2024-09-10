package selenium.testingmachine.projects.hr.unit_directory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class unitStructure {

    private WebDriver driver;

    public unitStructure(WebDriver driver) {
        this.driver = driver;
    }
    public void unit(){
        try{

            WebDriverWait wait = configController.getWebDriverWait(driver);

            Thread.sleep(2000);

            configController.setMenuStepId(driver, "183320834"); //Бүтцийн нэгж

            Thread.sleep(2000);
            
            configController.clickAddButton(driver);

            Thread.sleep(2000);

            configController.inputTextByCss(driver, "DEPARTMENT_NAME", "test1");

            configController.selectOption(driver, "PARENT_ID", "Боловсруулах цех");

            configController.selectOption(driver, "CLASSIFICATION_ID", "Борлуулалт");

            Thread.sleep(500);

            configController.selectOption(driver, "TYPE_ID", "Компани");
            Thread.sleep(500);

            configController.saveChecklist(driver);

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                configController.closeChecklistById(driver, "183320834");
                return;
            }
            
            Thread.sleep(3500);

            configController.selectOption(driver, "CITY_ID", "Улаанбаатар");

            Thread.sleep(500);

            configController.lookupFieldName(driver, "mvParam[DISTRICT_ID]_nameField", "Баянзүрх");

            Thread.sleep(500);

            configController.lookupFieldName(driver, "mvParam[STREET_ID]_nameField", "28-р хороо");

            configController.inputTextByCss(driver, "DESCRIPTION", "38р гудамж");

            configController.nextSaveChecklist(driver, "183320834");

            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                configController.closeChecklistById(driver, "183320834");
                return;
            }

            Thread.sleep(3500);

            configController.closeChecklistById(driver, "183320834");

            ClassCounter.registerWorkingClass(this.getClass());

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
   
}

