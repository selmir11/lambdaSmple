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
    | Do you have an eligible immigration status? |
    | Yes |
    | No |
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
    | ¿Tiene un estatus migratorio elegible? |
    | Sí |
    | No |
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