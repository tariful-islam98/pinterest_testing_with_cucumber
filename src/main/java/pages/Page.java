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

    SignupPage signupPage = new SignupPage(this);
    protected SignupPage getSignupPage(){return signupPage;}
}
