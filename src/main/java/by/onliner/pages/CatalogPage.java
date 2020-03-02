package by.onliner.pages;

import com.simkin.framework.Page;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import static com.simkin.framework.Browser.*;

@Log4j
@NoArgsConstructor
public class CatalogPage extends Page {

    private String catalogMenuElementXpath = "//li[@data-id][%d]";
    private String navigationSubheaderElementXpath = "//div[contains(text(), \"%s\")]";
    private String whatToBuyElementXpath = "//span[contains(text(), \"%s\")]";



    public CatalogPage logMessages() {
        super.logMessages();
        return this;
    }

    @Override
    public CatalogPage checkHeader(String text) throws NotFoundException {
        super.checkHeader(text);
        return this;
    }

    public CatalogPage openCatalogSubMenu(@NotNull CatalogMenu catalogMenu) {
        catalogMenuElementXpath = String.format(catalogMenuElementXpath, catalogMenu.getSubMenuNumber());
        WebElement BeautySubMenu = getDriver().findElement(By.xpath(catalogMenuElementXpath));
        waitUntilVisibilityOfElementLocated(catalogMenuElementXpath);
        BeautySubMenu.click();
        return this;
    }

    public CatalogPage hobbyElementHoverOver() throws InterruptedException {
        Thread.sleep(1000);
        implicitlyWait();
        WebElement hobbyElement = getDriver().findElement(By.xpath(String.format(navigationSubheaderElementXpath, "Хобби")));
        hoverOver(hobbyElement);
        return this;
    }

    public CatalogFilterPage aeroElementClickButton() {
        String aeroElementXPath = String.format(whatToBuyElementXpath, "Радиоуправляемые авиамодели");
        WebElement aeroElement = getDriver().findElement(By.xpath(aeroElementXPath));
        waitUntilVisibilityOfElementLocated(aeroElementXPath);
        aeroElement.click();
        pageLoadTimeout();
        return new CatalogFilterPage();
    }
}