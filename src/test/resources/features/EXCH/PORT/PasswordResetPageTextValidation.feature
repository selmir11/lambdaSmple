@SLER-293
Feature:Create, reset password for Individual and broker accounts
  
  @SLER-293
  Scenario: test Forgot password page and text
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create forgot "password"
    Then I verify enter your password text is displayed
    And I click submit button
    Then I verify error username required text is displayed
    And I enter valid email "soukainatesting+am001@gmail.com"
    And I click submit button
    Then I verify notice is sent to the client text

