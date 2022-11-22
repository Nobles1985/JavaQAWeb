package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class store {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.dns-shop.ru/");

        WebElement chooseCity = driver.findElement(By.xpath("//div[@class='city-select__label']"));
        chooseCity.click();
        WebElement cityName = driver.findElement(By.xpath("//div[@id='select-city-modal']//span[2]"));
        cityName.click();
        WebElement storeMenu = driver.findElement(By.xpath("//a[contains(text(),'Магазины')]"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(storeMenu));
        storeMenu.click();
        WebElement searchForName = driver.findElement(By.xpath("//input[@placeholder='Название магазина, адрес или метро']"));
        searchForName.sendKeys("Стар");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='shop-list-item__shop-link'])[25]")));
        WebElement searchResult = driver.findElement(By.xpath("(//a[@class='shop-list-item__shop-link'])[25]"));
        searchResult.click();
        //driver.quit();
    }
}
