@TAM @PageNavigationDeductions @TamCoCo
Feature: Tests related to the Deductions page

  Background: I go to the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page

  @SLCR-740
  Scenario: SLCR-740 Income Service Doesn't Fail Gracefully During Attempt To Delete Non-Existent Income
    And I select "School tuition" as deduction option with "1500.00" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I select go back on the income summary CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify "School tuition" as Deductions option with "1,500.00" amount at "1: Annually" frequency CoCo page
    Then I open current page in new tab
    And I switch to the tab number 0
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I switch to the tab number 1
    Then I validate I am on the "CoCo Deductions" page
    And I select continue on the Deductions CoCo page
    Then I verify the error banner at the top of the deductions coco page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page