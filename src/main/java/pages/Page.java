package pages;

import core.ConfigUtil;
import core.WebConnector;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Page {
    public static Properties properties = ConfigUtil.getConfig("config");
    public WebDriver driver = WebConnector.driver;

    LoginPage loginPage = new LoginPage(this);
    protected LoginPage getLoginPage(){return loginPage;}

    FbLoginPage fbLoginPage = new FbLoginPage(this);
    protected FbLoginPage getFbLoginPage(){return fbLoginPage;}

    SignupPage signupPage = new SignupPage(this);
    protected SignupPage getSignupPage(){return signupPage;}

    FbSignupPage fbSignupPage = new FbSignupPage(this);
    protected FbSignupPage getFbSignupPage(){return fbSignupPage;}

    SearchPage searchPage = new SearchPage(this);
    protected SearchPage getSearchPage(){return searchPage;}

    NotificationPage notificationPage = new NotificationPage(this);
    protected NotificationPage getNotificationPage(){return notificationPage;}

    InboxPage inboxPage = new InboxPage(this);
    protected InboxPage getInboxPage(){return inboxPage;}

    ProfileEditPage editPage = new ProfileEditPage(this);
    protected ProfileEditPage getEditPage(){return editPage;}

    ProfileSharePage sharePage = new ProfileSharePage(this);
    protected ProfileSharePage getSharePage(){return sharePage;}

    ShareWithFbPage withFbPage = new ShareWithFbPage(this);
    protected ShareWithFbPage getWithFbPage(){return withFbPage;}

    ShareWithTwitterPage twitterPage = new ShareWithTwitterPage(this);
    protected ShareWithTwitterPage getTwitterPage(){return twitterPage;}

    public String currentUrl(){
        return driver.getCurrentUrl();
    }
}
