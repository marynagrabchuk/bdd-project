Feature: Verify All Products and product detail page
  Scenario:
    Given user on a Home Page and home page is visible
    When  Click Products button
    And user Hover over first product and click (Add to cart)
    Then Click (Continue Shopping) button
    And user Hover over second product and click (Add to cart)
    Then user Click (View Cart) button
    And Verify both products are added to Cart
    Then Verify their prices, quantity and total price