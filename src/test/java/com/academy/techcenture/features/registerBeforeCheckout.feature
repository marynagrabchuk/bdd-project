Feature:  Register before Checkout
  Scenario: Place Order: Register before Checkout
    Given user land on a home Page
    When user Click Signup  Login button
    And Fill  details in Signup and create account
      |Name     |Email           |Password|Date|Month|Year|Title|First name|Last name|Company|Address        |State   |City  |Zipcode|Mobile    |Country      |
      |Kevin Lee|kevlee@gmail.com|123Ken! |12  |May  |1988|Mr   |Kevin     |Lee      |IPK GMB|123 main street|Virginia|McLean|22102  |7031112233|United States|
    And Verify ACCOUNT CREATED! and click Continue button
    Then Verify  Logged in as username  at top
    When Add products  to cart
    And  Click Cart button
    And user Verifies that cart page is displayed
    When user Click Proceed To Checkout
    Then user verify Address Details and Review Your Order
    And user Enter description in comment text area and click Place Order
    When Enter payment details: Name on Card Card Number CVC Expiration date
    Then user Click Pay and Confirm Order button
    And Verify success message 'Your order has been placed successfully!'

