package org.example.classfortesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends AbstractPage{

    @FindBy(xpath = "//a[contains(text(),'17 дюймов')]")
    private WebElement monitorSize;

    @FindBy(xpath = "//a[contains(text(),'Игровые')]")
    private WebElement gamingLaptop;

    @FindBy(xpath = "//div[@class='products-page__list']//div[2]//div[2]//div[4]//button[2]")
    private WebElement buttonBuy;

    @FindBy(xpath = "//button[contains(text(),'В корзине')]")
    private WebElement buttonBasket;

    @FindBy(xpath = "(//button[@class='button-ui button-ui_white button-ui_icon wishlist-btn'])[1]")
    private WebElement addWishlist;

    @FindBy(xpath = "//a[contains(text(),'+ Общий список')]")
    private WebElement addGeneralList;

    @FindBy(xpath = "//span[@class='cart-link-counter__badge']")
    private WebElement shoppingCounter;

    @FindBy(css = ".wishlist-link-counter__badge")
    private WebElement wishCounter;

    public CatalogPage(WebDriver driver) { super(driver, new Actions(driver)); }

    public void scrollPage(){
        getActions().scrollByAmount(0, 450).build().perform();
    }

    public void clickMonitorSize() {
        getActions().click(monitorSize).pause(1000).build().perform();
    }

    public void clickGamingLaptop() {
        getActions().click(gamingLaptop).pause(1000).build().perform();
    }

    public void clickButtonBuy() { getActions().click(buttonBuy).pause(2000).build().perform(); }

    public CatalogPage clickButtonBasket(){
        buttonBasket.click();
        return this;
    }

    public CatalogPage clickAddWishlist(){
        addWishlist.click();
        return this;
    }

    public WebElement getShoppingCounter() { return shoppingCounter; }

    public WebElement getWishCounter() { return wishCounter; }

    public void clickAddGeneralList() { getActions().click(addGeneralList).pause(2000).build().perform(); }
}
