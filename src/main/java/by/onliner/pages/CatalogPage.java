package by.onliner.pages;

import com.simkin.framework.Page;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import static com.simkin.framework.WebDriverInstance.*;

@Log4j
@NoArgsConstructor
public class CatalogPage extends Page {

    public CatalogPage logMessages() {
        super.logMessages();
        return this;
    }

    public CatalogPage openCatalogPage() {
        openPage("https://catalog.onliner.by/");
        return this;
    }

    @Override
    public CatalogPage checkHeader(String text) throws NotFoundException {
        super.checkHeader(text);
        return this;
    }

    public CatalogPage beautyAndSportButtonClick() {
        String beautyAndSportXPath = "//span[contains(text(), \"Красота и\")]";
        waitUntilVisibilityOfElementLocated(beautyAndSportXPath);
        WebElement beautyAndSportButton = getDriver().findElement(By.xpath(beautyAndSportXPath));
        beautyAndSportButton.click();
        return this;
    }

    public CatalogPage hobbyElementHoverOver() throws InterruptedException {
        Thread.sleep(1000);
        implicitlyWait();
        WebElement hobbyElement = getDriver().findElement(By.xpath("//div[contains(text(), \"Хобби\")]"));
        hoverOver(hobbyElement);
        return this;
    }

    public CatalogFilterPage aeroElementClickButton() {
        String aeroElementXPath = "//span[contains(text(), \"Радиоуправляемые авиамодели\")]";
        WebElement aeroElement = getDriver().findElement(By.xpath(aeroElementXPath));
        waitUntilVisibilityOfElementLocated(aeroElementXPath);
        aeroElement.click();
        pageLoadTimeout();
        return new CatalogFilterPage();
    }
}