Feature: Initial Application Single Applicant(Silver Enhanced)

  @SLCR-297 @SLCR-933 @SLCR-934 @SLCR-935 @SLCR-936 @pol_coco_passed
  Scenario: COCO Initial Application - Single Applicant (Silver Enhanced)
    Given I set the test scenario details in coco
      | totalGroups | totalMembers | total_subscribers | total_dependents | total_enrollees |
      | 1           | 1            | 1                 | 1                | 1               |
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "coco" account creation with email "MGC4testing"@outlook.com
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Given I set the dynamic policy, coverage and financial dates in coco
      | PolicyStartDate           | PolicyEndDate            | CoverageStartDate         | CoverageEndDate          | FinancialStartDate        | FinancialEndDate         |
      | First Of Next Month       | Last Day Of Current Year | First Of Next Month       | Last Day Of Current Year | First Of Next Month       | Last Day Of Current Year |
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "PO BOX 1454", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "White or European" for race and ethnicity option for "Primary"
    And I click continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "19,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
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
    Then I verify eligible plan on Application Result page coco depends on SES
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    And I get the application id from the url from tobacco page coco
    Then I click continue on coco start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I select or skip the medical plans for groups on medical plan page
      | Group 1:Cigna Connect Colorado Option Bronze |
    Then I validate I am on the "planSummaryMedicalDental" page
    And I set "Medical" Plans premium amount
    And I click continue on coco plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page

#    And I click on "My Documents and Letters" link on welcome page
#    And I click on download "EN-002-04" document
#
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "(EN-002-04)" in "English"
    And I verify the notice Text for "EN-002-04" in "English" for "Coco"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    And I select year "Current Year" from My Current Plan container
    And I Validate the correct enrolled plans are displayed on coco welcome page
    And I click on "My Plans" link on welcome page
    Then I click on Future Plans CoCo
    Then I validate enrolled medical plans on future plans tab in COCO
    And I click on Sign Out in the Header for "Elmo"

    And I validate "SUBMITTED" policy table entities for groups in COCO
    And I verify the policy data quality check with Policy Ah keyset size 1
    And I validate Medical entities for groups from COCO pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code |addl_maint_reason  | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
    And I download the medical and dental files from sftp server with location "/outboundedi/"
    And I validate the coco ob834 medical file data

    And I upload all the "medical" ob834 edi files to sftp server with location "/outboundedi/mockediresponse/genEff834"
   # Ib999 DB Validation
    And I validate "medical" entities from ib999_details db table
    And I download the "medical" ib999 files from sftp server with location "/archive/INBOUND999/"
    And I validate the ib999 "medical" file data
