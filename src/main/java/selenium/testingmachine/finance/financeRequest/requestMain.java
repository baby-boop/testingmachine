package selenium.testingmachine.finance.financeRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import selenium.testingmachine.finance.financeRequest.businessInformation.businessInformation;
import selenium.testingmachine.finance.financeRequest.firstInformation.associatedCompany;
import selenium.testingmachine.finance.financeRequest.firstInformation.creditHistory;
import selenium.testingmachine.finance.financeRequest.firstInformation.emergencyContact;
import selenium.testingmachine.finance.financeRequest.firstInformation.employeeFromKhaan;
import selenium.testingmachine.finance.financeRequest.firstInformation.securedLoans;
import selenium.testingmachine.finance.financeRequest.firstInformation.shareHolders;
import selenium.testingmachine.finance.financeRequest.firstInformation.stocks;
import selenium.testingmachine.finance.financeRequest.firstInformation.subcontractor;

public class requestMain {

 public void mainSystem(){
        EdgeOptions options = new EdgeOptions();
        // options.addArguments("--headless=new");
        WebDriver driver = new EdgeDriver(options);
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
            businessInformation information = new businessInformation(driver);
            
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
