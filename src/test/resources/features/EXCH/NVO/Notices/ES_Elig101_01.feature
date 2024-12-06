@NVO @NVOPDF
Feature: Eligibility Notices

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "mf_test_"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

  @SLER-987 @MFReady
  Scenario: Not Eligible; Didn't Apply; 1 person; ES
    # EMAIL check
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Report a life change
    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    # Who are you
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01/01/1985" in county "Denver" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    And I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page

    # Continue on my own
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I select "Male" as sex option
    # Below is specific case context: user not applying
    And I select "No" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    Then I select "Yes" for CO Resident option
    Then I select "No" for Federally Recognized Tribe option
    Then I click continue on the Add Address page

    # Life change information
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page

    # Financial help
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "6000000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    And I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    # Health coverage and life change information
    Then I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    # Declarations and signature
    Then I validate I am on the "EXCH Declarations and Signature" page
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page

    # Review application results
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click on My Account in the "NonElmo" Header

    # Check Email notice
    Then I validate I am on the "My Account Overview" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "mf_test_@outlook.com" and "ALaska12!"
    Then I open the notice "Los resultados de su solicitud" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    And I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Ineligible: Did Not Apply" notice in "Spanish" for "1" members
    And I click on Sign Out in the Header for "Elmo"

  @SLER-988 @MFReady
  Scenario: Not Eligible; Not a CO Resident; 1 person; ES
    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

#    # Report a life change
    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    # Who are you
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Columbus" in State "OH" with dob "01/01/1985" in county "Franklin" with zipcode "43201"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    And I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page

    # Continue on my own
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I select "Female" as sex option
    And I select "No" as pregnancy option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Columbus" in state "OH" with zipcode "43201" and county "FRANKLIN"
    # Below is specific case context: user not a CO resident
    Then I select "No" for CO Resident option
    Then I select "No" for Federally Recognized Tribe option
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page

    # Life change information
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page

    # Financial help
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "6000000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    And I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    # Health coverage and life change information
    Then I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    # Declarations and signature
    Then I validate I am on the "EXCH Declarations and Signature" page
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page

    # Review application results
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click on My Account in the "NonElmo" Header

    # Check Email notice
    Then I validate I am on the "My Account Overview" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "mf_test_@outlook.com" and "ALaska12!"
    Then I open the notice "Los resultados de su solicitud" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Ineligible: Not CO Resident" notice in "Spanish" for "1" members
    And I click on Sign Out in the Header for "Elmo"

  @SLER-992 @MFReady
  Scenario: MA, QHP Eligible; 1 person; ES
    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Report a life change
    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    # Who are you
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01/01/1985" in county "Denver" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    And I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page

    # Continue on my own
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80202" and county "DENVER"
    Then I select "Yes" for CO Resident option
    Then I select "No" for Federally Recognized Tribe option
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page

    # Financial help
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    # Below is specific case context: user has income of $20,000 triggering MedicAid
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2000000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "Yes" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    And I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    # Health coverage and life change information
    Then I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    # Declarations and signature
    Then I validate I am on the "EXCH Declarations and Signature" page
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page

    # Review application results
    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click on My Account in the "NonElmo" Header

    # Check Email notice
    Then I validate I am on the "My Account Overview" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "mf_test_@outlook.com" and "ALaska12!"
    Then I open the notice "Los resultados de su solicitud" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Health First Colorado" notice in "Spanish" for "1" members
    And I click on Sign Out in the Header for "Elmo"

  @SLER-989 @WIP
  Scenario: APTC, CSR, QHP Eligible; Lost Insurance; 1 person; ES
    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Report a life change
    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    # Who are you
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01/01/1985" in county "Denver" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    And I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page

    # Continue on my own
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80202" and county "DENVER"
    # Below is specific case context: user from CO
    Then I select "Yes" for CO Resident option
    Then I select "No" for Federally Recognized Tribe option
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page

    # Financial help
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "3600000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    And I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    # Health coverage and life change information
    Then I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    # Declarations and signature
    Then I validate I am on the "EXCH Declarations and Signature" page
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page

    # Review application results
    Then I validate I am on the "Application History" page
#    Then I save the Total Savings
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click on My Account in the "NonElmo" Header

     # Check Email notice
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "mf_test_@outlook.com" and "ALaska12!"
    Then I open the notice "Los resultados de su solicitud" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on Sign Out in the Header for "NonElmo"

    # Grab CSR % via admin portal
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I search for user and click email from search results
    Then I verify Primary account holder and account number displays
    Then I validate I am on the "Admin Portal individual dashboard" page
#    And I save the Cost Sharing Reduction percent
    Then I verify the option in years displays
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page

    # Check My Documents notice
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
#    Then I validate "Application Results": "QHP" notice in "Spanish" for "1" members
#    And I click on Sign Out in the Header for "Elmo"

  @SLER-990 @WIP
  Scenario: APTC, CSR, QHP Eligible; Gain of Tribal Status; 1 person; ES
    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Report a life change
    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    # Who are you
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01/01/1985" in county "Denver" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    And I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page

    # Continue on my own
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80202" and county "DENVER"
    Then I select "Yes" for CO Resident option
    # Below is specific case context: user has tribal status
    Then I select "Yes" for Federally Recognized Tribe option
#    Then I add the tribe details
#    Then I select "No" for Hardship Exemption option
#    Then I select "No" for Disability option
#    Then I select "No" to the recently denied medicaid question
#    Then I select "No" for Incarceration option
#    Then I click continue on the Add Address page
#    And I select "Prefer not to answer" for race and ethnicity for "Primary"
#    And I click continue on the Race and Ethnicity page
#    Then I validate I am on the "Citizenship" page
#    Then I select "Yes" for Citizen option
#    Then I select "No" for Naturalized Immigrant option
#    Then I click continue on the Citizenship page
#    Then I validate I am on the "Family Overview" page
#    Then I verify the family overview table is present
#    Then I click continue on family overview page
#
#    # Financial help
#    Then I validate I am on the "Financial Help" page
#    And I Apply for financial help
#    Then I validate I am on the "Employment Info" page
#    Then I select the option "Yes" to employment
#    And I select the option "No" to self employment
#    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2400000" at frequency "Annually"
#    And I select the option "No" to seasonal employment
#    And I select the option "No" to projected income
#    And I click continue on the Employment Info Page
#    Then I validate I am on the "Employment Summary" page
#    Then I click continue on the Employment Summary Page
#    Then I validate I am on the "Additional income" page
#    And I click None of these as additional income option and continue
#    Then I validate I am on the "Deductions" page
#    Then I click None of these as deduction option and continue
#    Then I validate I am on the "Income Summary" page
#    Then I select the projected income option "No" and continue
#    Then I validate I am on the "Tax status" page
#    And I select the option "No" to claim as dependent
#    And I select the option "Yes" to file federal income tax return next year
#    And I select "Single" tax filing status
#    And I select "No" to claim dependents
#    And I click save and continue on tax status page
#
#    # Health coverage and life change information
#    Then I validate I am on the "Elmo Other Health Coverage" page
#    Then I select "None of these" as ELMO health coverage option
#    Then I click continue on the ELMO health coverage page
#    Then I validate I am on the "Family Overview" page
#    Then I verify the family overview table is present
#    Then I click continue on family overview page
#    Then I validate I am on the "Tell us about life changes" page
#    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
#    Then I click on Save and Continue
#
#    # Declarations and signature
#    Then I validate I am on the "EXCH Declarations and Signature" page
#    And I Declare as Tax Household 1
#    Then I click Continue on the Declarations And Signature Page
#
#    # Review application results
#    Then I validate I am on the "Application History" page
#    Then I click on view results and shop
#    Then I validate I am on the "Application Results" page
#    Then I click on My Account in the "NonElmo" Header
#
#     # Check Email notice
#    Then I open outlook Tab
#    And I sign in to outlook with Valid Credentials "mf_test_@outlook.com" and "ALaska12!"
#    Then I open the notice "Los resultados de su solicitud" in "Spanish"
#    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
#    Then I delete the open notice
#    And I sign out of Outlook
#    And I switch to the tab number 0
#
#    # Check My Documents notice
#    Then I validate I am on the "My Account Overview" page
#    Then I click on ClickHere link for "My Documents"
#    Then I validate I am on the "My Documents" page
#    Then I validate the notice "Application Results" exist in my document letter Containers
#    And I click on download "Application Results" document
#    Then I validate "Application Results": "ANAI" notice in "Spanish" for "1" members
#    And I click on Sign Out in the Header for "Elmo"

  @SLER-991 @WIP
  Scenario: APTC, CSR, QHP Eligible; Gain of Tribal Status; 2 person; ES
    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Report a life change
    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    # Who are you
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01/01/1985" in county "Denver" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    And I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page

    # Continue on my own
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80202" and county "DENVER"
    Then I select "Yes" for CO Resident option
    # Below is specific case context: user has tribal status
    Then I select "Yes" for Federally Recognized Tribe option
#    Then I add the tribe details
#    Then I select "No" for Hardship Exemption option
#    Then I select "No" for Disability option
#    Then I select "No" to the recently denied medicaid question
#    Then I select "No" for Incarceration option
#    Then I click continue on the Add Address page
#    And I select "Prefer not to answer" for race and ethnicity for "Primary"
#    And I click continue on the Race and Ethnicity page
#    Then I validate I am on the "Citizenship" page
#    Then I select "Yes" for Citizen option
#    Then I select "No" for Naturalized Immigrant option
#    Then I click continue on the Citizenship page
#    Then I validate I am on the "Family Overview" page
#    Then I verify the family overview table is present
#    # Below is specific case context: user has another member with tribal status
#    Then I click Add Another Family Member
#    Then I validate I am on the "Add Member" page
#    Then I enter member details with "01/01/1985" date of birth
#    And I select "Female" as member's sex option
#    And I mark the Additional member is pregnant as "No"
#    And I select "Spouse" as relationship option
#    And I select "Yes" to Is Member Applying
#    And I click continue on Tell us about additional members page
#    Then I validate I am on the "Add Address" page
#    Then I select "Household" for Residential Address
#    Then I select "Yes" for CO Resident option
#    Then I select "Yes" for Federally Recognized Tribe option
#    Then I add the tribe details
#    Then I select "No" for Hardship Exemption option
#    Then I select "No" for Disability option
#    Then I select "No" to the recently denied medicaid question
#    Then I select "No" for Incarceration option
#    Then I click continue on the Add Address page
#    And I select "Prefer not to answer" for race and ethnicity for "Primary"
#    And I click continue on the Race and Ethnicity page
#    Then I validate I am on the "Citizenship" page
#    Then I select "Yes" for Citizen option
#    Then I select "No" for Naturalized Immigrant option
#    Then I click continue on the Citizenship page
#    Then I validate I am on the "Family Overview" page
#    Then I verify the family overview table is present
#    Then I click continue on family overview page
#
#    # Financial help
#    Then I validate I am on the "Financial Help" page
#    And I Apply for financial help
#    Then I validate I am on the "Employment Info" page
#    Then I select the option "Yes" to employment
#    And I select the option "No" to self employment
#    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2400000" at frequency "Annually"
#    And I select the option "No" to seasonal employment
#    And I select the option "No" to projected income
#    And I click continue on the Employment Info Page
#    Then I validate I am on the "Employment Summary" page
#    Then I click continue on the Employment Summary Page
#    Then I validate I am on the "Additional income" page
#    And I click None of these as additional income option and continue
#    Then I validate I am on the "Deductions" page
#    Then I click None of these as deduction option and continue
#    Then I validate I am on the "Income Summary" page
#    Then I select the projected income option "No" and continue
#    Then I validate I am on the "Employment Info" page
#    Then I select the option "Yes" to employment
#    And I select the option "No" to self employment
#    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "3200000" at frequency "Annually"
#    And I select the option "No" to seasonal employment
#    And I select the option "No" to projected income
#    And I click continue on the Employment Info Page
#    Then I validate I am on the "Employment Summary" page
#    Then I click continue on the Employment Summary Page
#    Then I validate I am on the "Additional income" page
#    And I click None of these as additional income option and continue
#    Then I validate I am on the "Deductions" page
#    Then I click None of these as deduction option and continue
#    Then I validate I am on the "Income Summary" page
#    Then I select the projected income option "No" and continue
#    Then I validate I am on the "Tax status" page
#    And I select the option "No" to claim as dependent
#    And I select the option "Yes" to file federal income tax return next year
#    And I select "Married filing jointly" tax filing status
#    And I select spouse to file taxes jointly
#    And I select "No" to claim dependents
#    And I click save and continue on tax status page
#
#    # Health coverage and life change information
#    Then I validate I am on the "Elmo Other Health Coverage" page
#    Then I select "None of these" as ELMO health coverage option
#    Then I click continue on the ELMO health coverage page
#    Then I validate I am on the "Elmo Other Health Coverage" page
#    Then I select "None of these" as ELMO health coverage option
#    Then I click continue on the ELMO health coverage page
#    Then I validate I am on the "Family Overview" page
#    Then I verify the family overview table is present
#    Then I click continue on family overview page
#    Then I validate I am on the "Tell us about life changes" page
#    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
#    Then I click on Save and Continue
#
#    # Declarations and signature
#    Then I validate I am on the "EXCH Declarations and Signature" page
#    And I Declare as Tax Household 1
#    Then I click Continue on the Declarations And Signature Page
#
#    # Review application results
#    Then I validate I am on the "Application History" page
#    Then I click on view results and shop
#    Then I validate I am on the "Application Results" page
#    Then I click on My Account in the "NonElmo" Header
#
#    # Check Email notice
#    Then I validate I am on the "My Account Overview" page
#    Then I open outlook Tab
#    And I sign in to outlook with Valid Credentials "mf_test_@outlook.com" and "ALaska12!"
#    Then I open the notice "Los resultados de su solicitud" in "Spanish"
#    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
#    Then I delete the open notice
#    And I sign out of Outlook
#    And I switch to the tab number 0
#
#    # Check My Documents notice
#    Then I validate I am on the "My Account Overview" page
#    Then I click on ClickHere link for "My Documents"
#    Then I validate I am on the "My Documents" page
#    Then I validate the notice "Application Results" exist in my document letter Containers
#    And I click on download "Application Results" document
#    Then I validate "Application Results": "ANAI" notice in "Spanish" for "2" members
#    And I click on Sign Out in the Header for "Elmo"