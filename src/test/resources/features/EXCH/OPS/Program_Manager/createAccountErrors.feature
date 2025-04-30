@OPS @Exch @ProgramManager
@SLER-2186
Feature: OPS: PMDash: Create Account/Errors
  @SLER-2186
  Scenario:SLER-2186: OPS: PMDash: Create Account/Errors
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I click create account on admin portal
    Then I click on create profile button on Create Program Manager Profile page
    And I validate errors are displaying on Create Program Manager Profile page
    Then I create program manger profile on admin portal "c4assistorportal"
    And I validate the success message for Profile creation is displayed
    Then I logout from Admin Portal