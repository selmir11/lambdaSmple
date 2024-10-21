@BrokerPortalDashboard @port @Dashboard
Feature: Verifying the current broker assignment in Client Information

  @SLER-1159
  Scenario: : Individual account creation and broker authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page

    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    And I click on Find a Broker
    Then I Search authorized Broker "Harrison Andersen"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    Then I verify Manage who helps you header text in "English"

    And I validate my broker details in the current broker table are "Harrison Andersen", "Harrison Andersen Agency", "28548247", "80205", "303-931-7516", "BROKER", "Active"

    And I click on Sign Out in the Header for "WhoHelpsYouPage"

  #Agency owner verifies the current broker assignment for the client
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "HarrisonAndersen@test.com" password "ALaska13!" and "HarrisonAndersen@testQA.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I click Agency Dashboard

    And I search Client Information for my client
    Then I verify my client's name is displayed in Client Information
    Then I verify the currently assigned broker is "Harrison Andersen"

    Then I click on broker userName and logout