@OPS
Feature: Manage Plans: Buttons (positive and negative testing) buttons in previous year 2023 //2148
  @SLER-838
  Scenario: Verify user with role for Manage Plans will be able to make changes
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4007126206" "2425005563" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page
    Then I check default year displays
    Then I verify both buttons Medical and Dental is checked
    And I validate buttons displayed on Manage page
    Then I click Make Changes Medical button
    And I validate "Save" medical button displays on Manage page
    And I click Reset Changes Medical
    Then I click Make Changes Dental button
    And I validate "Save" dental button displays on Manage page
    And I click Reset Changes Dental
    And logout from Admin Portal
  @SLER-838
  Scenario: Verify user with role for Manage Plans will be able to make changes
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4007126206" "2564008767" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page
   # Then I check default year displays
    Then I verify both buttons Medical and Dental is checked
   # Then I verify Years in dropdown starting from "2022" as expected
    And I select the "2023" plan year on manage plan
    Then I verify both buttons Medical and Dental is checked
    And I validate buttons displayed on Manage page
    Then I click Make Changes Medical button
    And I validate "Save" medical button displays on Manage page
    And I click Reset Changes Medical
    Then I click Make Changes Dental button
    And I validate "Save" dental button displays on Manage page
    And I click Reset Changes Dental
    And logout from Admin Portal
  @SLER-838
  Scenario: Verify user with no role for Manage Plans will be not able make changes
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalSEReport_UN_STG" password "adminPortalSEReport_PW_STG" and "adminPortalSEReport_UN_QA" password "adminPortalSEReport_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4007126206" "2425005563" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page
    Then I check default year displays
    Then I verify both buttons Medical and Dental is checked
    And I validate medical and dental buttons does not display on Manage page
    And I logout from Admin Portal