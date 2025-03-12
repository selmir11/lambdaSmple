@TAM @TamExch
Feature: Secondary User-OHC Retiree Elmo Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
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

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
    Then I select "Retiree Health Plan" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Retiree" page

  @SLER-615 @SecondaryUserOhcRetireeElmo
  Scenario: SLER-615 I can see Retiree's dynamic data for Primary and Secondary user - English
    And I verify the "First Section" Retiree page data in "English"
    Then I click "Yes" for currently enrolled in Retiree question
    And I verify the "Second Section" Retiree page data in "English"
    Then I click "Yes" for insurance ending in 60 days in Retiree question
    And I verify the "Third Section" Retiree page data in "English"
    Then I enter the end date as "Current Month" on the Retiree page
    Then I click "No" for insurance ending voluntary for Retiree question
    Then I click continue on the OHC Retiree page

    Then I select "Retiree Health Plan" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Retiree" page
    And I verify the "First Section Secondary" Retiree page data in "English"
    Then I click "Yes" for currently enrolled in Retiree question
    And I verify the "Second Section Secondary" Retiree page data in "English"
    Then I click "Yes" for insurance ending in 60 days in Retiree question
    And I verify the "Third Section Secondary" Retiree page data in "English"
    Then I enter the end date as "Current Month" on the Retiree page
    Then I click "No" for insurance ending voluntary for Retiree question

    And I click on Sign Out in the Header for "Elmo"

  @SLER-616 @SecondaryUserOhcRetireeElmo
  Scenario: SLER-616 I can see Retiree's dynamic data for Primary and Secondary user - Spanish
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page
    And I verify the "First Section" Retiree page data in "Spanish"
    Then I click "Yes" for currently enrolled in Retiree question
    And I verify the "Second Section" Retiree page data in "Spanish"
    Then I click "Yes" for insurance ending in 60 days in Retiree question
    And I verify the "Third Section" Retiree page data in "Spanish"
    Then I enter the end date as "Current Month" on the Retiree page
    Then I click "No" for insurance ending voluntary for Retiree question
    Then I click continue on the OHC Retiree page

    Then I select "Retiree Health Plan" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Elmo Ohc Retiree" page
    And I verify the "First Section Secondary" Retiree page data in "Spanish"
    Then I click "Yes" for currently enrolled in Retiree question
    And I verify the "Second Section Secondary" Retiree page data in "Spanish"
    Then I click "Yes" for insurance ending in 60 days in Retiree question
    And I verify the "Third Section Secondary" Retiree page data in "Spanish"
    Then I enter the end date as "Current Month" on the Retiree page
    Then I click "No" for insurance ending voluntary for Retiree question

    And I click on Sign Out in the Header for "Elmo"