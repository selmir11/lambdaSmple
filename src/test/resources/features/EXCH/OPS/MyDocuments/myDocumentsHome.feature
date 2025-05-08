@OPS @Exch @ExchMyDocs
Feature: My Document Home Page validations

  @SLER-2090
  Scenario:SLER-2090: OPS MyDocs Navigating to file explorer[RT-1819]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click on upload another document
    When I select document "TestMyDocs.docx" and upload
    Then I see the document "TestMyDocs.docx" that I choose in the Upload modal
    When I click on close to remove the uploaded document
    Then I verify document removed successfully
    And I close button to close modal
    Then I see the username that I am currently logged into

  @SLER-2109
  Scenario:SLER-2109:OPS MyDocs Select Type and checks errors[RT-1938]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click on upload another document
    When I select any type of document from dropdown
    When I select any category of document from dropdown
    When I click on upload my document button
    Then I validate file required error message
    And I close button to close modal
    And I click on upload another document
    When I click on upload my document button
    Then I validate selection required error message
    Then I validate font colour height and size of selection required error
    Then I validate border colour of type and category dropdown
    When I select any type of document from dropdown
    When I select any category of document from dropdown
    Then I validate selection required error message disappear

  @SLER-2073
  Scenario:SLER-2073: Verify user can see their Documents and Notices in the Documents and Notices container [RT-1818]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "1903086579" "9067566019" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate I am on "Past Documents and Letters" container
    And I validate current year defaulted in plan Year
    Then I select "Letters" from document and letter dropdown
    And  I select year "All" in plan year
    Then I validate all uploaded documents or notices loaded for my account start with "IND"
      | IND_Plan Selection and Payment Confirmation (EN-002-04)|
      | IND_Renewal Plan Still Available (EN-007-01)         |
      | IND_Eligibility Change with SEP (ELG-101-03)               |
      | IND_Welcome Message (AM-001-01)                            |
      | IND_Welcome Message (AM-001-03)                            |
      | IND_Initial Eligibility notice (ELG-101-01)                |
    And  I Click on double chevron in Past Documents and Letters Container
    Then I validate Date Received, Time Received and Download button available in "English"
    And I select year "Previous Year" in plan year
    Then I select "Documents and Letters" from document and letter dropdown
    And  I Click on double chevron in Past Documents and Letters Container
    Then I validate document date shows for selected year
    And I select year "Current Year" in plan year
    Then I validate no document message
      |You do not have any Documents or Letters at this time |
    And I change the language from header to "Spanish"
    Then I validate no document message
      |No tiene documentos ni cartas en este momento |
    Then I validate I am on "Documentos y Cartas Anteriores" container
    And I verify plan year label "Año:"
    And I validate current year defaulted in plan Year
    And I validate default value in Documents and letters dropdown in "Spanish"
    Then I validate no document message
      |No tiene documentos ni cartas en este momento |
    Then I verify Go back to welcome page button
      | Volver a la Pagina de Bienvenida |
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2102
  Scenario:SLER-2102: Verify Text on upload doc modal in My documents from manage client via broker portal [RT-1906]
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+PrestonSaunders@outlook.com" password "ALaska12!" and "C4PortTesting+PSaundersQA@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Broker Dashboard" page
    Then I validate the Your Clients page title
    And I click on the first client in my list
    And I click "manage" the client
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click on upload another document
    And I validate Modal texts on upload a document pop up
      |Upload a document|
      |Tell us more about this document|
      |What type of document is this?  |
      |Which document are you submitting?|
      |Select a file from your device    |
      |Browse My Files                   |
      |Only one document can be uploaded at a time using this window|
      |Cancel                                                       |
      | Upload My Document |
    And I close button to close modal
    And I click on upload another document
    And I click on cancel button on upload document pop up
    And I change the language from header to "Spanish"
    And I click on upload another document in spanish
    And I validate Modal texts on upload a document pop up
      |Cargar un documento|
      |Díganos más sobre este documento|
      |¿Qué tipo de documento es este?|
      |¿Qué documento está enviando?|
      |Seleccione un archivo de su dispositivo|
      |Explorar Mis Archivos|
      |Solo se puede cargar un documento a la vez usando esta ventana|
      |Cancelar|
      |Cargar Mi Documento                                       |
    And I close button to close modal
    And I click on upload another document in spanish
    And I click on cancel button on upload document pop up
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"



  @SLER-2129
  Scenario:SLER-2129:Verify Text on upload doc modal in My documents from manage client via Admin Portal [ RT-1907]]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click on upload another document
    And I validate Modal texts on upload a document pop up
      |Upload a document|
      |Tell us more about this document|
      |What type of document is this?  |
      |Which document are you submitting?|
      |Select a file from your device    |
      |Browse My Files                   |
      |Only one document can be uploaded at a time using this window|
      |Cancel                                                       |
      | Upload My Document |
    Then I validate font and Background color of Document popup
    And I close button to close modal
    And I click on upload another document
    And I click on cancel button on upload document pop up
    And I change the language from header to "Spanish"
    And I click on upload another document in spanish
    And I validate Modal texts on upload a document pop up
      |Cargar un documento|
      |Díganos más sobre este documento|
      |¿Qué tipo de documento es este?|
      |¿Qué documento está enviando?|
      |Seleccione un archivo de su dispositivo|
      |Explorar Mis Archivos|
      |Solo se puede cargar un documento a la vez usando esta ventana|
      |Cancelar|
      |Cargar Mi Documento                                       |
    And I close button to close modal
    And I click on upload another document in spanish
    And I click on cancel button on upload document pop up
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2140
  Scenario:SLER-2140:Verify English and Spanish Text for Document and upload page [RT-1975]
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I verify the page text on the My Documents Page in "English"
      | My Documents and Letters |
      | We need more information to confirm or verify what you told us in your application. |
      | Help me understand this page                                                        |
      | Information We Need                                                                 |
      | Upload another document |
      | Past Documents and Letters |
    And I click on upload another document
    And I click on cancel button on upload document pop up
    And I change the language from header to "Spanish"
    And I verify the page text on the My Documents Page in "Spanish"
      | Mis Documentos y Cartas |
      | Necesitamos más información para confirmar o verificar lo que nos informó en su solicitud. |
      | Ayuda para entender esta página                                                        |
      | Información que Necesitamos                                                                 |
      | Cargar otro documento |
      | Documentos y Cartas Anteriores |
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2155
  Scenario:SLER-2155:Verify document category and their types in Ascending orders via Admin Portal [ RT-1987]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click on upload another document
    And I validate Document category displayed in ascending order and "Other" at end of list "English"
      | 1095A Dispute |
      | American Indian/Alaska Native Tribal Membership |
      | Appeals |
      | Authorized Representative |
      | Citizenship Status         |
      | Complaints                    |
      | Customer Authorization Form        |
      | Death   |
      | Eligible Immigration Status     |
      | Health First Colorado (Medicaid) Application |
      | Health First Colorado (Medicaid) Redetermination (RRR)|
      | Identity      |
      | Incarceration |
      | Income|
      | Life Change Event            |
      | Medicare              |
      | Peace Corps        |
      | Social Security Number    |
      | TRICARE                                 |
      | Veterans Affairs (VA)                  |
      | Other|

    Then I validate Document Types for corresponding category list in ascending order and "Other" at end of list "English"
      | Correction Proof  & Correction Request |
      | Bureau of Indian Affairs Issued Document  & Tribal Enrollment/Membership Document  & Other Official Federal Recognized Tribe Document |
      | Appeals                                                                                                           |
      | Power of Attorney & Other legal Document |
      |Federally Approved Tribal Document & U.S. Birth Certificate & U.S. Certificate of Naturalization & U.S. Passport & Other Official Citizenship Document|
      | Complaints &  Feedback  |
      | Customer Authorization Form    |
      | Proof of Life Document    |
      | DS2019 (Certificate of Eligibility for Exchange Visitor (J-1) Status) & I-20 (Certificate of Eligibility for Nonimmigrant (F-1) Student Status) & I-327 Reentry Permit & I-551 Permanent Resident Card & I-571 Refugee Travel Document & I-766 Employment Authorization Card & INS Form I-94 (Arrival/Departure Record) & INS Form I-94 (Arrival/Departure Record) in Unexpired Foreign Passport & Machine Readable Immigrant Visa (with Temporary I-551 Language) & Temporary I-551 Stamp (on passport or I-94) & Other Official US Citizenship and Immigration Services Document   |
      |Health First Colorado (Medicaid) Application|
      | Health First Colorado (Medicaid) Redetermination (RRR)|
      |Driver's License - State, Federal or Local Government  &School ID & US Military ID Card  & Other Official Government ID   |
      | Court or Legal Document & Unexpired State ID Card & Other Official Document                                             |
      |Employer Statement & Form 8962  &Investment Income Statement & Pay Stub/Check & Premium Tax Credit Reconciliation Attestation Form & Retirement Income Statement & Self-Employment Ledger & Social Security Income Statement & Tax Document & Unemployment Amount Letter & Other Official Income Document   |
      | Report Life Change Events Individual Marketplace    |
      | Document from Medicare & Explanation of Health Coverage Form|
      |Document from Peace Corps & Explanation of Health Coverage Form|
      |Social Security Card & Social Security Document & Other Official Document with First/Last Name and SSN|
      |Document from TRICARE & Explanation of Health Coverage Form|
      |Document from Veterans Affairs (VA) & Explanation of Health Coverage Form|
      |Other                                                                               |
    And I close button to close modal
    Then  I click on Sign Out in the Header for "Elmo"

  @SLER-2188
  Scenario:SLER-2188:Verify document category and their types in Ascending orders via Admin Portal in Spanish [ RT-2012]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I change the language from header to "Spanish"
    And I click on upload another document in spanish
    And  I validate Document category displayed in ascending order and "Otros" at end of list "Spanish"

      | 1095A Disputa |
      | Apelaciones |
      | Asuntos de los veteranos |
      | Certificado de defunción |
      | Cuerpo de Paz            |
      | Documento emitido por la Oficina de Asuntos Indígenas |
      | Encarcelamiento                                       |
      | Evento de vida calificado                             |
      | Formulario de Autorización del cliente                |
      | Health First Colorado (Medicaid) Aplicación           |
      | Health First Colorado (Medicaid) Redeterminación (RRR) |
      | Identidad                                              |
      | Ingreso                                                |
      | Medicare                                               |
      | Número de Seguro Social                                |
      | Otro documento oficial de ciudadanía                   |
      | Otro documento oficial de servicios de inmigración sobre ciudadanía de Estados Unidos |
      | Quejas |
      | Representante autorizado |
      | TRICARE |
      | Otros |

    Then I validate Document Types for corresponding category list in ascending order and "Otro" at end of list "Spanish"
      |  Comprobante de encarcelamiento  & Prueba de corrección |
      | Apelaciones                                             |
      | Documentos de la Administración de Veteranos  & Explicación del formulario de cobertura de salud |
      | Certificación de prueba de vida |
      | Documentos del Cuerpo de Paz  & Explicación del formulario de cobertura de salud |
      | Documento de membresía/inscripción tribal  & Documento emitido por la Oficina de Asuntos Indígenas  & Otro documento oficial de una tribu reconocida por las autoridades federales|
      | Documento legal o de un tribunal  & Tarjeta vigente de identificación estatal  & Otro documento oficial                                                                            |
      | Informe de eventos de vida calificados Mercado individual                                                                                                                         |
      | Formulario de Autorización del cliente   |
      |  Health First Colorado (Medicaid) Aplicación   |
      | Health First Colorado (Medicaid) Redeterminación (RRR)|
      | Licencia de conducir expedida por el Gobierno estatal, federal o local  & Tarjeta de identidad del ejército de Estados Unidos  & Tarjeta de identificación escolar  & Otro documento de identificación gubernamental oficial |
      | Carta de la cantidad por desempleo  & Declaración del empleador  & Documento fiscal  & Estado de cuenta de ingresos por inversiones  & Estado de cuenta de ingresos por jubilación  & Estado de cuenta del ingreso del Seguro Social  & Formulario 8962  & Formulario de ratificación de conciliación del crédito fiscal para el pago de la prima  & Libro contable de trabajo independiente  & Recibo de pago/cheque  & Otro documento oficial de ingresos |
      |  Documento de Medicare  & Explicación del formulario de cobertura de salud |
      |  Documento del Seguro Social  & Tarjeta del Seguro Social  & Otro documento oficial con nombre y apellido y n.º del Seguro Social |
      |  Certificado (acta) de nacimiento de Estados Unidos  & Certificado de naturalización de Estados Unidos  & Documento tribal aprobado por las autoridades federales  & Pasaporte de Estados Unidos  & Otro documento oficial de ciudadanía |
      |  Documento de viaje para refugiado I-571  & DS2019 (Certificado de elegibilidad o estatus de visitante de intercambio; J-1)  & Formulario INS I-94 (Registro de entrada/salida)  & I-20 (Certificado de elegibilidad para estatus de estudiante no inmigrante; F-1)  & I-94 (Registro de entrada/salida) en pasaporte extranjero vigente  & Permiso de reingreso I-327  & Sello temporal I-551 (en el pasaporte o I-94/I-94A)  & Tarjeta de autorización de empleo I-766  & Tarjeta de residente permanente I-551  & Visa de inmigrante legible por máquina (con idioma temporal I-551)  & Otro documento oficial de Servicios de Inmigración y Ciudadanía de Estados Unidos |
      |  Comentarios  & Quejas                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
      |  Poder notarial  & Otro documento legal                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
      |  Documento de TRICARE  &  Explicación del formulario de cobertura de salud                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
      | Otros                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
    And I close button to close modal
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2164
  Scenario:SLER-2164: OPS MyDocs Verify All Modal Errors[RT-1984]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click on upload another document
    When I click on upload my document button
    Then I validate file required error message
    Then I validate selection required error message
    Then I validate font colour height and size of selection required error
    Then I validate border colour of type and category dropdown
    When I select any type of document from dropdown
    When I click on upload my document button
    Then I validate selection required error message for only document category
    Then I validate file required error message
    When I select any category of document from dropdown
    Then I validate file required error message
    Then I validate font colour height and size of file required error
    And I close button to close modal
    And I click on upload another document
    When I select document "TestMyDocs.docx" and upload
    When I click on upload my document button
    Then I validate selection required error message
    When I select any type of document from dropdown
    When I click on upload my document button
    Then I validate selection required error message for only document category
    When I select any category of document from dropdown
    When I select document "OversizeTestJPEG.jpg" and upload
    When I click on upload my document button
    Then I verify doc file size large error message in red
    Then I validate already selected file text box border is red
    When I select document "TestTIFF.tif" and upload
    When I click on upload my document button
    Then I verify doc unsupported error message in red
    Then I validate already selected file text box border is red

  @SLER-2208
  Scenario:SLER-2208:My documents Indiviual porter Header , Footer, Title validation in Spanish [RT-1962]
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I change the language from header to "Spanish NonElmo"
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Document Spanish" page
    And I verify the page text on the My Documents Page in "Spanish"
      | Mis Documentos y Cartas |
      | Necesitamos más información para confirmar o verificar lo que nos informó en su solicitud. |
      | Ayuda para entender esta página                                                        |
      | Información que Necesitamos                                                                 |
      | Cargar otro documento |
      | Documentos y Cartas Anteriores |
    Then I verify text "Username" in the Header or in the Footer
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    And I validate I am on the "Account Overview Spanish" page
    And I validate the page is in "Spanish"
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Document Spanish" page
    Then I verify text "Apply for coverage Spanish" in the Header or in the Footer
    And I click on Apply for Coverage in the "Elmo" Header
    And I validate I am on the "Account Overview Spanish" page
    Then I click link my docs on accountOverview page
    Then I verify text "Find a plan Spanish" in the Header or in the Footer
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page
    Then I validate that "Current Application Spanish" text displays on the Application History page in Spanish
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I click link my docs on accountOverview page
    Then I verify text "My Account Spanish" in the Header or in the Footer
    And I click on My Account in the "Elmo" Header
    And I validate I am on the "Account Overview Spanish" page
    Then I click link my docs on accountOverview page
    Then I verify text "Learn More Spanish" in the Header or in the Footer
    And I click on Learn More in the Header
    And I validate I am on the "Faqs Spanish" page and close tab
    Then I verify text "Find Expert Assistance Spanish" in the Header or in the Footer
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help Exch Spanish" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I click link my docs on accountOverview page
    Then I verify text "Globe" in the Header or in the Footer
    And I change the language from header to "English"
    And I change the language from header to "Spanish"
    Then I verify text "Privacy Policy Spanish" in the Header or in the Footer
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy Exch Spanish" page and close tab
    Then I verify text "Terms of Use Spanish" in the Header or in the Footer
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms of Use Exch Spanish" page and close tab
    And I click on Contact Us in the "Exch" Footer
    Then I verify text "Contact Us Footer Link Spanish" in the Header or in the Footer
    And I validate I am on the "Contact Us Exch Spanish" page and close tab
    Then I verify text "Copy Rights Spanish" in the Header or in the Footer
    Then I verify text "Follow Us Spanish" in the Header or in the Footer
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2234
  Scenario:SLER-2234:Verify Welcome letter downloaded with proper name format [RT-1996]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    Then I validate I am on "Past Documents and Letters" container
    And I select year "All" in plan year
    And I select year "Current Year" in plan year
    Then I verify file "IND_Welcome Message (AM-001-01)" downloaded with Proper name format in ".pdf" type
    Then  I click on Sign Out in the Header for "Elmo"

  @SLER-2252
  Scenario:SLER-2252:Verify user can upload Document to the MVR for all Document Category [RT-1979]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "7605717009" "7732518009" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click upload MVR button if present for category "Social Security Number"
    And I click Upload MVR carrot and verify default category "Social Security Number" and corresponding document types
      | Social Security Card & Social Security Document & Other Official Document with First/Last Name and SSN   |
    Then I upload MVR doc on the My Documents page and verify success message
    And I click upload MVR button if present for category "US Citizenship"
    And I click Upload MVR carrot and verify default category "US Citizenship" and corresponding document types
      | Federally Approved Tribal Document &  U.S. Birth Certificate & U.S. Certificate of Naturalization & U.S. Passport & Other Official Citizenship Document |
    Then I upload MVR doc on the My Documents page and verify success message
    And I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    Then I enter an "accountID" in any env "2908004501" "6301040608" to search user
    Then I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click upload MVR button if present for category "American Indian or Alaska Native Membership"
    And I click Upload MVR carrot and verify default category "American Indian or Alaska Native Membership" and corresponding document types
      | Bureau of Indian Affairs Issued Document & Tribal Enrollment/Membership Document & Other Official Federal Recognized Tribe Document |
    Then I upload MVR doc on the My Documents page and verify success message
    And I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    Then I enter an "accountID" in any env "3891909040" "5930557950" to search user
    Then I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click upload MVR button if present for category "Life"
    And I click Upload MVR carrot and verify default category "Life" and corresponding document types
      |Proof of Life Document |
    Then I upload MVR doc on the My Documents page and verify success message
    And I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    Then I enter an "accountID" in any env "3891105690" "5940607420" to search user
    Then I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click upload MVR button if present for category "Eligible Immigration Status"
    And I click Upload MVR carrot and verify default category "Eligible Immigration Status" and corresponding document types
      | DS2019 (Certificate of Eligibility for Exchange Visitor (J-1) Status) & I-20 (Certificate of Eligibility for Nonimmigrant (F-1) Student Status) & I-327 Reentry Permit & I-551 Permanent Resident Card & I-571 Refugee Travel Document & I-766 Employment Authorization Card & INS Form I-94 (Arrival/Departure Record) & INS Form I-94 (Arrival/Departure Record) in Unexpired Foreign Passport & Machine Readable Immigrant Visa (with Temporary I-551 Language) & Temporary I-551 Stamp (on passport or I-94) & Other Official US Citizenship and Immigration Services Document   |
    Then I upload MVR doc on the My Documents page and verify success message
    And I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    Then I enter an "accountID" in any env "7767237002" "7892055002" to search user
    Then I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click upload MVR button if present for category "Financial Help Eligibility"
    And I click Upload MVR carrot and verify default category "Financial Help Eligibility" and corresponding document types
      |Employer Statement & Form 8962  &Investment Income Statement & Pay Stub/Check & Premium Tax Credit Reconciliation Attestation Form & Retirement Income Statement & Self-Employment Ledger & Social Security Income Statement & Tax Document & Unemployment Amount Letter & Other Official Income Document   |
    Then I upload MVR doc on the My Documents page and verify success message
    And I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    Then I enter an "accountID" in any env "5480980120" "8509559700" to search user
    Then I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click upload MVR button if present for category "Incarceration Status"
    And I click Upload MVR carrot and verify default category "Incarceration Status" and corresponding document types
      | Court or Legal Document & Unexpired State ID Card & Other Official Document    |
    Then I upload MVR doc on the My Documents page and verify success message
    Then  I click on Sign Out in the Header for "Elmo"

    @SLER-2259
    Scenario:SLER-2259: OPS: Verify Document Success Message for Another and Upload [RT-1991]
      Given I open the login page on the "admin" portal
      And I refresh the page
      And I validate I am on the "Login" page
      When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
      And I validate I am on the "Admin search" page
      Then I click create account on admin portal
      And I enter general mandatory data for "exchange" account creation
      And I validate I am on the "Admin search" page
      And I select "individual" checkbox on Admin Portal Dashboard
      And I search for user and click email from search results
      And I click "On Behalf Of (OBO)" from application links dropdown
      Then I validate I am on the "Account Overview" page
      Then I apply for the current year
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button
      Then I click on continue with  application button on Before you begin page
      And I report "Birth" and click continue
      Then I select "member" from the who are you question
      And I am a member with SSN "" City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
      Then I answer all Id proofing questions and click continue
      And I click continue button on Congratulations page
      Then I validate I am on the "Find Expert Help" page
      Then I click Continue on my own button from Manage who helps you page
      Then I select "Male" as sex option
      And I select "Yes" to Are You Applying
      Then I click I don't have a Social Security Number box and "Yes" on Tell us about yourself page
      And I click continue on Tell us about yourself page
      Then I enter member with address line1 "1234 Street" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
      And I select "Yes" for CO Resident option
      And I select "No" for Federally Recognized Tribe option
      And I select "No" for Hardship Exemption option
      And I select "No" for Disability option
      And I select "No" to the recently denied medicaid question
      And I select "No" for Incarceration option
      And I click continue on the Add Address page
      And I select "Prefer not to answer" for race and ethnicity for "Primary"
      Then I click continue on the Race and Ethnicity page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page
      Then I click continue on family overview page
      Then I validate I am on the "Financial Help" page
      And I Apply for financial help
      Then I select the option "Yes" to employment
      And I select the option "No" to self employment
      And I enter employment details with "4000000" income at "Annually" frequency
      And I select the option "No" to seasonal employment
      And I select the option "No" to projected income
      And I click continue on the Employment Info Page
      Then I click continue on the Employment Summary Page
      Then I click None of these as additional income option and continue
      Then I validate I am on the "Deductions" page
      Then I click None of these as deduction option and continue
      Then I validate I am on the "Income Summary" page
      Then I select the projected income option "No" and continue
      Then I validate I am on the "Tax status" page
      Then I select "No" for will you be claimed as dependent question
      Then I select "Yes" for will file tax return question
      Then I select the "Single" tax filing option on the Tax Status page
      Then I select "No" for will claim dependents question
      Then I click Save and Continue on Tax Status page
      Then I select "None of these" as health coverage option
      Then I click continue on the health coverage page
      Then I click continue on family overview page
      Then I select "Birth" QLCE on tell us about life changes page
      Then I click on Save and Continue
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear
      Then I click on view results and shop
      Then I validate I am on the "Application Results" page
      Then I click the provide documents link on the app results page
      Then I upload MVR doc for "Social Security Number" on the My Documents page
      And I click on upload another document
      Then I upload another doc "TestMyDocs.docx" for "Social Security Number" on the My Documents page and verify success message
      Then  I click on Sign Out in the Header for "Elmo"

  @SLER-2265
  Scenario:SLER-2265:Verify Document uploaded for Income type and downloaded with proper name format [RT-1989]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click on upload another document link
    Then I upload another doc "TestMyDocs.docx" for category "Income" and type "Form 8962" and verify success message
    Then I validate I am on "Past Documents and Letters" container
    And I select year "All" in plan year
    And I select year "Current Year" in plan year
    Then I verify file "Income" downloaded with Proper name format in ".docx" type
    Then  I click on Sign Out in the Header for "Elmo"

 @SLER-2268
  Scenario:SLER-2268:Verify upload document modal Errors[RT-1999]
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    And I verify the page text on the My Documents Page in "English"
      | My Documents and Letters |
      | We need more information to confirm or verify what you told us in your application. |
      | Help me understand this page                                                        |
      | Information We Need                                                                 |
      | Upload another document |
      | Past Documents and Letters |
    And I click on upload another document link
    And I validate Modal texts on upload a document pop up
      |Upload a document|
      |Tell us more about this document|
      |What type of document is this?  |
      |Which document are you submitting?|
      |Select a file from your device    |
      |Browse My Files                   |
      |Only one document can be uploaded at a time using this window|
      |Cancel                                                       |
      | Upload My Document |
    And I click on upload my document button
    Then I validate file required error message
    Then I validate selection required error message
    And I select any type of document from dropdown
    And I close button to close modal
    Then I verify modal popup closed
    Then I see the username in Exch that I am currently logged into
    And I click on upload another document link
    And I select any type of document from dropdown
    And I click on cancel button on upload document pop up
    Then I verify modal popup closed
    Then I see the username in Exch that I am currently logged into
    Then  I click on Sign Out in the Header for "Elmo"

  @SLER-2277
  Scenario:SLER-2277:Verify Document uploaded for Income type and downloaded with proper name format Spanish [RT-2014]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I change the language from header to "Spanish"
    And I click on upload another document link
    Then I upload another doc "TestMyDocs.docx" for category "Ingreso" and type "Formulario 8962" and verify success message "Spanish"
    Then I validate I am on "Past Documents and Letters" container
    And I select year "All" in plan year
    And I select year "Current Year" in plan year
    Then I verify file "Income" downloaded with Proper name format in ".docx" type
    Then  I click on Sign Out in the Header for "Elmo"

  @SLER-2282
  Scenario: SLER-2282:OPS: MyDocs: verify Document Type blank when new document category selected [RT-2003]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click on upload another document link
    Then I verify Document category blank by default
    And I verify Document category "1095A Dispute" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Correction Proof" is selected on modal popup
    And I verify Document category "American Indian/Alaska Native Tribal Membership" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Bureau of Indian Affairs Issued Document" is selected on modal popup
    And I verify Document category "Appeals" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Appeals" is selected on modal popup
    And I verify Document category "Authorized Representative" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Power of Attorney" is selected on modal popup
    And I verify Document category "Citizenship Status" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Federally Approved Tribal Document" is selected on modal popup
    And I verify Document category "Complaints" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Complaints" is selected on modal popup
    And I verify Document category "Customer Authorization Form" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Customer Authorization Form" is selected on modal popup
    And I verify Document category "Death" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Proof of Life Document" is selected on modal popup
    And I verify Document category "Eligible Immigration Status" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "I-327 Reentry Permit" is selected on modal popup
    And I verify Document category "Health First Colorado (Medicaid) Application" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Health First Colorado (Medicaid) Application" is selected on modal popup
    And I verify Document category "Health First Colorado (Medicaid) Redetermination (RRR)" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Health First Colorado (Medicaid) Redetermination (RRR)" is selected on modal popup
    And I verify Document category "Identity" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "US Military ID Card" is selected on modal popup
    And I verify Document category "Incarceration" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Court or Legal Document" is selected on modal popup
    And I verify Document category "Income" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Form 8962" is selected on modal popup
    And I verify Document category "Life Change Event" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Report Life Change Events Individual Marketplace" is selected on modal popup
    And I verify Document category "Medicare" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Document from Medicare" is selected on modal popup
    And I verify Document category "Peace Corps" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Document from Peace Corps" is selected on modal popup
    And I verify Document category "Social Security Number" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Social Security Card" is selected on modal popup
    And I verify Document category "TRICARE" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Document from TRICARE" is selected on modal popup
    And I verify Document category "Veterans Affairs (VA)" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Document from Veterans Affairs (VA)" is selected on modal popup
    And I verify Document category "Other" is selected on modal popup
    And I verify Document type blank by default
    Then I verify Document type "Other" is selected on modal popup
    And I close button to close modal
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2290
  Scenario:SLER-2290:Verify Help drawer text on the document page [RT-2020]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "7724352002" "5990496490" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click on the help drawer icon on the document page
    Then I validate help drawer open in right side of the page
    And I verify help drawer "header" text on the My Document page
      | Help |
    And I verify help drawer "sub header" text on the My Document page
      | My Documents and Letters Explanation |
    And I verify help drawer "body title" text on the My Document page
      | Overview |
    And I verify help drawer "body content" text on the My Document page
      | Have questions about documents you need to provide? Click here for more information. |
      | You have 90 days to submit the document(s) we requested. The color of the due date signifies the time you have left to provide the document. |
      | If the due date is green, you have 60 to 90 days to provide your documentation.                                                              |
      | If the due date is yellow, you have 30 to 59 days to provide your documentation.                                                             |
      | If the due date is red, you have less than 30 days to provide your documentation.                                                            |
      | Did your document request expire? If the upload button is still available, provide the documentation for review.                            |
      | If you are not able to upload your document(s), please contact our Service Center at 1-855-752-6749. |
    And I verify help drawer "footer" text on the My Document page
      | Need more help?  Contact us |
    And I click on the help drawer icon to close on the document page
    Then I validate help drawer closed on the document page
    And I click on "Help me understand this page" link in Help Drawer
    Then I validate help drawer open in right side of the page
    And I click on "here" link in Help Drawer
    And I validate I am on the "Submit Documents" page and close tab
    And I click on "Contact Us" link in Help Drawer
    And I validate I am on the "We Can Help" page and close tab
    And I click on the help drawer icon to close on the document page
    And I click upload MVR button for "Financial Help Eligibility"
    Then I validate help drawer open in right side of the page for "Income" mvr
    And I verify help drawer "Income header" text on the My Document page
      | Help |
    And I verify help drawer "Income sub header" text on the My Document page
      | Proof of Financial Help Eligibility|
    And I verify help drawer "Income body title" text on the My Document page
      | Overview |
    And I verify help drawer "Income body content" text on the My Document page
      | In order to verify your income, you must submit two documents: |
      | (1) Confirming your income and                                 |
      | (2) Confirming that you previously filed and reconciled APTC on your federal taxes, or were not required to. |
      | More information is available on our website. |
    And I verify help drawer "Income footer" text on the My Document page
      | Need more help?  Contact us |
    And I click on "our website" link in Help Drawer
    And I validate I am on the "Submit Documents" page and close tab
    And I click on "Contact Us" link in Help Drawer
    And I validate I am on the "We Can Help" page and close tab
    And I close button to close modal
    Then  I click on Sign Out in the Header for "Elmo"

  @SLER-2297 @OPSRegression
  Scenario:SLER-2297:Verify due date color on document page for MVR Types in Spanish [RT-2017]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "2343002676" "5990496490" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I change the language from header to "Spanish"
    And I verify Document header on my document page
      | Mis Documentos y Cartas |
    Then I verify Sub header on my document page
      | Necesitamos más información para confirmar o verificar lo que nos informó en su solicitud. |
    Then I verify container header for information we need
      | Información que Necesitamos |
    And I verify MVR name on the information we need container in "Spanish"
    Then I Verify due date are displaying in proper color
    Then I verify member name in MVR type
    # Member names for an account 2343002676 in QA Env
      |     memberNames            |      Env     |
      | Primarynfdxxg YtkvelwTest    |      qa      |
      | Spousepjjrzdxm Nombyeyptqssf |      qa      |
      | Sonrgonmbvx Stxcyheghapri    |      qa      |
    # Member Names for an account 5990496490 in Staging Env
      | apelizfadst apindefurdst     |      staging  |
      | gsdertetr apindefurdst       |      staging  |
    Then I verify Upload button on the right
    Then I verify mvr type with date, member name and upload button
    And I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I change the language from header to "Spanish"
    And I verify Document header on my document page
      | Mis Documentos y Cartas |
    Then I verify Sub header on my document page
      | Necesitamos más información para confirmar o verificar lo que nos informó en su solicitud. |
    Then I verify container header for information we need
      | Información que Necesitamos |
    And I verify no document on new account
      | En este momento no es necesario que cargue ningún documento |
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2322
  Scenario:SLER-2322: Verify due date color on document page for MVR Types in English [RT-1813]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "2343002676" "5990496490" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I verify Document header on my document page
      | My Documents and Letters |
    Then I verify Sub header on my document page
      | We need more information to confirm or verify what you told us in your application. |
    Then I verify container header for information we need
      | Information We Need |
    And I verify MVR name on the information we need container in "English"
    Then I Verify due date are displaying in proper color
    Then I verify member name in MVR type
    # Member names for an account 2343002676 in QA Env
      |     memberNames            |      Env     |
      | Primarynfdxxg YtkvelwTest    |      qa      |
      | Spousepjjrzdxm Nombyeyptqssf |      qa      |
      | Sonrgonmbvx Stxcyheghapri    |      qa      |
    # Member Names for an account 5990496490 in Staging Env
      | apelizfadst apindefurdst     |      staging  |
      | gsdertetr apindefurdst       |      staging  |
      | michael lipsitz              |   staging  |
      | nicolasa lipsitz              |  staging  |
    Then I verify Upload button on the right
    Then I verify mvr type with date, member name and upload button
    And I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I verify Document header on my document page
      | My Documents and Letters |
    Then I verify Sub header on my document page
      | We need more information to confirm or verify what you told us in your application. |
    Then I verify container header for information we need
      | Information We Need |
    And I verify no document on new account
      | You don't need to upload any documents at this time|
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2298
  Scenario:SLER-2298:Verify Modal pop up error in Spanish  [RT-2019]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I change the language from header to "Spanish"
    And I click on upload another document link
    Then I click on upload documents button in modal popup
    Then I validate selection required error message on modal popup
      | Debe hacer una Selección |
    Then I validate font colour height and size of selection required error
    Then I validate border colour of type and category dropdown
    Then I validate file required error message on modal popup
     | Archivo requerido para cargar, adjunte un archivo y inténtelo de nuevo. |
    Then I validate font colour height and size of file required error
    Then I validate border colour of type and category dropdown
    Then I select any type of document from dropdown
    Then I click on upload documents button in modal popup
    Then I validate selection required error message for only document category on modal popup
      | Debe hacer una Selección |
    Then I validate border colour of category dropdown
    Then I validate file required error message on modal popup
      | Archivo requerido para cargar, adjunte un archivo y inténtelo de nuevo. |
    Then  I select any category of document from dropdown in spanish
    Then  I click on upload documents button in modal popup
    Then I validate file required error message on modal popup
      | Archivo requerido para cargar, adjunte un archivo y inténtelo de nuevo. |
    Then I validate font colour height and size of file required error
    And I close button to close modal
    And I click on upload another document link
    Then I select document "TestMyDocs.docx" and upload
    Then I click on upload documents button in modal popup
    Then I validate selection required error message on modal popup
      | Debe hacer una Selección |
    Then I validate font colour height and size of selection required error
    Then I validate border colour of type and category dropdown
    Then I select any type of document from dropdown
    Then I click on upload documents button in modal popup
    Then I validate selection required error message for only document category on modal popup
      | Debe hacer una Selección |
    Then I validate border colour of category dropdown
    Then I select any category of document from dropdown in spanish
    Then I select document "OversizeTestJPEG.jpg" and upload
    Then I click on upload documents button in modal popup
    Then I verify doc file size large error message in red in Spanish
    Then I validate already selected file text box border is red
    Then I select document "TestTIFF.tif" and upload
    Then I click on upload documents button in modal popup
    Then I verify unsupported document error message with red in color
    | No se admite este tipo de archivo. Los archivos deben ser pdf, doc, docx, gif, jpeg, jpg, o png.|
    Then I validate already selected file text box border is red
    And I close button to close modal
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2324
  Scenario:SLER-2324:OPS: Verify Document Success Message for Another and Upload in Spanish [RT-2016]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with SSN "" City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    Then I click I don't have a Social Security Number box and "Yes" on Tell us about yourself page
    And I click continue on Tell us about yourself page
    Then I enter member with address line1 "1234 Street" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    Then I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "4000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click the provide documents link on the app results page
    And I change the language from header to "Spanish"
    Then I upload MVR doc for "Número de Seguro Social" on the My Documents page in "Spanish"
    And I click on upload another document in spanish
    Then I upload another doc "TestMyDocs.docx" for "Número de Seguro Social" on the My Documents page and verify success message in "Spanish"
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"



  @SLER-2332
  Scenario:SLER-2332:Verify user can see their Documents and Notices in the Documents and Notices container [RT-2013]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "1903086579" "4006848148" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I change the language from header to "Spanish"
    Then I validate I am on "Documentos y Cartas Anteriores" container
    And I validate current year defaulted in plan Year
    Then I select "Cartas" from document and letter dropdown
    And  I select year "Todos" in plan year
    Then I validate all uploaded documents or notices loaded for my account start with "IND"
      | IND_Plan Selection and Payment Confirmation (EN-002-04)|
      | IND_Renewal Plan Still Available (EN-007-01)         |
      | IND_Eligibility Change with SEP (ELG-101-03)               |
      | IND_Welcome Message (AM-001-01)                            |
      | IND_Welcome Message (AM-001-03)                            |
      | IND_Initial Eligibility notice (ELG-101-01)                |
    And  I Click on double chevron in Past Documents and Letters Container
    Then I validate Date Received, Time Received and Download button available in "Spanish"
    And I select year "Previous Year" in plan year
    Then I select "Documentos y cartas" from document and letter dropdown
    And  I Click on double chevron in Past Documents and Letters Container
    Then I validate document date shows for selected year
    And I select year "Current Year" in plan year
    Then I validate no document message
      |No tiene documentos ni cartas en este momento |
    Then I validate I am on "Documentos y Cartas Anteriores" container
    And I verify plan year label "Año:"
    And I validate current year defaulted in plan Year
    And I validate default value in Documents and letters dropdown in "Spanish"
    Then I validate no document message
      | No tiene documentos ni cartas en este momento |
    Then I verify Go back to welcome page button
      | Volver a la Pagina de Bienvenida |
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"

  @SLER-2340
  Scenario:SLER-2340:Verify Help drawer text on the document page in Spanish [RT-2021]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "7724352002" "5990496490" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I change the language from header to "Spanish"
    Then I validate I am on the "My Document Spanish" page
    And I click on the help drawer icon on the document page
    Then I validate help drawer open in right side of the page in Spanish
    And I verify help drawer "header Spanish" text on the My Document page
      | Ayuda |
    And I verify help drawer "sub header Spanish" text on the My Document page
      |Explicación de Mis documentos y cartas |
    And I verify help drawer "body title Spanish" text on the My Document page
      | Resumen |
    And I verify help drawer "body content Spanish" text on the My Document page
      | ¿Tiene preguntas sobre los documentos que debe proporcionar? Haga clic aquí para obtener más información |
      | Tiene 90 días para entregar los documentos que le pedimos. El color de la fecha límite indica el tiempo que le queda para entregar el documento.   |
      | Si la fecha límite está en verde, tiene entre 60 y 90 días para entregar sus documentos.                                                           |
      | Si la fecha límite está en amarillo, tiene entre 30 y 59 días para entregar sus documentos.                         |
      | Si la fecha límite está en rojo, tiene menos de 30 días para entregar sus documentos.                               |
      | ¿Se venció su solicitud de documentos? Si el botón de carga está activo, proporcione los documentos para revisión.  |
      | Si no puede cargar sus documentos, comuníquese con nuestro Centro de servicio al 1-855-752-6749. |
    And I verify help drawer "footer" text on the My Document page
      |¿Necesitas más ayuda?  Contáctenos |
    And I click on the help drawer icon to close on the document page
    Then I validate help drawer closed on the document page
    And I click on "Help me understand this page Spanish" link in Help Drawer
    Then I validate help drawer open in right side of the page in Spanish
    And I click on "here Spanish" link in Help Drawer
    And I validate I am on the "Submit Documents" page and close tab
    And I click on "Contact Us Spanish" link in Help Drawer
    And I validate I am on the "Podemos ayudar" page and close tab
    And I click on the help drawer icon to close on the document page
    And I click upload MVR button for "elegibilidad para ayuda financiera" in "Spanish"
    And I verify help drawer "Income header Spanish" text on the My Document page
      | Ayuda |
    And I verify help drawer "Income sub header Spanish" text on the My Document page
      | Comprobante de elegibilidad para ayuda financiera |
    And I verify help drawer "Income body title Spanish" text on the My Document page
      | Resumen |
    And I verify help drawer "Income body content Spanish" text on the My Document page
      | Para verificar sus ingresos, usted debe enviar dos documentos: |
      | (1) Uno de que conforme sus ingresos y                              |
      | (2) otro que confirme que previamente presentó y concilió su APTC en sus impuestos federales, o que no se requiere que lo haga |
      | Hay más información en nuestro sitio web.  |
    And I verify help drawer "Income footer" text on the My Document page
      | ¿Necesitas más ayuda?  Contáctenos |
    And I click on "our website Spanish" link in Help Drawer
    And I validate I am on the "Submit Documents" page and close tab
    And I click on "Contact Us Spanish" link in Help Drawer
    And I validate I am on the "Podemos ayudar" page and close tab
    And I close button to close modal
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2399
  Scenario:SLER-2399: OPS: MyDocs: Long file name, spinner, DB[RT-1985]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click on upload another document
    Then I select "Income" from the document type dropdown
    Then I select "Form 8962" from the document category type dropdown
    When I select document "TestMyDocWithNameLongerThan25Characters.jpg" and upload
    When I click on upload my document button
    Then I wait for 2000 milliseconds
    Then  I click on Sign Out in the Header for "Elmo"
    Then I validate the document details with values
      | 7708      |
      | null      |
      | Form 8962 |
      | jpg       |







