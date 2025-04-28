@OPS
Feature: Manage Plans: Buttons (positive and negative testing)
  Background:
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page

  @SLER-838
  Scenario: Verify user with role for Manage Plans will be able to make changes
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4007126206" "2425005563" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page
    Then I check default year displays
    Then I verify both buttons Medical and Dental is checked
    And I validate Make Changes button displayed for "Both" on Manage page
    Then I click Make Changes Medical button
    And I validate "Save" medical button displays on Manage page
    And I click Reset Changes Medical
    Then I click Make Changes Dental button
    And I validate "Save" dental button displays on Manage page
    And I click Reset Changes Dental
    And logout from Admin Portal
  @SLER-838
  Scenario: Verify user with no role for Manage Plans will be not able make changes
    Then I login as Admin User any environment "adminPortalSEReport_UN_STG" password "adminPortalSEReport_PW_STG" and "adminPortalSEReport_UN_QA" password "adminPortalSEReport_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4007126206" "2425005563" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page
    Then I check default year displays
    Then I verify both buttons Medical and Dental is checked
    And I validate medical and dental buttons does not display on Manage page
    And I logout from Admin Portal

  @SLER-2420 @OPSRegression
  Scenario: OPS MP Current Med Container verification (order)[RT-2090]
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "8721217600" "9042275003" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    Then I verify admin portal header text in manage plans page
      |Primary Account Holder:|
      |Account ID:|
    Then I verify page texts of select_a_plan_year dropdown
      |2025|
      |2021|
      |2022|
      |2023|
    Then I verify font color etc of web element of empty container
    And I select the "2022" plan year on manage plan
    Then I verify both buttons Medical and Dental is checked
    Then I unchecked "Dental" from plan type
    Then I verify page texts of all labels of "only_medical" plan
      | Latest Application Date: |
      | Financial Start Date:    |
      | EHB Premium:             |
      | Financial End Date:      |
      | CSR Amount:              |
      | Plan Premium:            |
      | Latest LCE and Date:     |
      | Plan APTC:               |
      | Rating Area:             |
      | Premium after Subsidy:   |
      | Service Area:            |
      | Plan AV:                 |
      | HIOS ID:                 |
      | Policy ID:               |
    Then I verify color font size of medical_or_dental plan container
    Then I verify previous_Financial_Periods - Medical_Or_Dental text labels
      | EHB Premium:           |
      | Financial End Date:    |
      | CSR Amount:            |
      | Plan Premium:          |
      | Rating Area:           |
      | Plan APTC:             |
      | Service Area:          |
      | Premium after Subsidy: |
      | Plan AV:               |
      | Financial Start Date:  |
      | HIOS ID:               |
    Then I verify green bar between two financial periods
    Then I verify expand and collapse all financial periods within the Previous Financial Period

  @SLER-2433 @OPSRegression
  Scenario: OPS MP Simplified View Informational Components[RT-2529]
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "2110007768" "5830106510" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    And I select the "2022" plan year on manage plan
    Then I unchecked "Dental" from plan type
    Then I verify page texts of all labels of "only_medical" plan
      | Latest Application Date: |
      | Financial Start Date:    |
      | EHB Premium:             |
      | Financial End Date:      |
      | CSR Amount:              |
      | Plan Premium:            |
      | Latest LCE and Date:     |
      | Plan APTC:               |
      | Rating Area:             |
      | Premium after Subsidy:   |
      | Service Area:            |
      | Plan AV:                 |
      | HIOS ID:                 |
      | Policy ID:               |
    Then I unchecked "Medical" from plan type
    Then I checked "Dental" from plan type
    Then I verify page texts of all labels of "only_dental" plan
      | Latest Application Date: |
      | Financial Start Date:    |
      | EHB Premium:             |
      | Financial End Date:      |
      | CSR Amount:              |
      | Plan Premium:            |
      | Latest LCE and Date:     |
      | Plan APTC:               |
      | Rating Area:             |
      | Premium after Subsidy:   |
      | Service Area:            |
      | Plan AV:                 |
      | HIOS ID:                 |
      | Policy ID:               |
    Then I logout from Admin Portal
    Then I close child window
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env " 4007331033" "6203260386" to search user
    And I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I verify page texts of all labels of "only_medical" plan
      | Latest Application Date: |
      | Financial Start Date:    |
      | EHB Premium:             |
      | Financial End Date:      |
      | CSR Amount:              |
      | Plan Premium:            |
      | Latest LCE and Date:     |
      | Plan SES:                |
      | Rating Area:             |
      | Premium after Subsidy:   |
      | Service Area:            |
      | Plan AV:                 |
      | HIOS ID:                 |
      | Policy ID:               |
    Then I check for Previous Medical container message display

  @SLER-2446 @OPSRegression
  Scenario: OPS MP Previous Dent Container verification (order)[RT-2101]
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "5830336830" "2642003470" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    Then I verify admin portal header text in manage plans page
      |Primary Account Holder:|
      |Account ID:|
    Then I verify page texts of select_a_plan_year dropdown
      |2025|
      |2021|
      |2022|
      |2023|
    And I select the "2022" plan year on manage plan
    Then I verify font color etc of web element of empty container
    And I select the "2023" plan year on manage plan
    Then I unchecked "Medical" from plan type
    Then I verify Previous_Financial_Periods_Dental text color size etc
    Then I verify color border of Previous_Financial_Periods_Dental container and all columns inside container
    Then I verify previous_Financial_Periods - Medical_Or_Dental text labels
      | EHB Premium:           |
      | Financial End Date:    |
      | CSR Amount:            |
      | Plan Premium:          |
      | Rating Area:           |
      | Plan APTC:             |
      | Service Area:          |
      | Premium after Subsidy: |
      | Plan AV:               |
      | Financial Start Date:  |
      | HIOS ID:               |
    Then I verify green bar between two financial periods
    Then I verify expand and collapse all financial periods within the Previous Financial Period
    Then I validate green back ground and white text of "Dental" button only when checked
    Then I validate white back ground and black text of "Medical" button only when unchecked

  @SLER-2453 @OPSRegression
  Scenario: OPS MP Current Dent Container verification (order)s[RT-2099]
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "5830336830" "2642003470" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    Then I verify admin portal header text in manage plans page
      | Primary Account Holder: |
      | Account ID:             |
    Then I verify page texts of select_a_plan_year dropdown
      | 2025 |
      | 2021 |
      | 2022 |
      | 2023 |
    And I select the "2021" plan year on manage plan
    Then I verify font color etc of web element of empty container
    And I select the "2023" plan year on manage plan
    Then I verify both buttons Medical and Dental is checked
    Then I unchecked "Medical" from plan type
    Then I verify color font size of medical_or_dental plan container
    Then I verify plan name and policy coverage dates are visible for "only_dental"
    Then I verify page texts of all labels of "only_dental" plan
      | Latest Application Date: |
      | Financial Start Date:    |
      | EHB Premium:             |
      | Financial End Date:      |
      | CSR Amount:              |
      | Plan Premium:            |
      | Latest LCE and Date:     |
      | Plan APTC:               |
      | Rating Area:             |
      | Premium after Subsidy:   |
      | Service Area:            |
      | Plan AV:                 |
      | HIOS ID:                 |
      | Policy ID:               |
    Then I verify green bar between two financial periods
    Then I verify expand and collapse all financial periods within the Previous Financial Period
    Then I validate green back ground and white text of "Dental" button only when checked
    Then I validate white back ground and black text of "Medical" button only when unchecked
    Then I verify plan name and policy coverage dates are visible for Previous_Financial_Periods medical_or_dental
    Then I verify previous_Financial_Periods - Medical_Or_Dental text labels
      | EHB Premium:           |
      | Financial End Date:    |
      | CSR Amount:            |
      | Plan Premium:          |
      | Rating Area:           |
      | Plan APTC:             |
      | Service Area:          |
      | Premium after Subsidy: |
      | Plan AV:               |
      | Financial Start Date:  |
      | HIOS ID:               |

  @SLER-2448
  Scenario: Verify Editable Fields on manage plan for 2021 and 2022 (med, den) [RT-2186]
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "1300066709" "1502076601" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2021" plan year on manage plan
    Then I wait for 1000 milliseconds
    Then I click Make Changes Medical button
    Then I verify fields are editable on Manage plan for 2 member
    Then I update manage plan editable fields
      |   Env   | Member    | Coverage End   | Coverage Start   |  Termination Reason  | Financial End    | Financial Start   | Premium        | APTC |
      |   qa    |    1      |  07012021      |   07012021       |     Non_Payment      |  07012021        |     07012021      |    250.55      | 25.00 |
      |   qa    |    2      |  07012021      |  07012021        |     No_Reason_Ci     |  07012021        |    07012021       |    200.00      | 25.00 |
      | staging |    1      |  12312021      |   09222021       |     No_Reason        | 12312021         |    09222021       |    150.55      | 10.00 |
      | staging |    2      | 12312021       | 09222021         |     Age_Out          |  12312021        |    09222021       |    100.00      | 10.00 |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I wait for 2000 milliseconds
    And I select the "2021" plan year on manage plan
    Then I wait for 1000 milliseconds
    Then I click Make Changes Dental button
    Then I verify fields are editable on Manage plan for 2 member
    Then I update manage plan editable fields
      |   Env    | Member    | Coverage End   | Coverage Start   |  Termination Reason  | Financial End  | Financial Start  | Premium        | APTC |
      |  qa      |   1       |  12312021      |   09222021       |     No_Reason        | 12312021       |    09222021      |    150.55      | 10.00 |
      |  qa      |   2       | 12312021       |   09222021       |     Age_Out          |  12312021      |    09222021      |    100.00      | 10.00 |
      | staging  |   1       |  01012021      |   01012021       |     No_Reason        | 01012021       |    01012021      |    150.55      | 10.00 |
      | staging  |   2       | 01012021       |    01012021      |     Age_Out          |  01012021      |    01012021      |    100.00      | 10.00 |

    And I click Save Button Dental
    And I select the reason to confirm the changes
    Then I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    Then I enter an "accountID" in any env "5770106760" "2436002372" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2022" plan year on manage plan
    Then I click Make Changes Medical button
    Then I verify fields are editable on Manage plan for 2 member
    Then I update manage plan editable fields
      |  Env     | Member    | Coverage End   | Coverage Start   |  Termination Reason  | Financial End    | Financial Start   | Premium        | APTC |
      |  qa      |   1       |  11182022      |   11182022       |     Non_Payment      |  11182022        |     11182022      |    277.89      | 25.00 |
      |  qa      |   2       |  11182022      |  11182022        |     No_Reason_Ci     |  11182022        |    11182022       |    163.27      | 25.00 |
      | staging  |   1       |  10012022      |   10012022       |     No_Reason        | 10012022         |    10012022       |    150.55      | 0.00 |
      | staging  |   2       | 10012022       | 10012022         |     Age_Out          |  10012022        |    10012022       |    100.00      | 0.00 |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I wait for 1000 milliseconds
    And I select the "2022" plan year on manage plan
    Then I click Make Changes Dental button
    Then I verify fields are editable on Manage plan for 2 member
    Then I update manage plan editable fields
      |   Env     | Member    | Coverage End   | Coverage Start   |  Termination Reason  | Financial End    | Financial Start   | Premium        | APTC |
      |   qa     |    1       |  10012022      |   10012022       |    No_Reason         |  10012022        |     10012022      |    150.55      | 0.00 |
      |   qa     |    2       |  10012022      |  10012022        |    Age_Out           |  10012022        |    10012022       |    100.00      | 0.00 |
      | staging  |    1       |  10012022      |   10012022       |     No_Reason        |  10012022        |    10012022       |    150.55      | 0.00 |
      | staging  |    2       | 10012022       | 10012022         |     Age_Out          |  10012022        |    10012022       |    100.00      | 0.00 |
    And I click Save Button Dental
    And I select the reason to confirm the changes
    Then I close current tab and switch back to previous tab
    Then I logout from Admin Portal


  @SLER-2452
  Scenario: Verify Editable Fields on manage plan for 2023 and 2024 (med, den) [RT-2189]
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5470217690" "9075763090" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2024" plan year on manage plan
    Then I wait for 1000 milliseconds
    Then I click Make Changes Medical button
    Then I verify fields are editable on Manage plan for 2 member
    Then I update manage plan editable fields
      |   Env   | Member    | Coverage End   | Coverage Start   |  Termination Reason  | Financial End    | Financial Start   | Premium        | APTC    |
      |   qa    |    1      |  06022024      |   01012024       |     Age_Out          |   06022024       |     01012024      |    425.73      | 403.88  |
      |   qa    |    2      |  06022024      |   01012024       |     No_Reason        |   06022024       |    01012024       |   271.86       | 0.00    |
      | staging |    1      |  12312024      |   01012024       |     No_Reason        |   12312024       |    01012024       |    291.04      | 0.00    |
      | staging |    2      |  12312024      |   01012024       |     No_Reason        |   12312024       |    01012024       |    179.83      | 0.00    |
    And I click Save Button Medical
    And I click on cancel button on confirm changes popup
    Then I click Reset Changes Medical
    Then I wait for 2000 milliseconds
    And I select the "2024" plan year on manage plan
    Then I wait for 1000 milliseconds
    Then I click Make Changes Dental button
    Then I verify fields are editable on Manage plan for 2 member
    Then I update manage plan editable fields
      |   Env    | Member    | Coverage End   | Coverage Start   |  Termination Reason  | Financial End  | Financial Start  | Premium        | APTC |
      |  qa      |   1       |  12312024      |   01012024       |     No_Reason        | 12312024       |    01012024      |    9.11        | 0.00 |
      |  qa      |   2       |  12312024      |   01012024       |     Age_Out          |  12312024      |    01012024      |    13.84       | 0.00 |
      | staging  |   1       |   12312024     |   01012024       |     No_Reason        |  12312024      |   01012024       |    13.84      | 0.00 |
      | staging  |   2       |   12312024     |   01012024       |     Age_Out          |   12312024     |   01012024       |    22.84      | 0.00 |

    And I click Save Button Dental
    And I click on cancel button on confirm changes popup
    Then I click Reset Changes Dental
    Then I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    Then I enter an "accountID" in any env "9075763090" "5470217690" to search user
    Then I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I click Make Changes Medical button
    Then I verify fields are editable on Manage plan for 2 member
    Then I update manage plan editable fields
      |  Env     | Member    | Coverage End   | Coverage Start   |  Termination Reason  | Financial End    | Financial Start   |  Premium       | APTC   |
      |  qa      |   1       |  12312023      |   01012023       |     Non_Payment      |  12312023        |    01012023       |    396.20      | 297.58 |
      |  qa      |   2       |  12312023      |   01012023       |     No_Reason_Ci     |  12312023        |    01012023       |    256.21      | 0.00   |
      | staging  |   1       |  12312023      |   01012023       |     No_Reason        |  12312023        |   01012023        |    241.12      | 0.00   |
      | staging  |   2       |  12312023      |   04232023       |     Age_Out          |  12312023        |   05012023        |    149.96      | 0.00    |
    And I click Save Button Medical
    And I click on cancel button on confirm changes popup
    Then I click Reset Changes Medical
    Then I wait for 1000 milliseconds
    And I select the "2023" plan year on manage plan
    Then I click Make Changes Dental button
    Then I verify fields are editable on Manage plan for 2 member
    Then I update manage plan editable fields
      |   Env     | Member     | Coverage End   | Coverage Start   |  Termination Reason  | Financial End    | Financial Start   | Premium        | APTC  |
      |   qa      |    1       | 12312023       |   01012023       |    No_Reason         | 12312023         |   01012023        |    9.11        | 0.00  |
      |   qa      |    2       | 12312023       |   01012023       |    Age_Out           |  12312023        |   01012023        |    13.84       | 0.00  |
      | staging   |   1        |  12312023      |   01012023       |     No_Reason        |  12312023        |   01012023        |    13.84       | 0.00  |
      | staging   |   2        |  12312023      |   04232023       |     Age_Out          |  12312023        |   05012023        |    22.84       | 0.00  |
    And I click Save Button Dental
    And I click on cancel button on confirm changes popup
    Then I click Reset Changes Dental
    Then I close current tab and switch back to previous tab
    Then I logout from Admin Portal


  @SLER-980
  Scenario: SLER-980 Edit Button Showing 2023
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
#    Both 2023
    Then I enter an accountId in any Env "1003067571" "1000016976" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I validate Make Changes button displayed for "Both" on Manage page
#  Med Only 2023
    And I close current tab and switch back to previous tab
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "1100010578" "1205056702" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I validate Make Changes button displayed for "Medical" on Manage page
#  Dent Only 2023
    And I close current tab and switch back to previous tab
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "2697005072" "3009308680" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I validate Make Changes button displayed for "Dental" on Manage page
#  Termed Both 2023
    And I close current tab and switch back to previous tab
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "1203027527" "1004096817" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I validate Make Changes button displayed for "Both" on Manage page
#  Termed Med Only 2023
    And I close current tab and switch back to previous tab
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "1100010578" "1102046838" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I validate Make Changes button displayed for "Medical" on Manage page
#  Termed Dent Only 2023
    And I close current tab and switch back to previous tab
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "2502000970" "7663211009" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I validate Make Changes button displayed for "Dental" on Manage page
#  No 2023
    And I close current tab and switch back to previous tab
    And I click Go Back on admin portal program manager dashboard
    When I click on reset button on admin portal search page
    Then I enter an accountId in any Env "1103027791" "6409150727" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I validate Make Changes button displayed for "Neither" on Manage page

    Then I close current tab and switch back to previous tab
    Then I logout from Admin Portal