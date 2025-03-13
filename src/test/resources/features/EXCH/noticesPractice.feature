@Practice @Notices @PDF
Feature: Notices Practice

    Background:
         # Create New Account and Log In
        Given I open the login page on the "login" portal
        And I validate I am on the "Login" page
        When I click create a new account on login page
        Then I click create my account from pre-screen page
        And I enter general mandatory data for "exchange" account creation with email "pdfNotices"@outlook.com
        Then I validate I am on the "Login" page
        And  I enter valid credentials to login
        And I validate I am on the "Account Overview" page

    @TEAM-123
    Scenario: TEAM-123: English, Email, Does Not Apply for Health Insurance

        # Apply for Current Year
        Then I apply for the current year
        Then I validate I am on the "Let us guide you" page
        And I select "no" option on the Let us guide you page
        And I click on save and continue button
        Then I validate I am on the "Before you begin" page
        And I click on continue with  application button on Before you begin page

        # Who Are You
        And I report "Birth" and click continue
        Then I validate I am on the "Who Are You" page
        Then I select "member" from the who are you question
        And I am a member with City "Denver" in State "CO" with dob "01/01/1985" in county "Denver" with zipcode "80205"
        Then I validate I am on the "Identity Proofing - Initial Questions" page
        And I answer all Id proofing questions and click continue
        Then I validate I am on the "Identify Proofing - Congratulations" page
        And I click continue button on Congratulations page

        # Continue on My Own
        Then I validate I am on the "Find Expert Help Exch" page
        And I click Continue on my own button from Manage who helps you page

        # About Yourself
        Then I validate I am on the "Tell us about yourself" page
        And I select "Male" as sex option
        # Below is specific case context: user not applying
        And I select "No" to Are You Applying
        And I click continue on Tell us about yourself page
        Then I validate I am on the "Add Address" page
        Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
        Then I select "Yes" for CO Resident option
        Then I select "No" for Federally Recognized Tribe option
        Then I click continue on the Add Address page
        And I select "Prefer not to answer" for race and ethnicity for "Primary"
        And I click continue on the Race and Ethnicity page
        Then I select "Yes" for Citizen option
        And I select "No" for Naturalized Immigrant option
        And I click continue on the Citizenship page

        # Life change information
        Then I validate I am on the "Family Overview" page
        #Then I verify the family overview table is present
        Then I click continue on family overview page

        # Financial help
        Then I validate I am on the "Financial Help" page
        And I Apply for financial help
        Then I validate I am on the "Employment Info" page
        Then I select the option "Yes" to employment
        And I select the option "No" to self employment
        Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "6000000" at frequency "Annually"
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
        Then I validate I am on the "Tax status Elmo" page
        Then I select "No" for will you be claimed as dependent question
        Then I select "Yes" for will file tax return question
        Then I select the "Single" tax filing option on the Tax Status page
        Then I select "No" for will claim dependents question
        Then I click Save and Continue on Tax Status page

        # Health coverage and life change information
        Then I validate I am on the "Elmo Other Health Coverage" page
        Then I select "None of these" as health coverage option
        Then I click continue on the health coverage page
        Then I validate I am on the "Family Overview" page
        ##Then I verify the family overview table is present
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
        Then I click on ClickHere link for "My Documents"
        Then I validate I am on the "My Documents" page
        Then I validate the notice "Application Results" exist in my document letter Containers
        Then I click on download "Application Results" document
        Then I validate "ELIG-001-01 English" notice content
        And I click on Sign Out in the Header for "Elmo"

    @TEAM-124
    Scenario: TEAM-124: Spanish, Email, Does Not Apply for Health Insurance

        # Change Language Preference to Spanish
        And I click on ClickHere link for "My Profile"
        And I click on Make Changes Button
        And I change Preferred Language Contact Method to "Spanish"
        And I click on Save Button
        And I click on My Account in the "Elmo" Header

        # Apply for Current Year
        Then I apply for the current year
        Then I validate I am on the "Let us guide you" page
        And I select "no" option on the Let us guide you page
        And I click on save and continue button
        Then I validate I am on the "Before you begin" page
        And I click on continue with  application button on Before you begin page

        # Who Are You
        And I report "Birth" and click continue
        Then I validate I am on the "Who Are You" page
        Then I select "member" from the who are you question
        And I am a member with City "Denver" in State "CO" with dob "01/01/1985" in county "Denver" with zipcode "80205"
        Then I validate I am on the "Identity Proofing - Initial Questions" page
        And I answer all Id proofing questions and click continue
        Then I validate I am on the "Identify Proofing - Congratulations" page
        And I click continue button on Congratulations page

        # Continue on My Own
        Then I validate I am on the "Find Expert Help Exch" page
        And I click Continue on my own button from Manage who helps you page

        # About Yourself
        Then I validate I am on the "Tell us about yourself" page
        And I select "Male" as sex option
        # Below is specific case context: user not applying
        And I select "No" to Are You Applying
        And I click continue on Tell us about yourself page
        Then I validate I am on the "Add Address" page
        Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
        Then I select "Yes" for CO Resident option
        Then I select "No" for Federally Recognized Tribe option
        Then I click continue on the Add Address page
        And I select "Prefer not to answer" for race and ethnicity for "Primary"
        And I click continue on the Race and Ethnicity page
        Then I select "Yes" for Citizen option
        And I select "No" for Naturalized Immigrant option
        And I click continue on the Citizenship page

        # Life Change Information
        Then I validate I am on the "Family Overview" page
        #Then I verify the family overview table is present
        Then I click continue on family overview page

        # Financial Help
        Then I validate I am on the "Financial Help" page
        And I Apply for financial help
        Then I validate I am on the "Employment Info" page
        Then I select the option "Yes" to employment
        And I select the option "No" to self employment
        Then I enter company details with addressline1 as "1234 Court" and city as "Denver" and state as "CO" and zipcode as "80205" and income "6000000" at frequency "Annually"
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
        Then I validate I am on the "Tax status Elmo" page
        Then I select "No" for will you be claimed as dependent question
        Then I select "Yes" for will file tax return question
        Then I select the "Single" tax filing option on the Tax Status page
        Then I select "No" for will claim dependents question
        Then I click Save and Continue on Tax Status page

        # Health Coverage and Life Change Information
        Then I validate I am on the "Elmo Other Health Coverage" page
        Then I select "None of these" as health coverage option
        Then I click continue on the health coverage page
        Then I validate I am on the "Family Overview" page
        #Then I verify the family overview table is present
        Then I click continue on family overview page
        Then I validate I am on the "Tell us about life changes" page
        Then I select "LostCoverage" QLCE on tell us about life changes page
        Then I click on Save and Continue

        # Declarations and Signature
        Then I validate I am on the "EXCH Declarations and Signature" page
        And I Declare as Tax Household 1
        Then I click Continue on the Declarations And Signature Page

        # Review Application Results
        Then I validate I am on the "Application History" page
        Then I click on view results and shop
        Then I validate I am on the "Application Results" page
        Then I click on My Account in the "NonElmo" Header

        # Check My Documents Notice
        Then I validate I am on the "My Account Overview" page
        Then I click on ClickHere link for "My Documents"
        Then I validate I am on the "My Documents" page
        Then I validate the notice "Application Results" exist in my document letter Containers
        Then I click on download "Application Results" document
        Then I validate "ELIG-001-01 Spanish" notice content
        And I click on Sign Out in the Header for "Elmo"