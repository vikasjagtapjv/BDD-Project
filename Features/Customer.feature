
Feature:Customer

 Background: Below are common steps for each Scenario
    Given User launch Chrome browser 
    When User Opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as " admin@yourstore.com" and password as "admin"
    And click on Login
    Then User can view Dashboard
    When User click on navBar
    When  User click on customers menu
    And  Click on customer menu item

  Scenario: Add  a new Customer
    And  Click on add new button
    Then User can view Add new customer page
    When User Enter Customer info
    And click on save button
    Then User can view Confirmation message "The new customer has been  added Successfully "
    And close browser 

    Scenario: Search Customer by EmailID
     And Enter customers email
    When Click on search button
    Then user should found Email in the search Table
    And close browser 
   
    Scenario: Search Customer by Name
   
    And Enter Customer First name
    And Enter Customer Last name
    Then User should found name in the search table
     And close browser 
    

 