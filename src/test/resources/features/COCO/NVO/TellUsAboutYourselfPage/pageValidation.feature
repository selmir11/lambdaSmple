Feature: Validation - Tell us about yourself page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-82 @NVOCoCoRegression
  Scenario: Validation on the Tell us about yourself page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I validate errors are displaying on Tell Us About Yourself Page CoCo "English"