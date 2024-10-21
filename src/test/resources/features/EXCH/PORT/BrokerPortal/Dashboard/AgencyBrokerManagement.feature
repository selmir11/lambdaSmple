@BrokerPortalManageBrokers @port @Dashboard
Feature: Verify associated broker management in Broker Portal

  @SLER-693
  Scenario: Verify the Agency Owner's ability to send an invite to a new broker
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "johnc4hcoautomation+1734age@gmail.com" password "ALaska13!" and "johnc4hcoautomation+1734qaage@gmail.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Agency Dashboard
    Then I click the Manage Brokers button
    And I search for a broker named "oneseventhreefour"
    Then I send the invite to join my agency
    Then I click on broker userName and logout

  @SLER-693
  Scenario: Verify the broker's ability to accept an invite to a new agency
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "johnc4hcoautomation+1734bro@gmail.com" password "ALaska13!" and "johnc4hcoautomation+1734qabro@gmail.com" password "ALaska13!"
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

  @SLER-693
  Scenario: Verify the Agency Owner's ability to remove a broker from their agency and resend
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "johnc4hcoautomation+1734age@gmail.com" password "ALaska13!" and "johnc4hcoautomation+1734qaage@gmail.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Agency Dashboard
    Then I click the Manage Brokers button
    And I search for a broker named "oneseventhreefour"
    Then I remove the broker from my agency
    Then I click Go Back on the Manage Associated Brokers page

    Then I click the Manage Brokers button
    Then I send the invite to join my agency
    Then I click on broker userName and logout

  @SLER-693
  Scenario: Verify the broker's ability to deny a previously accepted invitation to a new agency
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "johnc4hcoautomation+1734bro@gmail.com" password "ALaska13!" and "johnc4hcoautomation+1734qabro@gmail.com" password "ALaska13!"
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
    Then I click Go Back on the My Agency page

    Then I click the My Agency View link
    Then I deny the agency invite
    Then I click on broker userName and logout