package selenium.testingmachine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
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
        return createStatsDTO();
    }

    // public ResponseEntity<statsDTO> getStats() {
    //     statsDTO stats = createStatsDTO();
    //     return ResponseEntity.ok(stats);
    // }

    private statsDTO createStatsDTO() {
        int classCount = ClassCounter.getAllClassCount();
        int workingCount = ClassCounter.getWorkingAllClassCount();
        int errorCount = ErrorUtils.getErrorCount();
        int warningCount = ErrorUtils.getWarningCount();
        int infoCount = ErrorUtils.getInfoCount();
        int processCount = workingCount + errorCount + warningCount + infoCount;
        int percent = (classCount == 0) ? 0 : (processCount * 100) / classCount;

        return new statsDTO(classCount, errorCount, warningCount, workingCount, infoCount, processCount, percent);
    }
}
