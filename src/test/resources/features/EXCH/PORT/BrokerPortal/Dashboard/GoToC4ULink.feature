@BrokerPortalDashboard @port @Dashboard
Feature: Verify broker access to the C4U link on the Dashboard page

  @SLER-544
  Scenario: Verify broker access to the C4U link on the Dashboard page
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    Then I enter mandatory data for "Broker" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page
    And I log into my "Broker" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I enter the MFA code and click Verify
    Then I click Broker Dashboard
    And I click the C4U Link
    Then I validate I am on the "Broker Portal C4U link" page