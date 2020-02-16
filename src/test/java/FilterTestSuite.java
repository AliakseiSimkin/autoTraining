import by.onliner.pages.BaseTest;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import static com.simkin.framework.WebDriverInstance.getDriver;

public class FilterTestSuite extends BaseTest {

        @Test
        public void testOnliner() throws Exception {
            //start testing
            webaApp.mainPage()
                    .logMessages()
                    .openMainPage()
                    .catalogMenuButtonClick()
                    .beautyAndSportButtonClick()
                    .hobbyElementHoverOver().aeroElementClickButton()
                    //Проверить текст хедера "Радиоуправляемые авиамодели"
                    .checkHeader(getDriver().getTitle())
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
}
