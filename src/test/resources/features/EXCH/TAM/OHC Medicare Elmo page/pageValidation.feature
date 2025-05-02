@TAM @TamExch
Feature: Page Validation-OHC Medicare Elmo Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
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
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "Medicare" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc Medicare" page

  @SLER-329 @PageValidationOhcMedicareElmo
  Scenario: SLER-329 I can see Medicare's standard errors consistently - English
    And I verify the "First Section" Medicare page data in "English"
    Then I click continue on the OHC Medicare page
    And I verify "Currently Eligible" error in "English" on the Medicare page
    Then I click "No" for currently eligible in Medicare question
    And I verify "Currently Eligible" error does not show for Medicare page

    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    And I verify the "Part A Section" Medicare page data in "English"
    Then I click continue on the OHC Medicare page
    And I verify "Part A Amount Required" error in "English" on the Medicare page
    And I verify "Part A" error in "English" on the Medicare page
    Then I enter Part A amount of "150.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    And I verify "Part A" error does not show for Medicare page
    Then I enter Part A amount of "del"
    Then I click continue on the OHC Medicare page
    And I verify "Part A Amount Required" error in "English" on the Medicare page
    And I verify "Part A Date" error in "English" on the Medicare page
    Then I check checkbox for Part "A Don't Pay"
    Then I enter end date of "Current Month" for Medicare part "A"
    And I verify "Part A Amount Required" error does not show for Medicare page
    And I verify "Part A Date" error does not show for Medicare page

    Then I check checkbox for Part "A"
    Then I check checkbox for Part "B"
    And I verify the "Part B Section" Medicare page data in "English"
    Then I click continue on the OHC Medicare page
    And I verify "Part B" error in "English" on the Medicare page
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    And I verify "Part B" error does not show for Medicare page
    Then I click continue on the OHC Medicare page
    And I verify "Part B Date" error in "English" on the Medicare page
    Then I enter end date of "Current Month" for Medicare part "B"
    And I verify "Part B Date" error does not show for Medicare page

    And I click on Sign Out in the Header for "Elmo"


  @SLER-330 @PageValidationOhcMedicareElmo @TAMSmokeExch
  Scenario: SLER-330 I can see Medicare's standard errors consistently - Spanish
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page
    And I verify the "First Section" Medicare page data in "Spanish"
    Then I click continue on the OHC Medicare page
    And I verify "Currently Eligible" error in "Spanish" on the Medicare page
    Then I click "No" for currently eligible in Medicare question
    And I verify "Currently Eligible" error does not show for Medicare page

    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    And I verify the "Part A Section" Medicare page data in "Spanish"
    Then I click continue on the OHC Medicare page
    And I verify "Part A Amount Required" error in "Spanish" on the Medicare page
    And I verify "Part A" error in "Spanish" on the Medicare page
    Then I enter Part A amount of "150.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    And I verify "Part A" error does not show for Medicare page
    Then I enter Part A amount of "del"
    Then I click continue on the OHC Medicare page
    And I verify "Part A Amount Required" error in "Spanish" on the Medicare page
    And I verify "Part A Date" error in "Spanish" on the Medicare page
    Then I check checkbox for Part "A Don't Pay"
    Then I enter end date of "Current Month" for Medicare part "A"
    And I verify "Part A Amount Required" error does not show for Medicare page
    And I verify "Part A Date" error does not show for Medicare page

    Then I check checkbox for Part "A"
    Then I check checkbox for Part "B"
    And I verify the "Part B Section" Medicare page data in "Spanish"
    Then I click continue on the OHC Medicare page
    And I verify "Part B" error in "Spanish" on the Medicare page
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    And I verify "Part B" error does not show for Medicare page
    Then I click continue on the OHC Medicare page
    And I verify "Part B Date" error in "Spanish" on the Medicare page
    Then I enter end date of "Current Month" for Medicare part "B"
    And I verify "Part B Date" error does not show for Medicare page


    And I click on Sign Out in the Header for "Elmo"

  @SLER-711 @PageValidationOhcMedicareElmo
  Scenario: SLER-711 I validate save, update and remove on Medicare are updated in the DB
    And I verify Currently eligible is "Not Selected" on the Medicare page
    And I verify Part A "is not" and Part B "is not" checked on the Medicare page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|retiree_health_plan_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_no_premium_paid_ind|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |           0           |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |     1      |                  |                  |                       |                            |                        |                            |                            |
    Then I click "No" for currently eligible in Medicare question
    Then I click continue on the OHC Medicare page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|retiree_health_plan_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_no_premium_paid_ind|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |           0           |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |     1      |                  |                  |                       |                            |            0           |                            |                            |
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc Medicare" page
    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    Then I enter Part A amount of "250.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    Then I enter end date of "Current Month" for Medicare part "A"
    Then I click continue on the OHC Medicare page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|retiree_health_plan_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_no_premium_paid_ind|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |           0           |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |     1      |         1        |                  |        250.00         |                            |            1           |             1              |                            |
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc Medicare" page
    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    Then I check checkbox for Part "B"
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    Then I enter end date of "Current Month" for Medicare part "B"
    Then I click continue on the OHC Medicare page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|retiree_health_plan_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_no_premium_paid_ind|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |           0           |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |     1      |         0        |        1         |                       |                            |            1           |                            |              1             |
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc Medicare" page
    Then I click "No" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    Then I enter Part A amount of "300.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    Then I enter end date of "Current Month" for Medicare part "A"
    Then I click "No" for Part "B" insurance ending in 60 days in Medicare question
    Then I click continue on the OHC Medicare page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|retiree_health_plan_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_no_premium_paid_ind|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |           0           |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |     1      |         1        |         1        |        300.00         |                            |            0           |             1              |               0            |
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc Medicare" page
    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A Don't Pay"
    Then I click "No" for Part "A" insurance ending in 60 days in Medicare question
    Then I check checkbox for Part "B"
    Then I click continue on the OHC Medicare page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|retiree_health_plan_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_no_premium_paid_ind|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |           0           |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |     1      |         1        |         0        |                       |              1             |            1           |             0              |                            |
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "English"
    Then I check checkbox for Part "A"
    Then I click continue on the OHC Medicare page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|retiree_health_plan_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_no_premium_paid_ind|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |           0           |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |     1      |         0        |         0        |                       |                            |            1           |                            |                            |

    And I click on Sign Out in the Header for "NonElmo"


  @SLER-1161 @PageValidationOhcMedicareElmo
  Scenario: SLER-1161 Errors cleared so that I don't continue to see errors when I answer questions
    #step1 - verify the initial state of the Medicare page
    And I verify the header for "Primary" Member on the Medicare page in "English"
    And I verify initial questions on the Medicare page in "English"
    And I verify Part A "is not" and Part B "is not" checked on the Medicare page

    #step2 - verify errors are cleared for part A
    Then I click continue on the OHC Medicare page
    Then I check checkbox for Part "A"
    And I verify "Part A Amount Required" error does not show for Medicare page
    And I verify "Part A" error does not show for Medicare page
    Then I click continue on the OHC Medicare page
    And I verify "Part A Amount Required" error in "English" on the Medicare page
    And I verify "Part A" error in "English" on the Medicare page
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    And I verify "Part A Date" error does not show for Medicare page
    Then I click continue on the OHC Medicare page
    And I verify "Part A Date" error in "English" on the Medicare page
    Then I check checkbox for Part "A"
    And I verify Part A "is not" and Part B "is not" checked on the Medicare page
    Then I check checkbox for Part "A"
    And I verify Part A "is" and Part B "is not" checked on the Medicare page
    And I verify "Part A Amount Required" error does not show for Medicare page
    And I verify "Part A" error does not show for Medicare page
    And I verify "Part A Date" error does not show for Medicare page

    #step3 - verify errors are cleared for part B
    Then I check checkbox for Part "B"
    And I verify "Part B" error does not show for Medicare page
    Then I click continue on the OHC Medicare page
    And I verify "Part B" error in "English" on the Medicare page
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    And I verify "Part B Date" error does not show for Medicare page
    Then I click continue on the OHC Medicare page
    Then I check checkbox for Part "B"
    And I verify Part A "is" and Part B "is not" checked on the Medicare page
    Then I check checkbox for Part "B"
    And I verify Part A "is" and Part B "is" checked on the Medicare page
    And I verify "Part B" error does not show for Medicare page
    And I verify "Part B Date" error does not show for Medicare page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-1125 @PageValidationOhcMedicareElmo @TAMSmokeExch
  Scenario: SLER-1125 I validate no errors displayed on the Family Overview page after user selects Medicare coverage
    And I verify Currently eligible is "Not Selected" on the Medicare page
    And I verify Part A "is not" and Part B "is not" checked on the Medicare page
    Then I click "Yes" for currently eligible in Medicare question
    Then I click continue on the OHC Medicare page

  #verify there are no errors after user selects only "Yes" to Currently eligible question
    And I validate I am on the "Family Overview" page
    Then I validate no errors are displayed on family overview page
    Then I click continue on family overview page
    And I validate I am on the "Tell us about life changes" page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on "No Thanks" on good news page
    And I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page

    And I validate I am on the "Ohc Medicare" page
    And I verify Currently eligible is "Yes" on the Medicare page
    And I verify Part A "is not" and Part B "is not" checked on the Medicare page
    Then I click "No" for currently eligible in Medicare question
    Then I click continue on the OHC Medicare page

  #verify there are no errors after user selects only "No" to Currently eligible question
    And I validate I am on the "Family Overview" page
    Then I validate no errors are displayed on family overview page
    Then I click continue on family overview page
    And I validate I am on the "Tell us about life changes" page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on "No Thanks" on good news page
    And I validate I am on the "Application History" page

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-1222
  Scenario: SLER-1222 I verify that income-portal-ui uses common components from ng-common on the ELMO Medicare page
    And I verify the header for "Primary" Member on the Medicare page in "English"
    Then I verify Medicare checkbox in "Not Selected" state
    And I refresh the page
    Then I verify Medicare checkbox in "Selected" state
    And I refresh the page
    Then I verify Medicare checkbox in "Focus" state
    And I refresh the page
    Then I verify Medicare checkbox in "Hover" state

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page