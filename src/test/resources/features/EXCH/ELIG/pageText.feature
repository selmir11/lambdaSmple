@ELIG
Feature: Verify all English and Spanish Text on ELIG pages

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-38 @PageText
  Scenario: Verify English Text on the Let us guide you page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I validate the verbiage on Let us guide you page in "English"

  @SLER-47 @PageText
  Scenario: Verify English Text on the Enter Case Info page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "Yes" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Enter Case ID" page
    And I validate the verbiage on the Enter Case ID page in "English"

  @SLER-58 @PageText
  Scenario: Verify English Text on the Before you begin page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I validate the verbiage on the Before you begin page in "English"

  @SLER-66 @PageText
  Scenario: Verify English Text on the Report a life change (Initial) page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I validate the verbiage on the Report a life change page in "English"

  @SLER-75 @PageText
  Scenario: Verify English Text on the Identity Proofing - Initial page
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    And I validate the verbiage on the Identity Proofing - Initial page in "English"

  @SLER-79 @PageText
  Scenario: Verify English Text on the Congratulations! (RIDP) page
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I validate the verbiage on the RIDP - Congratulations page in "English"

  @SLER-219 @PageText
  Scenario: Verify Spanish Text on the Let us guide you page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    When I change the language from header to "Spanish NonElmo"
    And I validate I am on the "Spanish" page
    And I validate the verbiage on Let us guide you page in "Spanish"

  @SLER-220 @PageText
  Scenario: Verify Spanish Text on Enter Case Info page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "Yes" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Enter Case ID" page
    When I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    And I validate the verbiage on the Enter Case ID page in "Spanish"

  @SLER-221 @PageText
  Scenario: Verify Spanish Text on the Before you begin page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    When I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    And I validate the verbiage on the Before you begin page in "Spanish"

  @SLER-222 @PageText
  Scenario: Verify Spanish Text on the Report a life change (Initial) page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    When I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    And I validate the verbiage on the Report a life change page in "Spanish"

  @SLER-223 @PageText
  Scenario: Verify Spanish Text on the Identity Proofing - Initial page
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    When I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    Then I select "member" from the who are you question
    And I validate the verbiage on the Identity Proofing - Initial page in "Spanish"

  @SLER-224 @PageText
  Scenario: Verify Spanish Text on the Congratulations! (RIDP) page
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    When I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    And I validate the verbiage on the RIDP - Congratulations page in "Spanish"

  @SLER-242 @PageText
  Scenario: Verify English Text on the Citizenship and immigration status page
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
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
    Then I validate I am on the "Citizenship" page
    And I verify the text on the Citizenship and Immigration Status page in "English"
    | Citizenship and immigration status: |
    | Help me understand this page |
    | Are you a U.S. Citizen? |
    | Yes |
    | No |
    Then I select "Yes" for Citizen option
    And I verify the text for Naturalized Citizen in "English"
    | Are you a Naturalized Citizen? |
    | Yes |
    | No |
    Then I select "No" for Citizen option
    And I verify the text for Eligible Immigration Status in "English"
      | Do you have an eligible immigration status or are you authorized to work in the U.S.?                                                                                                         |
      | Starting November 1, 2024, DACA status is considered an eligible immigration status. People with DACA status will be able to enroll in a plan and get financial help through the marketplace. |
      | Yes                                                                                                                                                                                           |
      | No                                                                                                                                                                                            |
    Then I select "Yes" for Eligible Immigration Status option
    Then I verify the text Document Type in "English"
      | Document type |
    Then I verify the Document Type dropdown options in "English"
      | Select Option|
      | I-327 Reentry Permit |
      | I-551 Permanent Resident Card |
      | I-571 Refugee Travel Document |
      | I-766 Employment Authorization Card |
      | Machine Readable Immigrant Visa (with Temporary I-551 Language) |
      | Temporary I-551 Stamp (on passport or I-94) |
      | I-94 (Arrival/Departure Record) |
      | I-94 (Arrival/Departure Record) in Unexpired Foreign Passport |
      | I-20 (Certificate of Eligibility for Nonimmigrant (F-1) Student Status) |
      | DS2019 (Certificate of Eligibility for Exchange Visitor (J-1) Status) |
      | Other |
    Then I select "No" for Eligible Immigration Status option
    And I verify the text for undocumented citizen information in 'English'

  @SLER-253 @PageText
  Scenario: Verify Spanish Text on the Citizenship and immigration status page
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
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
    Then I validate I am on the "Citizenship" page
    When I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    Then I validate I am on the "Citizenship" page
    And I verify the text on the Citizenship and Immigration Status page in "Spanish"
      | Ciudadanía y estatus migratorio: |
      | Ayuda para entender esta página |
      | ¿Es usted ciudadano/a de Estados Unidos? |
      | Sí |
      | No |
    Then I select "Yes" for Citizen option
    And I verify the text for Naturalized Citizen in "Spanish"
    | ¿Es usted ciudadano/a naturalizado(a) de Estados Unidos? |
    | Sí |
    | No |
    Then I select "No" for Citizen option
    And I verify the text for Eligible Immigration Status in "Spanish"
      | ¿Tiene un estatus migratorio elegible o tiene autorización para trabajar en los Estados Unidos?                                                                                                                               |
      | A partir del 1º de noviembre de 2024, el estatus de DACA se considera como un estatus migratorio elegible. Las personas con el estatus de DACA podrán inscribirse en un plan y recibir ayuda financiera a través del Mercado. |
      | Sí                                                                                                                                                                                                                            |
      | No                                                                                                                                                                                                                            |
    Then I select "Yes" for Eligible Immigration Status option
    Then  I verify the text Document Type in "Spanish"
      | Tipo de documento |
    Then I verify the Document Type dropdown options in "Spanish"
      | Seleccione |
      | Permiso de reingreso I-327 |
      | Tarjeta de residente permanente I-551 |
      | Documento de viaje para refugiado I-571 |
      | Tarjeta de autorización de empleo I-766 |
      | Visa de inmigrante legible por máquina (con idioma temporal I-551) |
      | Sello temporal I-551 (en el pasaporte o I-94) |
      | I-94 (Registro de entrada/salida) |
      | I-94 (Registro de entrada/salida) en pasaporte extranjero vigente |
      | I-20 (Certificado de elegibilidad para estatus de estudiante no inmigrante; F-1) |
      | DS2019 (Certificado de elegibilidad para estatus de visitante de intercambio; J-1) |
      | Otro |
    Then I select "No" for Eligible Immigration Status option
    And I verify the text for undocumented citizen information in 'Spanish'

    @SLER-541 @PageText
    Scenario: Verify the help drawer text and urls on Report a life change page
      When I click create a new account on login page
      Then I click create my account from pre-screen page
      And I enter general mandatory data for "exchange" account creation
      Then I validate I am on the "Login" page
      And I enter valid credentials to login
      Then I validate I am on the "Account Overview" page
      And I apply for the current year
      Then I validate I am on the "Let us guide you" page
      And I select "No" option on the Let us guide you page
      And I click on save and continue button
      Then I click on continue with  application button on Before you begin page
      Then I validate I am on the "Report a life change" page
      Then I click on the help drawer icon on the page
      And I validate the below help drawer text in "English"
      | Help |
      | Qualified Life Change Event |
      | Overview |
      | Select any Life Change Event that happened to you or someone in your household within the past 60 days. The loss of other health insurance can be reported up to 60 days before you lose your other insurance. |
      | Important for people losing Health First Colorado (Colorado's Medicaid program): If you are going to lose or have already lost Health First Colorado coverage, you are eligible for a Special Enrollment Period to sign up for a health insurance plan through July 2024. You can enroll as early as 60 days prior to the end of your Health First Colorado coverage. The sooner you enroll in a health insurance plan, the sooner your coverage begins. |
      | To see if you are qualified to enroll after losing your health insurance plan please visit: |
      | https://connectforhealthco.com/get-started/when-can-i-buy-insurance/ |
      | You can also check this box if your household's annual Modified Adjusted Gross Income is at or below 150% of the federal poverty level: |
      | https://www.healthcare.gov/glossary/federal-poverty-level-fpl/ |
      | Please use the list below to see the income limits by household size: |
      | 1 person: $22,590 |
      | 2 people: $30,660 |
      | 3 people: $38,730 |
      | 4 people: $46,800 |
      | 5 people: $54,870 |
      | 6 people: $62,940 |
      | 7 people: $71,010 |
      | 8 people: $79,080 |
      | 9 people: $87,150 |
      | 10 people: $95,220 |
      | Need more help? |
      | Contact us |

  @SLER-542 @PageText
  Scenario: Verify the spanish version of the help drawer text and urls on Report a life change page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    When I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    Then I click on the help drawer icon on the page
    And I validate the below help drawer text in "Spanish"
      | Ayuda |
      | Evento de cambio de vida calificado |
      | Resumen |
      | Seleccione el evento de vida calificado que usted o alguien de su familia haya tenido en los últimos 60 días. La pérdida de otro seguro de salud se puede reportar hasta 60 días antes de que lo pierda. |
      | Importante para las personas que pierden Health First Colorado (Programa Medicaid de Colorado): Si va a perder la cobertura con Health First Colorado o ya la perdió, es elegible para un período de inscripción especial durante el cual podrá inscribirse en un plan de seguro de salud hasta julio de 2024. Puede inscribirse desde 60 días antes de que finalice su cobertura con Health First Colorado. Mientras más pronto se inscriba en un plan de seguro de salud, más pronto comenzará su cobertura. |
      | Para averiguar si usted está calificado para inscribirse después de perder su seguro de salud, visite: |
      | https://connectforhealthco.com/es/comenzar/cuando-puedo-adquirir-un-seguro/ |
      | Marque esta casilla si el Ingreso bruto ajustado modificado anual de la familia es igual o inferior al 150% del nivel federal de pobreza: |
      | https://www.cuidadodesalud.gov/es/glossary/federal-poverty-level-fpl/ |
      | Vea la lista a continuación con los límites de ingresos por tamaño familiar: |
      | 1 persona: $22,590 |
      | 2 personas: $30,660 |
      | 3 personas: $38,730 |
      | 4 personas: $46,800 |
      | 5 personas: $54,870 |
      | 6 personas: $62,940 |
      | 7 personas: $71,010 |
      | 8 personas: $79,080 |
      | 9 personas: $87,150 |
      | 10 personas: $95,220 |
      | ¿Necesitas más ayuda? |
      | Contáctenos |

  @SLER-595 @PageText
  Scenario: Verify the help drawer text and urls on Life Change Events page - qlceConfirmation - second one
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
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
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "3700000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I click on the help drawer icon on the page
    And I validate the below help drawer text in "English"
      | Help |
      | Qualified Life Change Event |
      | Overview |
      | Select any Life Change Event that happened to you or someone in your household within the past 60 days. The loss of other health insurance can be reported up to 60 days before you lose your other insurance. |
      | Important for people losing Health First Colorado (Colorado's Medicaid program): If you are going to lose or have already lost Health First Colorado coverage, you are eligible for a Special Enrollment Period to sign up for a health insurance plan through July 2024. You can enroll as early as 60 days prior to the end of your Health First Colorado coverage. The sooner you enroll in a health insurance plan, the sooner your coverage begins. |
      | To see if you are qualified to enroll after losing your health insurance plan please visit: |
      | https://connectforhealthco.com/get-started/when-can-i-buy-insurance/ |
      | You can also check this box if your household's annual Modified Adjusted Gross Income is at or below 150% of the federal poverty level: |
      | https://www.healthcare.gov/glossary/federal-poverty-level-fpl/ |
      | Please use the list below to see the income limits by household size: |
      | 1 person: $22,590 |
      | 2 people: $30,660 |
      | 3 people: $38,730 |
      | 4 people: $46,800 |
      | 5 people: $54,870 |
      | 6 people: $62,940 |
      | 7 people: $71,010 |
      | 8 people: $79,080 |
      | 9 people: $87,150 |
      | 10 people: $95,220 |
      | Need more help? |
      | Contact us |

  @SLER-596 @PageText
  Scenario: Verify the spanish version of the help drawer text and urls on Life Change Events page - qlceConfirmation - second one
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
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
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "3700000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    When I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    Then I click on the help drawer icon on the page
    And I validate the below help drawer text in "Spanish"
      | Ayuda |
      | Evento de cambio de vida calificado |
      | Resumen |
      | Seleccione el evento de vida calificado que usted o alguien de su familia haya tenido en los últimos 60 días. La pérdida de otro seguro de salud se puede reportar hasta 60 días antes de que lo pierda. |
      | Importante para las personas que pierden Health First Colorado (Programa Medicaid de Colorado): Si va a perder la cobertura con Health First Colorado o ya la perdió, es elegible para un período de inscripción especial durante el cual podrá inscribirse en un plan de seguro de salud hasta julio de 2024. Puede inscribirse desde 60 días antes de que finalice su cobertura con Health First Colorado. Mientras más pronto se inscriba en un plan de seguro de salud, más pronto comenzará su cobertura. |
      | Para averiguar si usted está calificado para inscribirse después de perder su seguro de salud, visite: |
      | https://connectforhealthco.com/es/comenzar/cuando-puedo-adquirir-un-seguro/ |
      | Marque esta casilla si el Ingreso bruto ajustado modificado anual de la familia es igual o inferior al 150% del nivel federal de pobreza: |
      | https://www.cuidadodesalud.gov/es/glossary/federal-poverty-level-fpl/ |
      | Vea la lista a continuación con los límites de ingresos por tamaño familiar: |
      | 1 persona: $22,590 |
      | 2 personas: $30,660 |
      | 3 personas: $38,730 |
      | 4 personas: $46,800 |
      | 5 personas: $54,870 |
      | 6 personas: $62,940 |
      | 7 personas: $71,010 |
      | 8 personas: $79,080 |
      | 9 personas: $87,150 |
      | 10 personas: $95,220 |
      | ¿Necesitas más ayuda? |
      | Contáctenos |

  @SLER-628 @PageText
  Scenario: Verify the help icon text and urls on Report a life change page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    Then I click on the help icon next to special requirement option
    And I validate the below help drawer text in "English"
      | Help |
      | Qualified Life Change Event |
      | Overview |
      | Select any Life Change Event that happened to you or someone in your household within the past 60 days. The loss of other health insurance can be reported up to 60 days before you lose your other insurance. |
      | Important for people losing Health First Colorado (Colorado's Medicaid program): If you are going to lose or have already lost Health First Colorado coverage, you are eligible for a Special Enrollment Period to sign up for a health insurance plan through July 2024. You can enroll as early as 60 days prior to the end of your Health First Colorado coverage. The sooner you enroll in a health insurance plan, the sooner your coverage begins. |
      | To see if you are qualified to enroll after losing your health insurance plan please visit: |
      | https://connectforhealthco.com/get-started/when-can-i-buy-insurance/ |
      | You can also check this box if your household's annual Modified Adjusted Gross Income is at or below 150% of the federal poverty level: |
      | https://www.healthcare.gov/glossary/federal-poverty-level-fpl/ |
      | Please use the list below to see the income limits by household size: |
      | 1 person: $22,590 |
      | 2 people: $30,660 |
      | 3 people: $38,730 |
      | 4 people: $46,800 |
      | 5 people: $54,870 |
      | 6 people: $62,940 |
      | 7 people: $71,010 |
      | 8 people: $79,080 |
      | 9 people: $87,150 |
      | 10 people: $95,220 |
      | Need more help? |
      | Contact us |

  @SLER-629 @PageText
  Scenario: Verify the spanish version of the help icon text and urls on Report a life change page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    When I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    Then I click on the help icon next to special requirement option
    And I validate the below help drawer text in "Spanish"
      | Ayuda |
      | Evento de cambio de vida calificado |
      | Resumen |
      | Seleccione el evento de vida calificado que usted o alguien de su familia haya tenido en los últimos 60 días. La pérdida de otro seguro de salud se puede reportar hasta 60 días antes de que lo pierda. |
      | Importante para las personas que pierden Health First Colorado (Programa Medicaid de Colorado): Si va a perder la cobertura con Health First Colorado o ya la perdió, es elegible para un período de inscripción especial durante el cual podrá inscribirse en un plan de seguro de salud hasta julio de 2024. Puede inscribirse desde 60 días antes de que finalice su cobertura con Health First Colorado. Mientras más pronto se inscriba en un plan de seguro de salud, más pronto comenzará su cobertura. |
      | Para averiguar si usted está calificado para inscribirse después de perder su seguro de salud, visite: |
      | https://connectforhealthco.com/es/comenzar/cuando-puedo-adquirir-un-seguro/ |
      | Marque esta casilla si el Ingreso bruto ajustado modificado anual de la familia es igual o inferior al 150% del nivel federal de pobreza: |
      | https://www.cuidadodesalud.gov/es/glossary/federal-poverty-level-fpl/ |
      | Vea la lista a continuación con los límites de ingresos por tamaño familiar: |
      | 1 persona: $22,590 |
      | 2 personas: $30,660 |
      | 3 personas: $38,730 |
      | 4 personas: $46,800 |
      | 5 personas: $54,870 |
      | 6 personas: $62,940 |
      | 7 personas: $71,010 |
      | 8 personas: $79,080 |
      | 9 personas: $87,150 |
      | 10 personas: $95,220 |
      | ¿Necesitas más ayuda? |
      | Contáctenos |

  @SLER-630 @PageText
  Scenario: Verify the help icon text and urls on Life Change Events page - qlceConfirmation - second one
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
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
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "3700000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I click on the help icon next to special requirement option
    And I validate the below help drawer text in "English"
      | Help |
      | Qualified Life Change Event |
      | Overview |
      | Select any Life Change Event that happened to you or someone in your household within the past 60 days. The loss of other health insurance can be reported up to 60 days before you lose your other insurance. |
      | Important for people losing Health First Colorado (Colorado's Medicaid program): If you are going to lose or have already lost Health First Colorado coverage, you are eligible for a Special Enrollment Period to sign up for a health insurance plan through July 2024. You can enroll as early as 60 days prior to the end of your Health First Colorado coverage. The sooner you enroll in a health insurance plan, the sooner your coverage begins. |
      | To see if you are qualified to enroll after losing your health insurance plan please visit: |
      | https://connectforhealthco.com/get-started/when-can-i-buy-insurance/ |
      | You can also check this box if your household's annual Modified Adjusted Gross Income is at or below 150% of the federal poverty level: |
      | https://www.healthcare.gov/glossary/federal-poverty-level-fpl/ |
      | Please use the list below to see the income limits by household size: |
      | 1 person: $22,590 |
      | 2 people: $30,660 |
      | 3 people: $38,730 |
      | 4 people: $46,800 |
      | 5 people: $54,870 |
      | 6 people: $62,940 |
      | 7 people: $71,010 |
      | 8 people: $79,080 |
      | 9 people: $87,150 |
      | 10 people: $95,220 |
      | Need more help? |
      | Contact us |

  @SLER-631 @PageText
  Scenario: Verify the spanish version of the help icon text and urls on Life Change Events page - qlceConfirmation - second one
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
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
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "3700000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    When I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    Then I click on the help icon next to special requirement option
    And I validate the below help drawer text in "Spanish"
      | Ayuda |
      | Evento de cambio de vida calificado |
      | Resumen |
      | Seleccione el evento de vida calificado que usted o alguien de su familia haya tenido en los últimos 60 días. La pérdida de otro seguro de salud se puede reportar hasta 60 días antes de que lo pierda. |
      | Importante para las personas que pierden Health First Colorado (Programa Medicaid de Colorado): Si va a perder la cobertura con Health First Colorado o ya la perdió, es elegible para un período de inscripción especial durante el cual podrá inscribirse en un plan de seguro de salud hasta julio de 2024. Puede inscribirse desde 60 días antes de que finalice su cobertura con Health First Colorado. Mientras más pronto se inscriba en un plan de seguro de salud, más pronto comenzará su cobertura. |
      | Para averiguar si usted está calificado para inscribirse después de perder su seguro de salud, visite: |
      | https://connectforhealthco.com/es/comenzar/cuando-puedo-adquirir-un-seguro/ |
      | Marque esta casilla si el Ingreso bruto ajustado modificado anual de la familia es igual o inferior al 150% del nivel federal de pobreza: |
      | https://www.cuidadodesalud.gov/es/glossary/federal-poverty-level-fpl/ |
      | Vea la lista a continuación con los límites de ingresos por tamaño familiar: |
      | 1 persona: $22,590 |
      | 2 personas: $30,660 |
      | 3 personas: $38,730 |
      | 4 personas: $46,800 |
      | 5 personas: $54,870 |
      | 6 personas: $62,940 |
      | 7 personas: $71,010 |
      | 8 personas: $79,080 |
      | 9 personas: $87,150 |
      | 10 personas: $95,220 |
      | ¿Necesitas más ayuda? |
      | Contáctenos |

  @SLER-2019 @PageText
  Scenario: Verify English and Spanish Text for Parolee status on the Citizenship and immigration status page [RT-990]
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
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
    Then I validate I am on the "Citizenship" page
    Then I select "No" for Citizen option
    Then I select "Yes" for Eligible Immigration Status option
    Then I select "I-327 Reentry Permit" as Document type
    Then I enter A-Number USCIS number for "NonCitizen" on Lawful Presence page
    Then I select "None of the above" active-duty members of the military or honorably discharged veterans
    Then I select "Yes" for name matching the document
    And I click continue on the Citizenship page
    Then I select "No" for Lawful Permanent Resident
    Then I select "Paroled into the U.S." for immigration status
    Then I click continue on the Immigration Status page
    Then I verify text on the Immigration Status on "Paroled into the U.S"
      | Citizenship and Immigration Status:  |
      | Help me understand this page |
      | Immigration Status |
      | It looks like we need more information about your immigration status |
      | What is the grant date of your parolee status? |
      | mm/dd/yyyy |
      | < Back |
      | Save and Continue |
    And I change the language from header to "Spanish NonElmo"
    Then I verify text on the Immigration Status on "Paroled into the U.S"
      | Ciudadanía y estatus migratorio:   |
      | Ayuda para entender esta página |
      | Estatus Migratorio |
      | Al parecer, necesitamos más información sobre su estatus migratorio |
      | ¿Cuál es la fecha en la que se le otorgó su estatus de libertad condicional? |
      | mm/dd/yyyy |
      | < Atrás |
      | Guardar y Continuar |
    And I change the language from header to "English NonElmo"
    Then  I click on Sign Out in the Header for "NonElmo"


  @SLER-2029 @PageText
  Scenario: Verify English and Spanish Text for Applicant for asylum status on the Citizenship and immigration status page [RT-989]
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
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
    Then I validate I am on the "Citizenship" page
    Then I select "No" for Citizen option
    Then I select "Yes" for Eligible Immigration Status option
    Then I select "I-327 Reentry Permit" as Document type
    Then I enter A-Number USCIS number for "NonCitizen" on Lawful Presence page
    Then I select "None of the above" active-duty members of the military or honorably discharged veterans
    Then I select "Yes" for name matching the document
    And I click continue on the Citizenship page
    Then I select "No" for Lawful Permanent Resident
    Then I select "Applicant for asylum" for immigration status
    Then I click continue on the Immigration Status page
    Then I verify text on the Immigration Status on "Applicant for asylum"
      | Citizenship and Immigration Status:  |
      | Help me understand this page |
      | Immigration Status |
      | It looks like we need more information about your immigration status |
      | Are you authorized to work in the United States? |
      | Yes |
      | No |
      | < Back |
      | Save and Continue |
    And I change the language from header to "Spanish NonElmo"
    Then I verify text on the Immigration Status on "Applicant for asylum"
      | Ciudadanía y estatus migratorio:   |
      | Ayuda para entender esta página |
      | Estatus Migratorio |
      | Al parecer, necesitamos más información sobre su estatus migratorio |
      | ¿Está autorizado para trabajar en los Estados Unidos? |
      | Sí |
      | No |
      | < Atrás |
      | Guardar y Continuar |
    And I change the language from header to "English NonElmo"
    Then  I click on Sign Out in the Header for "NonElmo"

  @SLER-2051 @PageText
  Scenario: Verify English and Spanish Text for Conditional Entrant Granted before 1980 status on the Citizenship and immigration status page [RT-989]
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
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
    Then I validate I am on the "Citizenship" page
    Then I select "No" for Citizen option
    Then I select "Yes" for Eligible Immigration Status option
    Then I select "I-327 Reentry Permit" as Document type
    Then I enter A-Number USCIS number for "NonCitizen" on Lawful Presence page
    Then I select "None of the above" active-duty members of the military or honorably discharged veterans
    Then I select "Yes" for name matching the document
    And I click continue on the Citizenship page
    Then I select "No" for Lawful Permanent Resident
    Then I select "Conditional Entrant Granted before 1980" for immigration status
    Then I click continue on the Immigration Status page
    Then I verify text on the Immigration Status on "Conditional Entrant Granted before 1980"
      | Citizenship and Immigration Status:  |
      | Help me understand this page |
      | Immigration Status |
      | It looks like we need more information about your immigration status |
      | When was your immigration status granted? |
      | mm/dd/yyyy |
      | < Back |
      | Save and Continue |
    And I change the language from header to "Spanish NonElmo"
    Then I verify text on the Immigration Status on "Conditional Entrant Granted before 1980"
      | Ciudadanía y estatus migratorio:   |
      | Ayuda para entender esta página |
      | Estatus Migratorio |
      | Al parecer, necesitamos más información sobre su estatus migratorio |
      | ¿Cuándo se le otorgó su estatus migratorio? |
      | mm/dd/yyyy |
      | < Atrás |
      | Guardar y Continuar |
    And I change the language from header to "English NonElmo"
    Then  I click on Sign Out in the Header for "NonElmo"

  @SLER-2041 @PageValidation
  Scenario: ELIG-Let us guide you (Peak Application)-Page Text (RT-976)
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    Then I verify the text on Let us guide you page
      | If you have never enrolled with us before but have completed an application for Health First Colorado (Colorado's Medicaid Program) or Child Health Plan Plus (CHP+), we can save you time and pull the information you submitted previously. You will have a chance to review and change your information as needed. Would you like to search for a previously completed application? |
      | You will need your Case ID, which can be found on your Health First Colorado eligibility notice.                                                                                                                                                                                                                                                                                       |
      | Yes, I’m new to Connect for Health Colorado and I have completed an application for Health First Colorado or Child Health Plan Plus                                                                                                                                                                                                                                                    |
      | No thanks, take me to the application                                                                                                                                                                                                                                                                                                                                                  |
    And I change the language from header to "Spanish NonElmo"
    Then I verify the text on Let us guide you page
      | Si nunca se ha inscrito con nosotros antes pero ya presentó una solicitud para Health First Colorado (el programa Medicaid de Colorado) o Child Health Plan Plus (CHP+), podemos ahorrarle tiempo y extraer la información que envió antes. Usted tendrá la oportunidad de revisar y cambiar su información según sea necesario. ¿Desea buscar una solicitud previamente completada? |
      | Necesitará su identificación del caso que aparece en su aviso de elegibilidad de Health First Colorado.                                                                                                                                                                                                                                                                              |
      | Sí, soy nuevo a Connect for Health Colorado y ya presenté una solicitud Health First Colorado or Child Health Plan Plus                                                                                                                                                                                                                                                            |
      | No gracias, lléveme a la aplicación                                                                                                                                                                                                                                                                                                                                                |


  @SLER-2059 @PageText
  Scenario: Verify English and Spanish Text for Tell us about life changes page [RT-1012]
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for no financial help
    Then I validate I am on the "Tell us about life changes" page
    And I validate the verbiage on the Tell us about life changes page
      | Tell us about life changes |
      | Select any life change event you or someone in your household has experienced within the past 60 days. The loss of other health insurance, including Health First Colorado or Child Health Plans Plus, can be reported up to 60 days before you lose coverage. Members of federally recognized tribes and Alaska natives can enroll in coverage through Connect for Health Colorado anytime of the year. |
      | Help me understand this page |
      #LCE Types
      | Birth/Adoption/Foster Care/Court Order |
      | Pregnancy |
      | Marriage |
      | Divorce |
      | Death |
      | Change of primary residence |
      | Change of income or job |
      | Enrollment in future or existing health insurance |
      | Will lose/lost health insurance or my household's annual income meets special requirements |
      | Gained eligible immigration status |
      | Change of incarceration status |
      | Gain of American Indian/Alaskan Native tribal status |
      | Tax Time Enrollment Period  |
      | None of these apply to my household |
      #SubContent details for QLCEtpes
      |Who does this change apply to?       |
      |Event Date                           |
       #EventDate text for Loss of Coverage
      |Event Date: If you are losing Health First Colorado or CHP+ coverage, enter the date coverage ends. If it has already ended, enter today's date. If you are losing other coverage, please enter the last day of the month that you are covered.    |
     #Change of address addtional checkbox
      |Moved to Colorado                                                                                                                                                                                                                                  |
      #Additonal content for Pregancy
      |IMPORTANT                            |
      |When you become pregnant, you can enroll in a health insurance plan. Your coverage can start as early as the month in which a health care provider certified your pregnancy, or it can start on the first day of the month after you choose a plan.|
      |To enroll and choose the start date for your plan, call our Customer Service Center at 855-752-6749. You cannot enroll through your online account.                                                                                                |
    And I change the language from header to "Spanish NonElmo"
    And I validate the verbiage on the Tell us about life changes page
      | Infórmenos sobre los cambios importantes en la vida |
      | Seleccione los eventos de vida calificados que usted o alguien de su familia haya tenido en los últimos 60 días. Se puede reportar la pérdida de seguro de salud, incluyendo Health First Colorado o Child Health Plan Plus, hasta 60 días antes de que pierda la cobertura. Los miembros de las tribus reconocidas a nivel federal o los nativos de Alaska pueden inscribirse en la cobertura a través de Connect for Health Colorado en cualquier momento del año. |
      | Ayuda para entender esta página |
            #LCE Types
      | Nacimiento/Adopción/Colocación en hogar sustituto/Mandato judicial |
      | Embarazo |
      | Matrimonio |
      | Divorcio |
      | Muerte |
      | Cambio de residencia primaria |
      | Cambio de ingreso o trabajo |
      | Inscripción en seguro de salud futuro o actual |
      | Perderé o perdí el seguro de salud o mi ingreso familiar anual cumple con los requisitos especiales |
      | Obtención de estatus migratorio elegible |
      | Cambio en el estado de encarcelamiento |
      | Obtención de estatus de indígena norteamericano o nativo de Alaska |
      | Programa de Inscripción para la declaración de impuestos  |
      |Ninguno de estos se aplica a mi hogar |
      #SubContent details for QLCEtpes
      |¿A quién aplica este cambio?      |
      |Fecha del evento                           |
       #EventDate text for Loss of Coverage
      |Fecha del evento: (Si usted va a perder la cobertura de Health First Colorado o CHP+, ingrese la fecha en que terminará. Si ya terminó, ingrese la fecha de hoy). Si va a perder otra cobertura, ingrese el último día del mes en que estará cubierto.|
      #Change of address addtional checkbox
      |Mudanza a Colorado                                                                                                                                                                                                                                  |
      #Additonal content for Pregancy
      |IMPORTANTE                            |
      |Cuando se embaraza, usted puede inscribirse en un plan de seguro de salud. La cobertura puede comenzar el mes en que un proveedor de atención médica dé constancia del embarazo; o bien, puede comenzar el primer día del mes luego de que usted elija un plan.|
      |Para inscribirse y elegir la fecha de inicio de su plan, llame a nuestro Centro de atención al cliente al 855-752-6749. No puede inscribirse a través de su cuenta en línea.                                                                                   |
    And I change the language from header to "English NonElmo"
    Then  I click on Sign Out in the Header for "NonElmo"

  @SLER-2054 @PageText @WIP
  Scenario: ELIG-Declarations and Signature-Page Text (RT-1013)
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "MovedToColorado" and click continue
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with SSN "234345678" City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    Then I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
    Then I select "Male" as sex option
    Then I select "Yes" to Are You Applying
    Then I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    Then I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
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
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "NoneOfThese" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I verify the text on Declarations and Signature page in "English"
    And I change the language from header to "Spanish NonElmo"
    #TODO Spanish validation fails. Special characters need to be unicoded.
    Then I verify the text on Declarations and Signature page in "Spanish"

  @SLER-2050 @PageText
  Scenario: SLER-2050 Verify the Family Overview page text in English and Spanish
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
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

    Then I validate I am on the "Family Overview" page
    Then I validate the "English" text on the family overview page
    And I change the language from header to "Spanish NonElmo"
    Then I validate the "Spanish" text on the family overview page
    And I change the language from header to "English NonElmo"
    Then I click on Sign Out in the Header for "Household Page"

  @SLER-2060 @PageText
  Scenario: SLER-2060 - ELIG - verify text on Caretaker Page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
  # location change
    And I am a member with City "Denver" in State "CO" with dob "01011971" in county "DENVER" with zipcode "80220"
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

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
  #income variance
    And I enter employment details with "1000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue


    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    Then I click on "Continue" on good news page

    Then I validate I am on the "Parent/Caretaker" page
    And I validate the "English" text on the Caretaker page
    And I change the language from header to "Spanish NonElmo"
    And I validate the "Spanish" text on the Caretaker page
    And I change the language from header to "English NonElmo"
    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2116 @PageText
  Scenario: SLER-2116 - ELIG - verify text on Full Time Student Page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
  # location change
    And I am a member with City "Denver" in State "CO" with dob "01011971" in county "DENVER" with zipcode "80220"
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

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
  #income variance
    And I enter employment details with "1000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue


    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    Then I click on "Continue" on good news page

    Then I validate I am on the "Parent/Caretaker" page
    Then I select "No" for under the age of 19 question and Continue on ParentCaretaker MA page

    Then I select "No" temporarily absent from Colorado question and Continue on Out Of State MA page

    Then I validate I am on the "FullTimeStudent" page
    And I validate the "English" text on the FullTime Student page

    And I change the language from header to "Spanish NonElmo"
    And I validate the "Spanish" text on the FullTime Student page

    And I change the language from header to "English NonElmo"
    And I click continue on the FullTime Student page
    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2149 @PageText
  Scenario: SLER-2149 - ELIG - verify text on Medical Condition and Disability Page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
  # location change
    And I am a member with City "Denver" in State "CO" with dob "01011971" in county "DENVER" with zipcode "80220"
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

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
  #income variance
    And I enter employment details with "1000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue


    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    Then I click on "Continue" on good news page

    Then I validate I am on the "Parent/Caretaker" page
    Then I select "No" for under the age of 19 question and Continue on ParentCaretaker MA page

    Then I validate I am on the "Temporarily OutOfState" page
    Then I select "No" temporarily absent from Colorado question and Continue on Out Of State MA page

    Then I validate I am on the "FullTimeStudent" page
    Then I select "No" for attending school full-time question and Continue on Full-Time Student MA page

    Then I validate I am on the "Medical Condtion" page
    And I validate the "English" text on the Medical Condition MA page

    And I change the language from header to "Spanish NonElmo"
    And I validate the "Spanish" text on the Medical Condition MA page

    And I change the language from header to "English NonElmo"
    And I click continue on the Medical Condition MA page
    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2083 @PageText
  Scenario: SLER-2083 - ELIG - verify text on Out of State Page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
  # location change
    And I am a member with City "Denver" in State "CO" with dob "01011971" in county "DENVER" with zipcode "80220"
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

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
  #income variance
    And I enter employment details with "1000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue


    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    Then I click on "Continue" on good news page

    Then I validate I am on the "Parent/Caretaker" page
    Then I select "No" for under the age of 19 question and Continue on ParentCaretaker MA page
    And I click continue on the Caretaker page

    Then I validate I am on the "Temporarily OutOfState" page
    And I validate the "English" text on the Out of State MA page
    And I change the language from header to "Spanish NonElmo"
    And I validate the "Spanish" text on the Out of State MA page
    And I change the language from header to "English NonElmo"
    And I click continue on the Out of State MA page
    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2217 @PageText
  Scenario: Testing will verify the ARP BANNER/Start Here button is no longer Present
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I verify ARP Banner no longer present on Account Overview page
    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2219
  Scenario: ELIG-Select Immigration Status-Adult (Citizenship and Immigration status)-Page Text [RT-1089]
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "11181980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I verify the text on the Citizenship and Immigration Status page in "English"
      | Citizenship and immigration status: |
      | Help me understand this page |
      | Are you a U.S. Citizen? |
      | Yes |
      | No |
    Then I select "No" for Citizen option
    Then I select "Yes" for Eligible Immigration Status option
    Then I select "I-327 Reentry Permit" as Document type
    Then I enter A-Number USCIS number for "NonCitizen" on Lawful Presence page
    Then I select "None of the above" active-duty members of the military or honorably discharged veterans
    Then I select "Yes" for name matching the document
    And I click continue on the Citizenship page
    Then I select "No" for Lawful Permanent Resident
    Then I validate the immigration dropdown values for "English" language
      | Administrative order staying removal |
      | Afghan or Iraqi Special Immigrant Visa (SIV) holder |
      | Afghan or Ukrainian Humanitarian Parolee |
      | Applicant for adjustment to LPR status |
      | Applicant for asylum |
      | Applicant for Cancellation of Removal or Suspension of Deportation |
      | Applicant for legalization under the Immigration Reform and Control Act |
      | Applicant for Legalization under the LIFE Act |
      | Applicant/recipient for Temporary Protected Status |
      | Applicant for withholding of deportation or removal |
      | Citizen of Micronesia, the Marshall Islands, or Palau |
      | Conditional Entrant Granted before 1980 |
      | Cuban/Haitian Entrant |
      | Deferred Action Status (including DACA) |
      | Deferred Enforced Departure |
      | Granted Withholding of Deportation |
      | Native American born in Canada |
      | Non-immigrant visa holder |
      | Order of Supervision |
      | Paroled into the U.S. |
      | Refugee or asylee |
      | Registry applicant |
      | Resident of American Samoa |
      | Temporary Protected Status |
      | Temporary Resident Status |
      | Victim of battery/abuse (or victim's spouse, child, or parent) |

    When I change the language from header to "Spanish NonElmo"
    Then I select "No" for Lawful Permanent Resident
    Then I validate the immigration dropdown values for "Spanish" language
      | Afgano o iraquí titular de una visa especial de inmigrante (SIV) |
      | Afgano o Ucraniano en libertad condicional humanitaria |
      | Ciudadano de Micronesia, de las Islas Marshall y Palau |
      | En libertad condicional otorgada en EE. UU. |
      | Estatus de Acción Diferida (incluido DACA) |
      | Estatus de residente temporal |
      | Estatus temporalmente protegido |
      | Expulsión forzada aplazada |
      | Indígena norteamericano nacido en Canadá |
      | Orden administrativa de aplazamiento de traslado |
      | Orden de supervisión |
      | Participante condicional: estatus otorgado antes de 1980 |
      | Participante cubano o haitiano |
      | Refugiado o asilado |
      | Residente de Samoa Americana |
      | Solicitante de asilo |
      | Solicitante de cambio de estatus a residente permanente legal (LPR) |
      | Solicitante de cancelación de traslado o de suspensión de deportación |
      | Solicitante o sujeto de Estatus temporalmente protegido |
      | Solicitante de legalización según la Ley de Reforma y Control de la Inmigración |
      | Solicitante de Legalización según la ley LIFE |
      | Solicitante de registro |
      | Solicitante de suspensión de deportación o traslado |
      | Suspensión de deportación otorgada |
      | Titular de visa no inmigrante |
      | Víctima de tráfico (o es cónyuge, hijo/a, hermano/a o padre/madre de la víctima) |
      | Víctima de violencia/abuso (o es cónyuge, hijo/a o padre/madre de la víctima) |

  @SLER-2251 @PageText
  Scenario: ELIG-Welcome Page (Enrollment)-Page Text (RT-1429)
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    Given I set the test scenario details
      | totalGroups | totalDentalGroups | totalMembers | total_subscribers | total_dependents | total_enrollees |
      | 2           | 2                 | 4            | 1                 | 1                | 2               |
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "MovedToColorado" and click continue
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with SSN "234345678" City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    Then I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
    Then I select "Male" as sex option
    Then I select "Yes" to Are You Applying
    Then I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    Then I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
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
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    When I select birth and check member and "First Day of Current Month" as event date on QLCE
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    Then I select first dental plan
    Then I click continue on dental plan results page
    And I set "Medical" Plans premium amount
    And I set "Dental" Plans premium amount
    And I click continue on plan summary page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I Validate the correct enrolled plans are displayed on account overview page
    Then I validate page text for plan information table header
      | PLAN TYPE     |
      | MEMBER(S)     |
      | CARRIER/PHONE |
      | PLAN          |
      | PREMIUM       |
      | APTC          |
    And I change the language from header to "Spanish NonElmo"
    Then I validate page text for plan information table header
      | TIPO DE PLAN                 |
      | MIEMBRO(S)                   |
      | COMPAÑÍA DE SEGURO/TELÉFONO: |
      | PLAN                         |
      | CUOTA                        |
      | APTC                         |

  @SLER-2262 @PageText
  Scenario: ELIG- Please call Experian (RIDP)-Page Text(RT-1436)
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "09051959" in county "DENVER" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    Then I select specific answers for Id proofing questions and click continue
      | CapGemini         |
      | Littleton Address |
      | CHASE             |
    Then I validate I am on the "Upload Documents (RIDP)" page
    Then I validate the following text on Upload Documents RIDP page including the error message and button texts
      |Please call Experian to unlock your account. 1 (866) 578-5409\nMake sure to provide your reference number: Farsd\nExperian hours of operation are Monday - Friday, 6:30am to 8pm MST; Saturday, 8am-6pm MST; Sunday, 9am-6pm MST.|
      |Check Status                                                                                                                                                                                                                     |
      |< Back                                                                                                                                                                                                                           |
    When I change the language from header to "Spanish NonElmo"
    Then I validate the following text on Upload Documents RIDP page including the error message and button texts
      |Por favor llame a Experian para desbloquear su cuenta. 1 (866) 578-5409\nSu número de referencia DSH es Farsd\nLas horas de operación de Experian son de lunes a viernes, de 6:30 a.m. a 8 p.m. MST; sábados, de 8 a.m. a 6 p.m. MST; domingo, de 9 a.m. a 6 p.m. MST.|
      |Check Status                                                                                                                                                                                                                     |
      |< Atrás                                                                                                                                                                                                                           |
    Then I click on Sign Out in the Header for "NonElmo"

  @SLER-2216 @PageText
  Scenario: ELIG-Naturalized Citizen Status (Citizenship and immigration status)-Page Text(RT-1067)
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "MovedToColorado" and click continue
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with SSN "234345678" City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    Then I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
    Then I select "Male" as sex option
    Then I select "Yes" to Are You Applying
    Then I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    Then I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "Yes" for Naturalized Immigrant option
    Then I validate page texts when us citizen option is "Yes"
      | A-Number/USCIS number      |
      | Document type              |
      | Document Number            |
      | A########                  |
      | Naturalization Certificate |
      | Citizenship Certificate    |
    And I change the language from header to "Spanish NonElmo"
    Then I select "Yes" for Citizen option
    And I select "Yes" for Naturalized Immigrant option
    Then I validate page texts when us citizen option is "Yes"
      | Número A/Número USCIS         |
      | Tipo de documento             |
      | Número del documento          |
      | A########                     |
      | Certificado de naturalización |
      | Certificado de ciudadanía     |
    And I change the language from header to "English NonElmo"
    Then I select "No" for Citizen option
    Then I select "Yes" for Eligible Immigration Status option
    Then I select "I-327 Reentry Permit" as Document type
    Then I select "No" for name matching the document
    Then I validate page texts when us citizen option is "No"
      | A-Number/USCIS number                                                                                                 |
      | Are any of the following active-duty members of the military or honorably discharged veterans? (check all that apply) |
      | Me                                                                                                                    |
      | My spouse                                                                                                             |
      | One or both of my parents                                                                                             |
      | None of the above                                                                                                     |
      | Does                                                                                                                  |
      | match the name on the document?                                                                                       |
      | Enter name as it appears on document                                                                                  |
      | First Name                                                                                                            |
      | Middle Name                                                                                                           |
      | Last Name                                                                                                             |
    And I change the language from header to "Spanish NonElmo"
    Then I select "No" for Citizen option
    Then I select "Yes" for Eligible Immigration Status option
    Then I select "Permiso de reingreso I-327" as Document type
    Then I select "No" for name matching the document
    Then I validate page texts when us citizen option is "No"
      | Número A/Número USCIS                                                                                                                          |
      | ¿Alguno de los siguientes es miembro en servicio activo del ejército o veterano dado de baja honrosamente? (marque todos los que correspondan) |
      | Yo                                                                                                                                             |
      | Mi esposo(a)                                                                                                                                   |
      | Uno o ambos de mis padres                                                                                                                      |
      | Ningunos de los anteriores                                                                                                                     |
      | ¿Coincide el nombre de                                                                                                                         |
      | con el de la tarjeta?                                                                                                                          |
      | Ingrese el nombre según aparece en el documento                                                                                                |
      | Nombre                                                                                                                                         |
      | Segundo nombre o inicial (opcional)                                                                                                            |
      | Apellido(s)                                                                                                                                    |

  @SLER-2261 @PageText
  Scenario:  ELIG-Five Year Bar Page-Help Drawer text-Page Text (RT-2067)
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "MovedToColorado" and click continue
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with SSN "234345678" City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    Then I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
    Then I select "Male" as sex option
    Then I select "Yes" to Are You Applying
    Then I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    Then I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "No" for Citizen option
    And I select "Yes" for Eligible Immigration Status option
    And I select "I-327 Reentry Permit" as Document type
    Then I enter A-Number USCIS number for "NonCitizen" on Lawful Presence page
    Then I select "None of the above" active-duty members of the military or honorably discharged veterans
    Then I select "Yes" for name matching the document
    Then I click continue on the Citizenship page
    When I click Help me understand this page link on five year bar page
    Then I validate help menu page text headers on five year bar page
      |Lawful Presence|
      |Lawful Permanent Resident|
      |Grant Date|
      |Lived in the U.S. since 1996|
      |lawfully |
      |Immigration Statuses Along with Lawful Permanent Resident Status|
      |All Immigration Statuses|
    When I click Help me understand this page link on five year bar page
    And I change the language from header to "Spanish NonElmo"
    When I click Help me understand this page link on five year bar page
    Then I validate help menu page text headers on five year bar page
      |Residencia Permanente|
      |Residente permanente legal|
      |Fecha de otorgamiento|
      |Vivido en Estados Unidos desde 1996|
      |legal|
      |Estatus migratorio junto con el estatus de Residencia permanente legal|
      |Todos los estatus migratorios|

  @SLER-2167 @PageText
  Scenario: SLER-2167 - ELIG - verify text on Application History Page for 10k enrollee
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
  # location change
    And I am a member with City "Denver" in State "CO" with dob "01011971" in county "DENVER" with zipcode "80220"
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

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
  #income variance
    And I enter employment details with "1000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue


    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page

    Then I validate I am on the "Application History" page
    And I validate the "EnglishQHP" text on the Application History page
    And I change the language from header to "Spanish NonElmo"
    And I validate the "SpanishQHP" text on the Application History page
    And I change the language from header to "English NonElmo"
    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2187 @PageText
  Scenario: SLER-2187 - ELIG - verify text on Application History Page for 50k enrollee
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
  # location change
    And I am a member with City "Denver" in State "CO" with dob "01011971" in county "DENVER" with zipcode "80220"
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

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
  #income variance
    And I enter employment details with "5000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue


    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    And I validate the "EnglishNonQHP" text on the Application History page
    And I change the language from header to "Spanish NonElmo"
    And I validate the "SpanishNonQHP" text on the Application History page
    And I change the language from header to "English NonElmo"
    And I click on Sign Out in the Header for "NonElmo"

  @SLER-2166 @PageText
  Scenario: SLER-2166 - ELIG - verify text on Application Results Page - wth QHP language
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
  # location change
    And I am a member with City "Denver" in State "CO" with dob "01011971" in county "DENVER" with zipcode "80220"
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

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
  #income variance
    And I enter employment details with "1000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue


    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page

    And I validate the "EnglishQHP" text on the Application Results page
    And I change the language from header to "Spanish NonElmo"
    And I validate the "SpanishQHP" text on the Application Results page
    And I change the language from header to "English NonElmo"

    And I click continue on application results page
    And I click on Sign Out in the Header for "Portal"

  #TODO: Needs updates for functions at the end.
  @SLER-2338 @PageText
  Scenario: SLER-2338 - ELIG - verify text on Application Results Page - with No QHP language
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
  # location change
    And I am a member with City "Denver" in State "CO" with dob "01011971" in county "DENVER" with zipcode "80220"
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

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
  #income variance
    And I enter employment details with "8000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue


    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I validate the "EnglishNoQHP" text on the Application Results page
    #And I change the language from header to "Spanish NonElmo"
    #And I validate the "SpanishNoQHP" text on the Application Results page
    #And I change the language from header to "English NonElmo"

    #And I click continue on application results page
    #And I click on Sign Out in the Header for "Portal"