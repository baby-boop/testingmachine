package selenium.testingmachine.list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ListController {

    @GetMapping("/list")
    public List<ErrorMessageDTO> getAlerts() {
        return IsErrorList.getListMessages();
    }

    @GetMapping("/meta")
    public ListDTO displayList() {
        int processCount = Lists.getCheckCount();
        return new ListDTO(processCount);
    }

    @GetMapping("/timeout")
    public List<ErrorTimeoutDTO> getTimeoutErrors() {
        return Lists.errorTimeoutMessages();
    }
}
