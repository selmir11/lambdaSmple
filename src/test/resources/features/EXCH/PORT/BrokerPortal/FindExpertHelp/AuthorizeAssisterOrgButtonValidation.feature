@FindExpertHelp @port
Feature: Tests the Authorize Assister Organization button on the Find expert help/Manage who helps you page

  @SLER-737
  Scenario: Verifies the Authorize Assister Organization button on the Find expert help/Manage who helps page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I verify Find Expert Help header Text in "English"
    Then I verify Find Expert Help page "Exch" title Text in "English"
    Then I verify Find Expert Help buttons in "English"

    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page

    Then I validate I am on the "Find Expert Help Exch" page
    Then I verify Manage who helps you header text in "English"
    Then I validate the Authorize Assister Organization button "is not displayed"
    Then I validate the Change Assister button "is displayed"

    Then I Remove my current Assister
    And I "Ok" my decision to remove my current assister
    Then I validate the Authorize Assister Organization button "is displayed"
