
Feature: Transaction Page UI Test


  Scenario: Verify the Transactions page UI is displayed correctly
    Given the user is on the login page
    When the user enters a valid username and password
    And the user clicks the login button
    And the user navigates to the Transactions page
    Then the Transactions page title should be displayed correctly
    And the transactions table should be visible
