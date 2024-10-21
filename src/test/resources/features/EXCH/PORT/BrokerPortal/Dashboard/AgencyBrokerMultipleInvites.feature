@BrokerPortalManageBrokers @port @Dashboard
Feature: Verify associated broker can't accept more than one invite from an agency in Broker Portal

  @SLER-697
  Scenario: Verify the broker's inability to accept an invite from a second agency
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "carrimautomation+MSloanSTG@gmail.com" password "ALaska12!" and "carrimautomation+MSloan@gmail.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Broker Dashboard
    Then I click the My Agency View link
    Then I approve the second agency invite
    And I verify the unable to accept more than one agency invite error message
    Then I click OK to the agency invite error message
    Then I click on broker userName and logout