@SLER-352
Feature: Verify the navigation from My Documents get assistance from OBO
  @SLER-352
  Scenario: Verify the navigation from My Documents get assistance from OBO
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I enter an accountId in any Env "8316608600" "1506066573" to search user
    Then I click on Search button in find certified broker page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help Exch OBO" page
    And I click the back button from Find Expert Help page
    Then I validate I am on the "Account Overview" page

