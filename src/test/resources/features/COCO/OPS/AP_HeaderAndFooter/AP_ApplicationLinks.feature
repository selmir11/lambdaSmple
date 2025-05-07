@SLCR-34 @OPS @COCO @AP
Feature: AdminPortal: General: Header, footer, and application links

  @SLCR-34
  Scenario:SLCR-34:Validate Header and Footer on Search page for admin portal(landing page upon login) and Application Links validation
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "applicationLinkText Display" for Admin Portal
    Then I validate "applicationlinkarrow Display" for Admin Portal
    Then I validate "Logoutbutton Display" for Admin Portal
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
   And I verify text on the "Exch" "Admin portal Footer" in "English"
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click "CBMS Case ID Search" from application links dropdown
    And I validate I am on the "CBMS Search" page and close tab
    And I click "Document Lookup" from application links dropdown
    And I validate I am on the "Document LookUp" page and close tab
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab


  Scenario: Verify Header and Footer for Dashboard page and links for COCO Indiviual User
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "5890916640" "4007384519" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I validate I am on the "On Behalf Of(OBO)" page and close tab
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I verify text on the "Exch" "Admin portal Footer" in "English"

  @SLCR-34
  Scenario: Verify Manage Plans page Header and Footer
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I click Colorado Connect to search user
    Then I enter an "accountID" in any env "5890916640" "4007384519" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on "Manage Plans" user dashboard button
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I validate I am on the "On Behalf Of(OBO)" page and close tab
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then logout from Admin Portal

  @SLCR-34
  Scenario: Verify Manage Account Access page Header and Footer
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I click Colorado Connect to search user
    Then I enter an "accountID" in any env "5890916640" "4007384519" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on "Manage Account Access" user dashboard button
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I validate I am on the "On Behalf Of(OBO)" page and close tab
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then logout from Admin Portal

  @SLCR-34
  Scenario: Verify Manage Account Details page Header and Footer
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I click Colorado Connect to search user
    Then I enter an "accountID" in any env "5890916640" "4007384519" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on "Manage Account Details" user dashboard button
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I validate I am on the "On Behalf Of(OBO)" page and close tab
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then logout from Admin Portal

  @SLCR-34
  Scenario: Verify EDI Transactions reports page Header and Footer
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I click Colorado Connect to search user
    Then I enter an "accountID" in any env "5890916640" "4007384519" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on view button for "EDI Transactions" report
    Then I validate I am on the "EDI Transactions" page
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I validate I am on the "On Behalf Of(OBO)" page and close tab
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then logout from Admin Portal

  @SLCR-34
  Scenario: Verify Detailed EDI report page Header and Footer
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I click Colorado Connect to search user
    Then I enter an "accountID" in any env "5890916640" "4007384519" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on view button for "Detailed EDI" report
    Then I validate I am on the "Detailed EDI" page
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I validate I am on the "On Behalf Of(OBO)" page and close tab
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then logout from Admin Portal

  @SLCR-34
  Scenario: Verify Account Activity report page Header and Footer
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I click Colorado Connect to search user
    Then I enter an "accountID" in any env "5890916640" "4007384519" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on view button for "Account Activity" report
    Then I validate I am on the "Account Activity" page
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I validate I am on the "On Behalf Of(OBO)" page and close tab
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then logout from Admin Portal
