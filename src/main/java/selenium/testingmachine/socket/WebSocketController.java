package selenium.testingmachine.socket;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public test sendTestMessage() {
        return createTest();
    }

    @GetMapping("/hello")
    public ResponseEntity<test> getStats() {
        test stats = createTest();
        return ResponseEntity.ok(stats);
    }

    private test createTest() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int t = a + b;

        test testObj = new test();
        testObj.setA(a);
        testObj.setB(b);
        testObj.setC(c);
        testObj.setD(d);
        testObj.setT(t);

        return testObj;
    }
}
