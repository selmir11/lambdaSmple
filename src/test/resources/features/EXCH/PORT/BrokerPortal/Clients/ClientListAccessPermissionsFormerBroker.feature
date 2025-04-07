@BrokerPortalClients @port
Feature: Verify a former broker no longer has access to the agency's client list

  @SLER-2280
  Scenario: : Individual account creation and broker authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I validate I am on the "Find Expert Help Exch" page
    And I click on Find a Broker
    Then I Search authorized Broker "Noah Trujillo"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Noah Trujillo", "Arrow Head Agency", "983624175862", "80205", "719-405-4901", "BROKER", "Active"
    And I click on Sign Out in the Header for "Elmo"

  #Creating a new broker account to invite to an agency
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

  #Agency Owner sends an invite to a new broker
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

  #Broker accepts the invite to a new agency
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
    Then I click Broker Dashboard

    Then I click View Your Clients button
    Then I switch to the tab number 1
    And I wait for 2000 milliseconds
    And I search for clients
    And I click on first client search result
    And I verify my client's name is displayed

    And I close current tab and switch back to previous tab
    Then I click the My Agency View link
    Then I deny the agency invite
    Then I click Broker Dashboard

    Then I click View Your Clients button
    Then I switch to the tab number 1
    And I wait for 2000 milliseconds
    And I search for clients
    Then I validate The Client is removed successfully

    Then I click on broker userName and logout