package selenium.testingmachine.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/json-data")
public class JsonDataController {

    @Autowired
    private JsonDataService service;

    @PostMapping
    public JsonData saveJsonData(@RequestBody JsonData jsonData) {
        return service.saveJsonData(jsonData);
    }

    @GetMapping("/{code}")
    public JsonData getJsonData(@PathVariable Integer code) {
        return service.getJsonDataByCode(code);
    }

}
