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
  Scenario: SLER-2371 Verify navigation on the ELMO Deductions Page in EXCH
    When I click on Sign Out in the Header for "Elmo"
    Then I open the login page on the "login" portal
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

  @SLER-2390
  Scenario: SLER-2390 Verify the ability to see the page so that I can review and update the income information in English
    Then I verify color size format of the header and other page texts other than check boxes
      | Income:                                                      |
      | Deductions                                                   |
      | Do you have any of the following expenses?                   |
      | Select all that apply, and enter the amount of each expense. |
    Then I verify all deduction options color size format text order and check boxes for "English"
      | Alimony or spousal support paid out     |
      | Domestic production activities          |
      | Health Savings Account contribution     |
      | Pre-tax retirement account contribution |
      | School tuition and fees                 |
      | Self-employment tax                     |
      | Student loan interest                   |
      | Self-employment health insurance        |
      | Self-employment retirement plan         |
      | Moving expenses                         |
      | None of these                           |
    Then I click "AOSS" as deduction option only
    Then I validate default property of amount box and dropdown for "English"
      | Select Option |
      | Annually      |
      | Every 2 weeks |
      | Monthly       |
      | Twice a month |
      | Weekly        |
    Then I click "AOSS" as deduction option only
    And I select "Alimony" as deduction option with "200.00" amount at "Annually" frequency
    Then I verify amount "200.00"  and frequency "Annually" is selected correctly
    Then I verify when None_of_these selected,other checkboxes not selected
    Then I verify font color size of the back and save button in deductions page when mouse_Hover is "Off"
    Then I verify font color size of the back and save button in deductions page when mouse_Hover is "On"

  @SLER-2406
  Scenario: SLER-2406 Verify the ability to see the page so that I can review and update the income information in Spanish(RT-2585)
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I verify color size format of the header and other page texts other than check boxes
      | Ingresos:                                                                   |
      | Deducciones                                                                 |
      | ¿Tiene alguno de los siguientes gastos?                                     |
      | Seleccione todos los que correspondan, e ingrese la cantidad de cada gasto. |
    Then I verify all deduction options color size format text order and check boxes for "Spanish"
      | Pensión alimenticia o apoyo conyugal que paga     |
      | Actividades de producción para el mercado interno |
      | Aporte a cuenta de ahorros de salud               |
      | Aporte a la cuenta de retiro antes de impuestos   |
      | Colegiatura y cuotas escolares                    |
      | Impuesto al trabajo independiente                 |
      | Interés por préstamo de estudiante                |
      | Seguro de salud de trabajador independiente       |
      | Plan de retiro como trabajador independiente      |
      | Gastos de mudanza                                 |
      | Ninguna de las anteriores                         |
    Then I click "AOSS" as deduction option only
    Then I validate default property of amount box and dropdown for "Spanish"
      | Seleccionar opción |
      | Anualmente         |
      | Cada dos semanas   |
      | Mensualmente       |
      | Dos veces por mes  |
      | Semanalmente       |
    Then I click "AOSS" as deduction option only
    And I select "Alimony" as deduction option with "200.00" amount at "Anualmente" frequency
    Then I verify amount "200.00"  and frequency "Anualmente" is selected correctly
    Then I verify when None_of_these selected,other checkboxes not selected
    Then I verify font color size of the back and save button in deductions page when mouse_Hover is "Off"
    Then I verify font color size of the back and save button in deductions page when mouse_Hover is "On"

  @SLER-2412
  Scenario:  SLER-2412 As an Exch user, I want to see the ELMO Deductions page so that I can enter my deduction information [RT-2602]
    When I click on Sign Out in the Header for "Elmo"
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