Feature: Seed05 - Exchange

  Background: Seed 05 For Exchange- Family of Four - NFA
    Given I set the test scenario details
      | totalGroups | totalMembers | total_subscribers | total_dependents | total_enrollees |
      | 1           | 4            | 1                 | 3                |   4             |
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Given I set the dynamic policy, coverage and financial dates for "medical" plan
      | PolicyStartDate           | PolicyEndDate            | CoverageStartDate         | CoverageEndDate          | FinancialStartDate        | FinancialEndDate         |
      | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year |
    Given I set the dynamic policy, coverage and financial dates for "dental" plan
      | PolicyStartDate           | PolicyEndDate            | CoverageStartDate         | CoverageEndDate          | FinancialStartDate        | FinancialEndDate         |
      | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year |
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
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
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
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "03051989", "Female" and applying "Yes"
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "04212013", "Female" and applying "Yes"
        |Primary:Daughter|
        |Spouse:Daughter|
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Daughter"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Son", "12222016", "Male" and applying "Yes"
        |Primary:Son|
        |Spouse:Son|
        |Daughter:Brother|
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Son"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
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
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    And I validate I am on the "Medical Plan Results" page
    And I select "Cigna Connect Colorado Option Bronze" medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    And I validate I am on the "Dental Plan Results" page
    And I select "Delta Dental of Colorado Family Comprehensive Plan" plan
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
    And I validate "medical" details on my policies page
    And I validate "dental" details on my policies page
    And I click View Plan History link from "medical" plan card
    And I validate "medical" plan details from plan history
    And I click on to Back to Current Plan Details button
    And I click View Plan History link from "dental" plan card
    And I validate "dental" plan details from plan history

    And I click on Sign Out in the Header for "NonElmo"

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

  @SLER-1290 @pol_exch_passed
  Scenario: RT-2530 ENR-EXCH: DEMOGRAPHIC CHANGE - AGENT BROKER INFO - ADD BROKER
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on make changes button
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Other" and click continue
    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    Then I Search authorized Broker "Mister Broker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I click continue on the Immigration Status page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
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

    And I verify the policy data quality check with Policy Ah keyset size 2
    And I verify the data from book of business queue table with "POLICY_UPDATE" as event type

    And I validate "medical" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason |
      | 001                   | 001                | AI                    | AGENT BROKER INFO |            |
    And I validate "dental" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason |
      | 001                   | 001                | AI                    | AGENT BROKER INFO |            |
    And I download the medical and dental files from sftp server with location "/outboundedi/"

    And I validate the ob834 "medical" file data
    And I validate the ob834 "dental" file data

