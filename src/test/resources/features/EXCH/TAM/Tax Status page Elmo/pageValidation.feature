@TAM @TamExch
Feature: Page Validation-Tax Status Elmo Page

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

  @SLER-1781 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1781 I verify that income-portal-ui uses common components from ng-common on the new Tax Status page in EXCH
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    #step2 - navigate to ELMO Tax Status page
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
    Then I validate I am on the "Tax status" page
    #step3 - validate checkboxes
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I verify Tax checkbox in "Not Selected" state
    And I refresh the page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I verify Tax checkbox in "Selected" state
    And I refresh the page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I verify Tax checkbox in "Focus" state
    And I refresh the page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I verify Tax checkbox in "Hover" state

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1809 @PageValidationTaxStatusElmoPage @TAMSmokeExch
  Scenario: SLER-1809 I want to see my data when claimed as dependent so that I can review my Tax Status information
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Son", "05012015", "Male" and applying "Yes"
      |Primary:Son|
      |Spouse:Son |
    Then I validate I am on the "Add Member" page
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
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Son"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "80000.00" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
#    Step 1
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    And I verify will you be claimed question on the Tax Status page for "Primary" in "English"
    And I verify will you be claimed Yes "is not" and No "is not" selected on the Tax Status page
#    Step 2
    Then I select "No" for will you be claimed as dependent question
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    And I verify will you be claimed question on the Tax Status page for "Primary" in "English"
    And I verify will you be claimed Yes "is not" and No "is" selected on the Tax Status page
    And I verify file tax return question on the Tax Status page for "Primary" in "English"
    And I verify file tax return Yes "is not" and No "is not" selected on the Tax Status page
#    Step 3
    Then I select "Yes" for will you be claimed as dependent question
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    And I verify will you be claimed question on the Tax Status page for "Primary" in "English"
    And I verify will you be claimed Yes "is" and No "is not" selected on the Tax Status page
    And I verify who will claim you question on the Tax Status page for "Primary" in "English"
    And I verify who will claim you question on the Tax Status page for selected for ""
#    Step 4
    Then I select "Spouse" for who will claim as dependent question
    And I verify who will claim you question on the Tax Status page for selected for "Spouse"
    Then I select "Someone else" for who will claim as dependent question
    And I verify who will claim you question on the Tax Status page for selected for "Someone else"
    And I verify enter the name question on the Tax Status page for "Primary" in "English"
    And I verify for who will claim as dependent enter the name question on the Tax Status page data
    |First Name|Middle Name|Last Name|Suffix|DOB|
    |          |           |         |      |   |
    And I enter data for who will claim as dependent enter the name question on the Tax Status page
    |First Name|Middle Name|Last Name|Suffix|   DOB  |
    |  Anna    |  Marie    |  Bean   | Sr   |02161990|
    And I verify for who will claim as dependent enter the name question on the Tax Status page data
    |First Name|Middle Name|Last Name|Suffix   |   DOB    |
    |  Anna    |  Marie    |  Bean   | 2: SR   |1990-02-16|

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1831 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1831 I want to see my data when choosing to file a federal income tax return so that I can review my Tax Status information - English
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    Then I validate I am on the "Tax status" page
#    Step 2
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    And I verify will you be claimed question on the Tax Status page for "Primary" in "English"
    And I verify will you be claimed Yes "is not" and No "is not" selected on the Tax Status page
    Then I select "No" for will you be claimed as dependent question
    And I verify file tax return question on the Tax Status page for "Primary" in "English"
    And I verify file tax return Yes "is not" and No "is not" selected on the Tax Status page
#    Step 3
    Then I select "Yes" for will file tax return question
    And I verify select tax filing status question on the Tax Status page in "English"
    And I verify select tax filing status "0: null" selected on the Tax Status page
    And I verify Exceptional circumstances checkbox "is not" selected on the Tax Status page
#    Step 4
    Then I select the "Single" tax filing option on the Tax Status page
    And I verify will you claim dependents question on the Tax Status page for "Primary" in "English"
    And I verify will you claim dependents Yes "is not" and No "is not" selected on the Tax Status page
#    Step 5
    Then I select "Yes" for will claim dependents question
    And I verify who will be claimed question on the Tax Status page for "Primary" in "English"
#    Step 6
    Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
    And I verify who will be claimed does not show enter the name question on the Tax Status page
#    Step 7
    Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    And I verify who will be claimed with enter the name question on the Tax Status page in "English"
    And I verify who will be claimed enter the name question on the Tax Status page data
      |First Name|Middle Name|Last Name|Suffix|DOB|
      |          |           |         |      |   |

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1840 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1840 I want to see my data when choosing to file a federal income tax return so that I can review my Tax Status information - Spanish
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
#    Step 2
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Tax status" page
    And I validate I am on the "Spanish" page
    And I verify the header for "Primary" Member on the Tax Status page in "Spanish"
    And I verify will you be claimed question on the Tax Status page for "Primary" in "Spanish"
    And I verify will you be claimed Yes "is not" and No "is not" selected on the Tax Status page
    Then I select "No" for will you be claimed as dependent question
    And I verify file tax return question on the Tax Status page for "Primary" in "Spanish"
    And I verify file tax return Yes "is not" and No "is not" selected on the Tax Status page
#    Step 3
    Then I select "Yes" for will file tax return question
    And I verify select tax filing status question on the Tax Status page in "Spanish"
    And I verify select tax filing status "0: null" selected on the Tax Status page
    And I verify Exceptional circumstances checkbox "is not" selected on the Tax Status page
#    Step 4
    Then I select the "Single" tax filing option on the Tax Status page
    And I verify will you claim dependents question on the Tax Status page for "Primary" in "Spanish"
    And I verify will you claim dependents Yes "is not" and No "is not" selected on the Tax Status page
#    Step 5
    Then I select "Yes" for will claim dependents question
    And I verify who will be claimed question on the Tax Status page for "Primary" in "Spanish"
#    Step 6
    Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
    And I verify who will be claimed does not show enter the name question on the Tax Status page
#    Step 7
    Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
    Then I select "Otra persona" for who will be claimed as dependent question on the Tax Status page
    And I verify who will be claimed with enter the name question on the Tax Status page in "Spanish"
    And I verify who will be claimed enter the name question on the Tax Status page data
      |First Name|Middle Name|Last Name|Suffix|DOB|
      |          |           |         |      |   |

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1842 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1842 I want to see my data when am married filing jointly so that I can review my Tax Status information
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    Then I validate I am on the "Tax status" page
#    Step 2
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    And I verify select tax filing status "0: null" selected on the Tax Status page
#    Step 3
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    And I verify Exceptional circumstances checkbox "is not" selected on the Tax Status page
    Then I check Exceptional circumstances checkbox on the Tax Status page
    And I verify Exceptional circumstances checkbox "is" selected on the Tax Status page
    Then I check Exceptional circumstances checkbox on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
#    Step 4
    And I verify who will you be filing jointly with "Spouse" selected on the Tax Status page in "English"
      |ExpectedMembers|
      |Spouse         |
    And I verify will you claim dependents question on the Tax Status page for "Primary" in "English"
    And I verify will you claim dependents Yes "is not" and No "is not" selected on the Tax Status page
    Then I select "No" for will claim dependents question
    And I verify will you claim dependents Yes "is not" and No "is" selected on the Tax Status page
#    Step 5
    Then I select "Someone else" as filing jointly with option on the Tax Status page
    And I verify filing jointly with enter the name question on the Tax Status page in "English"
    And I verify filing jointly with enter the name question on the Tax Status page
      |First Name|Middle Name|Last Name|Suffix|DOB|
      |          |           |         |      |   |
    And I verify will you claim dependents question on the Tax Status page for "Primary" in "English"
    And I verify will you claim dependents Yes "is not" and No "is" selected on the Tax Status page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1844 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1844 I want to be able to save, update or remove my Tax Status information when claimed as dependent so that my Tax Status details are accurate
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    Then I validate I am on the "Tax status" page
#    Step 2
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
#    Step 3
    And I wait for 5000 milliseconds
    And I verify the tax filing data for "Primary" in DB
      |claimed_as_dep_on_othr_ftr_ind|tax_filing_type|
      |                              |  NON_FILER    |
#    Step 4
    Then I validate I am on the "Tax status" page
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I select "Yes" for will you be claimed as dependent question
    Then I select "Primary" for who will claim as dependent question
    Then I click Save and Continue on Tax Status page
#    Step 5
    And I wait for 5000 milliseconds
    And I verify the tax filing data for "Primary" in DB
      |claimed_as_dep_on_othr_ftr_ind|tax_filing_type|
      |                              |    FILER      |
    And I verify the tax filing data for "Spouse" in DB
      |claimed_as_dep_on_othr_ftr_ind|tax_filing_type|
      |                              |   DEPENDENT   |
#    Step 6
    Then I click Go back on the health coverage page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I select "Yes" for will you be claimed as dependent question
    Then I select "Someone else" for who will claim as dependent question
    And I enter data for who will claim as dependent enter the name question on the Tax Status page
      |First Name|Middle Name|Last Name|Suffix|   DOB  |
      |  Anna    |  Marie    |  Bean   |      |02161983|
    Then I click Save and Continue on Tax Status page
#    Step 7
    And I wait for 5000 milliseconds
    And I verify the tax filing data for "Primary" in DB
      |claimed_as_dep_on_othr_ftr_ind|tax_filing_type|
      |                              |   NON_FILER   |
    And I verify the tax filing data for "Spouse" in DB
      |claimed_as_dep_on_othr_ftr_ind|tax_filing_type|
      |                              |   DEPENDENT   |
#    Step 8
    Then I click Go back on Tax Status page
    Then I click Go back on Tax Status page
    And I click plus icon next to member on household page for "Anna"
    Then I click on Remove this Member for "Anna"
    Then I click on "OK" in the Remove Member frame
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I click Save and Continue on Tax Status page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
#    Step 9
    And I wait for 5000 milliseconds
    And I verify the tax filing data for "Primary" in DB
      |claimed_as_dep_on_othr_ftr_ind|tax_filing_type|
      |                              |   NON_FILER   |
    And I verify the tax filing data for "Spouse" in DB
      |claimed_as_dep_on_othr_ftr_ind|tax_filing_type|
      |                              |   NON_FILER   |

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1853 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1853 I want to be able to save, update or remove my Tax Status information when filing a federal income tax return so that my Tax Status details are accurate - Primary
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    Then I validate I am on the "Tax status" page
#    Step 2
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I check Exceptional circumstances checkbox on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#    Step 3
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |     SNGL        |           1            |
#    Step 4
    Then I click Go back on Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
#    Step 5
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |     SNGL        |           1            |
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |   DEPENDENT   |                              |     SNGL        |           1            |
    And I verify tax_return_id is "Different" as last ID for "Primary" on the Tax Status page
#    Step 6
    Then I click Go back on the health coverage page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
#    Step 7
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Primary" on the Tax Status page
#    Step 8
    Then I click Go back on Tax Status page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "Yes" for will file tax return question
    Then I select the "Qualified widow(er)" tax filing option on the Tax Status page
    Then I click Save and Continue on Tax Status page
#    Step 9
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |      QWD        |           0            |
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Primary" on the Tax Status page
#    Step 10
    Then I click Go back on Tax Status page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I select "Yes" for will claim dependents question
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    And I enter data for who will be claimed as dependent enter the name question on the Tax Status page
      |First Name|Middle Name|Last Name|Suffix|   DOB  |
      |  Anna    |  Marie    |  Bean   |      |02162020|
    Then I click Save and Continue on Tax Status page
#    Step 11
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |      SNGL       |           0            |
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Primary" on the Tax Status page
#    Step 12
    Then I click Go back on Tax Status page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#    Step 13
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |     SNGL        |           0            |
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Primary" on the Tax Status page
#    Step 14
    Then I click Go back on Tax Status page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I check Exceptional circumstances checkbox on the Tax Status page
    Then I click Save and Continue on Tax Status page
    #    Step 15
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |     SNGL        |          1             |
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Primary" on the Tax Status page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1864 @PageValidationTaxStatusElmoPage @TAMSmokeExch
  Scenario: SLER-1864 I want to be able to save, update or remove my Tax Status information when filing a federal income tax return so that my Tax Status details are accurate - Secondary
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
    Then I validate I am on the "Tax status" page
#    Step 2
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I check Exceptional circumstances checkbox on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#    Step 3
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |     SNGL        |           1            |
#    Step 4
    Then I click Go back on Tax Status page
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I select "Yes" for will claim dependents question
    Then I select "Primary" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
#    Step 5
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |     SNGL        |           1            |
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |   DEPENDENT   |                              |     SNGL        |           1            |
    And I verify tax_return_id is "Different" as last ID for "Spouse" on the Tax Status page
#    Step 6
    Then I click Go back on the health coverage page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
#    Step 7
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Spouse" on the Tax Status page
#    Step 8
    Then I click Go back on the health coverage page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I select "Yes" for will file tax return question
    Then I select the "Qualified widow(er)" tax filing option on the Tax Status page
    Then I click Save and Continue on Tax Status page
#    Step 9
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |      QWD        |           0            |
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Spouse" on the Tax Status page
#    Step 10
    Then I click Go back on Tax Status page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I select "Yes" for will claim dependents question
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    And I enter data for who will be claimed as dependent enter the name question on the Tax Status page
      |First Name|Middle Name|Last Name|Suffix|   DOB  |
      |  Anna    |  Marie    |  Bean   |      |02162020|
    Then I click Save and Continue on Tax Status page
#    Step 11
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |     SNGL        |           0            |
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Spouse" on the Tax Status page
#    Step 12
    Then I click Go back on Tax Status page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#    Step 13
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |     SNGL        |           0            |
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Spouse" on the Tax Status page
#    Step 14
    Then I click Go back on Tax Status page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I check Exceptional circumstances checkbox on the Tax Status page
    Then I click Save and Continue on Tax Status page
#    Step 15
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |     SNGL        |          1             |
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Spouse" on the Tax Status page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1871 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1871 I want to be able to save, update or remove my Tax Status information when I am married filing jointly so that my Tax Status details are accurate
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    Then I validate I am on the "Tax status" page
#    Step 2
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I check Exceptional circumstances checkbox on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#    Step 3
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |      MFJ        |           1            |
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    SPOUSE     |                              |      MFJ        |           1            |
    And I verify tax_return_id is "Different" as last ID for "Primary" on the Tax Status page
    And I verify tax_return_id is "Different" as last ID for "Spouse" on the Tax Status page
    And I verify tax_return_id for "Primary" is "Same" compared to "Spouse" on the Tax Status page
#    Step 4
    Then I click Go back on the health coverage page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#    Step 5
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |      SNGL       |           1            |
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Primary" on the Tax Status page
    And I verify tax_return_id is "Different" as last ID for "Spouse" on the Tax Status page
    And I verify tax_return_id for "Primary" is "Different" compared to "Spouse" on the Tax Status page
#    Step 6
    Then I click Go back on Tax Status page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#    Step 7
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |      MFJ        |           1            |
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    SPOUSE     |                              |      MFJ        |           1            |
    And I verify tax_return_id is "Different" as last ID for "Primary" on the Tax Status page
    And I verify tax_return_id is "Different" as last ID for "Spouse" on the Tax Status page
    And I verify tax_return_id for "Primary" is "Same" compared to "Spouse" on the Tax Status page
#    Step 8
    Then I click Go back on the health coverage page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Someone else" as filing jointly with option on the Tax Status page
    And I enter data for filing jointly with enter the name question on the Tax Status page
      |First Name|Middle Name|Last Name|Suffix|   DOB  |
      |  Anna    |  Marie    |  Bean   |      |02161980|
    Then I click Save and Continue on Tax Status page
#    Step 9
    And I wait for 5000 milliseconds
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |      MFJ        |           1            |
    And I verify the tax return data for "Spouse" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |               |                              |                 |                        |
    And I verify tax_return_id is "Different" as last ID for "Primary" on the Tax Status page
    And I verify tax_return_id is "Different" as last ID for "Spouse" on the Tax Status page
    And I verify tax_return_id for "Primary" is "Different" compared to "Spouse" on the Tax Status page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1884 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1884 I want standard errors displayed when I fail to enter information correctly for "Someone else" so that errors are displayed consistently
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    Then I validate I am on the "Tax status" page
#    Step 3/4 - Primary
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "Yes" for will you be claimed as dependent question
    Then I select "Someone else" for who will claim as dependent question
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will claim as dependent enter the name question on the Tax Status page data in "English"
#    Step 5 - Primary
    And I change the language from header to "Spanish"
    And I verify error messages with date "required" for who will claim as dependent enter the name question on the Tax Status page data in "Spanish"
#    Step 6 - Primary
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will claim as dependent enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will claim as dependent enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will claim as dependent enter the name question on the Tax Status page data in "Spanish"
#    Step 7 - Primary
    And I change the language from header to "English"
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will claim as dependent enter the name question on the Tax Status page data in "English"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will claim as dependent enter the name question on the Tax Status page data in "English"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will claim as dependent enter the name question on the Tax Status page data in "English"
#    Step 8 - Primary cannot be automated due to calendar is not it's own element
#    Step 9/10 - Primary
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Someone else" as filing jointly with option on the Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "English"
#    Step 11 - Primary
    And I change the language from header to "Spanish"
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "Spanish"
#    Step 12 - Primary
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for filing jointly with enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for filing jointly with enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "Spanish"
#    Step 13 - Primary
    And I change the language from header to "English"
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for filing jointly with enter the name question on the Tax Status page data in "English"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for filing jointly with enter the name question on the Tax Status page data in "English"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "English"
#    Step 14 - Primary cannot be automated due to calendar is not it's own element
#    Step 15/16 - Primary
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "English"
#    Step 17 - Primary
    And I change the language from header to "Spanish"
    And I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "Spanish"
#    Step 18 - Primary
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will be claimed with enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will be claimed with enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "Spanish"
#    Step 19 - Primary
    And I change the language from header to "English"
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will be claimed with enter the name question on the Tax Status page data in "English"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will be claimed with enter the name question on the Tax Status page data in "English"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "English"
#    Step 20 - Primary cannot be automated due to calendar is not it's own element
#    Other Member (Spouse)
    And I click on Apply for Coverage in the "Elmo" Header
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
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
    Then I validate I am on the "Tax status" page
#    Step 3/4 - Spouse
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I select "Yes" for will you be claimed as dependent question
    Then I select "Someone else" for who will claim as dependent question
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will claim as dependent enter the name question on the Tax Status page data in "English"
#    Step 5 - Spouse
    And I change the language from header to "Spanish"
    And I verify error messages with date "required" for who will claim as dependent enter the name question on the Tax Status page data in "Spanish"
#    Step 6 - Spouse
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will claim as dependent enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will claim as dependent enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will claim as dependent enter the name question on the Tax Status page data in "Spanish"
#    Step 7 - Spouse
    And I change the language from header to "English"
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will claim as dependent enter the name question on the Tax Status page data in "English"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will claim as dependent enter the name question on the Tax Status page data in "English"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will claim as dependent enter the name question on the Tax Status page data in "English"
#    Step 8 - Spouse cannot be automated due to calendar is not it's own element
#    Step 9/10 - Spouse
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Someone else" as filing jointly with option on the Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "English"
#    Step 11 - Spouse
    And I change the language from header to "Spanish"
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "Spanish"
#    Step 12 - Spouse
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for filing jointly with enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for filing jointly with enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "Spanish"
#    Step 13 - Spouse
    And I change the language from header to "English"
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for filing jointly with enter the name question on the Tax Status page data in "English"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for filing jointly with enter the name question on the Tax Status page data in "English"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "English"
#    Step 14 - Spouse cannot be automated due to calendar is not it's own element
#    Step 15/16 - Spouse
    Then I select "Primary" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "English"
#    Step 17 - Spouse
    And I change the language from header to "Spanish"
    And I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "Spanish"
#    Step 18 - Spouse
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will be claimed with enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will be claimed with enter the name question on the Tax Status page data in "Spanish"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "Spanish"
#    Step 19 - Spouse
    And I change the language from header to "English"
    Then I enter date of "Future 1" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will be claimed with enter the name question on the Tax Status page data in "English"
    Then I enter date of "Past 72685" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "not valid" for who will be claimed with enter the name question on the Tax Status page data in "English"
    Then I enter date of "Partial" for Someone else's DOB on Tax Status page
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "English"
#    Step 20 - Spouse cannot be automated due to calendar is not it's own element

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1888 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1888 I want standard errors displayed when I fail to enter information correctly so that errors are displayed consistently - Primary
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    Then I validate I am on the "Tax status" page
#    Step 3 - Primary
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I click Save and Continue on Tax Status page
    And I verify will you be claimed error on the Tax Status page for "Primary" in "English"
#    Step 4 - Primary
    And I change the language from header to "Spanish"
    And I verify will you be claimed error on the Tax Status page for "Primary" in "Spanish"
    And I change the language from header to "English"
#    Step 5 - Primary
    Then I select "Yes" for will you be claimed as dependent question
    And I verify no errors show on the Tax Status page
#    Step 6 - Primary
    Then I click Save and Continue on Tax Status page
    And I verify who will claim you error on the Tax Status page for "Primary" in "English"
#    Step 7 - Primary
    And I change the language from header to "Spanish"
    And I verify who will claim you error on the Tax Status page for "Primary" in "Spanish"
    And I change the language from header to "English"
#    Step 8 - Primary
    Then I select "Spouse" for who will claim as dependent question
    And I verify no errors show on the Tax Status page
#    Step 9 - Primary
    Then I select "No" for will you be claimed as dependent question
    Then I click Save and Continue on Tax Status page
    And I verify file tax return error on the Tax Status page for "Primary" in "English"
#    Step 10 - Primary
    And I change the language from header to "Spanish"
    And I verify file tax return error on the Tax Status page for "Primary" in "Spanish"
    And I change the language from header to "English"
#    Step 11 - Primary
    Then I select "Yes" for will file tax return question
    And I verify no errors show on the Tax Status page
#    Step 12 - Primary
    Then I click Save and Continue on Tax Status page
    And I verify select tax filing status error on the Tax Status page in "English"
#    Step 13 - Primary
    And I change the language from header to "Spanish"
    And I verify select tax filing status error on the Tax Status page in "Spanish"
    And I change the language from header to "English"
#    Step 14 - Primary
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    And I verify no errors show on the Tax Status page
#    Step 15 - Primary
    Then I click Save and Continue on Tax Status page
    And I verify who will you be filing jointly with error on the Tax Status page for "Primary" in "English"
#    Step 16 - Primary
    And I change the language from header to "Spanish"
    And I verify who will you be filing jointly with error on the Tax Status page for "Primary" in "Spanish"
    And I change the language from header to "English"
#    Step 17 - Primary
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    And I verify no errors show on the Tax Status page
#    Step 18 - Primary
    Then I click Save and Continue on Tax Status page
    And I verify will you claim dependents error on the Tax Status page for "Primary" in "English"
#    Step 19 - Primary
    And I change the language from header to "Spanish"
    And I verify will you claim dependents error on the Tax Status page for "Primary" in "Spanish"
    And I change the language from header to "English"
#    Step 20 - Primary
    Then I select "Yes" for will claim dependents question
    And I verify no errors show on the Tax Status page
#    Step 21 - Primary
    Then I click Save and Continue on Tax Status page
    And I verify who will be claimed error on the Tax Status page for "Primary" in "English"
#    Step 22 - Primary
    And I change the language from header to "Spanish"
    And I verify who will be claimed error on the Tax Status page for "Primary" in "Spanish"
    And I change the language from header to "English"
#    Step 23 - Primary
    Then I select "Yes" for will claim dependents question
    And I verify no errors show on the Tax Status page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1899 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1899 I want standard errors displayed when I fail to enter information correctly so that errors are displayed consistently - Spouse
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
    Then I validate I am on the "Tax status" page
#    Step 3 - Spouse
    And I verify the header for "Spouse" Member on the Tax Status page in "English"
    Then I click Save and Continue on Tax Status page
    And I verify will you be claimed error on the Tax Status page for "Spouse" in "English"
#    Step 4 - Spouse
    And I change the language from header to "Spanish"
    And I verify will you be claimed error on the Tax Status page for "Spouse" in "Spanish"
    And I change the language from header to "English"
#    Step 5 - Spouse
    Then I select "Yes" for will you be claimed as dependent question
    And I verify no errors show on the Tax Status page
#    Step 6 - Spouse
    Then I click Save and Continue on Tax Status page
    And I verify who will claim you error on the Tax Status page for "Spouse" in "English"
#    Step 7 - Spouse
    And I change the language from header to "Spanish"
    And I verify who will claim you error on the Tax Status page for "Spouse" in "Spanish"
    And I change the language from header to "English"
#    Step 8 - Spouse
    Then I select "Primary" for who will claim as dependent question
    And I verify no errors show on the Tax Status page
#    Step 9 - Spouse
    Then I select "No" for will you be claimed as dependent question
    Then I click Save and Continue on Tax Status page
    And I verify file tax return error on the Tax Status page for "Spouse" in "English"
#    Step 10 - Spouse
    And I change the language from header to "Spanish"
    And I verify file tax return error on the Tax Status page for "Spouse" in "Spanish"
    And I change the language from header to "English"
#    Step 11 - Spouse
    Then I select "Yes" for will file tax return question
    And I verify no errors show on the Tax Status page
#    Step 12 - Spouse
    Then I click Save and Continue on Tax Status page
    And I verify select tax filing status error on the Tax Status page in "English"
#    Step 13 - Spouse
    And I change the language from header to "Spanish"
    And I verify select tax filing status error on the Tax Status page in "Spanish"
    And I change the language from header to "English"
#    Step 14 - Spouse
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    And I verify no errors show on the Tax Status page
#    Step 15 - Spouse
    Then I click Save and Continue on Tax Status page
    And I verify who will you be filing jointly with error on the Tax Status page for "Spouse" in "English"
#    Step 16 - Spouse
    And I change the language from header to "Spanish"
    And I verify who will you be filing jointly with error on the Tax Status page for "Spouse" in "Spanish"
    And I change the language from header to "English"
#    Step 17 - Spouse
    Then I select "Primary" as filing jointly with option on the Tax Status page
    And I verify no errors show on the Tax Status page
#    Step 18 - Spouse
    Then I click Save and Continue on Tax Status page
    And I verify will you claim dependents error on the Tax Status page for "Spouse" in "English"
#    Step 19 - Spouse
    And I change the language from header to "Spanish"
    And I verify will you claim dependents error on the Tax Status page for "Spouse" in "Spanish"
    And I change the language from header to "English"
#    Step 20 - Spouse
    Then I select "Yes" for will claim dependents question
    And I verify no errors show on the Tax Status page
#    Step 21 - Spouse
    Then I click Save and Continue on Tax Status page
    And I verify who will be claimed error on the Tax Status page for "Spouse" in "English"
#    Step 22 - Spouse
    And I change the language from header to "Spanish"
    And I verify who will be claimed error on the Tax Status page for "Spouse" in "Spanish"
    And I change the language from header to "English"
#    Step 23 - Spouse
    Then I select "Yes" for will claim dependents question
    And I verify no errors show on the Tax Status page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1901 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1901 I want the "Someone else" errors cleared so that I don't continue to see these errors as I answer questions
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      | Primary:Spouse |
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
    Then I validate I am on the "Tax status" page
#    Step 2
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "Yes" for will you be claimed as dependent question
    Then I select "Someone else" for who will claim as dependent question
    Then I click Save and Continue on Tax Status page
    Then I verify error messages with date "required" for who will claim as dependent enter the name question on the Tax Status page data in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will you be claimed as dependent question
    And I verify no errors show on the Tax Status page
    And I verify for who will claim as dependent enter the name question on the Tax Status page data
      |First Name|Middle Name|Last Name|Suffix   |   DOB    |
      |          |           |         |         |          |
#    Step 3
    Then I click Save and Continue on Tax Status page
    Then I verify error messages with date "required" for who will claim as dependent enter the name question on the Tax Status page data in "English"
    Then I select "Spouse" for who will claim as dependent question
    Then I select "Someone else" for who will claim as dependent question
    And I verify no errors show on the Tax Status page
    And I verify for who will claim as dependent enter the name question on the Tax Status page data
      |First Name|Middle Name|Last Name|Suffix   |   DOB    |
      |          |           |         |         |          |
#    Step 4
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Someone else" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "English"
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    And I verify no errors show on the Tax Status page
    And I verify filing jointly with enter the name question on the Tax Status page
      |First Name|Middle Name|Last Name|Suffix   |   DOB    |
      |          |           |         |         |          |
#    Step 5
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "English"
    Then I select "No" for will file tax return question
    Then I select "Yes" for will file tax return question
    And I verify no errors show on the Tax Status page
    And I verify filing jointly with enter the name question on the Tax Status page
      |First Name|Middle Name|Last Name|Suffix   |   DOB    |
      |          |           |         |         |          |
#    Step 6
    Then I click Save and Continue on Tax Status page
    And I verify error messages with date "required" for filing jointly with enter the name question on the Tax Status page data in "English"
    Then I select "Yes" for will you be claimed as dependent question
    Then I select "No" for will you be claimed as dependent question
    And I verify no errors show on the Tax Status page
    And I verify filing jointly with enter the name question on the Tax Status page
      |First Name|Middle Name|Last Name|Suffix   |   DOB    |
      |          |           |         |         |          |
#    Step 7
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
    Then I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "English"
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    And I verify no errors show on the Tax Status page
    And I verify who will be claimed enter the name question on the Tax Status page data
      |First Name|Middle Name|Last Name|Suffix   |   DOB    |
      |          |           |         |         |          |
#    Step 8
    Then I click Save and Continue on Tax Status page
    Then I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "English"
    Then I select "No" for will claim dependents question
    Then I select "Yes" for will claim dependents question
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    And I verify no errors show on the Tax Status page
    And I verify who will be claimed enter the name question on the Tax Status page data
      |First Name|Middle Name|Last Name|Suffix   |   DOB    |
      |          |           |         |         |          |
#    Step 9
    Then I click Save and Continue on Tax Status page
    Then I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "English"
    Then I select "No" for will file tax return question
    Then I select "Yes" for will file tax return question
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    And I verify no errors show on the Tax Status page
    And I verify who will be claimed enter the name question on the Tax Status page data
      |First Name|Middle Name|Last Name|Suffix   |   DOB    |
      |          |           |         |         |          |
#    Step 10
    Then I click Save and Continue on Tax Status page
    Then I verify error messages with date "required" for who will be claimed with enter the name question on the Tax Status page data in "English"
    Then I select "Yes" for will you be claimed as dependent question
    Then I select "No" for will you be claimed as dependent question
    Then I select "Someone else" for who will be claimed as dependent question on the Tax Status page
    And I verify no errors show on the Tax Status page
    And I verify who will be claimed enter the name question on the Tax Status page data
      |First Name|Middle Name|Last Name|Suffix   |   DOB    |
      |          |           |         |         |          |

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2367 @PageValidationTaxStatusElmoPage
  Scenario: SLER-2367 Validate that a family member doesn't remain to be a dependent on the tax household of a primary member after selection is changed to "Qualified widow(er)" in Tax Return Portal, Exchange
      #step2 - add a family member (dependent)
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "01012003", "Female" and applying "Yes"
      | Primary:Daughter |
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" for Foster care in state of Colorado
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Daughter"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
      #step3 - provide all basic information for both users - primary and dependent
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
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Daughter" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
      #step4 - navigate back to a primary user Tax Status page and change their tax filing status
    And I validate I am on the "Family Overview" page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I click the save and continue button on the Income Summary Detail page
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I select the "Qualified widow(er)" tax filing option on the Tax Status page
    Then I click Save and Continue on Tax Status page
      #step5 - verify the family member doesn't remain to be a dependent in primary's tax household
    Then I validate I am on the "Tax status" page
    And I verify the header for "Daughter" Member on the Tax Status page in "English"
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    And I verify the tax return data for "Primary" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |      QWD        |           0            |
    And I verify the tax return data for "Daughter" in DB
      |tax_filing_type|claimed_as_dep_on_othr_ftr_ind|tax_filing_status|exceptional_circumstance|
      |    FILER      |                              |      SNGL       |           0            |
    And I validate I am on the "Other Health Coverage" page
    Then I click continue on the health coverage page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the health coverage page
    And I validate I am on the "Family Overview" page

    And I click on Sign Out in the Header for "NonElmo"