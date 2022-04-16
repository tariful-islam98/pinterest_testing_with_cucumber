package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.WebConnector.driver;

public class ProfileEditPage {
    private By profileId = By.xpath("//div[@data-test-id=\"header-profile\"]");
    private By editBtn = By.xpath("//div[@data-test-id=\"edit-button\"]");
    private By lastNameInputField = By.xpath("//input[@id=\"last_name\"]");
    private By saveBtn = By.xpath("//div[@data-test-id=\"done-button\"]");
    private By toastDiv = By.xpath("//div[@data-test-id=\"toast\"]");

    public ProfileEditPage(Page page) {
    }

    public void clickProfileIcon(){
        driver.findElement(profileId).click();
    }

    public void clickEditProfile(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(editBtn));
        driver.findElement(editBtn).click();
    }

    public void clickLastNameField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInputField));
        driver.findElement(lastNameInputField).click();
    }

    public void enterLastName(String lastname){
        driver.findElement(lastNameInputField).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        driver.findElement(lastNameInputField).sendKeys(lastname);
    }

    public void clickSaveButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        driver.findElement(saveBtn).click();
    }

    public boolean isEdited(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastDiv));
        return driver.findElement(toastDiv).isDisplayed();
    }
}
