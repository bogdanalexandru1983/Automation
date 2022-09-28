package com.pearson.automation.testBase;

import com.pearson.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.pearson.automation.utils.Constants.CHROME_DRIVER_PATH;
import static com.pearson.automation.utils.Constants.CONFIG_PATH;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class WebDriverContainer {
    private static WebDriver webDriver;

    public static WebDriver getDriver(){
        if (webDriver == null) {
            setup();
        }
        return webDriver;
    }

    public static WebDriver setup() {
        String browserInUse = ConfigReader.getProperty(CONFIG_PATH, "browser");
        switch (browserInUse) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.firefox.driver", CHROME_DRIVER_PATH);
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException(String.format("Browser in use: %s is not a valid type. ",browserInUse));
        }
        return webDriver;
    }

    public static void quit(){
        if(webDriver !=null){
            webDriver.quit();
            webDriver=null;
        }
    }

    public static void close(){
        if(webDriver !=null){
            webDriver.close();
        }
    }

}
