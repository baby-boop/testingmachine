package selenium.testingmachine.projects.warehouse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.projects.warehouse.masterdata.locationWarehouse;
import selenium.testingmachine.projects.warehouse.masterdata.productBrandWarehouse;
import selenium.testingmachine.projects.warehouse.masterdata.productCategoryWarehouse;
import selenium.testingmachine.projects.warehouse.masterdata.productMaterialWarehouse;
import selenium.testingmachine.projects.warehouse.masterdata.productTypeWarehouse;
import selenium.testingmachine.projects.warehouse.masterdata.requestTypeWarehouse;
import selenium.testingmachine.projects.warehouse.masterdata.returnTypeWarehouse;
import selenium.testingmachine.projects.warehouse.masterdata.treasurerWarehouse;
import selenium.testingmachine.projects.warehouse.masterdata.warehouseMasterData;

public class warehouseMain {
    public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        try{

            warehouseLogin login = new warehouseLogin(driver);
            treasurerWarehouse treasurerWarehouse = new treasurerWarehouse(driver);
            warehouseMasterData warehouseMasterData = new warehouseMasterData(driver);
            locationWarehouse locationWarehouse = new locationWarehouse(driver);
            returnTypeWarehouse returnTypeWarehouse = new returnTypeWarehouse(driver);
            requestTypeWarehouse requestTypeWarehouse = new requestTypeWarehouse(driver);
            productMaterialWarehouse productMaterialWarehouse = new productMaterialWarehouse(driver);
            productCategoryWarehouse productCategoryWarehouse = new productCategoryWarehouse(driver);
            productTypeWarehouse productTypeWarehouse = new productTypeWarehouse(driver);
            productBrandWarehouse productBrandWarehouse = new productBrandWarehouse(driver);

            ClassCounter.registerClass(treasurerWarehouse.getClass());
            ClassCounter.registerClass(warehouseMasterData.getClass());
            ClassCounter.registerClass(locationWarehouse.getClass());
            ClassCounter.registerClass(returnTypeWarehouse.getClass());
            ClassCounter.registerClass(requestTypeWarehouse.getClass());
            ClassCounter.registerClass(productMaterialWarehouse.getClass());
            ClassCounter.registerClass(productCategoryWarehouse.getClass());
            ClassCounter.registerClass(productTypeWarehouse.getClass());
            ClassCounter.registerClass(productBrandWarehouse.getClass());
    
            login.login();
            treasurerWarehouse.data();
            warehouseMasterData.data();
            locationWarehouse.data();
            returnTypeWarehouse.data();
            requestTypeWarehouse.data();
            productMaterialWarehouse.data();
            productCategoryWarehouse.data();
            productTypeWarehouse.data();
            productBrandWarehouse.data();

        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }    
}
