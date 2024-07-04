package selenium.testingmachine.hr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import selenium.testingmachine.hr.command_directory.reasonForAssistance;
import selenium.testingmachine.hr.command_directory.reasonForDiscipline;
import selenium.testingmachine.hr.command_directory.reasonForDismissal;
import selenium.testingmachine.hr.command_directory.reasonForLeave;
import selenium.testingmachine.hr.command_directory.reasonForPrize;
import selenium.testingmachine.hr.command_directory.reasonForSuppport;
import selenium.testingmachine.hr.employee_directory.addressType;
import selenium.testingmachine.hr.employee_directory.examType;
import selenium.testingmachine.hr.employee_directory.familyType;
import selenium.testingmachine.hr.employee_directory.fileType;
import selenium.testingmachine.hr.employee_directory.formOfProperty;
import selenium.testingmachine.hr.employee_directory.prizeOfType;
import selenium.testingmachine.hr.main.allowenceOfBenefits;
import selenium.testingmachine.hr.main.employeeList;
import selenium.testingmachine.hr.main.employeeManagement;
import selenium.testingmachine.hr.main.jobCandidates;
import selenium.testingmachine.hr.main.jobCandidatesList;
import selenium.testingmachine.hr.main.jobDiscipline;
import selenium.testingmachine.hr.main.jobDismissed;
import selenium.testingmachine.hr.main.jobExtra;
import selenium.testingmachine.hr.main.jobLongLeave;
import selenium.testingmachine.hr.main.jobSalary;
import selenium.testingmachine.hr.main.jobTransitionalMovement;
import selenium.testingmachine.hr.main.labourBook;
import selenium.testingmachine.hr.main.openHr;
import selenium.testingmachine.hr.main.reassignment;
import selenium.testingmachine.hr.main.representativeEmployee;
import selenium.testingmachine.hr.master_data.positionList;
import selenium.testingmachine.hr.master_data.unitList;
import selenium.testingmachine.hr.master_data.workplaceList;
import selenium.testingmachine.hr.position_directory.dutiesForPosition;
import selenium.testingmachine.hr.position_directory.positionReasonLevel;
import selenium.testingmachine.hr.position_directory.positionReasonType;
import selenium.testingmachine.hr.position_directory.salaryTypeForPosition;
import selenium.testingmachine.hr.unit_directory.unitCodeType;
import selenium.testingmachine.hr.unit_directory.unitSegment;
import selenium.testingmachine.hr.unit_directory.unitStructure;
import selenium.testingmachine.hr.unit_directory.unitType;

public class mainHr {
    public void main_hr_system(){
        EdgeOptions options = new EdgeOptions();
        // options.addArguments("--headless=new");
        WebDriver driver = new EdgeDriver(options);
        
        try {
			openHr openHr = new openHr(driver);
            employeeManagement management = new employeeManagement(driver);
            employeeList list = new employeeList(driver);
            jobCandidates candidates = new jobCandidates(driver);
            jobCandidatesList candidate = new jobCandidatesList(driver);
            labourBook labour = new labourBook(driver);
            jobDismissed dismissed = new jobDismissed(driver);
            jobLongLeave longLeave = new jobLongLeave(driver);
            jobTransitionalMovement transitionalMovement = new jobTransitionalMovement(driver);
            allowenceOfBenefits benefits = new allowenceOfBenefits(driver);
            jobExtra extra = new jobExtra(driver);
            jobDiscipline discipline = new jobDiscipline(driver);
            jobSalary salary = new jobSalary(driver);
            representativeEmployee rEmployee = new representativeEmployee(driver);
            reassignment reassignment = new reassignment(driver);
            unitList unit = new unitList(driver);
            positionList position = new positionList(driver);
            workplaceList workplace = new workplaceList(driver); //department error
            fileType filetype = new fileType(driver);
            prizeOfType prize = new prizeOfType(driver); //primary key
            formOfProperty property = new formOfProperty(driver);
            examType exam = new examType(driver);
            addressType address = new addressType(driver);
            familyType family = new familyType(driver);
            reasonForDismissal dismissal = new reasonForDismissal(driver);
            reasonForAssistance assistance = new reasonForAssistance(driver);
            reasonForDiscipline discipline1 = new reasonForDiscipline(driver);
            reasonForPrize prize1 = new reasonForPrize(driver);
            reasonForLeave leave = new reasonForLeave(driver);
            reasonForSuppport support = new reasonForSuppport(driver);
            unitType unitType = new unitType(driver);
            unitCodeType codeType = new unitCodeType(driver);
            unitSegment segment = new unitSegment(driver);
            unitStructure structure = new unitStructure(driver);
            dutiesForPosition duties = new dutiesForPosition(driver);
            salaryTypeForPosition salaryType = new salaryTypeForPosition(driver);
            positionReasonType reasonType = new positionReasonType(driver);
            positionReasonLevel reasonLevel = new positionReasonLevel(driver);

		
			openHr.loginHr();
            management.employee();
            list.employees();
            candidates.candidates();
            candidate.candidate();
            labour.labour();
            dismissed.dismissed(); //wfmStatusError
            longLeave.longLeave();
            transitionalMovement.transition();
            benefits.benefits();
            extra.extra();
            discipline.warning();
            salary.salary();
            rEmployee.representative();
            reassignment.reassignment(); 
            // Ажилтны лавлах
            unit.unit();
            position.position();
            filetype.types();
            exam.types();
            family.types();
            address.types();
            property.property();
            prize.prize();
            // Тушаалын лавлах
            dismissal.reason();
            assistance.reason();
            discipline1.reason();
            prize1.reason(); //cannot 
            leave.reason();
            support.reason(); //check
            unitType.unit();
            codeType.unit();
            structure.unit(); //check
            segment.unit();
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
