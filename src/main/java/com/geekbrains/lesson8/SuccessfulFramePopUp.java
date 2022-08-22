package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class SuccessfulFramePopUp {
    private SelenideElement switchToFrame = $(By.xpath("//iframe[contains(@src, 'login')]"));
    private SelenideElement actualTitle = $(By.xpath("//h2[.='Вход']"));

    @Step("Проверяем появление окошечка авторизации")
    public SuccessfulFramePopUp switchToFrameSet(String expectedTitle) {
        switchTo().frame($(By.xpath("//iframe[contains(@src, 'login')]")));
        actualTitle.shouldHave(Condition.text(expectedTitle));
        return this;
    }

}
