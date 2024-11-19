@OPS @SLER-1201
# OPEN bugs for commented steps OPS-6265
Feature: Manage Plans:Editing Validation Errors(Medical and Dental)
  Scenario: SLER-1201 Manage plan 2024
    Given I open the login page on the "admin" portal
  And I validate I am on the "Login" page
  Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
  And I validate I am on the "Admin Portal search" page
  Then I enter an accountId in any Env "9005970041" "2678007169" to search user
  And I click on Search button in AP dashboard page
  And I click acct first row from Search Results table in admin portal
  And I validate I am on the "Admin Portal individual dashboard" page
  Then I verify Primary account holder and account number displays
  Then I click on "Manage Plans" user dashboard button
  And I validate I am on the "Manage Plans" page
  Then I validate title and labels on Manage page
  And I check default year displays
  And I select the "2024" plan year on manage plan
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
      | 1:01012023 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Financial Start date of member
      | 1:01012023 |
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
      | 2:01012023 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Financial Start date of member
      | 2:01012023 |
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

#   APTC errors
    When I update the APTC value for
      | 1:400.16 |
    When I update the APTC value for
      | 2:571.84 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 400.16 |
    When I update the APTC value for
      | 1:400.16 |
    When I update the APTC value for
      | 2:571.84 |
    And I click Save Button Medical
    And I validate APTC entered exceeds EHB amount error is displaying for "medical"
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    When I update the APTC value for
      | 2:10445.16 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 1044.51 |
    And I click Save Button Medical
    And I validate APTC entered exceeds EHB amount error is displaying for "medical"
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I update the APTC value for
      | 1:blank |
      | 2:blank |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      |         |
      | 2      |         |
    Then I update the premium value for
      | 1:00.00 |
      | 2:00.00 |
#    And I click Save Button Medical
#    And I validate Invalid monetary amount for Premium error is displaying - OPS-6265
    And I click Reset Changes Medical

#  Dental policy date errors validation
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
   Then I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the coverage end date
      | 1:01012019 |
    Then I verify it displays coverage end date error
    Then I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the financial end date
      | 1:01012020 |
    Then I verify it displays financial end date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the Coverage Start date of member
      | 2:01012025 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the Financial Start date of member
      | 2:01012025 |
    Then I verify it displays financial start date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the coverage end date
      | 2:01012023 |
    Then I verify it displays coverage end date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the financial end date
      | 2:01012023 |
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
      | 2:01012027 |
    Then I verify it displays coverage end date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the financial end date
      | 2:01012027 |
    Then I verify it displays financial end date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the Coverage Start date of member
      | 2:01012025 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the Financial Start date of member
      | 2:01012025 |
    Then I verify it displays financial start date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button

#    Dental policy aptc errors validation
    Then I update the APTC value for
      | 1:3000.00 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 3000.00 |
    And I validate APTC entered exceeds EHB amount error is displaying for "dental"
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:71.16 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 71.16  |
    And I validate APTC entered exceeds EHB amount error is displaying for "dental"
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 1: blank |
      | 2: blank |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      |         |
      | 2      |         |
    And I click Reset Changes Dental
    And I click Make Changes Dental button

#    premium amount error validation OPS 6265
    Then I update the premium value for
      | 1:blank |
      | 2:blank |
#    And I click Save Button Dental
##    And I validate Invalid monetary amount for Premium error is displaying - OPS-6265