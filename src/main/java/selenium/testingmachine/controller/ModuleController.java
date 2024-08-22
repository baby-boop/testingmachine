package selenium.testingmachine.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import selenium.testingmachine.SeleniumTestApplication;
import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;

@RestController
@RequestMapping("/api")
public class ModuleController {

    private final SeleniumTestApplication application;

    public ModuleController(SeleniumTestApplication application) {
        this.application = application;
    }

    @PostMapping("/module")
    public String executeModule(@RequestBody Map<String, String> request) {
        String module = request.get("module");
        String errorMessage = "";
        String successMessage = "";

        try {
            String moduleMessage = application.executeModule(module);

            int classCount = ClassCounter.getAllClassCount();
            int workingCount = ClassCounter.getWorkingAllClassCount();
            int errorCount = ErrorUtils.getErrorCount();
            int warningCount = ErrorUtils.getWarningCount();
            int infoCount = ErrorUtils.getInfoCount();
            int processCount = workingCount + errorCount + warningCount + infoCount;

            if (classCount == processCount) {
                successMessage = moduleMessage;
                return successMessage;
            }
            
        } catch (Exception e) {
            errorMessage = "Модуль ажиллуулахад алдаа гарлаа! ";
            return errorMessage;
        }

        return "Модуль бүрэн ажиллаж дуусаагүй";
    }
}
