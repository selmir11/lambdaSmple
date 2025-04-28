@OPS @Exch @IndiviualDashboard
Feature: EDI Detailed Outbound Transactions : Verify all data
  @SLER-858
  Scenario:IndDash: Verify Detailed EDI Report Page
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I wait for 2000 milliseconds
    And I validate I am on the "Admin search" page
    Then I enter an "accountID" in any env "6702500086" "8335642700" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on view button for "Detailed EDI" report
    Then I validate I am on the "Detailed EDI" page
    Then I select plan year for "2023"
    Then I click on search button on EDI report page
    And I verify Detailed EDI headers data
    And I verify Detailed Outbound Transactions table header order
    And I verify Outbound Transactions data
    Then I validate sorting is working as expected for all columns