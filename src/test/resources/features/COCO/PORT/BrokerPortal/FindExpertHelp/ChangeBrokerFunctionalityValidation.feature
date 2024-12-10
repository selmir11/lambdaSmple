@portCOCO @FindExpertHelpCoCo
Feature: Change broker functionality and previous broker/assister table validation

  @SLCR-390
  Scenario: Change broker functionality and previous broker/assister table validation
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

    Then I verify Find Expert Help header Text in "English"
    Then I verify Find Expert Help page "CoCo" title Text in "English"

    And I click on Find a Broker
    Then I Search authorized Broker "Solomon Brandt"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Solomon Brandt", "Brandt Agency", "95185264", "80205", "720-405-4901", "BROKER", "Active"

    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    Then I validate the details in the Previous Broker Assister table are "Solomon Brandt", "95185264", "80205", "720-405-4901", "Broker"
    Then I validate the Change Broker button "is not" displayed

    And I click on Find a Broker
    Then I Search authorized Broker "Solomon Brandt"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Solomon Brandt", "Brandt Agency", "95185264", "80205", "720-405-4901", "BROKER", "Active"

    And I validate the Previous Broker Assister table is not displayed

    Then I validate the Change Broker button "is" displayed
    Then I click on change the existing broker

    Then I Search authorized Broker "Brandt Agency"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click the Authorize broker button
    And I validate the text to authorize a new broker "Del Mercer" with "Brandt Agency" or keep the same broker "Solomon Brandt" with "Brandt Agency" in "English" for "CoCo"

    Then I click on "Keep Current Broker" in the warning container to authorize new or keep the same broker
    Then I click Go Back on the Find a Certified Broker page

    Then I verify Manage who helps you header text in "English"
    And I validate my broker details in the current broker table are "Solomon Brandt", "Brandt Agency", "95185264", "80205", "720-405-4901", "BROKER", "Active"

    Then I click on change the existing broker
    Then I Search authorized Broker "Brandt Agency"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click the Authorize broker button
    Then I click on "Authorize New Broker" in the warning container to authorize new or keep the same broker

    Then I verify Manage who helps you header text in "English"
    And I validate my broker details in the current broker table are "Del Mercer", "Brandt Agency", "4682357", "80205", "719-563-6254", "BROKER", "Active"

    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    Then I verify Find Expert Help header Text in "English"

    And I validate the Previous Broker Assister text
    And I validate the Previous Broker Assister table header labels
    Then I verify the previous brokers and assisters are listed in alphabetical order