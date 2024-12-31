@TAM @TamExch
Feature: Page Validation-Tax Status Elmo Page

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
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
#    Workaround until Elmo Tax Status page is in flow
    Then I validate I am on the "Tax status" page
    And I change the C4 url to "Tax Status Elmo page"
#    End of workaround
    Then I validate I am on the "Tax status Elmo" page
#    And I set the browser resolution to 2000 x 800

  @SLER-1902 @HelpDrawerTaxStatusElmoPage
  Scenario: SLER-1902 I want English and Spanish text added to the help drawer so that I can find more information about the questions on the page (desktop)
    Then I click on the "Header" help link on Tax Status Elmo page
    And I verify the help drawer "Full:English" text on Tax Status Elmo page
    Then I click on Contact Us link in Help Drawer on the Tax Status Elmo page
    And I validate I am on the "We Can Help" page and close tab
    Then I click on the "Header" help link on Tax Status Elmo page

    Then I click on the "Side" help link on Tax Status Elmo page
    And I verify the help drawer "Full:English" text on Tax Status Elmo page
    Then I click on Contact Us link in Help Drawer on the Tax Status Elmo page
    And I validate I am on the "We Can Help" page and close tab
    Then I click on the "Side" help link on Tax Status Elmo page

    Then I click on the "Claimed as Dependent" help link on Tax Status Elmo page
    And I verify the help drawer "Claim:English" text on Tax Status Elmo page
    Then I click on Contact Us link in Help Drawer on the Tax Status Elmo page
    And I validate I am on the "We Can Help" page and close tab
    Then I click on the "Claimed as Dependent" help link on Tax Status Elmo page

    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I click on the "Exceptional Circumstances" help link on Tax Status Elmo page
    And I verify the help drawer "Exceptional Circumstances:English" text on Tax Status Elmo page
    Then I click on Contact Us link in Help Drawer on the Tax Status Elmo page
    And I validate I am on the "We Can Help" page and close tab
    Then I click on the "Exceptional Circumstances" help link on Tax Status Elmo page

    Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
    Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
    Then I click on the "Claiming Dependent" help link on Tax Status Elmo page
    And I verify the help drawer "Claim:English" text on Tax Status Elmo page
    Then I click on Contact Us link in Help Drawer on the Tax Status Elmo page
    And I validate I am on the "We Can Help" page and close tab
    Then I click on the "Claiming Dependent" help link on Tax Status Elmo page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Tax status Elmo" page
    And I validate I am on the "Spanish" page
    Then I click on the "Header" help link on Tax Status Elmo page
    And I verify the help drawer "Full:Spanish" text on Tax Status Elmo page
    Then I click on Contact Us link in Help Drawer on the Tax Status Elmo page
    And I validate I am on the "We Can Help" page and close tab
    Then I click on the "Header" help link on Tax Status Elmo page

    Then I click on the "Side" help link on Tax Status Elmo page
    And I verify the help drawer "Full:Spanish" text on Tax Status Elmo page
    Then I click on Contact Us link in Help Drawer on the Tax Status Elmo page
    And I validate I am on the "We Can Help" page and close tab
    Then I click on the "Side" help link on Tax Status Elmo page

    Then I click on the "Claimed as Dependent" help link on Tax Status Elmo page
    And I verify the help drawer "Claim:Spanish" text on Tax Status Elmo page
    Then I click on Contact Us link in Help Drawer on the Tax Status Elmo page
    And I validate I am on the "We Can Help" page and close tab
    Then I click on the "Claimed as Dependent" help link on Tax Status Elmo page

    Then I click on the "Exceptional Circumstances" help link on Tax Status Elmo page
    And I verify the help drawer "Exceptional Circumstances:Spanish" text on Tax Status Elmo page
    Then I click on Contact Us link in Help Drawer on the Tax Status Elmo page
    And I validate I am on the "We Can Help" page and close tab
    Then I click on the "Exceptional Circumstances" help link on Tax Status Elmo page

    Then I click on the "Claiming Dependent" help link on Tax Status Elmo page
    And I verify the help drawer "Claim:Spanish" text on Tax Status Elmo page
    Then I click on Contact Us link in Help Drawer on the Tax Status Elmo page
    And I validate I am on the "We Can Help" page and close tab
    Then I click on the "Claiming Dependent" help link on Tax Status Elmo page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page