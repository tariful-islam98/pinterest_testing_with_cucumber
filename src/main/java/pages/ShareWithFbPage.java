package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static core.WebConnector.driver;

public class ShareWithFbPage {
    private By fbBtn = By.xpath("//button[@aria-label=\"Share on Facebook\"]");

    public ShareWithFbPage(Page page) {
    }

    /**
     * Share by whatsapp
     */
    public void shareByFb(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fbBtn));
        driver.findElement(fbBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        wait.until(ExpectedConditions.titleContains("Facebook"));
        return driver.getTitle().contains("Facebook");
    }
}
