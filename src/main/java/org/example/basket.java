package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basket {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.dns-shop.ru/");

        WebElement categoryList = driver.findElement(By.xpath("//a[contains(text(),'ПК, ноутбуки, периферия')]"));
        actions.moveToElement(categoryList).build().perform();
        WebElement laptop = driver.findElement(By.xpath("//a[@class='ui-link menu-desktop__second-level'][contains(text(),'Ноутбуки')]"));
        laptop.click();
        WebElement monitorSize = driver.findElement(By.xpath("//a[contains(text(),'17 дюймов')]"));
        monitorSize.click();
        WebElement buttonBuy = driver.findElement(By.xpath("//div[@class='catalog-products view-simple']//div[1]//div[4]//button[2]"));
        buttonBuy.click();
        WebElement buttonBasket = driver.findElement(By.xpath("//span[contains(text(),'В корзину')]"));
        buttonBasket.click();
        WebElement extraOptions = driver.findElement(By.xpath("//div[@class='additional-services__checkbox-wrapper']//div[@class='additional-services__service-title'][contains(text(),'Установка лицензионной ОС Windows (лицензия Window')]"));
        extraOptions.click();
        WebElement buttonDelete = driver.findElement(By.xpath("//button[@class='menu-control-button remove-button']"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(buttonDelete));
        buttonDelete.click();
        WebElement buttonReturn = driver.findElement(By.xpath("//a[@class='empty-message-button empty-message-button_return']"));
        buttonReturn.click();
        //driver.quit();
    }
}
