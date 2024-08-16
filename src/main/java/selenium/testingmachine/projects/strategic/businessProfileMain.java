package selenium.testingmachine.projects.strategic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import selenium.testingmachine.config.ClassCounter;

public class businessProfileMain {
    public void mainSystem(){
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        Actions actions = new Actions(driver);
        try{

            businessProfileLogin login = new businessProfileLogin(driver);
            businessProfile profile = new businessProfile(driver);
            businessDirection direction = new businessDirection(driver);

            ClassCounter.registerClass(profile.getClass());
            ClassCounter.registerClass(direction.getClass());

            login.login();
            profile.data();
            direction.data();
            



        }finally {
            driver.quit();
			System.out.println("completed");

        }
    }
}
