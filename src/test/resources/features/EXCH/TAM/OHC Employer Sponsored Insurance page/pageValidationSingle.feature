@TAM
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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
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
    Then I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page

  @SLER-1035 @PageValidationOhiEsiElmo
  Scenario: SLER-1035 I validate save, update and remove on ESI are updated in the DB
#    Step 1
    And I verify the header for Primary Member on the ESI page in "English"
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "220.03" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I click continue on the ESI page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
#    Step 2
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             1            |          1           |           1             |           220.03            |
#    Step 3
    And I verify "Min Value" is "Yes" on the ESI page
    And I verify "Amount" is "220.03" on the ESI page
    And I verify "Currently Enrolled" is "Yes" on the ESI page
    And I verify "Insurance Ending" is "Yes" on the ESI page
    And I verify "Input Date" is "Current Month" on the ESI page
    And I verify "Voluntary End" is "Yes" on the ESI page
#    Step 4
    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "80.95" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Today" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I click continue on the ESI page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
#    Step 5
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             1            |          0           |           0             |           80.95             |
#    Step 6
    And I verify "Min Value" is "No" on the ESI page
    And I verify "Amount" is "80.95" on the ESI page
    And I verify "Currently Enrolled" is "Yes" on the ESI page
    And I verify "Insurance Ending" is "Yes" on the ESI page
    And I verify "Input Date" is "Today" on the ESI page
    And I verify "Voluntary End" is "No" on the ESI page
#    Step 7
    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    Then I enter "111.46" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I click continue on the ESI page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
#    Step 8
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             1            |          0           |           2             |           111.46            |
#    Step 9
    And I verify "Min Value" is "I don't know" on the ESI page
    And I verify "Amount" is "111.46" on the ESI page
    And I verify "Currently Enrolled" is "Yes" on the ESI page
    And I verify "Insurance Ending" is "Yes" on the ESI page
    And I verify "Input Date" is "Current Month" on the ESI page
    And I verify "Voluntary End" is "No" on the ESI page
#    Step 10
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "73.03" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
#    Step 11
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |            0             |                      |             1           |           73.03             |
#    Step 12
    And I verify "Min Value" is "Yes" on the ESI page
    And I verify "Amount" is "73.03" on the ESI page
    And I verify "Currently Enrolled" is "Yes" on the ESI page
    And I verify "Insurance Ending" is "No" on the ESI page
#    Step 13
    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "230.01" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
#    Step 14
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             0            |                      |           0             |           230.01            |
#    Step 15
    And I verify "Min Value" is "No" on the ESI page
    And I verify "Amount" is "230.01" on the ESI page
    And I verify "Currently Enrolled" is "Yes" on the ESI page
    And I verify "Insurance Ending" is "No" on the ESI page
#    Step 16
    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    Then I enter "120.87" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
#    Step 17
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             0            |                      |           2             |           120.87            |
#    Step 18
    And I verify "Min Value" is "I don't know" on the ESI page
    And I verify "Amount" is "120.87" on the ESI page
    And I verify "Currently Enrolled" is "Yes" on the ESI page
    And I verify "Insurance Ending" is "No" on the ESI page
#    Step 19
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "221.03" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
#    Step 20
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             0            |                      |           1             |           221.03            |
#    Step 21
    And I verify "Min Value" is "Yes" on the ESI page
    And I verify "Amount" is "221.03" on the ESI page
    And I verify "Currently Enrolled" is "Yes" on the ESI page
    And I verify "Insurance Ending" is "No" on the ESI page
#    Step 22
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "506.03" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click continue on the ESI page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
#    Step 23
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             0              |                          |                      |           1             |           506.03            |
#    Step 24
    And I verify "Min Value" is "Yes" on the ESI page
    And I verify "Amount" is "506.03" on the ESI page
    And I verify "Currently Enrolled" is "No" on the ESI page
#    Step 25
    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "257.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click continue on the ESI page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
#    Step 26
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             0              |                          |                      |           0             |           257.00            |
#    Step 27
    And I verify "Min Value" is "No" on the ESI page
    And I verify "Amount" is "257.00" on the ESI page
    And I verify "Currently Enrolled" is "No" on the ESI page
#    Step 28
    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    Then I enter "475.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click continue on the ESI page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
#    Step 29
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             0              |                          |                      |           2             |           475.00            |
#    Step 30
    And I verify "Min Value" is "I don't know" on the ESI page
    And I verify "Amount" is "475.00" on the ESI page
    And I verify "Currently Enrolled" is "No" on the ESI page

    And I click on Sign Out in the Header for "Elmo"



