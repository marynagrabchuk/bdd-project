Feature: Register User with existing email
  Scenario: User register with existing email and get error message
    Given user is on the homePage
    Then user verify the homePage is visible
    When user  clicks the SignUp  Login button
    And user verify new  user Signup! is visible
    When user enter name and already registered email address
    Then user clicks on singUp button log in button
    And user verify error Email address already exist! is visible