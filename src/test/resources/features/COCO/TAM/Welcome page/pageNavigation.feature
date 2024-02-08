Feature: SLCR-28: TAM-Page Navigation-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  Scenario: Create CoCo Account and Login
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the welcome page
    And I apply for 2024 CoCo
    Then I click the back button from Find Expert Help page
    Then I click on My Profile Button CoCo
    Then I click on Go back to Welcome page Button on My Profile CoCo
   