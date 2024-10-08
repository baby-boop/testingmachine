package selenium.testingmachine.projects.hr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.projects.hr.main.allowenceOfBenefits;
import selenium.testingmachine.projects.hr.main.employeeList;
import selenium.testingmachine.projects.hr.main.employeeManagement;
import selenium.testingmachine.projects.hr.main.jobCandidates;
import selenium.testingmachine.projects.hr.main.jobCandidatesList;
import selenium.testingmachine.projects.hr.main.jobDiscipline;
import selenium.testingmachine.projects.hr.main.jobDismissed;
import selenium.testingmachine.projects.hr.main.jobExtra;
import selenium.testingmachine.projects.hr.main.jobLongLeave;
import selenium.testingmachine.projects.hr.main.jobSalary;
import selenium.testingmachine.projects.hr.main.jobTransitionalMovement;
import selenium.testingmachine.projects.hr.main.labourBook;
import selenium.testingmachine.projects.hr.main.reassignment;
import selenium.testingmachine.projects.hr.main.representativeEmployee;

public class mainHr {
    public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        
        try {
			loginHr login = new loginHr(driver);
            employeeManagement management = new employeeManagement(driver);
            employeeList list = new employeeList(driver);
            jobCandidates candidates = new jobCandidates(driver);
            jobCandidatesList candidate = new jobCandidatesList(driver);
            labourBook labour = new labourBook(driver);
            jobDismissed dismissed = new jobDismissed(driver);
            jobLongLeave longLeave = new jobLongLeave(driver);
            jobTransitionalMovement transitionalMovement = new jobTransitionalMovement(driver);
            allowenceOfBenefits benefits = new allowenceOfBenefits(driver);
            jobExtra extra = new jobExtra(driver);
            jobDiscipline discipline = new jobDiscipline(driver);
            jobSalary salary = new jobSalary(driver);
            representativeEmployee rEmployee = new representativeEmployee(driver);
            reassignment reassignment = new reassignment(driver);


             ClassCounter.registerClass(management.getClass());
             ClassCounter.registerClass(list.getClass());
             ClassCounter.registerClass(candidates.getClass());
             ClassCounter.registerClass(candidate.getClass());
             ClassCounter.registerClass(labour.getClass());
             ClassCounter.registerClass(dismissed.getClass());
             ClassCounter.registerClass(longLeave.getClass());
             ClassCounter.registerClass(transitionalMovement.getClass());
             ClassCounter.registerClass(benefits.getClass());
             ClassCounter.registerClass(extra.getClass());
             ClassCounter.registerClass(discipline.getClass());
             ClassCounter.registerClass(salary.getClass());
             ClassCounter.registerClass(rEmployee.getClass());
             ClassCounter.registerClass(reassignment.getClass());

			login.loginHr();
             management.employee();
             list.employees();
             candidates.candidates();
             candidate.candidate();
             labour.labour();
             dismissed.dismissed();
             longLeave.longLeave();

             transitionalMovement.transition();
             benefits.benefits();
             extra.extra();
             discipline.warning();
             salary.salary();
             rEmployee.representative();
             reassignment.reassignment();



        } finally {
            driver.quit();
			System.out.println("completed");

        }
    }
}
