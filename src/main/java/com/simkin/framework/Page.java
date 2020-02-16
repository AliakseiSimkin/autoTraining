package com.simkin.framework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.simkin.framework.WebDriverInstance.*;

@Log4j
public class Page {

    protected Page logMessages() {
        log.debug("debug");
        return this;
    }

   protected Page openPage(String url) {
       getDriver().get(url);
       maximizeBrowser();
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
}