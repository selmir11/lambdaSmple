@SLCR-48
Feature: print functionality on the Colorado Connect My Clients page
  @SLCR-48
  Scenario: print functionality on My Clients page
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I login as Broker User "testing.soukaina+teststg@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I enter the MFA code and click Verify
    Then I validate I am on the "Broker Dashboard" page
    And I click on "colorado Connect" tab
    Then I verify that Print button is visible and enable

  @SLCR-48
  Scenario: print functionality on My Clients page assistNet
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    When I login as Assistnet User any environment "" password "ALaska12!" and "c4assistorportal+gu21djeMX@gmail.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I enter the MFA code and click Verify
    Then I validate I am on the "assistnet dashboard" page
    And I click on view My Clients button
    Then I verify that Print button is visible and enable in Assistent portal
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard
