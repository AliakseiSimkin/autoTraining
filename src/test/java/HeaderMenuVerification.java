import by.onliner.pages.BaseTest;
import by.onliner.pages.HeaderMenu;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;

//java -Dmy.prop="my value" FilterTestSuite
@Log4j
public class HeaderMenuVerification extends BaseTest {
    @Test
    public void mainPageHeaderVerification() throws Exception {
        log.info("Thread is " + Thread.currentThread().getId());
        webApp.mainPage()
                .checkHeaderMenu(HeaderMenu.CATALOG)
                .checkHeaderMenu(HeaderMenu.NEWS)
                .checkHeaderMenu(HeaderMenu.CARMARKET)
                .checkHeaderMenu(HeaderMenu.HOUSES)
                .checkHeaderMenu(HeaderMenu.SERVICES)
                .checkHeaderMenu(HeaderMenu.FLEAMARKET)
                .checkHeaderMenu(HeaderMenu.FORUM);
    }
}