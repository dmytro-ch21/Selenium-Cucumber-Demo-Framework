@regression
Feature: User search functionality

  @bestBuyRun
  Scenario Outline: Search a product
    Given user lands on best buy
    When user enters "<text>" in search box
    @smartphones
    Examples:
      | text              |
      | iPhone 13 Pro Max |
      | iPhone 15 Pro Max |
      | Blackberry 2023   |
      | Samsung S23       |

    @laptops
    Examples:
      | text             |
      | MacBook Pro M3   |
      | MacBook M2       |
      | MacBook Air 2019 |
      | Gaming Laptop    |