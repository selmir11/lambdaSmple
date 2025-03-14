@TAM @pageValidation @TamCoCo
Feature: Tests related to the Additional Income page

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
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "03021995", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "2000000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify the header for additional member on the CoCo Additional Income page in "English"

  @SLCR-836
  Scenario: SLCR-836 - ELIG-Page Validation-Additional Member Additional Income - English
    And I select "Alimony Received" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Alimony Received" as additional income option CoCO page
    And I select "Alimony Received" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Alimony Received" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Alimony Received" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Alimony Received" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Alimony Received" in "English"
    And I refresh the page
    And I select "Alimony Received" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Alimony Received" as additional income option CoCO page
    And I select "Alimony Received" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Alimony Received" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Capital Gains" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Capital Gains" as additional income option CoCO page
    And I select "Capital Gains" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Capital Gains" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Capital Gains" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Capital Gains" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Capital Gains" in "English"
    And I refresh the page
    And I select "Capital Gains" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Capital Gains" as additional income option CoCO page
    And I select "Capital Gains" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Capital Gains" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Income from rental property" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Income from rental property" as additional income option CoCO page
    And I select "Income from rental property" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Income from rental property" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Income from rental property" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Income from rental property" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Income from rental property" in "English"
    And I refresh the page
    And I select "Income from rental property" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Income from rental property" as additional income option CoCO page
    And I select "Income from rental property" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Income from rental property" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Pension" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Pension" as additional income option CoCO page
    And I select "Pension" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Pension" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Pension" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Pension" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Pension" in "English"
    And I refresh the page
    And I select "Pension" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Pension" as additional income option CoCO page
    And I select "Pension" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Pension" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Private Retirement Income" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Private Retirement Income" as additional income option CoCO page
    And I select "Private Retirement Income" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Private Retirement Income" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Private Retirement Income" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Private Retirement Income" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Private Retirement Income" in "English"
    And I refresh the page
    And I select "Private Retirement Income" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Private Retirement Income" as additional income option CoCO page
    And I select "Private Retirement Income" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Private Retirement Income" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Income from Social Security" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Income from Social Security" as additional income option CoCO page
    And I select "Income from Social Security" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Income from Social Security" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Income from Social Security" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Income from Social Security" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Income from Social Security" in "English"
    And I refresh the page
    And I select "Income from Social Security" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Income from Social Security" as additional income option CoCO page
    And I select "Income from Social Security" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Income from Social Security" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Unemployment Insurance Benefit" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Unemployment Insurance Benefit" as additional income option CoCO page
    And I select "Unemployment Insurance Benefit" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Unemployment Insurance Benefit" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Unemployment Insurance Benefit" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Unemployment Insurance Benefit" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Unemployment Insurance Benefit" in "English"
    And I refresh the page
    And I select "Unemployment Insurance Benefit" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Unemployment Insurance Benefit" as additional income option CoCO page
    And I select "Unemployment Insurance Benefit" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Unemployment Insurance Benefit" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Investment Income" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Investment Income" as additional income option CoCO page
    And I select "Investment Income" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Investment Income" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Investment Income" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Investment Income" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Investment Income" in "English"
    And I refresh the page
    And I select "Investment Income" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Investment Income" as additional income option CoCO page
    And I select "Investment Income" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Investment Income" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Cash Support" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Cash Support" as additional income option CoCO page
    And I select "Cash Support" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Cash Support" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Cash Support" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Cash Support" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Cash Support" in "English"
    And I refresh the page
    And I select "Cash Support" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Cash Support" as additional income option CoCO page
    And I select "Cash Support" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Cash Support" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Untaxed Foreign Income" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Untaxed Foreign Income" as additional income option CoCO page
    And I select "Untaxed Foreign Income" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Untaxed Foreign Income" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Untaxed Foreign Income" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Untaxed Foreign Income" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Untaxed Foreign Income" in "English"
    And I refresh the page
    And I select "Untaxed Foreign Income" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Untaxed Foreign Income" as additional income option CoCO page
    And I select "Untaxed Foreign Income" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Untaxed Foreign Income" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Royalty Income" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Royalty Income" as additional income option CoCO page
    And I select "Royalty Income" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Royalty Income" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Royalty Income" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Royalty Income" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Royalty Income" in "English"
    And I refresh the page
    And I select "Royalty Income" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Royalty Income" as additional income option CoCO page
    And I select "Royalty Income" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Royalty Income" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Taxable income from Tribal Sources" as additional income option with "" amount at "Weekly" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Taxable income from Tribal Sources" as additional income option CoCO page
    And I select "Taxable income from Tribal Sources" as additional income option with "60" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Taxable income from Tribal Sources" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Taxable income from Tribal Sources" as additional income option with "-999,999,9.9@ A" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Taxable income from Tribal Sources" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Taxable income from Tribal Sources" in "English"
    And I refresh the page
    And I select "Taxable income from Tribal Sources" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Taxable income from Tribal Sources" as additional income option CoCO page
    And I select "Taxable income from Tribal Sources" as additional income option with "78.00" amount at "Weekly" frequency
    And I verify no error message gets displayed for "Taxable income from Tribal Sources" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-837
  Scenario: SLCR-837 - ELIG-Page Validation-Additional Member Additional Income - Spanish
    And I change the language from header to "Spanish"
    And I verify the header for additional member on the CoCo Additional Income page in "Spanish"
    And I select "Alimony Received" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Alimony Received" as additional income option CoCO page
    And I select "Alimony Received" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Alimony Received" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Alimony Received" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Alimony Received" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Alimony Received" in "Spanish"
    And I refresh the page
    And I select "Alimony Received" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Alimony Received" as additional income option CoCO page
    And I select "Alimony Received" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Alimony Received" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Capital Gains" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Capital Gains" as additional income option CoCO page
    And I select "Capital Gains" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Capital Gains" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Capital Gains" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Capital Gains" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Capital Gains" in "Spanish"
    And I refresh the page
    And I select "Capital Gains" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Capital Gains" as additional income option CoCO page
    And I select "Capital Gains" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Capital Gains" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Income from rental property" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Income from rental property" as additional income option CoCO page
    And I select "Income from rental property" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Income from rental property" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Income from rental property" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Income from rental property" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Income from rental property" in "Spanish"
    And I refresh the page
    And I select "Income from rental property" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Income from rental property" as additional income option CoCO page
    And I select "Income from rental property" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Income from rental property" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Pension" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Pension" as additional income option CoCO page
    And I select "Pension" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Pension" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Pension" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Pension" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Pension" in "Spanish"
    And I refresh the page
    And I select "Pension" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Pension" as additional income option CoCO page
    And I select "Pension" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Pension" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Private Retirement Income" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Private Retirement Income" as additional income option CoCO page
    And I select "Private Retirement Income" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Private Retirement Income" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Private Retirement Income" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Private Retirement Income" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Private Retirement Income" in "Spanish"
    And I refresh the page
    And I select "Private Retirement Income" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Private Retirement Income" as additional income option CoCO page
    And I select "Private Retirement Income" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Private Retirement Income" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Income from Social Security" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Income from Social Security" as additional income option CoCO page
    And I select "Income from Social Security" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Income from Social Security" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Income from Social Security" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Income from Social Security" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Income from Social Security" in "Spanish"
    And I refresh the page
    And I select "Income from Social Security" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Income from Social Security" as additional income option CoCO page
    And I select "Income from Social Security" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Income from Social Security" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Unemployment Insurance Benefit" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Unemployment Insurance Benefit" as additional income option CoCO page
    And I select "Unemployment Insurance Benefit" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Unemployment Insurance Benefit" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Unemployment Insurance Benefit" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Unemployment Insurance Benefit" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Unemployment Insurance Benefit" in "Spanish"
    And I refresh the page
    And I select "Unemployment Insurance Benefit" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Unemployment Insurance Benefit" as additional income option CoCO page
    And I select "Unemployment Insurance Benefit" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Unemployment Insurance Benefit" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Investment Income" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Investment Income" as additional income option CoCO page
    And I select "Investment Income" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Investment Income" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Investment Income" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Investment Income" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Investment Income" in "Spanish"
    And I refresh the page
    And I select "Investment Income" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Investment Income" as additional income option CoCO page
    And I select "Investment Income" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Investment Income" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Cash Support" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Cash Support" as additional income option CoCO page
    And I select "Cash Support" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Cash Support" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Cash Support" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Cash Support" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Cash Support" in "Spanish"
    And I refresh the page
    And I select "Cash Support" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Cash Support" as additional income option CoCO page
    And I select "Cash Support" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Cash Support" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Untaxed Foreign Income" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Untaxed Foreign Income" as additional income option CoCO page
    And I select "Untaxed Foreign Income" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Untaxed Foreign Income" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Untaxed Foreign Income" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Untaxed Foreign Income" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Untaxed Foreign Income" in "Spanish"
    And I refresh the page
    And I select "Untaxed Foreign Income" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Untaxed Foreign Income" as additional income option CoCO page
    And I select "Untaxed Foreign Income" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Untaxed Foreign Income" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Royalty Income" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Royalty Income" as additional income option CoCO page
    And I select "Royalty Income" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Royalty Income" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Royalty Income" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Royalty Income" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Royalty Income" in "Spanish"
    And I refresh the page
    And I select "Royalty Income" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Royalty Income" as additional income option CoCO page
    And I select "Royalty Income" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Royalty Income" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I select "Taxable income from Tribal Sources" as additional income option with "" amount at "Semanalmente" frequency
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text               		   | fontSize | fontFamily            | fontWeight | color              |
      |Esta cantidad es obligatoria| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Taxable income from Tribal Sources" as additional income option CoCO page
    And I select "Taxable income from Tribal Sources" as additional income option with "60" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Taxable income from Tribal Sources" CoCo Additional Income & amount gets converted to "0.60" on CoCo Additional Income page
    And I refresh the page
    And I select "Taxable income from Tribal Sources" as additional income option with "-999,999,9.9@ A" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Taxable income from Tribal Sources" CoCo Additional Income & amount gets converted to "999,999.99" on CoCo Additional Income page
    Then I verify Additional Income CoCo amount Minimum and Maximum for "Taxable income from Tribal Sources" in "Spanish"
    And I refresh the page
    And I select "Taxable income from Tribal Sources" as additional income option with "64.00" amount
    And I select continue on the Additional Income CoCO page
    And I validate the error text with its properties and the error icon on the CoCo Additional Income page
      | Text                                    | fontSize | fontFamily            | fontWeight | color              |
      |Seleccione una de las siguientes opciones| 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "Taxable income from Tribal Sources" as additional income option CoCO page
    And I select "Taxable income from Tribal Sources" as additional income option with "78.00" amount at "Semanalmente" frequency
    And I verify no error message gets displayed for "Taxable income from Tribal Sources" CoCo Additional Income & amount gets converted to "640,078.00" on CoCo Additional Income page
    Then I select "None of these" as additional income option CoCO page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page