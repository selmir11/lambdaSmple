Feature: My profile page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-51
  Scenario: My Profile Page Navigation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile Exch
    Then I validate I am on the "My Account Overview" page
    And I click on the Username in the "Exch" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    And I click on Save Button
    And  I validate chat widget is present
