package selenium.testingmachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recording")
@CrossOrigin(origins = "http://localhost:3000")  // React connection
public class RecordingController {

    @Autowired
    private RecordingService recordingService;

    @PostMapping("/start")
    public String startRecording(@RequestBody String url) {
        recordingService.startRecording(url);
        return "Recording started";
    }

    @PostMapping("/stop")
    public List<RecordingAction> stopRecording() {
        return recordingService.stopRecording(); // Automatically saved
    }

    @GetMapping("/actions")
    public List<RecordingAction> getAllRecordings() {
        return recordingService.getAllRecordings(); // Return all saved actions
    }

    @PostMapping("/replay")
    public String replayRecording(@RequestBody List<RecordingAction> actions) {
        recordingService.replayActions(actions);
        return "Actions replayed";
    }
}
