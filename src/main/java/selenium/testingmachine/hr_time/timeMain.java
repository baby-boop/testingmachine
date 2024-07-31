package selenium.testingmachine.hr_time;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.hr_time.masterData.employeeAttendanceLog;

public class timeMain {
    public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        try{

            timeLogin login = new timeLogin(driver);
            employeeAttendanceLog employeeAttendanceLog = new employeeAttendanceLog(driver);

            login.login();
            employeeAttendanceLog.data();

        }
        finally {
            driver.quit();
			System.out.println("completed");

        }
    }
}
