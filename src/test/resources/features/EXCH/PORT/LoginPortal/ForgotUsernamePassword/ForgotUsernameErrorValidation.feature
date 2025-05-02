@ForgotUsernamePassword
Feature: Errors on Forgot Username in General Login Portal

  @SLER-750
  Scenario: Errors on Forgot Username in General Login Portal in English
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "username"
    And I validate I am on the "forgotUsername" page
    Then I click submit on forgot username Page
    And I verify the error msg in "English"
    Then I enter information's for Forgot username in STG Firsname "$" LastName "$" phone "1" accountType "Customer" or QA Firsname "#" LastName "#" phone "9"
    Then I click submit on forgot username Page
    And I verify the error msg in "Special character"

  @SLER-750
  Scenario: Errors on Forgot Username in General Login Portal in Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "username"
    And I validate I am on the "forgotUsername" page
    And I change the language from header to "Spanish"
    Then I click submit on forgot username Page
    And I verify the error msg in "Spanish"
    Then I enter information's for Forgot username in STG Firsname "$" LastName "$" phone "1" accountType "Customer" or QA Firsname "#" LastName "#" phone "9"
    Then I click submit on forgot username Page
    And I verify the error msg in "Special character Spanish"


