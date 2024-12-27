@PortLUGY
Feature: Navigation to Create account page LUGY off flow

  @SLER-1907 @PortLUGY
  Scenario: Navigation to Create account page LUGY off flow
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click on Help me understand what I qualify for button
    And I validate I am on the "LUGY" page
    Then I select Tell us about your household "None of these applies" option in Let us guide you Page
    Then I select continue on Let us guide you Page
    And I validate I am on the "LUGY Family Details" page
    And I select the number of "3" people are in your household
    Then I select "No" is anyone in your household age 19 or under
    Then I select "No" is there pregnant in your household
    And I select continue on Let us guide you Page
    And I validate I am on the "LUGY Family Income" page
    Then I select "60000" income and "Annually" option in let us guide you page
    And I select continue on Let us guide you Page
    And I validate I am on the "LUGY Prescreener Result" page
    Then I click Apply for Financial Help in Let us guide you Page
    Then I validate I am on the "Create Account" page

