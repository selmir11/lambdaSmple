@TAM @TamExch
Feature: Page Text-Income Opt Out Page

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
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "4500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    And I wait for 15 milliseconds
    And I set the browser resolution to 1536 x 864
    And I verify the header for Primary Member on the Employment Summary page in "English"

  @SLER-920 @HelpDrawerEmploymentSummaryPage
  Scenario: SLER-920 Validate help drawer text on the Employment Summary page - English
    And I select "Help me understand" icon on the Employment Summary Page
    Then I validate Employment Summary help drawer verbiage in "English"
    And I click on "Contact Us" link in Help Drawer on the Employment Summary page
    And I validate I am on the "We Can Help" page and close tab
    And I select "close help" icon on the Employment Summary Page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-921 @HelpDrawerEmploymentSummaryPage
  Scenario: SLER-921 Validate help drawer text on the Employment Summary page - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I validate I am on the "Spanish" page
    And I select "Help me understand" icon on the Employment Summary Page
    Then I validate Employment Summary help drawer verbiage in "Spanish"
    And I click on "Contact Us" link in Help Drawer on the Employment Summary page
    And I validate I am on the "We Can Help" page and close tab
    And I select "close help" icon on the Employment Summary Page

    And I click on Sign Out in the Header for "Elmo"

