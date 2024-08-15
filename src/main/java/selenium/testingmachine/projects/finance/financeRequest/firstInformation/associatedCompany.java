package selenium.testingmachine.projects.finance.financeRequest.firstInformation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.warningMessageField;

public class associatedCompany {

    public static @warningMessageField String message;

    private WebDriver driver;

    public associatedCompany(WebDriver driver) {
        this.driver = driver;
    }
    public void company(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement main = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Зээл, Зээлдэгчийн мэдээлэл')]")));
            main.click();

            Thread.sleep(2000);

            WebElement subMain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Холбоотой компани')]")));
            subMain.click();

            Thread.sleep(2000);

            // WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("add_btn")));
            // add.click();

            WebElement addRow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action-path='C10']")));
            addRow.click();

            Thread.sleep(1000);

            WebElement path1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C10.C1][6]")));
            path1.sendKeys("test1");

            WebElement path2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C10.C2][6]")));
            path2.sendKeys("101010");

            WebElement path3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C10.C3][6]")));
            path3.sendKeys("test2");

            WebElement path4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C10.C4][6]")));
            path4.sendKeys("test3");

            WebElement path5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C10.C5][6]")));
            path5.sendKeys("test4");

            WebElement path6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C10.C6][6]")));
            path6.sendKeys("test5");

            // WebElement path7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mvParam[C2.C8][5]")));
            // path7.sendKeys("test5");

            Thread.sleep(500);

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
                return;
            }

            Thread.sleep(1000);
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class: " + this.getClass().getSimpleName() + "<br>" + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished: "+ this.getClass().getSimpleName());
        }
    }
    private boolean isErrorMessagePresent(WebDriverWait wait) {
        try {
            WebElement errorContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".brighttheme.ui-pnotify-container")));
            WebElement errorTitle = errorContainer.findElement(By.cssSelector(".ui-pnotify-title"));
            String errorTitleText = errorTitle.getText();
            if (errorTitleText.contains("warning") || errorTitleText.contains("error")) {
                try {
                    wait.withTimeout(Duration.ofSeconds(2));
                    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-pnotify-text")));
                    String errorText = errorMessage.getText();
                    
                    String processName = "";
                    try {
                        WebElement mainProcess = driver.findElement(By.cssSelector("div.mb-1.d-flex.justify-content-between > p"));
                        processName = mainProcess.getText();
                    } catch (Exception e) {
                        System.out.println("Process name element not found: " + this.getClass().getName() + e.getMessage());
                    }
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Сахилга" +"<br>Алдаа: " + errorText;
                            
                    return errorMessage.isDisplayed();
                } catch (Exception e) {
                    System.out.println("Error while checking for error message: " + e.getMessage());
                    return false;
                } finally {
                    wait.withTimeout(Duration.ofSeconds(30));
                }
            }else{
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Error while checking for error title: " + e.getMessage());
            return false;
        }
    }
}