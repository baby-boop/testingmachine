package selenium.testingmachine.hr.master_data;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class unitList {
      private WebDriver driver;

    public unitList(WebDriver driver) {
        this.driver = driver;
    }
    public void unit(){
        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(500);
            WebElement openField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Мастер дата')]")));
            openField.click();
            Thread.sleep(2000);
            WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Нэмэх")));
            edit.click();

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

            // WebElement nxtSave = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-sm.btn-circle.btn-success.bpMainSaveButton.bp-btn-save")));
            // nxtSave.click();

            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-dialog-titlebar-close")));
            closeButton.click();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error class-unitList : " + e.getMessage());
            driver.quit();
        }finally{
            System.out.println("finished unitList");
        }
    }
}
