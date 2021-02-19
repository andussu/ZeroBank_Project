package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().toSignInButton.click();
    }

    @When("the user enters the user credentials")
    public void the_user_enters_the_user_credentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("user_username"), ConfigurationReader.get("user_password"));
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        String expectedUsername = ConfigurationReader.get("user_username");
        String actualUsername = new AccountSummary().usernameDropdown.getText();

        Assert.assertEquals("Checking if username is displayed correct after login", expectedUsername, actualUsername);
    }

    @And("the user is on {string} page")
    public void theUserIsOnPage(String page) {
        String expectedTitle = "Zero - " + page;
        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals("Checking if page title is correct", expectedTitle, actualTitle);
    }

    @Then("the user should not be able to login")
    public void theUserShouldNotBeAbleToLogin() {
        Assert.assertTrue(new LoginPage().wrongCredentialsAlert.isDisplayed());
    }

    @When("the user enters wrong username and correct password")
    public void theUserEntersWrongUsernameAndCorrectPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("a1b2c3d4", ConfigurationReader.get("user_password"));
    }

    @When("the user enters correct username and wrong password")
    public void theUserEntersCorrectUsernameAndWrongPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("user_username"),"a1b2c3d4");
    }

    @When("the user enters wrong credentials")
    public void theUserEntersWrongCredentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("a1b2c3d4", "a1b2c3d4");
    }

    @When("the user enters blank credentials")
    public void theUserEntersBlankCredentials() {
        LoginPage loginPage  = new LoginPage();
        loginPage.login("","");
    }
}
