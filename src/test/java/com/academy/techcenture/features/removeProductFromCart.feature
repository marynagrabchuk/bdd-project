Feature: Remove Products From Cart
  Scenario: Remove Products From Cart
    Given User Verify that home page is visible successfully
    When User Add products to cart
    Then User Click Cart Button
    And User  Verify that cart page is displayed
    Then User  Click X button corresponding to particular product
    And User  Verify that product is removed from the cart