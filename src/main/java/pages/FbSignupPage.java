package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.WebConnector.driver;

public class FbSignupPage {
    private By signupBtnPath = By.xpath("//div[@data-test-id=\"simple-signup-button\"]/button");//get signup button
    private By fbSignupBtnPath = By.xpath("//div[@data-test-id = \"facebook-connect-button\"]/button");

    public FbSignupPage(Page page) {
    }

    public void clickSignupPage2(){
        driver.findElement(signupBtnPath).click();
    }

    public void clickFbBtn2(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fbSignupBtnPath));
        driver.findElement(fbSignupBtnPath).click();
    }

    public String isFbSignupWindowOpened(){
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()){
            if (!originalWindow.contentEquals(windowHandle)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return driver.getTitle();
    }
}
