@helpDrawer
Feature: Tests related to the help drawer on ELMO pages

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-42-WIP
  Scenario: Open and display help drawer on the ELMO Income page (non self-employment view) when the primary help text icon is selected
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
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment