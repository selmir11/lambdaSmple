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
    |1:01012023|
    |2:01012023|
  Then I verify field "coverage start date" is editable for 2 member on manage plan
  And I update the Coverage Start date of member
    |1:01012023|
    |2:01012023|
  Then I verify field "termination reason" is editable for 2 member on manage plan
  And I update the Termination Reason value
    |1:Non_Payment|
    |2:No_Reason_Ci|
  Then I verify field "financial end date" is editable for 2 member on manage plan
  And I update the financial end date
    |1:01012023|
    |2:01012023|
  Then I verify field "financial start date" is editable for 2 member on manage plan
  And I update the Financial Start date of member
    |1:01012023|
    |2:01012023|
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

  @SLCR-916
  Scenario:COCO Manage Plan - Verify Previous Med Container [CCRT-255]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "9025379033" "6501370386" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I validate previous financial year style properties on manage plan
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
    And I verify label on Previous Financial Period Medical Plan container
      | EHB Premium:             |
      | Financial End Date:      |
      | CSR Amount:              |
      | Plan Premium:            |
      | Rating Area:             |
      | Plan APTC:               |
      | Service Area:            |
      | Premium after Subsidy:   |
      | Plan AV:                 |
      | Financial Start Date:    |
      | HIOS ID:                 |
      | Policy ID:               |
    Then I verify green bar for more financial period
    Then I verify expand and collapse all financial periods within the Previous Financial Period
    Then I close current tab and switch back to previous tab
    Then I logout from Admin Portal

  @SLCR-926 @OPSRegression
  Scenario: Verify Error message on manage plan field update for medical [CCRT-342]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "4007816232" "9091861032" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2023" plan year on manage plan
    Then I wait for 1000 milliseconds
    Then I click Make Changes Medical button
    Then I update the "premium" value using copy paste
      |  Env     | Member    |    Value      |
      |  qa      |   1       |  $44444.44    |
      | staging  |   1       |  $44444.44    |
    And I click Save Button Medical
    Then I validate Invalid monetary amount for Premium error is displaying
    Then I validate error message in Red color for date fields
      | Invalid monetary amount for Premium: $44444.44    |
    Then I click Reset Changes Medical
    Then I verify premium field is Non editable on Manage plan
    Then I verify "premium" values not changed on manage plan
      |  Env     | Member    |    Value      |
      |  qa      |   1       |  $337.34      |
      | staging  |   1       |  $391.65      |
    Then I click Make Changes Medical button
    Then I update the "SES" value using copy paste
      |  Env     | Member    |    Value      |
      |  qa      |   1       |  $44444.44    |
      | staging  |   1       |  $99999.44    |
    And I click Save Button Medical
    Then I validate SES error message in Red color with value
       | Env       |           Invalid Message                       |            SES exceed Message              |
       | qa        |   Invalid monetary amount for SES: $44444.44    |  SES entered exceeds SES amount: $337.34   |
       | staging   |   Invalid monetary amount for SES: $99999.44    |  SES entered exceeds SES amount: $778.33   |
    Then I click Reset Changes Medical
    Then I verify SES field is Non editable on Manage plan
    Then I verify "SES" values not changed on manage plan
      |  Env     | Member    |    Value      |
      |  qa      |   1       |  $337.34      |
      | staging  |   1       |  $0.00        |
      | staging  |   2       |  $386.68      |
    Then I click Make Changes Medical button
    Then I update the Coverage Start date of member
      | 1:01/04/2032 |
    And I click Save Button Medical
    Then I validate error message in Red color for date fields
      |The coverage start date must be entered within the selected plan year and can not be after the coverage end date.|
    Then I click Reset Changes Medical
    Then I verify coverage start field is Non editable on Manage plan
    Then I verify "coverage start date" values not changed on manage plan
      |  Env     | Member    |    Value      |
      |  qa      |   1       | 01/01/2023    |
      | staging  |   1       |  01/01/2023   |
      | staging  |   2       |  01/01/2023   |
    Then I click Make Changes Medical button
    Then I update the coverage end date
      | 1:01/01/4444 |
    And I click Save Button Medical
    Then I validate error message in Red color for date fields
      |The coverage end date must be entered within the selected plan year and can not be prior to the coverage start date.|
    Then I click Reset Changes Medical
    Then I verify coverage end date is Non editable on Manage plan
    Then I verify "coverage end date" values not changed on manage plan
      |  Env     | Member    |    Value      |
      |  qa      |   1       | 12/31/2023    |
      | staging  |   1       |  12/31/2023   |
      | staging  |   2       |  12/31/2023   |
    Then I click Make Changes Medical button
    Then I update the Financial Start date of member
      | 1:01/01/2033 |
    And I click Save Button Medical
    Then I validate error message in Red color for date fields
    | The financial start date must be entered within the selected plan year and can not be after the financial end date.|
    Then I click Reset Changes Medical
    Then I verify financial start field is Non editable on Manage plan
    Then I verify "financial start date" values not changed on manage plan
      |  Env     | Member    |    Value       |
      |  qa      |   1       | 01/01/2023     |
      | staging  |   1       |  01/01/2023    |
      | staging  |   2       |   01/01/2023   |
    Then I click Make Changes Medical button
    Then I update the financial end date
      | 1:02/01/2034 |
    And I click Save Button Medical
    Then I validate error message in Red color for date fields
      |The financial end date must be entered within the selected plan year and can not be prior to the financial start date.|
    Then I click Reset Changes Medical
    Then I verify financial end date field is Non editable on Manage plan
    Then I verify "financial end date" values not changed on manage plan
      |  Env     | Member    |    Value      |
      |  qa      |   1       | 12/31/2023    |
      | staging  |   1       | 12/31/2023    |
      | staging  |   2       |  12/31/2023   |
    Then I close current tab and switch back to previous tab
    Then I logout from Admin Portal

