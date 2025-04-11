@OPS @SLCR-775 @managePlan
Feature: Manage Plans:Current Medical Container - change policy [CCRT-232]

  Scenario:Manage plan current year 2025
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5020858490" "" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I validate title and labels on Manage page Coco account
    Then I validate blue bar on Manage page
    And I check default year displays
    Then I verify Years in dropdown starting from "2021" as expected
    And I select the "2025" plan year on manage plan
    And I wait for 300 milliseconds

    # plan MEDICAL only
    Then I select the 1 "Medical" policy Plan
    And I select Plans Med Active Policy
    Then I wait for 500 milliseconds
    And I validate the second medical policy for the year "2025" DB

@SLCR-904
Scenario:COCO Editable Fields on manage plan [CCRT-239]
  Given I open the login page on the "admin" portal
  And I refresh the page
  And I validate I am on the "Login" page
  When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
  And I validate I am on the "Admin search" page
  And I select "coco" checkbox on Admin Portal Dashboard
  Then I enter an accountId in any Env "5230727910" "3315409680" to search user
  And I click on Search button in AP dashboard page
  And I click acct first row from Search Results table in admin portal
  Then I click on "Manage Plans" user dashboard button
  And I validate I am on the "Manage Plans" page
  And I select the "2023" plan year on manage plan
  Then I click Make Changes Medical button
  Then I verify field "coverage end date" is editable for 2 member on manage plan
  And I update the coverage end date
    |1:03302023|
    |2:03302023|
  Then I verify field "coverage start date" is editable for 2 member on manage plan
  And I update the Coverage Start date of member
    |1:01022023|
    |2:01022023|
  Then I verify field "termination reason" is editable for 2 member on manage plan
  And I update the Termination Reason value
    |1:Non_Payment|
    |2:No_Reason_Ci|
  Then I verify field "financial end date" is editable for 2 member on manage plan
  And I update the financial end date
    |1:03302023|
    |2:03302023|
  Then I verify field "financial start date" is editable for 2 member on manage plan
  And I update the Financial Start date of member
    |1:01032023|
    |2:01032023|
  Then I verify field "premium" is editable for 2 member on manage plan
  Then I update the premium value for
    | 1:250.55 |
    | 2:200.00 |
  Then I verify field "APTC" is editable for 2 member on manage plan
  Then I update the APTC value for
    | 1:0.00 |
    | 2:0.00 |
  And I click Save Button Medical
  And I select the reason to confirm the changes
  Then I close current tab and switch back to previous tab
  Then I logout from Admin Portal

  @SLCR-905
  Scenario:COCO Manage Plan - verify label on Informational Component container for med [CCRT-237]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "7767131003" "2302008865" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    And I verify label on Information Component
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
    And I check for Previous Medical container message display
    Then I verify dental plan not available on manage plan
    Then I close current tab and switch back to previous tab
    Then I logout from Admin Portal

  @SLCR-906
  Scenario:COCO Manage Plan - verify label on Informational Component container for med only [CCRT-235]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "4007384519" "5890916640" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2024" plan year on manage plan
    And I verify label on Information Component
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
    And I check for Previous Medical container message display
    Then I close current tab and switch back to previous tab
    Then I logout from Admin Portal

  @SLCR-907
  Scenario:COCO Manage Plan - verify label on Informational Component container for med [CCRT-236]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env " 4007331033" "6203260386" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I validate style properties on manage plan
    Then I validate the "medical" member details table column header and Style on manage plan
      | No.         |
      | Person ID   |
      | Name        |
      | Date of Birth   |
      | Relationship    |
      | Tobacco         |
    Then I validate the "medical" coverage details table column header and Style on manage plan
      | No. |
      | Coverage Start |
      | Coverage End   |
      | Status         |
      | Effectuated    |
      | Termination Reason |
    Then I validate the "medical" financial details table column header and Style on manage plan
      | No. |
      | Financial Start |
      | Financial End   |
      | Premium         |
      | SES             |
    And I verify label on Information Component
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
    And I check for Previous Medical container message display
    Then I verify dental plan not available on manage plan
    Then I close current tab and switch back to previous tab
    Then I logout from Admin Portal