package selenium.testingmachine;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import selenium.testingmachine.finance.financeRequest.requestMain;
import selenium.testingmachine.hr.mainHr;
import selenium.testingmachine.hr_salary.main_salary;

@SpringBootApplication
public class SeleniumTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SeleniumTestApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        String promptMessage = "Тест хийх модулиа сонгоно уу? (salary/hr/request): ";

        while (true) {
            System.out.println(promptMessage);
            choice = scanner.nextLine().trim().toLowerCase();
            switch (choice) {
                case "salary":
                    main_salary salary = new main_salary();
                    salary.main_salary_system();
                    break;
                case "hr":
                    mainHr hr = new mainHr();
                    hr.main_hr_system();
                    break;
                case "request":
                    requestMain main = new requestMain();
                    main.mainSystem();
                    break;
                case "task":
                    createTask task = new createTask();
                    task.login();
                    break;
                default:
                    System.out.println("Тухайн модуль олдсонгүй '" + choice + "'");
                    break;
            }
        }
    }
}
