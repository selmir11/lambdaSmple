Feature: Navigation - Family Overview page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-47 @PageNavigationFamilyOverview
  Scenario: Navigation on the Tell us about yourself page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click Primary EditUpdate on the Family Overview page
    And I click Go Back on the tell us about yourself page
    Then I validate I am on the "CoCo Family Overview" page
    And I verify button text Manage who helps you in "English"
    Then I click Manage who helps you on the Family Overview page
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    And I change the language from header to "Spanish"
    And I verify button text Manage who helps you in "Spanish"
    Then I click Manage who helps you on the Family Overview page
    Then I validate I am on the "Find Expert Help" page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

