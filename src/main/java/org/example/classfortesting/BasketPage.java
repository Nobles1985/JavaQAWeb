package org.example.classfortesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='additional-services__checkbox-wrapper']//span[@class='base-ui-checkbox__icon base-ui-checkbox__icon base-ui-checkbox__icon-hover']")
    private WebElement extraOptions;

    @FindBy(xpath = "//p[@class='remove-button__title']")
    private WebElement buttonDelete;

    @FindBy(css = ".empty-message")
    private WebElement emptyBasketMessage;

    @FindBy(xpath = "//a[@class='empty-message-button empty-message-button_return']")
    private WebElement buttonReturn;

    public BasketPage(WebDriver driver) { super(driver, new Actions(driver)); }

    public BasketPage clickExtraOptions(){
        extraOptions.click();
        return this;
    }

    public void clickButtonDelete(){
        Actions actions = new Actions(getDriver());
        actions.pause(1000).click(buttonDelete).build().perform();
    }

    public BasketPage clickButtonReturn(){
        buttonReturn.click();
        return this;
    }

    public WebElement getEmptyBasketMessage() {
        return emptyBasketMessage;
    }
}