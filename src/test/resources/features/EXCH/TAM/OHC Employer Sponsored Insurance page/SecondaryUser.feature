@TAM @TamExch
Feature: Secondary User-OHI ESI Elmo Page

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
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page

  @SLER-536 @SecondaryUserOhiEsiElmo
  Scenario: SLER-536 I can see ESI's dynamic data for Primary and Secondary user - English
    And I verify the "No Job Section" ESI page data in "English"
    Then I select the "0" employer for "Primary" member on the ESI page
    And I verify the "Job Section" ESI page data in "English"
    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    Then I enter "200.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    And I verify the "Currently Enrolled Section" ESI page data in "English"
    Then I select the Will Insurance End "Yes" button on the ESI page
    And I verify the "Currently Enrolled Ending Section" ESI page data in "English"
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I click "Yes" for offer family plans question
    And I verify the "Family Plans Section" ESI page data in "English"
    Then I click "No" for offer family plans question
    Then I click continue on the ESI page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    And I verify the "No Job Section Secondary" ESI page data in "English"
    Then I select the "0" employer for "Secondary" member on the ESI page
    And I verify the "Job Section Secondary" ESI page data in "English"
    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    Then I enter "200.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    And I verify the "Currently Enrolled Section Secondary" ESI page data in "English"
    Then I select the Will Insurance End "Yes" button on the ESI page
    And I verify the "Currently Enrolled Ending Section Secondary" ESI page data in "English"
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I click "Yes" for offer family plans question
    And I verify the "Family Plans Section Secondary" ESI page data in "English"

    And I click on Sign Out in the Header for "Elmo"

  @SLER-537 @SecondaryUserOhiEsiElmo
  Scenario: SLER-537 I can see ESI's dynamic data for Primary and Secondary user - Spanish
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page
    And I verify the "No Job Section" ESI page data in "Spanish"
    Then I select the "0" employer for "Primary" member on the ESI page
    And I verify the "Job Section" ESI page data in "Spanish"
    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    Then I enter "200.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    And I verify the "Currently Enrolled Section" ESI page data in "Spanish"
    Then I select the Will Insurance End "Yes" button on the ESI page
    And I verify the "Currently Enrolled Ending Section" ESI page data in "Spanish"
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I click "Yes" for offer family plans question
    And I verify the "Family Plans Section" ESI page data in "Spanish"
    Then I click "No" for offer family plans question
    Then I click continue on the ESI page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    And I verify the "No Job Section Secondary" ESI page data in "Spanish"
    Then I select the "0" employer for "Secondary" member on the ESI page
    And I verify the "Job Section Secondary" ESI page data in "Spanish"
    Then I select "I don't know" for meet the Minimum Value Standard on the ESI page
    Then I enter "200.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    And I verify the "Currently Enrolled Section Secondary" ESI page data in "Spanish"
    Then I select the Will Insurance End "Yes" button on the ESI page
    And I verify the "Currently Enrolled Ending Section Secondary" ESI page data in "Spanish"
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I click "Yes" for offer family plans question
    And I verify the "Family Plans Section Secondary" ESI page data in "Spanish"

    And I click on Sign Out in the Header for "Elmo"