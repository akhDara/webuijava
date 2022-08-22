import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.geekbrains.lesson8.ChosenLikedFilm;
import com.geekbrains.lesson8.MainPageHome;
import com.geekbrains.lesson8.SuccessfulFramePopUp;
import com.geekbrains.lesson8.SuccessfulHoverCinemaButton;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;
import static com.geekbrains.lesson8.ChosenLikedFilm.AFISHA_BASE_URL;

public class MyStepdefs {
    @Given("Пользователь на главной странице")
    public void пользовательНаГлавнойСтранице() {
        Configuration.timeout = 10000;
        open(AFISHA_BASE_URL);
    }

    @When("навести На Кино")
    public void навестиНаКино() {
        new MainPageHome().clickToCinemaButton();
    }

    @Then("Проверяем переход на страницу Окко")
    public void проверяемПереходНаСтраницуОкко() {
        new SuccessfulHoverCinemaButton().switchToOkkoPage("https://www.afisha.ru/movie/okko-soon/");
    }

    @After(value = "@close")
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Given("Пользователь не авторизован")
    public void пользовательНеАвторизован() {
        Configuration.timeout = 10000;
        open(AFISHA_BASE_URL);
    }

    @When("Клик на фильм")
    public void кликНаФильм() { new MainPageHome().selectFilm();
    }

    @And("Клик на {string}")
    public void кликНаДобавитьВИзбранное() {
        new ChosenLikedFilm().likeMoveChosen();
    }

    @Then("Проверяем появление окошечка авторизации")
    public void проверяемПоявлениеОкошечкаАвторизации() {
        new SuccessfulFramePopUp().switchToFrameSet("Вход");
    }
}
