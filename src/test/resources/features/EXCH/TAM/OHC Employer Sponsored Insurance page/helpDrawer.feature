@TAM @TamExch @helpDrawerESI
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "job" as health coverage option
    Then I click continue on the health coverage page

    And I set the browser resolution to 1536 x 864
    Then I validate I am on the "Ohc ESI" page

  @SLER-156
    #fails when run on small screens (Let's chat widget covers up help drawer footer)
  Scenario: SLER-156 Validate help drawer text on the ELMO ESI page - English
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
    #And I set the browser resolution to 2000 x 800
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


  @SLER-199 @TAMSmokeExch
    #fails when run on small screens (Let's chat widget covers up help drawer footer)
  Scenario: SLER-199 Validate help drawer text on the ELMO ESI page - Spanish
    And I change the language from header to "Spanish"
    And I verify the Help Drawer is "Closed Spanish" on the ESI page
    Then I open or close the Help Drawer on the ESI page
    And I verify the Help Drawer is "Open" on the ESI page
    And I verify the Help Drawer "Main" text in "Spanish" on the ESI page
    Then I click on "Employer Coverage Tool 1" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 2" link in Help Drawer on the ESI page
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
    Then I click on "Employer Coverage Tool 2" link in Help Drawer on the ESI page
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
    Then I click on "Employer Coverage Tool 1" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
    Then I click on "Employer Coverage Tool 3" link in Help Drawer on the ESI page
    And I validate I am on the "Employer Coverage" page and close tab
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




