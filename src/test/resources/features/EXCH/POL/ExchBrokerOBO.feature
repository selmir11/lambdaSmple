Feature: Enroll a plan from broker portal (FAMILY OF 1)

  @SLER-626 @n1
  Scenario: : EXCH Initial Application -  Broker OBO -  Minor Only
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "MGC4testing"@outlook.com
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Given I set the dynamic policy, coverage and financial dates for "medical" plan
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year |
    Given I set the dynamic policy, coverage and financial dates for "dental" plan
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year |
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011983" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    And I click on Find a Broker
    Then I Search authorized Broker "Amethyst"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I click on Sign Out in the Header for "WhoHelpsYouPage"

    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "Amethyst.Broker@invalid.com" password "ALaska13!" and "Amethyst.Broker@invalid.com" password "ALaska13!"

    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I search for clients
    And I click on first client search result
    And I click "manage" the client
    Then I validate I am on the "Account Overview" page

    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I select "No" as pregnancy option
    And I select "No" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Hispanic or Latino" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "03022010", "Female" and applying "Yes"
      |Primary:Daughter|
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
    And I select "Hispanic or Latino" for race and ethnicity for "Daughter"
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

    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click continue on start shopping page
    And I validate I am on the "Medical Plan Results" page
    And I select "Select Health Value Bronze $6900 Medical Deductible" medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    Then I select "EssentialSmile Colorado - Total Care" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I set "Medical" Plans premium amount
    And I set "Dental" Plans premium amount
    And I click continue on plan summary page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox

    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I validate I am on the "Pay now" page
    Then I click all done from payment portal page OBO
    And I check for minors in the household
    Then I validate I am on the "Broker Portal Your Clients" page
    Then I click on broker userName and logout

    Then I validate I am on the "Login" page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on ClickHere link for "My Documents"
    And I click on download "EN-002-04" document
    Then I click on the Colorado Connect or C4 Logo in the "My Policies" Header
    Then I validate I am on the "My Account Overview" page
    And I Validate the correct enrolled plans are displayed on account overview page
    Then I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page
    And I validate "medical" details on my policies page
    And I validate "dental" details on my policies page
    And I click on Sign Out in the Header for "NonElmo"

# #   Gmail Verification
#    Then I open outlook Tab
#    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
#    Then I open the notice "(EN-002-04)" in "English"
#    And I verify the notice Text for "EN-002-04" in "English" for "Exch"
#    And I validate additional details for "medical" plan on email notice
#      | Daughter |
#    And I validate additional details for "dental" plan on email notice
#      | Daughter |
#    Then I delete the open notice
#    And I sign out of Outlook
#    And I switch to the tab number 0

    #DbVerification
    And I verify the policy data quality check with Policy Ah keyset size 2
    And I verify the data from book of business queue table with "POLICY_SUBMISSION" as event type

    And I validate "medical" entities from policy tables
    And I validate "dental" entities from policy tables

    And I validate "medical" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
    And I validate "dental" entities from pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
    And I download the medical and dental files from sftp server with location "/outboundedi/"
    And I validate the ob834 "medical" file data
    And I validate the ob834 "dental" file data

    And I upload all the "medical" ob834 edi files to sftp server with location "/outboundedi/mockediresponse/genEff834"
    And I upload all the "dental" ob834 edi files to sftp server with location "/outboundedi/mockediresponse/genEff834"

  # Ib999 DB Validation
    And I validate "medical" entities from ib999_details db table
    And I validate "dental" entities from ib999_details db table

    And I download the "medical" ib999 files from sftp server with location "/archive/INBOUND999/"
    And I download the "dental" ib999 files from sftp server with location "/archive/INBOUND999/"

    And I validate the ib999 "medical" file data
    And I validate the ib999 "dental" file data

    #Ib834
    And I validate ib834 "medical" details in database for groups
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason |
      | 021                   | 021                | 28                    | CONFIRM           |
    And I validate ib834 "dental" details in database for groups
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason |
      | 021                   | 021                | 28                    | CONFIRM           |

    And I download the "medical" ib834 file from sftp server location "/archive/inboundedi/"
    And I download the "dental" ib834 file from sftp server location "/archive/inboundedi/"

    And I validate the ib834 "medical" files data
    And I validate the ib834 "dental" files data

    # Ob999
    And I validate "medical" entities from ob999_details db table
    And I validate "dental" entities from ob999_details db table

    And I download the "medical" ob999 file from sftp server with location "/outbound999/"
    And I download the "dental" ob999 file from sftp server with location "/outbound999/"

    And I validate the ob999 "medical" file data
    And I validate the ob999 "dental" file data