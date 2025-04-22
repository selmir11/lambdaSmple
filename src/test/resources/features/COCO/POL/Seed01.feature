Feature: Regression Tests that require COCO Seed 1

  Background: Seed 01 For COCO- Single Applicant with Income of $19k
    Given I set the test scenario details in coco
      | totalGroups | totalMembers | total_subscribers | total_dependents | total_enrollees |
      | 1           | 1            | 1                 | 0                |  1              |
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Given I set the dynamic policy, coverage and financial dates in coco
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year |
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    And I get the application id from the url from tobacco page coco
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on coco start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I select or skip the medical plans for groups on medical plan page
      | Group 1:Cigna Connect Colorado Option Bronze |
    Then I validate I am on the "planSummaryMedicalDental" page
    And I set medical premium amount
    And I click continue on coco plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page
    And I click on Sign Out in the Header for "Elmo"

    And I validate "SUBMITTED" Medical entities from COCO policy tables
    And I validate Medical entities from COCO pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code |addl_maint_reason  | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
    And I download the medical files from coco sftp server with location "/outboundedi/"
    And I validate the coco ob834 medical file data
    Given I set the dynamic policy, coverage and financial dates in coco
      | PolicyStartDate     | PolicyEndDate       | CoverageStartDate   | CoverageEndDate     | FinancialStartDate  | FinancialEndDate    |
      | First Of Next Month | First Of Next Month | First Of Next Month | First Of Next Month | First Of Next Month | First Of Next Month |


    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin dashboard" page
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    Then I click on "Manage Plans" user dashboard button
    Then I click Make Changes Medical button
    And I update the Coverage Start date of member on manage plan page
      | Primary:First Day Of Current Year |
    And I update the Financial Start date of member on manage plan page
      | Primary:First Day Of Current Year |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I close current tab and switch back to previous tab
    And logout from Admin Portal

    And I validate "CANCELLED" Medical entities from COCO policy tables
    And I validate Medical entities from COCO pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code |addl_maint_reason  | sep_reason  |
      | 024                   | 024                | AI                    | CANCEL            |             |
    And I download the medical files from coco sftp server with location "/outboundedi/"
    And I validate the coco ob834 medical file data
    Given I set the dynamic policy, coverage and financial dates in coco
      | PolicyStartDate           | PolicyEndDate            | CoverageStartDate         | CoverageEndDate          | FinancialStartDate        | FinancialEndDate         |
      | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year |


# DB Validation
    And I validate "SUBMITTED" Medical entities from COCO policy tables
    And I validate Medical entities from COCO pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code |addl_maint_reason  | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
    And I validate the coco ob834 medical file data that present in localPath or coco sftp server "/outboundedi/"
    And I validate the coco ob834 medical file data

    #UI Validation
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I Validate the correct enrolled plans are displayed on coco welcome page
    And I click on "My Plans" link on welcome page
    And I validate enrolled medical plans details on my policies page coco
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-780 @pol_coco_passed
  Scenario: CCRT-106 - DEMOGRAPHIC CHANGE (SUBSCRIBER) - IDENTIFYING DETAILS - NAME (FIRST. MIDDLE, LAST)
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click make Changes button on welcome page
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I click EditUpdate on Family Overview page for "Primary"
    Then I update full name of member with prefix "Primary" in coco
    And I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I check "None of these" life change event checkbox
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    And I click close on open enrollment ended pop up modal

    #UI Validation
    Then I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I Validate the correct enrolled plans are displayed on coco welcome page
    And I click on Sign Out in the Header for "Elmo"

  # DB Validation
    And I validate "SUBMITTED" Medical entities from COCO policy tables
    And I validate Medical entities from COCO pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | incorrect_entity_id_code | incorrect_id_code_qualifier |addl_maint_reason  | sep_reason  |
      | 001                   | 001                | 25                    | 70                       | 1                           |DEMOGRAPHIC CHANGE |             |
    And I download the medical files from coco sftp server with location "/outboundedi/"
    And I validate the coco ob834 medical file data


  @SLCR-783-WIP-@R4V
  Scenario: CCRT-125 - ENR-COCO: ADD DEPENDENT (LCE: Birth) SAME PLANS
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
#    Given I set the dynamic policy, coverage and financial dates in coco
#     | PolicyStartDate           | PolicyEndDate            | CoverageStartDate         | CoverageEndDate          | FinancialStartDate        | FinancialEndDate         |
#     | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year |
    Then I validate I am on the "CoCo Welcome" page
    And I click Make changes button on Welcome Page
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    And I get the newborn "Newborn" dob as "current date" in CoCo page
    And I enter details on tell us about additional members of your household page with name "Newborn", dob "getFromSharedData", gender "Male", and applying "Yes"
    And I select the relationship to primary member as "Child or Other dependent"
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "101 COCO DRIVE", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Newborn"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "Birth:Newborn" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on coco start shopping page
    Then I click continue on grouping Members Medical coco page
    Then I validate I am on the "Medical Plan Results" page
    And I click Continue on the Medical Plans Page CoCo
    Then I validate I am on the "planSummaryMedicalDental" page
    And I set medical premium amount
    And I click continue on coco plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-847-WIP
  Scenario: CCRT-114 - ENR-COCO: DEMOGRAPHIC CHANGE (SUBSCRIBER) - IDENTIFYING DETAILS - GENDER & RACE
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click make Changes button on welcome page
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I click EditUpdate on Family Overview page for "Primary"
    And I update the gender selection to "Female" in coco
    And I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "White or European" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I check "None of these" life change event checkbox
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click on Sign Out in the Header for "Elmo"




