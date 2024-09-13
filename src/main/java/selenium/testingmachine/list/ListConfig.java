package selenium.testingmachine.list;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ListConfig {
    /**
     * DEV USER CONNECTION

    public static final String URL = "https://dev.veritech.mn/login";
    public static final String USERNAME = "shinetsetseg.sh";
    public static final String PASSWORD = "shinee@2023";
     */

    public static final String MainUrl = "http://202.131.244.213";
    public static final String URL = MainUrl + "/login";
    public static final String BaseUrl = MainUrl + "/mdobject/dataview/";
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "2762412..khai";

    public static final int TIMEOUT = 10;

    public static WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }
}
