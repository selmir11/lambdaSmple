@AdminPortalOBO @port
Feature: Admin Portal Account creation and notice AM-006-01 validation

  @SLER-1850
  Scenario: : Admin Portal Account creation and notice AM-006-01 validation
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalAccountManagement_UN_STG" password "adminPortalAccountManagement_PW_STG" and "adminPortalAccountManagement_UN_QA" password "adminPortalAccountManagement_PW_QA"
    And I validate I am on the "Admin search" page
    And I click "AP Account Creation" from application links dropdown
    Then I wait for 1000 milliseconds
    Then I validate I am on the "Admin account creation" page
    And I enter general data to create admin account with email "MGC4testing"
    Then I validate the Success message is displayed
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "AM-006-01" in "English"
    And I verify the notice Text for "AM-006-01" in "English" for "Admin"
    Then I delete the open notice
    And I sign out of Outlook