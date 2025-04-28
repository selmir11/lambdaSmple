Feature: Elig101-01 - Elig Notices

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "MGC4testing"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page


  @SLER-2351
  Scenario: SLER-2351 ELG-101-01 APTC eligibility 1 member English
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "4800000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Eligibile: APTC" notice in "English" for "1" members
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-2357
  Scenario: SLER-2357 ELIG-Notice ELG-101-01 APTC eligibility 1 member Spanish
    And I click on the Username in the "Exch NonElmo" Header
    And I validate I am on the "My Profile" page
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on Apply for Coverage in the "Elmo" Header

    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "4800000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Eligibile: APTC" notice in "Spanish" for "1" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "resultados de su solicitu" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-2373
  Scenario: SLER-2373 ELIG-Notice ELG-101-01 APTC eligibility 2 members English
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011980", "Female" and applying "Yes"
      | Primary:Spouse |
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
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "3000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "2500000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click "No" on Before you continue popup on the application history page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Eligibile: APTC" notice in "English" for "2" members
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-2426
  Scenario: SLER-2426 ELIG-Notice ELG-101-01 APTC eligibility 2 members Spanish
    And I click on the Username in the "Exch NonElmo" Header
    And I validate I am on the "My Profile" page
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on Apply for Coverage in the "Elmo" Header

    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011980", "Female" and applying "Yes"
      | Primary:Spouse |
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
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "3000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "2500000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click "No" on Before you continue popup on the application history page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Eligibile: APTC" notice in "Spanish" for "2" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "resultados de su solicitu" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-2422
  Scenario: ELIG-101-01- 1 member Income MVR valid SEP [RT-2959] - English
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "48000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "No Cost Sharing Reduction" notice in "English" for "1" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-2437
  Scenario: ELIG-Elig101-01- 1 member Income MVR valid SEP - RT-2959 - Spanish
    And I click on the Username in the "Exch NonElmo" Header
    And I validate I am on the "My Profile" page
    And I click on Make Changes Button
    And I change Preferred Language Contact Method to "Spanish"
    And I click on Save Button
    And I click on Apply for Coverage in the "Elmo" Header

    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "No Cost Sharing Reduction" notice in "Spanish" for "1" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

    @SLER-2440
    Scenario: ELIG-Elig101-01- 1 member Death MVR valid SEP [RT-2969]
      Then I apply for the current year
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button
      Then I click on continue with  application button on Before you begin page
      And I report "Birth" and click continue
      Then I select "member" from the who are you question
      And I am a member with SSN "" City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
      Then I answer all Id proofing questions and click continue
      And I click continue button on Congratulations page
      Then I validate I am on the "Find Expert Help Exch" page
      Then I click Continue on my own button from Manage who helps you page
      Then I select "Male" as sex option
      And I select "Yes" to Are You Applying
      And I update DOB to new DOB of "01011985"
      Then I update SSN number to new SSN number "345456789"
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
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page
      Then I click continue on family overview page
      Then I validate I am on the "Financial Help" page
      And I Apply for financial help
      Then I select the option "Yes" to employment
      And I select the option "No" to self employment
      And I enter employment details with "480000" income at "Annually" frequency
      And I select the option "No" to seasonal employment
      And I select the option "No" to projected income
      And I click continue on the Employment Info Page
      Then I click continue on the Employment Summary Page
      Then I click None of these as additional income option and continue
      Then I validate I am on the "Deductions" page
      Then I click None of these as deduction option and continue
      Then I select the projected income option "No" and continue
      Then I select "No" for will you be claimed as dependent question
      Then I select "Yes" for will file tax return question
      Then I select the "Single" tax filing option on the Tax Status page
      Then I select "No" for will claim dependents question
      Then I click Save and Continue on Tax Status page
      Then I validate I am on the "Other Health Coverage" page
      Then I select "None of these" as health coverage option
      Then I click continue on the health coverage page
      Then I click continue on family overview page
      Then I select "LostCoverage" QLCE on tell us about life changes page
      Then I click on Save and Continue
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear
      Then I validate I am on the "Application History" page
      And I click on Apply for Coverage in the "NonElmo" Header

      Then I validate I am on the "My Account Overview" page
      Then I click on ClickHere link for "My Documents"
      Then I validate I am on the "My Documents" page
      Then I validate the notice "Application Results" exist in my document letter Containers
      Then I click on download "Application Results" document
      Then I validate "ELIG-001-01 MVR English 1" notice content
      And I click on Sign Out in the Header for "Elmo"

  @SLER-2438
  Scenario: SLER-2438 Elig101-01- 1 member AI/AN MVR valid SEP English
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "4500000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    Then I click on download "Application Results" document
    Then I validate "ELIG-001-01 AIAN MVR Valid SEP English 1" notice content

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"


  @SLER-2469
  Scenario: SLER-2469 Elig101-01- 1 member Income MVR valid No SEP
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "9000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "NoneOfThese" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page

    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    Then I click on download "Application Results" document
    Then I validate "ELIG-001-01 MVR valid No SEP English 1" notice content

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

    
    @SLER-2460
  Scenario: Elig101-01- 1 member Incarcerated MVR valid SEP [RT-2970]
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with SSN "" City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I update DOB to new DOB of "01011985"
    Then I update SSN number to new SSN number "456567890"
    And I click continue on Tell us about yourself page
    Then I enter member with address line1 "1234 Street" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "IncarceratedMVRAutomationTest"
    Then I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "500000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    Then I click on download "Application Results" document
    Then I validate "ELIG-001-01 Incarcerated MVR valid SEP 1" notice content

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

 @SLER-2468
  Scenario: Elig101-01- 1 member Immigration MVR valid SEP [RT-2967]
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with SSN "" City "Denver" in State "CO" with dob "01011985" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I update DOB to new DOB of "01011985"
    Then I update SSN number to new SSN number "345456789"
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
    And I enter employment details with "3900000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "NoneOfThese" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    Then I validate the notice "Application Results" exist in my document letter Containers
    Then I click on download "Application Results" document
    Then I validate "ELIG-001-01 Immigration MVR English 1" notice content

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"
