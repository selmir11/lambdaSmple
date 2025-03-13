@OPS
Feature: Manage Plans:Simplified View Editing Validation Errors (Dental)
  @SLER-2256
  Scenario: SLER-2256 Dental plan current year - 2025
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1303017415" "2110007768" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
   # And I select the "2025" plan year on manage plan
   # And I click Make Changes Dental button
#  Dental policy current year plan date errors validation
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
      | 1:300000 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 3000.00 |
    And I validate APTC entered exceeds EHB amount error is displaying for "dental"
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:57165 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 571.65  |
    And I validate APTC entered exceeds EHB amount error is displaying for "dental"
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:87090 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 870.90  |


  @SLER-2256
  Scenario: SLER-2256 MP: Previous year 2022 Editing Validation Errors (Dent Only)
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1303017415" "2110007768" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2022" plan year on manage plan

    Then I click on Medical button to display only Dental view
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
      | 1:2716 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 27.16  |
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 1:5000 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 50.00  |
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:71160 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 711.60  |
    And I validate APTC entered exceeds EHB amount error is displaying for "dental"
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:70060 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 700.60 |
    And I validate APTC entered exceeds EHB amount error is displaying for "dental"
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 1:900000 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 9000.00 |
    And I validate APTC entered exceeds EHB amount error is displaying for "dental"
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:2000 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 20.00 |
