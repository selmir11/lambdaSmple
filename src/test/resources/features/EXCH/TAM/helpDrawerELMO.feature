@TAM @helpDrawer
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
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help

  @SLER-60
    #fails when run on small screens (Let's chat widget covers up help drawer footer)
  Scenario: SLER-60 Validate help drawer text on the ELMO Employment Income Details page
    And I set the browser resolution to 2000 x 800
    Then I validate I am on the "Employment Income" page
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

  @SLER-61
    #fails when run on small screens (Let's chat widget covers up help drawer footer)
  Scenario: SLER-61 Validate help drawer text on the ELMO Employment Income Details page (self-employment)
    And I set the browser resolution to 2000 x 800
    Then I validate I am on the "Employment Income" page
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

  @SLER-156
    #fails when run on small screens (Let's chat widget covers up help drawer footer)
  Scenario: SLER-156 Validate help drawer text on the ELMO ESI page - English
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "5160000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "job" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page

    And I set the browser resolution to 2000 x 800
    Then I validate I am on the "ESI" page
    And I verify the Help Drawer is "Closed English" on the ESI page
    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Main" text in "English" on the ESI page
    Then I click on "Employer Coverage Tool 1" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 2" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 3" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed English" on the ESI page
    Then I open or close the "Header" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Main" text in "English" on the ESI page
    Then I click on "Employer Coverage Tool 1" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 2" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 3" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Header" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed English" on the ESI page
    Then I open or close the "Which job" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Which job" text in "English" on the ESI page
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Which job" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed English" on the ESI page
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I open or close the "Minimum Value" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Minimum Value" text in "English" on the ESI page
    Then I click on "Employer Coverage Tool 1" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    And I set the browser resolution to Maximized
    Then I click on "Employer Coverage Tool 3" link in Help Drawer on the ESI page
    And I set the browser resolution to 2000 x 800
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Minimum Value" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed English" on the ESI page
    Then I open or close the "Help Me Understand" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    Then I open or close the Help Drawer on the ESI page
    Then I open or close the "Monthly Amount" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Monthly Amount" text in "English" on the ESI page
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Monthly Amount" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed English" on the ESI page
    Then I open or close the "Currently Enrolled" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Currently Enrolled" text in "English" on the ESI page
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Currently Enrolled" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed English" on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I open or close the "End in 60 days" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "End in 60 days" text in "English" on the ESI page
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "End in 60 days" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed English" on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I open or close the "Voluntarily Ending" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Voluntarily Ending" text in "English" on the ESI page
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Voluntarily Ending" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed English" on the ESI page

    And I click on Sign Out in the Header for "Elmo"


  @SLER-199 @TAMSmoke
    #fails when run on small screens (Let's chat widget covers up help drawer footer)
  Scenario: SLER-199 Validate help drawer text on the ELMO ESI page - Spanish
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "5160000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "job" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page

#    And I set the browser resolution to 2000 x 800
    Then I validate I am on the "ESI" page
    And I change the language from header to "Spanish"
    And I verify the Help Drawer is "Closed Spanish" on the ESI page
    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Main" text in "Spanish" on the ESI page
    Then I click on "Employer Coverage Tool 1" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 2 Spanish" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 3" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed Spanish" on the ESI page
    Then I open or close the "Header" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Main" text in "Spanish" on the ESI page
    Then I click on "Employer Coverage Tool 1" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 2 Spanish" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 3" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Header" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed Spanish" on the ESI page
    Then I open or close the "Which job" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Which job" text in "Spanish" on the ESI page
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Which job" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed Spanish" on the ESI page
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I open or close the "Minimum Value" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Minimum Value" text in "Spanish" on the ESI page
    Then I click on "Employer Coverage Tool 1 Spanish Min Val" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 3" link in Help Drawer on the ESI page
    Then I open or close the "Minimum Value" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed Spanish" on the ESI page
    Then I open or close the "Monthly Amount" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Monthly Amount" text in "Spanish" on the ESI page
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Monthly Amount" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed Spanish" on the ESI page
    Then I open or close the "Currently Enrolled" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Currently Enrolled" text in "Spanish" on the ESI page
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Currently Enrolled" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed Spanish" on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I open or close the "End in 60 days" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "End in 60 days" text in "Spanish" on the ESI page
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "End in 60 days" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed Spanish" on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I open or close the "Voluntarily Ending" Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Voluntarily Ending" text in "Spanish" on the ESI page
    Then I click on "Contact Us" link in Help Drawer on the ESI page
    And I validate I am on the "We Can Help" page and close tab
    Then I open or close the "Voluntarily Ending" Help Drawer on the ESI page
#    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Closed Spanish" on the ESI page

    And I click on Sign Out in the Header for "Elmo"




