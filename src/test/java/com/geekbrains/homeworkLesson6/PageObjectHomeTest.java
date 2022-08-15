package com.geekbrains.homeworkLesson6;

import com.geekbrains.homewlrkLesson6.MainPageHome;
import com.geekbrains.lesson6.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.geekbrains.homewlrkLesson6.BasePageHome.AFISHA_BASE_URL;

public class PageObjectHomeTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get(AFISHA_BASE_URL);
    }

    @Test
    void likeMovieTest(){
        new MainPageHome(driver).selectFilm()
                .likeMoveChosen()
                .switchToFrameSet("Вход");
    }

    @Test
    void hoverCinemaButtonAndClickOkkoLinkTest() {
        new MainPageHome(driver).clickToCinemaButton()
                .switchToOkkoPage("https://www.afisha.ru/movie/okko-soon/");
    }
    //комментарий чтобы опять создать коммит


    @AfterEach
    void killBrowser(){
        driver.quit();
    }
}
