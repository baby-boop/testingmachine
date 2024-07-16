package selenium.testingmachine.supply;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import selenium.testingmachine.supply.masterdata.goodsToBuy;
import selenium.testingmachine.supply.masterdata.productClassification;
import selenium.testingmachine.supply.masterdata.productPort;
import selenium.testingmachine.supply.masterdata.supplier;

public class mainSupply {
    public void mainSystem(){
        EdgeOptions options = new EdgeOptions();
        // options.addArguments("--headless=new");
        WebDriver driver = new EdgeDriver(options);
        try{
            supplyLogin login = new supplyLogin(driver);
            goodsToBuy buy = new goodsToBuy(driver);
            productClassification classification = new productClassification(driver);
            supplier supplier = new supplier(driver);
            productPort port = new productPort(driver);

            login.login();
            buy.data();
            classification.data();
            supplier.data();
            port.data();

        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }       
}
