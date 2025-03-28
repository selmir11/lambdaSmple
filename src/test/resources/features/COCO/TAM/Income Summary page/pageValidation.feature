@TAM @TamCoCo
Feature: Tests related to the Income Summary page

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

  @SLCR-896
  Scenario: SLCR-896 - As CoCo user on the Income Summary page, I want to see the total annual income and projected income so that I know the income amounts that will be used in determining eligibility(CCRT-553)
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I validate I am on the "CoCo Income Summary" page
    Then I verify the total annual income to be "$0.00"
    And I validate the total annual income label texts along with their properties on the CoCo Income Summary page
      | Text                                          | fontSize | fontFamily            | fontWeight | color               |
      | Total annual income $0.00                     | 19px     | "PT Sans", sans-serif | 700        | rgba(77, 77, 79, 1) |
      | Income minus Deductions = Total annual income | 14px     | "PT Sans", sans-serif | 400        | rgba(77, 77, 79, 1) |
    Then I select go back on the income summary CoCo page
    Then I validate I am on the "CoCo Deductions" page
    And I select Back on the Deductions CoCo page
    Then I validate I am on the "CoCo Additional Income" page
    And I select Go Back on the Additional Income CoCo page
    Then I validate I am on the "CoCo Employment Income" page
    And I select "Yes" employment option
    And I enter "12500.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select "Alimony Received" as additional income option with "262.00" amount at "Annually" frequency
    And I select "Income from rental property" as additional income option with "250.00" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "Student loan" as deduction option with "300.00" amount at "Annually" frequency
    And I select "School tuition" as deduction option with "185.00" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    And I validate I am on the "CoCo Income Summary" page
    Then I verify the total annual income to be "$12,527.00"
    And I validate the total annual income label texts along with their properties on the CoCo Income Summary page
      | Text                                          | fontSize | fontFamily            | fontWeight | color               |
      | Total annual income $12,527.00                | 19px     | "PT Sans", sans-serif | 700        | rgba(77, 77, 79, 1) |
      | Income minus Deductions = Total annual income | 14px     | "PT Sans", sans-serif | 400        | rgba(77, 77, 79, 1) |
    And I select the projected income option "Yes" on Income Summary CoCo page
    And I enter "15200.00" of projected income on Income Summary CoCo page
    Then I select go back on the income summary CoCo page
    Then I validate I am on the "CoCo Deductions" page
    And I select "Alimony" as deduction option with "6500.00" amount at "Annually" frequency
    And I select "HSA" as deduction option with "6027.00" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    And I validate I am on the "CoCo Income Summary" page
    Then I verify the total annual income to be "$0.00"
    And I validate the total annual income label texts along with their properties on the CoCo Income Summary page
      | Text                                          | fontSize | fontFamily            | fontWeight | color               |
      | Total annual income $0.00                     | 19px     | "PT Sans", sans-serif | 700        | rgba(77, 77, 79, 1) |
      | Income minus Deductions = Total annual income | 14px     | "PT Sans", sans-serif | 400        | rgba(77, 77, 79, 1) |
    And I select the projected income option "Yes" on Income Summary CoCo page
    And I enter "15200.00" of projected income on Income Summary CoCo page
    Then I select go back on the income summary CoCo page
    Then I validate I am on the "CoCo Deductions" page
    And I select "Self-employment health insurance" as deduction option with "2498.00" amount at "Annually" frequency
    And I select "Moving expenses" as deduction option with "2490.00" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    And I validate I am on the "CoCo Income Summary" page
    Then I verify the total annual income to be "-$4,988.00"
    And I validate the total annual income label texts along with their properties on the CoCo Income Summary page
      | Text                                          | fontSize | fontFamily            | fontWeight | color               |
      | Total annual income -$4,988.00                | 19px     | "PT Sans", sans-serif | 700        | rgba(77, 77, 79, 1) |
      | Income minus Deductions = Total annual income | 14px     | "PT Sans", sans-serif | 400        | rgba(77, 77, 79, 1) |
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page