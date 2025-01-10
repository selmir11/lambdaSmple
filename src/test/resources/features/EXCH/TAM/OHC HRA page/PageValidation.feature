@TAM @TamExch
Feature: Page Validation-OHI HRA Elmo Page

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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "HRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo HRA" page

  @SLER-789 @PageValidationOhiHraElmo
  Scenario: SLER-789 I can see HRA's standard errors consistently - English
    And I verify the "First Section" HRA page data in "English"
    Then I click continue on the Elmo OHI HRA page
    And I verify "Plan Year" error in "English" on the HRA page
    And I verify "Amount" error in "English" on the HRA page
    And I verify "Type" error in "English" on the HRA page
    Then I select Current Year year dropdown on the Elmo OHI HRA page
    And I verify "Plan Year" error does not show for HRA page
    Then I enter "6.00" amount on the Elmo OHI HRA page
    And I verify "Amount" error does not show for HRA page
    Then I select "ICHRA" for HRA type
    And I verify "Type" error does not show for HRA page
    And I verify the "Opt Out Section" HRA page data in "English"
    Then I click continue on the Elmo OHI HRA page
    And I verify "Opt Out" error in "English" on the HRA page
    Then I select "Yes" for opt out on the Elmo OHI HRA page
    And I verify "Opt Out" error does not show for HRA page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-790 @PageValidationOhiHraElmo
  Scenario: SLER-790 I can see HRA's standard errors consistently - Spanish
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page
    And I verify the "First Section" HRA page data in "Spanish"
    Then I click continue on the Elmo OHI HRA page
    And I verify "Plan Year" error in "Spanish" on the HRA page
    And I verify "Amount" error in "Spanish" on the HRA page
    And I verify "Type" error in "Spanish" on the HRA page
    Then I select Current Year year dropdown on the Elmo OHI HRA page
    And I verify "Plan Year" error does not show for HRA page
    Then I enter "6.00" amount on the Elmo OHI HRA page
    And I verify "Amount" error does not show for HRA page
    Then I select "ICHRA" for HRA type
    And I verify "Type" error does not show for HRA page
    And I verify the "Opt Out Section" HRA page data in "Spanish"
    Then I click continue on the Elmo OHI HRA page
    And I verify "Opt Out" error in "Spanish" on the HRA page
    Then I select "Yes" for opt out on the Elmo OHI HRA page
    And I verify "Opt Out" error does not show for HRA page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-811 @PageValidationOhiHraElmo @TAMSmoke
  Scenario: SLER-811 I validate save, update and remove on HRA are updated in the DB
    And I verify year is "Not Selected", amount is "Not Selected", type is "Not Selected", "Without" APTC question "" on the HRA page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|cobra_ind|
      |         0            |      0     |         0        |            0          |     0     |       0       |        0           |             0            |            0           |   1   |    0    |
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |         |             |        |                    |                      |
    Then I select Current Year year dropdown on the Elmo OHI HRA page
    Then I enter "500.00" amount on the Elmo OHI HRA page
    Then I select "QSEHRA" for HRA type
    Then I click continue on the Elmo OHI HRA page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|cobra_ind|
      |         0            |      0     |         0        |            0          |     0     |       0       |        0           |             0            |            0           |   1   |    0    |
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    500.00   | QSEHRA |                    |          0           |

    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo HRA" page
    Then I enter "60.00" amount on the Elmo OHI HRA page
    Then I click continue on the Elmo OHI HRA page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|cobra_ind|
      |         0            |      0     |         0        |            0          |     0     |       0       |        0           |             0            |            0           |   1   |    0    |
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |     60.00   | QSEHRA |                    |          1           |

    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo HRA" page
    Then I enter "25.00" amount on the Elmo OHI HRA page
    Then I select "ICHRA" for HRA type
    Then I select "Yes" for opt out on the Elmo OHI HRA page
    Then I click continue on the Elmo OHI HRA page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|cobra_ind|
      |         0            |      0     |         0        |            0          |     0     |       0       |        0           |             0            |            0           |   1   |    0    |
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |     25.00   |  ICHRA |         1          |          1           |

    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo HRA" page
    Then I enter "25.00" amount on the Elmo OHI HRA page
    Then I select "ICHRA" for HRA type
    Then I select "Yes" for opt out on the Elmo OHI HRA page
    Then I click continue on the Elmo OHI HRA page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|cobra_ind|
      |         0            |      0     |         0        |            0          |     0     |       0       |        0           |             0            |            0           |   1   |    0    |
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |     25.00   |  ICHRA |         1          |          1           |

    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo HRA" page
    Then I enter "45.00" amount on the Elmo OHI HRA page
    Then I select "Yes" for opt out on the Elmo OHI HRA page
    Then I click continue on the Elmo OHI HRA page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|cobra_ind|
      |         0            |      0     |         0        |            0          |     0     |       0       |        0           |             0            |            0           |   1   |    0    |
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |     45.00   |  ICHRA |         1          |          1           |

    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo HRA" page
    Then I enter "500.00" amount on the Elmo OHI HRA page
    Then I click continue on the Elmo OHI HRA page
    And I verify the OHI options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|cobra_ind|
      |         0            |      0     |         0        |            0          |     0     |       0       |        0           |             0            |            0           |   1   |    0    |
    And I verify the HRA options selected in the DB
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    500.00   |  ICHRA |                    |          0           |

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-1032 @PageValidationOhiHraElmo
  Scenario: SLER-1032 I validate HRA data is saved in Application History DB
    Then I select Current Year year dropdown on the Elmo OHI HRA page
    Then I enter "6.00" amount on the Elmo OHI HRA page
    Then I select "ICHRA" for HRA type
    Then I select "Yes" for opt out on the Elmo OHI HRA page
    Then I click continue on the Elmo OHI HRA page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    And I verify the HRA options selected in the DB after Application Results
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    6.00     |  ICHRA |         1          |          1           |

    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo HRA" page
    Then I enter "575.65" amount on the Elmo OHI HRA page
    Then I select "QSEHRA" for HRA type
    Then I click continue on the Elmo OHI HRA page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    And I verify the HRA options selected in the DB after Application Results
      |plan_year|emplr_hra_ctb|hra_type|emplr_ctb_optout_ind|hra_not_affordable_ind|
      |   2025  |    575.65   | QSEHRA |                    |            0         |

    And I click on Sign Out in the Header for "NonElmo"


