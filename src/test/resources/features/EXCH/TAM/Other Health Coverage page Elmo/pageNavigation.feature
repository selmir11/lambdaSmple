@TAM @TamExch
Feature: Secondary User-Other Health Coverage Elmo Page

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
    And I click continue on the Citizenship page

  @SLER-966 @PageNavigationOtherHealthCoveragePage
  Scenario: SLER-966 I need navigation functionality so I am navigated back to NES and the Family Overview
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
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    And I Apply for financial help
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
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
#Step 2
    Then I click Go back on the ELMO health coverage page
    And I validate I am on the "Family Overview" page
#Step 3
    And I click on "Spouse" to edit information from household page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Family Overview" page
#Step 4
    And I click on "Spouse" to edit information from household page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Family Overview" page
#Step 5
    And I click on "Spouse" to edit information from household page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "Health First Colorado" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Family Overview" page

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-967 @PageNavigationOtherHealthCoveragePage
  Scenario: SLER-967 I need navigation functionality so I am navigated to the correct page based on my OHI selections and family members
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
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Kid", "08062022", "Female" and applying "Yes"
      | Primary:Daughter |
      | Spouse:Daughter  |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Kid"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    And I Apply for financial help
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
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "Yes" to claim dependents
    And I select the "2" option for Who Will Claim as Dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
#Step 1
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
#Step 2
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
#Step 3
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Family Overview" page
#Step 4
    And I click on "Primary" to edit information from household page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I click the save and continue button on the Income Summary Detail page
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "Health First Colorado" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
#Step 5
    Then I click Go back on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
#Step 6
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "Health First Colorado" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
#Step 7
    Then I click Go back on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
#Step 8
    Then I click Go back on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "HRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo HRA" page
#Step 9
    Then I click Go Back on the Elmo OHI HRA page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "HRA" as ELMO health coverage option
#Step 10
    Then I select "Retiree Health Plan" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Retiree" page

    Then I click Go Back on the Elmo OHC Retiree page
    Then I select "Retiree Health Plan" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
#Step 11
    Then I select "TRICARE" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Tricare" page
#Step 12
    Then I click Go Back on the Elmo OHC Tricare page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Tricare" page
#Step 13
    Then I click Go Back on the Elmo OHC Tricare page
    Then I select "TRICARE" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I select "Other" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Individual Insurance" page
#Step 14
    Then I click Go Back on the Elmo OHC Individual Insurance page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Individual Insurance" page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-968 @PageNavigationOtherHealthCoveragePage
  Scenario: SLER-968 I need navigation functionality to enter the Other Health Coverage (OHC) application
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
#Step 2
    And I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
#Step 3
    Then I click Go back on the ELMO health coverage page
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
#Step 4
    And I validate I am on the "Tax status" page
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"

    And I click on Sign Out in the Header for "Elmo"
