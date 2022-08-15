package com.geekbrains.homewlrkLesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageHome {
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    Actions actions;

    public final static  String AFISHA_BASE_URL = "https://afisha.ru";

    public  BasePageHome (WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    //комментарий чтобы опять создать коммит
}
