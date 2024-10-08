package selenium.testingmachine.test.cucumber;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberExample {

        WebDriver driver;

        @Given("I am on the Google search page")
        public void i_am_on_the_google_search_page() {
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
        }

        @When("I search for {string}")
        public void i_search_for() {
            driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Hello, " );
            driver.findElement(By.name("q")).submit();
        }

        @Then("I should see search results")
        public void i_should_see_search_results() {
            driver.quit();
        }


}
