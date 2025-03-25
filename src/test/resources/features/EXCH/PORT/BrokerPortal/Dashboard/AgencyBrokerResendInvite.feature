@BrokerPortalManageBrokers @port @Dashboard
Feature: Verify a newly created associated broker's ability to deny an agency invite in Broker Portal

  @SLER-2279
  Scenario: Creating a new broker account to invite to an agency
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    Then I enter mandatory data for "Broker" account creation with email "C4BrokerTesting"@outlook.com
    Then I validate I am on the "Login" page

    And I log into my "Broker" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4BrokerTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Dashboard" page
    Then I validate the dashboard displays my "Broker" name

    And I click Complete Profile
    Then I validate the Your Information page title

    Then I enter my "Broker" license number and dates
    And I click No to the Book of Business question
    Then I click Continue on the Your Information page

    Then I click Continue on the Communication Preferences page

    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    Then I click Submit on the Broker Portal Terms page
    Then I click Go to my Dashboard

    Then I click on broker userName and logout

  Scenario: Agency Owner sends an invite to a new broker
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "NoahTrujilloAgencySTG@agency.com" password "ALaska15!" and "NoahTrujilloAgency@agency.com" password "ALaska14!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I wait for 2000 milliseconds

    Then I click Agency Dashboard
    Then I click the Manage Brokers button
    Then I click the Add New Broker Link

    Then I search for the new broker
    And I validate the broker results match my broker's details
    Then I click the Add link on the Add a Broker page
    And I validate the Invitation Sent text
    Then I click Go Back on the Add a Broker page

    Then I click on broker userName and logout

  Scenario: Broker denies an invite to a new agency
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I log into my "Broker" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4BrokerTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I click the My Agency View link
    Then I verify the current agency invitation details are "Arrow Head Agency", "720-789-6532" and "PENDING"
    Then I deny the agency invite
    And I wait for 2000 milliseconds
    And I verify there are no agency invites
    Then I click on broker userName and logout

  Scenario: Agency Owner sends another invite to the broker
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "NoahTrujilloAgencySTG@agency.com" password "ALaska15!" and "NoahTrujilloAgency@agency.com" password "ALaska14!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I wait for 2000 milliseconds

    Then I click Agency Dashboard
    Then I click the Manage Brokers button
    Then I search for the new broker on the Manage Associated Brokers page
    And I wait for 2000 milliseconds
    And I validate the broker results match my new broker
    Then I send the invite to join my agency
    And I wait for 2000 milliseconds
    And I verify the invite is "Pending Acceptance"
    Then I click on broker userName and logout

  Scenario: Broker accepts the invite to a new agency
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I log into my "Broker" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4BrokerTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I click the My Agency View link
    Then I verify the current agency invitation details are "Arrow Head Agency", "720-789-6532" and "PENDING"
    Then I approve the agency invite
    Then I click on broker userName and logout