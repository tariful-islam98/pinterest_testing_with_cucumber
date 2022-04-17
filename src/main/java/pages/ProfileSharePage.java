package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.WebConnector.driver;

public class ProfileSharePage {
    private By profileId = By.xpath("//div[@data-test-id=\"header-profile\"]");
    //Share Profile
    private By shareBtn = By.xpath("//button[@aria-label=\"Send Profile\"]");
    private By emailInputField = By.xpath("//input[@id=\"search\"]");
    private By contactId = By.xpath("//div[@class=\"RDc zI7 iyn Hsu\"]/div[@role=\"button\"]");
    private By msgField = By.xpath("//textarea[@id=\"sendObjectMessage\"]");
    private By sendBtn = By.xpath("//button[@type=\"submit\"]");

    public ProfileSharePage(Page page) {
    }

    public void clickProfileIcon(){
        driver.findElement(profileId).click();
    }

    public void clickShareBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(shareBtn));
        driver.findElement(shareBtn).click();
    }

    public void clickInputField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputField));
        driver.findElement(emailInputField).click();
    }

    public void typeEmail(String email){
        driver.findElement(emailInputField).sendKeys(email);
    }

    public void selectContact(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactId));
        driver.findElement(contactId).click();
    }

    public void writeMessage(String msg){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(msgField));
        driver.findElement(msgField).sendKeys(msg);
    }

    public void clickSendBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendBtn));
        driver.findElement(sendBtn).click();
    }

    public boolean isPopupDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputField));
        return driver.findElement(emailInputField).isDisplayed();
    }
}
