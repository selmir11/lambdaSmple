@applicationResultsLink
Feature: Tests related to the Application Results link

  Background: I go to the login portal
    Given I open the login page on the "login" portal

    @SLCR-25-WIP
  Scenario: Validate Application Results link text
      When I click create a new account on login page
      Then I validate I am on the pre-screen page
      And I click create my account from pre-screen page
      Then I validate I am on the createAccount page
      And I enter general mandatory data for "coco" account creation
      Then I validate I am on the login page
      And  I enter valid credentials to login
      Then I validate I am on the welcome page