@PortLUGY
Feature: As a LUGY user on the results page, I must see updated results if I'm over 400% FPL so I'm navigated to the correct place to start my application.

   @PortLUGY @SLER-1908
  Scenario: LUGY update income and navigation flow
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click on Help me understand what I qualify for button
    And I validate I am on the "LUGY" page
    Then I select Tell us about your household "None of these applies" option in Let us guide you Page
    Then I select continue on Let us guide you Page
    And I validate I am on the "LUGY Family Details" page
    And I select the number of "4" people are in your household
    Then I select "Yes" is anyone in your household age 19 or under
    Then I select "No" is there pregnant in your household
    And I select continue on Let us guide you Page
    And I validate I am on the "LUGY Family Income" page
    Then I select "90000" income and "Annually" option in let us guide you page
    And I select continue on Let us guide you Page
    And I validate I am on the "LUGY Prescreener Result" page
    Then I validate Apply for Financial Help is displayed in Let us guide you Page
    And I click Go Back button from chrome browser
    And I validate I am on the "LUGY Family Income" page
    Then I select "150000" income and "Annually" option in let us guide you page
    And I select continue on Let us guide you Page
    And I validate I am on the "LUGY Prescreener Result" page
    Then I validate Apply for Financial Help is displayed in Let us guide you Page