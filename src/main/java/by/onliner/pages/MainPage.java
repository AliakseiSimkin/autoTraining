package by.onliner.pages;

import com.simkin.framework.Page;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import static com.simkin.framework.Browser.implicitlyWait;
import static com.simkin.framework.WebDriverInstance.*;

@Log4j
@NoArgsConstructor
public class MainPage extends Page {
    private String headerMenuXpath = "//span[@class=\"b-main-navigation__text\" and text()=\"%s\"]";
    private String subHeaderMenuXpath = "//li[@data-id][%d]";

    @Override
    public MainPage logMessages() {
        super.logMessages();
        return this;
    }

    public MainPage openMainPage() {
        openPage("https://onliner.by");
        return this;
    }

    @Override
    public MainPage checkHeader(String text) throws NotFoundException {
        super.checkHeader(text);
        return this;
    }

    public CatalogPage openHeaderMenu(HeaderMenu headerMenu) {
        getDriver().findElement(By.xpath(String.format(headerMenuXpath, headerMenu.getMenuText()))).click();
        implicitlyWait();
        waitUntilVisibilityOfElementLocated(String.format(subHeaderMenuXpath, CatalogMenu.BEAUTY.getSubMenuNumber()));
        return new CatalogPage();
    }
}
