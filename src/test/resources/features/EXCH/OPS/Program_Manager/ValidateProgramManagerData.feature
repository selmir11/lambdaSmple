@OPS @OPSProgramManager @SLER-2328
Feature: Verify Program Manager Data

  @SLER-2328
  Scenario: Verify Program Manager Data
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "6203570527" "2813006563" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I validate the assistnet Data in Profile summary container
    And I validate the assistNet Organization Details in admin portal
    Then I click on Search button in AP broker dashboard page
    Then I validate I am on the "Admin search" page
    And I logout from Admin Portal