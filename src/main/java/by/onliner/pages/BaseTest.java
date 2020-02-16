package by.onliner.pages;

import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import static com.simkin.framework.WebDriverInstance.*;

@Log4j
public class BaseTest {

    protected static WebApplication webaApp;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        setDriver(new ChromeDriver());
        webaApp = new WebApplication();
    }

    @BeforeMethod
    public void beforeMethod() {
        getDriver().get("https://onliner.by");
        maximizeBrowser();
    }

    @AfterMethod
    public void takeScreenshot() throws IOException {
        TakesScreenshot scr = ((TakesScreenshot) getDriver());
        File screenshot = scr.getScreenshotAs(OutputType.FILE);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FileUtils.copyFile(screenshot, new File("/Users/aliaksei.simkin/Documents/Automation/screenshots/test1-" + timestamp + " .png"));
    }

    @AfterSuite
    public void afterSuit() {
        getDriver().quit();
        log.info("All close up activities completed");
    }
}
