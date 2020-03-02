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

    public String catalogFilterPageHeader = "Радиоуправляемые авиамодели";
    private String checkboxRelativeXpath = "//span[@class=\"schema-filter__checkbox-text\"][text()=\"%s\"]";
    private String aByText = "//a[text()=\"%s\"]";
    private String spanByText = "//span[contains(text(), \"%s\")]";
    private String inputByPlaceholderValue = "//input[@class=\"schema-filter-control__item schema-filter__number-input\"][@placeholder=\"%s\"]";



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
        String quadrocopterCheckboxXpath = String.format(checkboxRelativeXpath, "квадрокоптер");
        WebElement quadrocopterCheckbox = getDriver().findElement(By.xpath(quadrocopterCheckboxXpath));
        quadrocopterCheckbox.click();
        waitUntilPresenceOfElementLocated(quadrocopterCheckboxXpath);
        return this;
    }

    public CatalogFilterPage metalCheckboxCheck() {
        String metalCheckboxXpath = String.format(checkboxRelativeXpath, "металл");
        WebElement metalCheckbox = getDriver().findElement(By.xpath(metalCheckboxXpath));
        waitUntilPresenceOfElementLocated(metalCheckboxXpath);
        metalCheckbox.click();
        return this;
    }

    public CatalogFilterPage plasticCheckboxCheck() {
        String plasticCheckboxXpath = String.format(checkboxRelativeXpath, "пластик");
        WebElement plasticCheckbox = getDriver().findElement(By.xpath(plasticCheckboxXpath));
        waitUntilPresenceOfElementLocated(plasticCheckboxXpath);
        plasticCheckbox.click();
        return this;
    }

    public CatalogFilterPage setRangeOfActionFromInput(String fromValue) {
        WebElement rangeOfActionFromInput = getDriver().findElement(By.xpath(String.format(inputByPlaceholderValue, "5")));
        rangeOfActionFromInput.sendKeys(fromValue);
        return this;
    }

    public CatalogFilterPage additionalParametersElementClick() {
        WebElement additionalParametersElement = getDriver().findElement(By.xpath(String.format(aByText, "Дополнительные параметры")));
        additionalParametersElement.click();
        return this;
    }

    public CatalogFilterPage brushlessCheckboxCheck() {
        String brushlessCheckboxXpath = String.format(checkboxRelativeXpath, "бесколлекторный");
        WebElement brushlessCheckbox = getDriver().findElement(By.xpath(brushlessCheckboxXpath));
        waitUntilVisibilityOfElementLocated(brushlessCheckboxXpath);
        brushlessCheckbox.click();
        return this;
    }

    public CatalogFilterPage itemsFoundVerify(String expectedText) throws InterruptedException {
        Thread.sleep(1000);
        String itemsFoundXpath = String.format(spanByText, "Найдено");
        WebElement itemsFound = getDriver().findElement(By.xpath(itemsFoundXpath));
        waitUntilVisibilityOfElementLocated(itemsFoundXpath);
        Assert.assertEquals(itemsFound.getText(), expectedText);
        return this;
    }

    public CatalogFilterPage atPage() {
        Assert.assertEquals(getDriver().getTitle(), "Товары в каталоге Onliner");
        return this;
    }
}
