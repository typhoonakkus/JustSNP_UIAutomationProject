Feature: Product Page Add Cart and Checkout Process


  Background: : Login
    Given validate login page and click login
    When write username "standard_user"
    And write password "secret_sauce"
    And clicks on login btn
    Then user is navigate to the product page

    Scenario: Add Product To Cart and Complete Checkout
    And user adds first product to cart
    And user navigates to cart
    And user completes checkout
    Then confirmation message should be displayed






