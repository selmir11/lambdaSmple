@TAM @TamExch
Feature: Page Verification-Deductions Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
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
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page

  @SLER-233 @PageVerificationDeductionsPage
  Scenario: SLER-233 I see the Errors Cleared on the Deductions page - English
    Then I click "AOSS" as deduction option only
    Then I click continue on the Deductions page
    Then I validate I am on the "Deductions" page
    Then I verify error for Deductions option with no amount in "English"
    Then I verify error for Deductions option with no frequency in "English"

    Then I click "NoDeductions" as deduction option only
    Then I click "AOSS" as deduction option only
    Then I verify no errors show for Deductions options
    Then I click "AOSS" as deduction option only

    Then I click "DPAC" as deduction option only
    Then I click continue on the Deductions page
    Then I validate I am on the "Deductions" page
    Then I verify error for Deductions option with no amount in "English"
    Then I verify error for Deductions option with no frequency in "English"

    Then I click "NoDeductions" as deduction option only
    Then I click "DPAC" as deduction option only
    Then I verify no errors show for Deductions options
    Then I click "DPAC" as deduction option only

    Then I click "HSAC" as deduction option only
    Then I click "Pre-tax retirement account contribution" as deduction option with "500.00" amount at "Annually" frequency
    Then I click continue on the Deductions page
    Then I validate I am on the "Deductions" page
    Then I verify error for Deductions option with no amount in "English"
    Then I verify error for Deductions option with no frequency in "English"

    Then I click "NoDeductions" as deduction option only
    Then I click "HSAC" as deduction option only
    Then I click "PRAC" as deduction option only
    Then I verify no errors show for Deductions options
    Then I verify "2nd Checked" Deduction details of "500.00" amount at "1: Annually" frequency

    Then I click "NoDeductions" as deduction option only
    Then I click "STAF" as deduction option only
    Then I click "Self-employment tax" as deduction option with "75.00" amount at "Monthly" frequency
    Then I click continue on the Deductions page
    Then I validate I am on the "Deductions" page
    Then I verify error for Deductions option with no amount in "English"
    Then I verify error for Deductions option with no frequency in "English"
    Then I click "SETX" as deduction option only
    Then I click "SETX" as deduction option only
    Then I verify "2nd Checked" Deduction details of "75.00" amount at "3: Monthly" frequency

    Then I click "STAF" as deduction option only
    Then I click "SETX" as deduction option only
    Then I verify no error shows for Deductions page

    Then I click "NoDeductions" as deduction option only
    Then I verify no error shows for Deductions page
    Then I verify no errors show for Deductions options
    Then I click "NoDeductions" as deduction option only
    Then I verify no error shows for Deductions page
    Then I verify no errors show for Deductions options

    Then I click continue on the Deductions page
    Then I validate I am on the "Deductions" page
    Then I verify "English" error shows for Deductions page

    Then I click "NoDeductions" as deduction option only
    Then I verify no error shows for Deductions page
    Then I verify no errors show for Deductions options

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page



  @SLER-236 @PageVerificationDeductionsPage @TAMSmokeExch
  Scenario: SLER-236 I see the Errors Cleared on the Deductions page - Spanish
    And I change the language from header to "Spanish"
    Then I validate I am on the "Spanish" page

    Then I click "AOSS" as deduction option only
    Then I click continue on the Deductions page
    Then I validate I am on the "Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish"
    Then I verify error for Deductions option with no frequency in "Spanish"

    Then I click "NoDeductions" as deduction option only
    Then I click "AOSS" as deduction option only
    Then I verify no errors show for Deductions options
    Then I click "AOSS" as deduction option only

    Then I click "DPAC" as deduction option only
    Then I click continue on the Deductions page
    Then I validate I am on the "Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish"
    Then I verify error for Deductions option with no frequency in "Spanish"

    Then I click "NoDeductions" as deduction option only
    Then I click "DPAC" as deduction option only
    Then I verify no errors show for Deductions options
    Then I click "DPAC" as deduction option only

    Then I click "HSAC" as deduction option only
    Then I click "Pre-tax retirement account contribution" as deduction option with "500.00" amount at "Anualmente" frequency
    Then I click continue on the Deductions page
    Then I validate I am on the "Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish"
    Then I verify error for Deductions option with no frequency in "Spanish"

    Then I click "NoDeductions" as deduction option only
    Then I click "HSAC" as deduction option only
    Then I click "PRAC" as deduction option only
    Then I verify no errors show for Deductions options
    Then I verify "2nd Checked" Deduction details of "500.00" amount at "1: Annually" frequency

    Then I click "NoDeductions" as deduction option only
    Then I click "STAF" as deduction option only
    Then I click "Self-employment tax" as deduction option with "75.00" amount at "Mensualmente" frequency
    Then I click continue on the Deductions page
    Then I validate I am on the "Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish"
    Then I verify error for Deductions option with no frequency in "Spanish"
    Then I click "SETX" as deduction option only
    Then I click "SETX" as deduction option only
    Then I verify "2nd Checked" Deduction details of "75.00" amount at "3: Monthly" frequency

    Then I click "STAF" as deduction option only
    Then I click "SETX" as deduction option only
    Then I verify no error shows for Deductions page

    Then I click "NoDeductions" as deduction option only
    Then I verify no error shows for Deductions page
    Then I verify no errors show for Deductions options
    Then I click "NoDeductions" as deduction option only
    Then I verify no error shows for Deductions page
    Then I verify no errors show for Deductions options

    Then I click continue on the Deductions page
    Then I validate I am on the "Deductions" page
    Then I verify "Spanish" error shows for Deductions page

    Then I click "NoDeductions" as deduction option only
    Then I verify no error shows for Deductions page
    Then I verify no errors show for Deductions options

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1207 @PageVerificationDeductionsPage
  Scenario: SLER-1207 I verify that income-portal-ui uses common components from ng-common on the Deductions page in EXCH
    Then I verify Deductions checkbox in "Not Selected" state
    Then I verify Deductions checkbox in "Selected" state
    Then I verify Deductions checkbox in "Focus" state
    Then I verify Deductions checkbox in "Hover" state

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2260
  Scenario: SLER-2260 As an Exchange user on the ELMO Income pages, I want errors cleared on the Deductions page so that I don't see errors when I select an option
    Then I click continue on the Deductions page
    Then I verify "English" error shows for Deductions page
    Then I verify all checkbox deduction errors for "English"
    And I change the language from header to "Spanish"
    Then I validate I am on the "Spanish" page
    Then I verify all checkbox deduction errors for "Spanish"
    And I click on Sign Out in the Header for "Elmo"

  @SLER-2284
  Scenario: SLER-2284 ELIG-DB: As an Exchange user on the Deductions page, I want to be able to save, update and remove my deduction information so that my deduction information is available and accurate

    Then I validate I am on the "Deductions" page
    Then I click "School tuition and fees" as deduction option with "1000.00" amount at "Monthly" frequency
    Then I click "Student loan interest" as deduction option with "500.00" amount at "Annually" frequency
    Then I click continue on the Deductions page
    #DB STep
    Then I validate the deduction for kind "STAF" with amount "1000.00" and frequency "Monthly" in DB
    Then I validate the deduction for kind "STLI" with amount "500.00" and frequency "Annually" in DB
    And  I click on Go Back on income summary page
    Then I validate I am on the "Deductions" page
    Then I click "STAF" as deduction option only
    Then I click "Pre-tax retirement account contribution" as deduction option with "5000.00" amount at "Annually" frequency
    Then I click continue on the Deductions page
    #DB STep
    Then I validate I am on the "Income Summary" page
    Then I validate the deduction for kind "PRAC" with amount "5000.00" and frequency "Annually" in DB
    Then I validate the deduction for kind "STLI" with amount "500.00" and frequency "Annually" in DB
    And  I click on Go Back on income summary page
    Then I validate I am on the "Deductions" page
    Then I click "STLI" as deduction option only
    Then I click "PRAC" as deduction option only
    Then I click "Alimony or spousal support paid out" as deduction option with "9000.00" amount at "Annually" frequency
    Then I click "Self-employment tax" as deduction option with "7000.00" amount at "Weekly" frequency
    Then I click continue on the Deductions page
    #DB STep
    Then I validate I am on the "Income Summary" page
    Then I validate the deduction for kind "AOSS" with amount "9000.00" and frequency "Annually" in DB
    Then I validate the deduction for kind "SETX" with amount "7000.00" and frequency "Weekly" in DB
    And  I click on Go Back on income summary page
    Then I validate I am on the "Deductions" page
    Then I click "AOSS" as deduction option only
    Then I click "SETX" as deduction option only

    Then I click "Moving expenses" as deduction option with "9000.00" amount at "Annually" frequency
    Then I click "Self-employment retirement plan" as deduction option with "7000.00" amount at "Weekly" frequency
    Then I click continue on the Deductions page
    #DB STep
    Then I validate I am on the "Income Summary" page
    Then I validate the deduction for kind "MOVE" with amount "9000.00" and frequency "Annually" in DB
    Then I validate the deduction for kind "SERP" with amount "7000.00" and frequency "Weekly" in DB
    And  I click on Go Back on income summary page
    Then I validate I am on the "Deductions" page
    Then I click "NoDeductions" as deduction option only
    And I click on Sign Out in the Header for "Elmo"

  @SLER-2371
  Scenario: navigation on the ELMO Deductions Page in EXCH [RT-2582]
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
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
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    And  I click on Go Back on income summary page
    Then I validate I am on the "Deductions" page
