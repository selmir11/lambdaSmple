@helpDrawer
Feature: Tests related to the help drawer

  @SLCR-27 @n1
  Scenario: Validate the english and spanish verbiage on the help drawer
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on help icon
    Then I validate the default verbiage on help icon
    And I click on help icon "Spanish"
    Then I validate the default verbiage on help icon in "Spanish"

  @SLCR-27
  Scenario: Validate the english and spanish verbiage on the help drawer button
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on help icon button
    Then I validate the default verbiage on help icon
    And I click on help icon button "Spanish"
   Then I validate the default verbiage on help icon in "Spanish"

  @SLCR-27
  Scenario: Validate the default verbiage on the help drawer in Admin Portal
    Given I open the login page on the "admin" portal
    When I login as Admin User
    And I validate I am on the "Admin dashboard" page
    Then I click create account on admin portal
    And I click on help icon
    Then I validate the default verbiage on help icon
    And I click on help icon "Spanish"
    And I validate the default verbiage on help icon in "Spanish"
    Then logout from Admin Portal

  Scenario: Validate the default verbiage on the help drawer button in Admin Portal
    Given I open the login page on the "admin" portal
    When I login as Admin User
    And I validate I am on the "Admin dashboard" page
    Then I click create account on admin portal
    And I click on help icon button
    Then I validate the default verbiage on help icon
    And I click on help icon button "Spanish"
    Then I validate the default verbiage on help icon in "Spanish"
    Then logout from Admin Portal