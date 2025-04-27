@OPS @SLER-1940 @managePlan
Feature: Manage Plans:Simplified view buttons and tables data
  Scenario:Manage plan 2022
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1303017415" "2110007768" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I validate title and labels on Manage page
    And I validate simplified plans "Medical Plan:" and "Dental Plan:" and labels on Manage page
    And I validate Make Changes button displayed for "Both" on Manage page
    Then I verify both buttons Medical and Dental is checked
    Then I click Make Changes Medical button
    And I validate "Save" medical button displays on Manage page
    And I click Reset Changes Medical
    Then I click Make Changes Dental button
    And I validate "Save" dental button displays on Manage page
    And I click Reset Changes Dental
    And I select Plans Med Active Policy
    Then I check current Simplified Medical container labels
    And I check plan name: "Friday Bronze Rx Copay" "Policy Coverage: 01/01/2023 to 12/31/2023" "04/12/2023" or plan name: "Bronze 5300 HSA" "Policy Coverage: 01/31/2022 to 12/31/2022" "02/28/2022"
    Then I validate "63312CO0600090-01" or "31070CO0010007-01" data for HIOS ID on manage plans
    Then I validate member table data row "1", "1105217869", "apelizcctid apindkglfgyq", "10/01/1980", "Self", "No" or "1", "1105217869", "apelizcctid apindkglfgyq", "10/01/1980", "Self", "No"
    Then I validate member table data row two "2", "3616120780", "Baby apindkglfgyq", "03/15/2023", "Son", "No" or "1", "1105217869", "apelizcctid apindkglfgyq", "10/01/1980", "Self", "No"
    And I validate "Medical" coverage table data on Simplified View "1", "01/01/2023", "12/31/2023", "Submitted", "No", "" or "1", "01/01/2023", "12/31/2023", "Submitted", "No", ""
    Then I validate "Medical" coverage table data row two on Simplified View "2", "01/01/2023", "12/31/2023", "Submitted", "No", "" or "1", "01/01/2023", "12/31/2023", "Submitted", "No", ""
    And I validate "Medical" financial table data on Simplified View "1", "04/01/2023", "12/31/2023", "$315.83", "$271.46" or "1", "01/01/2023", "12/31/2023", "Submitted", "No"
    Then I validate "Medical" financial table data row two on Simplified View "2", "03/01/2023", "12/31/2023", "$182.35", "$0.00" or "2", "01/01/2023", "12/31/2023", "Submitted", "No"
    And logout from Admin Portal
    And I validate I am on the "Login" page
  Scenario:Manage plan 2022 user has no role for manage plans
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalDLT_UN_STG" password "adminPortalDLT_PW_STG" and "adminPortalDLT_UN_QA" password "adminPortalDLT_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "5830106510" "2110007768" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate title and labels on Manage page
    And I select the "2022" plan year on manage plan
    Then I verify both buttons Medical and Dental is checked
    And I validate medical and dental buttons does not display on Manage page
    And I logout from Admin Portal
    And I validate I am on the "Login" page