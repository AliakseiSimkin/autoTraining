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
public class MainPage extends Page {

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

    public CatalogPage catalogMenuButtonClick() {
        WebElement catalogMenuButton = getDriver().findElement(By.xpath("//a[@href=\"https://catalog.onliner.by/\"]"));
        catalogMenuButton.click();
        implicitlyWait();
        waitUntilVisibilityOfElementLocated("//span[contains(text(), \"Красота и\")]");
        return new CatalogPage();
    }
}
