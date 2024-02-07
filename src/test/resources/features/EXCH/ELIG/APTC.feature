@APTC
Feature: UI Tests related to APTC

  Background: I go the login portal
    Given I open the login page on the login portal

  @SLER-21
  Scenario: ELIG-Single Member Denver-APTC Calculator
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for 2024
    Then I select No Thanks option from guide you section
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Find Expert Help page
    And I enter details on tell us about yourself page and continue
    Then I enter Additional details and click continue on add address page
    And I enter citizenship details and click continue
    Then I click continue on family overview page
    And I Apply for financial help
    Then I enter employment details with "3700000" annual income
    Then I click continue on the Employment Summary Page
    Then I click "None of these" as additional income option and continue
    Then I click "None of these" as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then Then I select "None of these" as health insurance option and continue
    Then I click continue on family overview page
    # Then I select "Birth" QLCE on tell us about life changes page
    # And I Declare and sign
    # Then I validate that my APTC value is "$327.63/mo"