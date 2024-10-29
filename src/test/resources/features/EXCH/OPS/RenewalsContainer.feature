@OPS
Feature: Admin Portal Renewals container
  @SLER-707
  Scenario: Admin Portal Renewals container data on Individual dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1102047439" "9099768081" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    Then I verify Renewal status label and data "Renewal Status: PENDING" is displayed
    And I validate "Medical" "Auto-Renewal Plan:" as "Cigna Connect Flex Bronze 7200" and "Dental" "Auto-Renewal Plan:" as "Delta Dental of Colorado Family Value Plan"
    And I verify container "Renewals" and "Plan Year 2025" is displayed
    And I click Go Back on admin portal broker dashboard
    Then I validate I am on the "Admin search" page
    Then I logout from Admin Portal