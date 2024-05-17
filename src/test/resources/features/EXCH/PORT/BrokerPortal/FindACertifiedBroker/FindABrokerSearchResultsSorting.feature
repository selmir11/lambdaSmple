@FindACertifiedBroker @port
Feature: Tests broker search result sorting on the anonymous Find a Certified Broker page

  @SLER-350
  Scenario: Sorting search results
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Login Portal" Header
    And I click on Find Expert Assistance in the "Login Portal" Header
    And I click on Find a Broker
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
