@ExchBroker
Feature: Broker Dashboard- Verify Broker Data
  @SLER-685
  Scenario:SLER-685:Verify Broker Dashboard dashboard
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
  Scenario:SLER-685:Verify Broker Dashboard with no client
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
  Scenario:SLER-2419:OPS: BrDash: Edit Email Address[RT-2567]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I wait for 500 milliseconds
    Then I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "9074284089" "1905057247" to search user
    Then I click on Search button in AP dashboard page
    And I wait for 500 milliseconds
    Then I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click "Edit Profile" on Account Summary container AP Broker dashboard page
    And I enter new email email address "eluniaxm" in the Summary container
    Then I validate address field should be editable and buttons should have correct styles
    Then I click "Save" button on Account Summary container AP Broker dashboard page
    Then I set the email value for agency STG "9074284089" QA "1905057247"
    And I validate the success message is displayed
    Then I logout from Admin Portal


    Given I open the login page on the "broker" portal
    And I login as Broker User any environment "enrintialtest+testbrokerops@outlook.com" password "ALaska12!" and "eluniaxm+testgj@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "eluniaxm@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    Then I click Agency Dashboard
    And I validate I am on the "Agency Dashboard" page
    And I wait for 500 milliseconds
    Then I validate the "Agency" email on the communication Prefrences container on broker dashboard page
    And I click on broker userName and logout


    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I wait for 500 milliseconds
    Then I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "9074284089" "1905057247" to search user
    Then I click on Search button in AP dashboard page
    And I wait for 500 milliseconds
    Then I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click "Edit Profile" on Account Summary container AP Broker dashboard page
    And I enter new email email address "eluniaxm" in the Summary container
    Then I validate address field should be editable and buttons should have correct styles
    Then I click "Save" button on Account Summary container AP Broker dashboard page
    Then I set the email value for agency STG "9074284089" QA "1905057247"
    And I validate the success message is displayed
    Then I logout from Admin Portal


























