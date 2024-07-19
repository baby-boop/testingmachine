package selenium.testingmachine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import selenium.testingmachine.finance.financeRequest.requestMain;
import selenium.testingmachine.hr.mainHr;
import selenium.testingmachine.hr_salary.main_salary;
import selenium.testingmachine.office.officeContract;
import selenium.testingmachine.office.officeTask;
import selenium.testingmachine.store.storeMain;
import selenium.testingmachine.supply.mainSupply;

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
                executeModule(module);
            } catch (Exception e) {
                System.err.println("Модуль ажиллуулахад алдаа гарлаа: " + e.getMessage());
            }
        } else {
            System.out.println("Модуль олдсонгүй.");
        }
    }

    public void executeModule(String module) {
        switch (module) {
            case "salary":
                main_salary salary = new main_salary();
                salary.main_salary_system();
                System.out.println("Salary running");
                break;
            case "hr":
                mainHr hr = new mainHr();
                hr.main_hr_system();
                System.out.println("HR running");
                break;
            case "request":
                requestMain requestMain = new requestMain();
                requestMain.mainSystem();
                System.out.println("Request running");
                break;
            case "contract":
                officeContract contract = new officeContract();
                contract.mainSystem();
                System.out.println("Contract running");
                break;
            case "task":
                officeTask task = new officeTask();
                task.mainSystem();
                System.out.println("Task running");
                break;
            case "supply":
                mainSupply supply = new mainSupply();
                supply.mainSystem();
                System.out.println("Supply running");
                break;
            case "store":
                storeMain store = new storeMain();
                store.mainSystem();
                System.out.println("Store running");
                break;
            default:
                throw new IllegalArgumentException("Модуль олдсонгүй");
        }
    }
}
