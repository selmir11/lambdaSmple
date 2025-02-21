@OPS @SLCR-775 @managePlan
Feature: Manage Plans:Current Medical Container - change policy

  Scenario:Manage plan current year 2025
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
   # Then I enter an accountId in any Env "5020858490" "4006533799" to search user
    Then I enter an accountId in any Env "5020858490" "" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I validate title and labels on Manage page Coco account
    Then I validate blue bar on Manage page
    And I check default year displays
    Then I verify Years in dropdown starting from "2021" as expected
    And I select the "2025" plan year on manage plan
    And I wait for 300 milliseconds

    # plan MEDICAL only
    Then I select the 1 "Medical" policy Plan
    And I select Plans Med Active Policy
    Then I wait for 500 milliseconds
    And I validate the second medical policy for the year "2025" DB

