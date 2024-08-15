package selenium.testingmachine.projects.hr.unit_directory;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class unitStructure {

    public static @MessageField String message;

    private WebDriver driver;

    public unitStructure(WebDriver driver) {
        this.driver = driver;
    }
    public void unit(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(2000);
            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Мастер дата')]")));
            openField.click();

            Thread.sleep(1000);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Бүтэц, нэгжийн лавлах')]")));
            element.click();

            Thread.sleep(1000);
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-stepid='183320834")));
            link.click();

            Thread.sleep(2000);
            
            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='DEPARTMENT_NAME']")));
            name.sendKeys("test1");

            WebElement parent = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='PARENT_ID']")));
            parent.click();
            WebElement parentOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Боловсруулах цех']")));
            parentOption.click();

            WebElement type = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='CLASSIFICATION_ID']")));
            type.click();
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Борлуулалт']")));
            typeOption.click();

            WebElement types = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='TYPE_ID']")));
            types.click();
            WebElement typesOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Компани']")));
            typesOption.click();

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ml-1 btn btn-sm btn-circle btn-success bp-btn-save')]")));
            saveBtn.click();

            if (isErrorMessagePresent(wait)) {
                System.out.println("Error message found after saving. Exiting...");
                Thread.sleep(3500);
                
                WebElement cnclBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ui-dialog-titlebar-close')]")));
                cnclBtn.click();
                return;
            }
            
            WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='CITY_ID']")));
            city.click();
            WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Улаанбаатар']")));
            cityOption.click();

            WebElement district = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[DISTRICT_ID]_nameField")));
            district.sendKeys("Баянзүрх");
            district.sendKeys(Keys.ENTER);

            Thread.sleep(500);
            WebElement street = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mvParam[STREET_ID]_nameField")));
            street.sendKeys("28-р хороо");
            street.sendKeys(Keys.ENTER);

            WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-path='DESCRIPTION']")));
            description.sendKeys("38р гудамж");

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
            WebElement errorTitle = driver.findElement(By.cssSelector(".ui-pnotify-title"));
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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " -" +"<br>Алдаа: " + errorText;
                            
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

