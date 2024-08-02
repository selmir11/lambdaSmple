@CreateAccount @port
Feature: Verify the error messages on the Create Account page

  @SLER-538
  Scenario: Verify the field error messages on the Create Account page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    Then I validate the mandatory field error messages in "English"
    Then I validate the mandatory options error messages in "English"
    Then I validate the fields cannot contain special characters error message in "English"
    Then I validate that letters are not allowed in the phone field
    Then I validate the password must contain at least 8 characters error message in "English"
    Then I validate the password must contain 1 uppercase character error message in "English"
    Then I validate the password must contain 1 lowercase character error message in "English"
    Then I validate the password must contain 1 number error message in "English"
    Then I validate the password cannot contain part of the username error message in "English"
    Then I validate the password cannot contain the first name error message in "English"

  @SLER-538
  Scenario: Verify the field error messages on the Create Account page in Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I change the language from header to "Spanish"
    Then I validate the mandatory field error messages in "Spanish"
    Then I validate the mandatory options error messages in "Spanish"
    Then I validate the fields cannot contain special characters error message in "Spanish"
    Then I validate that letters are not allowed in the phone field
    Then I validate the password must contain at least 8 characters error message in "Spanish"
    Then I validate the password must contain 1 uppercase character error message in "Spanish"
    Then I validate the password must contain 1 lowercase character error message in "Spanish"
    Then I validate the password must contain 1 number error message in "Spanish"
    Then I validate the password cannot contain part of the username error message in "Spanish"
    Then I validate the password cannot contain the first name error message in "Spanish"