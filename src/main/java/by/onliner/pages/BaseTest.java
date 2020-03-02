package by.onliner.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.simkin.framework.Browser;
import com.simkin.framework.BrowserType;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

import static com.simkin.framework.WebDriverInstance.*;

@Log4j
public class BaseTest {

    private Browser browser;

    protected static WebApplication webaApp;
    protected static ExtentTest extentTest;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentReports extentReports;

    protected FileInputStream fis;
    protected Properties property;
    protected String envUrl;
    protected String testSuiteName;

    @SneakyThrows
    @BeforeSuite
    public void beforeSuite() {
        browser = new Browser(BrowserType.CHROME);
        webaApp = new WebApplication();
        property = new Properties();

        try {
            fis = new FileInputStream("src" + File.separator + "main" + File.separator + "resources" + File.separator + "onlinerProd.properties");
            property.load(fis);
            envUrl = property.getProperty("env");
            testSuiteName = property.getProperty("testSuiteName");

            log.info("Environment URL is " + envUrl);
            log.info("The following tests will be run " + testSuiteName);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("File not found or it cannot be read");
        } finally {
            fis.close();
        }
    }

    @BeforeClass
    public void startTest() {
        extentHtmlReporter = new ExtentHtmlReporter("./reports/testOnlinerReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }

    @BeforeMethod
    public void beforeMethod() {
        extentTest = extentReports.createTest(testSuiteName);
        browser.openUrl(envUrl);
        browser.maximizeWindow();
    }

    @AfterMethod
    public void takeScreenshot() throws IOException {
        TakesScreenshot scr = ((TakesScreenshot) getDriver());
        File screenshot = scr.getScreenshotAs(OutputType.FILE);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FileUtils.copyFile(screenshot, new File(File.separator + "Users" + File.separator + "aliaksei.simkin" + File.separator + "Documents" + File.separator + "Automation" + File.separator + "screenshots" + File.separator + "test1-" + timestamp + " .png"));
        extentTest.log(Status.PASS, "the test is finished successfully");
        extentTest = null;
    }

    @AfterSuite
    public void afterSuit() {
        browser.browserQuit();
        log.info("All close up activities completed");
        extentReports.flush();
    }
}
