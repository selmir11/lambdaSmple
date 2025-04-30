@OPS @manageplan
Feature: Manage Plans: Buttons (positive and negative testing)
  @SLCR-275
  Scenario: Verify user with role for Manage Plans will be able to make changes
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5720167020" "4006533799" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2024" plan year on manage plan
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page Coco account
#    Then I check default year displays
    And I verify Medical button checked
    And I validate buttons displayed on CoCo Manage page
    Then I click Make Changes Medical button
    And I validate "Save" medical button displays on Manage page
    And I click Reset Changes Medical
    And logout from Admin Portal
  @SLCR-275
  Scenario: Verify user with no role for Manage Plans will be not able make changes
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalSEReport_UN_STG" password "adminPortalSEReport_PW_STG" and "adminPortalSEReport_UN_QA" password "adminPortalSEReport_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5720167020" "4006533799" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    Then I check default year displays
    And I select the "2024" plan year on manage plan
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page Coco account
    And I verify Medical button checked
    And I validate medical and dental buttons does not display on Manage page
    And I logout from Admin Portal


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

  @SLCR-742 @OPSRegression
  Scenario: OPS CoCo IndDash Member Table[CCRT-131]
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "6703170627" "2008008265" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I verify color font format etc for elements of Account Summary container
    |Username|
    |Full Name|
    |Household Members|
    Then I verify height width and color of line under each household members
    Then I click on manage account details button on admin portal Individual dashboard
    Then I validate I am on the "account details" page
    Then I verify font color format of primary account holder label
    Then I verify account id displayed in any Env "6703170627" "2008008265"
    Then I verify account table labels of account detail container
    Then I verify primary account holder name in account detail container
    Then I verify account table field values of account detail container

  @SLCR-942 @OPSRegression
  Scenario: OPS CoCo MP NFA Removing Subscriber from policy[CCRT-353]
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "coco" account creation
    Then I verify account created successfully message displays
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Spouse", "03021995", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Spouse"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I select "Yes" employment option
    And I enter "2000000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Male", and applying "Yes"
    And I enter my residential address "1235 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I select "Yes" employment option
    And I enter "4000000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "Birth" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a OBO signature on the Declarations And Signature Page CoCo
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    And I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    And I click "No" to the Tobacco usage question on start shopping page for "Spouse" coco
    Then I click continue on coco start shopping page
    And I click continue on coco medical grouping page
    Then I validate I am on the "Medical Plan Results" page
    And I select or skip the medical plans for groups on medical plan page
      | Group 1:Cigna Connect Colorado Option Bronze |
    And I select or skip the medical plans for groups on medical plan page
      | Group 2:Cigna Connect Colorado Option Bronze |
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page
    And I close current tab and switch back to previous tab
    And I refresh the page
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    Then I select policy plan "PrimaryMember" from select_a_policy dd by visible text
    Then I click Make Changes Medical button
    And I update the Coverage Start date of member on manage plan page
      | Primary:First Day Of Current Year |
    Then I update the Financial Start date of member on manage plan page
      | Primary:First Day Of Current Year |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I select policy plan "01/01/2025" from select_a_policy dd by visible text
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I validate I am on the "CoCo Welcome" page
    And I click make Changes button on welcome page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Male", and applying "No"
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    And I check "None of these" life change event checkbox
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a OBO signature on the Declarations And Signature Page CoCo
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    And I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    And I click "No" to the Tobacco usage question on start shopping page for "Spouse" coco
    Then I click continue on coco start shopping page
    And I click continue on coco medical grouping page
    Then I validate I am on the "Medical Plan Results" page
