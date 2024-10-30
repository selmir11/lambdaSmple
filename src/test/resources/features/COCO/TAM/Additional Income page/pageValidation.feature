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
    Then I click EditUpdate on Family Overview page for "Primay"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "2000000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page

  @SLCR-375 @TAMSmoke
  Scenario: SLCR-375 I want amount and frequency errors cleared on the Additional income sources page so that I don't see errors when I select an option - English
    #Step3
    Then I select "Income from rental property" as additional income option CoCO page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income option with no amount in "English" CoCo page
    Then I verify error for additional income option with no frequency in "English" CoCo page
    #Step4
    Then I select "None of these" as additional income option CoCO page
    Then I select "Income from rental property" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step5
    Then I select "Unemployment Insurance Benefit" as additional income option CoCO page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income option with no amount in "English" CoCo page
    Then I verify error for additional income option with no frequency in "English" CoCo page
    #Step6
    Then I select "Unemployment Insurance Benefit" as additional income option CoCO page
    Then I select "Income from rental property" as additional income option CoCO page
    Then I select "Unemployment Insurance Benefit" as additional income option CoCO page
    Then I select "Income from rental property" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step7
    Then I select "None of these" as additional income option CoCO page
    Then I select "Taxable income from Tribal Sources" as additional income option CoCO page
    And I select "Private Retirement Income" as additional income option with "500.00" amount at "Monthly" frequency
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income option with no amount in "English" CoCo page
    Then I verify error for additional income option with no frequency in "English" CoCo page
    #Step8
    Then I select "None of these" as additional income option CoCO page
    Then I select "Taxable income from Tribal Sources" as additional income option CoCO page
    Then I select "Private Retirement Income" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    Then I verify "Private Retirement income" as additional income option with "500.00" amount at "3: Monthly" frequency CoCo page
    #Step9
    Then I select "None of these" as additional income option CoCO page
    Then I select "Income from Social Security" as additional income option CoCO page
    And I select "Pension" as additional income option with "70.00" amount at "Weekly" frequency
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income option with no amount in "English" CoCo page
    Then I verify error for additional income option with no frequency in "English" CoCo page
    Then I select "None of these" as additional income option CoCO page
    Then I select "Income from Social Security" as additional income option CoCO page
    Then I select "Pension" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    Then I verify "Pension" as additional income option with "70.00" amount at "5: Weekly" frequency CoCo page
    #Step10
    Then I select "Pension" as additional income option CoCO page
    Then I select "Income from Social Security" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income no option in "English" CoCo page
    #Step11
    Then I select "None of these" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    Then I select "None of these" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step12
    Then I select "Alimony Received" as additional income option CoCO page
    Then I select "Alimony Received" as additional income option CoCO page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income no option in "English" CoCo page
    #Step13
    Then I select "Income from Social Security" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step14
    Then I select "Income from Social Security" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step15
    Then I select "None of these" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    Then I select "None of these" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step16
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income no option in "English" CoCo page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-376
  Scenario: SLCR-376 I want amount and frequency errors cleared on the Additional income sources page so that I don't see errors when I select an option - Spanish
    And I change the language from header to "Spanish"
    #Step3
    Then I select "Income from rental property" as additional income option CoCO page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income option with no amount in "Spanish" CoCo page
    Then I verify error for additional income option with no frequency in "Spanish" CoCo page
    #Step4
    Then I select "None of these" as additional income option CoCO page
    Then I select "Income from rental property" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step5
    Then I select "Unemployment Insurance Benefit" as additional income option CoCO page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income option with no amount in "Spanish" CoCo page
    Then I verify error for additional income option with no frequency in "Spanish" CoCo page
    #Step6
    Then I select "Unemployment Insurance Benefit" as additional income option CoCO page
    Then I select "Income from rental property" as additional income option CoCO page
    Then I select "Unemployment Insurance Benefit" as additional income option CoCO page
    Then I select "Income from rental property" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step7
    Then I select "None of these" as additional income option CoCO page
    Then I select "Taxable income from Tribal Sources" as additional income option CoCO page
    And I select "Private Retirement Income" as additional income option with "500.00" amount at "Mensualmente" frequency
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income option with no amount in "Spanish" CoCo page
    Then I verify error for additional income option with no frequency in "Spanish" CoCo page
    #Step8
    Then I select "None of these" as additional income option CoCO page
    Then I select "Taxable income from Tribal Sources" as additional income option CoCO page
    Then I select "Private Retirement Income" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    Then I verify "Private Retirement income" as additional income option with "500.00" amount at "3: Monthly" frequency CoCo page
    #Step9
    Then I select "None of these" as additional income option CoCO page
    Then I select "Income from Social Security" as additional income option CoCO page
    And I select "Pension" as additional income option with "70.00" amount at "Semanalmente" frequency
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income option with no amount in "Spanish" CoCo page
    Then I verify error for additional income option with no frequency in "Spanish" CoCo page
    Then I select "None of these" as additional income option CoCO page
    Then I select "Income from Social Security" as additional income option CoCO page
    Then I select "Pension" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    Then I verify "Pension" as additional income option with "70.00" amount at "5: Weekly" frequency CoCo page
    #Step10
    Then I select "Pension" as additional income option CoCO page
    Then I select "Income from Social Security" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income no option in "Spanish" CoCo page
    #Step11
    Then I select "None of these" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    Then I select "None of these" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step12
    Then I select "Alimony Received" as additional income option CoCO page
    Then I select "Alimony Received" as additional income option CoCO page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income no option in "Spanish" CoCo page
    #Step13
    Then I select "Income from Social Security" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step14
    Then I select "Income from Social Security" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step15
    Then I select "None of these" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    Then I select "None of these" as additional income option CoCO page
    Then I verify no errors show for additional income options CoCo page
    #Step16
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Additional Income" page
    Then I verify error for additional income no option in "Spanish" CoCo page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page



