@BrokerPortalDB @port
Feature: Verifying broker reassignment in the database

  @SLER-1158
  Scenario: : Individual account creation and broker reassignment verification in the database
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

    And I click on Sign Out in the Header for "Portal"

    And I verify the broker authorization type in the database is "OWNER"
    And I verify the broker authorization in BoB DB is "Harrison Andersen"

  #Agency owner reassigns a broker to work with the client
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
    Then I click Agency Dashboard

    And I search Client Information for my client
    Then I verify my client's name is displayed in Client Information
    Then I verify the currently assigned broker is "Harrison Andersen"

    Then I change the assigned broker to "Springs Springs"
    And I wait for 2000 milliseconds
    Then I verify the currently assigned broker is "Springs Springs"

    And I verify the broker authorization type in the database is "BROKER"
    And I verify the broker authorization in BoB DB is "Springs Springs"