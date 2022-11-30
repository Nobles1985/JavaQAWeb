package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public abstract class WebDriverAbstractTest {

    private static WebDriver driver;
    private static Actions actions;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow(() -> driver.navigate().to("https://www.dns-shop.ru/"),
                "Страница не доступна");
        WebElement chooseCity = getDriver().findElement(By.xpath("//div[@class='city-select__label']"));
        chooseCity.click();
        WebElement cityName = getDriver().findElement(By.xpath("//div[@id='modals']//span[2]"));
        cityName.click();
        actions.pause(4000).build().perform();
        Assertions.assertEquals("Санкт-Петербург", getDriver().findElement(By.xpath("//span[@class='city-select__text']"))
                .getText(), "Неверный город!");
    }

    @AfterAll
    static void end() { driver.quit(); }

    public static WebDriver getDriver() { return driver; }

    public static Actions getActions() { return actions; }
}