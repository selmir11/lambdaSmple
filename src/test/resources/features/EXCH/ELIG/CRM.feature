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
    And I validate SSA Error for SSN "012123456" on Tell us about yourself page
    And I click continue on Tell us about yourself page
    And I validate SSA Error for SSN "012123456" on Tell us about yourself page
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
    Then I open the "MVRDVR" Tab on contact page
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
    Then I validate that my APTC value is "$486.09/mo"
    And I validate MVR details for account
      |manual_verification_type|manual_verif_status|
      |Income                  |Open               |

    Then I click on view results and shop
    And I click continue on application results page
    And I wait for hold on content to disappear
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "PrimaryMember"
    Then I click continue on start shopping page
    And I validate I am on the "Medical Plan Results" page
    And I select "Anthem Colorado Option Bronze Pathway Essentials Std" medical plan
    Then I click continue on medical plan results page
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
    Then I click on Sign Out in the Header for "NonElmo"

    And I wait for 7000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
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
    Then I click on "No Thanks" on good news page
    Then I validate that "Health First Colorado or CHP+, if the State of Colorado determines you qualify" text displays on the Application History page
    And I validate new event "BE_ATL_DOC_VERIFY_UPSERT_RESP" is present in DB
    Then I click on Sign Out in the Header for "NonElmo"

    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
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
    Then I click on "No Thanks" on good news page
    Then I validate that "Health First Colorado or CHP+, if the State of Colorado determines you qualify" text displays on the Application History page
    And I validate new event "BE_ATL_DOC_VERIFY_UPSERT_RESP" is present in DB
    Then I click on Sign Out in the Header for "NonElmo"

    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
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

  @SLER-1276
  Scenario: SLER-1276 Creation of SSN and Citizenship MVRs in OSC (Checks DB)
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with SSN "" City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
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
    Then I click I don't have a Social Security Number box and "Yes" on Tell us about yourself page
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
    And I select "Yes" for Naturalized Immigrant option
    Then I enter A-Number USCIS number for "Citizen" on Lawful Presence page
    Then I select "Naturalization Certificate" as Document type on Lawful Presence page
    Then I enter Document Number on Lawful Presence page
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "9500000" income at "Annually" frequency
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
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click the provide documents link on the app results page
    Then I upload MVR doc for "Social Security Number" on the My Documents page
    Then I upload MVR doc for "US Citizenship" on the My Documents page
    And I validate MVR details for account
      |manual_verification_type|manual_verif_status|
      |Citizenship             |Open               |
      |SSN                     |Open               |
    Then I click on Sign Out in the Header for "Elmo"

    And I wait for 7000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
    And I verify the "Citizenship/Immigration Status" DVR number 1 is "Active" in the CRM
    And I verify the "SSN Verification" DVR number 2 is "Active" in the CRM
    Then I open the "Citizenship" MVR
    Then I check the "Citizenship" MVR title for "Primary"
    Then I check that the MVR has a status of "Open"
    Then I check the "Citizenship" MVR data for "Primary"
    Then I click the Go Back arrow in CRM
    Then I open the "SSN" MVR
    Then I check the "SSN" MVR title for "Primary"
    Then I check that the MVR has a status of "Open"
    Then I check the "SSN" MVR data for "Primary"
    Then I sign out of CRM

  @SLER-1291
  Scenario: SLER-1291 MA Application in CRM (Checks DB)
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
    And I enter employment details with "1150000" income at "Annually" frequency
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
    Then I click on "No Thanks" on good news page
    Then I validate that "Health First Colorado or CHP+, if the State of Colorado determines you qualify" text displays on the Application History page
    And I validate new event "BE_ATL_DOC_VERIFY_UPSERT_RESP" is present in DB
    Then I click on Sign Out in the Header for "NonElmo"

    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I search for user and click email from search results
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I verify Reports container title
    Then I click on view button for "Account Activity" report
    And I validate I am on the "Account Activity" page
    And I validate Account Activity title row
    Then I wait for 900 milliseconds
    Then I validate "BE_ATL_CONTACT_UPSER.." event code and description "Contact Upsert" in activity event report
    Then I validate "UI_ACCT_CREATED" event code and description "Account created" in activity event report
    Then I validate "BE_ATL_DOC_VERIFY_UP.." event code and description "CRM Upsert Document Verif.." in activity event report
    And I close current tab and switch back to previous tab
    And I logout from Admin Portal

    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
    And I verify the "MA Application" DVR number 1 is "Active" in the CRM
    Then I open the "MA Application" DVR number 1 in the CRM
    Then I check the "MA Application" DVR title in the CRM
    Then I check the "MA Application" DVR Name and Doc Type in the CRM
    Then I sign out of CRM

  @SLER-1292
  Scenario: SLER-1292 MA logic to not duplicate if MA Incident is opened already on an existing contact
    Then I log into the CRM system
    Then I search for user by Email Staging "PrimaryMemberkfetbekt.RmxhkdyjTest@test.com" QA "PrimaryMembergwjxcubx.IllrrtspTest@test.com" in CRM
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
    And I verify the "MA Application" DVR number 1 is "Active" in the CRM
    Then I open the "MA Application" DVR number 1 in the CRM
    Then I check the "MA Application" DVR title in the CRM
    Then I get the time and date of DVR in the CRM
    Then I sign out of CRM

    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
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
    Then I click on "No Thanks" on good news page
    Then I validate that "Health First Colorado or CHP+, if the State of Colorado determines you qualify" text displays on the Application History page
    And I validate new event "BE_ATL_DOC_VERIFY_UPSERT_RESP" is present in DB
    Then I click on Sign Out in the Header for "NonElmo"

    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
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

  @SLER-1293
  Scenario: SLER-1293 Creation of Income DVR in OBO flow
    And I enter first name "MVRAutomationTest", middle name "mname", last name "VLPunex" and general mandatory data for "exchange" account creation
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
    And I select "Prefer not to answer" for race and ethnicity for "MVRAutomationTest"
    Then I click continue on the Race and Ethnicity page
    Then I select "No" for Citizen option
    Then I select "Yes" for Eligible Immigration Status option
    Then I select "I-327 Reentry Permit" as Document type
    Then I enter A-Number USCIS number for "NonCitizen" on Lawful Presence page
    Then I select "None of the above" active-duty members of the military or honorably discharged veterans
    Then I select "Yes" for name matching the document
    And I click continue on the Citizenship page
    Then I select "No" for Lawful Permanent Resident
    Then I select "Administrative order staying removal" for immigration status
    Then I click continue on the Immigration Status page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "700000" income at "Annually" frequency
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
    Then I click "No" on Before you continue popup on the application history page
    Then I validate that my APTC value is "$493.58/mo"
    And I validate MVR details for account
      |manual_verification_type|manual_verif_status|
      |Lawful Presence         |Open               |
      |Income                  |Open               |

    Then I click on view results and shop
    Then I click the provide documents link on the app results page
    And I verify "Eligible Immigration Status" MRV needed on the My Documents page
    And I verify "Financial Help Eligibility" MRV needed on the My Documents page
    Then I click on Sign Out in the Header for "Elmo"

    And I wait for 7000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
    Then I open the "Lawful Presence" MVR
    Then I check that the MVR has a status of "Open"
    Then I click the Go Back arrow in CRM
    Then I open the "Income" MVR
    Then I check that the MVR has a status of "Open"
    Then I sign out of CRM

  @SLER-1294
  Scenario: SLER-1294 MA logic to not duplicate if MA Incident is opened already on an existing contact
    Then I log into the CRM system
    Then I search for user by Email Staging "PrimaryMemberrupcfyxe.UmrmlttdTest@test.com" QA "PrimaryMemberwzxlssho.KnarwamrTest@test.com" in CRM
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
    Then I change the sort of Status Reason DVR to A to Z in the CRM
    And I verify the "MA Application" DVR number 1 is "Active" in the CRM
    Then I open the "MA Application" DVR number 1 in the CRM
    Then I check the "MA Application" DVR title in the CRM
    Then I get the time and date of DVR in the CRM
    Then I sign out of CRM

    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
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
    Then I click on "Continue" on good news page
    Then I select "No" for under the age of 19 question and Continue on ParentCaretaker MA page
    Then I select "No" temporarily absent from Colorado question and Continue on Out Of State MA page
    Then I select "No" for attending school full-time question and Continue on Full-Time Student MA page
    Then I select "No" for medical condition or disability question and Continue on Medical Condition MA page
    Then I select "No" for medical expenses question and Continue on Medical Expenses MA page
    Then I select "No" for self-employed question and Continue on Self-Employed MA page
    Then I click Continue on Thank You MA page
    Then I validate that "Health First Colorado or CHP+, if the State of Colorado determines you qualify" text displays on the Application History page
    And I validate new event "BE_ATL_DOC_VERIFY_UPSERT_RESP" is present in DB
    Then I click on Sign Out in the Header for "NonElmo"

    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
    Then I change the sort of Status Reason DVR to A to Z in the CRM
    And I verify the "MA Application" DVR number 1 is "Active" in the CRM
    And I verify the "MA Application" DVR number 2 is "Canceled" in the CRM
    Then I open the "MA Application" DVR number 1 in the CRM
    Then I check the "MA Application" DVR title in the CRM
    Then I get the time and date of DVR in the CRM
    And I verify time and date of DVR is "Same" in the CRM
    Then I click the Go Back arrow in CRM
    Then I change the sort of Status Reason DVR to A to Z in the CRM
    Then I open the "MA Application" DVR number 2 in the CRM
    Then I check the "MA Application" DVR title in the CRM
    Then I get the time and date of DVR in the CRM
    And I verify time and date of DVR is "Newer" in the CRM
    Then I sign out of CRM

