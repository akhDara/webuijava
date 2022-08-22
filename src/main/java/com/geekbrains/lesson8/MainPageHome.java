package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class MainPageHome {

    private ElementsCollection filmList = $$(By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]/h2"));

    @Step("Найти дайджест Кино")
    public ChosenLikedFilm selectFilm() {
        filmList.findBy(Condition.text("Легенды Орленка")).click();
        return page(ChosenLikedFilm.class);
    }

    private SelenideElement cinemaButton = $(By.xpath("//a[.='ДЕТИ']"));


    @Step("Клик на выбранный фильм")
    public SuccessfulHoverCinemaButton clickToCinemaButton() {
                cinemaButton.hover();
        return page(SuccessfulHoverCinemaButton.class);
    }

}
