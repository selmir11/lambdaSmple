@TAM @TamCoCo @PageNavigationCacScreenerPage
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

  @SLCR-350 @PageNavigationCacScreenerPage @TAMSmoke
  Scenario: SLCR-350 I need navigation functionality so I am navigated to the correct page English
    Then I click on "Yes" option for "under 19" on CAC Screener page
    Then I click on "Yes" option for "pregnant" on CAC Screener page
    Then I click on "Yes" option for "DACA" on CAC Screener page
#    Then I click on "Yes" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page

    And I validate results option for "HealthFirst" on CAC Screener page displays in "English"
    Then I click "HealthFirst button" in results on the CAC Screener page
    And I validate I am on the "Health First Co Apply" page and close tab
    Then I click "HealthFirst link" in results on the CAC Screener page
    And I validate I am on the "Health First Co Apply" page and close tab

    And I validate results option for "C4HCO" on CAC Screener page displays in "English"
    Then I click "C4HCO" in results on the CAC Screener page
    And I validate I am on the "Create Account" page and close tab

#    And I validate results option for "SES Renewal" on CAC Screener page displays in "English"
#    Then I click "SES Renewal" in results on the CAC Screener page
#    Then I validate I am on the "CoCo Welcome" page
#
#    And I select take a short quiz on welcome page
#    Then I click "Enrollment Expert" in results on the CAC Screener page
#    And I validate I am on the "OmniSalud Help" page and close tab

    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page

    And I select take a short quiz on welcome page
    Then I click Retake quiz button on the CAC Screener page
    Then I click on "No" option for "under 19" on CAC Screener page
    Then I click on "No" option for "pregnant" on CAC Screener page
    Then I click on "No" option for "DACA" on CAC Screener page
#    Then I click on "No" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page

#    And I validate results option for "SES New" on CAC Screener page displays in "English"
#    Then I click "SES New" in results on the CAC Screener page
#    Then I validate I am on the "CoCo Welcome" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-351 @PageNavigationCacScreenerPage
  Scenario: SLCR-351 I need navigation functionality so I am navigated to the correct page Spanish
    And I change the language from header to "Spanish"
    Then I click on "Yes" option for "under 19" on CAC Screener page
    Then I click on "Yes" option for "pregnant" on CAC Screener page
    Then I click on "Yes" option for "DACA" on CAC Screener page
#    Then I click on "Yes" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page

    And I validate results option for "HealthFirst" on CAC Screener page displays in "Spanish"
    Then I click "HealthFirst button" in results on the CAC Screener page
    And I validate I am on the "Health First Co Apply" page and close tab
    Then I click "HealthFirst link" in results on the CAC Screener page
    And I validate I am on the "Health First Co Apply" page and close tab

    And I validate results option for "C4HCO" on CAC Screener page displays in "Spanish"
    Then I click "C4HCO" in results on the CAC Screener page
    And I validate I am on the "Create Account" page and close tab

#    And I validate results option for "SES Renewal" on CAC Screener page displays in "Spanish"
#    Then I click "SES Renewal" in results on the CAC Screener page
#    Then I validate I am on the "CoCo Welcome" page
#
#    And I select take a short quiz on welcome page
#    Then I click "Enrollment Expert" in results on the CAC Screener page
#    And I validate I am on the "OmniSalud Help" page and close tab

    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page

    And I select take a short quiz on welcome page
    Then I click Retake quiz button on the CAC Screener page
    Then I click on "No" option for "under 19" on CAC Screener page
    Then I click on "No" option for "pregnant" on CAC Screener page
    Then I click on "No" option for "DACA" on CAC Screener page
#    Then I click on "No" option for "SES" on CAC Screener page
    Then I click See results button on the CAC Screener page

#    And I validate results option for "SES New" on CAC Screener page displays in "Spanish"
#    Then I click "SES New" in results on the CAC Screener page
#    Then I validate I am on the "CoCo Welcome" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page




