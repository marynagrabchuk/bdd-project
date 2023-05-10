Feature: Place Order: Login before Checkout

  Scenario: Place Order: Login before Checkout
    Given nav to home page
    When user clicks sign in sihnup button
    Then user Fill email, password and click Login button
    And Verify Logged in as username at top
    When user Adds product to cart
    And uer Click Cart button
    Then user Verify that cart page is displayed
    When user Clicks Proceed To Checkout
    And user Verify Address Details and Review Your Order
    Then Enter description in comment text area and click place Order
    Then Enter payment details : Name on Card, Card Number, CVC, Expiration date
    And Click Pay and Confirm Order
    And user Verify success message 'Your order has been placed successfully!'