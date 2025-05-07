@OPS @Exch @IndiviualDashboard
Feature: Admin Portal agency verify data
  @SLER-534
  Scenario:SLER-534:Verify agency data
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "Agency" checkbox on Admin Portal Dashboard
    And I search for Agency using "stateLicenseNumber" "65873464" on Agency dashboard
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Agency dashboard" page
    Then I verify Agency name and account number displays
    Then I validate data for Agency Summary: "Hanks Enterprises" "546424428" "Agent: Tom Hanks" "invalid@test.com" "Website:" "343-523-6523"
    And logout from Admin Portal