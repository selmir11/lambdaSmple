@TAM @TamExch
Feature: Help Drawer-OHC VA Healthcare Elmo Page

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
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    Then I select "VA Health Care" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohc VA Healthcare" page
    And I set the browser resolution to 2000 x 800

  @SLER-904 @HelpDrawerOhcVaHealthcareElmo
  Scenario: SLER-904 Validate help drawer text on the VA Healthcare page - English
    Then I click "Yes" for currently enrolled in VA Healthcare question
    Then I click "Yes" for insurance ending in 60 days in VA Healthcare question
    And I select "Help me understand" icon on the VA Healthcare Page
    Then I validate VA Healthcare "full" help drawer verbiage in "English"
    And I click VA Healthcare Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "Help me understand" icon on the VA Healthcare Page
    And I select "Please enter" icon on the VA Healthcare Page
    Then I validate VA Healthcare "full" help drawer verbiage in "English"
    And I click VA Healthcare Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "Please enter" icon on the VA Healthcare Page
    And I select "currently enrolled" icon on the VA Healthcare Page
    Then I validate VA Healthcare "currently enrolled" help drawer verbiage in "English"
    And I click VA Healthcare Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "currently enrolled" icon on the VA Healthcare Page
    And I select "60 days" icon on the VA Healthcare Page
    Then I validate VA Healthcare "60 days" help drawer verbiage in "English"
    And I click VA Healthcare Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "60 days" icon on the VA Healthcare Page
    And I select "voluntarily ending" icon on the VA Healthcare Page
    Then I validate VA Healthcare "voluntarily ending" help drawer verbiage in "English"
    And I click VA Healthcare Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "voluntarily ending" icon on the VA Healthcare Page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-905 @HelpDrawerOhcVaHealthcareElmo
  Scenario: SLER-905 Validate help drawer text on the VA Healthcare page - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I verify the header for Primary Member on the VA Healthcare page in "Spanish"
    Then I click "Yes" for currently enrolled in VA Healthcare question
    Then I click "Yes" for insurance ending in 60 days in VA Healthcare question
    And I select "Help me understand" icon on the VA Healthcare Page
    Then I validate VA Healthcare "full" help drawer verbiage in "Spanish"
    And I click VA Healthcare Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "Help me understand" icon on the VA Healthcare Page
    And I select "Please enter" icon on the VA Healthcare Page
    Then I validate VA Healthcare "full" help drawer verbiage in "Spanish"
    And I click VA Healthcare Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "Please enter" icon on the VA Healthcare Page
    And I select "currently enrolled" icon on the VA Healthcare Page
    Then I validate VA Healthcare "currently enrolled" help drawer verbiage in "Spanish"
    And I click VA Healthcare Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "currently enrolled" icon on the VA Healthcare Page
    And I select "60 days" icon on the VA Healthcare Page
    Then I validate VA Healthcare "60 days" help drawer verbiage in "Spanish"
    And I click VA Healthcare Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "60 days" icon on the VA Healthcare Page
    And I select "voluntarily ending" icon on the VA Healthcare Page
    Then I validate VA Healthcare "voluntarily ending" help drawer verbiage in "Spanish"
    And I click VA Healthcare Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "voluntarily ending" icon on the VA Healthcare Page

    And I click on Sign Out in the Header for "Elmo"
