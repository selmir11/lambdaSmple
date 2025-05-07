@OPS @APGeneral
Feature: AP Create account - Application Links
  @SLER-1939
  Scenario:SLER-1939:Admin Portal - Architecture user creates Admin Portal account
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalAccountManagement_UN_STG" password "adminPortalAccountManagement_PW_STG" and "AdminPortalAccountManagement_UN_QA" password "AdminPortalAccountManagement_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I click "AP Account Creation" from application links dropdown
    And I enter general data to create admin account with email "MGC4testing"
    Then I validate the Success message is displayed
    And I logout from Admin Portal
  @SLER-1939
  Scenario:SLER-1939:Admin Portal - Not architecture user have no link for AP Create Account
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I open the login page on the "admin" portal
    Then I login as Admin User any environment "adminPortalSEReport_UN_STG" password "adminPortalSEReport_PW_STG" and "adminPortalSEReport_UN_QA" password "adminPortalSEReport_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I validate "AP Account Creation" application link not display
    And I logout from Admin Portal
    