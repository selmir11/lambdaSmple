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
    And I validate Document category list displayed in ascending order

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

    Then I validate Document Types for selected category list document category in ascending order
      | Correction Proof -- Correction Request |
      | Bureau of Indian Affairs Issued Document -- Tribal Enrollment/Membership Document -- Other Official Federal Recognized Tribe Document |
      | Appeals                                                                                                           |
      | Power of Attorney-- Other legal Document |
      |Federally Approved Tribal Document-- U.S. Birth Certificate-- U.S. Certificate of Naturalization-- U.S. Passport-- Other Official Citizenship Document|
      | Complaints--  Feedback  |
      | Customer Authorization Form    |
      | Proof of Life Document    |
      | DS2019 (Certificate of Eligibility for Exchange Visitor (J-1) Status)-- I-20 (Certificate of Eligibility for Nonimmigrant (F-1) Student Status)-- I-327 Reentry Permit-- I-551 Permanent Resident Card-- I-571 Refugee Travel Document-- I-766 Employment Authorization Card-- INS Form I-94 (Arrival/Departure Record)-- INS Form I-94 (Arrival/Departure Record) in Unexpired Foreign Passport-- Machine Readable Immigrant Visa (with Temporary I-551 Language)-- Temporary I-551 Stamp (on passport or I-94)-- Other Official US Citizenship and Immigration Services Document   |
      |Health First Colorado (Medicaid) Application|
      | Health First Colorado (Medicaid) Redetermination (RRR)|
      |Driver's License - State, Federal or Local Government --School ID-- US Military ID Card -- Other Official Government ID   |
      | Court or Legal Document-- Unexpired State ID Card-- Other Official Document                                             |
      |Employer Statement-- Form 8962 --Investment Income Statement-- Pay Stub/Check-- Premium Tax Credit Reconciliation Attestation Form-- Retirement Income Statement-- Self-Employment Ledger-- Social Security Income Statement-- Tax Document-- Unemployment Amount Letter-- Other Official Income Document   |
      | Report Life Change Events Individual Marketplace    |
      | Document from Medicare-- Explanation of Health Coverage Form|
      |Document from Peace Corps-- Explanation of Health Coverage Form|
      |Social Security Card-- Social Security Document-- Other Official Document with First/Last Name and SSN|
      |Document from TRICARE-- Explanation of Health Coverage Form|
      |Document from Veterans Affairs (VA)-- Explanation of Health Coverage Form|
      |Other                                                                               |
