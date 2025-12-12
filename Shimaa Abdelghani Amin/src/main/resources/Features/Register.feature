Feature: Register Page Functionality

  Scenario: Ensure error message is displayed when personal details are blank
    Given the user is on the home page
    When the user opens the Register page
    And the user submits the form with blank personal details
    Then an error message should be displayed

  Scenario: Ensure password field hides characters
    Given the user is on the home page
    When the user opens the Register page
    And the user types in the password field
    Then the characters should be hidden

  Scenario: Ensure system accepts only valid credentials
    Given the user is on the home page
    When the user opens the Register page
    And the user enters valid registration credentials
    Then the system should accept the registration successfully
