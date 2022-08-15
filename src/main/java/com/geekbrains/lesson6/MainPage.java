package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {
    @FindBy(xpath = "//a[@class='login']")
    private WebElement singInButton;

    public MainPage(WebDriver driver) {
        super(driver);
        mainMenuBlock = new MainMenuBlock(driver);
    }

    public MainMenuBlock mainMenuBlock;

    public LoginPage clickSignButton() {
        singInButton.click();
        return new LoginPage(driver);
    }

}
