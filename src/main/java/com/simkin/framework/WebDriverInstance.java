package com.simkin.framework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


@Log4j
public class WebDriverInstance {
    private static WebDriver driver;

    public static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), 30);
    }

    public static Actions getActions() {
        return new Actions(getDriver());
    }

    public static void setDriver(WebDriver driver) {
        WebDriverInstance.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void implicitlyWait() { getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS); }

    public static void pageLoadTimeout() { getDriver().manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS); }

    public static void maximizeBrowser() { getDriver().manage().window().maximize(); }

    public static void hoverOver(WebElement element) { getActions().moveToElement(element).build().perform(); }

    public static void waitUntilVisibilityOfElementLocated(String xpathString) { getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathString))); }

    public static void waitUntilPresenceOfElementLocated (String xpathString) {
        getWait().until(presenceOfElementLocated(By.xpath(xpathString)));
    }
}
