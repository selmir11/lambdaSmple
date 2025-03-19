@TAM @TamExch
Feature: Help Drawer-Other Health Coverage Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page
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
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "Other" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Ohc Individual Insurance" page
    And I set the browser resolution to 1536 x 864

  @SLER-914 @HelpDrawerIndividualInsurancePage
  Scenario: SLER-914 Validate help drawer text on the Individual Insurance page - English
    Then I click "Yes" for currently enrolled in Individual Insurance question
    Then I click "Yes" for insurance ending in 60 days in Individual Insurance question
    And I select "Help me understand" icon on the Individual Insurance Page
    Then I validate Individual Insurance "full" help drawer verbiage in "English"
    And I click Individual Insurance Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "Help me understand" icon on the Individual Insurance Page
    And I select "Please enter" icon on the Individual Insurance Page
    Then I validate Individual Insurance "full" help drawer verbiage in "English"
    And I click Individual Insurance Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "Please enter" icon on the Individual Insurance Page
    And I select "currently enrolled" icon on the Individual Insurance Page
    Then I validate Individual Insurance "currently enrolled" help drawer verbiage in "English"
    And I click Individual Insurance Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "currently enrolled" icon on the Individual Insurance Page
    And I select "60 days" icon on the Individual Insurance Page
    Then I validate Individual Insurance "60 days" help drawer verbiage in "English"
    And I click Individual Insurance Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "60 days" icon on the Individual Insurance Page
    And I select "voluntarily ending" icon on the Individual Insurance Page
    Then I validate Individual Insurance "voluntarily ending" help drawer verbiage in "English"
    And I click Individual Insurance Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "voluntarily ending" icon on the Individual Insurance Page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-915 @HelpDrawerIndividualInsurancePage @TAMSmokeExch
  Scenario: SLER-915 Validate help drawer text on the Individual Insurance page - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I validate I am on the "Spanish" page
    Then I click "Yes" for currently enrolled in Individual Insurance question
    Then I click "Yes" for insurance ending in 60 days in Individual Insurance question
    And I select "Help me understand" icon on the Individual Insurance Page
    Then I validate Individual Insurance "full" help drawer verbiage in "Spanish"
    And I click Individual Insurance Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "Help me understand" icon on the Individual Insurance Page
    And I select "Please enter" icon on the Individual Insurance Page
    Then I validate Individual Insurance "full" help drawer verbiage in "Spanish"
    And I click Individual Insurance Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "Please enter" icon on the Individual Insurance Page
    And I select "currently enrolled" icon on the Individual Insurance Page
    Then I validate Individual Insurance "currently enrolled" help drawer verbiage in "Spanish"
    And I click Individual Insurance Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "currently enrolled" icon on the Individual Insurance Page
    And I select "60 days" icon on the Individual Insurance Page
    Then I validate Individual Insurance "60 days" help drawer verbiage in "Spanish"
    And I click Individual Insurance Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "60 days" icon on the Individual Insurance Page
    And I select "voluntarily ending" icon on the Individual Insurance Page
    Then I validate Individual Insurance "voluntarily ending" help drawer verbiage in "Spanish"
    And I click Individual Insurance Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    And I select "voluntarily ending" icon on the Individual Insurance Page

    And I click on Sign Out in the Header for "Elmo"

