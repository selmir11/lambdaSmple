@OPS
Feature: OPS: IndDash: Removed Members Don't Show
  @SLCR-717
  Scenario:SLCR-717 : OPS: IndDash: Removed Members Don't Show
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "4007384519" "5890916640" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I verify coco individual Account Summary details