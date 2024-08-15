package selenium.testingmachine.projects.finance.financeRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.projects.finance.financeRequest.businessInformation.businessInformationMain;
import selenium.testingmachine.projects.finance.financeRequest.firstInformation.associatedCompany;
import selenium.testingmachine.projects.finance.financeRequest.firstInformation.creditHistory;
import selenium.testingmachine.projects.finance.financeRequest.firstInformation.emergencyContact;
import selenium.testingmachine.projects.finance.financeRequest.firstInformation.employeeFromKhaan;
import selenium.testingmachine.projects.finance.financeRequest.firstInformation.securedLoans;
import selenium.testingmachine.projects.finance.financeRequest.firstInformation.shareHolders;
import selenium.testingmachine.projects.finance.financeRequest.firstInformation.stocks;
import selenium.testingmachine.projects.finance.financeRequest.firstInformation.subcontractor;

public class requestMain {

 public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        try{

            requestLogin login = new requestLogin(driver);
            request request = new request(driver);
            associatedCompany associated = new associatedCompany(driver);
            subcontractor contractor = new subcontractor(driver);
            securedLoans loans = new securedLoans(driver);
            stocks stocks = new stocks(driver);
            emergencyContact contacts = new emergencyContact(driver);
            creditHistory history = new creditHistory(driver);
            employeeFromKhaan employee = new employeeFromKhaan(driver);
            shareHolders shareHolders = new shareHolders(driver);
            businessInformationMain information = new businessInformationMain(driver);
            
            login.login();
            request.requestProcess();
            associated.company();
            shareHolders.holders();
            contractor.notice();
            loans.notice();
            stocks.notice();
            contacts.notice();
            employee.employee();
            history.information();
            // information.mainSystem();



        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }    
}
