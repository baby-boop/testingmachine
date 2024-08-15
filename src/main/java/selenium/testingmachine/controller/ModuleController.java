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
        String responseMessage;

        try {
            responseMessage = application.executeModule(module);
        } catch (Exception e) {
            responseMessage = "Модуль ажиллуулахад алдаа гарлаа: " ;
            // + e.getMessage()
        }

        return responseMessage;
    }
}
