Feature: Verify All Products and product detail page
  Scenario:
    Given user is on the HomePage
    When user Clicks on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    And user verifies The products list is visible
    Then user  Clicks on View Product of first product
    When user User is landed to product detail page
    Then user Verifies that detail is visible: product name, category, price, availability, condition, brand

