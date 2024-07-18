package selenium.testingmachine.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import selenium.testingmachine.finance.financeRequest.businessInformation.additionalFinancial;
import selenium.testingmachine.finance.financeRequest.businessInformation.bankToReceiveSalesProceeds;
import selenium.testingmachine.finance.financeRequest.businessInformation.barterAssets;
import selenium.testingmachine.finance.financeRequest.businessInformation.businessLicense;
import selenium.testingmachine.finance.financeRequest.businessInformation.businessLoans;
import selenium.testingmachine.finance.financeRequest.businessInformation.businessStandart;
import selenium.testingmachine.finance.financeRequest.businessInformation.businessStocks;
import selenium.testingmachine.finance.financeRequest.businessInformation.buyer;
import selenium.testingmachine.finance.financeRequest.businessInformation.debtToIncomerRatio;
import selenium.testingmachine.finance.financeRequest.businessInformation.directions;
import selenium.testingmachine.finance.financeRequest.businessInformation.director;
import selenium.testingmachine.finance.financeRequest.businessInformation.financialReporting;
import selenium.testingmachine.finance.financeRequest.businessInformation.fixedAssets;
import selenium.testingmachine.finance.financeRequest.businessInformation.mainEmployees;
import selenium.testingmachine.finance.financeRequest.businessInformation.movableAssets;
import selenium.testingmachine.finance.financeRequest.businessInformation.operationCost;
import selenium.testingmachine.finance.financeRequest.businessInformation.otherInformation;
import selenium.testingmachine.finance.financeRequest.businessInformation.paymentDetails;
import selenium.testingmachine.finance.financeRequest.businessInformation.prepaidExpenses;
import selenium.testingmachine.finance.financeRequest.businessInformation.prepaidIncome;
import selenium.testingmachine.finance.financeRequest.businessInformation.receivablesDetails;
import selenium.testingmachine.finance.financeRequest.businessInformation.salesRevenue;
import selenium.testingmachine.finance.financeRequest.businessInformation.supplier;
import selenium.testingmachine.finance.financeRequest.firstInformation.associatedCompany;
import selenium.testingmachine.finance.financeRequest.firstInformation.creditHistory;
import selenium.testingmachine.finance.financeRequest.firstInformation.emergencyContact;
import selenium.testingmachine.finance.financeRequest.firstInformation.employeeFromKhaan;
import selenium.testingmachine.finance.financeRequest.firstInformation.securedLoans;
import selenium.testingmachine.finance.financeRequest.firstInformation.shareHolders;
import selenium.testingmachine.finance.financeRequest.firstInformation.stocks;
import selenium.testingmachine.finance.financeRequest.firstInformation.subcontractor;
import selenium.testingmachine.finance.financeRequest.request;
import selenium.testingmachine.hr.command_directory.reasonForAssistance;
import selenium.testingmachine.hr.command_directory.reasonForDiscipline;
import selenium.testingmachine.hr.command_directory.reasonForDismissal;
import selenium.testingmachine.hr.command_directory.reasonForLeave;
import selenium.testingmachine.hr.employee_directory.prizeOfType;
import selenium.testingmachine.hr.main.jobDismissed;
import selenium.testingmachine.hr.main.jobLongLeave;
import selenium.testingmachine.hr.position_directory.dutiesForPosition;
import selenium.testingmachine.hr.position_directory.positionReasonLevel;
import selenium.testingmachine.hr.position_directory.positionReasonType;
import selenium.testingmachine.hr.position_directory.salaryTypeForPosition;
import selenium.testingmachine.hr.unit_directory.unitCodeType;
import selenium.testingmachine.hr.unit_directory.unitSegment;
import selenium.testingmachine.hr.unit_directory.unitStructure;
import selenium.testingmachine.hr.unit_directory.unitType;
import selenium.testingmachine.hr_salary.master_data.salaryCalculatorMonth;
import selenium.testingmachine.hr_salary.salary_system.prlSalaryCalculator;
import selenium.testingmachine.hr_salary.salary_system.vacationCalculator;
import selenium.testingmachine.hr_time.notTimeRegistration;
import selenium.testingmachine.hr_time.planLongtime;
import selenium.testingmachine.office.contract.main.contractList;
import selenium.testingmachine.office.contract.main.registrationOfContracts;
import selenium.testingmachine.office.contract.masterdata.contractDirections;
import selenium.testingmachine.office.contract.masterdata.contractPaymentType;
import selenium.testingmachine.office.contract.masterdata.contractPrivacyType;
import selenium.testingmachine.office.contract.masterdata.contractReasonsForTermination;
import selenium.testingmachine.office.contract.masterdata.contractReminderDays;
import selenium.testingmachine.office.contract.masterdata.contractType;
import selenium.testingmachine.office.contract.masterdata.contractTypeOfLosses;
import selenium.testingmachine.office.task.main.registrationOfTask;
import selenium.testingmachine.office.task.masterdata.taskLevel;
import selenium.testingmachine.office.task.masterdata.taskType;
import selenium.testingmachine.supply.main.createOrder;
import selenium.testingmachine.supply.masterdata.goodsToBuy;
import selenium.testingmachine.supply.masterdata.productClassification;

@RestController
public class DashboardController {


    @GetMapping("/dashboard")

    public String displayClassName() {
        
        List<String> messages = Arrays.asList(
                prizeOfType.message, 
                jobDismissed.message, 
                jobLongLeave.message,
                reasonForDismissal.message,
                reasonForAssistance.message,
                reasonForDiscipline.message,
                // reasonForPrize.message
                reasonForLeave.message,
                // reasonForSuppport.message
                unitType.message,
                unitCodeType.message,
                unitSegment.message,
                unitStructure.message,
                dutiesForPosition.message,
                salaryTypeForPosition.message,
                positionReasonType.message,
                positionReasonLevel.message,
                salaryCalculatorMonth.message,
                vacationCalculator.message,
                prlSalaryCalculator.message,
                notTimeRegistration.message,
                planLongtime.message,
                request.message,
                associatedCompany.message,
                subcontractor.message,
                securedLoans.message,
                stocks.message,
                emergencyContact.message,
                creditHistory.message,
                employeeFromKhaan.message,
                shareHolders.message,
                directions.message,
                director.message,
                supplier.message,
                buyer.message,
                mainEmployees.message,
                businessStandart.message,
                businessLicense.message,
                otherInformation.message,
                businessLoans.message,
                businessStocks.message,
                fixedAssets.message,
                movableAssets.message,
                financialReporting.message,
                additionalFinancial.message,
                receivablesDetails.message,
                prepaidExpenses.message,
                paymentDetails.message,
                prepaidIncome.message,
                bankToReceiveSalesProceeds.message,
                salesRevenue.message,
                operationCost.message,
                debtToIncomerRatio.message,
                barterAssets.message,
                contractType.message,
                contractDirections.message,
                contractPaymentType.message,
                contractReminderDays.message,
                contractPrivacyType.message,
                contractTypeOfLosses.message,
                contractReasonsForTermination.message,
                registrationOfContracts.message,
                contractList.message,
                taskLevel.message,
                taskType.message,
                registrationOfTask.message,
                goodsToBuy.message,
                productClassification.message,
                supplier.message,
                createOrder.message
                );
        
        String concatenatedMessages = messages.stream()
                .filter(message -> message != null && !message.isEmpty())
                .collect(Collectors.joining("</p><p>", "<p>", "</p>"));

        return "<html><body>" + concatenatedMessages + "</body></html>";
    
    }
}
