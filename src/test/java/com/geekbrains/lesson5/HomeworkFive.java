package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HomeworkFive {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String DIARY_TEST_URL = "https://diary.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(DIARY_TEST_URL);
        Cookie cookie = new Cookie("_identity_", "b2d47694f2fb97dc90118500e2db14ee3d5e887acc368fd7f5754478f8d1d7bfa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3571166%2C%22pvU8FMnnv79GKt2hR9K-O5uWXo33p_DS%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }

    @Test
    void createNewNote()  {
        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();

        String postTitle = "котик" + new Random().nextInt(1000);
        driver.findElement(By.id("postTitle")).sendKeys(postTitle);

        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("Как Котики сократили проверку релизной сборки с 4 дней до 4 часов? \n" +
                "\n" +
                "Коллеги Котики делятся советами как уменьшить Time-to-Market по выходу новых фич, выиграв при этом в качестве проверки. А также узнаете:\n" +
                "\n" +
                "· почему релизная команда отказалась от TMS TestRail в пользу Qase,\n" +
                "· какие инстументы используют ребята для написания UI-автотестов,\n" +
                "· почему команда выбрала понедельник единым днем для проверки релиза. \n");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();
        List<WebElement> postTitles =  driver.findElements(By.xpath("//a[@class='title']"));
        postTitles.stream().filter(p -> p.getText().equals(postTitle)).findFirst().get().click();
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='postContent']")).isDisplayed(), true);

    }

    @Test
    void likedCitation () throws InterruptedException {
        driver.findElement(By.xpath("//a[@title='Мой дневник']")).click();
        List<WebElement> list1 =  (List<WebElement>) driver.findElements(By.xpath("//a[@class='addQuote lastLink post_quotes']"));
        WebElement e = list1.get(0);
        e.click();
        driver.findElement(By.xpath("//a[@class='drop_menu']")).click();
        driver.findElement(By.xpath("//*[.='Цитатник']")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='item  first'][1]")).isDisplayed(), true);
    }

    @Test
    void deleteCitation () {
        driver.findElement(By.xpath("//a[@class='drop_menu']")).click();
        driver.findElement(By.xpath("//*[.='Цитатник']")).click();
        driver.findElement(By.xpath("//a[@title='Удалить из цитатника']")).click();
        driver.navigate().refresh();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Нет записей']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//*[.='Нет записей']")).isDisplayed(), true);

    }

    @Test
    void deleteNote () throws InterruptedException {
        driver.findElement(By.xpath("//a[@title='Мой дневник']")).click();
        driver.findElement(By.xpath("//a[@title='Удалить']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='text-right']//button[1]")));
        driver.findElement(By.xpath("//div[@class='text-right']//button[1]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Нет записей']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//*[.='Нет записей']")).isDisplayed(), true);
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}


