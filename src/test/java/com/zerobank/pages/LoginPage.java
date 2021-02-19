package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "input#user_login")
    public WebElement usernameInputBox;

    @FindBy(css = "input#user_password")
    public WebElement passwordInputBox;

    @FindBy(css = "input#user_remember_me")
    public WebElement keepSignedInCheckBox;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//a[.='Forgot your password ?']")
    public WebElement forgotPasswordLink;

    @FindBy(css = "div.alert.alert-error")
    public WebElement wrongCredentialsAlert;

    public void login(String usernameStr, String passwordStr) {
        usernameInputBox.sendKeys(usernameStr);
        passwordInputBox.sendKeys(passwordStr);
        signInButton.click();
    }
}
