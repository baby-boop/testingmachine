package selenium.testingmachine.projects.hr;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @PostMapping("/error")
    public String error(@RequestBody String errorMessage) {
        if (errorMessage == null || errorMessage.isEmpty()) {
            errorMessage = "No errors reported.";
        }

        System.out.println("Received error: " + errorMessage);
        return "Error received: " + errorMessage;
    }
}
