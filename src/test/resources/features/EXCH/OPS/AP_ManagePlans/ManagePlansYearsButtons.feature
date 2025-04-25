@OPS
Feature: Manage Plans: Buttons (positive and negative testing) 
  @SLER-838
  Scenario: Verify user with role for Manage Plans will be able to make changes
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
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
    And I validate buttons displayed on Manage page
    Then I click Make Changes Medical button
    And I validate "Save" medical button displays on Manage page
    And I click Reset Changes Medical
    Then I click Make Changes Dental button
    And I validate "Save" dental button displays on Manage page
    And I click Reset Changes Dental
    And logout from Admin Portal
  @SLER-838
  Scenario: Verify user with no role for Manage Plans will be not able make changes
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
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
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
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
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
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

  @SLCR-918 @OPSRegression
  Scenario: OPS CoCo MP Simplified View Table Information[CCRT-452]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "7739739003" "8163138600" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I select policy plan "01/01/2023" from select_a_policy dd by visible text
    Then I verify medical_plan text available in red color
    Then I verify one container for Medical plans displayed instead of Current and Previous sections
    Then I verify member two shows twice in CoverageDetails and FinancialDetails tables

  @SLER-2446 @OPSRegression
  Scenario: OPS MP Previous Dent Container verification (order)[RT-2101]
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
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
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
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

  @SLCR-725 @OPSRegression
  Scenario: OPS CoCo MP Simplified View Informational Components[CCRT-436]
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "8313683700" "8920958600" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I verify plan name and policy coverage dates are visible for "only_medical"
    Then I verify medical_plan text available in red color
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

  @SLCR-776 @OPSRegression
  Scenario: OPS CoCo MP Simplified View Editable Fields for all member Medical[CCRT-461]
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "8313683700" "8920958600" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I click Make Changes Medical button
    Then I verify edit "coverage_start_date" with value "01102023" for all members
    Then I verify edit "coverage_end_date" with value "12302023" for all members
    Then I verify edit "financial_start_date" with value "01102023" for all members
    Then I verify edit "financial_end_date" with value "12302023" for all members
    Then I verify edit "Premium" with value "9006" for all members
    Then I verify edit "SES" with value "9007" for all members
    And I click Reset Changes Medical
    Then I click Make Changes Medical button
    Then I verify options are getting selected from termination reason drop down for all members
    And I click Reset Changes Medical
