@OPS @manageplan
Feature: Manage Plans: Buttons (positive and negative testing)
  @SLCR-275
  Scenario: Verify user with role for Manage Plans will be able to make changes
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5720167020" "4006533799" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2024" plan year on manage plan
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page Coco account
#    Then I check default year displays
    And I verify Medical button checked
    And I validate buttons displayed on CoCo Manage page
    Then I click Make Changes Medical button
    And I validate "Save" medical button displays on Manage page
    And I click Reset Changes Medical
    And logout from Admin Portal
  @SLCR-275
  Scenario: Verify user with no role for Manage Plans will be not able make changes
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalSEReport_UN_STG" password "adminPortalSEReport_PW_STG" and "adminPortalSEReport_UN_QA" password "adminPortalSEReport_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5720167020" "4006533799" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    Then I check default year displays
    And I select the "2024" plan year on manage plan
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page Coco account
    And I verify Medical button checked
    And I validate medical and dental buttons does not display on Manage page
    And I logout from Admin Portal
