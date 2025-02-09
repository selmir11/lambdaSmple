@OPS
Feature: My documents Indiviual porter Header , Footer, Title and dropdown display validation
  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-700
  Scenario: My documents Indiviual porter Header , Footer, Title and dropdown display validation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I verify the page text in "English" on the My Documents Page
#    Verify Footer and welcome back navigate button
    Then I validate Welcome back button navigates to welcome page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I verify text on the "Exch" "Footer" in "English"
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
#    Verify Header and sign out
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click link my docs on accountOverview page
    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click link my docs on accountOverview page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click link my docs on accountOverview page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "ExpertHelp in community" Header
    And I go to the previous browser page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page
    And I go to the previous browser page

  @SLER-703
  Scenario: My documents Indiviual porter upload doc modal text for English/Spanish
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I verify the page text in "English" on the My Documents Page
    And I click on upload another document
    And I validate Modal texts on upload document pop up
    And I close button to close modal
    And I change the language from header to "Spanish"
    And I verify the page text in "Spanish Headers" on the My Documents Page
    And I click on upload another document in spanish
    And I validate upload another document modal texts in spanish
    And I close button to close modal

  @SLER-708
  Scenario: Verify user can select each category from category dropdown
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click on upload another document
    And I verify user can select each type from type dropdown

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

