@TAM @TamExch
Feature: Page Text-Income Opt Out Page

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
    And I Apply for financial help

    And I validate I am on the "Employment Income" page

  @SLER-240 @PageTextEmploymentIncome @TAMSmokeExch
  Scenario: SLER-240 I can see Employment Income's Header and footer - English
    Then I validate I am on the "Employment Income" page
    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
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

    Then I validate I am on the "Employment Income" page
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

    Then I validate I am on the "Employment Income" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
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

    Then I validate I am on the "Employment Income" page
    And I click on My Account in the "Elmo" Header
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

    Then I validate I am on the "Employment Income" page
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "Employment Income" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    Then I validate I am on the "Employment Income" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "ExpertHelp" Header
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

    Then I validate I am on the "Employment Income" page
    And I click on the Username in the "Exch" Header
    Then I validate I am on the "My Profile" page
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

    Then I validate I am on the "Employment Income" page
#    And I set the browser resolution to 1200 x 800
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "Employment Income" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "Employment Income" page
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "Employment Income" page
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "Employment Income" page
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "Employment Income" page
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "Employment Income" page
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "Employment Income" page
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "Employment Income" page
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "Employment Income" page


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-241 @PageTextEmploymentIncome
  Scenario: SLER-241 I can see Employment Income's Header and footer - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
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

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
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

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
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

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on My Account in the "Elmo" Header
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

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "ExpertHelp" Header
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

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on the Username in the "Exch" Header
    Then I validate I am on the "My Profile" page
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

    And I validate I am on the "Employment Income" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
#    And I set the browser resolution to 1200 x 800
    Then I validate I am on the "Employment Income" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "Employment Income" page
    Then I validate Employment Info Page header in "Spanish"


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2072 @PageTextEmploymentIncome
  Scenario: SLER-2072-ELIG-Income-Page Text(RT-995)
    Then I Verify the page text on Employment Income page, which is in initial state
      | Income:                                          |
      | Employment Income                                |
      | Do you have a job or are you currently employed? |
      | Yes                                              |
      | No                                               |
      | Go back                                          |
      | Save and continue                                |
    Then I select the option "Yes" to employment
    Then I Verify the page text on Employment Income page after clicking yes to employment
      | Income:                                          |
      | Employment Income                                |
      | Do you have a job or are you currently employed? |
      | Yes                                              |
      | No                                               |
      | Go back                                          |
      | Save and continue                                |
      | Is this job self-employment?                     |
      | Yes                                              |
      | No                                               |
    And I select the option "Yes" to self employment
    Then I Verify the page text on Employment Income page after clicking yes to self employment question
      | Income:                                                                          |
      | Employment Income                                                                |
      | Do you have a job or are you currently employed?                                 |
      | Yes                                                                              |
      | No                                                                               |
      | Go back                                                                          |
      | Save and continue                                                                |
      | Is this job self-employment?                                                     |
      | Yes                                                                              |
      | No                                                                               |
      | Company Name (Company or job name can be informal. They are for reference only.) |
      | What is your current net income from this company or job?                        |
      | Enter profit once expenses are paid.                                             |
      | amount                                                                           |
      | Select Option                                                                    |
      | Will this income be the same or lower next year?                                 |
      | Yes                                                                              |
      | No                                                                               |
    And I select the option "No" to self employment
    Then I Verify the page text on Employment Income page after clicking No to self employment question
      | Income:                                                                          |
      | Employment Income                                                                |
      | Do you have a job or are you currently employed?                                 |
      | Yes                                                                              |
      | No                                                                               |
      | Go back                                                                          |
      | Save and continue                                                                |
      | Is this job self-employment?                                                     |
      | Yes                                                                              |
      | No                                                                               |
      | Company Name (Company or job name can be informal. They are for reference only.) |
      | amount                                                                           |
      | Select Option                                                                    |
      | Will this income be the same or lower next year?                                 |
      | Yes                                                                              |
      | No                                                                               |
      | Address line 1                                                                   |
      | Address line 2                                                                   |
      | City                                                                             |
      | State                                                                            |
      | Select Option                                                                    |
      | ZIP Code                                                                         |
      | What is your current gross income from this company or job?                      |
      | Include commission or tips earned.                                               |
      | Is this income part of seasonal, commission, or tip based employment?            |
      | Yes                                                                              |
      | No                                                                               |
    And I refresh the page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I Verify the page text on Employment Income page, which is in initial state
      | Ingresos:                               |
      | Ingresos por empleo                     |
      | ¿Tiene un trabajo o empleo actualmente? |
      | Sí                                      |
      | No                                      |
      | Volver                                  |
      | Guardar y continuar                     |
    Then I select the option "Yes" to employment
    Then I Verify the page text on Employment Income page after clicking yes to employment
      | Ingresos:                               |
      | Ingresos por empleo                     |
      | ¿Tiene un trabajo o empleo actualmente? |
      | Sí                                      |
      | No                                      |
      | Volver                                  |
      | Guardar y continuar                     |
      | ¿Este trabajo es por cuenta propia?     |
      | Sí                                      |
      | No                                      |
    Then I select the option "Yes" to self employment
    Then I Verify the page text on Employment Income page after clicking yes to self employment question
      | Ingresos:                                                                                                  |
      | Ingresos por empleo                                                                                        |
      | ¿Tiene un trabajo o empleo actualmente?                                                                    |
      | Sí                                                                                                         |
      | No                                                                                                         |
      | Volver                                                                                                     |
      | Guardar y continuar                                                                                        |
      | ¿Este trabajo es por cuenta propia?                                                                        |
      | Sí                                                                                                         |
      | No                                                                                                         |
      | Nombre de la empresa (El nombre de la empresa o del trabajo puede ser informal. Son solo para referencia.) |
      | ¿Cuál es su ingreso neto actual de esta empresa o trabajo?                                                 |
      | Ingresar ganancias una vez que se pagan los gastos.                                                        |
      | cantidad                                                                                                   |
      | Seleccionar opción                                                                                         |
      | ¿Espera que ese ingreso se mantenga igual o que baje el próximo año?                                       |
      | Sí                                                                                                         |
      | No                                                                                                         |
    And I select the option "No" to self employment
    Then I Verify the page text on Employment Income page after clicking No to self employment question
      | Ingresos:                                                                                                  |
      | Ingresos por empleo                                                                                        |
      | ¿Tiene un trabajo o empleo actualmente?                                                                    |
      | Sí                                                                                                         |
      | No                                                                                                         |
      | Volver                                                                                                     |
      | Guardar y continuar                                                                                        |
      | ¿Este trabajo es por cuenta propia?                                                                        |
      | Sí                                                                                                         |
      | No                                                                                                         |
      | Nombre de la empresa (El nombre de la empresa o del trabajo puede ser informal. Son solo para referencia.) |
      | cantidad                                                                                                   |
      | Seleccionar opción                                                                                         |
      | ¿Espera que ese ingreso se mantenga igual o que baje el próximo año?                                       |
      | Sí                                                                                                         |
      | No                                                                                                         |
      | Domicilio 1                                                                                                |
      | Domicilio 2                                                                                                |
      | Ciudad                                                                                                     |
      | Estado                                                                                                     |
      | Seleccionar opción                                                                                         |
      | Código postal                                                                                              |
      | ¿Cuál es su ingreso bruto actual de esta empresa o trabajo?                                                |
      | Incluir la comisión o las propinas ganadas.                                                                |
      | ¿Este ingreso es parte de un trabajo temporal, por comisiones o por propinas?                              |
      | Sí                                                                                                         |
      | No                                                                                                         |
    And I click on Sign Out in the Header for "Elmo"

  @SLER-2233
  Scenario: SLER-2233 ELIG-Self-Employment (MA Questions)-Page Text [RT-1023]
    Then I click continue on the Employment Info Page
    And I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option
    And I click continue on the Additional Income page
    Then I click None of these as deduction option and continue
    And I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    And I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on "Continue" on good news page
    Then I select "No" for under the age of 19 question and Continue on ParentCaretaker MA page
    Then I select "No" temporarily absent from Colorado question and Continue on Out Of State MA page
    Then I select "No" for attending school full-time question and Continue on Full-Time Student MA page
    Then I select "No" for medical condition or disability question and Continue on Medical Condition MA page
    Then I select "No" for medical expenses question and Continue on Medical Expenses MA page
    Then I validate the Page Text on the Self-Employment MA page in "English"
      |Label:|
      | Is anyone in the household self-employed? |
      | Self-Employment                           |
      | Help me understand this page              |
      | Yes                                       |
      | No                                        |
    And I change the language from header to "Spanish NonElmo"
    Then I validate the Page Text on the Self-Employment MA page in "Spanish"
      |Label:|
      | ¿Alguien de su familia trabaja por cuenta propia? |
      | Trabajador independiente                          |
      | Ayuda para entender esta página                   |
      | Sí                                                |
      | No                                                |


  @SLER-2303
  Scenario: SLER-2303 As a Exch account user on the Employment Income details page, I want to see my dynamic data so that I can verify my employer income information
    Then I Verify the page text on Employment Income page, which is in initial state
      | Income:                                          |
      | Employment Income                                |
      | Do you have a job or are you currently employed? |
      | Yes                                              |
      | No                                               |
      | Go back                                          |
      | Save and continue                                |
    Then I select the option "Yes" to employment
    Then I Verify the page text on Employment Income page after clicking yes to employment
      | Income:                                          |
      | Employment Income                                |
      | Do you have a job or are you currently employed? |
      | Yes                                              |
      | No                                               |
      | Go back                                          |
      | Save and continue                                |
      | Is this job self-employment?                     |
      | Yes                                              |
      | No                                               |

    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I click on the Back button on the Additionalincomepage
    Then I verify that the No Employment button is enabled

    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "333 Some Road" and city as "Boulder" and state as "CO" and zipcode as "80020" and income "1500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click Edit on Income Summary row 1
    Then I validate that the employment status label is not present
    And I select the option "Yes" to self employment
    And I click continue on the Employment Info Page
    Then I click on Add job or self-employment on the Employment Summary Page
    Then I validate that the employment status label is not present
    And I click on Sign Out in the Header for "Elmo"

    @SLER-2349
    Scenario: SLER-2349 As an Exchange account user on the Employment Income page, I see the structure of the page so that I can provide my basic income information
      Then I Verify the page text on Employment Income page, which is in initial state
        | Income:                                          |
        | Employment Income                                |
        | Do you have a job or are you currently employed? |
        | Yes                                              |
        | No                                               |
        | Go back                                          |
        | Save and continue                                |
      Then I validate page Navigation works for Footer hyperlink text in "English"
        | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
        | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
        | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
        | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
        | FacebookIcon   | Facebook          | facebook.com                          |
        | xIcon          | X                 | x.com                                 |
        | YouTubeIcon    | YouTube           | youtube.com                           |
        | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
        | InstagramIcon  | Login • Instagram | instagram.com                         |
        | ThreadsIcon    | Threads           | threads.com                           |
      Then I validate Employment Income page for text design
      Then I select the option "Yes" to employment
      Then I validate Employment Income page for YesOption text design
      And I select the option "No" to self employment
      Then I validate Employment Income page for NoOption text design
      Then I click go back button on the Employment Info Page
      And I click plus icon next to member on household page for "Primary"
      And I click the edit income icon on household page for "Primary"
      Then I select the option "Yes" to employment
      Then I select the option "No" to employment
      And I click on Sign Out in the Header for "Elmo"




