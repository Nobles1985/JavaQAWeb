package org.example;

import io.qameta.allure.*;
import org.example.classfortesting.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Пользовательская история.")
public class DnsTest extends WebDriverAbstractTest {

    @Test
    @DisplayName("Корзина.")
    @Description("Тестирование добавления определенного товара в корзину и его удаление.")
    @Link("https://spb.dns-shop.ru")
    @Severity(SeverityLevel.BLOCKER)
    void basketTest() {

        MainPage mainPage = new MainPage(getDriver());
        mainPage.findCategoryList();
        mainPage.clickLaptop();
        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.clickMonitorSize();
        catalogPage.scrollPage();
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
    @DisplayName("Доставка.")
    @Description("Тестирование страницы с информацией о видах доставки.")
    @Link("https://spb.dns-shop.ru")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Избранное.")
    @Description("Тестирование добавления определенных товаров в избранное и их удаление.")
    @Link("https://spb.dns-shop.ru")
    @Severity(SeverityLevel.CRITICAL)
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
        catalogPage.scrollPage();
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
    @DisplayName("Акции.")
    @Description("Тестирование сортировки промоакций по их типу.")
    @Link("https://spb.dns-shop.ru")
    @Severity(SeverityLevel.NORMAL)
    void promotionsTest(){

        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickPromotions();
        Assertions.assertEquals("https://www.dns-shop.ru/actions/", getDriver().getCurrentUrl());
        PromotionsPage promotionsPage = new PromotionsPage(getDriver());
        promotionsPage.clickDiscounts();
        promotionsPage.clickButtonShow();
        Assertions.assertEquals("Скидки и предложения", promotionsPage.getSelectedPromotions().getText());
        promotionsPage.clickDiscounts()
                .clickProfitableKits();
        promotionsPage.clickButtonShow();
        Assertions.assertEquals("Выгодные комплекты", promotionsPage.getSelectedPromotions().getText());
    }

    @Test
    @DisplayName("Инфослайдер.")
    @Description("Тестирование сортировки статей в выборке по типам представленной информации.")
    @Link("https://spb.dns-shop.ru")
    @Severity(SeverityLevel.MINOR)
    void sliderTest(){

        MainPage mainPage = new MainPage(getDriver());
        mainPage.scrollPage();
        mainPage.clickButtonNews();
        Assertions.assertEquals("Новости", mainPage.getSelectedType().getText(), "Сортировка не удалась!");
        mainPage.clickButtonBlog();
        Assertions.assertEquals("Блоги", mainPage.getSelectedType().getText(), "Сортировка не удалась!");
        mainPage.clickButtonReview();
        Assertions.assertEquals("Обзоры", mainPage.getSelectedType().getText(), "Сортировка не удалась!");
        mainPage.clickButtonAll();
    }

    @Test
    @DisplayName("Поиск магазина.")
    @Description("Тестирование пиоска магазина по части названия станции метро.")
    @Link("https://spb.dns-shop.ru")
    @Severity(SeverityLevel.MINOR)
    void storeTest() {

        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickShops();
        Assertions.assertEquals("https://www.dns-shop.ru/shops/spb/", getDriver().getCurrentUrl());
        ShopsPage shopsPage = new ShopsPage(getDriver());
        shopsPage.sendSearchForName()
                .clickSearchResult();
        Assertions.assertEquals("Санкт-Петербург - М. Старая Деревня ГИПЕР ТЦ «Старая Деревня»", shopsPage.getNameResult().getText());
    }
}