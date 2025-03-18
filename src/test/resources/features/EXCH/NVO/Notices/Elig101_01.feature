@NVO @NVOPDF
Feature: Eligibility 101-01 Notices

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "pdfNotices"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page

  @SLER-919
  Scenario: Not Eligible; Didn't Apply; 1 person

    # EMAIL check
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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


    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    Then I click on download "Application Results" document
    Then I validate "ELIG-001-01 English" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-954
  Scenario: Not Eligible; Not a CO Resident; 1 person

    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    And I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 NO CO RES English" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-962
  Scenario: MA, QHP Eligible; 1 person

    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 MA QHP English" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-959
  Scenario: APTC, CSR, QHP Eligible; Lost Insurance; 1 person

    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#
    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 QHP English" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-960
  Scenario: APTC, CSR, QHP Eligible; Gain of Tribal Status; 1 person
    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
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
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2400000" at frequency "Annually"
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 Gain of Tribal Status English 1" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-961
  Scenario: APTC, CSR, QHP Eligible; Gain of Tribal Status; 2 person
    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
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
    # Below is specific case context: user has another member with tribal status
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011980", "Female" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    Then I select "Yes" for CO Resident option
    Then I select "Yes" for Federally Recognized Tribe option
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
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
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2400000" at frequency "Annually"
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
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "3200000" at frequency "Annually"
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 Gain of Tribal Status English 2" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-987
  Scenario: Not Eligible; Didn't Apply; 1 person; ES

    # EMAIL check
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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


    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    Then I click on download "Application Results" document
    Then I validate "ELIG-001-01 Spanish" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-988
  Scenario: Not Eligible; Not a CO Resident; 1 person; ES

    # EMAIL CHECK
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    And I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 NO CO RES Spanish" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-992
  Scenario: MA, QHP Eligible; 1 person; ES

    # EMAIL CHECK
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 MA QHP Spanish" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-989
  Scenario: APTC, CSR, QHP Eligible; Lost Insurance; 1 person; ES

    # EMAIL CHECK
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#
    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 QHP Spanish" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-990
  Scenario: APTC, CSR, QHP Eligible; Gain of Tribal Status; 1 person; ES

    # EMAIL CHECK
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
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
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2400000" at frequency "Annually"
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 Gain of Tribal Status Spanish 1" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-991
  Scenario: APTC, CSR, QHP Eligible; Gain of Tribal Status; 2 person; ES

    # EMAIL CHECK
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
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
    # Below is specific case context: user has another member with tribal status
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011980", "Female" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    Then I select "Yes" for CO Resident option
    Then I select "Yes" for Federally Recognized Tribe option
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
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
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2400000" at frequency "Annually"
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
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "3200000" at frequency "Annually"
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 Gain of Tribal Status Spanish 2" notice content
    And I click on Sign Out in the Header for "Elmo"

#    Mail

  @SLER-1071
  Scenario: Not Eligible; Didn't Apply; 1 person; MAIL

    # EMAIL check
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

         # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my own
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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


    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    Then I click on download "Application Results" document
    Then I validate "ELIG-001-01 English Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-1072
  Scenario: Not Eligible; Not a CO Resident; 1 person; MAIL

    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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

         # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my ow
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    And I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 NO CO RES English Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-1073
  Scenario: MA, QHP Eligible; 1 person; MAIL

    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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

         # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my own
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 MA QHP English Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-1074
  Scenario: APTC, CSR, QHP Eligible; Lost Insurance; 1 person; MAIL

    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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

         # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my own
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#
    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 QHP English Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-1076
  Scenario: APTC, CSR, QHP Eligible; Gain of Tribal Status; 1 person; MAIL
    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

         # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my own
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
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
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2400000" at frequency "Annually"
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 Gain of Tribal Status English 1 Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-1078
  Scenario: APTC, CSR, QHP Eligible; Gain of Tribal Status; 2 person; MAIL
    # EMAIL CHECK
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

         # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my own
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    # Below is specific case context: user has another member with tribal status
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011980", "Female" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    Then I select "Yes" for CO Resident option
    Then I select "Yes" for Federally Recognized Tribe option
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
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
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2400000" at frequency "Annually"
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
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "3200000" at frequency "Annually"
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 Gain of Tribal Status English 2 Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-1079
  Scenario: Not Eligible; Didn't Apply; 1 person; ES; MAIL

    # EMAIL check
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page


    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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


    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    Then I click on download "Application Results" document
    Then I validate "ELIG-001-01 Spanish Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-1080
  Scenario: Not Eligible; Not a CO Resident; 1 person; ES; MAIL

    # EMAIL CHECK
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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

          # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my own
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    And I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 NO CO RES Spanish Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-993
  Scenario: MA, QHP Eligible; 1 person; ES; MAIL

    # EMAIL CHECK
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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

          # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my own
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 MA QHP Spanish Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-1081
  Scenario: APTC, CSR, QHP Eligible; Lost Insurance; 1 person; ES; MAIL

    # EMAIL CHECK
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
          # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my own
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
#
    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 QHP Spanish Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-1082
  Scenario: APTC, CSR, QHP Eligible; Gain of Tribal Status; 1 person; ES; MAIL

    # EMAIL CHECK
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header

    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
          # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my own
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
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
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2400000" at frequency "Annually"
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 Gain of Tribal Status Spanish 1 Mail" notice content
    And I click on Sign Out in the Header for "Elmo"

  @SLER-1083
  Scenario: APTC, CSR, QHP Eligible; Gain of Tribal Status; 2 person; ES; MAIL

    # EMAIL CHECK
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on My Account in the "Elmo" Header
    # Apply for current year
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
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
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

          # Change preference to mail
    And I click on the Username in the "Exch NonElmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    Then I change the Preferred Contact Method to "Mail"
    And I click on Save Button
    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page

    # Reapply again
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Continue on my own
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    # Below is specific case context: user has another member with tribal status
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011980", "Female" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    Then I select "Yes" for CO Resident option
    Then I select "Yes" for Federally Recognized Tribe option
    Then I add the tribe details state as "Colorado" and tribe name as "Southern Ute Indian Tribe of the Southern Ute Reservation"
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
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2400000" at frequency "Annually"
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
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "3200000" at frequency "Annually"
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    # Health coverage and life change information
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
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

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "ELIG-001-01 Gain of Tribal Status Spanish 2 Mail" notice content
    And I click on Sign Out in the Header for "Elmo"