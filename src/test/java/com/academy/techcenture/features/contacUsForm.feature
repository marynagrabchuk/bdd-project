Feature: Test Contact us form
  Scenario: Contact Us Form
    Given user is on a Home Page and home page is visible
    When user Clicks on Contact Us button
    And user verifies get in touch is visible
    Then user enters name, email, subject and message
    |name     |email        |message                  |
    |Kevin Lee|abb@gmail.com|Why my account is blocked|
    When user uploads a file
    And user clicks on a submit button
    Then user clicks ok button
    And user veryfies Verify success message (Success! Your details have been submitted successfully.) is visible
    Then user clicks on Home button and verify that landed to home page successfully

