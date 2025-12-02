
Feature: Desktops Page Functionality


  Scenario: Ensure all Add to Cart buttons are clickable
    Given the user is in the home page
    When the user opens the Desktops page
    And the user adds all desktop items to the cart
    Then all items should be added successfully


  Scenario: Ensure the Next Page button is clickable
    Given the user is on the home page
    When the user opens the Desktops page
    And the user clicks the next page button
    Then the page should navigate to a new URL


  Scenario: Ensure the Compare button redirects to the Compare page
    Given the user is on the home page
    When the user opens the Desktops page
    And the user clicks the compare button on the desktops page
    Then the user should be redirected to the compare page from the desktops page
