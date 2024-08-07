Feature: My Profile Page Exch

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLER-792
  Scenario: My Profile Page Navigation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    Then I verify Password Popup text on My profile page Exch "English"
    And I change the language from header to "Spanish"
    Then I verify Password Popup text on My profile page Exch "Spanish"