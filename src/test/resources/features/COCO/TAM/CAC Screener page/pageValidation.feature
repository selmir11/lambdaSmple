@TAM @TamCoCo @PageValidationCacScreenerPage
Feature: Page Text-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CAC Screener" page

  @SLCR-340 @PageValidationCacScreenerPage @TAMSmokeCoCo
  Scenario: SLCR-340 I want to see an updated page and dynamic behavior when quiz results are displayed English
    Then I click on "Yes" option for "under 19" on CAC Screener page
    Then I click on "Yes" option for "pregnant" on CAC Screener page
    Then I click on "Yes" option for "DACA" on CAC Screener page
#    Then I click on "Yes" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page
    And I validate results option for "header" on CAC Screener page displays in "English"
    And I validate results option for "HealthFirst" on CAC Screener page displays in "English"
    And I validate results option for "C4HCO" on CAC Screener page displays in "English"
#    And I validate results option for "SES Renewal" on CAC Screener page displays in "English"
    And I validate CAC Screener questions are "Disabled" in "English"
    Then I click Retake quiz button on the CAC Screener page
    And I validate CAC Screener questions are "Enabled" in "English"
    Then I click on "No" option for "under 19" on CAC Screener page
    Then I click on "No" option for "pregnant" on CAC Screener page
    Then I click on "Yes" option for "DACA" on CAC Screener page
#    Then I click on "Yes" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page
    And I validate results option for "header" on CAC Screener page displays in "English"
    And I validate results option for "C4HCO" on CAC Screener page displays in "English"
#    And I validate results option for "SES Renewal" on CAC Screener page displays in "English"
    And I validate CAC Screener questions are "Disabled" in "English"
    And I refresh the page
    And I validate results option for "header" on CAC Screener page displays in "English"
    And I validate results option for "C4HCO" on CAC Screener page displays in "English"
#    And I validate results option for "SES Renewal" on CAC Screener page displays in "English"
    And I validate CAC Screener questions are "Disabled" in "English"
    And I validate "Yes" option for "under 19" on CAC Screener page is "false"
    And I validate "No" option for "under 19" on CAC Screener page is "true"
    And I validate "Yes" option for "pregnant" on CAC Screener page is "false"
    And I validate "No" option for "pregnant" on CAC Screener page is "true"
    And I validate "No" option for "DACA" on CAC Screener page is "false"
    And I validate "Yes" option for "DACA" on CAC Screener page is "true"
#    And I validate "No" option for "SES" on CAC Screener page is "false"
#    And I validate "Yes" option for "SES" on CAC Screener page is "true"
    Then I click Retake quiz button on the CAC Screener page
    And I validate CAC Screener questions are "Enabled" in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-345 @PageValidationCacScreenerPage
  Scenario: SLCR-345 I want to see an updated page and dynamic behavior when quiz results are displayed Spanish
    And I change the language from header to "Spanish"
    Then I click on "Yes" option for "under 19" on CAC Screener page
    Then I click on "Yes" option for "pregnant" on CAC Screener page
    Then I click on "Yes" option for "DACA" on CAC Screener page
#    Then I click on "Yes" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page
    And I validate results option for "header" on CAC Screener page displays in "Spanish"
    And I validate results option for "HealthFirst" on CAC Screener page displays in "Spanish"
    And I validate results option for "C4HCO" on CAC Screener page displays in "Spanish"
#    And I validate results option for "SES Renewal" on CAC Screener page displays in "Spanish"
    And I validate CAC Screener questions are "Disabled" in "Spanish"
    Then I click Retake quiz button on the CAC Screener page
    And I validate CAC Screener questions are "Enabled" in "Spanish"
    Then I click on "No" option for "under 19" on CAC Screener page
    Then I click on "No" option for "pregnant" on CAC Screener page
    Then I click on "Yes" option for "DACA" on CAC Screener page
#    Then I click on "Yes" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page
    And I validate results option for "header" on CAC Screener page displays in "Spanish"
    And I validate results option for "C4HCO" on CAC Screener page displays in "Spanish"
#    And I validate results option for "SES Renewal" on CAC Screener page displays in "Spanish"
    And I validate CAC Screener questions are "Disabled" in "Spanish"
    And I refresh the page
    And I validate results option for "header" on CAC Screener page displays in "Spanish"
    And I validate results option for "C4HCO" on CAC Screener page displays in "Spanish"
#    And I validate results option for "SES Renewal" on CAC Screener page displays in "Spanish"
    And I validate CAC Screener questions are "Disabled" in "Spanish"
    And I validate "Yes" option for "under 19" on CAC Screener page is "false"
    And I validate "No" option for "under 19" on CAC Screener page is "true"
    And I validate "Yes" option for "pregnant" on CAC Screener page is "false"
    And I validate "No" option for "pregnant" on CAC Screener page is "true"
    And I validate "No" option for "DACA" on CAC Screener page is "false"
    And I validate "Yes" option for "DACA" on CAC Screener page is "true"
#    And I validate "No" option for "SES" on CAC Screener page is "false"
#    And I validate "Yes" option for "SES" on CAC Screener page is "true"
    Then I click Retake quiz button on the CAC Screener page
    And I validate CAC Screener questions are "Enabled" in "Spanish"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page


