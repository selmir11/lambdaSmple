@TAM @TamCoCo
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
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page

  @SLCR-65 @PageTextIncomeSummary
  Scenario: SLCR-65 I can see Income Summary's Header and footer - English
    Then I validate I am on the "CoCo Income Summary" page
    And I verify text on the "CoCo" "Header" in "English"
    And I verify text on the "CoCo" "Footer" in "English"

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "CoCo Income Summary" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Income Summary" page


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-66 @PageTextIncomeSummary @TAMSmokeCoCo
  Scenario: SLCR-66 I can see Income Summary's Header and footer - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I verify text on the "CoCo" "Header" in "Spanish"
    And I verify text on the "CoCo" "Footer" in "Spanish"

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    And I validate I am on the "CoCo Income Summary" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Income Summary" page


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-377
  Scenario: SLCR-377 I want to see a pencil icon rather than the Edit/Update link
    And I verify the header for Primary Member on the CoCo Income Summary page in "English"
    Then I verify the edit icon
    And I click on the edit "Income" icon on the Income Summary CoCo page
    Then I validate I am on the "CoCo Employment Income" page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I click on the edit "Deductions" icon on the Income Summary CoCo page
    Then I validate I am on the "CoCo Deductions" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-640
  Scenario: SLCR-640 I want the ability to see the page in English - Primary user
    And I verify the header for Primary Member on the CoCo Income Summary page in "English"
    Then I verify income "None" in "English" on the income summary CoCo page
    Then I verify deduction "None" in "English" on the income summary CoCo page
    Then I verify the total annual income to be "0.00"
    Then I verify the total annual income description in "English"
    Then I verify the Projected Income text on CoCo Income Summary in "English"
    And I select the projected income option "Yes" on Income Summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I select Go Back on the Additional Income CoCo page
    And I select "Yes" employment option
    And I enter "50" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "All Jobs/Employers" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I select Go Back on the Additional Income CoCo page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I validate I am on the "CoCo Additional Income" page
    And I select "Alimony Received" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Alimony Received" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Capital Gains" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Capital Gains" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Income from rental property" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Income from rental property" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Pension" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Pension" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Private Retirement Income" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Private Retirement Income" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Income from Social Security" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Income from Social Security" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Unemployment Insurance Benefit" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Unemployment Insurance Benefit" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Investment Income" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Investment Income" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Cash Support" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Cash Support" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Untaxed Foreign Income" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Untaxed Foreign Income" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Royalty Income" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Royalty Income" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Taxable income from Tribal Sources" as additional income option with "100" amount at "Annually" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Taxable income from Tribal Sources" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "Alimony" as deduction option with "100" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Alimony or spousal support paid out" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Domestic production" as deduction option with "100" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Domestic production activities" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "HSA" as deduction option with "100" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Health Savings Account contribution" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Pre-tax retirement" as deduction option with "100" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Pre-tax retirement account contribution" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "School tuition" as deduction option with "100" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "School tuition and fees" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Self-employment tax" as deduction option with "100" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Self-employment tax" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Student loan" as deduction option with "100" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Student loan interest" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Self-employment health insurance" as deduction option with "100" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Self-employment health insurance" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Self-employment retirement" as deduction option with "100" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Self-employment retirement plan" in "English" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Moving expenses" as deduction option with "100" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Moving expenses" in "English" on the income summary CoCo page

  @SLCR-645
  Scenario: SLCR-645 I want the ability to see the page in Spanish - Primary user
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    Then I verify income "None" in "Spanish" on the income summary CoCo page
    Then I verify deduction "None" in "Spanish" on the income summary CoCo page
    Then I verify the total annual income to be "0.00"
    Then I verify the total annual income description in "Spanish"
    Then I verify the Projected Income text on CoCo Income Summary in "Spanish"
    And I select the projected income option "Yes" on Income Summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I select Go Back on the Additional Income CoCo page
    And I select "Yes" employment option
    And I enter "50" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "All Jobs/Employers" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I select Go Back on the Additional Income CoCo page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I validate I am on the "CoCo Additional Income" page
    And I select "Alimony Received" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Alimony Received" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Capital Gains" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Capital Gains" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Income from rental property" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Income from rental property" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Pension" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Pension" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Private Retirement Income" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Private Retirement Income" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Income from Social Security" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Income from Social Security" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Unemployment Insurance Benefit" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Unemployment Insurance Benefit" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Investment Income" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Investment Income" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Cash Support" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Cash Support" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Untaxed Foreign Income" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Untaxed Foreign Income" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Royalty Income" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Royalty Income" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I select Back on the Deductions CoCo page
    And I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select "Taxable income from Tribal Sources" as additional income option with "100" amount at "Anualmente" frequency
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I verify income "Taxable income from Tribal Sources" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "Alimony" as deduction option with "100" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Alimony or spousal support paid out" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Domestic production" as deduction option with "100" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Domestic production activities" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "HSA" as deduction option with "100" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Health Savings Account contribution" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Pre-tax retirement" as deduction option with "100" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Pre-tax retirement account contribution" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "School tuition" as deduction option with "100" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "School tuition and fees" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Self-employment tax" as deduction option with "100" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Self-employment tax" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Student loan" as deduction option with "100" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Student loan interest" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Self-employment health insurance" as deduction option with "100" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Self-employment health insurance" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Self-employment retirement" as deduction option with "100" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Self-employment retirement plan" in "Spanish" on the income summary CoCo page
    And I select go back on the income summary CoCo page
    And I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select "Moving expenses" as deduction option with "100" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I verify deduction "Moving expenses" in "Spanish" on the income summary CoCo page

  @SLCR-795
  Scenario: SLCR-795 I want error focus state for all components updated so that they are consistent with the style definitions in the Design System - Income Summary
    And I verify the header for Primary Member on the CoCo Income Summary page in "English"
    And I select continue on the income Summary CoCo page
    Then I verify income Summary CoCo error format for "Projected Income"
    Then I select the projected income option "Yes" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I verify income Summary CoCo error format for "Income Input"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-818
  Scenario: SLCR-818 As CoCo user, I want to see standard errors errors on the Income Summary page so that errors are displayed consistently(CCRT-571)
    And I verify the header for Primary Member on the CoCo Income Summary page in "English"
    Then I select the projected income option "Yes" on Income Summary CoCo page
    Then I click on the Projected Income Input field and click out of this field
    And I validate the error text along with its properties on the CoCo Income Summary page
      | Text               | fontSize | fontFamily            | fontWeight | color              | lineHeight | textAlign |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) | 24px       | start     |
    And I validate the label text along with its properties on the CoCo Income Summary page
      | Text                                 | fontSize | fontFamily            | fontWeight | color              | lineHeight | textAlign |
      | Enter your projected income in 2025. | 16px     | "PT Sans", sans-serif | 700        | rgba(150, 0, 0, 1) | 28px       | start     |
    And I enter "70.00" of projected income on Income Summary CoCo page
    And I verify no error shows on the Income Summary page
    And I refresh the page
    Then I select the projected income option "Yes" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    And I validate the error text along with its properties on the CoCo Income Summary page
      | Text               | fontSize | fontFamily            | fontWeight | color              | lineHeight | textAlign |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) | 24px       | start     |
    And I validate the label text along with its properties on the CoCo Income Summary page
      | Text                                 | fontSize | fontFamily            | fontWeight | color              | lineHeight | textAlign |
      | Enter your projected income in 2025. | 16px     | "PT Sans", sans-serif | 700        | rgba(150, 0, 0, 1) | 28px       | start     |
    Then I select the projected income option "No" on Income Summary CoCo page
    And I verify no error shows on the Income Summary page
    And I refresh the page
    And I select continue on the income Summary CoCo page
    And I validate the error text along with its properties on the CoCo Income Summary page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              | lineHeight | textAlign |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) | 24px       | start     |
    Then I select the projected income option "No" on Income Summary CoCo page
    And I verify no error shows on the Income Summary page
    And I refresh the page
    And I select continue on the income Summary CoCo page
    And I validate the error text along with its properties on the CoCo Income Summary page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              | lineHeight | textAlign |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) | 24px       | start     |
    Then I select the projected income option "Yes" on Income Summary CoCo page
    And I verify no error shows on the Income Summary page
    And I select continue on the income Summary CoCo page
    And I validate the error text along with its properties on the CoCo Income Summary page
      | Text               | fontSize | fontFamily            | fontWeight | color              | lineHeight | textAlign |
      | Amount is required | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) | 24px       | start     |
    And I validate the label text along with its properties on the CoCo Income Summary page
      | Text                                 | fontSize | fontFamily            | fontWeight | color              | lineHeight | textAlign |
      | Enter your projected income in 2025. | 16px     | "PT Sans", sans-serif | 700        | rgba(150, 0, 0, 1) | 28px       | start     |
    And I enter "70.00" of projected income on Income Summary CoCo page
    And I verify no error shows on the Income Summary page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
    
    @SLCR-887
    Scenario: SLCR-887 ELIG-As a user on the Income Summary page,
    I want to see the total annual income and projected income so that 
    I know the income amounts that will be used in determining eligibility [CCRT-253]
      And I verify no error shows on the Income Summary page
      Then I validate I am on the "CoCo Income Summary" page
      And I select go back on the income summary CoCo page
      And I select Back on the Deductions CoCo page
      And I select Go Back on the Additional Income CoCo page
      And I select "Yes" employment option
      And I enter "10000.00" income amount
      And I select "Annually" income frequency option
      And I select "No" income seasonal option
      And I select "No" income changes option
      And I click continue on the Employment income page
      And I select continue on the Additional Income CoCO page
      And I select continue on the Deductions CoCo page
      Then I verify income "All Jobs/Employers" in "English" on the income summary CoCo page
      And I select go back on the income summary CoCo page
      And I select Back on the Deductions CoCo page
      And I select "Alimony Received" as additional income option with "5000.00" amount at "Annually" frequency
      And I select continue on the Additional Income CoCO page
      And I select "School tuition" as deduction option with "2000.00" amount at "Annually" frequency
      And I select continue on the Deductions CoCo page
      Then I validate I am on the "CoCo Income Summary" page
      Then I validate that the Total Annual Income is correctly determined by adding the Employment Income "10000.00" and Additional Income "5000.00", then subtracting the Deduction Amount "2000.00"
