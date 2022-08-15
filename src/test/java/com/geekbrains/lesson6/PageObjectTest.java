package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver () {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    void putTShortToCartTest() throws InterruptedException {
       // MainPage mainPage = new MainPage(driver);
       // mainPage.clickSignButton();
       // new LoginPage(driver).login("salicib521@yubua.com", "qwerty12345678");
       // new MainMenuBlock(driver).hoverWomenButton();
       // new WomenSuggestPage(driver).



        //new MainPage(driver).clickSignButton();

        new MainPage(driver).clickSignButton()
                .login("salicib521@yubua.com", "qwerty12345678")
                .mainMenuBlock.hoverWomenButton()
                .clickTShirtsButton()
                .selectSize("S")
                .moveMouseToProductAndAddToCart()
                .checkTotalSumma("$18.51");

    }
    //комментарий чтобы опять создать коммит

    @AfterEach
    void killBrowser(){
        driver.quit();
    }
}
