package selenium.testingmachine.projects.hr.position_directory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class positionReasonLevel {

    private WebDriver driver;

    public positionReasonLevel(WebDriver driver) {
        this.driver = driver;
    }
    public void position(){
        try{

            WebDriverWait wait = configController.getWebDriverWait(driver);

            Thread.sleep(2000);

            configController.setMenuStepId(driver, "16746270668544"); //Албан тушаалын зэрэглэл

            Thread.sleep(2000);
            
            configController.clickAddButton(driver);

            configController.inputTextName(driver, "mvParam[PROF_LEVEL_NAME]", "112211");

            configController.clickCheckBoxId(driver, "mvParam[IS_ACTIVE]");


            configController.saveProcess(driver);
            if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                configController.closeProcess(driver);
                return;
            }
            
            
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            // List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            // if (!rows.isEmpty()) {
            //     WebElement firstRow = rows.get(0);
            //     firstRow.click();

            //     WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
            //     edit.click();

            // } else {
            //     System.out.println("No rows found.");
            // }

            // Thread.sleep(1000);

            // WebElement editSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm green-meadow bp-btn-save ')]")));
            // editSave.click();

            // if (ErrorUtils.isErrorMessagePresent(driver, wait, this.getClass())) {
            //     System.out.println("Error message found after saving. Exiting...");
            //     Thread.sleep(3500);
                
            //     WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
            //     cnclBtn.click();
            //     return;
            // }

            Thread.sleep(2000);

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
