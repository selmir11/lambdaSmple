@OPS @COCO @ManagePlansCoco
Feature: Manage Plans CoCo Policy Dropdown Arrow [CCRT-231]
  @SLCR-778
  Scenario:SLCR-778 CoCo Policy Dropdown Arrow
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "6809490767" "7657397009" to search user
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
    And I select the "2021" plan year on manage plan
    Then I validate "Select a plan year to view policies" message is displayed
    And I select the "2022" plan year on manage plan
    Then I validate "Select a plan year to view policies" message is displayed
    And I select the "2023" plan year on manage plan
    Then I validate "Select a plan year to view policies" message is displayed
    And I select the "2025" plan year on manage plan
    Then I validate "Select a plan year to view policies" message is displayed
    And I select the "2024" plan year on manage plan
    Then I select the 1 "Medical" policy Plan
    And I select Plans Med Active Policy
    Then I click Go Back button on Manage Plan page
    And I logout from Admin Portal
  @SLCR-778
  Scenario:SLCR-778 CoCo Policy Dropdown Arrow - multiple policies
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "1203027641" "5880566210" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2024" plan year on manage plan
    Then I select the 1 "Medical" policy Plan
    And I select Plans Med Active Policy
    Then I verify Plan ID data with plan selected "4000672200" "4000672200 - 03/15/2024 - apelizaagip" and "1303000032" "1303000032 - 01/03/2024 - apelizajfvn"
    Then I click Go Back button on Manage Plan page
  #  And I logout from Admin Portal

    

