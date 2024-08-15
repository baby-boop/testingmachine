package selenium.testingmachine.projects.office;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.projects.office.task.main.registrationOfTask;
import selenium.testingmachine.projects.office.task.masterdata.taskLevel;
import selenium.testingmachine.projects.office.task.masterdata.taskType;

public class officeTask {
    
 public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
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
