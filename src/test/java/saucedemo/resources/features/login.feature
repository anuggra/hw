Feature: Login to saucedemo.com

  Scenario: Successful login with valid credentials
    Given On Login page
    When Input username
    And Input password
    And Click login button
    Then User is on dashboard page

  Scenario: Invalid login with incorrect credentials
    Given User is on the saucedemo login page
    When User enters invalid username and password
    And User clicks on login button
    Then User should see an error message