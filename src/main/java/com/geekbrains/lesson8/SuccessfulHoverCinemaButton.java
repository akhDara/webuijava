package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SuccessfulHoverCinemaButton {
    private SelenideElement clickToDisappearingButton = $(By.xpath("//header//a[.='Скоро онлайн в Okko']"));



    @Step("Переход на страницу Okko")
    public SuccessfulHoverCinemaButton switchToOkkoPage(String actualUrl) {
        clickToDisappearingButton.click();
        webdriver().shouldHave(url(actualUrl));
        return this;
    }

}
