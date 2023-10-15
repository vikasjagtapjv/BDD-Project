
  Feature:New_Feature
  
  Scenario:Login With valid credential
    Given Launch the ChromeBrowser
    When Open the Url "https://opensource-demo.orangehrmlive.com"
    And Enters the UserName 
    And Enters the Password 
    And Click on login
    Then Page title should be "OrangeHRM"
    When User click on OrangeHRM.Inc
    Then Title should be"OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM" 
      
      
      
      
      
      
      
      
      
      
      
      
      
      
