@FindExpertHelp @port
Feature: Tests the current broker table and Change Broker button on the Manage who helps you page

  @SLER-480
  Scenario: Verifies the current broker table and Change Broker button on the Manage who helps you page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I validate I am on the "Find Expert Help Exch" page
    Then I verify Find Expert Help header Text in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I verify Find Expert Help header Text in "English"
    And I click on Find a Broker
    Then I Search authorized Broker "Kellogg"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    Then I verify Manage who helps you header text in "English"
    And I validate my broker details in the current broker table are "Margie Kellogg", "AAA Best Agency", "159753456", "80205", "303-123-7895", "BROKER", "Active"
    Then I validate the Change Broker button "is" displayed