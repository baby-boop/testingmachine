package selenium.testingmachine.action;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    private List<TestCase> testCases = new ArrayList<>();

    @PostMapping
    public String createTest(@RequestBody TestCase testCase) {
        testCases.add(testCase);
        return "Test case added successfully!";
    }

    @GetMapping
    public List<TestCase> getAllTests() {
        return testCases;
    }

    @PostMapping("/run/{testName}")
    public String runTest(@PathVariable String testName) {
        TestCase testCase = testCases.stream()
                .filter(tc -> tc.getName().equalsIgnoreCase(testName))
                .findFirst()
                .orElse(null);

        if (testCase == null) {
            return "Test case not found!";
        }

        // Selenium WebDriver тохируулах
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\batde\\Documents\\chromedriver-win64\\chromedriver.exe"); // ChromeDriver-ийн замыг заана
        WebDriver driver = new ChromeDriver();
        StringBuilder result = new StringBuilder();
        try {
            for (TestStep step : testCase.getSteps()) {
                switch (step.getAction()) {
                    case "navigate":
                        driver.get(step.getTarget());
                        result.append("Navigated to ").append(step.getTarget()).append("\n");
                        Thread.sleep(3000);
                        break;
                    case "click":
                        driver.findElement(By.name(step.getTarget())).click();
                        result.append("Clicked on element ").append(step.getTarget()).append("\n");
                        Thread.sleep(3000);
                        break;
                    case "input":
                        driver.findElement(By.name(step.getTarget())).sendKeys(step.getValue());
                        result.append("Input value '").append(step.getValue()).append("' into ").append(step.getTarget()).append("\n");
                        Thread.sleep(3000);
                        break;
                    default:
                        result.append("Unknown action: ").append(step.getAction()).append("\n");
                }
            }
            return "Test executed successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Test execution failed: " + e.getMessage();
        } finally {
            driver.quit();
        }
    }
}
