Feature: Login

Scenario: Login With valid credentials
   Given User launch Chrome browser
   When User Opens URL "https://admin-demo.nopcommerce.com/login"
   And  User enters Email as " admin@yourstore.com" and password as "admin"
   And  click on Login
   Then page Title should be "Dashboard / nopCommerce administration"
   When User click on logout link
   Then page Title should be "Your store. Login"
   And close browser 
   
