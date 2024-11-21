@AssistNet @port
Feature: My Clients list client selection functionality in the AssistNet Portal

  @SLER-1297
  Scenario: My Clients selection functionality
    And I open the login page on the "assistNet" portal
    When I login as Assistnet User any environment "carrimautomation+AssistersInc@gmail.com" password "ALaska15!" and "c4assistorportal+UT6JO3BqP@gmail.com" password "ALaska16!"
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

    And I validate the "Remove Selected Clients" header option is not displayed
    Then I select all clients checkbox

    And I validate the "Remove Selected Clients" header option is displayed
    Then I verify that a total of "10" clients have been selected from the My Clients list

    Then I select all clients checkbox
    And I validate the "Remove Selected Clients" header option is not displayed

    Then I select a random client's checkbox
    Then I verify that a total of "1" clients have been selected from the My Clients list
    And I click the client list right pagination arrow button
    And I wait for 1000 milliseconds
    Then I select a random client's checkbox
    Then I verify that a total of "2" clients have been selected from the My Clients list
    Then I verify the current client list result page is "2"

    And I click the client list left pagination arrow button
    And I wait for 1000 milliseconds
    Then I select all clients checkbox
    And I click the client list right pagination arrow button
    And I wait for 1000 milliseconds
    Then I select all clients checkbox
    Then I verify that a total of "20" clients have been selected from the My Clients list

    And I click the client list right pagination arrow button
    And I wait for 1000 milliseconds
    Then I select all clients checkbox
    And I wait for 1000 milliseconds
    Then I verify that a total of "30" clients have been selected from the My Clients list

    And I click the client list right pagination arrow button
    And I wait for 1000 milliseconds
    Then I select all clients checkbox
    And I wait for 1000 milliseconds
    Then I verify that a total of "40" clients have been selected from the My Clients list

    And I click the client list right pagination arrow button
    And I wait for 1000 milliseconds
    Then I select all clients checkbox
    And I wait for 1000 milliseconds
    Then I verify that a total of "50" clients have been selected from the My Clients list
    And I verify that the check all clients checkbox is disabled