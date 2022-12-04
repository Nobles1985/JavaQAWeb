package org.example.classfortesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ShopsPage extends AbstractPage{

    @FindBy(xpath = "//input[@placeholder='Название магазина, адрес или метро']")
    private WebElement searchForName;

    @FindBy(xpath = "(//a[@class='shop-list-item__shop-link'])[25]")
    private WebElement searchResult;

    @FindBy(css = ".shop-page__title")
    private WebElement nameResult;

    public ShopsPage(WebDriver driver) { super(driver, new Actions(driver)); }

    public ShopsPage sendSearchForName(){
        searchForName.sendKeys("Стар");
        return this;
    }

    public ShopsPage clickSearchResult(){
        searchResult.click();
        return this;
    }

    public WebElement getNameResult() { return nameResult; }
}