package selenium.testingmachine.projects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.projects.store.main.createOrderFromStore;
import selenium.testingmachine.projects.store.masterdata.cashier;
import selenium.testingmachine.projects.store.masterdata.cozy;
import selenium.testingmachine.projects.store.masterdata.customer;
import selenium.testingmachine.projects.store.masterdata.customerGroup;
import selenium.testingmachine.projects.store.masterdata.location;
import selenium.testingmachine.projects.store.masterdata.product;
import selenium.testingmachine.projects.store.masterdata.productBrand;
import selenium.testingmachine.projects.store.masterdata.productGroup;
import selenium.testingmachine.projects.store.masterdata.productModel;
import selenium.testingmachine.projects.store.masterdata.productTreasurer;
import selenium.testingmachine.projects.store.masterdata.salePrice;
import selenium.testingmachine.projects.store.masterdata.section;
import selenium.testingmachine.projects.store.masterdata.store;
import selenium.testingmachine.projects.store.masterdata.treasurer;
import selenium.testingmachine.projects.store.masterdata.warehouse;

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

            ClassCounter.registerClass(store.getClass());
            ClassCounter.registerClass(cashier.getClass());
            ClassCounter.registerClass(section.getClass());
            ClassCounter.registerClass(group.getClass());
            ClassCounter.registerClass(model.getClass());
            ClassCounter.registerClass(brand.getClass());
            ClassCounter.registerClass(productTreasurer.getClass());
            ClassCounter.registerClass(product.getClass());
            ClassCounter.registerClass(cozy.getClass());
            ClassCounter.registerClass(warehouse.getClass());
            ClassCounter.registerClass(location.getClass());
            ClassCounter.registerClass(treasurer.getClass());
            ClassCounter.registerClass(salePrice.getClass());
            ClassCounter.registerClass(customerGroup.getClass());
            ClassCounter.registerClass(customer.getClass());
            ClassCounter.registerClass(createOrderFromStore.getClass());

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
