package selenium.testingmachine.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecordingService {

    private WebDriver driver;
    private final List<RecordingAction> actions = new ArrayList<>();
    private String sessionName;

    @Autowired
    private RecordingActionRepository repository;

    public void startRecording(String url) {
        sessionName = UUID.randomUUID().toString();
        WebDriver baseDriver = new ChromeDriver();
        CustomEventListener listener = new CustomEventListener(actions, sessionName);
        driver = new EventFiringDecorator(listener).decorate(baseDriver);
        driver.get(url);
    }

    public List<RecordingAction> stopRecording() {
        if (driver != null) {
            driver.quit();
        }
        saveRecording(actions);
        return actions;
    }

    public void saveRecording(List<RecordingAction> actions) {
        repository.saveAll(actions);
    }

    public List<RecordingAction> getAllRecordings() {
        return repository.findAll();
    }

    public void replayActions(List<RecordingAction> actions) {
        WebDriver replayDriver = new ChromeDriver();
        for (RecordingAction action : actions) {
            By locator = getBy(action.getLocatorType(), action.getLocatorValue());
            WebElement element = replayDriver.findElement(locator);

            switch (action.getActionType()) {
                case "click":
                    element.click();
                    break;
                case "sendKeys":
                    element.sendKeys(action.getValue());
                    break;
                case "navigate":
                    replayDriver.get(action.getValue());
                    break;
                // Add more action types as needed
            }
        }
        replayDriver.quit();
    }

    private By getBy(String locatorType, String locatorValue) {
        switch (locatorType) {
            case "id":
                return By.id(locatorValue);
            case "cssSelector":
                return By.cssSelector(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            // Add more locator types as needed
            default:
                throw new IllegalArgumentException("Invalid locator type");
        }
    }
}
