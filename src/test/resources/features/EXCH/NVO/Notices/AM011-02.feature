@NVO @NVOPDF @AM @Notices
Feature: AM 011-02 Notices

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "mf_test_"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page

    # Who are you
    And I report "Birth" and click continue
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01/01/1985" in county "Denver" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    And I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page

    # Continue on my own
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page

    # About yourself
    Then I validate I am on the "Tell us about yourself" page
    And I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80202" and county "DENVER"
    # Below is specific case context: user from CO
    Then I select "Yes" for CO Resident option
    Then I select "No" for Federally Recognized Tribe option
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page

    # Financial help
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "3600000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    And I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
#
    # Health coverage and life change information
    Then I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Family Overview" page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    # Declarations and signature
    Then I validate I am on the "EXCH Declarations and Signature" page
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page

    # Review application results
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click on My Account in the "NonElmo" Header

    # Check My Documents notice
    Then I validate I am on the "My Account Overview" page

  @needTag
  Scenario Outline: AM Profile Changes- English
    And I click on ClickHere link for "My Profile"
    And I click on Make Changes Button
    And I update the <update_action> on profile page
    And I click on Save Button
    And I wait for 3000 milliseconds
    And I click on My Account in the "Elmo" Header
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on download "IND_Profile Change (AM-011-02)" document
    Then I validate "AM-011-02 English" notice content
    And I click on Sign Out in the Header for "Elmo"

    Examples:
      | update_action               |
      | contact mobile phone number |
      | contact email address       |
#      | contact preferred language  |
#      | contact preferred method    |