@TAM @TamExch
Feature: Page Text-Tax Status Elmo Page

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

  @SLER-1820 @PageTextTaxStatusElmoPage
  Scenario: SLER-1820 I need to see the updated page so that my Tax Status choices can be collected - English
#    Step 3
    And I verify Save and Back buttons on the Tax Status Elmo page in "English"
#    Step 4
    And I verify the header for "Primary" Member on the Tax Status Elmo page in "English"
#    Step 5
    And I verify will you be claimed question on the Tax Status Elmo page for "Primary" in "English"
#    Step 6
    Then I select "Yes" for will you be claimed as dependent question
    And I verify who will claim you question on the Tax Status Elmo page for "Primary" in "English"
    Then I select "Someone else" for who will claim as dependent question
    And I verify enter the name question on the Tax Status Elmo page for "Primary" in "English"
#    Step 7
    Then I select "No" for will you be claimed as dependent question
    And I verify file tax return question on the Tax Status Elmo page for "Primary" in "English"
#    Step 8
    Then I select "Yes" for will file tax return question
    And I verify select tax filing status question on the Tax Status Elmo page in "English"
#    Step 9
    Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
    And I verify who will you be filing jointly with question on the Tax Status Elmo page for "Primary" in "English"
    And I verify who will you be filing jointly with "" selected on the Tax Status Elmo page for "Primary" in "English"
    Then I select "Someone else" as filing jointly with option on the Tax Status Elmo page
    And I verify who will you be filing jointly with "Someone else" selected on the Tax Status Elmo page for "Primary" in "English"
    And I verify filing jointly with enter the name question on the Tax Status Elmo page in "English"
    Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
    And I verify who will you be filing jointly with "Spouse" selected on the Tax Status Elmo page for "Primary" in "English"
#    Step 10
    And I verify will you claim dependents question on the Tax Status Elmo page for "Primary" in "English"
    And I verify will you claim dependents Yes "is not" and No "is not" selected on the Tax Status Elmo page
#    Step 11
    Then I select "Yes" for will claim dependents question
    And I verify will you claim dependents Yes "is" and No "is not" selected on the Tax Status Elmo page
    And I verify who will be claimed question on the Tax Status Elmo page for "Primary" in "English"
    Then I select "Someone else" for who will be claimed as dependent question
    And I verify who will be claimed with enter the name question on the Tax Status Elmo page in "English"
    Then I select "Someone else" for who will be claimed as dependent question
#    Other Member (Son)
#    Workaround until Elmo Tax Status page is in flow
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
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I change the C4 url to "Tax Status Elmo page Son"
#    End of workaround
    Then I validate I am on the "Tax status Elmo" page
#    Step 4 - Other member
    And I verify the header for "Son" Member on the Tax Status Elmo page in "English"
#    Step 5 - Other member
    And I verify will you be claimed question on the Tax Status Elmo page for "Son" in "English"
#    Step 6 - Other member
    Then I select "Yes" for will you be claimed as dependent question
    And I verify who will claim you question on the Tax Status Elmo page for "Son" in "English"
    Then I select "Someone else" for who will claim as dependent question
    And I verify enter the name question on the Tax Status Elmo page for "Son" in "English"
#    Step 7 - Other member
    Then I select "No" for will you be claimed as dependent question
    And I verify file tax return question on the Tax Status Elmo page for "Son" in "English"
#    Step 8 - Other member
    Then I select "Yes" for will file tax return question
    And I verify select tax filing status question on the Tax Status Elmo page in "English"
#    Step 9 - Other member
    Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
    And I verify who will you be filing jointly with question on the Tax Status Elmo page for "Son" in "English"
    And I verify who will you be filing jointly with "" selected on the Tax Status Elmo page for "Son" in "English"
    Then I select "Someone else" as filing jointly with option on the Tax Status Elmo page
    And I verify who will you be filing jointly with "Someone else" selected on the Tax Status Elmo page for "Son" in "English"
    And I verify filing jointly with enter the name question on the Tax Status Elmo page in "English"
    Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
    And I verify who will you be filing jointly with "Spouse" selected on the Tax Status Elmo page for "Son" in "English"
#    Step 10 - Other member
    And I verify will you claim dependents question on the Tax Status Elmo page for "Son" in "English"
    And I verify will you claim dependents Yes "is not" and No "is not" selected on the Tax Status Elmo page
#    Step 11 - Other member
    Then I select "Yes" for will claim dependents question
    And I verify will you claim dependents Yes "is" and No "is not" selected on the Tax Status Elmo page
    And I verify who will be claimed question on the Tax Status Elmo page for "Son" in "English"
    Then I select "Someone else" for who will be claimed as dependent question
    And I verify who will be claimed with enter the name question on the Tax Status Elmo page in "English"
    Then I select "Someone else" for who will be claimed as dependent question

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1829 @PageTextTaxStatusElmoPage
  Scenario: SLER-1829 I need to see the updated page so that my Tax Status choices can be collected - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Tax status Elmo" page
    And I validate I am on the "Spanish" page
#    Step 3
    And I verify Save and Back buttons on the Tax Status Elmo page in "Spanish"
#    Step 4
    And I verify the header for "Primary" Member on the Tax Status Elmo page in "Spanish"
#    Step 5
    And I verify will you be claimed question on the Tax Status Elmo page for "Primary" in "Spanish"
#    Step 6
    Then I select "Yes" for will you be claimed as dependent question
    And I verify who will claim you question on the Tax Status Elmo page for "Primary" in "Spanish"
    Then I select "Otra persona" for who will claim as dependent question
    And I verify enter the name question on the Tax Status Elmo page for "Primary" in "Spanish"
#    Step 7
    Then I select "No" for will you be claimed as dependent question
    And I verify file tax return question on the Tax Status Elmo page for "Primary" in "Spanish"
#    Step 8
    Then I select "Yes" for will file tax return question
    And I verify select tax filing status question on the Tax Status Elmo page in "Spanish"
#    Step 9
    Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
    And I verify who will you be filing jointly with question on the Tax Status Elmo page for "Primary" in "Spanish"
    And I verify who will you be filing jointly with "" selected on the Tax Status Elmo page for "Primary" in "Spanish"
    Then I select "Otra persona" as filing jointly with option on the Tax Status Elmo page
    And I verify who will you be filing jointly with "Otra persona" selected on the Tax Status Elmo page for "Primary" in "Spanish"
    And I verify filing jointly with enter the name question on the Tax Status Elmo page in "Spanish"
    Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
    And I verify who will you be filing jointly with "Spouse" selected on the Tax Status Elmo page for "Primary" in "Spanish"
#    Step 10
    And I verify will you claim dependents question on the Tax Status Elmo page for "Primary" in "Spanish"
    And I verify will you claim dependents Yes "is not" and No "is not" selected on the Tax Status Elmo page
#    Step 11
    Then I select "Yes" for will claim dependents question
    And I verify will you claim dependents Yes "is" and No "is not" selected on the Tax Status Elmo page
    And I verify who will be claimed question on the Tax Status Elmo page for "Primary" in "Spanish"
    Then I select "Otra persona" for who will be claimed as dependent question
    And I verify who will be claimed with enter the name question on the Tax Status Elmo page in "Spanish"
    Then I select "Otra persona" for who will be claimed as dependent question
#    Other Member (Son)
#    Workaround until Elmo Tax Status page is in flow
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
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I change the C4 url to "Tax Status Elmo page Son"
#    End of workaround
    Then I validate I am on the "Tax status Elmo" page
#    Step 4 - Other member
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Tax status Elmo" page
    And I validate I am on the "Spanish" page
    And I verify the header for "Son" Member on the Tax Status Elmo page in "Spanish"
#    Step 5 - Other member
    And I verify will you be claimed question on the Tax Status Elmo page for "Son" in "Spanish"
#    Step 6 - Other member
    Then I select "Yes" for will you be claimed as dependent question
    And I verify who will claim you question on the Tax Status Elmo page for "Son" in "Spanish"
    Then I select "Otra persona" for who will claim as dependent question
    And I verify enter the name question on the Tax Status Elmo page for "Son" in "Spanish"
#    Step 7 - Other member
    Then I select "No" for will you be claimed as dependent question
    And I verify file tax return question on the Tax Status Elmo page for "Son" in "Spanish"
#    Step 8 - Other member
    Then I select "Yes" for will file tax return question
    And I verify select tax filing status question on the Tax Status Elmo page in "Spanish"
#    Step 9 - Other member
    Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
    And I verify who will you be filing jointly with question on the Tax Status Elmo page for "Son" in "Spanish"
    And I verify who will you be filing jointly with "" selected on the Tax Status Elmo page for "Son" in "Spanish"
    Then I select "Otra persona" as filing jointly with option on the Tax Status Elmo page
    And I verify who will you be filing jointly with "Otra persona" selected on the Tax Status Elmo page for "Son" in "Spanish"
    And I verify filing jointly with enter the name question on the Tax Status Elmo page in "Spanish"
    Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
    And I verify who will you be filing jointly with "Spouse" selected on the Tax Status Elmo page for "Son" in "Spanish"
#    Step 10 - Other member
    And I verify will you claim dependents question on the Tax Status Elmo page for "Son" in "Spanish"
    And I verify will you claim dependents Yes "is not" and No "is not" selected on the Tax Status Elmo page
#    Step 11 - Other member
    Then I select "Yes" for will claim dependents question
    And I verify will you claim dependents Yes "is" and No "is not" selected on the Tax Status Elmo page
    And I verify who will be claimed question on the Tax Status Elmo page for "Son" in "Spanish"
    Then I select "Otra persona" for who will be claimed as dependent question
    And I verify who will be claimed with enter the name question on the Tax Status Elmo page in "Spanish"
    Then I select "Otra persona" for who will be claimed as dependent question

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page