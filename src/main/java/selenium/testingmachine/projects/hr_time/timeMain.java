package selenium.testingmachine.projects.hr_time;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.projects.hr_time.main.employeePlan;
import selenium.testingmachine.projects.hr_time.main.notTimeRegistration;
import selenium.testingmachine.projects.hr_time.main.planLongtime;
import selenium.testingmachine.projects.hr_time.main.requestTime;
import selenium.testingmachine.projects.hr_time.main.timeBalance;
import selenium.testingmachine.projects.hr_time.masterData.employeeAttendanceLog;
import selenium.testingmachine.projects.hr_time.masterData.publicHolidays;
import selenium.testingmachine.projects.hr_time.masterData.timePlanList;

@Slf4j
public class timeMain {
    public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        try{

            timeLogin login = new timeLogin(driver);
            employeeAttendanceLog employeeAttendanceLog = new employeeAttendanceLog(driver);
            timePlanList timePlanList = new timePlanList(driver);
            publicHolidays publicHolidays = new publicHolidays(driver);
            notTimeRegistration notTimeRegistration = new notTimeRegistration(driver);
            planLongtime planLongtime = new planLongtime(driver);
            employeePlan employeePlan = new employeePlan(driver);
            requestTime requestTime = new requestTime(driver);
            timeBalance timeBalance = new timeBalance(driver);

            login.login();
            employeeAttendanceLog.data();
            timePlanList.data();
            publicHolidays.data();
            notTimeRegistration.main();
            planLongtime.main();
            employeePlan.main();
            requestTime.main();
            timeBalance.main();


        }
        finally {
            driver.quit();
			System.out.println("completed");

        }
    }
}
