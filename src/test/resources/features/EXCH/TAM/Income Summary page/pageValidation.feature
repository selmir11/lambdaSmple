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
    Then I select the projected income option as "Sí"
    Then I verify no error is displayed on the Income Summary page
    Then I click the save and continue button on the Income Summary Detail page
    And I verify the active error message as "Esta cantidad es obligatoria"
    Then I enter the projected income amount as "150.00"
    Then I verify no error is displayed on the Income Summary page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2353
  Scenario: RT-2583[ Automate navigation on the ELMO Income Summary Page in EXCH]
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
      | InstagramIcon  | Instagram         | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.net                           |
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














