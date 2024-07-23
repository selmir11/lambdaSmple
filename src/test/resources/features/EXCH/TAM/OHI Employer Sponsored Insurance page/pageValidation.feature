@TAM
Feature: Page Text-Other Health Insurance Page

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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter member details with "10101975" date of birth
    And I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Spouse" as relationship option
    And I select "Yes" to Is Member Applying
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter member details with "10102001" date of birth
    And I select "Male" as sex option
    And I select "Son" as relationship option
    And I select "Son" as relationship one option
    And I select "Yes" to Is Member Applying
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    Then I select "No" for Foster care in state of Colorado
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
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
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    Then I select "Yes" to claim dependents
    And I select the "2" option for Who Will Claim as Dependents
    And I click save and continue on tax status page
    Then I select "job" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page

  @SLER-239 @PageTextOtherHealthInsurancePage
  Scenario: SLER-239 I Validate saved data on the ESI page for multiple members
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "250.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I click "No" for offer family plans question
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    And I click on Apply for Coverage in the "Elmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Citizenship page
    And I click on the table dropdown 1
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health insurance page
#Step 1
    And I validate I am on the "ESI" page
    And I verify offer family health plans is "No" on the ESI page
#Step 2
    Then I click continue on the ESI page
#Step 3
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as health insurance option
#Step 4
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify offer family health plans is "No" on the ESI page
    Then I click "Yes" for offer family plans question
    Then I enter "650.00" for offer family amount question
    Then I click enrollment status for the members
      |   enrollmentStatus    |
      |      Enrolled         |
      |      Offered          |
#Step 5
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as health insurance option
#Step 6
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify offer family health plans is "Yes" on the ESI page
    And I verify offered family amount is "650.00" on the ESI page
    Then I verify enrollment status for the members
      |   enrollmentStatus    |
      |      Enrolled         |
      |      Offered          |
#Step 7
    Then I enter "800.00" for offer family amount question
    Then I click enrollment status for the members
      |   enrollmentStatus    |
      |      Offered          |
      |      No Option        |
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify offer family health plans is "Yes" on the ESI page
    And I verify offered family amount is "800.00" on the ESI page
    Then I verify enrollment status for the members
      |   enrollmentStatus    |
      |      Offered          |
      |      No Option        |

    And I click on Sign Out in the Header for "Elmo"



  @SLER-341 @PageValidationOhiEsiElmo
  Scenario: SLER-341 I can see ESI's standard errors consistently - English
    And I verify the "No Job Section" ESI page data in "English"
    Then I click continue on the ESI page
    And I verify "Which Job" error in "English" on the ESI page
    Then I select the "0" employer for "Primary" member on the ESI page
    And I verify "Which Job" error does not show for ESI page

    And I verify the "Job Section" ESI page data in "English"
    Then I click continue on the ESI page
    And I verify "Min Value" error in "English" on the ESI page
    And I verify "Amount" error in "English" on the ESI page
    And I verify "Currently Enrolled" error in "English" on the ESI page
    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    And I verify "Min Value" error does not show for ESI page
    Then I enter "200.00" for employee amount question on the ESI page
    And I verify "Amount" error does not show for ESI page
    Then I select the Are you currently enrolled "No" button on the ESI page
    And I verify "Currently Enrolled" error does not show for ESI page

    Then I select the Are you currently enrolled "Yes" button on the ESI page
    And I verify the "Currently Enrolled Section" ESI page data in "English"
    Then I click continue on the ESI page
    And I verify "Insurance Ending" error in "English" on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    And I verify "Insurance Ending" error does not show for ESI page

    Then I select the Will Insurance End "Yes" button on the ESI page
    And I verify the "Currently Enrolled Ending Section" ESI page data in "English"
    Then I click continue on the ESI page
    And I verify "Input Date" error in "English" on the ESI page
    Then I enter the end date as "Prior Month" on the ESI page
    Then I click continue on the ESI page
    And I verify "Input Date" error in "English Prior" on the ESI page
    Then I enter the end date as "Future Month" on the ESI page
    Then I click continue on the ESI page
    And I verify "Input Date" error in "English Future" on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    And I verify "Input Date" error does not show for ESI page
    And I verify "Voluntary End" error in "English" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    And I verify "Voluntary End" error does not show for ESI page

    And I click on Sign Out in the Header for "Elmo"


  @SLER-342 @PageValidationOhiEsiElmo
  Scenario: SLER-342 I can see ESI's standard errors consistently - Spanish
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page
    And I verify the "No Job Section" ESI page data in "Spanish"
    Then I click continue on the ESI page
    And I verify "Which Job" error in "Spanish" on the ESI page
    Then I select the "0" employer for "Primary" member on the ESI page
    And I verify "Which Job" error does not show for ESI page

    And I verify the "Job Section" ESI page data in "Spanish"
    Then I click continue on the ESI page
    And I verify "Min Value" error in "Spanish" on the ESI page
    And I verify "Amount" error in "Spanish" on the ESI page
    And I verify "Currently Enrolled" error in "Spanish" on the ESI page
    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    And I verify "Min Value" error does not show for ESI page
    Then I enter "200.00" for employee amount question on the ESI page
    And I verify "Amount" error does not show for ESI page
    Then I select the Are you currently enrolled "No" button on the ESI page
    And I verify "Currently Enrolled" error does not show for ESI page

    Then I select the Are you currently enrolled "Yes" button on the ESI page
    And I verify the "Currently Enrolled Section" ESI page data in "Spanish"
    Then I click continue on the ESI page
    And I verify "Insurance Ending" error in "Spanish" on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    And I verify "Insurance Ending" error does not show for ESI page

    Then I select the Will Insurance End "Yes" button on the ESI page
    And I verify the "Currently Enrolled Ending Section" ESI page data in "Spanish"
    Then I click continue on the ESI page
    And I verify "Input Date" error in "Spanish" on the ESI page
    Then I enter the end date as "Prior Month" on the ESI page
    Then I click continue on the ESI page
    And I verify "Input Date" error in "Spanish Prior" on the ESI page
    Then I enter the end date as "Future Month" on the ESI page
    Then I click continue on the ESI page
    And I verify "Input Date" error in "Spanish Future" on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    And I verify "Input Date" error does not show for ESI page
    And I verify "Voluntary End" error in "Spanish" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    And I verify "Voluntary End" error does not show for ESI page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-723 @PageValidationOhiEsiElmo
  Scenario: SLER-723 I validate save, update and remove on ESI are updated in the DB
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |                            |                          |                      |                         |                             |                                     |                               |

    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "220.03" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I click "No" for offer family plans question
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             1            |          1           |           1             |           220.03            |                     0               |                               |

    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "80.95" for employee amount question on the ESI page
    Then I enter the end date as "Today" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             1            |          0           |           0             |            80.95            |                     0               |                               |

    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    Then I enter "111.46" for employee amount question on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I click "Yes" for offer family plans question
    Then I enter "650.00" for offer family amount question
    Then I click enrollment status for the members
      |   enrollmentStatus    |
      |      Enrolled         |
      |      Offered          |
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             1            |          1           |           2             |           111.46            |                     1               |            650.00             |

    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "73.03" for employee amount question on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I enter "325.27" for offer family amount question
    Then I click enrollment status for the members
      |   enrollmentStatus    |
      |      No Option        |
      |      Offered          |
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             0            |                      |           1             |            73.03            |                     1               |            325.27             |

    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "230.01" for employee amount question on the ESI page
    Then I enter "700.00" for offer family amount question
    Then I click enrollment status for the members
      |   enrollmentStatus    |
      |      No Option        |
      |      No Option        |
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             0            |                      |           0             |           230.01            |                     1               |             700.00            |

    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    Then I enter "120.87" for employee amount question on the ESI page
    Then I enter "456.45" for offer family amount question
    Then I click enrollment status for the members
      |   enrollmentStatus    |
      |      Enrolled         |
      |      Enrolled         |
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             0            |                      |           2             |           120.87            |                     1               |            456.45             |

    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "221.03" for employee amount question on the ESI page
    Then I enter "963.45" for offer family amount question
    Then I click enrollment status for the members
      |   enrollmentStatus    |
      |      Offered          |
      |      Offered          |
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             1              |             0            |                      |           1             |           221.03            |                     1               |           963.45              |

    Then I enter "506.03" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click "No" for offer family plans question
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             0              |                          |                      |           1             |           506.03            |                   0                 |                               |

    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "257.00" for employee amount question on the ESI page
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             0              |                          |                      |           0             |           257.00            |                   0                 |                               |

    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    Then I enter "475.00" for employee amount question on the ESI page
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click Go back on the ELMO health insurance page
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page
    And I verify the OHI options selected in the DB
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|
      |         0             |      0     |         0        |     0   |     0     |       0       |        0           |             0            |            0           |   0   |            1         |             0              |                          |                      |           2             |           475.00            |                   0                 |                               |





    And I click on Sign Out in the Header for "Elmo"
    


