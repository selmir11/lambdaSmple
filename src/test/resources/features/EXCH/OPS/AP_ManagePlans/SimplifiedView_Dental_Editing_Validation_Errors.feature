@OPS @Exch @manageplans
Feature: Manage Plans:Simplified View Editing Validation Errors (Dental)
  @SLER-2256
  Scenario: SLER-2256 Dental plan year - 2023
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I wait for 500 milliseconds
    Then I enter an accountId in any Env "1303017415" "2110007768" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
  #  Dental policy plan date errors validation
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
      | 1:01012021 |
    Then I verify it displays coverage start date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the Financial Start date of member
      | 1:01012021 |
    Then I verify it displays financial start date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the coverage end date
      | 1:01012017 |
    Then I verify it displays coverage end date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the financial end date
      | 1:01011990 |
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
    And I update the coverage end date
      | 2:01012021 |
    Then I verify it displays coverage end date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    And I update the financial end date
      | 2:01012022 |
    Then I verify it displays financial end date error
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    # updates for APTC values to check error messages
    Then I update the APTC value for
      | 1:876890 |
    And I wait for 2000 milliseconds
    And I click Save Button Dental
    Then I wait for 3000 milliseconds
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 8768.90  |
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:109040 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 1090.40  |
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:87693 |
    And I click Save Button Dental
    Then I validate the expected "APTC entered exceeds EHB amount: $27.85" message is displayed
    And I click Reset Changes Dental
    And I logout from Admin Portal
  @SLER-2256
  Scenario: SLER-2256 MP: Previous year 2021 Editing Validation Errors (Dent Only)
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I wait for 500 milliseconds
    Then I enter an accountId in any Env "5830106510" "2110007768" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2021" plan year on manage plan
    Then I click on Medical button to display only Dental view
    And I click Make Changes Dental button
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
      | 1:5000 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 50.00 |
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 1:8000 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 80.00 |
    Then I validate the expected "APTC entered exceeds EHB amount: $16" message is displayed
    And I click Reset Changes Dental
    And I logout from Admin Portal