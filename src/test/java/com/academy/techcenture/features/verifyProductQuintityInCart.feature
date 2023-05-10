Feature: 13.Verify Product quantity in Cart
  Scenario: Verify Product quantity in Cart
    Given user on a Home page and home page is visible
    Given user Clicks View Product for any product on home page
    And Verify product detail is opened
    Then Increase quantity to 4
    And Click Add to cart button
    Then user Click View Cart button
    And Verify that product is displayed in cart page with exact quantity
