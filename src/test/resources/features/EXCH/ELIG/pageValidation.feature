Feature: Verify all Chat Widget on ELIG pages

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-104 @PageValidation
  Scenario: Verify Chat Widget on the Account Overview page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I validate chat widget is present
    And I open on chat widget
    Then I minimize the chat window

  @SLER-105 @PageValidation
  Scenario: Verify Chat Widget on the Let Us Guide You page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    Then I validate chat widget is present
    And I open on chat widget
    Then I minimize the chat window