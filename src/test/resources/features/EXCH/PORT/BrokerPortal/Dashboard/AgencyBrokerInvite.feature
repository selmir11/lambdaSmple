@BrokerPortalManageBrokers @port @Dashboard
Feature: Verify agency owner broker invite in Broker Portal

  @SLER-696
  Scenario: Verify the Agency Owner's ability to send an invite to a new broker
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "johnc4hcoautomation+1931staging@gmail.com" password "ALaska13!" and "johnc4hcoautomation+1931qa@gmail.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Agency Dashboard
    Then I click the Manage Brokers button
    And I search for a broker named "oneninethreeone"
    Then I validate the Send Invite link is "displayed"
    Then I send the invite to join my agency
    Then I click Go Back on the Manage Associated Brokers page
    Then I click the Manage Brokers button
    And I verify the invite is "Pending Acceptance"
    Then I click on broker userName and logout

  @SLER-696
  Scenario: Verify the broker's ability to accept an invite to a new agency
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "johnc4hcoautomation+1931stagingbro@gmail.com" password "ALaska13!" and "johnc4hcoautomation+1931qabro@gmail.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Broker Dashboard
    Then I click the My Agency View link
    Then I approve the agency invite
    Then I click on broker userName and logout

  @SLER-696
  Scenario: Verify the Agency Owner's ability to remove a broker from their agency so the accounts are reset
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "johnc4hcoautomation+1931staging@gmail.com" password "ALaska13!" and "johnc4hcoautomation+1931qa@gmail.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Agency Dashboard
    Then I click the Manage Brokers button
    And I search for a broker named "oneninethreeone"
    Then I validate the Send Invite link is "changed to Remove"
    Then I remove the broker from my agency
    Then I click on broker userName and logout
