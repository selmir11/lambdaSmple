Feature: Coco user validations for warning modal when SEP Period Ended

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And I login with "SEP" credentials
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "Application Results" link on welcome page

  @SLCR-692
  Scenario: Validate the warning modal text in English when sep period is closed
    And I click Continue on the Application Results Page CoCo
    Then I validate open enrollment ended pop up in "English-SEP"
    And I click close on open enrollment ended pop up modal
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-696
  Scenario: Validate the warning modal text in Spanish when sep period is closed
    And I change the language from header to "Spanish"
    And I click Continue on the Application Results Page CoCo
    Then I validate open enrollment ended pop up in "Spanish-SEP"
    And I click close on open enrollment ended pop up modal
    And I click on Sign Out in the Header for "Elmo"
