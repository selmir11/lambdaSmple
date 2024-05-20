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
  Scenario: SLER-128 I Validate the page text and checkboxes on the Other Health Insurance page
    And I change the C4 url to "Elmo Other Health Insurance Page"
    And I validate I am on the "Elmo Other Health Insurance" page
    And I verify text on the Other Health Insurance page in "English"
    And I verify the checkboxes on the Other Health Insurance page
    And I verify help icons on the Other Health Insurance page

    And I change the language from header to "Spanish"
    Then I verify text on the Other Health Insurance page in "Spanish"

    And I click on Sign Out in the Header for "Elmo"

  @SLER-237 @PageTextOtherHealthInsurancePage
  Scenario: SLER-237 I Validate the header and footer on the Other Health Insurance page
    And I change the C4 url to "Elmo Other Health Insurance Page"
    And I validate I am on the "Elmo Other Health Insurance" page

    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"
    Then I select "None of these" as ELMO health insurance option
    And I change the language from header to "Spanish"
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"

    Then I select "None of these" as ELMO health insurance option
    And I click on Sign Out in the Header for "Elmo"



  @SLER-307 @PageTextOtherHealthInsurancePage
  Scenario: SLER-307 I can see Other Health Insurance's standard errors consistently - English
    And I change the C4 url to "Elmo Other Health Insurance Page"
    And I validate I am on the "Elmo Other Health Insurance" page

    And I verify the text on Other Health Insurance page data in "English"
    Then I click continue on the ELMO health insurance page
    And I verify error message in "English" on the Other Health Insurance page
    And I verify the OHI info in the DB

    Then I select "Medicare" as ELMO health insurance option
    And I verify error message does not show for Individual Insurance page

    And I click on Sign Out in the Header for "Elmo"


  @SLER-310 @PageTextOtherHealthInsurancePage
  Scenario: SLER-310 I can see Other Health Insurance's standard errors consistently - Spanish
    And I change the C4 url to "Elmo Other Health Insurance Page"
    And I validate I am on the "Elmo Other Health Insurance" page
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page

    And I verify the text on Other Health Insurance page data in "Spanish"
    Then I click continue on the ELMO health insurance page
    And I verify error message in "Spanish" on the Other Health Insurance page
    And I verify the OHI info in the DB

    Then I select "Medicare" as ELMO health insurance option
    And I verify error message does not show for Individual Insurance page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-347 @PageTextOtherHealthInsurancePage
  Scenario: SLER-347 I validate save, update and remove on Other Health Insurance are updated in the DB
    And I change the C4 url to "Elmo Other Health Insurance Page"
    And I validate I am on the "Elmo Other Health Insurance" page

    Then I select "Health First Colorado" as ELMO health insurance option
    Then I select "CHP+" as ELMO health insurance option
    Then I select "Medicare" as ELMO health insurance option
    Then I select "job" as ELMO health insurance option
    Then I select "HRA" as ELMO health insurance option
    Then I select "Retiree Health Plan" as ELMO health insurance option
    Then I select "Peace Corps" as ELMO health insurance option
    Then I select "COBRA" as ELMO health insurance option
    Then I select "VA Health Care" as ELMO health insurance option
    Then I select "TRICARE" as ELMO health insurance option
    Then I select "Other" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "Elmo Other Health Insurance" page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         1            |      1     |         1        |     1   |            1          |     1     |       1       |        1           |             1            |            1           |   1   |
    Then I select "Health First Colorado" as ELMO health insurance option
    Then I select "CHP+" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "Elmo Other Health Insurance" page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         1            |      1     |         1        |     1   |            1          |     1     |       1       |        0           |             0            |            1           |   1   |
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "Elmo Other Health Insurance" page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |

    And I click on Sign Out in the Header for "Elmo"




  @SLER-386 @PageTextOtherHealthInsurancePage
  Scenario: SLER-386 I validate remove Medicare on Other Health Insurance is updated in the DB
    Then I select "Medicare" as health insurance option and continue
    And I change the C4 url to "Elmo Ohi Medicare Page"
    And I validate I am on the "Elmo Ohi Medicare" page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      1     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |
    Then I click "Yes" for currently eligible in Medicare question
    Then  I check checkbox for Part "A"
    Then I click "No" for Part "A" insurance ending in 60 days in Medicare question
    Then I enter Part A amount of "250.00"
    Then  I check checkbox for Part "B"
    Then I click "No" for Part "B" insurance ending in 60 days in Medicare question
    Then I click continue on the Elmo OHI Medicare page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |      1     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |         1        |         1        |           250.00         |           1            |              0             |              0             |

    And I click on Apply for Coverage in the "Elmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Citizenship page
    And I click on the table dropdown
    And I click the edit income 1
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I change the C4 url to "Elmo Other Health Insurance Page"
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|medicare_parta_ind|medicare_partb_ind|medicare_premium_amount|medicare_prem_parta_ind3|medicare_parta_end_soon_ind3|medicare_partb_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |                  |                  |                       |                        |                            |                            |

    And I click on Sign Out in the Header for "Elmo"




  @SLER-400 @PageTextOtherHealthInsurancePage
  Scenario: SLER-400 I validate remove Individual Insurance on Other Health Insurance is updated in the DB
    Then I select "Individual Insurance" as health insurance option and continue
    And I change the C4 url to "Elmo Ohi Individual Insurance Page"
    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            1           |   0   |
    Then I click "Yes" for currently enrolled in Individual Insurance question
    Then I click "No" for insurance ending in 60 days in Individual Insurance question
    Then I click continue on the Elmo OHI Individual Insurance page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            1           |   0   |            1          |             0             |

    And I click on Apply for Coverage in the "Elmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Citizenship page
    And I click on the table dropdown
    And I click the edit income 1
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I change the C4 url to "Elmo Other Health Insurance Page"
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|indv_ins_enrl_covg_ind3|indv_ins_covg_end_soon_ind3|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |                       |                           |

    And I click on Sign Out in the Header for "Elmo"




  @SLER-401 @PageTextOtherHealthInsurancePage
  Scenario: SLER-401 I validate remove Individual Insurance on ESI is updated in the DB
    Then I select "ESI" as health insurance option and continue
    And I validate I am on the "ESI" page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|
      |         1            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |
    Then I select the employer on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "350.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_coverage_end_soon_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         1            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |            0             |             1           |            350.00           |

    And I click on the table dropdown
    And I click the edit income 1
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I change the C4 url to "Elmo Other Health Insurance Page"
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    And I verify the OHI options selected in the DB
      |emp_sponsored_covg_ind|medicare_ind|va_health_care_ind|cobra_ind|retiree_health_plan_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_coverage_end_soon_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|
      |         0            |      0     |         0        |     0   |            0          |     0     |       0       |        0           |             0            |            0           |   0   |                          |                         |                             |

    And I click on Sign Out in the Header for "Elmo"

