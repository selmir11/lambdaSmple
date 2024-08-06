@FindACertifiedBroker @port
Feature: Tests broker search results pagination on the Find a Certified Broker page

  @SLER-398
  Scenario: Verifies search results pagination on the anonymous Find a Certified Broker page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I enter "Denver" into the broker location search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error is displayed in "English"
    And I click the right pagination arrow button 3 times
    Then I verify the current result page is "5"
    And I click the left pagination arrow button 4 times
    Then I verify the current result page is "1"

  @SLER-398
  Scenario: Verifies search results pagination on the Find a Certified Broker page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    And I click on Find a Broker
    Then I enter "Denver" into the broker location search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error is displayed in "English"
    And I click the right pagination arrow button 3 times
    Then I verify the current result page is "5"
    And I click the left pagination arrow button 4 times
    Then I verify the current result page is "1"