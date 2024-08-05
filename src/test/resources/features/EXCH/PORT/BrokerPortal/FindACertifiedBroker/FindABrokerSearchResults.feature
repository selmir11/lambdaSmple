@FindACertifiedBroker @port
Feature: Tests broker search results on the anonymous Find a Certified Broker page

  @SLER-346
  Scenario: Verifies search results are displayed for searches by name
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I Search authorized Broker "Brandt"
    And I click on Search button in find certified broker page
    Then I verify that a total of "2" results displays in "English"

  @SLER-346
  Scenario: Verifies search results are displayed for searches by location and language
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I enter "Denver" into the broker location search box
    Then I enter "English" into the broker language search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error is displayed in "English"

  @SLER-346
  Scenario: Verifies search results are displayed for searches with all options
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I enter "Denver" into the broker location search box
    Then I Search authorized Broker "Solomon"
    Then I enter "English" into the broker language search box
    And I click on Search button in find certified broker page
    Then I verify that a total of "1" results displays in "English"
