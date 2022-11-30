package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FavoritesTest extends WebDriverAbstractTest{

    @Test
    void favorTest() {
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
        getActions().click(categoryLaptop).pause(2000).scrollByAmount(0, 700).build().perform();
        WebElement buttonAddFavorite1 = getDriver().findElement(By.xpath("(//button[@class='button-ui button-ui_white button-ui_icon wishlist-btn'])[1]"));
        buttonAddFavorite1.click();
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
}