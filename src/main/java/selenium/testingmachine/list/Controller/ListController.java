package selenium.testingmachine.list.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import selenium.testingmachine.list.DTO.ErrorMessageDTO;
import selenium.testingmachine.list.DTO.ErrorTimeoutDTO;
import selenium.testingmachine.list.DTO.ListDTO;
import selenium.testingmachine.list.DTO.TotalDTO;
import selenium.testingmachine.list.Utils.IsErrorList;
import selenium.testingmachine.list.Lists;

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

    @GetMapping("/meta-total")
    public TotalDTO displayTotal() {
        int totalCount = Lists.getTotalCount();
        return new TotalDTO(totalCount);
    }

    @GetMapping("/timeout")
    public List<ErrorTimeoutDTO> getTimeoutErrors() {
        return Lists.errorTimeoutMessages();
    }
}
