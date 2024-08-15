package selenium.testingmachine.projects.hr.master_data;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testingmachine.config.MessageField;

public class positionList {

    public static @MessageField String message;

    private WebDriver driver;

    public positionList(WebDriver driver) {
        this.driver = driver;
    }
    public void position(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(2000);

            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-stepid='17149692930273']")));
            menu.click(); 
            
            Thread.sleep(2000);

            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            add.click();

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='positionName'] input[name='param[positionName]']")));
            name.sendKeys("test1");

            WebElement level = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='profLevelId']")));
            level.click();
            WebElement leveloption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Ажилтан']")));
            leveloption.click();

            WebElement type = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-s-path='classificationId']")));
            type.click();
            WebElement typeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Ажилтан']")));
            typeOption.click();

            WebElement levelParent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vocationGroupId_nameField")));
            levelParent.sendKeys("Программ зохиогч");
            levelParent.sendKeys(Keys.ENTER);

            WebElement salaryType = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-section-path='salaryTypeId'] div[data-s-path='salaryTypeId']")));
            salaryType.click();
            WebElement salaryTypeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label' and text()='Өдрөөр']")));
            salaryTypeOption.click();

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn main-run-btn bp-btn-save')]")));
            saveBtn.click();

            Thread.sleep(1000);
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@id,'datagrid-row')]")));
            List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@id,'datagrid-row')]"));
            if (!rows.isEmpty()) {
                WebElement lastRow = rows.get(rows.size() - 1);
                lastRow.click();

                WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Засах")));
                edit.click();

            } else {
                System.out.println("No rows found.");
            }

            Thread.sleep(1000);

            WebElement addName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-section-path='positionName'] input[name='param[positionName]']")));
            addName.sendKeys(" нэрийг солив");
            Thread.sleep(2000);

            WebElement editSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm bp-run-btn bp-btn-save  ')]")));
            editSave.click();

        
            // if (!rows.isEmpty()) {
            //     WebElement lastRow = rows.get(rows.size() - 1);
            //     lastRow.click();

            //     WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Устгах")));
            //     delete.click();

            // } else {
            //     System.out.println("No rows found.");
            // }
            // WebElement deletetn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn green-meadow btn-sm')]")));
            // deletetn.click();


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
                
                        message = "class: " + this.getClass().getName() + "<br>processName= " + processName + " - " +"<br>Алдаа: " + errorText;
                            
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