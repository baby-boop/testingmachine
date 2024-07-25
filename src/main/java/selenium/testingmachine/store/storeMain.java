package selenium.testingmachine.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import selenium.testingmachine.store.main.createOrderFromStore;
import selenium.testingmachine.store.masterdata.cashier;
import selenium.testingmachine.store.masterdata.cozy;
import selenium.testingmachine.store.masterdata.customer;
import selenium.testingmachine.store.masterdata.customerGroup;
import selenium.testingmachine.store.masterdata.location;
import selenium.testingmachine.store.masterdata.product;
import selenium.testingmachine.store.masterdata.productBrand;
import selenium.testingmachine.store.masterdata.productGroup;
import selenium.testingmachine.store.masterdata.productModel;
import selenium.testingmachine.store.masterdata.productTreasurer;
import selenium.testingmachine.store.masterdata.salePrice;
import selenium.testingmachine.store.masterdata.section;
import selenium.testingmachine.store.masterdata.store;
import selenium.testingmachine.store.masterdata.treasurer;
import selenium.testingmachine.store.masterdata.warehouse;

public class storeMain {
        public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        Actions actions = new Actions(driver);
        try{
            storeLogin login = new storeLogin(driver);
            store store = new store(driver);
            cashier cashier = new cashier(driver);
            section section = new section(driver);
            // pos pos = new pos(driver);
            productGroup group = new productGroup(driver);
            productModel model = new productModel(driver);
            productBrand brand = new productBrand(driver);
            productTreasurer productTreasurer = new productTreasurer(driver);
            product product = new product(driver);
            cozy cozy = new cozy(driver);
            warehouse warehouse = new warehouse(driver);
            location location = new location(driver);
            treasurer treasurer = new treasurer(driver);
            salePrice salePrice = new salePrice(driver);
            customerGroup customerGroup = new customerGroup(driver);
            customer customer = new customer(driver);
            createOrderFromStore createOrderFromStore = new createOrderFromStore(driver);

            login.login();
            store.data();
            cashier.data();
            section.data();
            // pos.data();
            group.data();
            model.data();
            brand.data();
            productTreasurer.data();
            product.data();
            cozy.data();
            warehouse.data();
            location.data();
            treasurer.data();
            salePrice.data();
            customerGroup.data();
            customer.data();
            createOrderFromStore.main();
            
        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }       
}
