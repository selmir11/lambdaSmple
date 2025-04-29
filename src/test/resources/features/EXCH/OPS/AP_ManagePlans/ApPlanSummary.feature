@OPS @Exch @manageplans
Feature: Manage Plans: Plan Summary container
  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page

  @SLER-2421
  Scenario: SLER-2421 Current Med & Dent Only Data
    Then I enter an accountId in any Env "7850487002" "8561552700" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I validate title and labels on Manage page for year "2025"
    Then I click "Dental" plan type on Manage Plans page
    Then I verify "Dental" plan type is not showing on Manage Plans page
    Then I verify "Medical" plan type is showing on Manage Plans page
    Then I validate current "Medical" plan summary in DB for 2 members on AP Manage Plans
    Then I validate current "Medical" all details table in DB for 2 members on AP Manage Plans
    Then I click "Dental" plan type on Manage Plans page
    Then I verify "Both" plan type is showing on Manage Plans page
    Then I validate current "Medical" plan summary in DB for 2 members on AP Manage Plans
    Then I validate current "Medical" all details table in DB for 2 members on AP Manage Plans
    Then I validate current "Dental" plan summary in DB for 2 members on AP Manage Plans
    Then I validate current "Dental" all details table in DB for 2 members on AP Manage Plans
    Then I click "Medical" plan type on Manage Plans page
    Then I verify "Medical" plan type is not showing on Manage Plans page
    Then I verify "Dental" plan type is showing on Manage Plans page
    Then I validate current "Dental" plan summary in DB for 2 members on AP Manage Plans
    Then I validate current "Dental" all details table in DB for 2 members on AP Manage Plans

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal