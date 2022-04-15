package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.WebConnector.driver;

public class FbLoginPage {
    private By loginBtnPath = By.xpath("//div[@data-test-id=\"simple-login-button\"]/button");//get login button
    private By fbLoginBtnPath = By.xpath("//div[@data-test-id = \"facebook-connect-button\"]/button");

    public FbLoginPage(Page page) {
    }

    public void clickLoginButton(){
        driver.findElement(loginBtnPath).click();
    }

    public void clickFbLoginBtn(){
        driver.findElement(fbLoginBtnPath).click();
    }

    public String isWindowOpened(){
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
        return driver.getTitle();
    }
}
