@FindACertifiedBroker @port
Feature: Tests broker search details on the anonymous Find a Certified Broker page in Spanish

  @SLER-486
  Scenario: Validating broker results details
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    And I validate the have a "Exch" broker call you text in "English"
    And I change the language from header to "Spanish"
    Then I validate the Find a Certified Broker near you page title in "Spanish"
    And I validate the have a "Exch" broker call you text in "Spanish"
    Then I Search authorized Broker "Noah Trujillo"
    And I click on Search button in find certified broker page
    Then I verify that a total of "1" results displays in "Spanish"
    Then I validate broker name is "Noah Trujillo"
    Then I validate agency name is "Arrow Head Agency"
    Then I validate agency address is "1234 Road, 1234 Road"
    Then I validate agency city state and zip is "Denver, CO 80205"
    And I click more details from the first broker result container
    Then I validate the agency details field labels in "Spanish"
    Then I validate the agency details "ArrowHeadAgency@agency.com", "720-789-6532", "Lunes", "07:00 AM to 05:00 PM", "983624175862", "Inglés"
    And I click hide details
    Then I validate broker name is "Noah Trujillo"
    Then I validate agency name is "Arrow Head Agency"
    Then I validate agency address is "1234 Road, 1234 Road"
    Then I validate agency city state and zip is "Denver, CO 80205"
    And I validate the agency details are hidden