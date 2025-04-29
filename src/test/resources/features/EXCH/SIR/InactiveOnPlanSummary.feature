@SIR @SIREXCH @SIR-EXCH11 @SIRRegression @PlanSummary
# SLER-1092
Feature: Skipping Medical and Dental Plan pages

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

   @SLER-1092
  Scenario: SLER-1092 - EXCH UI Page Validation - Skipping Medical and Dental Plan pages will lead to a Inactive Continue button on the Plan Summary
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    # Question not asked during Open Enrollment
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    And I select "Male" as sex option
    Then I select "Yes" to Are You Applying
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

    And I Apply for no financial help
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I click on view results and shop

    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    Then I click skip on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    Then  I click Skip on Dental Plan Results page

    Then I validate I am on the "Plan Summary" page
    And  I verify continue button is disabled Plan Summary page
    And I click on Sign Out in the Header for "Portal"


