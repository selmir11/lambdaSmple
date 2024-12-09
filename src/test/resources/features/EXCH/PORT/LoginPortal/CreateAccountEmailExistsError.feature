@CreateAccount @port @LoginPortal
Feature: Verify the account already exists error message on the Create your Account page

  @SLER-500
  Scenario: Create a new individual account on the Create your Account page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

  @SLER-500
  Scenario: Validate the account exists error message in English on the Create your Account page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter duplicate data for account creation
    Then I validate the We're unable to proceed with this email error message in "English"

  @SLER-500
  Scenario: Validate the account exists error message in Spanish on the Create your Account page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I change the language from header to "Spanish Login"
    And I enter duplicate data for account creation
    Then I validate the We're unable to proceed with this email error message in "Spanish"