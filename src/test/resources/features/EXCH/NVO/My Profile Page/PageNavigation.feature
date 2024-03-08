Feature: My profile page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-51 @WIP
  Scenario: My Profile Page Navigation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on My Profile Button Exch
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile Exch
    Then I validate I am on the "My Account Overview" page
    And  I click on My Account in the "NonElmo" Header
    Then I validate I am on the "My Profile" page