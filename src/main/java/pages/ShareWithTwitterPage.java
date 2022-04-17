package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.WebConnector.driver;

public class ShareWithTwitterPage {
    private By twitterBtn = By.xpath("//button[@aria-label=\"Share on Twitter\"]");

    public ShareWithTwitterPage(Page page) {
    }

    /**
     * Share by twitter
     */
    public void sharByTwitter(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(twitterBtn));
        driver.findElement(twitterBtn).click();
    }

    public boolean isTabOpened(){
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

//        assert driver.getWindowHandles().size() == 1;
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()){
            if(!originalWindow.contentEquals(windowHandle)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(ExpectedConditions.titleContains("Twitter"));
        return driver.getTitle().contains("Twitter");
    }
}
