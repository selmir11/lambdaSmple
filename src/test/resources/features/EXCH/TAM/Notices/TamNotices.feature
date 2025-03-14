@TAM @TamPdf @TAMSmokePDF
Feature: Elig101-01 - TAM Notices

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "MGC4testing"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page

  @SLER-535
  Scenario: SLER-535 Elig101-01- 1 member Not Eligible for APTC and CSR due to Health First Colorado - English
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
    And I enter employment details with "2000000" income at "Annually" frequency
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
    Then I select "Health First Colorado" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Health First Colorado" notice in "English" for "1" members
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"



  @SLER-699
  Scenario: SLER-699 Elig101-01- 1 member Not Eligible for APTC and CSR due to Health First Colorado - Spanish
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
    And I enter employment details with "2000000" income at "Annually" frequency
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
    Then I select "Health First Colorado" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Health First Colorado" notice in "Spanish" for "1" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "resultados de su solicitu" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-733
  Scenario: SLER-733 Elig101-01- 2 members Not Eligible for APTC and CSR due to Health First Colorado - English
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
    And I enter employment details with "2400000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "Health First Colorado" as health coverage option
    Then I click continue on the health coverage page
    Then I select "Health First Colorado" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Health First Colorado" notice in "English" for "2" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-738
  Scenario: SLER-738 Elig101-01- 2 members Not Eligible for APTC and CSR due to Health First Colorado - Spanish
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
    And I enter employment details with "2400000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "Health First Colorado" as health coverage option
    Then I click continue on the health coverage page
    Then I select "Health First Colorado" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "Health First Colorado" notice in "Spanish" for "2" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "resultados de su solicitu" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"


  @SLER-744
  Scenario: SLER-744 Elig101-01- 2 members Not Eligible for APTC and CSR due to CHP+ - English
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
    And I enter employment details with "2400000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
    Then I select "CHP+" as health coverage option
    Then I click continue on the health coverage page
    Then I select "CHP+" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "CHP" notice in "English" for "2" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"


  @SLER-745
  Scenario: SLER-745 Elig101-01- 2 members Not Eligible for APTC and CSR due to CHP+ - Spanish
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
    And I enter employment details with "2400000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
    Then I select "CHP+" as health coverage option
    Then I click continue on the health coverage page
    Then I select "CHP+" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I click on ClickHere link for "My Documents"
    Then I validate the notice "Application Results" exist in my document letter Containers
    And I click on download "Application Results" document
    Then I validate "Application Results": "CHP" notice in "Spanish" for "2" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "resultados de su solicitu" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-742
  Scenario: SLER-742 Elig101-01- 1 member Not Eligible for APTC and CSR due to Cobra - English
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
    And I enter employment details with "7000000" income at "Annually" frequency
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
    Then I select "COBRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc COBRA" page
    Then I click "Yes" for currently enrolled in COBRA question
    Then I click "No" for insurance ending in 60 days in COBRA question
    Then I click continue on the OHC Cobra page
    Then I click continue on family overview page
    Then I select "LostCoverage" QLCE on tell us about life changes page
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
    Then I validate "Application Results": "Cobra" notice in "English" for "1" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-743
  Scenario: SLER-743 Elig101-01- 1 member Not Eligible for APTC and CSR due to Cobra - Spanish
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
    And I enter employment details with "7000000" income at "Annually" frequency
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
    Then I select "COBRA" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc COBRA" page
    Then I click "Yes" for currently enrolled in COBRA question
    Then I click "No" for insurance ending in 60 days in COBRA question
    Then I click continue on the OHC Cobra page
    Then I click continue on family overview page
    Then I select "LostCoverage" QLCE on tell us about life changes page
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
    Then I validate "Application Results": "Cobra" notice in "Spanish" for "1" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "resultados de su solicitu" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-785
  Scenario: SLER-785 Elig101-01- 1 member Not Eligible for APTC and CSR due to Individucal Insurance - English
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
    And I select the option "Yes" to self employment
    And I enter self-employment details with "54000.00" income at "Annually" frequency and "Yes" to same or lower
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
    Then I select "Other" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc Individual Insurance" page
    Then I click "Yes" for currently enrolled in Individual Insurance question
    Then I click "No" for insurance ending in 60 days in Individual Insurance question
    Then I click continue on the OHC Individual Insurance page
    Then I click continue on family overview page
    Then I select "LostCoverage" QLCE on tell us about life changes page
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
    Then I validate "Application Results": "Individual Insurance" notice in "English" for "1" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "Application Results" in "English"
    And I verify the notice Text for "ELG-101-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"

  @SLER-786
  Scenario: SLER-786 Elig101-01- 1 member Not Eligible for APTC and CSR due to Individucal Insurance - Spanish
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
    And I select the option "Yes" to self employment
    And I enter self-employment details with "54000.00" income at "Annually" frequency and "Yes" to same or lower
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
    Then I select "Other" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc Individual Insurance" page
    Then I click "Yes" for currently enrolled in Individual Insurance question
    Then I click "No" for insurance ending in 60 days in Individual Insurance question
    Then I click continue on the OHC Individual Insurance page
    Then I click continue on family overview page
    Then I select "LostCoverage" QLCE on tell us about life changes page
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
    Then I validate "Application Results": "Individual Insurance" notice in "Spanish" for "1" members

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "resultados de su solicitu" in "Spanish"
    And I verify the notice Text for "ELG-101-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    And I click on Sign Out in the Header for "Elmo"