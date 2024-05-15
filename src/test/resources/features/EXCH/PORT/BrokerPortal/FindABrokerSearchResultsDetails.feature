@FindACertifiedBroker @port
Feature: Tests broker search details on the anonymous Find a Certified Broker page

  @SLER-377
  Scenario: Validating broker results details
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Login Portal" Header
    And I click on Find Expert Assistance in the "Login Portal" Header
    And I click on Find a Broker
    Then I validate the Find a Certified Broker near you page title in "English"
    Then I Search authorized Broker "Noah Trujillo"
    And I click on Search button
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