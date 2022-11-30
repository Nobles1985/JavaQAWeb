package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasketTest extends WebDriverAbstractTest{

    @Test
    void basketTest() {
        getDriver().get("https://www.dns-shop.ru/");
        WebElement categoryList = getDriver().findElement(By.xpath("//a[contains(text(),'ПК, ноутбуки, периферия')]"));
        getActions().moveToElement(categoryList).build().perform();
        WebElement laptop = getDriver().findElement(By.xpath("//span[contains(text(),'Ноутбуки')]"));
        laptop.click();
        WebElement monitorSize = getDriver().findElement(By.xpath("//a[contains(text(),'17 дюймов')]"));
        getActions().click(monitorSize).pause(1000).scrollByAmount(0, 500).build().perform();
        WebElement buttonBuy = getDriver().findElement(By.xpath("//div[@class='products-page__list']//div[2]//div[2]//div[4]//button[2]"));
        getActions().click(buttonBuy).pause(2000).build().perform();
        Assertions.assertEquals("1", getDriver().findElement(By.xpath("//span[@class='cart-link-counter__badge']")).getText(), "Ошибка счетчика товаров!");
        WebElement buttonBasket = getDriver().findElement(By.xpath("//button[contains(text(),'В корзине')]"));
        buttonBasket.click();
        WebElement extraOptions = getDriver().findElement(By.xpath("//div[@class='additional-services__checkbox-wrapper']//span[@class='base-ui-checkbox__icon base-ui-checkbox__icon base-ui-checkbox__icon-hover']"));
        extraOptions.click();
        WebElement buttonDelete = getDriver().findElement(By.xpath("//p[@class='remove-button__title']"));
        getActions().pause(1000).click(buttonDelete).build().perform();
        Assertions.assertTrue(getDriver().findElement(By.cssSelector(".empty-message")).isDisplayed(), "Корзина не пустая!");
        WebElement buttonReturn = getDriver().findElement(By.xpath("//a[@class='empty-message-button empty-message-button_return']"));
        buttonReturn.click();
    }
}