package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final String emailIdLocator = "email";
    @FindBy(id = emailIdLocator)
    private WebElement emailField;

    @FindBy(id="passwd")
    private WebElement passwdField;

    @FindBy(id="SubmitLogin")
    private WebElement submitLogin;

    public MainPage login (String login, String password) {
        //webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(emailIdLocator)));
        emailField.sendKeys(login);
        passwdField.sendKeys(password);
        submitLogin.click();
        return new MainPage(driver);
    }





}
