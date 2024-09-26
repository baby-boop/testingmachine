package selenium.testingmachine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableScheduling;

import selenium.testingmachine.Selenium.SeleniumTestMain;
import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.config.clearMessage;
import selenium.testingmachine.list.mainList;
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
import selenium.testingmachine.testJson.mainTest;

@EnableScheduling
@SpringBootApplication
public class SeleniumTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SeleniumTestApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length > 0) {
            String module = args[0];
            try {
                String result = executeModule(module);
                System.out.println(result);
            } catch (Exception e) {
                System.err.println("Модуль ажиллуулахад алдаа гарлаа : " + e.getMessage());
            }
        } else {
            System.out.println("Модуль олдсонгүй .");
        }
    }

    public String executeModule(String module) {
        String result;

        switch (module) {


            case "list":
                System.out.println("Starting module...");
                resetEnvironment();
                mainList mainList = new mainList();
                mainList.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "test":
                System.out.println("Starting module...");
                resetEnvironment();
                mainTest test = new mainTest();
                test.main_test_system();
                result = "Тест хийж дууссан";
                break;
            case "testCase":
                System.out.println("Starting module...");
                resetEnvironment();
                SeleniumTestMain main = new SeleniumTestMain();
                main.runTest();
                result = "Тест хийж дууссан";
                break;

            case "salary":
                System.out.println("Starting module...");
                resetEnvironment();
                mainSalary salary = new mainSalary();
                salary.main_salary_system();
                result = "Тест хийж дууссан";

                break;
            case "time":
                System.out.println("Starting module...");
                resetEnvironment();
                timeMain time = new timeMain();
                time.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "hr":
                System.out.println("Starting module...");
                resetEnvironment();
                mainHr hr = new mainHr();
                hr.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "hrdata":
                System.out.println("Starting module...");
                resetEnvironment();
                masterdata hrdata = new masterdata();
                hrdata.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "request":
                System.out.println("Starting module...");
                resetEnvironment();
                requestMain requestMain = new requestMain();
                requestMain.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "contract":
                System.out.println("Starting module...");
                resetEnvironment();
                officeContract contract = new officeContract();
                contract.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "task":
                System.out.println("Starting module...");
                resetEnvironment();
                officeTask task = new officeTask();
                task.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "supply":
                System.out.println("Starting module...");
                resetEnvironment();
                mainSupply supply = new mainSupply();
                supply.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "warehouse":
                System.out.println("Starting module...");
                resetEnvironment();
                warehouseMain warehouseMain = new warehouseMain();
                warehouseMain.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "store":
                System.out.println("Starting module...");
                resetEnvironment();
                storeMain store = new storeMain();
                store.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "standard":
                System.out.println("Starting module...");
                resetEnvironment();
                standardMain standard = new standardMain();
                standard.mainSystem();
                result = "Тест хийж дууссан";
                break;
            case "strategic":
                System.out.println("Starting module...");
                resetEnvironment();
                businessProfileMain profile = new businessProfileMain();
                profile.mainSystem();
                result = "Тест хийж дууссан";
                break;
            default:
                throw new IllegalArgumentException("Модуль олдсонгүй");
        }
        return result;
    }
    private void resetEnvironment() {
        clearMessage messageClearer = new clearMessage();
        messageClearer.clearMessages();
        ClassCounter.clearRegisteredClasses();
        ErrorUtils.resetCounts();
    }
}
