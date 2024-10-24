@portCOCO @FindExpertHelpCoCo
Feature: Manage who helps you page validation

  @SLCR-367
  Scenario: Manage who helps you page validation
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header

    Then I validate I am on the "FindExpertHelpCoco" page
    Then I verify Find Expert Help header Text in "English"
    Then I validate the Find a Broker button "is" displayed

    Then I verify Find Expert Help page "CoCo" title Text in "English"
    Then I verify Find Expert Help page Text in "English"
    Then I verify Find Expert Help buttons in "English"

    And I click on Find a Broker
    Then I Search authorized Broker "Margie Kellogg"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Margie Kellogg", "AAA Best Agency", "159753456", "80205", "303-123-7895", "BROKER", "Active"
    Then I validate the Change Broker button "is" displayed

    Then I verify Manage who helps you header text in "English"

    Then I Remove my current Broker
    And I verify the remove broker text in "English"
    And I "Cancel" my decision to remove my current broker

    And I validate my broker details in the current broker table are "Margie Kellogg", "AAA Best Agency", "159753456", "80205", "303-123-7895", "BROKER", "Active"

    Then I Remove my current Broker
    And I verify the remove broker text in "English"
    And I "Ok" my decision to remove my current broker
    And I validate no broker is authorized

    Then I verify Find Expert Help header Text in "English"
    Then I validate the Find a Broker button "is" displayed

    And I click on Sign Out in the Header for "Elmo"