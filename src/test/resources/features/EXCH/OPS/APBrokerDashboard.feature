@SLER-685
Feature: Broker Dashboard- Verify Broker Data
  @SLER-685
  Scenario: Verify Broker Dashboard dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Broker" checkbox on Admin Portal Dashboard
    And I enter an "Email" in any env "eematu1@msn.com" "Crystal.Broker@invalid.com" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I validate AP broker dashboard Header any env: QA name "Dale Cooper" ID "5590786800" User Type "BROKER" STG name "Crystal Broker" ID "7670732006" User Type "BROKER"
    And I wait for 2000 milliseconds
    And I verify Broker information's Account Summary
    And I verify Broker certification information's
    And I verify Broker Account Activity Container
    And I Verify Broker Client Information Container
    And I click Go Back on admin portal broker dashboard
    Then I validate I am on the "Admin search" page
    Then I logout from Admin Portal
  @SLER-685
  Scenario: Verify Broker Dashboard with no client
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Broker" checkbox on Admin Portal Dashboard
    And I enter an "Email" in any env "Mark.Cuban@invalid.com" "dbe@test.com" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I verify broker client information container no clients
    And I click Go Back on admin portal broker dashboard
    Then I validate I am on the "Admin search" page
    Then I logout from Admin Portal

  @SLER-2419
  Scenario: OPS: BrDash: Edit Email Address[RT-2567]
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    And I refresh the page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "1309040327" "1309007409" to search user
    Then I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click "Edit Profile" on Account Summary container AP Broker dashboard page

    And I enter new email email address "C4PortTesting" in the Summary container
    Then I validate address field should be editable and buttons should have correct styles





