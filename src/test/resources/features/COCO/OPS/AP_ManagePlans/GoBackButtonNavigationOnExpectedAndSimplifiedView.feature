@OPS @ManagePlansCoco @COCO
  Feature: Manage Plans: Button Go Back navigation
    @SLCR-724
  Scenario:SLCR-724 : Manage plan 2024 Go Back navigation
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5720167020" "4006533799" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    And I check default year displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I validate title and labels on Manage page Coco account
    Then I validate blue bar on Manage page
    And I check default year displays
    And I select the "2024" plan year on manage plan
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    Then I validate buttons displayed on CoCo Manage page
    Then I validate Go Back button on Manage Plan page
    And I click Go Back button on Manage Plan page
    And I validate I am on the "Individual CoCo" page
    And I check default year displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2024" plan year on manage plan
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    Then I validate buttons displayed on CoCo Manage page
    And I select the "2024" plan year on manage plan
    And I wait for 500 milliseconds
    And I validate I am on the "Manage Plans" page
    Then I validate buttons displayed on CoCo Manage page
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    Then I validate Go Back button on Manage Plan page
    And I click Go Back button on Manage Plan page
    And I validate I am on the "Individual CoCo" page
    And I logout from Admin Portal
  @SLCR-724
  Scenario:SLCR-724 :Manage plan 2025 Go Back navigation
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5010518090" "4006533799" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    And I check default year displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I validate title and labels on Manage page Coco account
    Then I validate blue bar on Manage page
    And I check default year displays
    And I validate I am on the "Manage Plans" page
    Then I validate buttons displayed on CoCo Manage page
    Then I validate Go Back button on Manage Plan page
    And I click Go Back button on Manage Plan page
    And I validate I am on the "Individual CoCo" page
    And I check default year displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate buttons displayed on CoCo Manage page
    And I validate I am on the "Manage Plans" page
    Then I validate buttons displayed on CoCo Manage page
    And I select the "2024" plan year on manage plan
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    Then I validate Go Back button on Manage Plan page
    And I click Go Back button on Manage Plan page
    And I validate I am on the "Individual CoCo" page
    And I logout from Admin Portal
  @SLCR-724
  Scenario:SLCR-724 :Manage plan 2023 Go Back navigation from Simple View MP page
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "8313683700" "8163138600" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    And I check default year displays
    Then I click on "Manage Plans" user dashboard button
    And I select the "2023" plan year on manage plan
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    Then I validate buttons displayed on CoCo Manage page
    Then I check current Simplified Medical container labels CoCo
    Then I click Go Back button on Simplified View
    And I validate I am on the "Individual CoCo" page
    Then I click on "Manage Plans" user dashboard button
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    And I check default year displays
    And I select the "2023" plan year on manage plan
    And I wait for 500 milliseconds
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I wait for 500 milliseconds
    And I validate I am on the "Manage Plans" page
    Then I click Go Back button on Simplified View
    And I validate I am on the "Individual CoCo" page
    And I logout from Admin Portal