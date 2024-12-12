Feature: My profile page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-258 @NVOExchRegression
  Scenario: Spanish Change Password Navigation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I change the language from header to "Spanish"
    And I click on Make Changes Button
    And I wait for 10000 milliseconds
    Then I verify Password text on My profile page "Spanish"
    And I wait for 10000 milliseconds
    And I click the Change Password Button
    Then I validate I am on the "Forgot my password" page

  @SLER-231 @NVOExchRegression
  Scenario: English Change Password Navigation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    And I wait for 10000 milliseconds
    Then I verify Password text on My profile page "English"
    And I wait for 10000 milliseconds
    And I click the Change Password Button
    Then I validate I am on the "Forgot my password" page