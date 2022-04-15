package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebConnector {

    public static Properties myProp = ConfigUtil.getConfig("config");

//    Properties browser= new Properties();

//    public Properties setConfig(){ return browser = ConfigUtil.getConfig("config"); }

    //    Properties OR = null;
//    Properties CONFIG = null;
    public static WebDriver driver = null;
//    String PathToParent = new File(System.getProperty("user.dir")).getPath();
//    String Path = PathToParent + File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"config"+File.separator;

//    public WebConnector(){
//        if (OR == null){
//            try {
//                // Initialize OR
//                OR = new Properties();
//                FileInputStream fs = new FileInputStream(Path+"OR.properties");
//                System.out.println(fs);
//                OR.load(fs);
//
//                // Initialize CONFIG
//                CONFIG = new Properties();
//
//                fs = new FileInputStream(Path+OR.getProperty("testEnv")+"_config.properties");
//                CONFIG.load(fs);
//
//            } catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
//    }

    public WebDriver openBrowser(){
        driver = null;
        if (driver==null) {

            String browserType = myProp.getProperty("browser");
            if (browserType.equalsIgnoreCase("Mozilla")) {
                if (System.getProperty("os.name").equals("Linux")) {
                    System.setProperty("webdriver.gecko.driver", "Geckodriver" + File.separator + "geckodriver_linux");
                } else if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.gecko.driver", "Geckodriver" + File.separator + "geckodriver.exe");
                } else {
                    System.setProperty("webdriver.gecko.driver", "Geckodriver" + File.separator + "geckodriver");
                }
                driver = new FirefoxDriver();
            } else if (browserType.equalsIgnoreCase("Chrome")) {
                if (System.getProperty("os.name").equals("Linux")) {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriver-Linux");
                } else if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriver.exe");
                    System.out.println(System.getProperty("os.name"));
                } else if (System.getProperty("os.name").contains("Mac")){
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "betachromedriver");
                }
                else {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedrivermac");
                }
                ChromeOptions options = new ChromeOptions();
                //options.setBinary("/usr/bin/google-chrome");
                options.addArguments("--headless");
                options.addArguments("start-maximized");
                options.addArguments("--disable-gpu");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver();
            } else if (browserType.equalsIgnoreCase("IE")) {
                if (System.getProperty("os.name").equals("Linux")) {
                    //System.setProperty("webdriver.ie.driver", "IEDriver"+File.separator+"chromedriver-Linux");
                } else if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.ie.driver", "IEDriver" + File.separator + "IEDriverServer.exe");
                } else {
                    //System.setProperty("webdriver.ie.driver", "IEDriver"+File.separator+"chromedriver");
                }
                driver = new InternetExplorerDriver();
            }
            else if (browserType.equalsIgnoreCase("headlesschrome")){
                if (System.getProperty("os.name").equals("Linux")) {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriverli");
                } else if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriver.exe");
                    System.out.println(System.getProperty("os.name"));
                } else {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriver");
                }
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=1366,768");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                driver = new ChromeDriver(options);
            }
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }
//    public void navigate(String URL){
//        driver.get(CONFIG.getProperty(URL));
//    }
//    public boolean isElementPresent(){
//        return true;
//    }
}
