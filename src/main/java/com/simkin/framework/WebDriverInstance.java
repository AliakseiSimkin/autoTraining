package com.simkin.framework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
