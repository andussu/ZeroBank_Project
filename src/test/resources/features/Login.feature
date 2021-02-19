@wip
Feature: Authorised user should be able to login

#positive testing

  Scenario: Login as a user

    Given the user is on login page
    When the user enters the user credentials
    Then the user should be able to login
    And the user is on "Account Summary" page

#negative testing

  Scenario: Fail the login with wrong username and correct password
    Given the user is on login page
    When the user enters wrong username and correct password
    Then the user should not be able to login

  Scenario: Fail the login with correct username and wrong password
    Given the user is on login page
    When the user enters correct username and wrong password
    Then the user should not be able to login

  Scenario: Fail the login with wrong credentials
    Given the user is on login page
    When the user enters wrong credentials
    Then the user should not be able to login

  Scenario: Fail the login with blank credentials
    Given the user is on login page
    When the user enters blank credentials
    Then the user should not be able to login
