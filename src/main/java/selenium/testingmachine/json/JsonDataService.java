package selenium.testingmachine.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonDataService {

    @Autowired
    private JsonDataRepository repository;

    public JsonData saveJsonData(JsonData jsonData) {
        return repository.save(jsonData);
    }

    public JsonData getJsonDataByCode(Integer code) {
        return repository.findByCode(code);
    }
}
