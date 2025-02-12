@FindExpertHelp @port
Feature: Verifying the remove broker confirmation text in English and Spanish

  @SLER-1139
  Scenario: : Individual account creation and household ID verification in the database
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
    Then I Search authorized Broker "AAA Best Agency"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    Then I verify Manage who helps you header text in "English"

    Then I Remove my current Broker
    And I verify the remove broker text in "English"
    And I "Cancel" my decision to remove my current broker

    And I change the language from header to "Spanish"
    Then I Remove my current Broker
    And I verify the remove broker text in "Spanish"
    And I "Cancel" my decision to remove my current broker

    And I change the language from header to "English"
    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker

    Then I verify Find Expert Help header Text in "English"

    And I click on Sign Out in the Header for "Elmo"