Feature:adding iphone element to cart

  Scenario:iphone product is added successfully when clicking on add to cart
    Given user in home page
    When clicking on iphone product
    And  clicking on add to cart button
    Then alert successfully appear
    When clicking on view cart
    Then user is directed to shopping cart page
    And  iphone is existed in elements in cart page
