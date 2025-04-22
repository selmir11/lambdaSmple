@OPS @SLER-2434 @managePlan
Feature: Manage Plans:Simplified View Editable Fields Med, Dent, and Both

  Scenario: Manage Plans:Simplified View Editable Fields Med, Dent, and Both(RT-2548)
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "2214004770" "2110007768" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate title and labels on Manage page
    And I check default year displays
    Then I verify Years in dropdown starting from "2021" as expected
    And I select the plan year based on the running environment
    Then I validate buttons displayed on Manage page
    Then I select the 1 "Medical" policy Plan
    And I click Make Changes Medical button
    Then I verify field "coverage start date" is editable for 1 member on manage plan
    And I update the Coverage Start date of member
      |1:01072023|
    Then I verify field "coverage end date" is editable for 1 member on manage plan
    And I update the coverage end date
      |1:03112023|
    And I update the Coverage Start date of member
      |1:01102023|
    Then I verify field "termination reason" is editable for 1 member on manage plan
    And I update the Termination Reason value
      |1:Non_Payment|
    Then I verify field "financial start date" is editable for 1 member on manage plan
    And I update the Financial Start date of member
      |1:03312023|
    Then I verify field "financial end date" is editable for 1 member on manage plan
    And I update the financial end date
      |1:10312023|
    And I update the Financial Start date of member
      |1:04302023|
    Then I verify field "premium" is editable for 1 member on manage plan
    Then I update the premium value for
      | 1:750.55 |
    Then I verify field "APTC" is editable for 1 member on manage plan
    Then I update the APTC value for
      | 1:900.00 |
    And I click Reset Changes Medical
    Then I select the 1 "Dental" policy Plan
    And I click Make Changes Dental button
    Then I verify field "coverage start date" is editable for 1 member on manage plan
    And I update the Coverage Start date of member
      |1:01072023|
    Then I verify field "coverage end date" is editable for 1 member on manage plan
    And I update the coverage end date
      |1:03112023|
    And I update the Coverage Start date of member
      |1:01102023|
    Then I verify field "termination reason" is editable for 1 member on manage plan
    And I update the Termination Reason value
      |1:Non_Payment|
    Then I verify field "financial start date" is editable for 1 member on manage plan
    And I update the Financial Start date of member
      |1:03312023|
    Then I verify field "financial end date" is editable for 1 member on manage plan
    And I update the financial end date
      |1:10312023|
    And I update the Financial Start date of member
      |1:04302023|
    Then I verify field "premium" is editable for 1 member on manage plan
    Then I update the premium value for
      | 1:750.55 |
    Then I verify field "APTC" is editable for 1 member on manage plan
    Then I update the APTC value for
      | 1:900.00 |
    And I click Reset Changes Dental
    And I logout from Admin Portal