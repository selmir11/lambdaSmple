@TAM @TamExch
Feature: Page Navigation-OHC ESI Page

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
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2500000" at frequency "Annually"
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
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page


  @SLER-687 @PageNavigationESI
  Scenario: SLER-687 The 'Find Expert Assistance' link stops working when navigate back to the error and unauthorized pages in OHC Portal, Exchange
    #Step1
    And I change the C4 url to "Other Health Coverage portal Error Exch"
    Then I validate I am on the "Error" page
    And I click Back to Welcome page Button on error Exch page
    Then I click Go Back button from chrome browser
    And I verify User name Link is displayed in the "Exch" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page
    #Step2
    And I click on Apply for Coverage in the "ExpertHelp" Header
    Then I validate I am on the "Account Overview" page
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
    And I click on "Primary" to edit information from household page
    Then I select the Edit Income link
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I click the save and continue button on the Income Summary Detail page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "ESI" page
    And I change the C4 url to "Other Health Coverage portal Unauthorized Exch"
    And I click on Apply for Coverage in the "Elmo" Header
    Then I click Go Back button from chrome browser
    And I verify User name Link is displayed in the "Exch" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page

    And I click on Sign Out in the Header for "WhoHelpsYouPage"
    Then I validate I am on the "Login" page

  @SLER-958 @PageTextESI
  Scenario: SLER-958 Delete employer from Employer Summary and ESI is removed from DB
    Then I select the Go Back button on the ESI page
    Then I click Go back on the ELMO health coverage page
    And I click on "Primary" to edit information from household page
    Then I select the Edit Income link
    And I validate I am on the "Employment Summary" page
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "4500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I select "Health First Colorado" as ELMO health coverage option
    Then I select "CHP+" as ELMO health coverage option
    Then I select "COBRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "250.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    Then I click "Yes" for currently enrolled in COBRA question
    Then I click "No" for insurance ending in 60 days in COBRA question
    Then I click continue on the Elmo OHC Cobra page
    And I click on "Primary" to edit information from household page
    Then I select the Edit Income link

    And I validate I am on the "Employment Summary" page
    And I verify the OHC options selected in the DB for "Primary"
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|cobra_enrl_covg_ind3|cobra_covg_end_soon_ind3|cobra_end_voluntary_ind3|curr_year_esi_afford_ind3|next_year_esi_afford_ind3|
      |         0             |      0     |         0        |     1   |     0     |       0       |        1           |             1            |            0           |   0   |            1         |             1              |            0             |                      |           1             |           250.00            |                                     |                               |        1           |            0           |                        |             1           |             1           |
    Then I click on Remove job "Second" entered for Primary on the Employment Summary Page
    And I verify the OHC options selected in the DB for "Primary"
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|cobra_enrl_covg_ind3|cobra_covg_end_soon_ind3|cobra_end_voluntary_ind3|curr_year_esi_afford_ind3|next_year_esi_afford_ind3|
      |         0             |      0     |         0        |     1   |     0     |       0       |        1           |             1            |            0           |   0   |            0         |                            |                          |                      |                         |                             |                                     |                               |        1           |            0           |                        |                         |                         |
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate Other Health Coverage options load "Medicaid, CHP+, COBRA"

    And I click on Sign Out in the Header for "Elmo"

  @SLER-963 @PageTextESI
  Scenario: SLER-963 Delete employer from Employer Summary and ESI is not removed from DB
    Then I select the Go Back button on the ESI page
    Then I click Go back on the ELMO health coverage page
    And I click on "Primary" to edit information from household page
    Then I select the Edit Income link
    And I validate I am on the "Employment Summary" page
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "4500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I select "Health First Colorado" as ELMO health coverage option
    Then I select "CHP+" as ELMO health coverage option
    Then I select "COBRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "250.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    Then I click "Yes" for currently enrolled in COBRA question
    Then I click "No" for insurance ending in 60 days in COBRA question
    Then I click continue on the Elmo OHC Cobra page
    And I click on "Primary" to edit information from household page
    Then I select the Edit Income link

    And I validate I am on the "Employment Summary" page
    And I verify the OHC options selected in the DB for "Primary"
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|cobra_enrl_covg_ind3|cobra_covg_end_soon_ind3|cobra_end_voluntary_ind3|curr_year_esi_afford_ind3|next_year_esi_afford_ind3|
      |         0             |      0     |         0        |     1   |     0     |       0       |        1           |             1            |            0           |   0   |            1         |             1              |            0             |                      |           1             |           250.00            |                                     |                               |        1           |            0           |                        |             1           |             1           |
    Then I click on Remove job "First" entered for Primary on the Employment Summary Page
    And I validate I am on the "Employment Summary" page
    And I verify the OHC options selected in the DB for "Primary"
      |retiree_health_plan_ind|medicare_ind|va_health_care_ind|cobra_ind|tricare_ind|peace_corps_ind|health_plus_plan_ind|child_health_plan_plus_ind|individual_insurance_ind|hra_ind|emp_sponsored_covg_ind|enrl_emp_sponsored_covg_ind3|emp_coverage_end_soon_ind3|emp_end_voluntary_ind3|emp_coverage_min_std_ind3|emp_coverage_monthly_prem_amt|emp_coverage_family_plan_offered_ind3|emp_coverage_family_prem_amount|cobra_enrl_covg_ind3|cobra_covg_end_soon_ind3|cobra_end_voluntary_ind3|curr_year_esi_afford_ind3|next_year_esi_afford_ind3|
      |         0             |      0     |         0        |     1   |     0     |       0       |        1           |             1            |            0           |   0   |            1         |             1              |            0             |                      |           1             |           250.00            |                                     |                               |        1           |            0           |                        |             1           |             1           |
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    And I validate Other Health Coverage options load "Medicaid, CHP+, ESI, COBRA"

    And I click on Sign Out in the Header for "Elmo"



  @SLER-964 @PageVerificationEsiPage
  Scenario: SLER-964 I need navigation functionality to enter and exit the ELMO OHC application to the ELMO Exch ESI page
    Then I select the Go Back button on the ESI page
    Then I select "HRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I select the Go Back button on the ESI page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "250.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    And I validate I am on the "Elmo HRA" page
    Then I click Go Back on the Elmo OHC HRA page
    And I validate I am on the "ESI" page
    Then I select the Go Back button on the ESI page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "HRA" as ELMO health coverage option
    Then I select "Medicare" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohc Medicare" page
    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    Then I enter Part A amount of "150.00"
    Then I click "No" for Part "A" insurance ending in 60 days in Medicare question
    Then I click continue on the Elmo OHC Medicare page
    And I validate I am on the "ESI" page
    Then I select the Go Back button on the ESI page
    And I validate I am on the "Elmo Ohc Medicare" page
    Then I click continue on the Elmo OHC Medicare page
    And I validate I am on the "ESI" page
    Then I click continue on the ESI page
    And I validate I am on the "Family Overview" page

    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "04161981", "Female" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    And I click on "Spouse" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "Medicare" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I click "No" for offer family plans question
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click Go back on the ELMO health coverage page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"

    And I click on Sign Out in the Header for "Elmo"

  @SLER-2064
  Scenario: SLER-2064 I want to be directed to the unauthorized page so that I know I have tried to access a page I am not authorized to access
#    check in English and change to Spanish
    And I validate I am on the "ESI" page
    And I change the C4 url to "Other Health Coverage portal Unauthorized Exch"
    Then I validate I am on the "Unauthorized" page
    Then I verify unauthorized text in "English"
    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"
    And I set the browser resolution to 1200 x 800
    And I change the language from header to "Spanish"
    And I set the browser resolution to Maximized
    Then I wait for 50 milliseconds
    Then I verify unauthorized text in "Spanish"
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
#    check in Spanish and change to English
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
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I change the C4 url to "Other Health Coverage portal Unauthorized Exch"
    Then I validate I am on the "Unauthorized" page
    Then I verify unauthorized text in "Spanish"
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I set the browser resolution to 1200 x 800
    And I change the language from header to "English"
    And I set the browser resolution to Maximized
    Then I wait for 50 milliseconds
    Then I verify unauthorized text in "English"
    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page