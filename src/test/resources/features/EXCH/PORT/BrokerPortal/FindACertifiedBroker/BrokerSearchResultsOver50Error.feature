@FindACertifiedBroker @port
Feature: Tests the over 50 search results error on the anonymous Find a Certified Broker page

  @SLER-340
  Scenario: Over 50 search results error is not displayed in English
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I enter "80203" into the broker location search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error does not display
    Then I enter "English" into the broker language search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error does not display

  @SLER-340
  Scenario: Over 50 search results error is displayed in English
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I enter "denver" into the broker location search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error is displayed in "English"
    Then I enter "English" into the broker language search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error is displayed in "English"

  @SLER-340
  Scenario: Over 50 search results error is displayed in Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    And I change the language from header to "Spanish"
    Then I enter "denver" into the broker location search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error is displayed in "Spanish"
    Then I clear the broker location search box
    Then I enter "Spanish" into the broker language search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error is displayed in "Spanish"