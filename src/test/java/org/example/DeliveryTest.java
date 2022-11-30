package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeliveryTest extends WebDriverAbstractTest{

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
}