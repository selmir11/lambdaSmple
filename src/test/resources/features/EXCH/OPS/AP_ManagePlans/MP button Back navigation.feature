@OPS @Exchmanageplans
Feature: Manage Plans: Button Go Back navigation
  Scenario:Manage plan 2022 Go Back navigation
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "2163002375" "3419108680" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I check default year displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I check default year displays
    And I select the "2022" plan year on manage plan
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    And I validate Make Changes button displayed for "Both" on Manage page
    Then I validate the "Policy" text of "Both" plan summary container on Manage Plans
    Then I validate Go Back button on Manage Plan page
    And I click Go Back button on Manage Plan page
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I check default year displays
    And I select the "2022" plan year on manage plan
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    And I validate Make Changes button displayed for "Both" on Manage page
    Then I unchecked "Dental" from plan type
    And I validate I am on the "Manage Plans" page
    Then I validate Go Back button on Manage Plan page
    And I click Go Back button on Manage Plan page
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    And I check default year displays
    And I select the "2022" plan year on manage plan
    And I validate I am on the "Manage Plans" page
    And I validate Make Changes button displayed for "Both" on Manage page
    And I wait for 300 milliseconds
    Then I unchecked "Medical" from plan type
    And I validate I am on the "Manage Plans" page
    Then I validate Go Back button on Manage Plan page
    And I click Go Back button on Manage Plan page
    And I validate I am on the "Admin Portal individual dashboard" page
    And I logout from Admin Portal

  Scenario:Manage plan 2023 Go Back navigation from Simple View MP page
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1303017415" "2110007768" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I check default year displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I wait for 300 milliseconds
    And I check default year displays
    And I select the "2023" plan year on manage plan
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    And I validate Make Changes button displayed for "Both" on Manage page
    Then I check current Simplified Medical container labels
    Then I click Go Back button on Simplified View
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    And I check default year displays
    And I select the "2023" plan year on manage plan
    And I wait for 500 milliseconds
    And I validate I am on the "Manage Plans" page
    Then I unchecked "Dental" from plan type
    And I validate I am on the "Manage Plans" page
    Then I click Go Back button on Simplified View
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I wait for 300 milliseconds
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I wait for 500 milliseconds
    And I validate I am on the "Manage Plans" page
    And I wait for 300 milliseconds
    Then I unchecked "Medical" from plan type
    And I validate I am on the "Manage Plans" page
    Then I click Go Back button on Simplified View
    And I validate I am on the "Admin Portal individual dashboard" page
    And I logout from Admin Portal



