@AssistNet @port
Feature: Authorize Assister Organization page validation

  @SLER-1279
  Scenario: : Authorize Assister Organization page validation
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I validate I am on the "Find Expert Help Exch" page
    And I click the Authorize Assister Organization button
    Then I validate I am on the "Authorize Assister Organization" page

    Then I validate the Authorize Assister Organization page title in "English"
    And I validate the Authorize Assister Organization page informational text in "English"
    And I validate the Authorize Assister Site ID field text in "English"
    And I validate the Authorize button is displayed in "English"
    And I validate the Authorize Assister Organization page Go Back button is displayed in "English"

    Then I change the language from header to "Spanish Login"

    Then I validate the Authorize Assister Organization page title in "Spanish"
    And I validate the Authorize Assister Organization page informational text in "Spanish"
    And I validate the Authorize Assister Site ID field text in "Spanish"
    And I validate the Authorize button is displayed in "Spanish"
    And I validate the Authorize Assister Organization page Go Back button is displayed in "Spanish"