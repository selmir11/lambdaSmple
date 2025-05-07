@OPS @APGeneral
Feature: Admin Portal Renewals container
  @SLER-707
  Scenario:SLER-707:Admin Portal Renewals container data on Individual dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1102047439" "1100086760" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    Then I verify Renewal status label and data "Renewal Status: PENDING" is displayed or "Renewal Status: CONFIRMED" is displayed
    And I validate "Medical" "Auto-Renewal Plan:" as "Cigna Connect Flex Bronze 7200" and "Dental" "Auto-Renewal Plan:" as "Delta Dental of Colorado Family Value Plan"
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    And I click Go Back on admin portal broker dashboard
    Then I validate I am on the "Admin search" page
    Then I logout from Admin Portal
  @SLER-707
  Scenario:SLER-707:Admin Portal Renewals container data on Individual dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1108010584" "1102036847" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    Then I verify Renewal status label and data "Renewal Status: PENDING" is displayed or "Renewal Status: CONFIRMED" is displayed
    And I validate only "Auto-Renewal Plan:" as "Cigna Connect Flex Silver 6000" or "Elevate Health Plans Colorado Option Bronze"
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    Then I logout from Admin Portal

      @SLER-707
  Scenario:SLER-707:Admin Portal Renewals container data on Individual dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "6003880150" "1102026899" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    Then I verify Renewal status is displayed
    And I validate Dental plan only "Auto-Renewal Plan:" as "Cigna Dental Pediatric" or "Delta Dental of Colorado Pediatric Enhanced Plan"
    And I click Go Back on admin portal broker dashboard
    Then I click on Reset button in AP dashboard page
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1808057456" "7698756006" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    And I verify No Renewal message displays
    Then I logout from Admin Portal

  @SLER-707
  Scenario:SLER-707:Admin Portal Renewals container data on Individual dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "2076005776" "6608400586" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    And I verify No Renewal message displays
    Then I verify reason for no renewal as Renewal Action: System Exclusion: OVER_25_DEPENDENT
    And I click Go Back on admin portal broker dashboard
    Then I click on Reset button in AP dashboard page
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "2155005404" "1106016861" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    And I verify No Renewal message displays
    Then I verify reason for no renewal where Renewal Action: OVER_29_CATASTROPHIC
    And I click Go Back on admin portal broker dashboard
    Then I validate I am on the "Admin search" page
    Then I logout from Admin Portal

  @SLER-707
  Scenario:SLER-707:Admin Portal Renewals container data on Individual dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "2155005704" "9074863003" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    And I verify No Renewal message displays
    And I click Go Back on admin portal broker dashboard
    Then I click on Reset button in AP dashboard page
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1708010555" "4006264018" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    And I verify No Renewal message displays
    Then I logout from Admin Portal

  @SLER-707
  Scenario:SLER-707:Admin Portal Renewals container data on Individual dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1107007976" "2132000375" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    Then I verify reason for no renewal where Renewal Action: CUSTOMER_OPT_OUT
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    And I click Go Back on admin portal broker dashboard
    Then I logout from Admin Portal

  @SLER-707
  Scenario:SLER-707:Admin Portal Renewals container data on Individual dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "7746667007" "7746667007" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    Then I verify Renewal status "Renewal Status: CANCELED" is displayed
    Then I verify reason for no renewal where Renewal Action: SYSTEM_CANCEL_DUE_TO_TERM
    And I click Go Back on admin portal broker dashboard
    Then I logout from Admin Portal