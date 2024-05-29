Feature: Validation - Tell us about yourself page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-82
  Scenario: Validation on the Tell us about yourself page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    And I click Primary EditUpdate on the Family Overview page