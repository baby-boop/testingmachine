package selenium.testingmachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableScheduling;

import selenium.testingmachine.Selenium.SeleniumTestMain;
import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.config.clearMessage;
import selenium.testingmachine.meta.MetaList.MetaMain;
import selenium.testingmachine.metaverse.Main.MVMain;
import selenium.testingmachine.projects.finance.financeRequest.requestMain;
import selenium.testingmachine.projects.finance.financeStandard.standardMain;
import selenium.testingmachine.projects.hr.mainHr;
import selenium.testingmachine.projects.hr.masterdata;
import selenium.testingmachine.projects.hr_salary.mainSalary;
import selenium.testingmachine.projects.hr_time.timeMain;
import selenium.testingmachine.projects.office.officeContract;
import selenium.testingmachine.projects.office.officeTask;
import selenium.testingmachine.projects.store.storeMain;
import selenium.testingmachine.projects.strategic.businessProfileMain;
import selenium.testingmachine.projects.supply.mainSupply;
import selenium.testingmachine.projects.warehouse.warehouseMain;
import selenium.testingmachine.test.WebScraperService;
import selenium.testingmachine.test.cucumber.CucumberExample;
import selenium.testingmachine.test.playwright.PlaywrightExample;
import selenium.testingmachine.testJson.mainTest;

import java.io.IOException;

@EnableScheduling
@SpringBootApplication
public class SeleniumTestApplication {



    public static void main(String[] args) {
        SpringApplication.run(SeleniumTestApplication.class, args);
        MetaMain MetaMain = new MetaMain();
        MetaMain.mainSystem();
    }


}
