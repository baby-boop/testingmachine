package selenium.testingmachine;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createTask {

    EdgeOptions options = new EdgeOptions();
        // options.addArguments("--headless=new");
    WebDriver driver = new EdgeDriver(options);
    public void login(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://vr.veritech.mn/login");
            driver.manage().window().setSize(new Dimension(1500, 800));
            WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
            userNameField.sendKeys("batdelger.a");
            // userNameField.sendKeys("admin");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass_word")));
            passwordField.sendKeys("batdelger@2023");
            passwordField.sendKeys(Keys.ENTER);

            String url = "https://vr.veritech.mn/appmenu#004";
            driver.get(url);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.location.href = arguments[0];", url);
            driver.navigate().refresh();

            // WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Оффиссын удирдлага')]")));
            // main.click();

            WebElement subMain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Ажил үүргийн удирдлага')]")));
            subMain.click();

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[taskName]")));
            name.sendKeys("cloud.veritech.mn дээр тестийн машин хөрвүүлэлт хийх");

            WebElement subname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[description]")));
            subname.sendKeys("cloud.veritech.mn дээр тестийн машин хөрвүүлэлт хийх");

            WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio'][@value='5']"));
            radioButton.click();

            WebElement department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("projectId_nameField")));
            department.sendKeys("Бусад");
            department.sendKeys(Keys.ENTER);

            WebElement saveAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn bp-btn-saveadd ')]")));
            saveAdd.click();

            Thread.sleep(500);

            WebElement sname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("param[taskName]")));
            sname.sendKeys("cloud.veritech.mn дээр тестийн машин хөрвүүлэлт хийх");

            WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            save.click();


        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-createTask : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished createTask");
            driver.quit();
        }
    }
}
