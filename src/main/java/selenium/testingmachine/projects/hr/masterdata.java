package selenium.testingmachine.projects.hr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.controller.configController;
import selenium.testingmachine.projects.hr.command_directory.reasonForAssistance;
import selenium.testingmachine.projects.hr.command_directory.reasonForDiscipline;
import selenium.testingmachine.projects.hr.command_directory.reasonForDismissal;
import selenium.testingmachine.projects.hr.command_directory.reasonForLeave;
import selenium.testingmachine.projects.hr.command_directory.reasonForPrize;
import selenium.testingmachine.projects.hr.command_directory.reasonForSuppport;
import selenium.testingmachine.projects.hr.employee_directory.addressType;
import selenium.testingmachine.projects.hr.employee_directory.examType;
import selenium.testingmachine.projects.hr.employee_directory.familyType;
import selenium.testingmachine.projects.hr.employee_directory.fileType;
import selenium.testingmachine.projects.hr.employee_directory.formOfProperty;
import selenium.testingmachine.projects.hr.employee_directory.prizeOfType;
import selenium.testingmachine.projects.hr.main.allowenceOfBenefits;
import selenium.testingmachine.projects.hr.main.employeeList;
import selenium.testingmachine.projects.hr.main.employeeManagement;
import selenium.testingmachine.projects.hr.main.jobCandidates;
import selenium.testingmachine.projects.hr.main.jobCandidatesList;
import selenium.testingmachine.projects.hr.main.jobDiscipline;
import selenium.testingmachine.projects.hr.main.jobDismissed;
import selenium.testingmachine.projects.hr.main.jobExtra;
import selenium.testingmachine.projects.hr.main.jobLongLeave;
import selenium.testingmachine.projects.hr.main.jobSalary;
import selenium.testingmachine.projects.hr.main.jobTransitionalMovement;
import selenium.testingmachine.projects.hr.main.labourBook;
import selenium.testingmachine.projects.hr.main.reassignment;
import selenium.testingmachine.projects.hr.main.representativeEmployee;
import selenium.testingmachine.projects.hr.master_data.positionList;
import selenium.testingmachine.projects.hr.master_data.unitList;
import selenium.testingmachine.projects.hr.master_data.workplaceList;
import selenium.testingmachine.projects.hr.position_directory.dutiesForPosition;
import selenium.testingmachine.projects.hr.position_directory.positionReasonLevel;
import selenium.testingmachine.projects.hr.position_directory.positionReasonType;
import selenium.testingmachine.projects.hr.position_directory.salaryTypeForPosition;
import selenium.testingmachine.projects.hr.unit_directory.unitCodeType;
import selenium.testingmachine.projects.hr.unit_directory.unitSegment;
import selenium.testingmachine.projects.hr.unit_directory.unitStructure;
import selenium.testingmachine.projects.hr.unit_directory.unitType;

public class masterdata {
    public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        
        try {
			loginHr login = new loginHr(driver);
            // Ажилтны лавлах
            unitList unit = new unitList(driver);
            positionList position = new positionList(driver);
            workplaceList workplace = new workplaceList(driver);
            //processgu
            fileType filetype = new fileType(driver);
            prizeOfType prize = new prizeOfType(driver); //primary key
            formOfProperty property = new formOfProperty(driver);
            familyType family = new familyType(driver);
            examType exam = new examType(driver);
            addressType address = new addressType(driver);

            //Тушаалын лавлах
            reasonForDismissal dismissal = new reasonForDismissal(driver);
            reasonForAssistance assistance = new reasonForAssistance(driver);
            reasonForDiscipline discipline1 = new reasonForDiscipline(driver);
            reasonForPrize prize1 = new reasonForPrize(driver);
            reasonForLeave leave = new reasonForLeave(driver);
            reasonForSuppport support = new reasonForSuppport(driver);
            //update orsn
            //Бүтэц, нэгжийн лавлах
            unitType unitType = new unitType(driver);
            unitCodeType codeType = new unitCodeType(driver);
            unitSegment segment = new unitSegment(driver);
            unitStructure structure = new unitStructure(driver);
            //Албан тушаалын лавлах
            dutiesForPosition duties = new dutiesForPosition(driver);
            salaryTypeForPosition salaryType = new salaryTypeForPosition(driver);
            positionReasonType reasonType = new positionReasonType(driver);
            positionReasonLevel reasonLevel = new positionReasonLevel(driver);

             // Ажилтны лавлах
//             ClassCounter.registerClass(unit.getClass());
//             ClassCounter.registerClass(position.getClass());
//             ClassCounter.registerClass(workplace.getClass());
//             ClassCounter.registerClass(filetype.getClass());
//             ClassCounter.registerClass(prize.getClass());
//             ClassCounter.registerClass(property.getClass());
//             ClassCounter.registerClass(family.getClass());
//             ClassCounter.registerClass(exam.getClass());
//             ClassCounter.registerClass(address.getClass());
//             ClassCounter.registerClass(dismissal.getClass());
//             ClassCounter.registerClass(assistance.getClass());
//             ClassCounter.registerClass(discipline1.getClass());
//             ClassCounter.registerClass(prize1.getClass());
//             ClassCounter.registerClass(leave.getClass());
//             ClassCounter.registerClass(support.getClass());

             //test heseg
            ClassCounter.registerClass(unitType.getClass());
            ClassCounter.registerClass(codeType.getClass());
            ClassCounter.registerClass(segment.getClass());
            ClassCounter.registerClass(structure.getClass());
            ClassCounter.registerClass(duties.getClass());
            ClassCounter.registerClass(salaryType.getClass());
            ClassCounter.registerClass(reasonType.getClass());
            ClassCounter.registerClass(reasonLevel.getClass());

			login.loginHr();
//             // Ажилтны лавлах
//             unit.unit();
//             position.position();
//             workplace.workplace();
//             filetype.types();
//             prize.prize();
//             property.property();
//             family.types();
//             exam.types();
//             address.types();
////            Тушаалын лавлах
//             dismissal.reason();
//             assistance.reason();
//             discipline1.reason();
//             prize1.reason();
//             leave.reason();
//             support.reason();
//            // Бүтэц, нэгжийн лавлах
            unitType.unit();
            codeType.unit();
            structure.unit(); //check
            segment.unit();
            //Албан тушаалын лавлах
            duties.position();
            salaryType.position();
            reasonType.position();
            reasonLevel.position();
            


        } finally {
            driver.quit();
			System.out.println("completed");

        }
    }
}
