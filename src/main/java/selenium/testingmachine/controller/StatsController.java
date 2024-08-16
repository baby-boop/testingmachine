package selenium.testingmachine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import selenium.testingmachine.config.ClassCounter;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.dto.statsDTO;

@RestController
@RequestMapping("/api")
public class StatsController {

    @GetMapping("/stats")    
    public statsDTO displayStats() {

        int classCount = ClassCounter.getAllClassCount();
        int workingCount = ClassCounter.getWorkingAllClassCount();
        int errorCount = ErrorUtils.getErrorCount();
        int warningCount = ErrorUtils.getWarningCount();
        int infoCount = ErrorUtils.getInfoCount();

        return new statsDTO(classCount, errorCount, warningCount, workingCount, infoCount);
    }
}
