package com.geekbrains.homewlrkLesson6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessfulFramePopUp extends BasePageHome{
    public SuccessfulFramePopUp(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[contains(@src, 'login')]")
    private WebElement switchToFrame;

    @FindBy(xpath = "//h2[.='Вход']")
    private WebElement actualTitle;

    @Step("Проверяем появление окошечка авторизации")
    public SuccessfulFramePopUp switchToFrameSet(String expectedTitle) {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        Assertions.assertEquals(expectedTitle, actualTitle.getText());
        return this;
    }

}
