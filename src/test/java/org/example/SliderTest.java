package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SliderTest extends WebDriverAbstractTest{

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
}