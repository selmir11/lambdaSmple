@OPS @SLCR-772 @managePlan
Feature: Manage Plans:Simplified View Editing Validation Errors Medical only CoCo [CCRT-240]
  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5230727910" "3315409680" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
  @SLCR-772
  Scenario: MP:2023 Simplified View Editing Validation Errors Med Only
    And I click Make Changes Medical button
    #    Medical Policy error validation
    And I update the Coverage Start date of member
      | 1:01012025 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Financial Start date of member
      | 1:01012025 |
    Then I verify it displays financial start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the coverage end date
      | 1:01012027 |
    Then I verify it displays coverage end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the financial end date
      | 1:01012027 |
    Then I verify it displays financial end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Coverage Start date of member
      | 1:01012024 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Financial Start date of member
      | 1:01012024 |
    Then I verify it displays financial start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the coverage end date
      | 1:01012017 |
    Then I verify it displays coverage end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the financial end date
      | 1:01011990 |
    Then I verify it displays financial end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Coverage Start date of member
      | 2:01012025 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Financial Start date of member
      | 2:01012025 |
    Then I verify it displays financial start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the coverage end date
      | 2:01012027 |
    Then I verify it displays coverage end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the financial end date
      | 2:01012027 |
    Then I verify it displays financial end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Coverage Start date of member
      | 2:01012024 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Financial Start date of member
      | 2:01012024 |
    Then I verify it displays financial start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the coverage end date
      | 2:01012021 |
    Then I verify it displays coverage end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the financial end date
      | 2:01012022 |
    Then I verify it displays financial end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I update the SES value for
      | 1:876.89 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for SES error for
      | member | aptc   |
      | 1      | 876.89  |
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I update the SES value for
      | 2:1090.40 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for SES error for
      | member | aptc   |
      | 2      | 1090.40  |
    And I validate SES entered exceeds EHB amount error is displaying
    Then I update the SES value for
      | 1: blank |
      | 2: blank |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for SES error for
      | member | aptc   |
      | 1      |         |
      | 2      |         |
    Then I close current tab and switch back to previous tab
    And I logout from Admin Portal




