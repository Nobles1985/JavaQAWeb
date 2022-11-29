package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketTest extends WebDriverAbstractTest{

    @Test
    void basketTest() {
        getDriver().get("https://www.dns-shop.ru/");
        WebElement categoryList = getDriver().findElement(By.xpath("//a[contains(text(),'ПК, ноутбуки, периферия')]"));
        getActions().moveToElement(categoryList).build().perform();
        WebElement laptop = getDriver().findElement(By.xpath("//a[@class='ui-link menu-desktop__second-level'][contains(text(),'Ноутбуки')]"));
        laptop.click();
        WebElement monitorSize = getDriver().findElement(By.xpath("//a[contains(text(),'17 дюймов')]"));
        monitorSize.click();
        WebElement buttonBuy = getDriver().findElement(By.xpath("//div[@class='catalog-products view-simple']//div[1]//div[4]//button[2]"));
        buttonBuy.click();
        Assertions.assertEquals("1", getDriver().findElement(By.xpath("//span[@class='cart-link__badge']")).getText(), "Ошибка счетчика товаров!");
        WebElement buttonBasket = getDriver().findElement(By.xpath("//span[contains(text(),'В корзину')]"));
        buttonBasket.click();
        WebElement extraOptions = getDriver().findElement(By.xpath("//div[@class='additional-services__checkbox-wrapper']//div[@class='additional-services__service-title'][contains(text(),'Установка лицензионной ОС Windows (лицензия Window')]"));
        extraOptions.click();
        WebElement buttonDelete = getDriver().findElement(By.xpath("//button[@class='menu-control-button remove-button']"));
        Assertions.assertTimeout(Duration.ofSeconds(3), () -> {
            new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(buttonDelete));
            buttonDelete.click();
        }, "Не удалось удалить товар из корзины!");
        WebElement buttonReturn = getDriver().findElement(By.xpath("//a[@class='empty-message-button empty-message-button_return']"));
        buttonReturn.click();
    }
}