package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class SamlibTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();

        /*driver.get("https://ficbook.net/");
        driver.findElement(By.xpath("//*[@id='jsLogin']/a")).click();
        WebElement loginForm = driver.findElement(By.xpath("//input[@id='loginForLoginFom']"));
        loginForm.sendKeys("student_test1");
        driver.findElement(By.xpath("//input[@id='passwordForLoginForm']")).sendKeys("12345678qwertygy[");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Cookie cookie = new Cookie ("remme2", "QXBwQnVuZGxlXEVudGl0eVxVc2VyOmMzUjFaR1Z1ZEY5MFpYTjA6MTY3NTI4MjUyOTpKL3FlQnJuVTh2ZHg4eVE0YXFJdzNLcUU3dHJzcFE4S0xHZFJrSWhoWHRsalZrWEY4VDFNalBwaFNTUmxSanNtWkZibUo4VW1JdWNyb0JISmI0RitEdz09OmViYTBjMTQ5MjBlZjNhZjkxNjk2MDYxZjdlNzNiNWI3NGQ5NGQwNTEyNzY2NWE1ZTI5NWYwNWRmZjIzYTdjMjQ%3D");
        Cookie cookie1 = new Cookie("PHPSESSID", "15nd5vr4hrjtvd0nu8lmi2ktv3");
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(cookie1);
        driver.navigate().refresh();*/


        driver.get("https://diary.ru/");
        Cookie cookie = new Cookie("_identity_", "62b279ebb44d69b8daf4a39c61ea2d9c16aa83fd3d92aa68c9f2813f93227ff6a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3570841%2C%22tC7rhgD_uTLMi6uq9B2Y4ra7KO_xZexK%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();

        String postTitle = "котик" + new Random().nextInt(1000);
        driver.findElement(By.id("postTitle")).sendKeys(postTitle);

        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("Как inDriver сократил проверку релизной сборки с 4 дней до 4 часов? \n" +
                "\n" +
                "Коллеги из inDriver делятся советами как уменьшить Time-to-Market по выходу новых фич, выиграв при этом в качестве проверки. А также узнаете:\n" +
                "\n" +
                "· почему релизная команда отказалась от TMS TestRail в пользу Qase,\n" +
                "· какие инстументы используют ребята для написания UI-автотестов,\n" +
                "· почему команда выбрала понедельник единым днем для проверки релиза. \n");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();

        //driver.findElement(By.xpath(String.format("//a[text() ='%s']", postTitle))).click();
        List<WebElement> postTitles =  driver.findElements(By.xpath("//a[@class='title']"));
        postTitles.stream().filter(p -> p.getText().equals(postTitle)).findFirst().get().click();


        Thread.sleep(5000);
        driver.quit();

    }
}
