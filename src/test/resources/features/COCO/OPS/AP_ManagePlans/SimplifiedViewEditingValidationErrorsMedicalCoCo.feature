@OPS @SLCR-772 @managelan @COCO
Feature: Manage Plans:Simplified View Editing Validation Errors Medical only CoCo [CCRT-462]
  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "8313683700" "8248218600" to search user
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
      | 1:01012021 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Financial Start date of member
      | 1:01012021 |
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
      | 2:01012021 |
    Then I verify it displays coverage end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the financial end date
      | 2:01012022 |
    Then I verify it displays financial end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    # updates for APTC/SES values to check error messages
    Then I update the APTC value for
      | 1:876890 |
    And I wait for 2000 milliseconds
    And I click Save Button Medical
    Then I wait for 3000 milliseconds
    Then I should see the Invalid monetary amount for SES error for
      | member | aptc   |
      | 1      | 8768.90  |
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I update the APTC value for
      | 2:109040 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for SES error for
      | member | aptc   |
      | 2      | 1090.40  |
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I update the APTC value for
      | 2:87693 |
    And I click Save Button Medical
    And I validate SES entered exceeds EHB amount error is displaying for
