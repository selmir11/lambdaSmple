@TAM @TamCoCo @PageTextCacScreenerPage
Feature: Page Text-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credential STG username "MGC4Test+apindayejkkzapeliz@gmail.com" PW "ALaska13!" QA username "qatestusercoco@test.com" PW "ALaska13!" for individual user without sign in any env
    When I click on sign in on login page
    Then I validate I am on the "CAC Screener" page

  @SLCR-346 @PageTextCacScreenerPage
  Scenario: SLCR-346 I can see my enrollment options Spanish
    And I change the language from header to "Spanish"
    And I validate the "Main" text for CAC Screener page in "Spanish"

    Then I click on "Yes" option for "under 19" on CAC Screener page
    Then I click on "Yes" option for "pregnant" on CAC Screener page
    Then I click on "Yes" option for "DACA" on CAC Screener page
#    Then I click on "Yes" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page
    And I validate CAC Screener questions are "Disabled" in "Spanish"
    And I validate the "HealthFirst" text for CAC Screener page in "Spanish"
    And I validate the "C4HCO" text for CAC Screener page in "Spanish"
#    And I validate the "SES Renewal" text for CAC Screener page in "Spanish"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CAC Screener" page
    And I change the language from header to "Spanish"
    Then I click on "No" option for "under 19" on CAC Screener page
    Then I click on "No" option for "pregnant" on CAC Screener page
    Then I click on "No" option for "DACA" on CAC Screener page
#    Then I click on "No" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page
#    And I validate the "SES New" text for CAC Screener page in "Spanish"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-347 @PageTextCacScreenerPage
  Scenario: SLCR-347 I can see my enrollment options English
    And I validate the "Main" text for CAC Screener page in "English"

    Then I click on "Yes" option for "under 19" on CAC Screener page
    Then I click on "Yes" option for "pregnant" on CAC Screener page
    Then I click on "Yes" option for "DACA" on CAC Screener page
#    Then I click on "Yes" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page
    And I validate CAC Screener questions are "Disabled" in "English"
    And I validate the "HealthFirst" text for CAC Screener page in "English"
    And I validate the "C4HCO" text for CAC Screener page in "English"
#    And I validate the "SES Renewal" text for CAC Screener page in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CAC Screener" page
    Then I click on "No" option for "under 19" on CAC Screener page
    Then I click on "No" option for "pregnant" on CAC Screener page
    Then I click on "No" option for "DACA" on CAC Screener page
#    Then I click on "No" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page
#    And I validate the "SES New" text for CAC Screener page in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page



