@SLER-318 @LoginPortalLogin
Feature:RT-2452 - Update Legal Notice language on Individual Login Portal page

    @SLER-2289
  Scenario: validate the error for missing username and password in English
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click on sign in on login page
    And I validate the error msg username and password required in "English"
    Then I change the language from header to "Spanish Login"
    And I validate the error msg username and password required in "Spanish"


