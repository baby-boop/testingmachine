package selenium.testingmachine.list;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mainList {

    public void main(){
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        try{

            Lists login = new Lists(driver);

            login.main();

        }finally {
            driver.quit();
            System.out.println("completed");

        }
    }
}
