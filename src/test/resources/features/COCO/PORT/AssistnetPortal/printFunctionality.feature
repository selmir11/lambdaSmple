@SLCR-48 @portCOCO
Feature: print functionality on the Colorado Connect My Clients page
  @SLCR-48
  Scenario: print functionality on My Clients page
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+TransferSTG@outlook.com" password "ALaska12!" and "C4PortTesting+Transfer@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I validate I am on the "Broker Portal Your Clients" page
    And I click on "colorado Connect" tab
    Then I verify that Print button is visible and enable
    Then I click on broker userName and logout

  @SLCR-48
  Scenario: print functionality on My Clients page assistNet
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    When I login as Assistnet User any environment "c4assistorportal+Gw7iYxhCL@gmail.com" password "ALaska12!" and "c4assistorportal+gu21djeMX@gmail.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I validate I am on the "assistnet dashboard" page
    And I click on view My Clients button
    Then I verify that Print button is visible and enable in Assistent portal
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard
