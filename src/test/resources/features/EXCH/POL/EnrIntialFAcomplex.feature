Feature: Enroll a in a plan 8 HH

  @SLER-832-WIP
  Scenario: : EXCH Initial Application - Complex Household
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "MGC4testing"@outlook.com
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Given I set the dynamic policy, coverage and financial dates for "medical" plan
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year |
    Given I set the dynamic policy, coverage and financial dates for "dental" plan
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year |
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "07271963" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    And I click on Find a Broker
    Then I Search authorized Broker "EnrIntial Broker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I select "No" as pregnancy option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "PO Box 1545" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Asian or Asian American" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    #1Member (spouse)
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "09051959", "Male" and applying "No"
      |Primary:Spouse|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "New" for Residential Address
    And I enter the new residential address details
      | addressLine1           | addressLine2 | city    | state | zipcode | county  | dob |
      | 501 DIFF Drive         | Unit 23      | Boulder | CO    | 80020   | BOULDER |09051959 |
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Asian or Asian American" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    #2Member (son1)
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "SonOne", "06281996", "Male" and applying "Yes"
      |Primary:Son|
      |Spouse:Son |
    And I click continue on Tell us about additional members page

    Then I validate I am on the "Add Address" page
    Then I select "New" for Residential Address
    And I enter the new residential address details
      | addressLine1           | addressLine2 | city    | state | zipcode | county  | dob |
      | 900 Jailhouse Rock     | Unit 23      | Denver  | CO    | 80205   | DENVER  |06281996 |

    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "Yes" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Asian or Asian American" for race and ethnicity for "Son"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    #member3 (son2)

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "SonTwo", "03052010", "Male" and applying "Yes"
      |Primary:Son|
      |Spouse:Son |
      |SonOne:Brother|
    And I click continue on Tell us about additional members page

    Then I validate I am on the "Add Address" page
    Then I select "501 DIFF Drive" specific Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Asian or Asian American" for race and ethnicity for "SonTwo"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    #member 4 (daughter)

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "02142001", "Female" and applying "Yes"
      |Primary:Daughter|
      |Spouse:Daughter |
      |SonOne:Sister|
      |SonTwo:Sister|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "1234 Road" specific Address
    And I select "Yes" for CO Resident option
    And I select "Yes" for Federally Recognized Tribe option
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" for Foster care in state of Colorado
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Indigenous or Native American" for race and ethnicity for "Daughter"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    #Member 5 (nephew)

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Nephew", "0151995", "Male" and applying "Yes"
      |Primary:Nephew|
      |Spouse:Nephew |
      |SonOne:Cousin|
      |SonTwo:Cousin|
      |Daughter:Cousin|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "1234 Road" specific Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select Not listed for race and ethnicity option and enter "Cajun" in the text box
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    #member6 (neice)
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Niece", "05051993", "Female" and applying "Yes"
      |Primary:Niece|
      |Spouse:Niece |
      |SonOne:Cousin|
      |SonTwo:Cousin|
      |Daughter:Cousin|
      |Nephew:Sister|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "1234 Road" specific Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "Yes" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select Not listed for race and ethnicity option and enter "Cajun" in the text box
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "47000.00" income at "Annually" frequency
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

    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 town" and city as "Denver" and state as "CO" and zipcode as "80205" and income "60000.00" at frequency "Annually"
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

    #Mem3
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue


  #Mem4
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue

    #Mem5
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue

     #Mem6
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue

     #Mem7
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "Yes" to claim dependents
    And I select the second dependent
    And I select the third dependent
    And I select the fourth dependent
    And I select the fifth dependent
    And I select the sixth dependent
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

    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on "No Thanks" on good news page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click "Yes" to the Tobacco usage question on start shopping page for "Primary,Niece,Nephew,Daughter"
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click on edit enrollment groups link
    Then I create new group in edit medical grouping page and drag members to the new group
      | Primary,Niece:Group1 |
      | SonTwo:Group2 |
      | Nephew:Group3 |
      | Daughter:Group4 |
    Then I click save button to save the groups
    Then I click on continue button on success pop-up
    Then I validate I am on the "Grouping Members Medical" page
    And  I get the details of medical group Members
    Then I click continue on grouping Members Medical page
    And I validate I am on the "Medical Plan Results" page
    And I select or skip the medical plans for groups
      |Group 1:Cigna Connect Colorado Option Bronze|
      |Group 2:Cigna Connect Colorado Option Bronze |
      |Group 3:Cigna Connect Colorado Option Bronze|
      |Group 4:skip|
    Then I validate I am on the "Grouping Members Dental" page
    Then I click on dental edit enrollment groups link
    Then I validate I am on the "Edit Grouping Members Dental" page
    Then I create new group in edit dental grouping page and drag members to the new group
      | Primary,Niece:Group1 |
      | SonTwo:Group2 |
      | Nephew:Group3 |
      | Daughter:Group4 |
    And I click save button to save the dental groups
    And I click on continue button on success pop-up from edit grouping dental page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    And I select or skip the dental plans for groups
      |Group 1:Anthem Dental Family|
      |Group 2:Anthem Dental Family|
      |Group 3:Anthem Dental Family|
      |Group 4:skip|
    Then I validate I am on the "planSummaryMedicalDental" page
    And I set "Medical" Plans premium amount
    And I set "Dental" Plans premium amount
    And I click continue on plan summary page
    And I validate I am on the "Financial Help Agreements" page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox

    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page

    Then I click all done from payment portal page

    Then I validate I am on the "Account Overview" page
    And I Validate the correct enrolled plans are displayed on account overview page
#    Then I click on ClickHere link for "My Plans"
#    Then I validate I am on the "My Policies" page
#    And I validate "medical" details on my policies page
#    And I validate "dental" details on my policies page
#    And I click View Plan History link from "medical" plan card
#    And I validate "medical" plan details from plan history
#    And I validate "dental" plan details from plan history
#    And I click on Sign Out in the Header for "NonElmo"

    And I validate "medical" entities from policy tables for groups
    And I validate "dental" entities from policy tables for groups

    And I validate "medical" entities from pre edi db tables for groups
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
    And I validate "dental" entities from pre edi db tables for groups
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |

#    #Gmail Verification
#    Then I open outlook Tab
#    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
#    Then I open the notice "(EN-002-04)" in "English"
#    And I verify the notice Text for "EN-002-04" in "English" for "Exch"
#    Then I delete the open notice
#    And I sign out of Outlook
#    And I switch to the tab number 0

    #DbVerification
    And I verify the policy data quality check with Policy Ah keyset size 4
    And I verify the data from book of business queue table with "POLICY_SUBMISSION" as event type

    And I validate the ob834 "medical" file data for groups
    And I validate the ob834 "dental" file data for groups

















