package selenium.testingmachine.metaverse.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import selenium.testingmachine.metaverse.DTO.MVCountDTO;
import selenium.testingmachine.metaverse.DTO.MVErrorTimeoutDTO;
import selenium.testingmachine.metaverse.DTO.MVTotalDTO;
import selenium.testingmachine.metaverse.DTO.MVerrorMessageDTO;
import selenium.testingmachine.metaverse.Main.MVLists;
import selenium.testingmachine.metaverse.Utils.isErrorMv;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MVController {

    @GetMapping("/mv-message")
    public List<MVerrorMessageDTO> getAlerts() {
        return isErrorMv.getMvMessages();
    }

    @GetMapping("/metaverse")
    public MVCountDTO displayCount() {
        int inticatorCount = MVLists.getCheckMvCount();
        return new MVCountDTO(inticatorCount);
    }

    @GetMapping("/mv-total")
    public MVTotalDTO displayTotal() {
        int totalCount = MVLists.getMvTotalCount();
        return new MVTotalDTO(totalCount);
    }

    @GetMapping("/mv-timeout")
    public List<MVErrorTimeoutDTO> getMvTimeoutErrors() {
        return MVLists.MVErrorTimeoutMessages();
    }
}
