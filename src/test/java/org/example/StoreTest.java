package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreTest extends WebDriverAbstractTest {

    @Test
    void storeTest() {
        getDriver().get("https://www.dns-shop.ru/");
        WebElement chooseCity = getDriver().findElement(By.xpath("//div[@class='city-select__label']"));
        chooseCity.click();
        WebElement cityName = getDriver().findElement(By.xpath("//div[@id='select-city-modal']//span[2]"));
        cityName.click();
        Assertions.assertEquals("Санкт-Петербург", getDriver().findElement(By.xpath("//span[@class='city-select__text']"))
                .getText(), "Неверный город!");
        WebElement storeMenu = getDriver().findElement(By.xpath("//a[contains(text(),'Магазины')]"));
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(storeMenu));
        storeMenu.click();
        Assertions.assertDoesNotThrow(() -> getDriver().navigate().to("https://www.dns-shop.ru/shops/spb/"),
                "Страница не доступна");
        WebElement searchForName = getDriver().findElement(By.xpath("//input[@placeholder='Название магазина, адрес или метро']"));
        searchForName.sendKeys("Стар");
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='shop-list-item__shop-link'])[25]")));
        WebElement searchResult = getDriver().findElement(By.xpath("(//a[@class='shop-list-item__shop-link'])[25]"));
        searchResult.click();
        Assertions.assertEquals("Санкт-Петербург - М. Старая Деревня ГИПЕР ТЦ «Старая Деревня»", getDriver().findElement(By.cssSelector(".shop-page__title"))
                .getText(), "магазин не найден!");
    }
}