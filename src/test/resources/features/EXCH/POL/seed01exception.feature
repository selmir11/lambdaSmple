Feature: Regression Tests that require Seed 1 w/exception

  Background: : Seed 01 w/exception For Exchange- Single Applicant NFA
    Given I set the test scenario details
      | totalGroups | totalMembers | total_subscribers | total_dependents | total_enrollees |
      | 1           | 1            | 1                 | 0                | 1               |
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Given I set the dynamic policy, coverage and financial dates for "medical" plan
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year |
    Given I set the dynamic policy, coverage and financial dates for "dental" plan
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year |
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "11281986" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "P.O.BOX 1454" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for no financial help
    Then I validate I am on the "Tell us about life changes" page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page
    And I validate I am on the "Medical Plan Results" page
    And I select "Elevate Health Plans Colorado Option Bronze" medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    And I select "Delta Dental of Colorado Family Basic Plan" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I set "Medical" Plans premium amount
    And I set "Dental" Plans premium amount
    And I click continue on plan summary page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I Validate the correct enrolled plans are displayed on account overview page
    Then I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page
    And I click on Future Plans
    And I validate "medical" details on my policies page
    And I validate "dental" details on my policies page
    And I click on Sign Out in the Header for "Elmo"

    #DB Validation
    And I validate "medical" entities from policy tables
    And I validate "dental" entities from policy tables
    And I validate "medical" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
    And I validate "dental" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
    And I verify the policy data quality check with Policy Ah keyset size 2
    And I verify the data from book of business queue table with "POLICY_SUBMISSION" as event type
    And I download the medical and dental files from sftp server with location "/outboundedi/"
    And I validate the ob834 "medical" file data
    And I validate the ob834 "dental" file data

  @SLER-1993   @pol_exch_passed
  Scenario: RT-2327 ENR-EXCH: EDIT POLICY - COVERAGE & FINANCIAL END DATES  (CANCEL)
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin dashboard" page
    And I search for user and click email from search results
    Then I click on manage plan button on admin portal Individual dashboard
    Given I set the dynamic policy, coverage and financial dates for "medical" plan
      | PolicyStartDate     | PolicyEndDate      | CoverageStartDate   | CoverageEndDate     | FinancialStartDate  | FinancialEndDate    |
      | First Of Next Month |First Of Next Month | First Of Next Month | First Of Next Month | First Of Next Month | First Of Next Month |
    Given I set the dynamic policy, coverage and financial dates for "dental" plan
      | PolicyStartDate     | PolicyEndDate      | CoverageStartDate   | CoverageEndDate     | FinancialStartDate  | FinancialEndDate    |
      | First Of Next Month |First Of Next Month | First Of Next Month | First Of Next Month | First Of Next Month | First Of Next Month |
    Then I click Make Changes Medical button
    And I update the Coverage End date of member on manage plan page for "Medical"
      | Primary:First Of Next Month |
    And I update the Financial End date of member on manage plan page
      | Primary:First Of Next Month |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I click Make Changes Dental button
    And I update the Coverage End date of member on manage plan page for "Dental"
      | Primary:First Of Next Month |
    And I update the Financial End date of member on manage plan page
      | Primary:First Of Next Month |
    And I click Save Button Dental
    And I select the reason to confirm the changes
    Then logout from Admin Portal
        #DB Validation
    And I validate "medical-cancelled" entities from policy tables
    And I validate "dental-cancelled" entities from policy tables

    And I validate "medical" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason|
      | 024                   | 024                | AI                    |   CANCEL          |           |
    And I validate "dental" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason|
      | 024                   | 024                | AI                    |   CANCEL          |           |
    And I verify the policy data quality check with Policy Ah keyset size 2
    And I verify the data from book of business queue table with "POLICY_SUBMISSION" as event type
    And I download the medical and dental files from sftp server with location "/outboundedi/"
    And I validate the ob834 "medical" file data
    And I validate the ob834 "dental" file data
