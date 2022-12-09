Feature: Add New Product

  Scenario: Successfully added new Product.
    Given User launch the chrome browser
    And User open the URL "https://admin-demo.nopcommerce.com/login"
    When User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then Page Title should be "Dashboard / nopCommerce administration"
    And User open Catalog accordant
    Then open the product menu
    And User clicks on Add new button for adding new product informatoon
    Given User fill new product information
    Then User scroll-up the page.
    And User saves the information.
