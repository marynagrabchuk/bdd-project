Feature: Verify Subscription in Cart page
  Scenario: Verify Subscription in Cart page
    Given user landing on a home Page
    When user clicks on a cart button
    And user Scroll down to footer
    And Verify text SUBSCRIPTION
    Then Enter email address in input and click arrow button
    And Verify success message (You have been successfully subscribed!) is visible