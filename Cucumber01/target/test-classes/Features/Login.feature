Feature: LoginTest

  Scenario: Successfully login with correct credentials
    Given User launch the chrome browser
    And User open the URL "https://admin-demo.nopcommerce.com/login"
    When User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then Page Title should be "Your store. Login"
    And Close Browser
