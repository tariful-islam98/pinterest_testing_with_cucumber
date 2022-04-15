package base;

import core.WebConnector;
import io.cucumber.java.Before;
import pages.Page;

public class Base extends Page {
    @Before("@login")
    public void startTest(){
        WebConnector connector = new WebConnector();
        driver = connector.openBrowser();
        driver.get(properties.getProperty("weburl"));
        driver.manage().window().maximize();
    }

    @Before("@signup")
    public void startSignupTest(){
        WebConnector connector = new WebConnector();
        driver = connector.openBrowser();
        driver.get(properties.getProperty("weburl"));
        driver.manage().window().maximize();
    }

    @Before("@fblogin")
    public void startFbLoginTest(){
        WebConnector connector = new WebConnector();
        driver = connector.openBrowser();
        driver.get(properties.getProperty("weburl"));
        driver.manage().window().maximize();
    }

    @Before("@fbsignup")
    public void startFbSignupTest(){
        WebConnector connector = new WebConnector();
        driver = connector.openBrowser();
        driver.get(properties.getProperty("weburl"));
        driver.manage().window().maximize();
    }
}
