Feature: 19. View & Cart Brand Products
  Scenario:  View & Cart Brand Products
    Given user lands on Home Page
    When user Click on the Products button
    And user Verify that Brands are visible on left side bar
    When user Click on any brand name
    And Verify that user is navigated to brand page and brand products are displayed
    Then On left side bar, click on any other brand link
    And Verify that user is navigated to that brand page and can see products