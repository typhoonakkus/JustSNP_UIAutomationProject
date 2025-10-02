Feature: Login Product Page Add Cart and Checkout Process


  Scenario Outline: Success Login and Validate Product and Complete Chackout
    Given validate login page and click login
    When write username "<user>"
    And write password "<password>"
    And clicks on login btn
    Then user is navigate to the product page
    And user adds first product to cart
    And user navigates to cart
    Then UI product title and price match API data
    And user completes checkout
    Then confirmation message should be displayed
    Examples:
      | user          | password |
      | standard_user | secret_sauce   |




