@OPS @COCO @UserDashboard
Feature: OPS: IndDash: Verify Detailed EDI Report Page
  @SLCR-897
  Scenario:SLCR-897:IndDash: Verify Detailed EDI Report Page
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "9059867099" "9055878011" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on view button for "Detailed EDI" report
    Then I validate I am on the "Detailed EDI" page
    And I verify Detailed EDI headers data for coco
    And I verify Detailed Outbound Transactions table header order for coco
    And I verify Outbound Transactions data for coco
    Then I validate sorting is working as expected for all columns for coco