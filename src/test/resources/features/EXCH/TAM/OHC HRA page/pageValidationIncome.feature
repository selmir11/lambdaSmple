@TAM @TamExch @PageVerificationIncomeHraPage
Feature: Page Validation-OHC HRA Elmo Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question

  @SLER-2120
  Scenario: SLER-2120 ELIG-ICHRA Opt Out Select Yes Over 400% FPL-HRA
    And I am a member with City "Denver" in State "CO" with dob "01011958" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "425833" income at "Monthly" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "HRA" page
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "50.00" amount on the OHC HRA page
    Then I select "ICHRA" for HRA type
    Then I select "Yes" for opt out on the OHC HRA page
    And I validate that, after selecting ICHRA the message is displayed in OHC HRA Page
      |It may be less expensive to pay for your coverage with the Advanced Premium Tax Credit you could receive through Connect for Health Colorado. This would replace your employer's contribution.|
      |If receiving Advance Premium Tax Credit is a more affordable option, would you choose to opt out from receiving an employer contribution?                                                     |
    Then I click continue on the OHC HRA page
    Then I validate I am on the "Family Overview" page
    Then I wait for 5000 milliseconds
    And I verify the HRA options selected in the DB
   |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |     50.00   |  ICHRA |         1          |          1           |
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text displays on the Application History page
    Then I validate that "Cost-Sharing Reductions" text does not display on the Application History page
    Then I validate that my APTC value is "$728.10/mo"
    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2307
  Scenario: SLER-2307 ELIG-QSEHRA Unaffordable Over 400% FPL-HRA - DB
    And I am a member with City "Frisco" in State "CO" with dob "01021971" in county "SUMMIT" with zipcode "80435"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "450000" income at "Monthly" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "HRA" page
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "5.00" amount on the OHC HRA page
    Then I select "QSEHRA" for HRA type
    Then I click continue on the OHC HRA page
    Then I validate I am on the "Family Overview" page
    Then I wait for 5000 milliseconds
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |      5.00   | QSEHRA |                    |          1           |
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text displays on the Application History page
    Then I validate that "Cost-Sharing Reductions" text does not display on the Application History page
    Then I validate that my APTC value is "$568.36/mo"
    Then I wait for 5000 milliseconds
    Then I validate the Overridden APTC amount is "5.0" in DB

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2310
  Scenario: SLER-2310 ELIG-ICHRA Affordable Over 400% FPL-HRA - DB
    And I am a member with City "Frisco" in State "CO" with dob "10101980" in county "SUMMIT" with zipcode "80435"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "500000" income at "Monthly" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "HRA" page
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "200.00" amount on the OHC HRA page
    Then I select "ICHRA" for HRA type
    Then I click continue on the OHC HRA page
    Then I validate I am on the "Family Overview" page
    Then I wait for 5000 milliseconds
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    200.00   |  ICHRA |                    |          0           |
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text does not display on the Application History page
    Then I validate that "Cost-Sharing Reductions" text does not display on the Application History page
    Then I validate the aptc section doesn't exist on the application history page

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2312
  Scenario: SLER-2312 ELIG- ICHRA Opt Out Select No Over 400% FPL-HRA - DB
    And I am a member with City "Denver" in State "CO" with dob "01011958" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "4258.33" income at "Monthly" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "HRA" page
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "50.00" amount on the OHC HRA page
    Then I select "ICHRA" for HRA type
    Then I select "No" for opt out on the OHC HRA page
    Then I click continue on the OHC HRA page
    Then I validate I am on the "Family Overview" page
    Then I wait for 5000 milliseconds
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    50.00    |  ICHRA |         0          |          1           |
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text does not display on the Application History page
    Then I validate that "Cost-Sharing Reductions" text does not display on the Application History page
    Then I validate the aptc section doesn't exist on the application history page

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2314
  Scenario: SLER-2314 ELIG- ICHRA Opt Out Select No-HRA NextYear - DB
    And I am a member with City "Denver" in State "CO" with dob "05021990" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "200000" income at "Monthly" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Head of household" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "HRA" page
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "50.00" amount on the OHC HRA page
    Then I select "ICHRA" for HRA type
    Then I select "No" for opt out on the OHC HRA page
    Then I click continue on the OHC HRA page
    Then I validate I am on the "Family Overview" page
    Then I wait for 5000 milliseconds
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    50.00    |  ICHRA |         0          |          1           |
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text does not display on the Application History page
    Then I validate that "Cost-Sharing Reductions" text does not display on the Application History page
    Then I validate the aptc section doesn't exist on the application history page

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2315
  Scenario: SLER-2315 ELIG-ICHRA Opt Out Select Yes-HRA NextYear -HRA - DB
    And I am a member with City "Denver" in State "CO" with dob "10011990" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "200000" income at "Monthly" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Head of household" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "HRA" page
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "50.00" amount on the OHC HRA page
    Then I select "ICHRA" for HRA type
    Then I select "Yes" for opt out on the OHC HRA page
    Then I click continue on the OHC HRA page
    Then I validate I am on the "Family Overview" page
    Then I wait for 5000 milliseconds
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    50.00    |  ICHRA |         1          |          1           |
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click "No" on Before you continue popup on the application history page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text displays on the Application History page
    Then I validate that "Cost-Sharing Reductions" text displays on the Application History page
    Then I validate that my APTC value is "$407.48/mo"

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2316
  Scenario: SLER-2316 ELIG- ICHRA Opt Out Select No-HRA - DB
    And I am a member with City "Denver" in State "CO" with dob "05021990" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "200000" income at "Monthly" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "HRA" page
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "50.00" amount on the OHC HRA page
    Then I select "ICHRA" for HRA type
    Then I select "No" for opt out on the OHC HRA page
    Then I click continue on the OHC HRA page
    Then I validate I am on the "Family Overview" page
    Then I wait for 5000 milliseconds
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    50.00    |  ICHRA |         0          |          1           |
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text does not display on the Application History page
    Then I validate that "Cost-Sharing Reductions" text does not display on the Application History page
    Then I validate the aptc section doesn't exist on the application history page

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2317
  Scenario: SLER-2317 ELIG-ICHRA Affordable-HRA - DB
    And I am a member with City "Frisco" in State "CO" with dob "10101980" in county "SUMMIT" with zipcode "80435"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "300000" income at "Monthly" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "HRA" page
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "1000.00" amount on the OHC HRA page
    Then I select "ICHRA" for HRA type
    Then I click continue on the OHC HRA page
    Then I validate I am on the "Family Overview" page
    Then I wait for 5000 milliseconds
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |   1000.00   |  ICHRA |                    |          0           |
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text does not display on the Application History page
    Then I validate that "Cost-Sharing Reductions" text does not display on the Application History page
    Then I validate the aptc section doesn't exist on the application history page

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2318
  Scenario: SLER-2318 ELIG-QSEHRA Unaffordable-HRA - DB
    And I am a member with City "Frisco" in State "CO" with dob "10101980" in county "SUMMIT" with zipcode "80435"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "2000.00" income at "Monthly" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "HRA" page
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "50.00" amount on the OHC HRA page
    Then I select "QSEHRA" for HRA type
    Then I click continue on the OHC HRA page
    Then I validate I am on the "Family Overview" page
    Then I wait for 5000 milliseconds
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    50.00    | QSEHRA |                    |          1           |
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click "No" on Before you continue popup on the application history page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text displays on the Application History page
    Then I validate that "Cost-Sharing Reductions" text displays on the Application History page
    Then I validate that my APTC value is "$537.46/mo"
    Then I wait for 5000 milliseconds
    Then I validate the Overridden APTC amount is "50.0" in DB

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2319
  Scenario: SLER-2319 ELIG-ICHRA Opt Out Select Yes-HRA - DB
    And I am a member with City "Denver" in State "CO" with dob "10011990" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "2000.00" income at "Monthly" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "HRA" page
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "50.00" amount on the OHC HRA page
    Then I select "ICHRA" for HRA type
    Then I select "Yes" for opt out on the OHC HRA page
    Then I click continue on the OHC HRA page
    Then I validate I am on the "Family Overview" page
    Then I wait for 5000 milliseconds
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    50.00    |  ICHRA |         1          |          1           |
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click "No" on Before you continue popup on the application history page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text displays on the Application History page
    Then I validate that "Cost-Sharing Reductions" text displays on the Application History page
    Then I validate that my APTC value is "$407.48/mo"

    And I click on Sign Out in the Header for "NonElmo"

