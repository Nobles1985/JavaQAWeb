package org.example;

import org.example.classfortesting.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DnsTest extends WebDriverAbstractTest {

    @Test
    void basketTest() {

        MainPage mainPage = new MainPage(getDriver());
        mainPage.findCategoryList();
        mainPage.clickLaptop();
        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.clickMonitorSize();
        catalogPage.clickButtonBuy();
        Assertions.assertEquals("1", catalogPage.getShoppingCounter().getText(), "Ошибка счетчика товаров!");
        catalogPage.clickButtonBasket();
        BasketPage basketPage = new BasketPage(getDriver());
        basketPage.clickExtraOptions();
        basketPage.clickButtonDelete();
        Assertions.assertTrue(basketPage.getEmptyBasketMessage().isDisplayed(), "Корзина не очищенна!");
        basketPage.clickButtonReturn();
    }

    @Test
    void deliveryTest(){

        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickButtonDelivery();
        DeliveryPage deliveryPage = new DeliveryPage(getDriver());
        deliveryPage.scrollPage();
        deliveryPage.clickHeaderYandexTaxi();
        Assertions.assertTrue(deliveryPage.getDescriptionYandex().isDisplayed(), "Вкладка не открыта!");
        deliveryPage.clickHeaderYandexTaxi();
        Assertions.assertFalse(deliveryPage.getDescriptionYandex().isDisplayed(), "Вкладка не закрыта!");
        deliveryPage.clickHeaderDeliveryTerms();
        Assertions.assertTrue(deliveryPage.getDescriptionsDeliveryTerms().isDisplayed(), "Вкладка не открыта!");
        deliveryPage.clickHeaderDeliveryTerms();
        Assertions.assertFalse(deliveryPage.getDescriptionsDeliveryTerms().isDisplayed(), "Вкладка не закрыта!");
    }

    @Test
    void favoritesTest() {

        //Блок авторизации
        MainPage mainPage = new MainPage(getDriver());
        mainPage.findLoginMenu();
        mainPage.clickButtonComeIn()
                .clickLoginAndPassword()
                .sendInputLogin()
                .sendInputPassword();
        mainPage.clickButtonLogin();
        Assertions.assertTrue(mainPage.getAvatar().isDisplayed());

        //Блок добавления в избранное
        mainPage.findCategoryList();
        mainPage.clickLaptop();
        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.clickGamingLaptop();
        catalogPage.clickAddWishlist();
        catalogPage.clickAddGeneralList();
        Assertions.assertEquals("1", catalogPage.getWishCounter().getText());
        catalogPage.clickAddWishlist();
        catalogPage.clickAddGeneralList();
        Assertions.assertEquals("2", catalogPage.getWishCounter().getText());
        mainPage.clickButtonWishlist();
        WishlistPage wishlistPage = new WishlistPage(getDriver());
        wishlistPage.clickChooseAll()
                .clickButtonBasket();
        wishlistPage.clickButtonDelete();
        Assertions.assertEquals("2", catalogPage.getWishCounter().getText());
        Assertions.assertEquals("0 товаров на сумму: 0 ₽", wishlistPage.getWishlistSum().getText());
        wishlistPage.refreshPage();
        Assertions.assertTrue(wishlistPage.getWishlistEmpty().isDisplayed(), "Вкладка избранное не очищенна!");
    }

    @Test
    void promotionsTest(){

        WebElement promotions = getDriver().findElement(By.xpath("//a[contains(text(),'Акции')]"));
        promotions.click();
        Assertions.assertDoesNotThrow(() -> getDriver().navigate().to("https://www.dns-shop.ru/actions/"),
                "Страница не доступна");
        WebElement promo1 = getDriver().findElement(By.xpath("(//span[contains(text(),'Скидки и предложения')])[1]"));
        promo1.click();
        WebElement sorting = getDriver().findElement(By.xpath("//div[@data-label='Показать']"));
        getActions().click(sorting).pause(1000).build().perform();
        Assertions.assertEquals("Скидки и предложения", getDriver()
                .findElement(By.xpath("//div[contains(@class,'actions-page__actions-wrap')]//div[1]//div[2]//div[1]//span[1]"))
                .getText(), "Сортировка не удалась!");
        WebElement promo2 = getDriver().findElement(By.xpath("(//span[contains(text(),'Выгодные комплекты')])[1]"));
        promo1.click();
        promo2.click();
        getActions().click(sorting).pause(1000).build().perform();
        Assertions.assertEquals("Выгодные комплекты", getDriver()
                .findElement(By.xpath("//div[contains(@class,'actions-page__actions-wrap')]//div[1]//div[2]//div[1]//span[1]"))
                .getText(), "Сортировка не удалась!");
    }

    @Test
    void sliderTest(){

        getActions().scrollByAmount(0, 600).build().perform();
        WebElement buttonNews = getDriver().findElement(By.xpath("//div[@class='stories__tabs-wrapper']//div[2]"));
        getActions().click(buttonNews).pause(2000).build().perform();
        Assertions.assertEquals("Новости", getDriver().findElement(By.xpath("//div[@class='stories__tab stories__tab_active']")).getText(), "Сортировка не удалась!");
        WebElement buttonBlog = getDriver().findElement(By.xpath("//div[@class='stories__tabs-wrapper']//div[3]"));
        getActions().click(buttonBlog).pause(2000).build().perform();
        Assertions.assertEquals("Блоги", getDriver().findElement(By.xpath("//div[@class='stories__tab stories__tab_active']")).getText(), "Сортировка не удалась!");
        WebElement buttonReview = getDriver().findElement(By.xpath("//div[@class='stories__tabs-wrapper']//div[4]"));
        getActions().click(buttonReview).pause(2000).build().perform();
        Assertions.assertEquals("Обзоры", getDriver().findElement(By.xpath("//div[@class='stories__tab stories__tab_active']")).getText(), "Сортировка не удалась!");
        WebElement buttonAll = getDriver().findElement(By.xpath("//div[@class='stories__tabs-wrapper']//div[1]"));
        buttonAll.click();
    }

    @Test
    void storeTest() {

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
