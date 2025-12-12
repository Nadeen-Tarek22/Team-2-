Feature: Tablets Page Functionality

  Scenario: Verify that tablet products are displayed with image, name, price.
    Given the user is on the home page
    When the user opens the Tablets page
    Then all tablet products should display image, name and price

  Scenario: Ensure all buttons are clickable
    Given the user is on the home page
    When the user opens the Tablets page
    And the user clicks all buttons
    Then the user should be able to use all the buttons successfully

  Scenario: Verify that product count changes correctly when the user change it.
    Given the user is on the home page
    When the user opens the Tablets page
    And the user changes the product count
    Then the count should be updated correctly
