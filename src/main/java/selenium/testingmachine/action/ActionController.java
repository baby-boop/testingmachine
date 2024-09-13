package selenium.testingmachine.action;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ActionController {

    @PostMapping("/actions")
    public String receiveActions(@RequestBody Map<String, Object> payload) {
        List<Map<String, String>> actions = (List<Map<String, String>>) payload.get("actions");

        // Үйлдлүүдийг боловсруулна
        actions.forEach(action -> {
            String type = action.get("type");
            String elementType = action.get("elementType");
            String elementId = action.get("elementId");
            String elementText = action.get("elementText");

            System.out.println("Үйлдэл: " + type + ", Элемент: " + elementType + ", ID: " + elementId + ", Текст: " + elementText);
        });

        // Энд өгөгдлийг өгөгдлийн санд хадгалах код бичиж болно
        return "Үйлдлүүдийг амжилттай хүлээн авлаа!";
    }
}
