@OPS @Exchmanageplans
Feature: Manage Plans:Editing Validation Errors(Medical and Dental)

  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page

  @SLER-1201
  Scenario: SLER-1201 Manage plan 2024
    Then I enter an accountId in any Env "9005970041" "2678007169" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
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
      | 1:42116 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 421.16 |
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    When I update the APTC value for
      | 2:79584 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 795.84 |
    And I validate APTC entered exceeds EHB amount error is displaying for "medical"
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    When I update the APTC value for
      | 2:1044589 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc    |
      | 2      | 1044.58 |
    And I click Save Button Medical
    And I validate APTC entered exceeds EHB amount error is displaying for "medical"
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    When I update the APTC value for
      | 2:80000 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 800.00 |
    And I click Save Button Medical
    And I validate APTC entered exceeds EHB amount error is displaying for "medical"
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    When I update the APTC value for
      | 2:900000 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc    |
      | 2      | 9000.00 |
    And I click Save Button Medical
    And I validate APTC entered exceeds EHB amount error is displaying for "medical"
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
      | 1:300000 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc    |
      | 1      | 3000.00 |
    And I validate APTC entered exceeds EHB amount error is displaying for "dental"
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:57165 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 571.65 |
    And I validate APTC entered exceeds EHB amount error is displaying for "dental"
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:87090 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 870.90 |

  @SLER-1234
  Scenario: MP:2024 Editing Validation Errors (Med Only)
    Then I enter an accountId in any Env "9005970041" "2678007169" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2024" plan year on manage plan
    Then I click on Dental button to display only medical view
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
    Then I update the APTC value for
      | 1:87689 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 1      | 876.89 |
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I update the APTC value for
      | 2:109040 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc    |
      | 2      | 1090.40 |
    And I validate APTC entered exceeds EHB amount error is displaying for "medical"
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I update the APTC value for
      | 2:500000 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc    |
      | 2      | 5000.00 |
    And I validate APTC entered exceeds EHB amount error is displaying for "medical"
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I update the APTC value for
      | 2:79876 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 798.76 |
    And I validate APTC entered exceeds EHB amount error is displaying for "medical"
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I update the APTC value for
      | 2:57580 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 575.80 |
    And I validate APTC entered exceeds EHB amount error is displaying for "medical"


  @SLER-1234
  Scenario: SLER-1234 MP: 2024 Editing Validation Errors (Dent Only)
    Then I enter an accountId in any Env "9005970041" "2678007169" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2024" plan year on manage plan
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
      | member | aptc  |
      | 1      | 27.16 |
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 1:5000 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc  |
      | 1      | 50.00 |
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:71160 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc   |
      | 2      | 711.60 |
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
      | member | aptc    |
      | 1      | 9000.00 |
    And I validate APTC entered exceeds EHB amount error is displaying for "dental"
    And I click Reset Changes Dental
    And I click Make Changes Dental button
    Then I update the APTC value for
      | 2:2000 |
    And I click Save Button Dental
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc  |
      | 2      | 20.00 |

  @SLER-2255
  Scenario:SLER-2255: OPS MP Simplified View Editing Validation Errors for Medical Only[RT-2549]
    Then I enter an accountId in any Env "2214004770" "2110007768" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I select a plan year from drop down in any environment "2023" "2022"
    And I unchecked "Dental" from plan type

    #Coverage start date error
    And I click Make Changes Medical button
    And I update the Coverage Start date of member
      | 1:01012020 |
    And I click Save Button Medical
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Coverage Start date of member
      | 1:01012027 |
    And I click Save Button Medical
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I edit "coverage_start_date" to blank for first row
    And I click Save Button Medical
    Then I verify it displays coverage start date error
    And I click Reset Changes Medical

    #Coverage end date error
    And I click Make Changes Medical button
    And I update the coverage end date
      | 1:01012021 |
    And I click Save Button Medical
    Then I verify it displays coverage end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the coverage end date
      | 1:01012028 |
    And I click Save Button Medical
    Then I verify it displays coverage end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the coverage end date
      | 1:02292022 |
    And I click Save Button Medical
    Then I verify it displays coverage end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I edit "coverage_end_date" to blank for first row
    And I click Save Button Medical
    Then I verify it displays coverage end date error
    And I click Reset Changes Medical

    #Financial start date error
    And I click Make Changes Medical button
    And I update the Financial Start date of member
      | 1:01012018 |
    And I click Save Button Medical
    Then I verify it displays financial start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the Financial Start date of member
      | 1:01012030 |
    And I click Save Button Medical
    Then I verify it displays financial start date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I edit "financial_start_date" to blank for first row
    And I click Save Button Medical
    Then I verify it displays financial start date error
    And I click Reset Changes Medical

    #Financial end date error
    And I click Make Changes Medical button
    And I update the financial end date
      | 1:01012018 |
    And I click Save Button Medical
    Then I verify it displays financial end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    And I update the financial end date
      | 1:01012030 |
    And I click Save Button Medical
    Then I verify it displays financial end date error
    And I click Reset Changes Medical
    And I click Make Changes Medical button
    Then I edit "financial_end_date" to blank for first row
    And I click Save Button Medical
    Then I verify it displays financial end date error
    And I click Reset Changes Medical

    #APTC error
    And I click Make Changes Medical button
    When I update the APTC value for
      | 1:130000 |
    And I click Save Button Medical
    Then I should see the Invalid monetary amount for APTC error for
      | member | aptc    |
      | 1      | 1300.00 |
    Then I validate APTC error "APTC entered exceeds EHB amount" for medical
    And I click Reset Changes Medical

    #Validate All errors
    And I click Make Changes Medical button
    Then I edit "coverage_start_date" to blank for first row
    Then I edit "coverage_end_date" to blank for first row
    Then I edit "financial_start_date" to blank for first row
    Then I edit "financial_end_date" to blank for first row
    And I update the Coverage Start date of member
      | 2:01012020 |
    And I update the coverage end date
      | 2:01012020 |
    And I update the Financial Start date of member
      | 2:01012020 |
    And I update the financial end date
      | 2:01012020 |
    Then I validate all the errors displayed on the policies Page
      | The coverage start date must be entered within the selected plan year and can not be after the coverage end date.      |
      | The coverage end date must be entered within the selected plan year and can not be prior to the coverage start date.   |
      | The coverage start date must be entered within the selected plan year and can not be after the coverage end date.      |
      | The coverage end date must be entered within the selected plan year and can not be prior to the coverage start date.   |
      | The financial start date must be entered within the selected plan year and can not be after the financial end date.    |
      | The financial end date must be entered within the selected plan year and can not be prior to the financial start date. |
      | The financial start date must be entered within the selected plan year and can not be after the financial end date.    |
      | The financial end date must be entered within the selected plan year and can not be prior to the financial start date. |
    And I click Reset Changes Medical
