package org.example.classfortesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PromotionsPage extends AbstractPage{

    @FindBy(xpath = "(//span[contains(text(),'Скидки и предложения')])[1]")
    private WebElement discounts;

    @FindBy(xpath = "//div[@data-label='Показать']")
    private WebElement buttonShow;

    @FindBy(xpath = "//div[contains(@class,'actions-page__actions-wrap')]//div[1]//div[2]//div[1]//span[1]")
    private WebElement selectedPromotions;

    @FindBy(xpath = "(//span[contains(text(),'Выгодные комплекты')])[1]")
    private WebElement profitableKits;

    public PromotionsPage(WebDriver driver) { super(driver, new Actions(driver)); }

    public PromotionsPage clickDiscounts(){
        discounts.click();
        return this;
    }

    public PromotionsPage clickProfitableKits(){
        profitableKits.click();
        return this;
    }

    public void clickButtonShow() { getActions().click(buttonShow).pause(1000).build().perform(); }

    public WebElement getSelectedPromotions() { return selectedPromotions; }
}
