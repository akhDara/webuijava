package com.geekbrains.homewlrkLesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPageHome extends BasePageHome {

    public MainPageHome(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]/h2")
    private List<WebElement> filmList;

    public ChosenLikedFilm selectFilm() {
        filmList.stream().filter(s -> s.getText().contains("Русалка и дочь короля")).findFirst().get().click();
        return new ChosenLikedFilm(driver);
    }

    @FindBy(xpath = "//a[.='КИНО']")
    private WebElement cinemaButton;

    public SuccessfulHoverCinemaButton clickToCinemaButton() {
        actions.moveToElement(cinemaButton)
                .build()
                .perform();
        return new SuccessfulHoverCinemaButton(driver);
    }
}
