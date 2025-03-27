@TAM @TamExch
Feature: Page Validation-OHC-Employer Sponsored Insurance page

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
    And I validate I am on the "Employment Income" page

  @SLER-2376
  Scenario: ELIG-As an Exchange individual, I see the structure of the page so that I can see my employer sponsored insurance (ESI) information[RT-2617]
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
    Then I validate I am on the "Other Health Coverage" page
    Then I select "job" as health coverage option
    Then I click continue on the health coverage page
    Then I validate font colour format of the text in employee sponsored page
    Then I validate below texts in employee sponsored page
      |Other Health Coverage:|
      |Employer-sponsored Health Insurance|
      |Help me understand this page|
      |Which job is offering health insurance?|
      |No Jobs Found|
      |Go back|
    When I click on go back button in employee sponsored page
    Then I click Go back on the health coverage page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 park street" and city as "Denver" and state as "CO" and zipcode as "80205" and income "1250000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I click the save and continue button on the Income Summary Detail page
    Then I click Save and Continue on Tax Status page
    Then I validate I am on the "Other Health Coverage" page
    Then I click continue on the health coverage page
    Then I validate font colour format of the text when one job added
    When I select the first option in which_job_is_offering dropdown
    Then I validate font colour etc when option is selected
    When I click "Yes" in Are you currently enrolled question
    Then I validate color border font when Are-you-currently-enrolled is "Yes"
    When I select "Yes" in Will this health insurance end question
    Then I validate when Will_this_health_insurance is Yes
    When I click "No" in Are you currently enrolled question
    Then I validate color border font when Are-you-currently-enrolled is "No"