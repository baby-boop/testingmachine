package selenium.testingmachine.projects.finance.financeRequest.businessInformation;

import org.openqa.selenium.WebDriver;

public class businessInformationMain {

    private WebDriver driver;

    public businessInformationMain(WebDriver driver) {
        this.driver = driver;
    }

    public void mainSystem(){
        try {
            directions direction = new directions(driver);
            director director = new director(driver);
            supplier supplier = new supplier(driver);
            buyer buyer = new buyer(driver);
            mainEmployees employees = new mainEmployees(driver);
            businessDepartment department = new businessDepartment(driver);
            businessStandart standart = new businessStandart(driver);
            businessLicense license = new businessLicense(driver);
            otherInformation other = new otherInformation(driver);
            businessLoans loans = new businessLoans(driver);
            businessStocks stocks = new businessStocks(driver);
            fixedAssets assets = new fixedAssets(driver);
            movableAssets movable = new movableAssets(driver);
            financialReporting report = new financialReporting(driver);
            additionalFinancial additional = new additionalFinancial(driver);
            receivablesDetails receivable = new receivablesDetails(driver);
            prepaidExpenses prepaid = new prepaidExpenses(driver);
            paymentDetails payment = new paymentDetails(driver);
            prepaidIncome income = new prepaidIncome(driver);
            bankToReceiveSalesProceeds bank = new bankToReceiveSalesProceeds(driver);
            salesRevenue sales = new salesRevenue(driver);
            operationCost cost = new operationCost(driver);
            debtToIncomerRatio ratio = new debtToIncomerRatio(driver);
            barterAssets barter = new barterAssets(driver);


            direction.business();
            director.business();
            supplier.business();
            buyer.business();
            employees.business();
            department.business();
            standart.business();
            license.business();
            other.business();
            loans.business();
            stocks.business();
            assets.binance();
            movable.finance();
            report.finance();
            additional.finance();
            receivable.finance();
            prepaid.finance();
            payment.finance();
            income.finance();
            bank.finance();
            sales.finance();
            cost.finance();
            ratio.finance();
            barter.finance();

        } finally {
            
        }
    }
}
