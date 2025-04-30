@TAM @TamExch
Feature: Page Validation-Income Summary Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
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
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page

  @SLER-2343
  Scenario: SLER-2343 As an Exchange user on the ELMO Income page, I want an error cleared on the Income Summary page so that I don't see the  error when I answer yes to the projected income question(RT-2709)
    Then I click the save and continue button on the Income Summary Detail page
    And I verify the active error message as "Please select one of the options below"
    Then I select the projected income option as "Yes"
    Then I verify no error is displayed on the Income Summary page
    Then I click the save and continue button on the Income Summary Detail page
    And I verify the active error message as "Amount is required"
    Then I enter the projected income amount as "150.00"
    Then I verify no error is displayed on the Income Summary page
    Then I click on Go Back on income summary page
    And I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I click the save and continue button on the Income Summary Detail page
    And I verify the active error message as "Seleccione una de las siguientes opciones"
    Then I select the projected income option as "Yes"
    Then I verify no error is displayed on the Income Summary page
    Then I click the save and continue button on the Income Summary Detail page
    And I verify the active error message as "Esta cantidad es obligatoria"
    Then I enter the projected income amount as "150.00"
    Then I verify no error is displayed on the Income Summary page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2353
  Scenario: SLER-2353 Automate navigation on the ELMO Income Summary Page in EXCH
    And I validate I am on the "Employment Summary" page
    Then I click on Go Back on income summary page
    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    And I validate I am on the "Employment Summary" page
    And I click on the edit Income Summary page

    And I validate I am on the "Employment Income" page
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    And I validate I am on the "Employment Summary" page

    And I click on the edit Deductions on Income Summary page
    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    And I validate I am on the "Employment Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    Then I click Go back on Tax Status page
    And I validate I am on the "Family Overview" page

    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    And I validate I am on the "Employment Summary" page
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | www.instagram.com | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.com                           |
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I validate I am on the "Income Summary" page


    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    And I validate I am on the "Employment Summary" page

    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    And I validate I am on the "Employment Summary" page

    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    And I validate I am on the "Employment Summary" page

    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab
    Then I validate I am on the "Income Summary" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "ExpertHelp" Header

    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    And I validate I am on the "Employment Summary" page

    Then I validate I am on the "Additional income" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    And I click on the Username in the "Exch" Header
    Then I validate I am on the "My Profile" page

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    And I validate I am on the "Employment Summary" page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I click on Sign Out in the Header for "Elmo"

  @SLER-2348
  Scenario: SLER-2348 As an Exchange user,I want to see my Income and Deductions so that I can review my financial information
    Then I verify page Header text in income summary page
    Then I validate font colour height and format of text in income summary page
    And I click on Go Back on income summary page
    When I click on Go Back button in deductions page
    And I select "Cash Support" as additional income option with "45.02" amount at "Annually" frequency
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I verify added income name "Cash Support" and amount "$45.02" in income summary page
    When I click on "edit_income_button" in income summary page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 park street" and city as "Denver" and state as "CO" and zipcode as "80205" and income "1250000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I validate income amounts "$12,500.00" and "$45.02" in income summary page
    When I click on "edit_income_button" in income summary page
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "102 park street" and city as "Denver" and state as "CO" and zipcode as "80205" and income "1842500" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I validate income amounts "$12,500.00" "$18,425.00" and "$45.02" in income summary page
    When I click on "edit_deductions_button" in income summary page
    And I select "Alimony" as deduction option with "485.00" amount at "Annually" frequency
    And I click continue on the Deductions page
    Then I validate deduction amount "$485.00" along with income amounts "$12,500.00" "$18,425.00" and "$45.02"
    Then I validate income and deduction calculations
    And I click on Go Back on income summary page
    When I click on Go Back button in deductions page
    Then I click on the Back button on the Additionalincomepage
    When I click on Go Back button in employment summary page
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "09051959", "Female" and applying "No"
      |Primary:Spouse|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Spouse"
    And I click the edit income icon on household page for "Spouse"
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    And I select None of these as additional income option
    And I click continue on the Additional Income page
    And I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I verify spouse name in income summary page
    Then I validate font colour height and format of text in income summary page

  @SLER-2358
  Scenario: SLER-2358 As an Exchange user, I want to see the total annual income and projected income so that it will be used in determining eligibility[RT-2603]
    Then I verify projected income question has not been answered
    Then I verify font colour text of Total annual income
    When I click on "edit_income_button" in income summary page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 park street" and city as "Denver" and state as "CO" and zipcode as "80205" and income "1250000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I click continue on the Employment Summary Page
    And I select "Cash Support" as additional income option with "512.00" amount at "Annually" frequency
    And I click continue on the Additional Income page
    And I select "Alimony" as deduction option with "485.00" amount at "Annually" frequency
    And I click continue on the Deductions page
    Then I verify total annual income amount "$12,527.00" in income summary page
    Then I select the projected income option as "Yes"
    Then I enter the projected income amount as "15200.00"
    Then I validate entered project income amount is "15,200.00"
    When I click on "edit_deductions_button" in income summary page
    Then I click "AOSS" as deduction option only
    And I select "School tuition" as deduction option with "13012.00" amount at "Annually" frequency
    And I click continue on the Deductions page
    Then I verify font colour text of Total annual income
    Then I verify projected income question has not been answered
    When I click on "edit_deductions_button" in income summary page
    Then I click "STAF" as deduction option only
    And I select "Moving expenses" as deduction option with "18000.00" amount at "Annually" frequency
    And I click continue on the Deductions page
    Then I verify total annual income amount "-$4,988.00" in income summary page













