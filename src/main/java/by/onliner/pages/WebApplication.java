package by.onliner.pages;

public class WebApplication extends BaseTest{

    public MainPage mainPage(){ return new MainPage(); }
    public CatalogPage catalogPage(){ return new CatalogPage(); }
    public CatalogFilterPage catalogFilterPage(){ return new CatalogFilterPage(); }
}
