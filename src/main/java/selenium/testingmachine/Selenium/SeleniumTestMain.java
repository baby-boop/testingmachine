package selenium.testingmachine.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTestMain {

    private WebDriver driver;

    public SeleniumTestMain() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-popup-blocking");
        driver = new ChromeDriver(options);
    }

    public void runTest() {
        SeleniumLogin login = new SeleniumLogin(driver);
        SampleTest sampleTest = new SampleTest(driver);

        login.login();
        sampleTest.test();
    }

}
