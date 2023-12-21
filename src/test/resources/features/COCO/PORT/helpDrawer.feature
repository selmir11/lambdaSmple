@helpDrawer
Feature: Tests related to the help drawer

  Background: I go the login portal
    Given I open the login page on the login portal

  @n1 @CCRT-14
    # provide proper tag here instead of CCRT-14. Give new test case num.
  Scenario: Validate the default verbiage on the help drawer
    When I click create a new account on login page
    Then I validate I am on the pre-screen page
    And I click create my account from pre-screen page
    Then I validate I am on the createAccount page
    And I click on help icon
   # And I validate the help drawer is open
    Then I validate the default verbiage on help icon
