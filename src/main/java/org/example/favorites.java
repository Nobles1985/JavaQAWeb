package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class favorites {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.dns-shop.ru/");

        //Блок авторизации
        WebElement menu = driver.findElement(By.xpath("//div[@class='user-menu']"));
        action.moveToElement(menu).build().perform();
        WebElement buttonComeIn = driver.findElement(By.xpath("(//button[@class='base-ui-button-v2_medium base-ui-button-v2_brand base-ui-button-v2_ico-none base-ui-button-v2'])[1]"));
        buttonComeIn.click();
        WebElement loginAndPassword = driver.findElement(By.xpath("//div[@class='block-other-login-methods__password-caption']"));
        loginAndPassword.click();
        WebElement login = driver.findElement(By.xpath("//input[@type='text']"));
        login.sendKeys("khj73325@cdfaq.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Test2022");
        WebElement buttonLogin = driver.findElement(By.xpath("(//button[@class='base-ui-button-v2_big base-ui-button-v2_brand base-ui-button-v2_ico-none base-ui-button-v2'])[1]"));
        buttonLogin.click();

        //Блок добавления в избранное
        Thread.sleep(7000);
        WebElement categoryList = driver.findElement(By.xpath("//a[contains(text(),'ПК, ноутбуки, периферия')]"));
        action.moveToElement(categoryList).build().perform();
        WebElement laptop = driver.findElement(By.xpath("//a[@class='ui-link menu-desktop__second-level'][contains(text(),'Ноутбуки')]"));
        laptop.click();
        WebElement categoryLaptop = driver.findElement(By.xpath("//a[contains(text(),'Игровые')]"));
        categoryLaptop.click();
        Thread.sleep(2000);
        WebElement buttonAddFavorite1 = driver.findElement(By.xpath("(//button[@class='button-ui button-ui_white button-ui_icon wishlist-btn'])[1]"));
        buttonAddFavorite1.click();
        WebElement buttonAddList = driver.findElement(By.xpath("//a[contains(text(),'+ Общий список')]"));
        buttonAddList.click();
        Thread.sleep(1000);
        WebElement buttonAddFavorite2 = driver.findElement(By.xpath("(//button[@class='button-ui button-ui_white button-ui_icon wishlist-btn'])[1]"));
        buttonAddFavorite2.click();
        WebElement buttonAddList2 = driver.findElement(By.xpath("//a[contains(text(),'+ Общий список')]"));
        buttonAddList2.click();
        WebElement favoriteList = driver.findElement(By.xpath("//a[@class='ui-link wishlist-link']"));
        favoriteList.click();
        Thread.sleep(2000);
        WebElement chooseAll = driver.findElement(By.xpath("(//label[@class='ui-checkbox'])[1]"));
        chooseAll.click();
        WebElement buttonBasket = driver.findElement(By.xpath("//button[@class='button-ui button-ui_white profile-wishlist-management__controls_delete']"));
        buttonBasket.click();
        WebElement buttonDelete = driver.findElement(By.xpath("//button[contains(text(),'Удалить')]"));
        buttonDelete.click();
        driver.navigate().refresh();
        //driver.quit();
    }
}
