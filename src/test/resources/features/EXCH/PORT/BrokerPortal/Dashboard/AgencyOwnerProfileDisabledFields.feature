@BrokerPortalProfile @port @Dashboard
Feature: Verify completed agency owner profile disabled fields in Broker Portal

  @SLER-704
  Scenario: Verify completed agency owner profile disabled fields
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
    Then I click Agency Dashboard
    Then I click the Edit Agency Information link
    Then I verify the Agency Group field is disabled
    Then I click Cancel on the Agency Details page
    Then I click Edit in Account Summary
    Then I verify the Book of Business buttons are disabled
    Then I click on broker userName and logout
