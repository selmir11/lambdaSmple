@LoginPortalLogin @PORT
Feature: Validate the automatically logged out text in login page
  
@SLER-2467
  Scenario: Validate the automatically logged out text in login page
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I wait for 10000 milliseconds
    And I validate timeout session popup without taking any actions
    And I wait for 20000 milliseconds
    Then I validate the automatically signed out message appear in "English"
    And I change the language from header to "Spanish"
    And I wait for 200 milliseconds
    Then I validate the automatically signed out message appear in "Spanish"