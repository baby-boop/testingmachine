package selenium.testingmachine.list;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import selenium.testingmachine.testJson.JsonProcessor;
import selenium.testingmachine.testJson.lastRowEditAndDelete;
import selenium.testingmachine.testJson.testLogin;

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
