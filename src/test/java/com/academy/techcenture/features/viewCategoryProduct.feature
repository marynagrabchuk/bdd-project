Feature: 18.View Category Products
  Scenario: View Category Products
    Given user lands  on Home Page
    And user Verify that categories are visible on left side bar
    When user Click on Women category
    And Click on any category link under Women category, for example: Dress
    Then Verify that category page is displayed and confirm text (WOMEN - TOPS PRODUCTS)
    When On left side bar, click on any sub-category link of Men category
    And Verify that user is navigated to that category page