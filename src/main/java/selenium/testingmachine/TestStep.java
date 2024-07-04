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

public class TestStep {

    EdgeOptions options = new EdgeOptions();
        // options.addArguments("--headless=new");
    WebDriver driver = new EdgeDriver(options);

    public void fullStep(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://testshuu.veritech.mn/login");
        driver.manage().window().setSize(new Dimension(1500, 800));
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
        userNameField.sendKeys("admin");

        try{
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass_word")));
            passwordField.sendKeys("89");
            passwordField.sendKeys(Keys.ENTER);
    
            String url = "https://testshuu.veritech.mn/appmenu/indexnew#16745416107063";
            driver.get(url);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.location.href = arguments[0];", url);
            driver.navigate().refresh();
    
            WebElement menuTileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, 'javascript:;')])[9]")));
            menuTileElement.click();
    
            WebElement openDirectory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Ажил горилогч')]")));
            openDirectory.click();
            System.out.println("1");
    
            WebElement checkpath = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='17152424082723")));
            checkpath.click();
            System.out.println("2");
    
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-labourBook" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("dd");
        }

        
    }
}
