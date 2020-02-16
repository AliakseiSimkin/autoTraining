package by.onliner.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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
    protected static ExtentTest logger;
    protected static ExtentHtmlReporter reporter;
    protected static ExtentReports extent;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        setDriver(new ChromeDriver());
        webaApp = new WebApplication();
    }

    @BeforeClass
    public void startTest() {
        reporter = new ExtentHtmlReporter("./reports/testOnlinerReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        logger = extent.createTest("testOnliner");
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
        logger.log(Status.PASS, "the test is finished successfully");
    }

    @AfterClass
    public static void endTest()
    {
        //extent.endTest(logger);
        extent.flush();
    }

    @AfterSuite
    public void afterSuit() {
        getDriver().quit();
        log.info("All close up activities completed");
    }
}
