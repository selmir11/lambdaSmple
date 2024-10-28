@BrokerPortalCoCoClients @portCOCO
Feature: CoCo Your Clients page functionality in Broker Portal

  @SLCR-386
  Scenario: : CoCo Your Clients page functionality
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "carrimautomation+Mclaughlin@gmail.com" password "ALaska12!" and "carrimautomation+LucienMclaughlin@gmail.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title

    And I click on "colorado Connect" tab
    Then I verify the current client list result page is "1"
    And I search for a client named "AAA"
    Then I click on first client search result
    Then I validate the "Remove Client" option is displayed
    Then I validate the "Transfer" option is displayed
    Then I validate the "Manage" option is displayed

    And I click on "connect For Health Colorado" tab
    Then I verify the current client list result page is "1"
    And I search for a client named "AAA"
    Then I click on first client search result
    Then I validate the "Remove Client" option is displayed
    Then I validate the "Transfer" option is displayed
    Then I validate the "Manage" option is displayed

    And I click on "colorado Connect" tab
    Then I verify the current client list result page is "1"
    Then I verify the clients are listed in alphabetical order
    And I click the client list right pagination arrow button
    Then I verify the clients are listed in alphabetical order
    Then I verify the current client list result page is "2"

    And I click on "connect For Health Colorado" tab
    Then I verify the current client list result page is "1"
    Then I verify the clients are listed in alphabetical order