package selenium.testingmachine.meta.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import selenium.testingmachine.meta.DTO.ErrorMessageDTO;
import selenium.testingmachine.meta.DTO.ErrorTimeoutDTO;
import selenium.testingmachine.meta.DTO.ListDTO;
import selenium.testingmachine.meta.DTO.TotalDTO;
import selenium.testingmachine.meta.Utils.IsErrorList;
import selenium.testingmachine.meta.MetaList.*;

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
        int processCount = MetaLists.getCheckCount();
        return new ListDTO(processCount);
    }

    @GetMapping("/meta-total")
    public TotalDTO displayTotal() {
        int totalCount = MetaLists.getTotalCount();
        return new TotalDTO(totalCount);
    }

    @GetMapping("/timeout")
    public List<ErrorTimeoutDTO> getTimeoutErrors() {
        return MetaLists.errorTimeoutMessages();
    }
}
