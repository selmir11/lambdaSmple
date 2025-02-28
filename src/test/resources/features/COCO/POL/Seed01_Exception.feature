Feature: Regression Tests that require Seed 1 without exception

Scenario:Seed 01 For COCO- Single Applicant with Income of $19k

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
    Then I validate I am on the "Elmo Race and Ethnicity" page
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
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    And I get the application id from the url from tobacco page coco
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

#UI Validation
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I select year "2025" from My Current Plan container
    And I Validate the correct enrolled plans are displayed on coco welcome page
    And I click on "My Plans" link on welcome page
    And I validate enrolled medical plans details on my policies page coco

# DB Validation
    And I validate "SUBMITTED" Medical entities from COCO policy tables
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         | PolicyMemberCoverageStatus |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | SUBMITTED                  |
    And I validate Current Medical entities from COCO pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | PolicyStartDate     | PolicyEndDate            | FinancialStartDate  |addl_maint_reason  | sep_reason      |
      | 021                   | 021                | EC                    | First Of Next Month | Last Day Of Current Year | First Of Next Month |                   | NEW_CO_RESIDENT |
    And I download the medical files from coco sftp server with location "/outboundedi/"
    And I validate the coco ob834 medical file data