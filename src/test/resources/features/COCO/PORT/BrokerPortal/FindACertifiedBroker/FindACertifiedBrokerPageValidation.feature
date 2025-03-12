@FindACertifiedBroker @port @portCOCO
Feature: Find a Certified Broker page validation

  @SLCR-86
  Scenario: Find a Certified Broker page text and broker details validation
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
    And I click on Find a Broker
    Then I validate the Find a Certified Broker near you page title in "English"
    And I validate the button and field text in "English"
    And I validate the have a "CoCo" broker call you text in "English"

    Then I Search authorized Broker "Noah Trujillo"
    And I click on Search button in find certified broker page
    Then I verify that a total of "1" results displays in "English"
    Then I validate broker name is "Noah Trujillo"
    Then I validate agency name is "Arrow Head Agency"
    Then I validate agency address is "1234 Road, 1234 Road"
    Then I validate agency city state and zip is "Denver, CO 80205"
    And I click more details from the first broker result container
    Then I validate the agency details field labels in "English"
    Then I validate the agency details "ArrowHeadAgency@agency.com", "720-789-6532", "Monday", "07:00 AM to 05:00 PM", "983624175862", "English"
    And I click hide details
    Then I validate broker name is "Noah Trujillo"
    Then I validate agency name is "Arrow Head Agency"
    Then I validate agency address is "1234 Road, 1234 Road"
    Then I validate agency city state and zip is "Denver, CO 80205"
    And I validate the agency details are hidden
    Then I clear the broker search box
    Then I click Go Back on the Find a Certified Broker page
    And I click on Find a Broker
    Then I enter "80203" into the broker location search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error does not display

  @SLCR-86
  Scenario: Find a Certified Broker search results error validation and pagination
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Find a Broker
    Then I validate the Find a Certified Broker near you page title in "English"

    Then I enter "denver" into the broker location search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error is displayed in "English"
    Then I clear the broker location search box
    And I wait for 2000 milliseconds

    And I click the right pagination arrow button 3 times
    Then I verify the current result page is "5"
    And I click the left pagination arrow button 4 times
    Then I verify the current result page is "1"

  @SLCR-86
  Scenario: Find a Certified Broker search results sorting validation
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Find a Broker
    Then I validate the Find a Certified Broker near you page title in "English"

    Then I Search authorized Broker "oneninefiveeight"
    And I click on Search button in find certified broker page
    Then I verify that a total of "2" results displays in "English"
    Then I validate broker name is "rt oneninefiveeightaaa"
    Then I validate agency name is "oneninefiveeightaaa"
    And I sort the results "Z-A"
    Then I verify that a total of "2" results displays in "English"
    Then I validate broker name is "rt oneninefiveeightzzz"
    Then I validate agency name is "oneninefiveeightzzz"
    And I sort the results "A-Z"
    Then I verify that a total of "2" results displays in "English"
    Then I validate broker name is "rt oneninefiveeightaaa"
    Then I validate agency name is "oneninefiveeightaaa"