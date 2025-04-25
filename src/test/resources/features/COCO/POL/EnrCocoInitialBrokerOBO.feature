Feature: HUSBAND + WIFE (Colorado Option) (BROKER OBO)
  @SLCR-298 #WIP
  Scenario: CCRT-49 COCO Initial Application HUSBAND + WIFE (Colorado Option) (BROKER OBO)
   Given I set the test scenario details in coco
     | totalGroups | totalMembers | total_subscribers | total_dependents | total_enrollees |
     | 1           | 2            | 1                 | 1                | 2               |
   Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "coco" account creation with email "MGC4testing"@outlook.com
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Given I set the dynamic policy, coverage and financial dates in coco
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year |
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    Then I Search authorized Broker "EnrIntial Broker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
#    And I validate my broker details in the current broker table are "EnrIntial Broker", "Test", "34564567658799", "80205", "719-555-1212", "BROKER", "Active"
    And I click on Sign Out in the Header for "Elmo"

    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "enrintialtest@outlook.com" password "ALaska12!" and "enrintialtest+007@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "enrintialtest@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    And I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I click on "colorado Connect" tab
    And I search for clients
    And I click on first client search result
    And I click "manage" the client

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11181993", "Male", and applying "Yes"
    And I enter my residential address "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Black or African American" for race and ethnicity option for "Primary"
    And I click continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "35,000.00" income amount
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
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "03021995", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Black or African American" for race and ethnicity option for "Spouse"
    And I click continue on the Race and Ethnicity page
    And I select "No" employment option
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
    And I enter a OBO signature on the Declarations And Signature Page CoCo
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    Then I verify eligible plan on Application Result page coco depends on SES
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse" coco
    And I get the application id from the url from tobacco page coco
    Then I click continue on coco start shopping page
    Then I click continue on grouping Members Medical coco page
    Then I validate I am on the "Medical Plan Results" page
    And I select or skip the medical plans for groups on medical plan page
      | Group 1:Select Health Value Colorado Option Bronze |
    Then I validate I am on the "planSummaryMedicalDental" page
    And I set "Medical" Plans premium amount
    And I click continue on coco plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I click on broker userName and logout

    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Plans" link on welcome page
    Then I click on Future Plans CoCo
    Then I validate enrolled medical plans on future plans tab in COCO
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Documents and Letters" link on welcome page
#    And I click on download "EN-002-04" document
#    Then I validate "EN-002-04 English" notice content
#    And I click on Sign Out in the Header for "Elmo"
#
#    Then I open outlook Tab
#    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
#    Then I open the notice "(EN-002-04)" in "English"
#    And I verify the notice Text for "EN-002-04" in "English" for "Coco"
#    Then I delete the open notice
#    And I sign out of Outlook
#    And I switch to the tab number 0

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

   #Ib834
   And I validate coco ib834 file for groups
    | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason |
    | 021                   | 021                | 28                    | CONFIRM           |
   And I download the "medical" ib834 file from sftp server location "/archive/inboundedi/"
   And I validate coco Ib834 file data

#  Ob999
  And I validate "medical" entities from ob999_details db table
  And I download the "medical" ob999 file from sftp server with location "/outbound999/"
  And I validate the ob999 "medical" file data



