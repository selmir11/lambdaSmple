@OPS @Exch @manageplans
Feature: Manage Plans: Plan Summary container
  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page

  @SLER-828
  Scenario: SLER-828 Previous Med Container verification
    Then I enter an accountId in any Env "2642003470" "5830336830" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I validate title and labels on Manage page for year "2023"
    Then I validate previous financial period "Medical" plan summary in DB for 1 policy 2 members on AP Manage Plans
    Then I validate previous "Medical" all details table in DB for 2 members on policy "1" for DB row 1 on AP Manage Plans
    Then I validate previous "Medical" all details table in DB for 1 members on policy "2" for DB row 0 on AP Manage Plans
    And I select "Medical" Show Financial Period for policy 2 on Manage Plans page
    Then I validate previous financial period "Medical" plan summary in DB for 2 policy 1 members on AP Manage Plans
    Then I validate previous "Medical" all details table in DB for 2 members on policy "1" for DB row 1 on AP Manage Plans
    Then I validate previous "Medical" all details table in DB for 1 members on policy "2" for DB row 0 on AP Manage Plans
    And I select "Medical" Show Financial Period for policy 1 on Manage Plans page
    Then I validate previous financial period "Medical" plan summary in DB for 1 policy 2 members on AP Manage Plans
#    Medical only view (add steps needed)
    Then I click "Dental" plan type on Manage Plans page
    Then I verify "Dental" plan type is not showing on Manage Plans page
    Then I verify "Medical" plan type is showing on Manage Plans page
    Then I validate previous financial period "Medical" plan summary in DB for 1 policy 2 members on AP Manage Plans
    Then I validate previous "Medical" all details table in DB for 2 members on policy "1" for DB row 1 on AP Manage Plans
    Then I validate previous "Medical" all details table in DB for 1 members on policy "2" for DB row 0 on AP Manage Plans
    And I select "Medical" Show Financial Period for policy 2 on Manage Plans page
    Then I validate previous financial period "Medical" plan summary in DB for 2 policy 1 members on AP Manage Plans
    Then I validate previous "Medical" all details table in DB for 2 members on policy "1" for DB row 1 on AP Manage Plans
    Then I validate previous "Medical" all details table in DB for 1 members on policy "2" for DB row 0 on AP Manage Plans

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal