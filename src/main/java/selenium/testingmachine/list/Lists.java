package selenium.testingmachine.list;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.testingmachine.config.ErrorUtils;
import selenium.testingmachine.controller.configController;

import java.util.Arrays;
import java.util.List;

public class Lists {
    private WebDriver driver;

    public Lists(WebDriver driver) {
        this.driver = driver;
    }

    public void main() {
        try {
            WebDriverWait wait = ListConfig.getWebDriverWait(driver);
            driver.get(ListConfig.URL);
            driver.manage().window().setSize(new Dimension(1500, 800));
            WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
            userNameField.sendKeys(ListConfig.USERNAME);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass_word")));
            passwordField.sendKeys(ListConfig.PASSWORD);
            passwordField.sendKeys(Keys.ENTER);

            Thread.sleep(3000);

            WebElement clickThat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'login/connectClient')]//h6[text()='Хишиг Арвин Индустриал']")));
            clickThat.click();

            Thread.sleep(2000);

            List<String> ids = DatabaseUtils.getIdsFromMetaList();

            int checkInt = 0;

            for (String id : ids) {
                String url = "http://202.131.244.213/mdobject/dataview/" + id;
//                String url = "https://dev.veritech.mn/mdobject/dataview/" + id;

                driver.get(url);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

                driver.navigate().refresh();

                if (IsErrorList.isErrorMessagePresent(driver, wait, id)) {
                    System.out.println("Error found for ID: " + id);
                }
                checkInt ++;
                System.out.println("Count: " + checkInt + "  id: " + id);
            }

        } catch (Exception e) {
            System.err.println("Error during login process: " + e.getMessage());
        }
    }
}
