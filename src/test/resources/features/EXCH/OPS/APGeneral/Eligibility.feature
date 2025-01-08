@OPS
Feature: AP Individual dashboard - Eligibility data
  @SLER-709
  Scenario:Admin Portal dashboard Eligibility container with 2 households
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "7746317007" "7634740008" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I validate individual dashboard container titles: "Plans" "Account Summary" "Eligibility" "Renewals" "Reports" "Payloads" are displayed
    And I click View Detailed Eligibility button on Individual dashboard
    And I check "Household level application and eligibility data" table data
    And I check "Member level eligibility data" columns "Member" "CSR" "Relationship to the Primary Account Holder" "Tax Filer Status"
    And I check "John Lee" "SELF" "MFJ" or "Fernando Konopelski" "SELF" "QWD"
    And I check "Life change events" columns "Life Change Event" "Impacted Members" "Date of Event"
    And I logout from Admin Portal
  @SLER-709
  Scenario:Admin Portal dashboard Eligibility container no eligibility data
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4007901519" "8780994000" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I validate individual dashboard container titles: "Plans" "Account Summary" "Eligibility" "Renewals" "Reports" "Payloads" are displayed
    Then I check message "There is no eligibility data" is displayed
    And I logout from Admin Portal
  @SLER-709
  Scenario:Admin Portal dashboard Eligibility container past year 2023
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4007800744" "1106017043" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I validate individual dashboard container titles: "Plans" "Account Summary" "Eligibility" "Renewals" "Reports" "Payloads" are displayed
    And I click View Detailed Eligibility button on Individual dashboard
    Then I select tax household
    And I check Household level application and eligibility data table
    And I check "Member level eligibility data" columns "Member" "CSR" "Relationship to the Primary Account Holder" "Tax Filer Status"
    And I check "Elizabeth Simmons" "SISTER" "HOH" or "Cousin Bear" "SON" "SNGL"
    And I check "Life change events" columns "Life Change Event" "Impacted Members" "Date of Event"
    And I check "LOSS_OF_MEC_OTHER" "2023-04-30" or "BIRTH_ADOPTION_OR_PLACEMENT_FOR_ADOPTION" "2021-04-17"
    And I logout from Admin Portal

