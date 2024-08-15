package selenium.testingmachine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.config.clearMessage;
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
                System.out.println("Starting salary module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                mainSalary salary = new mainSalary();
                salary.main_salary_system();
                result = "Salary module finished.";
                break;
            case "time":
                System.out.println("Starting time module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                timeMain time = new timeMain();
                time.mainSystem();
                result = "Time module finished.";
                break;
            case "hr":
                System.out.println("Starting HR module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                mainHr hr = new mainHr();
                hr.main_hr_system();
                result = "HR module finished.";
                break;
            case "request":
                System.out.println("Starting request module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                requestMain requestMain = new requestMain();
                requestMain.mainSystem();
                result = "Request module finished.";
                break;
            case "contract":
                System.out.println("Starting contract module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                officeContract contract = new officeContract();
                contract.mainSystem();
                result = "Contract module finished.";
                break;
            case "task":
                System.out.println("Starting task module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                officeTask task = new officeTask();
                task.mainSystem();
                result = "Task module finished.";
                break;
            case "supply":
                System.out.println("Starting supply module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                mainSupply supply = new mainSupply();
                supply.mainSystem();
                result = "Supply module finished.";
                break;
            case "warehouse":
                System.out.println("Starting warehouse module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                warehouseMain warehouseMain = new warehouseMain();
                warehouseMain.mainSystem();
                result = "Warehouse module finished.";
                break;
            case "store":
                System.out.println("Starting store module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                storeMain store = new storeMain();
                store.mainSystem();
                result = "Store module finished.";
                break;
            case "standard":
                System.out.println("Starting standard module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                standardMain standard = new standardMain();
                standard.mainSystem();
                result = "Standard module finished.";
                break;
            case "strategic":
                System.out.println("Starting strategic module...");
                messageClearer.clearMessages();
                ClassCounter.clearRegisteredClasses();
                ErrorUtils.resetCounts();
                businessProfileMain profile = new businessProfileMain();
                profile.mainSystem();
                result = "Strategic module finished.";
                break;
            default:
                throw new IllegalArgumentException("Модуль олдсонгүй");
        }
        return result;
    }
}
