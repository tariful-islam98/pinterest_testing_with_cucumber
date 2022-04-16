package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static core.WebConnector.driver;

public class InboxPage {
    //Message
    private By inboxIconLnk = By.xpath("//div[@aria-label= \"Messages\"]");
    private By newMsgBtnLnk = By.xpath("//button[@aria-label= \"Compose new message\"]");
    private By contactInputField = By.xpath("//input[@id= \"contactSearch\"]");
    private By contactList = By.xpath("//div[@class= \"Jea gjz mQ8 wsz zI7 iyn Hsu\"]");
    private By msgInputField = By.xpath("//textarea[@id= \"messageDraft\"]");
    private By sendBtn = By.xpath("//button[@aria-label=\"Send message to conversation\"]");
    private By sentMessages = By.xpath("//div[@class=\"tBJ dyH iFc sAJ O2T zDA IZT swG\"]");

    public InboxPage(Page page) {
    }

    public void clickMsgIcon(){
        driver.findElement(inboxIconLnk).click();
    }

    public void clickNewMsgBtn(){
        driver.findElement(newMsgBtnLnk).click();
    }

    public void inputEmail(String email){
        driver.findElement(contactInputField).sendKeys(email);
    }

    public void selectContact(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactList));
        List<WebElement> contact = driver.findElements(contactList);
        contact.get(0).click();
    }

    public void typeMessage(String msg){
        driver.findElement(msgInputField).sendKeys(msg);
    }

    public void clickSendButton(){
        driver.findElement(sendBtn).click();
    }

    public boolean isSent(){
        return driver.findElement(sentMessages).isDisplayed();
    }
}
