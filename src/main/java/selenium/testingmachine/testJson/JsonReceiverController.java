package selenium.testingmachine.testJson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonReceiverController {

    private Map<String, Object> storedJsonMap = new HashMap<>();

    @PostMapping("/receive-json")
    public String receiveJson(@RequestBody Map<String, Object> jsonMap) {
        System.out.println("Received JSON: " + jsonMap);

        this.storedJsonMap = jsonMap;

        return "JSON received successfully";
    }

    @GetMapping("/get-json")
    public ResponseEntity<Map<String, Object>> getJson() {
        return ResponseEntity.ok(this.storedJsonMap);
    }
}