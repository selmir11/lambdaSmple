@port @portNoticeLoginPortal
Feature: Trigger Notice IND_Welcome Message AM-001-01 from Admin Portal

  @SLER-1843
  Scenario: Creating a new exchange individual account from Admin Portal
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I validate I am on the "Create Account" page
    And I enter general mandatory data for "Admin exchange" account creation with email "testing.soukaina"@outlook.com
    Then I logout from Admin Portal

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "AM-001-01" in "English"
    And I verify the notice Text for "AM-001-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook