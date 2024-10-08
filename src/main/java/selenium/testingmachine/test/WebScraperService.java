package selenium.testingmachine.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebScraperService {

    public void playbackActions(String url, List<String> actions) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\batde\\Documents\\chromedriver-win64\\chromedriver.exe");

        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        options.addArguments("--disable-gpu"); // Applicable to Windows OS

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(url);
            for (String action : actions) {
                String[] parts = action.split(",");
                String actionType = parts[0];
                String selector = parts[1];

                if ("click".equals(actionType)) {
                    driver.findElement(By.cssSelector(selector)).click();
                } else if ("type".equals(actionType)) {
                    String text = parts[2]; // Assuming text to type is passed
                    driver.findElement(By.cssSelector(selector)).sendKeys(text);
                }
                // Add more action types as needed
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
