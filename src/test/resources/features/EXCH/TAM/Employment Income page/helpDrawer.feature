@TAM @TamExch @helpDrawerEmploymentIncome
Feature: Tests related to the help drawer on ELMO pages

  Background: I go the login portal
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    Then I select "Yes" to Are You Applying
    Then I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    Then I select "Yes" for CO Resident option
    Then I select "No" for Federally Recognized Tribe option
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I validate I am on the "Employment Income" page
    And I set the browser resolution to 1536 x 864

  @SLER-60
    #fails when run on small screens (Let's chat widget covers up help drawer footer)
  Scenario: SLER-60 Validate help drawer text on the ELMO Employment Income Details page
    And I change the language from header to "English"
    Then I select the option "Yes" to employment
    And I select "General help" icon on the Employment Info Page
    Then I validate help drawer header verbiage in "English"
    Then I validate general help drawer body verbiage in "English"
    Then I validate help drawer footer verbiage in "English"
    And I click Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I change the language from header to "Spanish"
    And I select "General help" icon on the Employment Info Page
    Then I validate help drawer header verbiage in "Spanish"
    Then I validate general help drawer body verbiage in "Spanish"
    Then I validate help drawer footer verbiage in "Spanish"
    And I click Contact Us link in help drawer footer
    And I validate I am on the "Podemos ayudar" page and close tab
    And I select "Do you have job" icon on the Employment Info Page
    Then I validate job question verbiage in "Spanish"
    And I change the language from header to "English"
    And I select "General help" icon on the Employment Info Page
    Then I validate job question verbiage in "English"
    And I select "Is it self-employment" icon on the Employment Info Page
    Then I validate job question verbiage in "English job"
    And I change the language from header to "Spanish"
    And I select "Is it self-employment" icon on the Employment Info Page
    Then I validate job question verbiage in "Spanish"

    And I click on Sign Out in the Header for "Elmo"

  @SLER-61
    #fails when run on small screens (Let's chat widget covers up help drawer footer)
  Scenario: SLER-61 Validate help drawer text on the ELMO Employment Income Details page (self-employment)
    And I change the language from header to "English"
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    And I select "Company Name" icon on the Employment Info Page
    Then I validate Company verbiage in "English"
    And I change the language from header to "Spanish"
    And I select "Company Name" icon on the Employment Info Page
    Then I validate Company verbiage in "Spanish"
    And I select "Net Income" icon on the Employment Info Page
    Then I validate Net Income verbiage in "Spanish"
    And I change the language from header to "English"
    And I select "Net Income" icon on the Employment Info Page
    Then I validate Net Income verbiage in "English"
    And I select "Income Change" icon on the Employment Info Page
    Then I validate Income Change verbiage in "English"
    And I change the language from header to "Spanish"
    And I select "Income Change" icon on the Employment Info Page
    Then I validate Income Change verbiage in "Spanish"

    And I click on Sign Out in the Header for "Elmo"

  @SLER-859
    #fails when run on small screens (Let's chat widget covers up help drawer footer)
  Scenario: SLER-859 Validate help drawer text on the ELMO Employment Income Details page (job employment)
    And I change the language from header to "English"
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I select "Company Name" icon on the Employment Info Page
    Then I validate Company verbiage in "English"
    And I change the language from header to "Spanish"
    And I select "Company Name" icon on the Employment Info Page
    Then I validate Company verbiage in "Spanish"
    #Commented out the steps below due to bug ticket TAM-5424
    #And I select "Address 1" icon on the Employment Info Page
    #Then I validate Address 1 verbiage in "Spanish"
    #And I change the language from header to "English"
    #And I select "Address 1" icon on the Employment Info Page
    #Then I validate Address 1 verbiage in "English"
    #And I select "Address 2" icon on the Employment Info Page
    #Then I validate Address 1 verbiage in "English"
    #And I change the language from header to "Spanish"
    #And I select "Address 2" icon on the Employment Info Page
    #Then I validate Address 1 verbiage in "Spanish"
    #And I select "City" icon on the Employment Info Page
    #Then I validate Address 1 verbiage in "Spanish"
    #And I change the language from header to "English"
    #And I select "City" icon on the Employment Info Page
    #Then I validate Address 1 verbiage in "English"
    #And I select "State" icon on the Employment Info Page
    #Then I validate Address 1 verbiage in "English"
    #And I change the language from header to "Spanish"
    #And I select "State" icon on the Employment Info Page
    #Then I validate Address 1 verbiage in "Spanish"
    #And I select "Zip" icon on the Employment Info Page
    #Then I validate Address 1 verbiage in "Spanish"
    And I change the language from header to "English"
    #And I select "Zip" icon on the Employment Info Page
    #Then I validate Address 1 verbiage in "English"
    And I select "Gross Income" icon on the Employment Info Page
    Then I validate Gross Income verbiage in "English"
    And I change the language from header to "Spanish"
    And I select "Gross Income" icon on the Employment Info Page
    Then I validate Gross Income verbiage in "Spanish"
    And I select "Seasonal" icon on the Employment Info Page
    Then I validate Seasonal verbiage in "Spanish"
    And I change the language from header to "English"
    And I select "Seasonal" icon on the Employment Info Page
    Then I validate Seasonal verbiage in "English"
    And I select "Job Income Change" icon on the Employment Info Page
    Then I validate Income Change verbiage in "English"
    And I change the language from header to "Spanish"
    And I select "Job Income Change" icon on the Employment Info Page
    Then I validate Income Change verbiage in "Spanish"

    And I click on Sign Out in the Header for "Elmo"

