@BrokerPortalDB @port
Feature: Allow AP users to update Broker communications preferences email

  @SLER-1841
  Scenario: Allow AP users to update Broker communications preferences email
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I wait for 500 milliseconds
    Then I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "4007848474" "8740878600" to search user
    Then I click on Search button in AP dashboard page
    And I wait for 500 milliseconds
    Then I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click "Edit Profile" on Account Summary container AP Broker dashboard page
    And I enter new email email address "testing.soukaina" in the Summary container
    Then I click "Save" button on Account Summary container AP Broker dashboard page
    Then I set the email value for agency STG "4007848474" QA "8740878600"
    Then I validate the agency email in DB
    And I validate the success message is displayed
    And I click on Search button in AP broker dashboard page
    And I validate I am on the "Admin search" page
    And I wait for 500 milliseconds
    Then I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "2844004878" "6507800786" to search user
    Then I click on Search button in AP dashboard page
    And I wait for 500 milliseconds
    Then I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click "Edit Profile" on Account Summary container AP Broker dashboard page
    And I enter new email email address "C4PortTesting" in the Summary container
    Then I click "Save" button on Account Summary container AP Broker dashboard page
    Then I set the email value for broker STG "2844004878" QA "6507800786"
    Then I validate the broker email in DB
    And I validate the success message is displayed
    Then I logout from Admin Portal

    Given I open the login page on the "broker" portal
    And I login as Broker User any environment "cmzwajss@test.com" password "ALaska12!" and "cmgstpss@test.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
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

    #validate broker email
    Given I open the login page on the "broker" portal
    And I login as Broker User any environment "cmlavwss@test.com" password "ALaska12!" and "cmgbkcss@test.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    Then I click Broker Dashboard
    And I validate I am on the "Broker Dashboard" page
    And I wait for 500 milliseconds
    Then I validate the "Broker" email on the communication Prefrences container on broker dashboard page
    And I click on broker userName and logout








