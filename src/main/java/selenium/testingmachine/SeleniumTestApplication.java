package selenium.testingmachine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.config.clearMessage;
import selenium.testingmachine.controller.Finished;
import selenium.testingmachine.projects.finance.financeRequest.requestMain;
import selenium.testingmachine.projects.finance.financeStandard.standardMain;
import selenium.testingmachine.projects.hr.mainHr;
import selenium.testingmachine.projects.hr_salary.mainSalary;
import selenium.testingmachine.projects.hr_time.timeMain;
import selenium.testingmachine.projects.office.officeContract;
import selenium.testingmachine.projects.office.officeTask;
import selenium.testingmachine.projects.store.storeMain;
import selenium.testingmachine.projects.strategic.businessProfileMain;
import selenium.testingmachine.projects.supply.mainSupply;
import selenium.testingmachine.projects.warehouse.warehouseMain;

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
                System.err.println("Модуль ажиллуулахад алдаа гарлаа: " + e.getMessage());
            }
        } else {
            System.out.println("Модуль олдсонгүй.");
        }
    }

    public String executeModule(String module) {
        String result;
        clearMessage messageClearer = new clearMessage();
            
        switch (module) {
            case "salary":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage();         
                      
                mainSalary salary = new mainSalary();
                salary.main_salary_system();
                result = "module finished.";
                
                break;
            case "time":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage(); 
                timeMain time = new timeMain();
                time.mainSystem();
                result = "module finished.";
                break;
            case "hr":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage(); 
                mainHr hr = new mainHr();
                hr.mainSystem();
                result = "module finished.";
                break;
            case "request":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage(); 
                requestMain requestMain = new requestMain();
                requestMain.mainSystem();
                result = "module finished.";
                break;
            case "contract":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage(); 
                officeContract contract = new officeContract();
                contract.mainSystem();
                result = "module finished.";
                break;
            case "task":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage(); 
                officeTask task = new officeTask();
                task.mainSystem();
                result = "module finished.";
                break;
            case "supply":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage(); 
                mainSupply supply = new mainSupply();
                supply.mainSystem();
                result = "module finished.";
                break;
            case "warehouse":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage(); 
                warehouseMain warehouseMain = new warehouseMain();
                warehouseMain.mainSystem();
                result = "module finished.";
                break;
            case "store":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage(); 
                storeMain store = new storeMain();
                store.mainSystem();
                result = "module finished.";
                break;
            case "standard":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage(); 
                standardMain standard = new standardMain();
                standard.mainSystem();
                result = "module finished.";
                break;
            case "strategic":
                System.out.println("Starting module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                Finished.clearFinishMessage(); 
                businessProfileMain profile = new businessProfileMain();
                profile.mainSystem();
                result = "module finished.";
                break;
            default:
                throw new IllegalArgumentException("Модуль олдсонгүй");
        }
        return result;
    }
}
