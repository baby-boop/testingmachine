package selenium.testingmachine.test.playwright;
import com.microsoft.playwright.*;

public class PlaywrightExample {
    public void main() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Open a website
            page.navigate("https://google.com");

            // Interact with an element
            page.fill("textarea[name='q']", "Hello, Playwright!");

            // Close the browser
            browser.close();
        }
    }
}
