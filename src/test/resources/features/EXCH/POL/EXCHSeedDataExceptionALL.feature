Feature: EXCH Seed Data with Exception ALL

  Scenario: Seed 01 w/exception For Exchange- Single Applicant NFA
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
    | PolicyStartDate    | PolicyEndDate            | CoverageStartDate  | CoverageEndDate          | FinancialStartDate    | FinancialEndDate         |
    | First Of Next Month  | Last Day Of Current Year | First Of Next Month  | Last Day Of Current Year | First Of Next Month     | Last Day Of Current Year |
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
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
    Then I click continue on start shopping page
    And I validate I am on the "Medical Plan Results" page
    And I select "Elevate Health Plans Colorado Option Bronze" medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    And I select "Delta Dental of Colorado Family Basic Plan" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
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
#    And I click View Plan History link from "medical" plan card
#    And I validate "medical" plan details from plan history
#    And I click on to Back to Current Plan Details button
#    And I click View Plan History link from "dental" plan card
#    And I validate "dental" plan details from plan history
    Then I click on the Colorado Connect or C4 Logo in the "My Policies" Header
    Then I validate I am on the "My Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"
#    And I validate "medical" entities from policy tables
#    And I validate "dental" entities from policy tables
#    And I validate "medical" entities from pre edi db tables
#    | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason |
#    | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
#    And I validate "dental" entities from pre edi db tables
#    | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason |
#    | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
#  And I download the files from sftp server with location "/outboundedi/"
#  And I verify the policy data quality check with Policy Ah keyset size 2
#  And I verify the data from book of business queue table with "POLICY_SUBMISSION" as event type
## And I validate the ob834 files should have the values
#      | LX | N1 75              | REF       | REFDEN    |
#      | 1  | PRE AMT 1          | 291.02    | 21.00     |
#      | 2  | APTC AMT           | 0.00      | 0.00      |
#      | 3  | CSR AMT            | 0.00      | 0.00      |
#      | 4  | RATING AREA        | 3         | 3         |
#      | 5  | SOURCE EXCHANGE ID | COHBE     | COHBE     |
#      | 6  | TOT RES AMT        | 291.02    | 21.00     |
#      | 7  | PRE AMT TOT        | 291.02    | 21.00     |
#      | 8  | SEP REASON         | NEW_CO_RESIDENT | NEW_CO_RESIDENT |
#

  Scenario: Seed 02 w/exception For Exchange- Single Applicant with FA
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
      | PolicyStartDate    | PolicyEndDate            | CoverageStartDate  | CoverageEndDate          | FinancialStartDate    | FinancialEndDate         |
      | First Of Next Month  | Last Day Of Current Year | First Of Next Month  | Last Day Of Current Year | First Of Next Month     | Last Day Of Current Year |
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
    And I click on Sign Out in the Header for "NonElmo"
#    Then I click on ClickHere link for "My Plans"
#    Then I validate I am on the "My Policies" page
#    And I validate "medical" details on my policies page
#    And I validate "dental" details on my policies page
##    And I click View Plan History link from "medical" plan card
#    And I validate "medical" plan details from plan history
#    And I click on to Back to Current Plan Details button
#    And I click View Plan History link from "dental" plan card
#    And I validate "dental" plan details from plan history
#    Then I click on the Colorado Connect or C4 Logo in the "My Policies" Header
#    Then I validate I am on the "My Account Overview" page
#    And I click on Sign Out in the Header for "Elmo"
#    And I validate "medical" entities from policy tables
#    And I validate "dental" entities from policy tables
#    And I validate member details from ob834_details table
#      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason      |
#      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
#    And I download the files from sftp server with location "/outboundedi/"
#    And I verify the policy data quality check with Policy Ah keyset size 2
#    And I verify the data from book of business queue table with "POLICY_SUBMISSION" as event type
##    And I validate the ob834 files should have the values
#      | LX | N1 75              | REF       | REFDEN    |
#      | 1  | PRE AMT 1          | 287.25    | 21.00     |
#      | 2  | APTC AMT           | 232.74    | 0.00      |
#      | 3  | CSR AMT            | 0.00      | 0.00      |
#      | 4  | RATING AREA        | 3         | 3         |
#      | 5  | SOURCE EXCHANGE ID | COHBE     | COHBE     |
#      | 6  | TOT RES AMT        | 54.51     | 21.00     |
#      | 7  | PRE AMT TOT        | 287.25    | 21.00     |
#      | 8  | SEP REASON         | NEW_CO_RESIDENT | NEW_CO_RESIDENT |


  Scenario: Seed 03 With Exception For Exchange- Husband + Wife Both Smokers with Broker - NFA
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Given I set the dynamic policy, coverage and financial dates for "medical" plan
      | PolicyStartDate    | PolicyEndDate            | CoverageStartDate  | CoverageEndDate          | FinancialStartDate    | FinancialEndDate         |
      | First Of Next Month  | Last Day Of Current Year | First Of Next Month  | Last Day Of Current Year | First Of Next Month     | Last Day Of Current Year |
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Boulder" in State "CO" with dob "11181993" in county "BOULDER" with zipcode "80020"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    And I Search authorized Broker "Margie"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "1234 Road" in city "Boulder" in state "CO" with zipcode "80020" and county "BOULDER"
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
    Then I validate I am on the "Family Overview" page
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "03021995", "Female" and applying "Yes"
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
    Then I validate I am on the "Family Overview" page
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
    Then I click "Yes" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    Then I validate I am on the "Medical Plan Results" page
    Then I select "Select Health Value Bronze $6900 Medical Deductible" medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    And I validate I am on the "Dental Plan Results" page
    And I select "EssentialSmile Colorado - Total Care" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I Validate the correct enrolled plans are displayed on account overview page
    And I click on Sign Out in the Header for "NonElmo"
#    Then I click on ClickHere link for "My Plans"
#    Then I validate I am on the "My Policies" page
#    And I validate "medical" details on my policies page
#    And I validate "dental" details on my policies page
#    Then I click on the Colorado Connect or C4 Logo in the "My Policies" Header
#    Then I validate I am on the "My Account Overview" page
#    And I click on Sign Out in the Header for "Elmo"

  Scenario: Seed 04 with exception For Exchange- Husband and Wife with FA
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Boulder" in State "CO" with dob "11181993" in county "BOULDER" with zipcode "80020"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    And I Search authorized Broker "Margie"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Boulder" in state "CO" with zipcode "80020" and county "BOULDER"
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
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "03021995", "Female" and applying "Yes"
      |Primary:Spouse|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 Uptown" and city as "Boulder" and state as "CO" and zipcode as "80020" and income "3500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 Main" and city as "Boulder" and state as "CO" and zipcode as "80020" and income "3000000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click continue on start shopping page
    And I validate I am on the "Grouping Members Medical" page
    Then I validate that there are 1 default groups
    Then I click continue on grouping Members Medical page
    And I validate I am on the "Medical Plan Results" page
    And I select "RMHP Colorado Doctors Plan Colorado Option Bronze" medical plan
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
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

  Scenario: Seed 05 With Exception For Exchange- Family of Four - NFA
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
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
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
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
    And I click continue on plan summary page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

  Scenario: Seed 06 With Exception For Exchange- Family of Four - FA
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
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
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "03021995", "Female" and applying "Yes"
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
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "8000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "Yes" to claim dependents
    And I select the second dependent
    And I select the third dependent
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    And I validate I am on the "Medical Plan Results" page
    And I select "Anthem Colorado Option Bronze Pathway Essentials Std" medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    And I validate I am on the "Dental Plan Results" page
    And I select "Anthem Dental Family" plan
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
    And I click on Sign Out in the Header for "NonElmo"

  Scenario: Seed 07 with exception For Exchange- Husband+Wife+Son+DIL, Husband and Son Tax payer with different address and SMOKERS
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "09051959" in county "DENVER" with zipcode "80205"
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
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "05271963", "Female" and applying "Yes"
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
    Then I enter details on tell us about additional members of your household exch page and continue with "Son", "08281999", "Male" and applying "Yes"
      |Primary:Son|
      |Spouse:Son |
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "New" for Residential Address
    And I enter the new residential address details
      | addressLine1           | addressLine2          | city    | state | zipcode | county  | dob     |
      | 101 Springs Drive      | Colorado Springs      | Denver  | CO    | 80919   | EL PASO |08281999 |
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    Then I select "No" for Foster care in state of Colorado
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
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "InLaw", "05052001", "Female" and applying "Yes"
      |Primary:In Law|
      |Spouse:In Law |
      |Son:Spouse    |
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "recent option" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    Then I select "No" for Foster care in state of Colorado
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "InLaw"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "45000.00" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "40000.00" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    Then I Declare as Tax Household 2
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page
    And I wait for hold on content to disappear
    Then I validate I am on the "Start Shopping" page
    Then I click "Yes" to the Tobacco usage question on start shopping page for "Son,InLaw"
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I validate that there are 2 default groups
    Then I click continue on grouping Members Medical page
    And I validate I am on the "Medical Plan Results" page
    And I select "KP Select CO Bronze 8500/50" plan
    Then I click continue on medical plan results page
    And I select "Anthem Colorado Option Silver Pathway Std" plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    And I select "Delta Dental of Colorado Family Basic Plan" plan
    Then I click continue on dental plan results page
    And I select "Anthem Dental Family Value" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter "taxHolder1" signature on the Financial Help Agreements page
    And I enter "taxHolder2" signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

  Scenario: Seed 08 with exception For Exchange-  Husband+Wife+Son+DIL, Husband and Son Tax payer with same address
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "09051959" in county "DENVER" with zipcode "80205"
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
    #spouse
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "05271963", "Female" and applying "Yes"
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
    Then I enter details on tell us about additional members of your household exch page and continue with "Son", "08281999", "Male" and applying "Yes"
      |Primary:Son|
      |Spouse:Son |
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    And I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    Then I select "No" for Foster care in state of Colorado
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
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "InLaw", "05052001", "Female" and applying "Yes"
      |Primary:In Law|
      |Spouse:In Law |
      |Son:Spouse    |
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    And I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    Then I select "No" for Foster care in state of Colorado
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "InLaw"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "45000.00" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "40000.00" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    Then I Declare as Tax Household 2
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page
    And I wait for hold on content to disappear
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I validate that there are 2 default groups
    Then I click on edit enrollment groups link
    Then I create new group in edit medical grouping page and drag members to the new group
      | Primary,Spouse:Group1 |
      | Son,InLaw:Group2 |
    Then I click save button to save the groups
    Then I click on continue button on success pop-up
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Select CO Bronze 8500/50" plan
    Then I click continue on medical plan results page
    And I select "KP Select CO Bronze 8500/50" plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I validate that there are 2 default groups
    Then I click on dental edit enrollment groups link
    Then I validate I am on the "Edit Grouping Members Dental" page
    Then I create new group in edit dental grouping page and drag members to the new group
      | Primary,Spouse:Group1 |
      | Son,InLaw:Group2 |
    And I click save button to save the dental groups
    And I click on continue button on success pop-up from edit grouping dental page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    Then I validate I am on the "Dental Plan Results" page
    And I select "Delta Dental of Colorado Family Enhanced Plan" plan
    Then I click continue on dental plan results page
    And I select "Delta Dental of Colorado Family Enhanced Plan" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter "taxHolder1" signature on the Financial Help Agreements page
    And I enter "taxHolder2" signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

  Scenario: Seed 09 With Exception For Exchange- Minor Only - FA
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "09052000" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I select "No" as pregnancy option
    And I select "No" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    Then I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "05052019", "Female" and applying "Yes"
      |Primary:Daughter|
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
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "4500000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Head of household" tax filing status
    And I select "Yes" to claim dependents
    And I select the first dependent
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    Then I select "KP Select CO Catastrophic" medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    And I select "Cigna Dental Pediatric" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

  Scenario: : Seed 10 With Exception For Exchange- Grandparents with minors only  - NFA
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Englewood" in State "CO" with dob "09051959" in county "ARAPAHOE" with zipcode "80113"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "No" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "1234 Road" in city "Englewood" in state "CO" with zipcode "80113" and county "ARAPAHOE"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    Then I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
#    //GRANDMA
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "07271963", "Female" and applying "No"
      |Primary:Spouse|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    And I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    Then I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
#    //GRAND DAUGHTER
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Granddaughter", "04212013", "Female" and applying "Yes"
      |Primary:Granddaughter|
      |Spouse:Granddaughter|
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
    And I select "Prefer not to answer" for race and ethnicity for "Granddaughter"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
#    //GRANDSON
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Grandson", "12222016", "Male" and applying "Yes"
      |Primary:Grandson|
      |Spouse:Grandson|
      |Granddaughter:Brother |
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
    And I select "Prefer not to answer" for race and ethnicity for "Grandson"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    And I Apply for no financial help
    Then I validate I am on the "Tell us about life changes" page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I set data from application history page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    Then I validate I am on the "Medical Plan Results" page
    Then I select "KP Select CO Catastrophic" medical plan
    Then I click continue on medical plan results page
    Then I select "KP Select CO Catastrophic" medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    And I validate I am on the "Dental Plan Results" page
    And I select "Cigna Dental Pediatric" plan
    Then I click continue on dental plan results page
    And I select "Cigna Dental Pediatric" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"










