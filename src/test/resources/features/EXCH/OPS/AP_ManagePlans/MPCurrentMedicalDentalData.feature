@OPS @Exchmanageplans
Feature: Manage Plans: Current Med & Dent Data Years dropdown
  @SLER-977
  Scenario:SLER-977: Current Med & Dent Data Years dropdown verified
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "2214004770" "2564008767" to search user
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
    And I check current Medical container labels and data display
    Then I check current Dental container labels and data display
    And I check for Previous Medical container display
    And I check for Previous Dental container display
    Then I check default year displays
    Then I verify Years in dropdown starting from "2022" as expected
    And I collapse year dropdown
    And I check for Previous Medical container display
    And I check for Previous Dental container display
    Then I logout from Admin Portal