package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class promotions {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.dns-shop.ru/");

        WebElement promotions = driver.findElement(By.xpath("//a[contains(text(),'Все акции')]"));
        promotions.click();
        WebElement promo1 = driver.findElement(By.xpath("(//label[@class='ui-checkbox ui-checkbox_list'])[2]"));
        promo1.click();
        WebElement sorting = driver.findElement(By.xpath("//div[@data-label='Показать']"));
        sorting.click();
        WebElement promo2 = driver.findElement(By.xpath("(//label[@class='ui-checkbox ui-checkbox_list'])[3]"));
        promo1.click();
        promo2.click();
        sorting.click();
        //driver.quit();
    }
}
