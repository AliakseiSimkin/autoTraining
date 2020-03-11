import by.onliner.pages.BaseTest;

import by.onliner.pages.CatalogMenu;
import by.onliner.pages.HeaderMenu;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Log4j
public class FiltersTest extends BaseTest {
    @Test(priority = 0)
    public void testOnliner() throws Exception {
        log.info("Thread is " + Thread.currentThread().getId());
        webApp.mainPage()
                .openHeaderMenu(HeaderMenu.CATALOG)
                .openCatalogSubMenu(CatalogMenu.BEAUTY)
                .hobbyElementHoverOver().aeroElementClickButton()
                //Проверить текст хедера "Радиоуправляемые авиамодели"
                .checkHeader("Квадрокоптер купить в Минске. Радиоуправляемые самолеты")
                .scrollPageDown()
                //Check checkboxes to setup a filter
                .quadrocopterCheckboxCheck()
                .metalCheckboxCheck()
                .plasticCheckboxCheck()
                .scrollPageDown()
                .setRangeOfActionFromInput("100")
                .scrollPageDown()
                .additionalParametersElementClick()
                .brushlessCheckboxCheck()
                .scrollPageDown()
                //Check how many items were found
                .itemsFoundVerify("Найдено 102 товара");
    }

    @Test (priority = 1)
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