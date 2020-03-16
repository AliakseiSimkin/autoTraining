package by.onliner.pages;

import com.simkin.framework.Page;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public MainPage checkHeaderMenu(HeaderMenu headerMenu) {
        //WebElement headerMenuElement = getDriver().findElement( By.xpath("//span[@class=\"b-main-navigation__text\"]"));
        //span[@class="b-main-navigation__text"]
        List<WebElement> headerMenuAllElements = getDriver().findElements(By.xpath("//span[@class=\"b-main-navigation__text\"]"));
        boolean isFound = false;
        for ( WebElement headerMenuElement: headerMenuAllElements) {
            if (headerMenuElement.getText().equals(headerMenu.getMenuText())) {
                log.info("Header element " + headerMenuElement.getText() + " has been found");
                isFound = true;
                break;
            }
        }
        if (isFound == true) {
            log.info(headerMenu.getMenuText() + " header element exists");
            return this;
        } else throw new NotFoundException(headerMenu.getMenuText() + "header element is not found!");
    }
}
