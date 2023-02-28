Feature: Verify Subscription in home page
  Scenario: Verify Subscription in home page
    Given user lands on a home Page
    When user scroll down to footer
    And user verifies text Subscription
    When user Enter email address in input and click arrow button
    Then Verify success message 'You have been successfully subscribed!' is visible