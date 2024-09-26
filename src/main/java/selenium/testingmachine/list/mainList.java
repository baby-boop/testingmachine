package selenium.testingmachine.list;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mainList {

    public void mainSystem(){
        ChromeOptions options = new ChromeOptions();
/*         options.addArguments("--headless");*/
        WebDriver driver = new ChromeDriver(options);
        try{

            Lists login = new Lists(driver);

            login.mainList();

        }finally {
            driver.quit();
            System.out.println("completed");

        }
    }
}