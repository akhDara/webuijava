package com.geekbrains.homewlrkLesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChosenLikedFilm extends BasePageHome{
    public ChosenLikedFilm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")
    private WebElement likeFilm;

    @Step("Клик на 'Добавить в Избранное'")
    public SuccessfulFramePopUp likeMoveChosen(){

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));
        likeFilm.click();
        return new SuccessfulFramePopUp(driver);
    }

}
