@OPS
Feature: OPS: IndDash: Check Exclusion Report
  @SLER-2393
  Scenario:IndDash: Check Exclusion Report
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I wait for 2000 milliseconds
    Then I enter an accountId in any Env "4007993032" "4006144055" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I click on view button for "Exclusion Reason" report
    Then I validate I am on the "Exclusion Reason" page
    And I wait for 500 milliseconds
    Then I select "2022" to search exclusion report
    Then I select "BOTH" coverage type dropdown
    And I verify Exclusion Report headers data
    And I verify Exclusion Report table header order
    And I verify Exclusion Report data
    Then I validate sorting is working as expected for all columns for exclusion report