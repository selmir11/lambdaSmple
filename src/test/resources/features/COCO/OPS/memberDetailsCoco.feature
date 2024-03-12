# memberDetails
# Tags: ops

Feature: Member Profile details

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-28 @PageNavigationWelcomePage
  Scenario Outline: Create CoCo Account and Login
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for <appType> account creation
    Then I validate I am on the <page> page
    And I enter valid credentials to login
    Then I validate I am on the <page1> page
    And I apply for 2024 CoCo
    Then I validate I am on the <page2> page
    Then I click the back button from Find Expert Help page
    Then I validate I am on the <page1> page
    Then I click on My Profile Button CoCo
    Then I validate I am on the <page3> page
    Then I click on "makeChangesButton" CoCo
    Examples:
      | appType | page    | page1          | page2              | page3        |
      | "coco"  | "Login" | "CoCo Welcome" | "Find Expert Help" | "My Profile" |
    #And I open the login page on the "Admin" portal
   # "refreshPage" page