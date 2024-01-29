@helpDrawer
Feature: Tests related to the help drawer

  Background: I go the login portal
    Given I open the login page on the login portal

    # intermittent failures are noticed because of faster execution. Run the scenario multiple times to make sure
  Scenario: Validate the default verbiage on the help drawer
    When I click create a new account on login page
    Then I validate I am on the pre-screen page
    And I click create my account from pre-screen page
    Then I validate I am on the createAccount page
    And I click on help icon
    Then I validate the default verbiage on help icon
    And I click on help icon "Spanish"
    Then I validate the default verbiage on help icon in "Spanish"

  Scenario: Validate the default verbiage on the help drawer button
    When I click create a new account on login page
    Then I validate I am on the pre-screen page
    And I click create my account from pre-screen page
    Then I validate I am on the createAccount page
    And I click on help icon button
    Then I validate the default verbiage on help icon
    #please check line 25 keep loading
    And I click on help icon button "Spanish"
  # Then I validate the default verbiage on help icon in "Spanish"