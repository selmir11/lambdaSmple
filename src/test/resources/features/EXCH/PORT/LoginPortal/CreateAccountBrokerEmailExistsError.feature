@CreateAccount @port @LoginPortal
Feature: Verify the broker account already exists error message on the Create your Account page

  @SLER-694
  Scenario: Create a new broker account on the Create your Account page
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I enter mandatory data for "Agency Owner" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page
    And I log into my "Agency Owner" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click on broker userName and logout

  @SLER-694
  Scenario: Validate the broker account exists error message in English on the Create your Account page
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    And I enter duplicate data for Agency Owner account creation
    Then I validate the We're unable to proceed with this email error message in "English"

  @SLER-694
  Scenario: Validate the broker account exists error message in Spanish on the Create your Account page
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    And I change the language from header to "Spanish"
    And I enter duplicate data for Agency Owner account creation
    Then I validate the We're unable to proceed with this email error message in "Spanish"