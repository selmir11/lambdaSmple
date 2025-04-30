@port @LoginPortalAnonymousHeader
Feature: Tests Find expert help navigation from Login Portal pages

  @SLER-309
  Scenario: Individual Create your Account page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page

  @SLER-309
  Scenario: Forgot my password page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create forgot "password"
    And I validate I am on the "forgotPassword" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page

  @SLER-309
  Scenario: Forgot Username page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create forgot "username"
    And I validate I am on the "forgotUsername" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page

  @SLER-309
  Scenario: Broker Create your Account page
    Given I open the login page on the "broker" portal
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page

  @SLER-309
  Scenario: Program manager Create your Account page
    Given I open the login page on the "assistNet" portal
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page