@TAM @TamExch
Feature: Page Text-Income Page

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
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "07271963", "Female" and applying "Yes"
      |Primary:Spouse|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    And I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "45000.00" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Employment Income" page

  @SLER-2405 @PageTextEmploymentIncome
  Scenario: SLER-2405 ELIG-Page Text-Additional Member Employment Income - English Validations(RT-2720)
    Then I verify the page text for secondary member on Employment Income page, which is in initial state
      | Income:                                          |
      | Employment Income                                |
      | Do you have a job or are you currently employed? |
      | Yes                                              |
      | No                                               |
      | Go back                                          |
      | Save and continue                                |
      | Help                                             |
    Then I select the option "Yes" to employment
    Then I verify the page text for secondary member on Employment Income page after clicking yes to employment
      | Income:                                          |
      | Employment Income                                |
      | Do you have a job or are you currently employed? |
      | Yes                                              |
      | No                                               |
      | Go back                                          |
      | Save and continue                                |
      | Help                                             |
      | Is this job self-employment?                     |
      | Yes                                              |
      | No                                               |
    Then I verify the Yes button is selected for have a job or currently employed question
    And I select the option "Yes" to self employment
    Then I verify the page text for secondary member on Employment Income page after clicking yes to self employment question
      | Income:                                                                          |
      | Employment Income                                                                |
      | Do you have a job or are you currently employed?                                 |
      | Yes                                                                              |
      | No                                                                               |
      | Go back                                                                          |
      | Save and continue                                                                |
      | Help                                                                             |
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
    Then I verify the Yes button is selected for have a job or currently employed question
    And I verify the "Yes" button is selected for self-employment question
    And I validate the Net Income Frequency Dropdown Menu in "English"
    And I select the option "No" to self employment
    Then I verify the page text for secondary member on Employment Income page after clicking No to self employment question
      | Income:                                                                          |
      | Employment Income                                                                |
      | Do you have a job or are you currently employed?                                 |
      | Yes                                                                              |
      | No                                                                               |
      | Go back                                                                          |
      | Save and continue                                                                |
      | Help                                                                             |
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

  @SLER-2410 @PageTextEmploymentIncome
  Scenario: SLER-2410 ELIG-Page Text-Additional Member Employment Income -Spanish Validations(RT-2720)
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I verify the page text for secondary member on Employment Income page, which is in initial state
      | Ingresos:                               |
      | Ingresos por empleo                     |
      | ¿Tiene un trabajo o empleo actualmente? |
      | Sí                                      |
      | No                                      |
      | Volver                                  |
      | Guardar y continuar                     |
      | Ayuda                                   |
    Then I select the option "Yes" to employment
    Then I verify the page text for secondary member on Employment Income page after clicking yes to employment
      | Ingresos:                               |
      | Ingresos por empleo                     |
      | ¿Tiene un trabajo o empleo actualmente? |
      | Sí                                      |
      | No                                      |
      | Volver                                  |
      | Guardar y continuar                     |
      | Ayuda                                   |
      | ¿Este trabajo es por cuenta propia?     |
      | Sí                                      |
      | No                                      |
    Then I verify the Yes button is selected for have a job or currently employed question
    And I select the option "Yes" to self employment
    Then I verify the page text for secondary member on Employment Income page after clicking yes to self employment question
      | Ingresos:                                                                                                  |
      | Ingresos por empleo                                                                                        |
      | ¿Tiene un trabajo o empleo actualmente?                                                                    |
      | Sí                                                                                                         |
      | No                                                                                                         |
      | Volver                                                                                                     |
      | Guardar y continuar                                                                                        |
      | Ayuda                                                                                                      |
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
    Then I verify the Yes button is selected for have a job or currently employed question
    And I verify the "Yes" button is selected for self-employment question
    And I validate the Net Income Frequency Dropdown Menu in "Spanish"
    And I select the option "No" to self employment
    Then I verify the page text for secondary member on Employment Income page after clicking No to self employment question
      | Ingresos:                                                                                                  |
      | Ingresos por empleo                                                                                        |
      | ¿Tiene un trabajo o empleo actualmente?                                                                    |
      | Sí                                                                                                         |
      | No                                                                                                         |
      | Volver                                                                                                     |
      | Guardar y continuar                                                                                        |
      | Ayuda                                                                                                      |
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