package selenium.testingmachine.projects.hr.unit_directory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

public class unitType {
 

    private WebDriver driver;

    public unitType(WebDriver driver) {
        this.driver = driver;
    }
    public void unit(){
        try{

            WebDriverWait wait = configController.getWebDriverWait(driver);

            Thread.sleep(2000);

            WebElement menuTileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-modulename='Core HR']")));
            menuTileElement.click();

            Thread.sleep(3500);

            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Мастер дата')]")));
            menu.click();

            Thread.sleep(2000);

            configController.setMenu(driver, "Бүтэц, нэгжийн лавлах");

            Thread.sleep(2000);

            configController.setMenuStepId(driver, "16878321532639"); //Нэгжийн төрөл

            Thread.sleep(2000);

            configController.clickAddButton(driver);
            
            Thread.sleep(2000);

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
            
            
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            // List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));

            // if (!rows.isEmpty()) {
            //     WebElement lastRow = rows.get(rows.size() - 1);
            //     lastRow.click();

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
