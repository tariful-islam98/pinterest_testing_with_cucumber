package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.WebConnector.driver;

public class LoginPage {
    private By loginBtn = By.xpath("//div[@data-test-id=\"simple-login-button\"]/button");//get login button
    private By userEmailField = By.id("email");
    private By userPasswordField = By.id("password");
    private By loginBtnPath = By.xpath("//div[@data-test-id=\"registerFormSubmitButton\"]/button");
    private By profileId = By.xpath("//div[@data-test-id=\"header-profile\"]");

    public LoginPage(Page page) {
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    public void setUserEmail(String userEmail) {
        driver.findElement(userEmailField).sendKeys(userEmail);
    }

    public void setPassword(String password) {
        driver.findElement(userPasswordField).sendKeys(password);
    }

    /**
     * TC_2.1
     * login with email and password
     * @return to Home Page
     */
    public void clickLogin() {
        driver.findElement(loginBtnPath).click();
    }

    public boolean isLoggedIn(){
        return driver.findElement(profileId).isDisplayed();
    }
}