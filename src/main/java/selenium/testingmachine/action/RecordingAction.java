package selenium.testingmachine.action;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Timestamp;

@Entity
public class RecordingAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionName;
    private String actionType; // e.g., "click", "sendKeys", "navigate"
    private String locatorType; // e.g., "id", "cssSelector", "xpath"
    private String locatorValue;
    private String value; // For sending keys or navigation URL
    private Timestamp timestamp;

    public RecordingAction() {}

    public RecordingAction(String sessionName, String actionType, String locatorType, String locatorValue, String value) {
        this.sessionName = sessionName;
        this.actionType = actionType;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
        this.value = value;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getLocatorType() {
        return locatorType;
    }

    public void setLocatorType(String locatorType) {
        this.locatorType = locatorType;
    }

    public String getLocatorValue() {
        return locatorValue;
    }

    public void setLocatorValue(String locatorValue) {
        this.locatorValue = locatorValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
