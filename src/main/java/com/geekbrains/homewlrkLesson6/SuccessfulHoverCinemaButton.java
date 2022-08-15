package com.geekbrains.homewlrkLesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulHoverCinemaButton extends BasePageHome{
    public SuccessfulHoverCinemaButton(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//header//a[.='Скоро онлайн в Okko']")
    private WebElement clickToDisappearingButton;

    public SuccessfulHoverCinemaButton switchToOkkoPage(String actualUrl) {
        clickToDisappearingButton.click();
        Assertions.assertEquals(driver.getCurrentUrl(), actualUrl);
        return this;
    }
}
