package selenium.testingmachine.meta.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import selenium.testingmachine.meta.DTO.*;
import selenium.testingmachine.meta.Utils.CheckWorkflow;
import selenium.testingmachine.meta.Utils.IsErrorList;
import selenium.testingmachine.meta.MetaList.*;

import java.util.List;

@RestController
public class ListController {

    @GetMapping("/list")
    public List<ErrorMessageDTO> getAlerts() {
        return IsErrorList.getListMessages();
    }

    @GetMapping("/meta")
    public ListDTO displayList() {
        int processCount = MetaLists.getCheckCount();
        int workflowCount = CheckWorkflow.getWorkflowCount();
        return new ListDTO(processCount, workflowCount);
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

    @GetMapping("/nodata")
    public List<NotFoundRowDTO> getNoData() {
        return CheckWorkflow.getNotFoundRowCount();
    }

    @GetMapping("/workflow")
    public List<WorkflowMessageDTO> getWorkflow() {
        return CheckWorkflow.getWorkflowMessages();
    }

}