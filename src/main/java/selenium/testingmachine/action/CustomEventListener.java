package selenium.testingmachine.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.List;

public class CustomEventListener implements WebDriverListener {

    private final List<RecordingAction> actions;
    private final String sessionName;

    public CustomEventListener(List<RecordingAction> actions, String sessionName) {
        this.actions = actions;
        this.sessionName = sessionName;
    }

    @Override
    public void beforeClick(WebElement element) {
        actions.add(new RecordingAction(sessionName, "click", getLocatorType(element), getElementLocator(element), null));
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        actions.add(new RecordingAction(sessionName, "sendKeys", getLocatorType(element), getElementLocator(element), String.join("", keysToSend)));
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        actions.add(new RecordingAction(sessionName, "findElement", locator.toString(), null, null));
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        actions.add(new RecordingAction(sessionName, "foundElement", locator.toString(), getElementLocator(result), null));
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation,String url){
        actions.add(new RecordingAction(sessionName, "navigate", "url", null, url));
    }

    private String getElementLocator(WebElement element) {
        try {
            String id = element.getAttribute("id");
            String css = element.getCssValue("css");
            return id != null ? id : css;
        } catch (Exception e) {
            return "Unknown";
        }
    }

    private String getLocatorType(WebElement element) {
        // This method should be updated to return actual locator type if needed
        return "cssSelector";
    }
}
