package org.example.classfortesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DeliveryPage extends AbstractPage{

    @FindBy(xpath = "//strong[contains(text(),'Доставка \"День в день\" в пределах КАД (Яндекс.Такс')]")
    private WebElement headerYandexTaxi;

    @FindBy(xpath = "(//div[@class='spoiler-body'])[1]")
    private WebElement descriptionYandex;

    @FindBy(xpath = "//strong[contains(text(),'Условия доставки')]")
    private WebElement headerDeliveryTerms;

    @FindBy(xpath = "(//div[@class='spoiler-body'])[4]")
    private WebElement descriptionsDeliveryTerms;

    public DeliveryPage(WebDriver driver) { super(driver, new Actions(driver)); }

    public void scrollPage(){
        getActions().scrollByAmount(0, 600).build().perform();
    }

    public DeliveryPage clickHeaderYandexTaxi(){
        headerYandexTaxi.click();
        return this;
    }

    public DeliveryPage clickHeaderDeliveryTerms(){
        headerDeliveryTerms.click();
        return this;
    }

    public WebElement getDescriptionYandex() {
        return descriptionYandex;
    }

    public WebElement getDescriptionsDeliveryTerms() {
        return descriptionsDeliveryTerms;
    }
}
