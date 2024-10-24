@TAM @helpDrawerOHC @TamExch
Feature: Page Text-Other Health Coverage Elmo Page

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

    And I validate I am on the "Elmo Other Health Coverage" page
    And I set the browser resolution to 2000 x 800

  @SLER-343 @PageVerificationOtherHealthInsurancePage
  Scenario: SLER-343 I Validate help drawer text in English on the Other Health Coverage page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"

    And I click Help me understand this page link on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer body text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "Health First Colorado" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "Child Health Plan Plus" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "Medicare" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "ESI" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "HRA" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "Retiree" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "Peace Corps" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "COBRA" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "VA Health Care" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "TRICARE" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "English" for "Individual" question on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    And I refresh the page
    And I click Help side button on the Other Health Coverage page
    Then I verify help drawer header text in "English" on the Other Health Coverage page
    Then I verify help drawer body text in "English" on the Other Health Coverage page
    Then I verify help drawer footer text in "English" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    And I set the browser resolution to Maximized
    And I click on Sign Out in the Header for "Elmo"


  @SLER-860 @PageVerificationOtherHealthInsurancePage
  Scenario: SLER-860 I Validate help drawer text in Spanish on the Other Health Coverage page
    And I change the language from header to "Spanish"
    And I verify the header for "Primary" Member on the Other Health Coverage page in "Spanish"

    And I click Help me understand this page link on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer body text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "Health First Colorado" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "Child Health Plan Plus" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "Medicare" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "ESI" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "HRA" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "Retiree" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "Peace Corps" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "COBRA" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "VA Health Care" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "TRICARE" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    Then I verify help text in "Spanish" for "Individual" question on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    And I refresh the page
    And I click Help side button on the Other Health Coverage page
    Then I verify help drawer header text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer body text in "Spanish" on the Other Health Coverage page
    Then I verify help drawer footer text in "Spanish" on the Other Health Coverage page
    And I click Contact Us link in help drawer footer of the Other Health Coverage page
    And I validate I am on the "We Can Help" page and close tab

    And I set the browser resolution to Maximized
    And I click on Sign Out in the Header for "Elmo"

