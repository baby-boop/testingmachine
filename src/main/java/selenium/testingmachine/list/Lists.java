package selenium.testingmachine.list;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Lists {
    private final WebDriver driver;
    private static int processCount = 0;

    public Lists(WebDriver driver) {
        this.driver = driver;
    }

    public void main() {
        try {
            WebDriverWait wait = ListConfig.getWebDriverWait(driver);
            driver.get(ListConfig.URL);
            driver.manage().window().setSize(new Dimension(1500, 800));

            // Login Process
            WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
            userNameField.sendKeys(ListConfig.USERNAME);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass_word")));
            passwordField.sendKeys(ListConfig.PASSWORD);
            passwordField.sendKeys(Keys.ENTER);

            Thread.sleep(3000);

            WebElement clickThat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'login/connectClient')]//h6[text()='Хишиг Арвин Индустриал']")));
            clickThat.click();

            Thread.sleep(2000);

            String directoryPath = "C:\\Users\\batde\\Downloads\\Hishig arvin uat lookupIds";

            File folder = new File(directoryPath);
            File[] listOfFiles = folder.listFiles((dir, name) -> name.endsWith(".txt"));

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    System.out.println("Processing file: " + file.getName());

                    List<String> ids = readIdsFromFile(file.getAbsolutePath());

                    for (String id : ids) {
                        String url = ListConfig.BaseUrl + id;
                        driver.get(url);
                        driver.navigate().refresh();

                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
                        waitForLoadToDisappear();
                        waitForLoadingToDisappear();
                        if (IsErrorList.isErrorMessagePresent(driver, id, file.getName())) {
                            System.out.println("Error found for ID: " + id);
                        }
                        processCount++;
                        System.out.println("Processed Count: " + processCount + ", ID: " + id);
                    }
                }
            } else {
                System.err.println("No .txt files found in directory: " + directoryPath);
            }

        } catch (Exception e) {
            System.err.println("Error during process: " + e.getMessage());
        }
    }

    private List<String> readIdsFromFile(String fileName) throws IOException {
        List<String> ids = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    ids.add(line.trim());
                }
            }
        }
        return ids;
    }

    private void waitForLoadingToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        try {
            WebElement loadingMessage = driver.findElement(By.xpath("//div[contains(@class, 'datagrid-mask-msg') and text()='Түр хүлээнэ үү']"));
            if (loadingMessage.isDisplayed()) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'datagrid-mask-msg') and text()='Түр хүлээнэ үү']")));
//                System.out.println("Түр хүлээнэ үү.");
            }
        } catch (NoSuchElementException e) {
//            System.out.println("Loading message was not present, proceeding without waiting.");
        }
    }

    private void waitForLoadToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        try {
            WebElement loadingMessages =  driver.findElement(By.cssSelector("div.loading-message.loading-message-boxed"));
            if (loadingMessages.isDisplayed()) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loading-message.loading-message-boxed")));
//                System.out.println("Loading message waiting for ...");
            }
        } catch (NoSuchElementException e) {
//            System.out.println("Loading message not disapper int time.");
        }
    }

    public static int getCheckCount() {
        return processCount;
    }
}
