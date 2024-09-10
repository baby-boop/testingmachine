package selenium.testingmachine.testJson;

import com.fasterxml.jackson.databind.ObjectMapper;

import selenium.testingmachine.controller.configController;

import org.springframework.web.client.RestTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class JsonProcessor {

    private WebDriver driver;

    public JsonProcessor(WebDriver driver) {
        this.driver = driver;
        
    }

    public void process() {
        WebDriverWait wait = configController.getWebDriverWait(driver);
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/get-json";
        String json = restTemplate.getForObject(apiUrl, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);

            for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
                String fieldPath = entry.getKey();
                String fieldData = entry.getValue().toString();

                WebElement locationNextDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-businessprocess-17149692898083")));

                WebElement field = wait.until(ExpectedConditions.elementToBeClickable(locationNextDiv.findElement(
                        By.name("param[" + fieldPath + "]")
                )));

                if(fieldPath==null){
                    System.err.println("fieldPath: " + fieldPath);
                }

                if (field != null) {
                    field.sendKeys(fieldData);
                } else {
                    System.err.println("Field not found or not visible: " + fieldPath);
                }
            }
            Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println("Error processing JSON: " + e.getMessage());
        } finally {
        }
    }
}
