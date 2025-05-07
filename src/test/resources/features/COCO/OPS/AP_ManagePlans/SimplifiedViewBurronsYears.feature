@OPS @SLCR-766 @ManagePlansCoco
Feature: Manage Plans:CoCo: Simplified View Buttons (positive and negative testing [CCRT-448]
  @SLCR-766
  Scenario:SLCR-766:Manage plan 2023
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "8313683700" "6503350186" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I check current Simplified Medical container labels CoCo
    And I verify Medical button checked
    Then I click Make Changes Medical button
    And I validate "Save" medical button displays on Manage page
    And I click Reset Changes Medical
    And I select Plans Med Active Policy
    And logout from Admin Portal
  @SLCR-766
  Scenario:SLCR-766:Manage plan 2023 user has no role for manage plans
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalDLT_UN_STG" password "adminPortalDLT_PW_STG" and "adminPortalDLT_UN_QA" password "adminPortalDLT_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "8313683700" "6503350186" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I check current Simplified Medical container labels CoCo
    And I verify Medical button checked
    Then I validate Make Changes Medical button does not display on Manage Plans page
    And I logout from Admin Portal
    And I validate I am on the "Login" page



    
