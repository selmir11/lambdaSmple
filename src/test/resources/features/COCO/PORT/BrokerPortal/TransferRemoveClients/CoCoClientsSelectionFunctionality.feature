@CoCoTransferRemove @portCOCO
Feature: CoCo Your Clients page client selection functionality

  @SLCR-399
  Scenario: : CoCo Your Clients page client selection functionality
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+MWalkerSTG@outlook.com" password "ALaska12!" and "C4PortTesting+MaggieWalker@outlook.com" password "ALaska12!"
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
    And I validate the "Remove Selected Clients" header option is not displayed

    Then I select all clients checkbox
    And I validate the "Remove Selected Clients" header option is displayed
    And I validate the "Transfer Selected Clients" header option is displayed
    Then I verify that a total of "10" clients have been selected

    Then I select all clients checkbox
    And I validate the "Remove Selected Clients" header option is not displayed
    Then I verify that a total of "0" clients have been selected

    Then I select a random client's checkbox
    Then I verify that a total of "1" clients have been selected
    And I click the client list right pagination arrow button
    Then I select a random client's checkbox
    Then I verify that a total of "2" clients have been selected
    Then I verify the current client list result page is "2"

    And I click the client list left pagination arrow button
    Then I select all clients checkbox
    Then I verify that a total of "11" clients have been selected
    Then I verify the current client list result page is "1"

    And I click the client list right pagination arrow button
    Then I verify the current client list result page is "2"
    Then I select all clients checkbox
    And I validate the "Remove Selected Clients" header option is displayed
    And I validate the "Transfer Selected Clients" header option is displayed
    Then I verify that a total of "20" clients have been selected

    And I click the client list right pagination arrow button
    Then I verify the current client list result page is "3"
    Then I select all clients checkbox
    And I validate the "Remove Selected Clients" header option is displayed
    And I validate the "Transfer Selected Clients" header option is displayed
    Then I verify that a total of "30" clients have been selected

    And I click the client list right pagination arrow button
    Then I verify the current client list result page is "4"
    Then I select all clients checkbox
    And I validate the "Remove Selected Clients" header option is displayed
    And I validate the "Transfer Selected Clients" header option is displayed
    Then I verify that a total of "40" clients have been selected

    And I click the client list right pagination arrow button
    Then I verify the current client list result page is "5"
    Then I select all clients checkbox
    And I validate the "Remove Selected Clients" header option is displayed
    And I validate the "Transfer Selected Clients" header option is displayed
    Then I verify that a total of "50" clients have been selected
    And I verify that the check all clients checkbox is disabled