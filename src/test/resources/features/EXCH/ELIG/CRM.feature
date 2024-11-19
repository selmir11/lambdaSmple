@CRM
Feature: Testing Manual Verification Requests (MVRs) and CRM (MD365)

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page

  @SLER-1220
  Scenario: SLER-1220 Correctable Error Count-SSA
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with SSN "012123456" City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    And I validate SSA Error on Tell us about yourself page
    And I click continue on Tell us about yourself page
    And I validate SSA Error on Tell us about yourself page
    And I click continue on Tell us about yourself page
    Then I enter member with address line1 "1234 Street" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    Then I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for no financial help
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I validate MVR details for account
      |manual_verification_type|manual_verif_status|manual_verif_date_set|manual_verif_due_date|manual_verif_date_expired|manual_verif_date_closed|
      |SSN                     |Open               |         0           |         90          |          105            |                        |
      |Citizenship             |Open               |         0           |         90          |          105            |                        |
    And I validate the SSA response code is "HE030004" in the DB for "Primary"
    And I click on Sign Out in the Header for "NonElmo"
    Then I validate I am on the "Login" page

    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the MVRDVR Tab on contact page
    Then I open the "SSN" MVR
    Then I check the "SSN" MVR title for "Primary"
    Then I check that the MVR has a status of "Open"
    Then I click the Go Back arrow in CRM
    Then I open the "Citizenship" MVR
    Then I check the "Citizenship" MVR title for "Primary"
    Then I check that the MVR has a status of "Open"
    Then I sign out of CRM

  @SLER-1237
  Scenario: SLER-1237 Income MVR (Low Income)
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    And I click on Find a Broker
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter member with address line1 "1234 Street" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    Then I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "2400000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate that my APTC value is "$443.92/mo"
    And I validate MVR details for account
      |manual_verification_type|manual_verif_status|
      |Income                  |Open               |

    Then I click on view results and shop
    And I click continue on application results page
    And I wait for hold on content to disappear
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    And I validate I am on the "Medical Plan Results" page
    And I select "Anthem Colorado Option Bronze Pathway Essentials Std" medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    And I select "Anthem Dental Family" plan
    Then I click continue on dental plan results page
   Then I validate I am on the "planSummaryMedicalDental" page
    And I set "Medical" Plans premium amount
    And I set "Dental" Plans premium amount
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
    Then I click on Sign Out in the Header for "NonElmo"

    And I wait for 7000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the MVRDVR Tab on contact page
    Then I open the "Income" MVR
    Then I check that the MVR has a status of "Open"
    Then I sign out of CRM

  @SLER-1240
  Scenario: SLER-1240 MA Application duplicates in CRM (Checks DB)
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    And I click on Find a Broker
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter member with address line1 "1234 Street" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    Then I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "1100000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on No Thanks on good news page
    Then I validate that "Health First Colorado or CHP+, if the State of Colorado determines you qualify" text displays on the Application History page
    And I validate new event "BE_ATL_DOC_VERIFY_UPSERT_RESP" is present in DB
    Then I click on Sign Out in the Header for "NonElmo"

    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the MVRDVR Tab on contact page
    And I verify the "MA Application" DVR number 1 is "Active" in the CRM
    Then I open the "MA Application" DVR number 1 in the CRM
    Then I check the "MA Application" DVR title in the CRM
    Then I get the time and date of DVR in the CRM
    Then I sign out of CRM

    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    Then I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on No Thanks on good news page
    Then I validate that "Health First Colorado or CHP+, if the State of Colorado determines you qualify" text displays on the Application History page
    And I validate new event "BE_ATL_DOC_VERIFY_UPSERT_RESP" is present in DB
    Then I click on Sign Out in the Header for "NonElmo"

    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the MVRDVR Tab on contact page
    And I verify the "MA Application" DVR number 1 is "Active" in the CRM
    And I verify the "MA Application" DVR number 2 is "Canceled" in the CRM
    Then I open the "MA Application" DVR number 1 in the CRM
    Then I check the "MA Application" DVR title in the CRM
    Then I get the time and date of DVR in the CRM
    And I verify time and date of DVR is "Same" in the CRM
    Then I click the Go Back arrow in CRM
    Then I open the "MA Application" DVR number 2 in the CRM
    Then I check the "MA Application" DVR title in the CRM
    Then I get the time and date of DVR in the CRM
    And I verify time and date of DVR is "Newer" in the CRM
    Then I sign out of CRM