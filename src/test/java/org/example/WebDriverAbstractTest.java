package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class WebDriverAbstractTest {

    private static WebDriver driver;
    private static Actions actions;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow(() -> driver.navigate().to("https://www.dns-shop.ru/"),
                "Страница не доступна");
    }

    @AfterAll
    static void end(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static Actions getActions() { return actions; }
}