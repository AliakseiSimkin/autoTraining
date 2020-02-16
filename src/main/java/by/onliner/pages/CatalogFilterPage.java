package by.onliner.pages;

import com.simkin.framework.Page;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.*;
import org.testng.Assert;

import static com.simkin.framework.WebDriverInstance.*;

@Log4j
@NoArgsConstructor
public class CatalogFilterPage extends Page {

    @Override
    public CatalogFilterPage logMessages() {
        super.logMessages();
        return this;
    }

    @Override
    public CatalogFilterPage openPage(String url) {
        super.openPage("https://catalog.onliner.by/radiocontrolair");
        return this;
    }

    @Override
    public CatalogFilterPage checkHeader(String text) throws NotFoundException {
        super.checkHeader(text);
        return this;
    }

    @Override
    public CatalogFilterPage scrollPageDown() {
        super.scrollPageDown();
        return this;
    }

    public CatalogFilterPage quadrocopterCheckboxCheck() {
        String quadrocopterCheckboxXpath = "//span[@class=\"schema-filter__checkbox-text\"][text()=\"квадрокоптер\"]";
        WebElement quadrocopterCheckbox = getDriver().findElement(By.xpath(quadrocopterCheckboxXpath));
        quadrocopterCheckbox.click();
        waitUntilPresenceOfElementLocated(quadrocopterCheckboxXpath);
        return this;
    }

    public CatalogFilterPage metalCheckboxCheck() {
        String metalCheckboxXpath = "//span[@class=\"schema-filter__checkbox-text\"][text()=\"металл\"]";
        WebElement metalCheckbox = getDriver().findElement(By.xpath(metalCheckboxXpath));
        waitUntilPresenceOfElementLocated(metalCheckboxXpath);
        metalCheckbox.click();
        return this;
    }

    public CatalogFilterPage plasticCheckboxCheck() {
        String plasticCheckboxXpath = "//span[@class=\"schema-filter__checkbox-text\"][text()=\"пластик\"]";
        WebElement plasticCheckbox = getDriver().findElement(By.xpath(plasticCheckboxXpath));
        waitUntilPresenceOfElementLocated(plasticCheckboxXpath);
        plasticCheckbox.click();
        return this;
    }

    public CatalogFilterPage setRangeOfActionFromInput(String fromValue) {
        WebElement rangeOfActionFromInput = getDriver().findElement(By.xpath("//input[@class=\"schema-filter-control__item schema-filter__number-input\"][@placeholder=\"5\"]"));
        rangeOfActionFromInput.sendKeys(fromValue);
        return this;
    }

    public CatalogFilterPage additionalParametersElementClick() {
        WebElement additionalParametersElement = getDriver().findElement(By.xpath("//a[text()=\"Дополнительные параметры\"]"));
        additionalParametersElement.click();
        return this;
    }

    public CatalogFilterPage brushlessCheckboxCheck() {
        String brushlessCheckboxXpath = "//span[@class=\"schema-filter__checkbox-text\"][text()=\"бесколлекторный\"]";
        WebElement brushlessCheckbox = getDriver().findElement(By.xpath(brushlessCheckboxXpath));
        waitUntilVisibilityOfElementLocated(brushlessCheckboxXpath);
        brushlessCheckbox.click();
        return this;
    }

    public CatalogFilterPage itemsFoundVerify(String expectedText) throws InterruptedException {
        Thread.sleep(1000);
        String itemsFoundXpath = "//span[contains(text(), \"Найдено\")]";
        WebElement itemsFound = getDriver().findElement(By.xpath("//span[contains(text(), \"Найдено\")]"));
        waitUntilVisibilityOfElementLocated(itemsFoundXpath);
        Assert.assertEquals(itemsFound.getText(), expectedText);
        return this;
    }

    public CatalogFilterPage atPage() {
        Assert.assertEquals(getDriver().getTitle(), "Товары в каталоге Onliner");
        return this;
    }
}
