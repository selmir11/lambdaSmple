@BrokerPortalClients @port
Feature: Client Broker authorization and deauthorization status

  @SLER-1155
  Scenario: : Exchange individual account creation and broker authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I validate I am on the "Find Expert Help Exch" page
    And I click on Find a Broker
    Then I Search authorized Broker "Preston Saunders"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Preston Saunders", "Bright Sky Agency", "88564585", "80205", "303-898-6427", "BROKER", "Active"
    And I click on Sign Out in the Header for "Elmo"

  #Associated broker verifying client authorization
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+PrestonSaunders@outlook.com" password "ALaska12!" and "C4PortTesting+PSaundersQA@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Broker Dashboard" page
    Then I validate the Your Clients page title
    And I search for clients
    And I click on first client search result
    And I verify my client's name is displayed
    Then I verify that my client's current status is "NO ELIGIBILITY"
    Then I click on broker userName and logout

  #Exchange individual revoking broker authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I validate I am on the "Find Expert Help Exch" page
    Then I verify Manage who helps you header text in "English"
    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    Then I verify Find Expert Help header Text in "English"
    And I validate the Previous Broker Assister text
    Then I validate the details in the Previous Broker Assister table are "Preston Saunders", "88564585", "80205", "303-898-6427", "Broker"
    And I click on Sign Out in the Header for "Elmo"

  #Associated broker verifying the client no longer displays in the client list
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+PrestonSaunders@outlook.com" password "ALaska12!" and "C4PortTesting+PSaundersQA@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Broker Dashboard" page
    Then I validate the Your Clients page title
    And I search for clients
    Then I validate The Client is removed successfully
    Then I click on broker userName and logout
