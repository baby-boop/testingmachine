package selenium.testingmachine.testJson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class mainTest {
    public void main_test_system(){
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        try{

            testLogin login = new testLogin(driver);
            JsonProcessor process = new JsonProcessor(driver);
            lastRowEditAndDelete lastStep = new lastRowEditAndDelete(driver);

            login.login();
            process.process();
//            lastStep.crud();

        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }
}

