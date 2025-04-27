Feature: Verify Plans Container CoCo Ind Dash
  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page

  @SLCR-922
  Scenario: OPS: IndDash: Verify Plans Container CoCo Ind Dash[CCRT-141]
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "8505622800" "4006533799" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    And I wait for 9000 milliseconds
      # 2025 Plan Container  8505622800
    And I verify Plan container for year "2025" against the DB on the CoCo dashboard
      # 2024 Plan Container
    And I select year "2024" from Manage Plan container on Individual dashboard
    And I wait for 9000 milliseconds
    And I verify Plan container for year "2024" against the DB on the CoCo dashboard
      # 2023 Plan Container  8048284700
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "6407760357" "6503350186" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    And I wait for 7000 milliseconds
    And I select year "2023" from Manage Plan container on Individual dashboard
    And I wait for 7000 milliseconds
    Then I verify Plan container for year "2023" against the DB on the CoCo dashboard
      #  No Plans on account
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "1902057599" "8276338600" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    And I select year "2024" from Manage Plan container on Individual dashboard
    And I select year "2023" from Manage Plan container on Individual dashboard
    And I select year "2022" from Manage Plan container on Individual dashboard
      #  Past Plans on account
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5720167020" "9013863081" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    And I verify Plan container with no active plan on the Individual dashboard
    And I select year "2024" from Manage Plan container on Individual dashboard
    And I verify Plan container with no active plan on the Individual dashboard
    And I select year "2023" from Manage Plan container on Individual dashboard
    And I verify Plan container with no active plan on the Individual dashboard
    And I select year "2022" from Manage Plan container on Individual dashboard