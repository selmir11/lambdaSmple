@TAM @TamExch
Feature: Page Text-Other Health Coverage Page

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
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "2500000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page

  @SLER-128 @PageTextOtherHealthInsurancePage
  Scenario: SLER-128 I Validate the page text and checkboxes on the Other Health Coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify text on the Other Health Coverage page in "English"
    And I verify the checkboxes on the Other Health Coverage page
    And I verify help icons on the Other Health Coverage page

    And I change the language from header to "Spanish"
    Then I verify text on the Other Health Coverage page in "Spanish"

    And I click on Sign Out in the Header for "Elmo"

  @SLER-237 @PageTextOtherHealthInsurancePage
  Scenario: SLER-237 I Validate the header and footer on the Other Health Coverage page
    And I validate I am on the "Elmo Other Health Coverage" page

    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"
    Then I select "None of these" as ELMO health coverage option
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"

    Then I select "None of these" as ELMO health coverage option
    And I click on Sign Out in the Header for "Elmo"



  @SLER-307 @PageTextOtherHealthInsurancePage
  Scenario: SLER-307 I can see Other Health Coverage's standard errors consistently - English
    And I validate I am on the "Elmo Other Health Coverage" page

    And I verify the text on Other Health Coverage page data in "English"
    Then I click continue on the ELMO health coverage page
    And I verify error message in "English" on the Other Health Coverage page
    And I verify the OHI info in the DB for "Primary"

    Then I select "Medicare" as ELMO health coverage option
    And I verify error message does not show for Individual Insurance page

    And I click on Sign Out in the Header for "Elmo"


  @SLER-310 @PageTextOtherHealthInsurancePage
  Scenario: SLER-310 I can see Other Health Coverage's standard errors consistently - Spanish
    And I validate I am on the "Elmo Other Health Coverage" page
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page

    And I verify the text on Other Health Coverage page data in "Spanish"
    Then I click continue on the ELMO health coverage page
    And I verify error message in "Spanish" on the Other Health Coverage page
    And I verify the OHI info in the DB for "Primary"

    Then I select "Medicare" as ELMO health coverage option
    And I verify error message does not show for Individual Insurance page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-347 @PageTextOtherHealthInsurancePage @TAMSmoke
  Scenario: SLER-347 I validate save, update and remove on Other Health Coverage are updated in the DB
    And I validate I am on the "Elmo Other Health Coverage" page

    Then I select "Health First Colorado" as ELMO health coverage option
    Then I select "CHP+" as ELMO health coverage option
    Then I select "Medicare" as ELMO health coverage option
    Then I select "job" as ELMO health coverage option
    Then I select "HRA" as ELMO health coverage option
    Then I select "Retiree Health Plan" as ELMO health coverage option
    Then I select "Peace Corps" as ELMO health coverage option
    Then I select "COBRA" as ELMO health coverage option
    Then I select "VA Health Care" as ELMO health coverage option
    Then I select "TRICARE" as ELMO health coverage option
    Then I select "Other" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click Go Back on the Elmo OHC Medicare page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         1            |      1     |         1        |     1   |            1          |     1     |       1       |        1           |             1            |            1           |   1   |
    Then I select "Health First Colorado" as ELMO health coverage option
    Then I select "CHP+" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click Go Back on the Elmo OHC Medicare page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         1            |      1     |         1        |     1   |            1          |     1     |       1       |        0           |             0            |            1           |   1   |
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |

    And I click on Sign Out in the Header for "NonElmo"




  @SLER-386 @PageTextOtherHealthInsurancePage
  Scenario: SLER-386 I validate remove Medicare on Other Health Coverage is updated in the DB
    Then I select "Medicare" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Medicare" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      1     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |
    Then I click "Yes" for currently eligible in Medicare question
    Then  I check checkbox for Part "A"
    Then I click "No" for Part "A" insurance ending in 60 days in Medicare question
    Then I enter Part A amount of "250.00"
    Then  I check checkbox for Part "B"
    Then I click "No" for Part "B" insurance ending in 60 days in Medicare question
    Then I click continue on the Elmo OHC Medicare page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |      1     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |         1        |         1        |           250.00         |           1            |              0             |              0             |

    And I click on Apply for Coverage in the "NonElmo" Header
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
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |                  |                  |                       |                        |                            |                            |

    And I click on Sign Out in the Header for "NonElmo"




  @SLER-400 @PageTextOtherHealthInsurancePage
  Scenario: SLER-400 I validate remove Individual Insurance on Other Health Coverage is updated in the DB
    Then I select "Other" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            1           |   0   |
    Then I click "Yes" for currently enrolled in Individual Insurance question
    Then I click "No" for insurance ending in 60 days in Individual Insurance question
    Then I click continue on the Elmo OHC Individual Insurance page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            1           |   0   |            1          |             0             |

    And I click on Apply for Coverage in the "NonElmo" Header
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
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |                       |                           |

    And I click on Sign Out in the Header for "NonElmo"




  @SLER-401 @PageTextOtherHealthInsurancePage
  Scenario: SLER-401 I validate remove Individual Insurance on ESI is updated in the DB
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    And I verify the OHI options selected in the DB for "Primary"
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|curr_year_esi_afford_ind3|next_year_esi_afford_ind3|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |                            |                          |                      |                         |                             |                                     |                               |                         |                         |
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "350.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    And I verify the OHI options selected in the DB for "Primary"
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|curr_year_esi_afford_ind3|next_year_esi_afford_ind3|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             0            |                      |             1           |           350.00            |                                     |                               |             0           |             0           |

    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the OHI options selected in the DB for "Primary"
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|curr_year_esi_afford_ind3|next_year_esi_afford_ind3|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            0         |                            |                          |                      |                         |                             |                                     |                               |                         |                         |

    And I click on Sign Out in the Header for "NonElmo"




  @SLER-473 @PageTextOtherHealthInsurancePage
  Scenario: SLER-473 I validate remove COBRA on Other Health Coverage is updated in the DB
    Then I select "COBRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo COBRA" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     1   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |
    Then I click "Yes" for currently enrolled in COBRA question
    Then I click "No" for insurance ending in 60 days in COBRA question
    Then I click continue on the Elmo OHC Cobra page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|cobra_enrl_covg_ind3|cobra_covg_end_soon_ind3|
      |         0            |      0     |         0        |     1   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |           1        |           0            |

    And I click on Apply for Coverage in the "NonElmo" Header
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
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|cobra_enrl_covg_ind3|cobra_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |                    |                        |

    And I click on Sign Out in the Header for "NonElmo"



  @SLER-475 @PageTextOtherHealthInsurancePage
  Scenario: SLER-475 I validate remove HRA on Other Health Coverage is updated in the DB
    Then I select "HRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo HRA" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   1   |
    Then I select Current Year year dropdown on the Elmo OHI HRA page
    Then I enter "500.00" amount on the Elmo OHI HRA page
    Then I select "QSEHRA" for HRA type
    And I validate I am on the "Elmo HRA" page
    Then I click continue on the Elmo OHI HRA page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   1   |
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2024  |   500.00    |  QSEHRA |                    |          0           |

    And I click on Apply for Coverage in the "NonElmo" Header
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
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |         |             |        |                    |                      |

    And I click on Sign Out in the Header for "NonElmo"


  @SLER-476 @PageTextOtherHealthInsurancePage
  Scenario: SLER-476 I validate remove VA Healthcare on Other Health Coverage is updated in the DB
    Then I select "VA Health Care" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi VA Healthcare" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         1        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |
    Then I click "Yes" for currently enrolled in VA Healthcare question
    Then I click "No" for insurance ending in 60 days in VA Healthcare question
    Then I click continue on the Elmo OHC VA Healthcare page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|va_enrl_covg_ind3|va_covg_end_soon_ind3|
      |         0            |      0     |         1        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |         1       |         0           |

    And I click on Apply for Coverage in the "NonElmo" Header
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
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|va_enrl_covg_ind3|va_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |                 |                     |

    And I click on Sign Out in the Header for "NonElmo"




  @SLER-477 @PageTextOtherHealthInsurancePage
  Scenario: SLER-477 I validate remove Retiree Health Plan on Other Health Coverage is updated in the DB
    Then I select "Retiree Health Plan" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Retiree" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     0   |            1          |     0     |       0       |        0           |             0            |            0           |   0   |
    Then I click "Yes" for currently enrolled in Retiree question
    Then I click "No" for insurance ending in 60 days in Retiree question
    Then I click continue on the Elmo OHC Retiree page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|retiree_enrl_covg_ind3|retiree_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            1          |     0     |       0       |        0           |             0            |            0           |   0   |            1         |            0             |

    And I click on Apply for Coverage in the "NonElmo" Header
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
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|retiree_enrl_covg_ind3|retiree_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |                      |                          |

    And I click on Sign Out in the Header for "NonElmo"




  @SLER-478 @PageTextOtherHealthInsurancePage
  Scenario: SLER-478 I validate remove TRICARE on Other Health Coverage is updated in the DB
    Then I select "TRICARE" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Tricare" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     0   |            0          |     1     |       0       |        0           |             0            |            0           |   0   |
    Then I click "Yes" for currently enrolled in Tricare question
    Then I click "No" for insurance ending in 60 days in Tricare question
    Then I click continue on the Elmo OHC Tricare page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|tricare_enrl_covg_ind3|tricare_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     1     |       0       |        0           |             0            |            0           |   0   |            1         |            0             |

    And I click on Apply for Coverage in the "NonElmo" Header
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
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|tricare_enrl_covg_ind3|tricare_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |                      |                          |

    And I click on Sign Out in the Header for "NonElmo"




  @SLER-479 @PageTextOtherHealthInsurancePage
  Scenario: SLER-479 I validate remove Peace Corps on Other Health Coverage is updated in the DB
    Then I select "Peace Corps" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Peace Corps" page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     0   |            0          |     0     |       1       |        0           |             0            |            0           |   0   |
    Then I click "Yes" for currently enrolled in Peace Corps question
    Then I click "No" for insurance ending in 60 days in Peace Corps question
    Then I click continue on the Elmo OHC Peace Corps page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|peace_corps_enrl_covg_ind3|peace_corps_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       1       |        0           |             0            |            0           |   0   |              1           |              0               |

    And I click on Apply for Coverage in the "NonElmo" Header
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
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|peace_corps_enrl_covg_ind3|peace_corps_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |                          |                              |

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-1221
  Scenario: SLER-1221 I verify that other-health-coverage portal uses common components from ng-common on the main OHC page
    Then I verify main OHC checkbox in "Not Selected" state
    And I refresh the page
    Then I verify main OHC checkbox in "Selected" state
    And I refresh the page
    Then I verify main OHC checkbox in "Focus" state
    And I refresh the page
    Then I verify main OHC checkbox in "Hover" state

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page