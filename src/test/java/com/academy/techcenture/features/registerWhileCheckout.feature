Feature: Register while Checkout
  Scenario: Register while Checkout
    Given on a Home page and home page is visible
    Given Add products to cart
    When user Click Cart button
    And Verify that cart page is displayed
    Then Click Proceed To Checkout
    And user Click Register Login button
    And Fill all details in Signup and create account
      |Name     |Email           |Password|Date|Month|Year|Title|First name|Last name|Company|Address        |State   |City  |Zipcode|Mobile    |Country      |
      |Kevin Lee|kevlee@gmail.com|123Ken! |12  |May  |1988|Mr   |Kevin     |Lee      |IPK GMB|123 main street|Virginia|McLean|22102  |7031112233|United States|
    And user Verify ACCOUNT CREATED! and click Continue button
    Then Verify  Logged in as username at top
    When user Click Cart button
    Then Click Proceed To Checkout button
    And Verify Address Details and Review Your Order
    Then Enter description in comment text area and click Place Order
    Then Enter payment details: Name on Card, Card Number, CVC, Expiration date
    And Click Pay and Confirm Order button
    And Verify success message Your order has been placed successfully!


