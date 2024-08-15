package selenium.testingmachine.projects.finance.financeStandard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.projects.finance.financeStandard.masterData.contactInformation;
import selenium.testingmachine.projects.finance.financeStandard.masterData.contractClassification;
import selenium.testingmachine.projects.finance.financeStandard.masterData.standardBank;
import selenium.testingmachine.projects.finance.financeStandard.masterData.standardCashier;
import selenium.testingmachine.projects.finance.financeStandard.masterData.standardDepartment;
import selenium.testingmachine.projects.finance.financeStandard.masterData.standardEmployee;
import selenium.testingmachine.projects.finance.financeStandard.masterData.standardPaymentType;
import selenium.testingmachine.projects.finance.financeStandard.masterData.standardPosition;
import selenium.testingmachine.projects.finance.financeStandard.masterData.standardWorkplace;

public class standardMain {
    public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        try{

            standardLogin login = new standardLogin(driver);
            standardDepartment standardDepartment = new standardDepartment(driver);
            standardPosition standardPosition = new standardPosition(driver);
            standardWorkplace standardWorkplace = new standardWorkplace(driver);
            standardEmployee standardEmployee = new standardEmployee(driver);
            contractClassification contractClassification = new contractClassification(driver);
            standardPaymentType standardPaymentType = new standardPaymentType(driver);
            standardCashier standardCashier = new standardCashier(driver);
            standardBank standardBank = new standardBank(driver);
            contactInformation contactInformation = new contactInformation(driver);


            ClassCounter.registerClass(standardDepartment.getClass());
            ClassCounter.registerClass(standardPosition.getClass());
            ClassCounter.registerClass(standardWorkplace.getClass());
            ClassCounter.registerClass(standardEmployee.getClass());
            ClassCounter.registerClass(contractClassification.getClass());
            ClassCounter.registerClass(standardPaymentType.getClass());
            ClassCounter.registerClass(standardCashier.getClass());
            ClassCounter.registerClass(standardBank.getClass());
            ClassCounter.registerClass(contactInformation.getClass());
    
            login.login();
            standardDepartment.data();
            standardPosition.data();
            standardWorkplace.data();
            standardEmployee.data();
            contractClassification.data();
            standardPaymentType.data();
            standardCashier.data();
            standardBank.data();
            contactInformation.data();

        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }    
}
