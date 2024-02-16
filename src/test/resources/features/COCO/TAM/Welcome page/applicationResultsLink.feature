@applicationResultsLink
Feature: Tests related to the Application Results link

  Background: I go to the login portal
    Given I open the login page on the "login" portal

    @SLCR-25-WIP
  Scenario: Validate Action links navigation and text with no applications in English
      When I click create a new account on login page
      Then I validate I am on the "Prescreen" page
      And I click create my account from pre-screen page
      Then I validate I am on the "Create Account" page
      And I enter general mandatory data for "coco" account creation
      Then I validate I am on the "Login" page
      And  I enter valid credentials to login
      Then I validate I am on the "CoCo Welcome" page
      And I click on "Application Results" link on welcome page
      Then I validate I am on the "Application Results" page
      And I click on Go back to Welcome page Button on Application Results page CoCo
      Then I validate I am on the "CoCo Welcome" page
      And I click on "My Documents and Letters" link on welcome page
      Then I validate I am on the "My Documents" page
      And I click on Apply for Coverage in the Header
      Then I validate I am on the "CoCo Welcome" page
      Then I validate "Application Results" link text on welcome page
      Then I validate "My Documents and Letters" link text on welcome page