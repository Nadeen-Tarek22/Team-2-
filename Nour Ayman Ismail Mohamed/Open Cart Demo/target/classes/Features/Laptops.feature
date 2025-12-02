Feature: Laptops Page Functionality


  Scenario: Ensure all Add to Cart buttons are clickable
    Given the user is on the home page
    When the user opens the Laptops page
    And the user adds all laptop items to the cart
    Then all items should be added successfully

  Scenario: Ensure sorting by Name (A - Z) works correctly
    Given the user is on the home page
    When the user opens the Laptops page
    And the user sorts laptops by "Name (A - Z)"
    Then the laptops should appear sorted alphabetically from A to Z


  Scenario: Ensure the Compare button redirects to the Compare page
    Given the user is on the home page
    When the user opens the Laptops page
    And the user clicks the compare button
    Then the user should be redirected to the compare page
