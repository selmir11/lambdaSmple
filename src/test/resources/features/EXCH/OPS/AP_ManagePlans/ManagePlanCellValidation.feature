@OPS @Exch @manageplans
Feature: Manage plan Cell Validation

  @SLER-2473
  Scenario:Manage plan Cell Validation
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I wait for 500 milliseconds
    Then I enter an accountId in any Env "9099864039" "4006144055" to search user
    And I click on Search button in AP dashboard page
    Then I wait for 500 milliseconds
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate title and labels on Manage page
    And I check default year displays
    And I select the "2022" plan year on manage plan
    Then I wait for 500 milliseconds
    Then I validate the no previous financial period medical on manage plan
    Then I validate the no previous financial period dental on manage plan
    And I check plan name: "Bronze Classic- PCP Saver Rx Copay (Choice)" "Policy Coverage: 01/01/2022 to 12/31/2022" "11/19/2021" or plan name: "Bronze 8700 Limited" "Policy Coverage: 01/01/2022 to 12/31/2022" "12/10/2021"
    And I check dental plan name: "Cigna Dental Pediatric" "Policy Coverage: 01/01/2022 to 12/31/2022" "11/19/2021" or plan name: "Delta Dental of Colorado Plains Plan" "Policy Coverage: 01/01/2022 to 12/31/2022" "12/10/2021"
    And I validate "Medical" financial table data on Simplified View "1", "01/01/2022", "12/31/2022", "$292.53", "$0.00" or "1", "01/01/2022", "12/31/2022", "$284.16", "$215.98"
    And I validate Dental financial table data on Simplified View "1", "01/01/2022", "12/31/2022", "$4,333.32", "$0.00" or "1", "01/01/2022", "12/31/2022", "$13.00", "$1.00"
    Then I click Make Changes Medical button
    When I update the APTC value for
      | 1:99999 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 999.99 |
    And I update the Coverage Start date of member
      | 1:01012025 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical
    And I wait for 200 milliseconds
    And I click Make Changes Medical button
    And I update the Financial Start date of member
      | 1:01012025 |
    Then I verify it displays financial start date error
    And I click Reset Changes Medical
    And I wait for 200 milliseconds
    And I click Make Changes Medical button
    And I update the financial end date
      | 1:01012027 |
    Then I verify it displays financial end date error
    And I click Reset Changes Medical
    And I wait for 200 milliseconds
    And I click Make Changes Medical button
    And I update the coverage end date
      | 1:01012027 |
    Then I verify it displays coverage end date error
    And I click Reset Changes Medical


#update Dental and trigger error msg


  And I click Make Changes Dental button
  And I update the Coverage Start date of member
    | 1:01012025 |
  Then I verify it displays coverage start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Financial Start date of member
    | 1:01012025 |
  Then I verify it displays financial start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Coverage Start date of member
    | 1:01012023 |
  Then I verify it displays coverage start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Financial Start date of member
    | 1:01012023 |
  Then I verify it displays financial start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the coverage end date
    | 1:01012027 |
  Then I verify it displays coverage end date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the financial end date
    | 1:01012027 |
  Then I verify it displays financial end date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the coverage end date
    | 1:01012019 |
  Then I verify it displays coverage end date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the financial end date
    | 1:01012020 |
  Then I verify it displays financial end date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Coverage Start date of member
    | 1:01012025 |
  Then I verify it displays coverage start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Financial Start date of member
    | 1:01012025 |
  Then I verify it displays financial start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the coverage end date
    | 1:01012023 |
  Then I verify it displays coverage end date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the financial end date
    | 1:01012023 |
  Then I verify it displays financial end date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Coverage Start date of member
    | 1:01012027 |
  Then I verify it displays coverage start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Financial Start date of member
    | 1:01012027 |
  Then I verify it displays financial start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Coverage Start date of member
    | 1:01012023 |
  Then I verify it displays coverage start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Financial Start date of member
    | 1:01012023 |
  Then I verify it displays financial start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the coverage end date
    | 1:01012027 |
  Then I verify it displays coverage end date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the financial end date
    | 1:01012027 |
  Then I verify it displays financial end date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Coverage Start date of member
    | 1:01012025 |
  Then I verify it displays coverage start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  And I update the Financial Start date of member
    | 1:01012025 |
  Then I verify it displays financial start date error
  And I click Reset Changes Dental
  And I click Make Changes Dental button
  When I update the APTC value for
    | 1:99999 |
  And I click Save Button Dental
  Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 999.99 |








