package selenium.testingmachine.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scrape")
public class ScraperController {

    @Autowired
    private WebScraperService webScraperService;

    @PostMapping("/playback")
    public String playback(@RequestBody PlaybackRequest request) {
        webScraperService.playbackActions(request.getUrl(), request.getActions());
        return "Playback started!";
    }
}

class PlaybackRequest {
    private String url;
    private List<String> actions;

    // Getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }
}
