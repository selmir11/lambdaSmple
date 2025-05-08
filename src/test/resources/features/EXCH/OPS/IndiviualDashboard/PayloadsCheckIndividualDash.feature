@OPS @Exch @IndiviualDashboard
Feature: Admin Portal verify data Payloads
  @SLER-695
  Scenario:SLER-695:Verify payloads data on Individual dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4006693955" "7697798005" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I validate individual dashboard container titles are displayed
    And I Verify Payload Information Container
    Then I verify "Payloads" container title
    And I verify the option in years displays
    And I click Go Back on admin portal broker dashboard
    Then I validate I am on the "Admin search" page
    Then I logout from Admin Portal
