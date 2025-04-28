@OPS @Exch @manageplans
Feature: Verify Plans Container Ind Dash
  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page

  @SLER-2427
  Scenario: SLER-2427 OPS: MP: Checking Years for Coverage
#    scenarios for Dental only in 2023 QA
    Then I enter an accountId in any Env "1300057292" "8277667600" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I validate title and labels on Manage page for year "2023"
    Then I verify both buttons Medical and Dental is checked
    Then I validate the "No Policy" text of "Medical" plan summary container on Manage Plans
    Then I validate the "Policy" text of "Dental" plan summary container on Manage Plans
    Then I check for Previous Medical container message display
    Then I check for Previous Dental container message display
    And I select the "2021" plan year on manage plan
    And I validate title and labels on Manage page for year "2021"
    Then I validate the "No Policy" text of "Both" plan summary container on Manage Plans
    And I select the "2023" plan year on manage plan
    And I validate title and labels on Manage page for year "2023"
    Then I validate the "No Policy" text of "Medical" plan summary container on Manage Plans
    And I select the "2022" plan year on manage plan
    And I validate title and labels on Manage page for year "2022"
    Then I validate the "Policy" text of "Both" plan summary container on Manage Plans
    And I select the "2023" plan year on manage plan
    And I validate title and labels on Manage page for year "2023"
    Then I validate the "No Policy" text of "Medical" plan summary container on Manage Plans
#    scenarios for Medical only in 2022 QA
    And I close current tab and switch back to previous tab
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "4006732699" "5590756430" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2022" plan year on manage plan
    And I validate title and labels on Manage page for year "2022"
    Then I verify both buttons Medical and Dental is checked
    Then I validate the "Policy" text of "Medical" plan summary container on Manage Plans
    Then I validate the "No Policy" text of "Dental" plan summary container on Manage Plans
    Then I check for Previous Medical container message display
    Then I check for Previous Dental container message display
    And I select the "2021" plan year on manage plan
    And I validate title and labels on Manage page for year "2021"
    Then I validate the "No Policy" text of "Both" plan summary container on Manage Plans
    And I select the "2022" plan year on manage plan
    And I validate title and labels on Manage page for year "2022"
    Then I validate the "No Policy" text of "Dental" plan summary container on Manage Plans
    And I select the "2023" plan year on manage plan
    And I validate title and labels on Manage page for year "2023"
    Then I validate the "Policy" text of "Both" plan summary container on Manage Plans
    And I select the "2022" plan year on manage plan
    And I validate title and labels on Manage page for year "2022"
    Then I validate the "No Policy" text of "Dental" plan summary container on Manage Plans

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal