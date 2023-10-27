Feature: Product Sorting Functionality

  Scenario: User Sorts Products by Price (Low to High)
    Given User is on the product listing page
    When User selects to sort products by "Price: Low to High"
    Then Products should be displayed in ascending order of price