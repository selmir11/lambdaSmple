@ForgotUsernamePassword
Feature: Create, reset password for Individual accounts
  
  @SLER-293
  Scenario: test Forgot password page and text
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create forgot "password"
    Then I validate the Forgot my password page title in "English"
    Then I verify enter your password text is displayed in "English"
    And I click submit button
    Then I verify error username required text is displayed in "English"
    And I enter valid email "soukainatesting+am001@gmail.com"
    And I click submit button
    Then I verify notice is sent to the client text in "English"

  @SLER-293
  Scenario: test Forgot password page and text in Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create forgot "password"
    And I change the language from header to "Spanish"
    Then I validate the Forgot my password page title in "Spanish"
    Then I verify enter your password text is displayed in "Spanish"
    And I click submit button
    Then I verify error username required text is displayed in "Spanish"
    And I enter valid email "soukainatesting+am001@gmail.com"
    And I click submit button
    Then I verify notice is sent to the client text in "Spanish"