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
    #step1 - add family member
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011980", "Female" and applying "Yes"
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
    And I change the C4 url to "Tax Status Elmo page"
    Then I validate I am on the "Tax status Elmo" page
    #step3 - validate checkboxes
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
    Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
    Then I select "Yes" for will claim dependents question
    Then I verify Tax checkbox in "Not Selected" state
    And I refresh the page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
    Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
    Then I select "Yes" for will claim dependents question
    Then I verify Tax checkbox in "Selected" state
    And I refresh the page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
    Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
    Then I select "Yes" for will claim dependents question
    Then I verify Tax checkbox in "Focus" state
    And I refresh the page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
    Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
    Then I select "Yes" for will claim dependents question
    Then I verify Tax checkbox in "Hover" state

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1809 @PageValidationTaxStatusElmoPage
  Scenario: SLER-1809 I want to see my data when claimed as dependent so that I can review my Tax Status information
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011980", "Female" and applying "Yes"
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
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
#    Workaround until Elmo Tax Status page is in flow
    Then I validate I am on the "Tax status" page
    And I change the C4 url to "Tax Status Elmo page"
#    End of workaround
    Then I validate I am on the "Tax status Elmo" page
#    Step 1
    And I verify the header for "Primary" Member on the Tax Status Elmo page in "English"
    And I verify will you be claimed question on the Tax Status Elmo page for "Primary" in "English"
    And I verify will you be claimed Yes "is not" and No "is not" selected on the Tax Status Elmo page
#    Step 2
    Then I select "No" for will you be claimed as dependent question
    And I verify the header for "Primary" Member on the Tax Status Elmo page in "English"
    And I verify will you be claimed question on the Tax Status Elmo page for "Primary" in "English"
    And I verify will you be claimed Yes "is not" and No "is" selected on the Tax Status Elmo page
    And I verify file tax return question on the Tax Status Elmo page for "Primary" in "English"
    And I verify file tax return Yes "is not" and No "is not" selected on the Tax Status Elmo page
#    Step 3
    Then I select "Yes" for will you be claimed as dependent question
    And I verify the header for "Primary" Member on the Tax Status Elmo page in "English"
    And I verify will you be claimed question on the Tax Status Elmo page for "Primary" in "English"
    And I verify will you be claimed Yes "is" and No "is not" selected on the Tax Status Elmo page
    And I verify who will claim you question on the Tax Status Elmo page for "Primary" in "English"
    And I verify who will claim you question on the Tax Status Elmo page for selected for ""
#    Step 4
    Then I select "Spouse" for who will claim as dependent question
    And I verify who will claim you question on the Tax Status Elmo page for selected for "Spouse"
    Then I select "Someone else" for who will claim as dependent question
    And I verify who will claim you question on the Tax Status Elmo page for selected for "Someone else"
    And I verify enter the name question on the Tax Status Elmo page for "Primary" in "English"
    And I verify enter the name question on the Tax Status Elmo page data
    |First Name|Middle Name|Last Name|Suffix|DOB|
    |          |           |         |      |   |
    And I enter data for enter the name question on the Tax Status Elmo page
    |First Name|Middle Name|Last Name|Suffix|   DOB  |
    |  Anna    |  Marie    |  Bean   | Sr   |02161990|
    And I verify enter the name question on the Tax Status Elmo page data
    |First Name|Middle Name|Last Name|Suffix|   DOB  |
    |  Anna    |  Marie    |  Bean   | 2: SR   |1990-02-16|

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page