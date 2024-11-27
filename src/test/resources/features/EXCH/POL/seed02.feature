Feature: Seed02 - Exchange

  Background: Seed 02 For Exchange- Single Applicant with FA
    Given I set the test scenario details
      | totalGroups | totalMembers | total_subscribers | total_dependents | total_enrollees |
      | 1           | 1            | 1                 | 0                |   1             |
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Given I set the dynamic policy, coverage and financial dates
      | PolicyStartDate           | PolicyEndDate            | CoverageStartDate         | CoverageEndDate          | FinancialStartDate        | FinancialEndDate         |
      | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year |
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "03051989" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "P.O. BOX 1454" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "4000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Sign Out in the Header for "NonElmo"

    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin dashboard" page
    And I search for user and click email from search results
    And I click "Admin LCE" from application links dropdown
    And I look up with account id on admin tool page
    And I change effective date to "0101" of "current year" from admin portal
    Then logout from Admin Portal

    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Eligibility"
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click continue on start shopping page
    And I validate I am on the "Medical Plan Results" page
    And I select "Elevate Health Plans Colorado Option Bronze" medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    And I select "Delta Dental of Colorado Family Basic Plan" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I Validate the correct enrolled plans are displayed on account overview page
    Then I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page
    And I validate "medical" details on my policies page
    And I validate "dental" details on my policies page
    And I click View Plan History link from "medical" plan card
    And I validate "medical" plan details from plan history
    And I click on to Back to Current Plan Details button
    And I click View Plan History link from "dental" plan card
    And I validate "dental" plan details from plan history
    And I click on Sign Out in the Header for "Elmo"

    And I validate "medical" entities from policy tables
    And I validate "dental" entities from policy tables

    And I verify the policy data quality check with Policy Ah keyset size 2
    And I verify the data from book of business queue table with "POLICY_SUBMISSION" as event type

    And I validate "medical" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason |
      | 021                   | 021                | EC                    |                   | ADMIN_LCE  |
    And I validate "dental" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason |
      | 021                   | 021                | EC                    |                   | ADMIN_LCE  |

    And I download the medical and dental files from sftp server with location "/outboundedi/"
    And I validate the ob834 "medical" file data
    And I validate the ob834 "dental" file data

  @SLER-1281-WIP
  Scenario:RT-2328 ENR-EXCH: EDIT POLICY - PREMIUM & APTC AMOUNT UPDATES
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin dashboard" page
    And I search for user and click email from search results
    Then I click on manage plan button on admin portal Individual dashboard
    Then I click Make Changes Medical button
    Then I update the premium value for
      | 1:200.00 |
    Then I update the APTC value for
      | 1:100.00 |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then logout from Admin Portal
    And I validate "medical" entities from policy tables
    And I validate "dental" entities from policy tables

    And I verify the policy data quality check with Policy Ah keyset size 2
    And I verify the data from book of business queue table with "POLICY_SUBMISSION" as event type

    And I validate "medical" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason |
      | 001                   | 001                | AI                    | FINANCIAL CHANGE  |            |
    And I validate "dental" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason |
      | 021                   | 021                | EC                    |                   | ADMIN_LCE  |
    And I download the medical and dental files from sftp server with location "/outboundedi/"
    And I validate the ob834 "medical" file data
    And I validate the ob834 "dental" file data


  @SLER-95-wip
  Scenario:ENR-EXCH: DEMOGRAPHIC CHANGE (SUBSCRIBER) - IDENTIFYING DETAILS - NAME (FIRST. MIDDLE, LAST)
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on make changes button
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Other" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page

    Then I update full name of member with prefix "Primary"
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
    And I click continue on the Add Address page

    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    Then I select "NoneOfThese" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    And I click on Sign Out in the Header for "NonElmo"
    And I validate "medical" entities from policy tables
    And I validate "dental" entities from policy tables
    And I verify the policy data quality check with Policy Ah keyset size 4
    And I verify the data from book of business queue table with "POLICY_UPDATE" as event type
    And I validate "medical" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason  | sep_reason |
      | 001                   | 001                | 25                    | "DEMOGRAPHIC  CHANGE" |            |
    And I validate "dental" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason  | sep_reason |
      | 001                   | 001                | 25                    | DEMOGRAPHIC CHANGE |            |
    And I download the medical and dental files from sftp server with location "/outboundedi/"
    And I validate the ob834 "medical" file data
    And I validate the ob834 "dental" file data

  @SLER-133-WIP
  Scenario:ENR-EXCH: ADD DEPENDENT (LCE: Marriage) - DIFF CARRIER / DIFF PLANS
    Given I set the test scenario details
      | totalGroups | totalMembers | total_subscribers | total_dependents | total_enrollees |
      | 1           | 1            | 1                 | 0                |   1             |
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on make changes button
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Marriage" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
#    Then I validate I am on the "Citizenship" page
#    Then I click continue on the Citizenship page

    Then I click continue on the Immigration Status page
    Then I validate I am on the "Family Overview" page
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "11281986", "Female" and applying "Yes"
      |Primary:Spouse|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    And I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
   # And I click on the RedIcon to add Member financial details
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    Then I validate I am on the "EXCH Declarations and Signature" page
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click Yes to the Tobacco usage question on start shopping page
      |Primary,Spouse|
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    Then I validate I am on the "Medical Plan Results" page
    Then I select "Cigna Connect Colorado Option Bronze" medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    And I validate I am on the "Dental Plan Results" page
    And I select "Cigna Dental Family + Pediatric" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page
    Then I select make payment button to pay the premium
    And I select the Money Order button
    And I click continue on payment selection page
    And I click continue on initial payment page
    And I click on Go To Welcome Page Button on whats next page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate "medical" entities from policy tables
    And I validate "dental" entities from policy tables
    # bob, data quality?
    And I validate "medical" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason                               |
      | 021                   | 021                | AI                    |                   | FINANCIAL_CHANGE |
    And I validate "dental" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason                               |
      | 021                   | 021                | EC                    |                   | MARRIAGE_CIVILUNION_OR_DOMESTIC_PARTNER |
    And I download the medical and dental files from sftp server with location "/outboundedi/"

    And I validate the ob834 "medical" file data
    And I validate the ob834 "dental" file data







