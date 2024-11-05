@SLER-748
Feature: Broker Dashboard- Change license and certification statuses
  @SLER-748
  Scenario: Verify Broker Dashboard in Admin Portal -  Change license and certification statuses
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "8363832700" "7660020008" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click Manage Certification button
    And I validate current Broker License Status: "APPROVED" and License Expiration Date: "" with Certification Status: "APPROVED"
    Then I change statuses and click Save button in manage certification container
    Then I click Manage Certification button
    Then I verify expected statuses are displayed
    And I validate current Broker License Status: "Not Approved" and License Expiration Date: "" with Certification Status: "Not Approved"
    Then I click Cancel button
    Then I click Manage Certification button
    Then I change statuses back and click Save
    And I click View Report button
    Then I verify Account Activity title
    Then I wait for 700 milliseconds
   # And I Verify Broker Account Activity latest information
    And I validate latest Broker Account Activity Report Event Code: "SP_BROKER_CERTIFIED" and Date: "2024-11-04" then Username: "AGENCY-SERVICE" with Description: "Broker certified" and finally Detail Value: "7660020008"
