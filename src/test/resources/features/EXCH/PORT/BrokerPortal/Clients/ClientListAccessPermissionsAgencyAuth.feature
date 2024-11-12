@BrokerPortalClients @port
Feature: Agency client list access permissions following agency owner authorization

  @SLER-1260
  Scenario: : Individual account creation and Agency owner authorization
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
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Maggie Walker", "Bright Sky Agency", "8895237", "80205", "303-898-6426", "BROKER", "Active"
    And I click on Sign Out in the Header for "WhoHelpsYouPage"

  Scenario: : Agency owner verifying access to the client list
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

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title
    And I search for clients
    And I click on first client search result
    And I verify my client's name is displayed
    Then I verify that my client's current status is "NO ELIGIBILITY"
    Then I click on broker userName and logout

  Scenario: : Broker verifying access to the client list
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

  Scenario: : Admin staff verifying access to the client list
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+MPhillipsSTG@outlook.com" password "ALaska12!" and "C4PortTesting+MPhillips@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I click View Your Clients button

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title
    And I search for clients
    And I click on first client search result
    And I verify my client's name is displayed
    Then I verify that my client's current status is "NO ELIGIBILITY"
    Then I click on broker userName and logout