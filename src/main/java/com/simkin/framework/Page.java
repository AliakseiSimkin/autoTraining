package com.simkin.framework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.simkin.framework.Browser.implicitlyWait;
import static com.simkin.framework.Browser.maximizeWindow;
import static com.simkin.framework.WebDriverInstance.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@Log4j
public class Page {

    protected Page logMessages() {
        log.debug("debug");
        return this;
    }

   protected Page openPage(String url) {

        getDriver().get(url);
       maximizeWindow();
       implicitlyWait();
       return this;
   }

    protected Page checkHeader(String text) throws NotFoundException {
        getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Assert.assertEquals(getDriver().getTitle(), text);
        return this;
    }

    protected Page scrollPageDown() {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,850)");
        return this;
    }


    public static void waitUntilVisibilityOfElementLocated(String xpathString) { getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathString))); }

    public static void waitUntilPresenceOfElementLocated (String xpathString) { getWait().until(presenceOfElementLocated(By.xpath(xpathString))); }
}