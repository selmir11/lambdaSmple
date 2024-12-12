Feature: My Profile Page Exch

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLER-997  @NVOExchRegression
  Scenario: Timeout Session popup on my profile page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I validate timeout session popup "English" on My Profile page
    And I wait for 10000 milliseconds
    And I change the language from header to "Spanish"
    And I wait for 10000 milliseconds
    And I validate timeout session popup "Spanish" on My Profile page

    #And I change the language from header to "English"
   # Then I validate I am on the "Login" page