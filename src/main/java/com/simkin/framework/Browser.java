package com.simkin.framework;

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
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                setDriver(new ChromeDriver());
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                setDriver(new FirefoxDriver());
            case SAFARI:
                //System.setProperty("webdriver.safari.driver", "drivers/safari");
                setDriver(new SafariDriver());
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
