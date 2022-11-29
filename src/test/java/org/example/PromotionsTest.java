package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class PromotionsTest extends WebDriverAbstractTest{

    @Test
    void promoTest(){
        getDriver().get("https://www.dns-shop.ru/");
        WebElement promotions = getDriver().findElement(By.xpath("//a[contains(text(),'Все акции')]"));
        promotions.click();
        Assertions.assertDoesNotThrow(() -> getDriver().navigate().to("https://www.dns-shop.ru/actions/"),
                "Страница не доступна");
        WebElement promo1 = getDriver().findElement(By.xpath("(//label[@class='ui-checkbox ui-checkbox_list'])[2]"));
        promo1.click();
        WebElement sorting = getDriver().findElement(By.xpath("//div[@data-label='Показать']"));
        sorting.click();
        getActions().pause(Duration.ofMillis(1000)).build().perform();
        Assertions.assertEquals("Скидки и предложения", getDriver().
                findElement(By.xpath("//div[contains(@class,'actions-page__actions-wrap')]//div[1]//div[2]//div[1]//span[1]"))
                .getText(), "Сортировка не удалась!");
        WebElement promo2 = getDriver().findElement(By.xpath("(//label[@class='ui-checkbox ui-checkbox_list'])[3]"));
        promo1.click();
        promo2.click();
        sorting.click();
        getActions().pause(Duration.ofMillis(1000)).build().perform();
        Assertions.assertEquals("Выгодные комплекты", getDriver().
                findElement(By.xpath("//div[contains(@class,'actions-page__actions-wrap')]//div[1]//div[2]//div[1]//span[1]"))
                .getText(), "Сортировка не удалась!");
    }
}