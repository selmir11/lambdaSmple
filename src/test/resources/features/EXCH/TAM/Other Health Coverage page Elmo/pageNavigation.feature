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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Elmo Other Health Coverage" page
#Step 2
    Then I click Go back on the health coverage page
    And I validate I am on the "Family Overview" page
#Step 3
    And I click on "Spouse" to edit information from household page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Family Overview" page
#Step 4
    And I click on "Spouse" to edit information from household page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the health coverage page
    And I validate I am on the "Family Overview" page
#Step 5
    And I click on "Spouse" to edit information from household page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status page
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "Health First Colorado" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Family Overview" page

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-967 @PageNavigationOtherHealthCoveragePage
  Scenario: SLER-967 I need navigation functionality so I am navigated to the correct page based on my OHC selections and family members
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Kid" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Elmo Other Health Coverage" page
#Step 1
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
#Step 2
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
#Step 3
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Family Overview" page
#Step 4
    And I click on "Primary" to edit information from household page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I click the save and continue button on the Income Summary Detail page
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "Health First Colorado" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
#Step 5
    Then I click Go back on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
#Step 6
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "Health First Colorado" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
#Step 7
    Then I click Go back on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
#Step 8
    Then I click Go back on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo HRA" page
#Step 9
    Then I click Go Back on the OHC HRA page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "HRA" as health coverage option
#Step 10
    Then I select "Retiree Health Plan" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Retiree" page

    Then I click Go Back on the OHC Retiree page
    Then I select "Retiree Health Plan" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
#Step 11
    Then I select "TRICARE" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Tricare" page
#Step 12
    Then I click Go Back on the OHC Tricare page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Tricare" page
#Step 13
    Then I click Go Back on the OHC Tricare page
    Then I select "TRICARE" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I select "Other" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Individual Insurance" page
#Step 14
    Then I click Go Back on the OHC Individual Insurance page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Individual Insurance" page

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
    Then I validate I am on the "Tax status Elmo" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
#Step 3
    Then I click Go back on the health coverage page
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
    Then I validate I am on the "Tax status Elmo" page
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"

    And I click on Sign Out in the Header for "Elmo"

  @SLER-1303 @PageNavigationOtherHealthCoveragePage @TAMSmokeExch
  Scenario: SLER-1303 My session is invalidated when I log out in OHC Portal, Exchange
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
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"

    #step1
    Then I open current page in new tab
    And I validate I am on the "Elmo Other Health Coverage" page
    And I switch to the tab number 0
    And I validate I am on the "Elmo Other Health Coverage" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page
    #step2
    And I switch to the tab number 1
    And I validate I am on the "Elmo Other Health Coverage" page
    And I refresh the page
    And I validate I am on the "Login" page
    And I close current tab and switch back to previous tab
    #step3
    And  I enter valid credentials to login
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
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I click the save and continue button on the Income Summary Detail page
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I open current page in new tab
    And I validate I am on the "Elmo Other Health Coverage" page
    And I switch to the tab number 0
    And I validate I am on the "Elmo Other Health Coverage" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page
    #step4
    And I switch to the tab number 1
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Login" page

  @SLER-1904 @PageNavigationOtherHealthCoveragePage
  Scenario: SLER-1904 Verify page scrolls to top for OHC pages.
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#    Step 2
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the page is scrolled to the top
#    Step 3
    Then I select "Medicare" as health coverage option
    Then I select "HRA" as health coverage option
    Then I select "TRICARE" as health coverage option
    Then I select "COBRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Medicare" page
    And I verify the page is scrolled to the top
    Then I click "No" for currently eligible in Medicare question
    Then I click continue on the OHC Medicare page
    And I validate I am on the "Elmo HRA" page
    And I verify the page is scrolled to the top
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "500.00" amount on the OHC HRA page
    Then I select "QSEHRA" for HRA type
    Then I click continue on the OHC HRA page
    And I validate I am on the "Elmo COBRA" page
    And I verify the page is scrolled to the top
    Then I click "No" for currently enrolled in COBRA question
    Then I click continue on the OHC Cobra page
    And I validate I am on the "Elmo Ohc Tricare" page
    And I verify the page is scrolled to the top
    Then I click "No" for currently enrolled in Tricare question
    Then I click continue on the OHC Tricare page
#    Step 4
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the page is scrolled to the top
#    Step 5
    Then I select "Medicare" as health coverage option
    Then I select "HRA" as health coverage option
    Then I select "TRICARE" as health coverage option
    Then I select "COBRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Medicare" page
    And I verify the page is scrolled to the top
    Then I click "No" for currently eligible in Medicare question
    Then I click continue on the OHC Medicare page
    And I validate I am on the "Elmo HRA" page
    And I verify the page is scrolled to the top
    Then I select Current Year year dropdown on the OHC HRA page
    Then I enter "500.00" amount on the OHC HRA page
    Then I select "QSEHRA" for HRA type
    Then I click continue on the OHC HRA page
    And I validate I am on the "Elmo COBRA" page
    And I verify the page is scrolled to the top
    Then I click "No" for currently enrolled in COBRA question
    Then I click continue on the OHC Cobra page
    And I validate I am on the "Elmo Ohc Tricare" page
    And I verify the page is scrolled to the top
    Then I click "No" for currently enrolled in Tricare question
    Then I click continue on the OHC Tricare page
#    Step 6
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I click the save and continue button on the Income Summary Detail page
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the page is scrolled to the top
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Medicare" page
    And I verify the page is scrolled to the top
    Then I click continue on the OHC Medicare page
    And I validate I am on the "Elmo HRA" page
    And I verify the page is scrolled to the top
    Then I click continue on the OHC HRA page
    And I validate I am on the "Elmo COBRA" page
    And I verify the page is scrolled to the top
    Then I click continue on the OHC Cobra page
    And I validate I am on the "Elmo Ohc Tricare" page
    And I verify the page is scrolled to the top
    Then I click continue on the OHC Tricare page
    And I validate I am on the "Elmo Other Health Coverage" page
    And I verify the page is scrolled to the top
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Medicare" page
    And I verify the page is scrolled to the top
    Then I click continue on the OHC Medicare page
    And I validate I am on the "Elmo HRA" page
    And I verify the page is scrolled to the top
    Then I click continue on the OHC HRA page
    And I validate I am on the "Elmo COBRA" page
    And I verify the page is scrolled to the top
    Then I click continue on the OHC Cobra page
    And I validate I am on the "Elmo Ohc Tricare" page
    And I verify the page is scrolled to the top
    Then I click continue on the OHC Tricare page

    And I click on Sign Out in the Header for "NonElmo"
    Then I validate I am on the "Login" page