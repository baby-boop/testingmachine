package selenium.testingmachine.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import selenium.testingmachine.store.masterdata.cashier;
import selenium.testingmachine.store.masterdata.pos;
import selenium.testingmachine.store.masterdata.section;
import selenium.testingmachine.store.masterdata.store;

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
            pos pos = new pos(driver);

            login.login();


        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }       
}
