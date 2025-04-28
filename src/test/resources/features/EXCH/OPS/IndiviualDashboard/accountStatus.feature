@OPS @Exch @IndiviualDashboard
Feature: OPS: IndDash: Account Statuses
  @SLER-1239
  Scenario:IndDash: Account Statuses
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I enter an "accountID" in any env "6401070186" "1907066501" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on "Manage Account Access" user dashboard button
    Then I verify account access status is "PROVISIONED"
    And I close current tab and switch back to previous tab
    And I click Go Back on admin portal program manager dashboard
    And I refresh the page
    Then I wait for 200 milliseconds
    Then I enter an "accountID" in any env "5810106730" "1901066513" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on "Manage Account Access" user dashboard button
    Then I verify account access status is "DEPROVISIONED"
    And I close current tab and switch back to previous tab
    And I click Go Back on admin portal program manager dashboard
    And I refresh the page
    Then I wait for 200 milliseconds
    Then I enter an "accountID" in any env "8838907600" "8308652700" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on "Manage Account Access" user dashboard button
    Then I verify account access status is "STAGED"
