package org.example;

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

    @Test
    void deliveryTest(){
        getDriver().get("https://www.dns-shop.ru/");
        getActions().scrollByAmount(0, 1100).build().perform();
        WebElement buttonDelivery = getDriver().findElement(By.xpath("//a[contains(text(),'Доставка')]"));
        getActions().click(buttonDelivery).pause(2000).scrollByAmount(0,600).build().perform();
        WebElement buttonYandexTaxi = getDriver().findElement(By.xpath("//strong[contains(text(),'Доставка \"День в день\" в пределах КАД (Яндекс.Такс')]"));
        buttonYandexTaxi.click();
        Assertions.assertTrue(getDriver().findElement(By.xpath("(//div[@class='spoiler-body'])[1]")).isDisplayed(), "Вкладка не открыта!");
        buttonYandexTaxi.click();
        Assertions.assertFalse(getDriver().findElement(By.xpath("(//div[@class='spoiler-body'])[1]")).isDisplayed(), "Вкладка открыта!");
        WebElement buttonDeliveryTerms = getDriver().findElement(By.xpath("//strong[contains(text(),'Условия доставки')]"));
        buttonDeliveryTerms.click();
        Assertions.assertTrue(getDriver().findElement(By.xpath("(//div[@class='spoiler-body'])[4]")).isDisplayed(), "Вкладка не открыта!");
        buttonDeliveryTerms.click();
        Assertions.assertFalse(getDriver().findElement(By.xpath("(//div[@class='spoiler-body'])[4]")).isDisplayed(), "Вкладка открыта!");
    }

    @Test
    void favoritesTest() {
        getDriver().get("https://www.dns-shop.ru/");

        //Блок авторизации
        WebElement menu = getDriver().findElement(By.xpath("//div[@class='header-bottom__user-menu']"));
        getActions().moveToElement(menu).build().perform();
        WebElement buttonComeIn = getDriver().findElement(By.xpath("//button[@class='base-ui-button-v2_medium base-ui-button-v2_brand base-ui-button-v2_ico-none base-ui-button-v2']"));
        buttonComeIn.click();
        WebElement loginAndPassword = getDriver().findElement(By.xpath("//div[@class='block-other-login-methods__password-caption']"));
        loginAndPassword.click();
        WebElement login = getDriver().findElement(By.xpath("//input[@autocomplete='username']"));
        login.sendKeys("khj73325@cdfaq.com");
        WebElement password = getDriver().findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Test2022");
        WebElement buttonLogin = getDriver().findElement(By.cssSelector(".base-ui-button-v2_big.base-ui-button-v2_brand.base-ui-button-v2_ico-none.base-ui-button-v2"));
        getActions().click(buttonLogin).pause(7000).build().perform();
        Assertions.assertTrue(getDriver().findElement(By.className("user-profile__avatar")).isDisplayed());

        //Блок добавления в избранное
        WebElement categoryList = getDriver().findElement(By.xpath("//a[contains(text(),'ПК, ноутбуки, периферия')]"));
        getActions().moveToElement(categoryList).build().perform();
        WebElement laptop = getDriver().findElement(By.xpath("//span[contains(text(),'Ноутбуки')]"));
        laptop.click();
        WebElement categoryLaptop = getDriver().findElement(By.xpath("//a[contains(text(),'Игровые')]"));
        getActions().click(categoryLaptop).pause(1000).scrollByAmount(0, 300).build().perform();
        WebElement buttonAddFavorite1 = getDriver().findElement(By.xpath("(//button[@class='button-ui button-ui_white button-ui_icon wishlist-btn'])[1]"));
        getActions().click(buttonAddFavorite1).build().perform();
        WebElement buttonAddList = getDriver().findElement(By.xpath("//a[contains(text(),'+ Общий список')]"));
        getActions().click(buttonAddList).pause(1000).build().perform();
        Assertions.assertEquals("1", getDriver().findElement(By.cssSelector(".wishlist-link-counter__badge")).getText());
        WebElement buttonAddFavorite2 = getDriver().findElement(By.xpath("(//button[@class='button-ui button-ui_white button-ui_icon wishlist-btn'])[1]"));
        buttonAddFavorite2.click();
        WebElement buttonAddList2 = getDriver().findElement(By.xpath("//a[contains(text(),'+ Общий список')]"));
        getActions().click(buttonAddList2).pause(1000).build().perform();
        Assertions.assertEquals("2", getDriver().findElement(By.cssSelector(".wishlist-link-counter__badge")).getText());
        WebElement favoriteList = getDriver().findElement(By.cssSelector(".wishlist-link-counter__lbl"));
        getActions().click(favoriteList).pause(2000).build().perform();
        WebElement chooseAll = getDriver().findElement(By.xpath("//span[contains(text(),'Выбрать все')]"));
        chooseAll.click();
        WebElement buttonBasket = getDriver().findElement(By.xpath("//button[@class='button-ui button-ui_white profile-wishlist-management__controls_delete']"));
        buttonBasket.click();
        WebElement buttonDelete = getDriver().findElement(By.xpath("//button[contains(text(),'Удалить')]"));
        getActions().click(buttonDelete).pause(1000).build().perform();
        Assertions.assertEquals("2", getDriver().findElement(By.cssSelector(".wishlist-link-counter__badge")).getText());
        Assertions.assertEquals("0 товаров на сумму: 0 ₽", getDriver().findElement(By.cssSelector(".profile-wishlist__sum")).getText());
        getDriver().navigate().refresh();
        Assertions.assertTrue(getDriver().findElement(By.cssSelector(".profile-wishlist__empty-image")).isDisplayed(), "Вкладка избранное не пуста!");
    }

    @Test
    void promotionsTest(){
        getDriver().get("https://www.dns-shop.ru/");
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
        getDriver().get("https://www.dns-shop.ru/");
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
        getDriver().get("https://www.dns-shop.ru/");
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
