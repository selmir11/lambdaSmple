@ELIG
Feature: Testing will verify text and navigation for Medical Condition Additional page (Medicaid eligibilty required)

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-2150-BUG-3160
  Scenario: SLER-2150 - ELIG - verify text on Medical Condition Additional Page  - stopped by bug SIR-3160/ELIG-4038
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
  # location change
    And I am a member with City "Denver" in State "CO" with dob "01011971" in county "DENVER" with zipcode "80220"
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

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
  #income variance
    And I enter employment details with "1000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    Then I click on "Continue" on good news page

    Then I validate I am on the "Parent/Caretaker" page
    Then I select "No" for under the age of 19 question and Continue on ParentCaretaker MA page

    Then I select "No" temporarily absent from Colorado question and Continue on Out Of State MA page

    Then I validate I am on the "FullTimeStudent" page
    Then I select "No" for attending school full-time question and Continue on Full-Time Student MA page

    Then I validate I am on the "Medical Condition" page
    Then I select "Yes" for medical condition or disability question on Medical Condition MA page
    And I click member on the Medical Condition MA page
    And I click continue on the Medical Condition MA page

    Then I validate I am on the "Medical Condition Additional" page
    And I validate the "English" text on the Medical Condition Additional MA page
    And I select the medical condition date on the Medical Condition Additional MA page

    And I change the language from header to "Spanish NonElmo"
    And I validate the "Spanish" text on the Medical Condition Additional MA page

    And I change the language from header to "English NonElmo"
    And I click continue on the Medical Condition Additional MA page
    And I click on Sign Out in the Header for "NonElmo"












