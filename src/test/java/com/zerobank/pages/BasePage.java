package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @FindBy(css = "div.container>a.brand")
    public WebElement indexLink;

    @FindBy(css = "input#searchTerm")
    public WebElement searchBox;

    @FindBy(css = "li>#signin_button")
    public WebElement toSignInButton;

    @FindBy(xpath = "(//li//a[@class='dropdown-toggle'])[2]")
    public WebElement usernameDropdown;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

}
