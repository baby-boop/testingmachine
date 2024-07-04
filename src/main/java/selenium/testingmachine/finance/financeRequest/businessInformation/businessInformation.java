package selenium.testingmachine.finance.financeRequest.businessInformation;

import org.openqa.selenium.WebDriver;

public class businessInformation {

    private WebDriver driver;

    public businessInformation(WebDriver driver) {
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

        } finally {
            // Do not quit the driver here
        }
    }
}
