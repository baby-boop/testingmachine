package selenium.testingmachine.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import selenium.testingmachine.SeleniumTestApplication;

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

            if (Finished.hasFinishMessage()) {
                successMessage = Finished.getFinishMessage() + " " + moduleMessage;
                return successMessage; 
                
            }
        } catch (Exception e) {
            errorMessage = "Модуль ажиллуулахад алдаа гарлаа! ";
            return errorMessage;
        }

        return "Модуль бүрэн ажиллаж дуусаагүй";
    }
}
