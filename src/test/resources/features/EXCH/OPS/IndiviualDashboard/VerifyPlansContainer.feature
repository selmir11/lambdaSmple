Feature: Verify Plans Container Ind Dash
@SLER-2416 #WIP
  Scenario: OPS: IndDash: Verify Plans Container Ind Dash[RT-2228]
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "9018373022" "5990056940" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate title and labels on Manage page
    And I check default year displays
    Then I verify Years in dropdown starting from "2021" as expected
    And I select the "2024" plan year on manage plan
    Then I validate buttons displayed on Manage page









