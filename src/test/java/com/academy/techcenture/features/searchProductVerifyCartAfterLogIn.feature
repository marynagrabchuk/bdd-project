Feature: 20.Search Products and Verify Cart After Login
  Scenario: Search Products and Verify Cart After Login
    Given user on a Home page
    When user clicks  on product button
    And user Verifies user is navigated to ALL PRODUCTS page successfully
    When user Enters product name in search input and click search button
    And user Verify SEARCHED PRODUCTS  is visible
    Then user Verifies all the products related to search are visible
    When user Add those products to cart
    Then Click Cart button and verify that products are visible in cart
    And Click Signup  Login button and submit login details
    Then user Again, go to Cart page
    And Verify that those products are visible in cart after login as well