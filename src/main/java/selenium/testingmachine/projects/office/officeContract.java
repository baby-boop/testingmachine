package selenium.testingmachine.projects.office;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.projects.office.contract.main.contractList;
import selenium.testingmachine.projects.office.contract.main.registrationOfContracts;
import selenium.testingmachine.projects.office.contract.masterdata.contractDirections;
import selenium.testingmachine.projects.office.contract.masterdata.contractPaymentType;
import selenium.testingmachine.projects.office.contract.masterdata.contractPrivacyType;
import selenium.testingmachine.projects.office.contract.masterdata.contractReasonsForTermination;
import selenium.testingmachine.projects.office.contract.masterdata.contractReminderDays;
import selenium.testingmachine.projects.office.contract.masterdata.contractType;
import selenium.testingmachine.projects.office.contract.masterdata.contractTypeOfLosses;



public class officeContract {
    
 public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        try{
            officeLogin login = new officeLogin(driver);
            contractType type = new contractType(driver);
            contractDirections directions = new contractDirections(driver);
            contractPaymentType paymentType = new contractPaymentType(driver);
            contractReminderDays reminder = new contractReminderDays(driver);
            contractPrivacyType privacyType = new contractPrivacyType(driver);
            contractReasonsForTermination termination = new contractReasonsForTermination(driver);
            contractTypeOfLosses losses = new contractTypeOfLosses(driver);
            registrationOfContracts reg = new registrationOfContracts(driver);
            contractList list = new contractList(driver);

            ClassCounter.registerClass(type.getClass());
            ClassCounter.registerClass(directions.getClass());
            ClassCounter.registerClass(paymentType.getClass());
            ClassCounter.registerClass(reminder.getClass());
            ClassCounter.registerClass(privacyType.getClass());
            ClassCounter.registerClass(termination.getClass());
            ClassCounter.registerClass(losses.getClass());
            ClassCounter.registerClass(reg.getClass());
            ClassCounter.registerClass(list.getClass());

            login.login();
            type.data();
            directions.data();
            paymentType.data();
            reminder.data();
            privacyType.data();
            termination.data();
            losses.data();
            reg.main();
            list.main();


        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }    
}
