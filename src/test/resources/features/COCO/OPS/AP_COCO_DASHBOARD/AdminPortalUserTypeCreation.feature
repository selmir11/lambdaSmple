@OPS @COCO
Feature: AP Create account - Application Links, Admin Portal user creation
  @SLCR-709
  Scenario:Admin Portal - Architecture user creates Admin Portal account with already used email to check error message then create unique A P user
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalAccountManagement_UN_STG" password "adminPortalAccountManagement_PW_STG" and "AdminPortalAccountManagement_UN_QA" password "AdminPortalAccountManagement_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I click "AP Account Creation" from application links dropdown
    And I enter my Admin Portal user data with email that is already in use
    And I wait for 200 milliseconds
    Then I validate the expected error message is displayed as expected
    Then I click "AP Account Creation" from application links dropdown
    And I enter general data to create admin account with email "MGC4testing"
    And I wait for 200 milliseconds
    Then I validate the Success message is displayed
    And I logout from Admin Portal
  @SLCR-709
  Scenario:Admin Portal - Not architecture user have no link for AP Create Account, negative check
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I open the login page on the "admin" portal
    Then I login as Admin User any environment "adminPortalDLT_UN_STG" password "adminPortalDLT_PW_STG" and "adminPortalSEReport_UN_QA" password "adminPortalSEReport_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I validate "AP Account Creation" application link not display
    And I logout from Admin Portal

