package selenium.testingmachine.office;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import selenium.testingmachine.office.task.main.registrationOfTask;
import selenium.testingmachine.office.task.masterdata.taskLevel;
import selenium.testingmachine.office.task.masterdata.taskType;

public class officeTask {
    
 public void mainSystem(){
        EdgeOptions options = new EdgeOptions();
        // options.addArguments("--headless=new");
        WebDriver driver = new EdgeDriver(options);
        try{
            officeLogin login = new officeLogin(driver);
            taskType type = new taskType(driver);
            taskLevel level = new taskLevel(driver);
            registrationOfTask task = new registrationOfTask(driver);

            login.login();
            type.data();
            level.data();
            task.main();

        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }    
}
