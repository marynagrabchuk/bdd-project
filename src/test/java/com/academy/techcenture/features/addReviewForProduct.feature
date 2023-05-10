Feature: 21 Add review on product
  Scenario: Add review on product
    Given user on the home page
    When user clicking on product button
    And user Verifies  user is navigated to ALL PRODUCTS page successfully
    Then Click on View Product button
    And user Verify Write Your Review is visible
    Then user Enter name, email and review
    Then user Click Submit button
    And Verify success message Thank you for your review.