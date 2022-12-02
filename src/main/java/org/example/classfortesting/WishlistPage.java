package org.example.classfortesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends AbstractPage{

    @FindBy(xpath = "//span[contains(text(),'Выбрать все')]")
    private WebElement chooseAll;

    @FindBy(xpath = "//button[@class='button-ui button-ui_white profile-wishlist-management__controls_delete']")
    private WebElement buttonBasket;

    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement buttonDelete;

    @FindBy(css = ".profile-wishlist__sum")
    private WebElement wishlistSum;

    @FindBy(css = ".profile-wishlist__empty-image")
    private WebElement wishlistEmpty;

    public WishlistPage(WebDriver driver) { super(driver, new Actions(driver)); }

    public WishlistPage clickChooseAll(){
        chooseAll.click();
        return this;
    }

    public WishlistPage clickButtonBasket(){
        buttonBasket.click();
        return this;
    }

    public void clickButtonDelete() { getActions().click(buttonDelete).pause(1000).build().perform(); }

    public void refreshPage() { getDriver().navigate().refresh(); }

    public WebElement getWishlistSum() { return wishlistSum; }

    public WebElement getWishlistEmpty() { return wishlistEmpty; }
}