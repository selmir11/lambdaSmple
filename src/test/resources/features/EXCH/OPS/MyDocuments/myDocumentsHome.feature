@OPS
Feature: My Document Home Page validations

  @SLER-2090 @OPSRegression
  Scenario: OPS MyDocs Navigating to file explorer[RT-1819]
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

  @SLER-2109 @OPSRegression
  Scenario: OPS MyDocs Select Type and checks errors[RT-1938]
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
  Scenario: Verify user can see their Documents and Notices in the Documents and Notices container [RT-1818]
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
    And  I select year "All" in plan year
    Then I validate all uploaded documents or notices loaded for my account start with "IND"
      | IND_Plan Selection and Payment Confirmation (EN-002-04)|
      | IND_Renewal Plan Still Available (EN-007-01)         |
      | IND_Eligibility Change with SEP (ELG-101-03)               |
      | IND_Welcome Message (AM-001-01)                            |
    And  I Click on double chevron in Past Documents and Letters Container
    Then I validate Date Received, Time Received and Download button available
    And I select year "Previous Year" in plan year
    And  I Click on double chevron in Past Documents and Letters Container
    Then I validate document date shows for selected year
    And I select year "Current Year" in plan year
    Then I validate no document message
      |You do not have any Documents or Letters at this time |
    And I change the language from header to "Spanish"
    Then I validate no document message
      |No tiene documentos ni cartas en este momento |
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"





  @SLER-2102
  Scenario:  Verify Text on upload doc modal in My documents from manage client via broker portal [RT-1906]
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
  Scenario:  Verify Text on upload doc modal in My documents from manage client via Admin Portal [ RT-1907]]
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
  Scenario: Verify English and Spanish Text for Document and upload page [RT-1975]
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
    And I verify the page text on the My Documents Page
      | My Documents and Letters |
      | We need more information to confirm or verify what you told us in your application. |
      | Help me understand this page                                                        |
      | Information We Need                                                                 |
      | Upload another document |
      | Past Documents and Letters |
    And I click on upload another document
    And I click on cancel button on upload document pop up
    And I change the language from header to "Spanish"
    And I verify the page text on the My Documents Page
      | Mis Documentos y Cartas |
      | Necesitamos más información para confirmar o verificar lo que nos informó en su solicitud. |
      | Ayuda para entender esta página                                                        |
      | Información que Necesitamos                                                                 |
      | Cargar otro documento |
      | Documentos y Cartas Anteriores |
    And I change the language from header to "English"
    Then  I click on Sign Out in the Header for "Elmo"


  @SLER-2155
  Scenario:  Verify document category and their types in Ascending orders via Admin Portal [ RT-1987]
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
  Scenario:  Verify document category and their types in Ascending orders via Admin Portal in Spanish [ RT-2012]
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


  @SLER-2164 @OPSRegression
  Scenario: OPS MyDocs Verify All Modal Errors[RT-1984]
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
  Scenario: My documents Indiviual porter Header , Footer, Title validation in Spanish [RT-1962]
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
    And I verify the page text on the My Documents Page
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


  @SLER-2234 @OPSRegression
  Scenario: Verify Welcome letter downloaded with proper name format [RT-1996]

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
    And I click on download "IND_Welcome Message (AM-001-01)" document
    Then I verify file "IND_Welcome Message (AM-001-01)" downloaded with Proper name format
    Then  I click on Sign Out in the Header for "Elmo"

  @SLER-2252
  Scenario: Verify user can upload Document to the MVR for all Document Category [RT-1979]
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
    Then I enter an "accountID" in any env "5450920960" "7892055002" to search user
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
