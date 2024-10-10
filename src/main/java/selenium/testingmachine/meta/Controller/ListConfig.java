package selenium.testingmachine.meta.Controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ListConfig {

    /*
     * DEV USER CONNECTION


    public static final String BaseUrl = "https://dev.veritech.mn";
    public static final String LoginUrl = BaseUrl + "/login";
    public static final String USERNAME = "shinetsetseg.sh";
    public static final String PASSWORD = "shinee@2023";
    public static final String MainUrl = BaseUrl + "/mdobject/dataview/";

//    public static final String MainUrl = BaseUrl + "/mdobject/dataview/16413658595761?";
//    public static final String tailUrl = "&mmid=164560279791910";
//    public static final String MetaverseURL= "/mdform/indicatorRender/";
   */

    /*
     * Хишиг арвин UAT USER CONNECTION
     */
    public static final String MainUrl = "http://202.131.244.213";
    public static final String LoginUrl = MainUrl + "/login";
    public static final String BaseUrl = MainUrl + "/mdobject/dataview/";
    public static final String USERNAME = "admin1";
    public static final String PASSWORD = "Khishigarvin*89";

    /*
    * Summit USER CONNECTION

    public static final String MainUrl = "http://192.168.60.43";
    public static final String LoginUrl = MainUrl + "/login";
    public static final String BaseUrl = MainUrl + "/mdobject/dataview/";
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "VrSummit@123";
*/

    /*
     * Хишиг арвин prod USER CONNECTION

    public static final String MainUrl = "http://202.131.244.211";
    public static final String LoginUrl = MainUrl + "/login";
    public static final String BaseUrl = MainUrl + "/mdobject/dataview/";
    public static final String USERNAME = "admin1";
    public static final String PASSWORD = "Khishigarvin*89";
*/

    public static final int TIMEOUT = 10;

    public static WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }
}
