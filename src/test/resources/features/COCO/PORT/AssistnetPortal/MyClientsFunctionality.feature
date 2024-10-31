@coocassistnet @portCOCO
Feature: CoCo My Clients list functionality in the AssistNet Portal

  @SLCR-385
  Scenario: CoCo Your Clients page functionality
    And I open the login page on the "assistNet" portal
    When I login as Assistnet User any environment "carrimautomation+RoyalStafford@gmail.com" password "ALaska12!" and "carrimautomation+RoyalStaffordQA@gmail.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I validate I am on the "assistnet dashboard" page
    And I click on view My Clients button
    Then I click on "colorado Connect" tab
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
    Then I verify the clients are listed in alphabetical order

    And I search for a client named "AAA"
    Then I click on the first client in my list

    And I clear the client search box to reset my list
    Then I verify the current client list result page is "1"
    Then I verify the clients are listed in alphabetical order

    And I click the client list right pagination arrow button
    Then I verify the current client list result page is "2"
    And I search for a client named "Client"
    And I wait for 1000 milliseconds
    Then I verify the current client list result page is "1"
    Then I verify the clients are listed in alphabetical order

    And I click on "connect For Health Colorado" tab
    Then I verify the current client list result page is "1"
    Then I verify the clients are listed in alphabetical order

    And I search for a client named "AAA"
    Then I click on the first client in my list

    Then I click on "colorado Connect" tab
    Then I verify the current client list result page is "1"
    Then I verify the clients are listed in alphabetical order

    Then I validate the search box cannot contain special characters
    And I validate numbers are not allowed in the search box
    And I validate spaces are not allowed in the search box