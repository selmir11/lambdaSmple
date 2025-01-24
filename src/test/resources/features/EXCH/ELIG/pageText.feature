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
      | 1 person: $21,870 |
      | 2 people: $29,580 |
      | 3 people: $37,290 |
      | 4 people: $45,000 |
      | 5 people: $52,710 |
      | 6 people: $60,240 |
      | 7 people: $68,130 |
      | 8 people: $75,840 |
      | 9 people: $83,550 |
      | 10 people: $91,260 |
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
      | 1 persona: $21,870 |
      | 2 personas: $29,580 |
      | 3 personas: $37,290 |
      | 4 personas: $45,000 |
      | 5 personas: $52,710 |
      | 6 personas: $60,240 |
      | 7 personas: $68,130 |
      | 8 personas: $75,840 |
      | 9 personas: $83,550 |
      | 10 personas: $91,260 |
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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
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
      | 1 person: $21,870 |
      | 2 people: $29,580 |
      | 3 people: $37,290 |
      | 4 people: $45,000 |
      | 5 people: $52,710 |
      | 6 people: $60,240 |
      | 7 people: $68,130 |
      | 8 people: $75,840 |
      | 9 people: $83,550 |
      | 10 people: $91,260 |
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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
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
      | 1 persona: $21,870 |
      | 2 personas: $29,580 |
      | 3 personas: $37,290 |
      | 4 personas: $45,000 |
      | 5 personas: $52,710 |
      | 6 personas: $60,240 |
      | 7 personas: $68,130 |
      | 8 personas: $75,840 |
      | 9 personas: $83,550 |
      | 10 personas: $91,260 |
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
      | 1 person: $21,870 |
      | 2 people: $29,580 |
      | 3 people: $37,290 |
      | 4 people: $45,000 |
      | 5 people: $52,710 |
      | 6 people: $60,240 |
      | 7 people: $68,130 |
      | 8 people: $75,840 |
      | 9 people: $83,550 |
      | 10 people: $91,260 |
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
      | 1 persona: $21,870 |
      | 2 personas: $29,580 |
      | 3 personas: $37,290 |
      | 4 personas: $45,000 |
      | 5 personas: $52,710 |
      | 6 personas: $60,240 |
      | 7 personas: $68,130 |
      | 8 personas: $75,840 |
      | 9 personas: $83,550 |
      | 10 personas: $91,260 |
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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
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
      | 1 person: $21,870 |
      | 2 people: $29,580 |
      | 3 people: $37,290 |
      | 4 people: $45,000 |
      | 5 people: $52,710 |
      | 6 people: $60,240 |
      | 7 people: $68,130 |
      | 8 people: $75,840 |
      | 9 people: $83,550 |
      | 10 people: $91,260 |
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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
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
      | 1 persona: $21,870 |
      | 2 personas: $29,580 |
      | 3 personas: $37,290 |
      | 4 personas: $45,000 |
      | 5 personas: $52,710 |
      | 6 personas: $60,240 |
      | 7 personas: $68,130 |
      | 8 personas: $75,840 |
      | 9 personas: $83,550 |
      | 10 personas: $91,260 |
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
    Then I verify the text on the Citizenship and Immigration Status page for Paroled into the U.S. in "English"
    And I change the language from header to "Spanish NonElmo"
    Then I verify the text on the Citizenship and Immigration Status page for Paroled into the U.S. in "Spanish"
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
    Then I verify the text on Let us guide you page in "English"
    And I change the language from header to "Spanish NonElmo"
    Then I verify the text on Let us guide you page in "Spanish"
