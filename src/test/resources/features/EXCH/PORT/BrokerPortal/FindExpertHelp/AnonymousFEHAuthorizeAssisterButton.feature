@port @FindExpertHelp
Feature: Tests the Authorize Assister Organization button is absent on the anonymous Find expert help page

  @SLER-313
  Scenario: Anonymous Find expert help page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page
    Then I verify Find Expert Help header Text in "English"
    Then I verify Find Expert Help page Text in "English"
    Then I validate the Have a Broker call you button is displayed
    Then I validate the Find a Broker button "is" displayed
    Then I validate the Find an Assister button is displayed
    Then I validate the Authorize Assister Organization button "is not displayed"