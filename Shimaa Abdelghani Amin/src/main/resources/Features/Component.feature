Feature: Components Page Functionality

  Scenario: Verify that the Components page is displayed correctly when the user clicks on the "Components" tab
    Given the user is on the home page
    When the user clicks on the Components tab
    Then the Components page should be displayed correctly

  Scenario: Verify that a message “There are no products to list in this category.” is displayed when there are no items under the selected category.
    Given the user is on the home page
    When the user opens an empty category under Components
    Then a message “There are no products to list in this category.” should be displayed

  Scenario: Verify that all product has price , name , image.
    Given the user is on the home page
    When the user opens the Components page
    Then all products should display price, name and image

  Scenario: Ensure all buttons are clickable
    Given the user is on the home page
    When the user opens the Components page
    And the user clicks all Add to Cart buttons
    Then the user should be able to use all buttons successfully
