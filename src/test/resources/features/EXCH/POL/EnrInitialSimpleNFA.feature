Feature: Simple NFA - Single Applicant
  @SLER-34 
  Scenario: Simple NFA flow with single applicant
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "MGC4testing"@outlook.com
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "11281986" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "P.O BOX 1454" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for no financial help
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click continue on start shopping page
    And I validate I am on the "Medical Plan Results" page
    And I select "Elevate Health Plans Colorado Option Bronze" medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    And I select "Delta Dental of Colorado Family Basic Plan" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I continue on plan summary page

    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page

    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page
    And I validate enrInitial simple NFA application medical and dental plan details from my policies page
    Then I click on the Colorado Connect or C4 Logo in the "My Policies" Header
    Then I validate I am on the "My Account Overview" page
    And I click on ClickHere link for "My Documents"
    And I click on download enrolment document
    Then I click on the Colorado Connect or C4 Logo in the "My Policies" Header
    Then I validate I am on the "My Account Overview" page
    And I Validate the correct enrolled plans are displayed on account overview page

    #Gmail
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "(EN-002-04)" in "English"
    And I verify the notice Text for "EN-002-04" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    #DbVerification

    And I verify the policy data quality check with Policy Ah keyset size 2
    #And I verify the data from book of business queue table