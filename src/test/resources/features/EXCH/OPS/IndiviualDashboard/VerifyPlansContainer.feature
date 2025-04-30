@OPS @Exch @IndiviualDashboard
Feature: Verify Plans Container Ind Dash
  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page

@SLER-2416
  Scenario: SLER-2416 OPS: IndDash: Verify Plans Container Ind Dash
    Then I enter an accountId in any Env "9018373022" "5990056940" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
#  2025 Plan Container
    Then I verify Plan container for year "2025" against the DB on the Individual dashboard
#  2024 Plan Container
    And I select year "2024" from Manage Plan container on Individual dashboard
  And I wait for 9000 milliseconds
    Then I verify Plan container for year "2024" against the DB on the Individual dashboard
#  2023 Plan Container
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "9018373022" "8232638600" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I select year "2023" from Manage Plan container on Individual dashboard
    Then I verify Plan container for year "2023" against the DB on the Individual dashboard
#  2022 Plan Container
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "5590636110" "9001767097" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I select year "2022" from Manage Plan container on Individual dashboard
    Then I verify Plan container for year "2022" against the DB on the Individual dashboard
#  No Plans on account
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "8214162800" "1800067242" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify Plan container with no active plan on the Individual dashboard
    And I select year "2024" from Manage Plan container on Individual dashboard
    And I verify Plan container with no active plan on the Individual dashboard
    And I select year "2023" from Manage Plan container on Individual dashboard
    And I verify Plan container with no active plan on the Individual dashboard
    And I select year "2022" from Manage Plan container on Individual dashboard
#  Past Plans on account
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "3953909650" "9093569055" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I verify Plan container with no active plan on the Individual dashboard
    And I select year "2024" from Manage Plan container on Individual dashboard
    And I verify Plan container with no active plan on the Individual dashboard
    And I select year "2023" from Manage Plan container on Individual dashboard
    And I verify Plan container with no active plan on the Individual dashboard
    And I select year "2022" from Manage Plan container on Individual dashboard

  Then logout from Admin Portal