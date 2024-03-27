@SLCR-34
Feature: AdminPortal: General: Header, footer, and application links

  @SLCR-34
  Scenario: Validate Header and Footer on Search page for admin portal(landing page upon login) and Application Links validation
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User
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


  @SLCR-34
  Scenario: Verify Header and Footer for Dashboard page and links for COCO Indiviual User
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User
    And I validate I am on the "Admin search" page
    And I click Colorado Connect to search user
    Then I enter an "accountID" "1108066870" to search user
    Then I click on Search
    Then I click on User to navigate user Dashboard
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
#    Then logout from Admin Portal

  @SLCR-34
  Scenario: Verify Manage Plan Header and Footer
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User
    And I validate I am on the "Admin search" page
    And I click Colorado Connect to search user
    Then I enter an "accountID" "1108066870" to search user
    Then I click on Search
    Then I click on User to navigate user Dashboard
    Then I click on Manage plans
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of(OBO)" from application links dropdown
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