Feature: Log in with correct  and incorrect credentials
  Background: Click on signup btn
    Given user navigates to home page and page is visible
    When user clicking on Signup Login button
    And  user Verifies Login to your account is visible

  Scenario: Login User with correct email and password
    Then user Enter correct email address and password
    And  user  Clicks login button
    Then user verify  log in success is visible

  Scenario: Login User with incorrect email and password
    Then user Enter incorrect email address and password
    And  user  Clicks login button after
    Then user verify error Your email or password is incorrect! is visible
