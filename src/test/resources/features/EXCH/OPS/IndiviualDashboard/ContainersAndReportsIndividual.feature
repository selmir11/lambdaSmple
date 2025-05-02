@OPS @Exch @IndiviualDashboard
Feature: Dashboard Individual: Verify Containers and Reports header and footer
  @SLER-591
  Scenario: Verify Containers
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "9093567025" "9093567025" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I validate individual dashboard container titles: "Plans" "Account Summary" "Eligibility" "Renewals" "Reports" "Payloads" are displayed
    Then I click on view button for "EDI Transactions" report
    And I validate I am on the "Admin Portal EDI Transactions" page
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I initiate incoming page
    And I logout from Admin Portal
  @SLCR-591
  Scenario: Verify Exclusion Reason reports page Header and Footer
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I wait for 2000 milliseconds
    Then I enter an accountId in any Env "9093567025" "9093567025" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on view button for "Exclusion Reason" report
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I initiate incoming page
    And I logout from Admin Portal

  @SLCR-591
  Scenario: Verify Detailed EDI report page Header and Footer
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "9093567025" "9093567025" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on view button for "Detailed EDI" report
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I initiate incoming page
    And I logout from Admin Portal
  @SLCR-591
Scenario: Verify Account Activity report page Header and Footer
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "9093567025" "9093567025" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on view button for "Account Activity" report
    Then I validate "Logo" for Admin Portal
    Then I validate "UserName Display" for Admin Portal
    Then I validate "PersonSymbol Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "accountInformation Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    Then I validate "UserDropdown Display" for Admin Portal
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I initiate incoming page
    And I logout from Admin Portal



