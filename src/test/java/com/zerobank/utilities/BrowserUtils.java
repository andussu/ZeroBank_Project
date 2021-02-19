package com.zerobank.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserUtils {

    @FindBy(css = "button#details-button")
    public static WebElement advancedButton;

    @FindBy(css = "a#proceed-link")
    public static WebElement proceedLink;


    public static void proceedToPage() {
        advancedButton.click();
        proceedLink.click();
    }
}
