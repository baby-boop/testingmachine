package selenium.testingmachine.projects.hr_salary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.projects.hr_salary.master_data.employeeListFromSalary;
import selenium.testingmachine.projects.hr_salary.master_data.salaryCalculatorMonth;
import selenium.testingmachine.projects.hr_salary.salary_system.vacationCalculator;

public class mainSalary {
    public void main_salary_system(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        try{

            salaryLogin login = new salaryLogin(driver);
            salaryCalculatorMonth calculatorMonth = new salaryCalculatorMonth(driver);
            employeeListFromSalary employeeList = new employeeListFromSalary(driver);
            vacationCalculator vacationCalculator = new vacationCalculator(driver);

            login.login();
            calculatorMonth.calculatorMonth();
            employeeList.data();
            // vacationCalculator.main(); //not working that process

            

        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }
}
