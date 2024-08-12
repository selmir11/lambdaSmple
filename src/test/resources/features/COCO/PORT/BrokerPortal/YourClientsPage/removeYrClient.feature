@port
Feature: Remove CoCo Client(s) from Your Client view Functionality in Broker Portal
  @SLCR-55 @port
  Scenario: verifying the removal of a single client
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Find a Broker
    Then I Search authorized Broker "Primary Rever"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    And I validate current Broker text exists
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
    And I open the login page on the "broker" portal
    When I login as Broker User "testing.soukaina+teststg@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Dashboard" page
    Then I click on "colorado Connect" tab
    And I search for clients
    Then I click on first client search result
    And I click "remove Client" the client
    Then I click "ok" remove client
    Then I click on "colorado Connect" tab
    And I search for clients
    Then I validate The Client is removed successfully
    Then I click on broker userName and logout

  @SLCR-55 @port
  Scenario: Verifying the removal of a single selected client
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Find a Broker
    Then I Search authorized Broker "Primary Rever"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    And I validate current Broker text exists
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
    And I open the login page on the "broker" portal
    When I login as Broker User "testing.soukaina+teststg@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Dashboard" page
    Then I click on "colorado Connect" tab
    And I search for clients
    Then I select the client searched
    And I select the "Remove Selected Clients" option from the header of the broker container
    Then I click "ok" remove client
    Then I click on "colorado Connect" tab
    And I search for clients
    Then I validate The Client is removed successfully
    Then I click on broker userName and logout

  @SLCR-55 @port
  Scenario: Verifying the removal of multiple clients
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Find a Broker
    Then I Search authorized Broker "Primary Rever"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    And I validate current Broker text exists
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
    And I open the login page on the "broker" portal
    When I login as Broker User "testing.soukaina+teststg@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Dashboard" page
    Then I click on "colorado Connect" tab
    Then I select all clients checkbox
    And I select the "Remove Selected Clients" option from the header of the broker container
    Then I click "ok" remove client
    Then I click on "colorado Connect" tab
    And I search for clients
    Then I click on broker userName and logout
    Then I open the login page on the "login" portal
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Find a Broker
    Then I Search authorized Broker "Primary Rever"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    And I validate current Broker text exists
    And I click on Sign Out in the Header for "Elmo"
