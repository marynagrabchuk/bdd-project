Feature: Log out user
  Scenario: Log out user
    Given user navigated to home page and page is visible
    When user clicks on Signup Login button
    And  user Verifies Login to your account Is visible
    Then user Enters correct email address and password
    And  user  Click login button
    Then user verifies  log in success is visible
    When user click log out button
    Then user navigated to home page