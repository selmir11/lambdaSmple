@TAM @TamExch
Feature: Page Validation-OHC Individual Insurance Elmo Page

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
    Then I select "Other" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Individual Insurance" page

  @SLER-260 @PageValidationOhcIndividualInsuranceElmo
  Scenario: SLER-260 I can see Individual Insurance's standard errors consistently - English
    And I verify the "First Section" Individual Insurance page data in "English"
    Then I click continue on the OHC Individual Insurance page
    And I verify "Currently Enrolled" error in "English" on the Individual Insurance page
    Then I click "Yes" for currently enrolled in Individual Insurance question
    And I verify "Currently Enrolled" error does not show for Individual Insurance page

    And I verify the "Second Section" Individual Insurance page data in "English"
    Then I click continue on the OHC Individual Insurance page
    And I verify "Insurance Ending" error in "English" on the Individual Insurance page
    Then I click "Yes" for insurance ending in 60 days in Individual Insurance question
    And I verify "Insurance Ending" error does not show for Individual Insurance page

    Then I click continue on the OHC Individual Insurance page
    And I verify "Input Date" error in "English" on the Individual Insurance page
    Then I enter the end date as "Prior Month" on the Individual Insurance page
    Then I click continue on the OHC Individual Insurance page
    And I verify "Input Date" error in "English Prior" on the Individual Insurance page
    Then I enter the end date as "Future Month" on the Individual Insurance page
    Then I click continue on the OHC Individual Insurance page
    And I verify "Input Date" error in "English Future" on the Individual Insurance page
    Then I enter the end date as "Current Month" on the Individual Insurance page
    And I verify "Voluntary End" error in "English" on the Individual Insurance page
    Then I click "No" for insurance ending voluntary for Individual Insurance question
    And I verify "Voluntary End" error does not show for Individual Insurance page


    And I click on Sign Out in the Header for "Elmo"

    
  @SLER-306 @PageValidationOhcIndividualInsuranceElmo
  Scenario: SLER-306 I can see Individual Insurance's standard errors consistently - Spanish
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page
    And I verify the "First Section" Individual Insurance page data in "Spanish"
    Then I click continue on the OHC Individual Insurance page
    And I verify "Currently Enrolled" error in "Spanish" on the Individual Insurance page
    Then I click "Yes" for currently enrolled in Individual Insurance question
    And I verify "Currently Enrolled" error does not show for Individual Insurance page

    And I verify the "Second Section" Individual Insurance page data in "Spanish"
    Then I click continue on the OHC Individual Insurance page
    And I verify "Insurance Ending" error in "Spanish" on the Individual Insurance page
    Then I click "Yes" for insurance ending in 60 days in Individual Insurance question
    And I verify "Insurance Ending" error does not show for Individual Insurance page

    Then I click continue on the OHC Individual Insurance page
    And I verify "Input Date" error in "Spanish" on the Individual Insurance page
    Then I enter the end date as "Prior Month" on the Individual Insurance page
    Then I click continue on the OHC Individual Insurance page
    And I verify "Input Date" error in "Spanish Prior" on the Individual Insurance page
    Then I enter the end date as "Future Month" on the Individual Insurance page
    Then I click continue on the OHC Individual Insurance page
    And I verify "Input Date" error in "Spanish Future" on the Individual Insurance page
    Then I enter the end date as "Current Month" on the Individual Insurance page
    And I verify "Voluntary End" error in "Spanish" on the Individual Insurance page
    Then I click "No" for insurance ending voluntary for Individual Insurance question
    And I verify "Voluntary End" error does not show for Individual Insurance page


    And I click on Sign Out in the Header for "Elmo"

  @SLER-719 @PageValidationOhcIndividualInsuranceElmo @TAMSmokeExch
  Scenario: SLER-719 I validate save, update and remove on Individual Insurance are updated in the DB
    And I verify Currently Enrolled is "Not Selected" on the Individual Insurance page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|retiree_health_plan_ind|hra_ind|individual_insurance_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|indv_ins_end_voluntary_ind3|
      |         0            |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0          |   0   |            1           |                       |                           |                           |
    Then I click "Yes" for currently enrolled in Individual Insurance question
    Then I click continue on the OHC Individual Insurance page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|retiree_health_plan_ind|hra_ind|individual_insurance_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|indv_ins_end_voluntary_ind3|
      |         0            |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0          |   0   |             1          |                      |                           |                           |
    Then I click "No" for currently enrolled in Individual Insurance question
    Then I click continue on the OHC Individual Insurance page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|retiree_health_plan_ind|hra_ind|individual_insurance_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|indv_ins_end_voluntary_ind3|
      |         0            |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0          |   0   |             1          |          0           |                           |                           |
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Individual Insurance" page
    Then I click "Yes" for currently enrolled in Individual Insurance question
    Then I click "Yes" for insurance ending in 60 days in Individual Insurance question
    Then I click continue on the OHC Individual Insurance page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|retiree_health_plan_ind|hra_ind|individual_insurance_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|indv_ins_end_voluntary_ind3|
      |         0            |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0          |   0   |             1          |          0           |                           |                           |
    Then I click "No" for insurance ending in 60 days in Individual Insurance question
    Then I click continue on the OHC Individual Insurance page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|retiree_health_plan_ind|hra_ind|individual_insurance_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|indv_ins_end_voluntary_ind3|
      |         0            |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0          |   0   |             1          |          1           |             0             |                           |
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Individual Insurance" page
    Then I click "Yes" for insurance ending in 60 days in Individual Insurance question
    Then I enter the end date as "Current Month" on the Individual Insurance page
    Then I click "No" for insurance ending voluntary for Individual Insurance question
    Then I click continue on the OHC Individual Insurance page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|retiree_health_plan_ind|hra_ind|individual_insurance_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|indv_ins_end_voluntary_ind3|
      |         0            |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0          |   0   |             1          |          1           |             1             |               0           |
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Individual Insurance" page
    Then I click "Yes" for insurance ending voluntary for Individual Insurance question
    Then I click continue on the OHC Individual Insurance page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|retiree_health_plan_ind|hra_ind|individual_insurance_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|indv_ins_end_voluntary_ind3|
      |         0            |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0          |   0   |             1          |          1           |             1             |               1           |
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Individual Insurance" page
    Then I click "No" for insurance ending in 60 days in Individual Insurance question
    Then I click continue on the OHC Individual Insurance page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|retiree_health_plan_ind|hra_ind|individual_insurance_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|indv_ins_end_voluntary_ind3|
      |         0            |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0          |   0   |             1          |          1           |             0             |                           |
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Individual Insurance" page
    Then I click "No" for currently enrolled in Individual Insurance question
    Then I click continue on the OHC Individual Insurance page
    And I verify the OHC options selected in the DB for "Primary"
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|retiree_health_plan_ind|hra_ind|individual_insurance_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|indv_ins_end_voluntary_ind3|
      |         0            |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0          |   0   |             1          |          0           |                           |                           |

    And I click on Sign Out in the Header for "NonElmo"
