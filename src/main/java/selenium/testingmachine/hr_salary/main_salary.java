package selenium.testingmachine.hr_salary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.hr_salary.master_data.salaryCalculatorMonth;
import selenium.testingmachine.hr_salary.salary_system.prlSalaryCalculator;
import selenium.testingmachine.hr_salary.salary_system.vacationCalculator;
import selenium.testingmachine.hr_time.employeePlan;
import selenium.testingmachine.hr_time.masterData.employeeAttendanceLog;
import selenium.testingmachine.hr_time.notTimeRegistration;
import selenium.testingmachine.hr_time.planLongtime;
import selenium.testingmachine.hr_time.requestTime;
import selenium.testingmachine.hr_time.timeBalance;

public class main_salary {
    public void main_salary_system(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        try{

            salaryCalculatorMonth calculatorMonth = new salaryCalculatorMonth(driver);
            vacationCalculator vacation = new vacationCalculator(driver);
            prlSalaryCalculator prl = new prlSalaryCalculator(driver);
            notTimeRegistration notTimeRegistration = new notTimeRegistration(driver);
            planLongtime longtime = new planLongtime(driver);
            employeePlan ePlan = new employeePlan(driver);
            requestTime requestime = new requestTime(driver);
            timeBalance balance = new timeBalance(driver);
            employeeAttendanceLog attendanceLog = new employeeAttendanceLog(driver);


            // calculatorMonth.calculatorMonth();
            // vacation.calculator();
            // prl.calculator();
           
            // notTimeRegistration.time();
            // longtime.plan();
            // ePlan.plan();
            // // requestime.time();
            // balance.time();
            attendanceLog.mData();
            

        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }
}
