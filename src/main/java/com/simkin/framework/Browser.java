package com.simkin.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Browser extends WebDriverInstance {
    public Browser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                setDriver(new ChromeDriver());
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                setDriver(new FirefoxDriver());
                break;
            case SAFARI:
                setDriver(new SafariDriver());
                break;
            default: throw new WebDriverException("No Driver Specified");
        }

    }

    public Browser openUrl(String url) {
        getDriver().get(url);
        implicitlyWait();
        return this;
    }

    public static void implicitlyWait() { getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS); }

    public static void pageLoadTimeout() { getDriver().manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS); }

    public static void maximizeWindow() { getDriver().manage().window().maximize(); }

    public static void hoverOver(WebElement element) { getActions().moveToElement(element).build().perform(); }

    public void browserQuit() {
        getDriver().quit();
    }
}
