@SLCR-38 @portCOCO
Feature: Find expert help page validation

  @SLCR-38
  Scenario: Find expert help page validation
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
    And I verify Find Expert Help header Text in "English"
    And I verify Find Expert Help page "CoCo" title Text in "English"
    Then I verify Find Expert Help page Text in "English"
    Then I verify Find Expert Help buttons in "English"
    And I change the language from header to "Spanish"
    And I verify Find Expert Help header Text in "Spanish"
    And I verify Find Expert Help page "CoCo" title Text in "Spanish"
    Then I verify Find Expert Help page Text in "Spanish"
    Then I verify Find Expert Help buttons in "Spanish"

