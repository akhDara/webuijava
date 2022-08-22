package com.geekbrains.homeworkLesson6;

import com.geekbrains.homewlrkLesson6.MainPageHome;
import com.geekbrains.lesson7.AdditionalLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import static com.geekbrains.homewlrkLesson6.BasePageHome.AFISHA_BASE_URL;

@Story("Проверка динамических элементов")
public class PageObjectHomeTest {
    WebDriver driver;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        driver.get(AFISHA_BASE_URL);

    }

    @Test
    @Feature("Форма авторизации по кнопке лайка")
    @TmsLink("tsmLink")
    @DisplayName("Тест: Проверка кнопка лайка")
    void likeMovieTest(){
        new MainPageHome(driver).selectFilm()
                .likeMoveChosen()
                .switchToFrameSet("Вход");
    }

    @Test
    @Feature("Переход на страницу Okko")
    @DisplayName("Тест: Навести курсор на кнопку Кино и клик на ссылку Okko")
    void hoverCinemaButtonAndClickOkkoLinkTest() {
        new MainPageHome(driver).clickToCinemaButton()
                .switchToOkkoPage("https://www.afisha.ru/movie/okko-soon/");
    }


    @AfterEach
    void killBrowser(){
       LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

       for(LogEntry log: logEntries) {
           Allure.addAttachment("Элемент лога браузера", log.getMessage());
       }
        driver.quit();
    }
}
