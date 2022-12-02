package org.example.classfortesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='header-bottom__user-menu']")
    private WebElement loginMenu;

    @FindBy(xpath = "//button[@class='base-ui-button-v2_medium base-ui-button-v2_brand base-ui-button-v2_ico-none base-ui-button-v2']")
    private WebElement buttonComeIn;

    @FindBy(xpath = "//div[@class='block-other-login-methods__password-caption']")
    private WebElement loginAndPassword;

    @FindBy(xpath = "//input[@autocomplete='username']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(css = ".base-ui-button-v2_big.base-ui-button-v2_brand.base-ui-button-v2_ico-none.base-ui-button-v2")
    private WebElement buttonLogin;

    @FindBy(className = "user-profile__avatar")
    private WebElement avatar;

    @FindBy(xpath = "//a[contains(text(),'ПК, ноутбуки, периферия')]")
    private WebElement categoryList;

    @FindBy(xpath = "//span[contains(text(),'Ноутбуки')]")
    private WebElement laptop;

    @FindBy(css = ".wishlist-link-counter__lbl")
    private WebElement buttonWishlist;

    @FindBy(xpath = "//a[contains(text(),'Доставка')]")
    private WebElement buttonDelivery;

    public MainPage(WebDriver driver) { super(driver, new Actions(driver)); }

    public void findLoginMenu() { getActions().moveToElement(loginMenu).build().perform(); }

    public MainPage clickButtonComeIn(){
        buttonComeIn.click();
        return this;
    }

    public MainPage clickLoginAndPassword(){
        loginAndPassword.click();
        return this;
    }

    public MainPage sendInputLogin(){
        inputLogin.sendKeys("khj73325@cdfaq.com");
        return this;
    }

    public MainPage sendInputPassword(){
        inputPassword.sendKeys("Test2022");
        return this;
    }

    public void clickButtonLogin() { getActions().click(buttonLogin).pause(7000).build().perform(); }

    public WebElement getAvatar() { return avatar; }

    public void findCategoryList() { getActions().moveToElement(categoryList).build().perform(); }

    public MainPage clickLaptop(){
        laptop.click();
        return this;
    }

    public void clickButtonDelivery(){
        getActions().scrollByAmount(0, 1100).build().perform();
        getActions().click(buttonDelivery).pause(2000).build().perform();
    }

    public void clickButtonWishlist() { getActions().click(buttonWishlist).pause(2000).build().perform();}
}