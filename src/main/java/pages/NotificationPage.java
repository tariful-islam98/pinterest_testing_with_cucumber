package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static core.WebConnector.driver;

public class NotificationPage {
    //Notification
    private By notificationIconLnk = By.xpath("//div[@aria-label=\"Notifications\"]");
    private By notificationList = By.xpath("//ul[@data-test-id=\"scrollable-list\"]");

    List<WebElement> options;

    public NotificationPage(Page page) {
    }

    public void clickNotificationIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationIconLnk));
        driver.findElement(notificationIconLnk).click();
    }

    public void selectNotification(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationList));
        WebElement ul = driver.findElement(notificationList);
        options = ul.findElements(By.tagName("li"));
        options.get(0).click();
    }

    public String getNotificationId(){
        return options.get(0).getAttribute("id");
    }
}
