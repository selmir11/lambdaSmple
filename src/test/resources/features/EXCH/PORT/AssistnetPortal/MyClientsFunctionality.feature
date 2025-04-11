@AssistNet @port
Feature: My Clients list client functionality and existing client data validation in the AssistNet Portal

  @SLER-2057
  Scenario: My Clients list client functionality and existing client data validation in the AssistNet Portal
    And I open the login page on the "assistNet" portal
    When I login as Assistnet User any environment "C4PortTesting+BlueRiverSTG@outlook.com" password "ALaska12!" and "C4PortTesting+BlueRiver@outlook.com" password "ALaska12!"
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
    And I wait for 1000 milliseconds
    Then I click on the first client in my list
    Then I verify that my client's current status is "POLICY SUBMITTED"
    Then I verify existing assister client details "Ollie Forbes", "80123", "3035556987", "9024183011" or "8728658600"
    Then I verify existing assister client plan details "2025", "QHP", "Denver Health"
    Then I verify the existing assister secondary client details "Graciela Nielsen", "80123", "2025", "QHP", "Anthem"