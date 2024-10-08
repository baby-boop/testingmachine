package selenium.testingmachine.action;

import java.beans.Statement;

public class TestStep {
    private String action; // e.g., "click", "input", "navigate"
    private String target; // e.g., CSS selector, URL
    private String value;  // e.g., text to input

    // Getters and Setters
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
