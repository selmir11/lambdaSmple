@OPS @SLER-1185 @managePlan
Feature: Manage Plans:Current Dent Container verification (order)

  Scenario:Manage plan 2022
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "2163002375" "9075763090" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate title and labels on Manage page
    And I check default year displays
    Then I verify Years in dropdown starting from "2021" as expected
    And I select the "2022" plan year on manage plan
    And I validate Make Changes button displayed for "Both" on Manage page

    #both plan MEDICAL AND DENTAL
    And I verify both buttons Medical and Dental is checked
    Then I select the 1 "Medical" policy Plan
    And I select Plans Med Active Policy
    Then I select the 1 "Dental" policy Plan
    And I select Plans Dental Active Policy
    Then I update my account_id any Env STG "2163002375" QA "9075763090"
    Then I wait for 500 milliseconds
    And I update the second medical and dental policy for the year UI
    And I validate the second medical policy for the year "2022" DB
    And I validate the second dental policy for the year "2022" DB

  #Medical Only
    Then I unchecked "Dental" from plan type
    And I select Plans Med Active Policy
    And I validate the second medical policy for the year "2022" DB
    
  #Dental Only
    Then I unchecked "Dental" from plan type
    Then I unchecked "Medical" from plan type
    And I select Plans Dental Active Policy
    And I validate the second dental policy for the year "2022" DB



