Feature: Test Register User Functionality

  Scenario: Check user register functionality works properly
    When user on home page, home page is visible
    When user clicks on sing up button log in button
    Then user is been navigated to login page
    Then user enters name and email
    And user clicks sing up
    Then user navigates to create an account page
    Then user enters <Title>, <Name>, <Email>, <Password>, <Date of birth>
      |Name     |Email           |Password|Date|Month|Year|Title|
      |Kevin Lee|kevlee@gmail.com|123Ken! |12  |May  |1988|Mr   |
    Then user  Select checkbox 'Sign up for our newsletter!'
    Then user Select checkbox 'Receive special offers from our partners!
    Then user Fill details: <First name>, <Last name>, <Company>, <Address>, <Address2>, <Country>, <State>, <City>, <Zipcode>, <Mobile>
      |First name|Last name|Company|Address        |State   |City  |Zipcode|Mobile    |Country      |
      |Kevin     |Lee      |IPK GMB|123 main street|Virginia|McLean|22102  |7031112233|United States|
    Then user Clicks 'Create Account button'
    Then user navigated to account created successfully page
    Then user clicks continue button
    Then user navigated to the home page

