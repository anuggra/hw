Feature: Shopping Cart Functionality

  Scenario: Add Items to Cart
    Given User is on the product page
    When User selects an item with name "Sample Product" and adds it to the cart
    Then The item "Sample Product" should appear in the cart