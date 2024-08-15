package selenium.testingmachine.projects.supply;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import selenium.testingmachine.projects.supply.main.createOrder;
import selenium.testingmachine.projects.supply.masterdata.goodsToBuy;
import selenium.testingmachine.projects.supply.masterdata.productClassification;
import selenium.testingmachine.projects.supply.masterdata.productPort;
import selenium.testingmachine.projects.supply.masterdata.supplier;

public class mainSupply {
    public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        Actions actions = new Actions(driver);
        try{
            supplyLogin login = new supplyLogin(driver);
            goodsToBuy buy = new goodsToBuy(driver);
            productClassification classification = new productClassification(driver);
            supplier supplier = new supplier(driver);
            productPort port = new productPort(driver);
            createOrder order = new createOrder(driver);

            login.login();
            buy.data();
            classification.data();
            supplier.data();
            port.data();
            order.main();

        }finally {
            driver.quit();
            System.out.println("completed");
        }
    }       
}
