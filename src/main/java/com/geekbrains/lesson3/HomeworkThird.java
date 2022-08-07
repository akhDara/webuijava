package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeworkThird {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.id("email")).sendKeys("bosixo6218@chimpad.com");
        driver.findElement(By.id("passwd")).sendKeys("qwerty12345678");
        driver.findElement(By.id("SubmitLogin")).click();

        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();

        Thread.sleep(3000);
        driver.quit();

    }
}
