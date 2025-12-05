Feature: Home page Functionality

  Scenario Outline: Search Elements related to the entered word appear.
    Given user in home page
    When user enter a "<searchWord>" in search bar
    Then user is directed to search page
    When user click on search bar icon
    Then Verify results Related "<keyWord>"

    Examples:
      |searchWord|keyWord|
      |mac       |mac    |
      |iphone     |iphone  |


  Scenario Outline: No result message appear when no search results or products exist
    Given user in home page
    When user enter a "<searchWord>" in search bar
    Then user is directed to search page
    When user click on search bar icon
    Then No products message appear
    Examples:
    |searchWord|
    |backbag   |
    |tshirt    |