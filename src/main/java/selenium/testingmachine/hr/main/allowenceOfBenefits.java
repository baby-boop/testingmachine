package selenium.testingmachine.hr.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class allowenceOfBenefits {
    public static @MessageField String message;
    private WebDriver driver;

    public allowenceOfBenefits(WebDriver driver) {
        this.driver = driver;
    }
    public void benefits(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17149688562173']")));
            menu.click();

            Thread.sleep(2000);

            WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Тэтгэмж хөнгөлөлт']")));
            subMenu.click();

            Thread.sleep(2000);

            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='bookDate']")));
            date.sendKeys("2024-06-07");

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='description'] textarea[name='param[description]']")));
            description.sendKeys("Тэтгэвэр олгомж");

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldEmployeeKeyId_nameField")));
            name.sendKeys("Бат-оргил");
            name.sendKeys(Keys.ENTER);

            WebElement benefitsType = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_param[HCM_LABOUR_BOOK_DTL.supportTypeId][0][]")));
            benefitsType.click();
            WebElement benefitsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Тусламж']")));
            benefitsOption.click();

            WebElement benefitsName= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='HCM_LABOUR_BOOK_DTL.supportSubTypeId']")));
            benefitsName.click();
            WebElement nameOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Түлээ нүүрсний тусламж']")));
            nameOption.click();

            WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='HCM_LABOUR_BOOK_DTL.startDate']")));
            startDate.sendKeys("2024-06-07"); 

            WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='HCM_LABOUR_BOOK_DTL.amountextra'] input[data-path='HCM_LABOUR_BOOK_DTL.amountextra']")));
            amount.sendKeys("800000");

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn btn-sm btn-circle btn-success bpMainSaveButton bp-btn-save')]")));
            saveBtn.click();
            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting..." + this.getClass().getName());
                Thread.sleep(3000);
                
                WebElement closeMessageBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".brighttheme-icon-closer")));
                closeMessageBtn.click();

                Thread.sleep(2000);
                return;
            }

            Thread.sleep(2000);


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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - Тэтгэмж хангамж" +"<br>Алдаа: " + errorText;
                            
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
