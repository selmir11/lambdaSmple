@BrokerPortalClients @port
Feature: Broker Portal Your Clients page functionality and existing client data validation

  @SLER-2097
  Scenario: : Broker Portal Your Clients page functionality and existing client data validation
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "carrimautomation+LCAgencySTG@gmail.com" password "ALaska12!" and "carrimautomation+LCAgency@gmail.com" password "ALaska12!"
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
    And I validate the Transfer All Clients button is displayed

    Then I verify the current client list result page is "1"
    Then I verify the clients are listed in alphabetical order

    And I click the client list right pagination arrow button
    Then I verify the current client list result page is "2"

    And I click the client list right pagination arrow button
    Then I verify the current client list result page is "3"

    And I click the client list left pagination arrow button
    Then I verify the current client list result page is "2"

    And I click the client list left pagination arrow button
    Then I verify the current client list result page is "1"

    And I search for a client named for staging "Bridgette" or for QA "Bridgette"
    And I wait for 1000 milliseconds
    Then I click on the first client in my list
    Then I verify that my client's current status is "NO ELIGIBILITY"
    And I wait for 1000 milliseconds

    And I clear the client search box to reset my list
    And I search for a client named for staging "Helga" or for QA "Helga"
    And I wait for 1000 milliseconds
    Then I click on the first client in my list
    Then I verify that my client's current status is "ELIGIBILITY ONLY"
    And I wait for 1000 milliseconds

    And I clear the client search box to reset my list
    And I search for a client named for staging "Ollie" or for QA "Ollie"
    And I wait for 2000 milliseconds
    Then I click on the first client in my list
    Then I verify that my client's current status is "POLICY SUBMITTED"
    Then I verify existing client details "Ollie Forbes", "80123", "3035556987", "9024183011" or "8728658600"
    Then I verify existing client plan details "2025", "CYA", "QLCE", "QHP", "Elevate Health Plans Colorado Option Bronze"
    Then I verify the existing secondary client details "Graciela Nielsen", "80123", "2025", "CYA", "QLCE", "QHP", "Anthem Bronze Pathway Essentials 9200 $0 Select Drugs"