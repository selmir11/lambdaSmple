@OPS @Exchmanageplans
Feature: Manage Plans: No Past medical and No Past dental periods //RT2098
  @SLER-979
  Scenario:SLER-979:Verify Manage Plans page when 2024 have No Past medical and dental periods
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4007126206" "1306056801 " to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I select year "2024" from Manage Plan container on Individual dashboard
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page
    Then I check default year displays
    Then I verify both buttons Medical and Dental is checked
    And I check for Previous Medical container message display
    And I check for Previous Dental container message display
    Then I verify Years in dropdown starting from "2021" as expected
    And I select the "2022" plan year on manage plan
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I logout from Admin Portal
  @SLER-979
  Scenario:SLER-979:Verify Manage Plans page when 2022  have No Past medical and dental periods
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "9093569055" "2865006566" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I select year "2022" from Manage Plan container on Individual dashboard
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page
    Then I check default year displays
    Then I verify Years in dropdown starting from "2021" as expected
    And I select the "2022" plan year on manage plan
    And I wait for 300 milliseconds
    Then I verify both buttons Medical and Dental is checked
    And I check for Previous Medical container message display
    And I check for Previous Dental container message display
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I logout from Admin Portal
  @SLER-979
  Scenario:SLER-979:Verify Manage Plans page when 2023 have No Past medical and dental periods
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "5550180800" "2865006566" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I select year "2023" from Manage Plan container on Individual dashboard
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page
    Then I check default year displays
    Then I verify both buttons Medical and Dental is checked
    And I check for Previous Medical container message display
    And I check for Previous Dental container message display
    Then I verify Years in dropdown starting from "2021" as expected
    And I select the "2023" plan year on manage plan
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I logout from Admin Portal
