package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ChosenLikedFilm  {
    public final static  String AFISHA_BASE_URL = "https://afisha.ru";
    private SelenideElement likeFilm = $(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']"));

    @Step("Клик на 'Добавить в Избранное'")
    public SuccessfulFramePopUp likeMoveChosen(){
        likeFilm.click();
        return page(SuccessfulFramePopUp.class);
    }

}
