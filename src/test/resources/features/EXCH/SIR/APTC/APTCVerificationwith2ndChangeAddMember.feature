@APTC @APTCSIR @APTC-SIR4
  #SLER-325, SLER-802, SLER-803, SLER-804, @SLER-805, @SLER-806, SLER-807, @SLER-808, @SLER-809, SLER-998, SLER-999, SLER-1007,
Feature: UI Tests related to APTC after second enrollment change

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-325
  Scenario: SLER-325- ELIG- APTCRules - born 1982 and 2011
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
    Then I validate I am on the "Report a life change" page
    And I report "Marriage" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Example" in State "CO" with dob "01011958" in county "Rio Grande" with zipcode "81144"
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "1000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
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

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the Insurance Company dropdown
    And I select "Rocky Mountain Health Plans / UHC" to filter for desired plan provider
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page

    Then I validate I am on the "Pay now" page
    Then I click all done from payment portal page

   # end initial enrollment and go back to make changes


    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
   Then I validate I am on the "Report a life change" page
   And I report "MovedToColorado" and click continue

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page

    Then I validate I am on the "Ethnicity and Race" page
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    And I click on "Primary" to edit information from household page

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "5152000"
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status" page
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's 1 APTC value is "$968.54/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$968.54"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Portal"


    @SLER-999
    Scenario Outline: SLER-999 - ELIG - APTCRules  - 1 member add enrollment - income change
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
      Then I validate I am on the "Report a life change" page
      And I report "MovedToColorado" and click continue

      Then I validate I am on the "Who Are You" page
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

      Then I validate I am on the "Ethnicity and Race" page
      And I select "Prefer not to answer" for race and ethnicity for "Primary"
      And I click continue on the Race and Ethnicity page
      
      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page

      Then I validate I am on the "Financial Help" page
      And I Apply for financial help
      Then I select the option "Yes" to employment
      And I select the option "No" to self employment
      And I enter employment details with "<income1>" income at "Annually" frequency
      And I select the option "No" to seasonal employment
      And I select the option "No" to projected income
      And I click continue on the Employment Info Page

      Then I click continue on the Employment Summary Page

      Then I validate I am on the "Additional income" page
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

      Then I select "Marriage" QLCE on tell us about life changes page
      Then I click on Save and Continue

      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear

      Then I validate I am on the "Good News" page
      Then I click on "No Thanks" on good news page

      Then I validate I am on the "Application History" page
      Then I click on view results and shop

      Then I validate I am on the "Application Results" page

      And I verify that the APTC amount does not appear on the app results page
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
      Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
      And I click continue on start shopping page

      Then I validate I am on the "Medical Plan Results" page
      And I select the Insurance Company dropdown
      And I select "Cigna Healthcare" to filter for desired plan provider
      And I select the first medical plan
      And I click continue on medical plan results page

      Then I validate I am on the "Dental Plan Results" page
      And I select first dental plan
      And I click continue on dental plan results page

      Then I validate I am on the "Plan Summary" page
      And I validate the APTC Credit on the Summary page is "<initialAPTCSummaryResult>"
      And I click continue on plan summary page

      Then I validate I am on the "Enrollment Agreements" page
      And I select "Acknowledgement" agreement checkbox
      And I select "Submit" agreement checkbox
      And I enter householder signature on the Enrollment Agreements page
      And I click submit enrollment on Enrollment Agreements page

      Then I validate I am on the "Pay now" page
      Then I click all done from payment portal page

       # end initial enrollment and go back to make changes

      Then I validate I am on the "Account Overview" page
      Then I click on make changes button

      Then I validate I am on the "Let us guide you" page
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button

      Then I validate I am on the "Before you begin" page
      Then I click on continue with  application button on Before you begin page

      # Question not asked during Open Enrollment
      Then I validate I am on the "Report a life change" page
      And I report "Marriage" and click continue

      Then I validate I am on the "Find Expert Help" page
      Then I click Continue on my own button from Manage who helps you page

      Then I select "Male" as sex option
      And I select "Yes" to Are You Applying
      And I click continue on Tell us about yourself page

      Then I validate I am on the "Add Address" page
      And I select "Yes" for CO Resident option
      And I select "No" for Federally Recognized Tribe option
      And I select "No" for Hardship Exemption option
      And I select "No" for Disability option
      And I select "No" to the recently denied medicaid question
      And I select "No" for Incarceration option
      And I click continue on the Add Address page

      Then I validate I am on the "Ethnicity and Race" page
      And I click continue on the Race and Ethnicity page

      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page

      Then I validate I am on the "Family Overview" page
      And I click Add Another Family Member

      Then I validate I am on the "Add Member" page
      Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
        |Primary:Spouse|
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

      Then I validate I am on the "Ethnicity and Race" page
      And I select "Prefer not to answer" for race and ethnicity for "Spouse"
      And I click continue on the Race and Ethnicity page

      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page

      And I click on "Spouse" to edit information from household page

      Then I validate I am on the "Application Summary" page
      Then I select the Edit Income link

      Then I validate I am on the "Employment Info" page
      Then I select the option "Yes" to employment
      And I select the option "No" to self employment
      And I enter employment details with "<income2>" income at "Annually" frequency
      And I select the option "No" to seasonal employment
      And I select the option "No" to projected income
      And I click continue on the Employment Info Page

      Then I validate I am on the "Employment Summary" page
      Then I click continue on the Employment Summary Page

      Then I validate I am on the "Additional income" page
      And I click None of these as additional income option
      Then I click continue on the Additional Income page

      Then I validate I am on the "Deductions" page
      And I click None of these as deduction option and continue

      Then I validate I am on the "Income Summary" page
      Then I select the projected income option "No" and continue

      Then I validate I am on the "Tax status" page
      Then I select "No" for will you be claimed as dependent question
      Then I select "Yes" for will file tax return question
      Then I select the "Married filing jointly" tax filing option on the Tax Status page
      Then I select "Spouse" as filing jointly with option on the Tax Status page
      Then I select "No" for will claim dependents question
      Then I click Save and Continue on Tax Status page

      And I validate I am on the "Other Health Coverage" page
      Then I click continue on the health coverage page

      And I validate I am on the "Other Health Coverage" page
      Then I select "None of these" as health coverage option
      Then I click continue on the health coverage page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page

      Then I validate I am on the "Tell us about life changes" page
      And  I select "Marriage" QLCE on tell us about life changes page
      Then I click on Save and Continue

      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear

      Then I validate I am on the "Application History" page
      Then I click on view results and shop

      Then I validate I am on the "Application Results" page
      Then I validate that my Tax Household's 1 APTC value is "<expectedPostAPTCResult>"
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
      Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
      And I click continue on start shopping page

      Then I validate I am on the "Grouping Members Medical" page
      Then I click continue on grouping Members Medical page

      Then I validate I am on the "Medical Plan Results" page
      And I click continue on medical plan results page

      Then I validate I am on the "Grouping Members Dental" page
      Then I click continue on grouping Members Dental page

      Then I validate I am on the "Dental Plan Results" page
      And I click continue on dental plan results page

      Then I validate I am on the "Plan Summary" page
      And I validate the APTC Credit on the Summary page is "<postAPTCSummaryResult>"
      And I click continue on plan summary page

      Then I validate I am on the "Financial Help Agreements" page
      And I click on Sign Out in the Header for "Portal"
      Examples:
      |income1      |income2    | expectedInitialAPTCResult | initialAPTCSummaryResult |expectedPostAPTCResult| postAPTCSummaryResult |
      |1500000      |1500000    | $0.00/mo                  | $0.00                    | $930.41/mo           | -$741.73              |


  @SLER-998
  Scenario Outline: SLER-998 - ELIG - APTCRules - 1 member add enrollment - income change
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
    Then I validate I am on the "Report a life change" page
    And I report "MovedToColorado" and click continue

    Then I validate I am on the "Who Are You" page
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "<income1>" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page

    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
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

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's 1 APTC value is "<expectedInitialAPTCResult>"

    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the Insurance Company dropdown
    And I select "Cigna Healthcare" to filter for desired plan provider
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<initialAPTCSummaryResult>"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page

    Then I validate I am on the "Pay now" page

    Then I click all done from payment portal page

    # end of initial enrollment

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    Then I validate I am on the "Report a life change" page
    And I report "Marriage" and click continue

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page

    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page

    Then I validate I am on the "Ethnicity and Race" page
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    And I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
      |Primary:Spouse|
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    And I click on "Spouse" to edit information from household page

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "<income2>" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    And I click None of these as additional income option
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    And I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I click continue on the health coverage page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's 1 APTC value is "<expectedPostAPTCResult>"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<postAPTCSummaryResult>"
    And I click on Sign Out in the Header for "Portal"
    Examples:
      |income1      |income2    | expectedInitialAPTCResult | initialAPTCSummaryResult |expectedPostAPTCResult| postAPTCSummaryResult |
      |10000000     |1000000    | $0.00/mo                  | $0.00                     |  $151.24/mo         | -$151.24              |



  @SLER-807
      # ELIG-APTCRules - SLER - 807
    Scenario Outline: SLER-807 - APTCRules - Add a daughter on 2nd enrollmnent
      When I click create a new account on login page
      Then I click create my account from pre-screen page
      And I enter general mandatory data for "exchange" account creation
      Then I validate I am on the "Login" page
      And I enter valid credentials to login
      Then I validate I am on the "Account Overview" page
      Then I apply for the current year
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button

      Then I validate I am on the "Before you begin" page
      Then I click on continue with  application button on Before you begin page

       # Question not asked during Open Enrollment
      Then I validate I am on the "Report a life change" page
      And I report "MovedToColorado" and click continue

      Then I validate I am on the "Who Are You" page
      Then I select "member" from the who are you question
      And I am a member with City "<City>" in State "<State>" with dob "<DOB>" in county "<County>" with zipcode "<Zipcode>"
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

      Then I validate I am on the "Ethnicity and Race" page
      And I select "Prefer not to answer" for race and ethnicity for "Primary"
      And I click continue on the Race and Ethnicity page

      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page

      Then I validate I am on the "Financial Help" page
      And I Apply for financial help

      Then I validate I am on the "Employment Income" page
      Then I select the option "No" to employment
      And I click continue on the Employment Info Page

      Then I validate I am on the "Additional income" page
      Then I click None of these as additional income option and continue

      Then I validate I am on the "Deductions" page
      Then I click None of these as deduction option and continue

      Then I validate I am on the "Income Summary" page
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

      Then I select "MoveToCO" QLCE on tell us about life changes page
      Then I click on Save and Continue

      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear

      Then I validate I am on the "Good News" page
      Then I click on "No Thanks" on good news page

      Then I validate I am on the "Application History" page
      Then I click on view results and shop

      Then I validate I am on the "Application Results" page
      And I verify that the APTC amount does not appear on the app results page
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
      Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
      And I click continue on start shopping page

      Then I validate I am on the "Medical Plan Results" page
      And I select the Insurance Company dropdown
      And I select "Rocky Mountain Health Plans / UHC" to filter for desired plan provider
      And I select the first medical plan
      And I click continue on medical plan results page

      Then I validate I am on the "Dental Plan Results" page
      And I select first dental plan
      And I click continue on dental plan results page

      Then I validate I am on the "Plan Summary" page
      And I validate the APTC Credit on the Summary page is "<aptc1>"
      And I click continue on plan summary page

      Then I validate I am on the "Enrollment Agreements" page
      And I select "Acknowledgement" agreement checkbox
      And I select "Submit" agreement checkbox
      And I enter householder signature on the Enrollment Agreements page
      And I click submit enrollment on Enrollment Agreements page

      Then I validate I am on the "Pay now" page
      Then I click all done from payment portal page

      # End of initial enrollment

      Then I validate I am on the "Account Overview" page
      Then I click on make changes button

      Then I validate I am on the "Let us guide you" page
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button

      Then I validate I am on the "Before you begin" page
      Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
      Then I validate I am on the "Report a life change" page
      And I report "LostCoverage" and click continue

      Then I validate I am on the "Find Expert Help" page
      Then I click Continue on my own button from Manage who helps you page

    Then I select "Male" as sex option
      And I select "Yes" to Are You Applying
      And I click continue on Tell us about yourself page

      Then I validate I am on the "Add Address" page
      And I select "Yes" for CO Resident option
      And I select "No" for Federally Recognized Tribe option
      And I select "No" for Hardship Exemption option
      And I select "No" for Disability option
      And I select "No" to the recently denied medicaid question
      And I select "No" for Incarceration option
      And I click continue on the Add Address page

      Then I validate I am on the "Ethnicity and Race" page
      And I click continue on the Race and Ethnicity page

      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page

      Then I validate I am on the "Family Overview" page
      Then I click Add Another Family Member

      Then I validate I am on the "Add Member" page
      Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "<DOBmember2>", "Female" and applying "Yes"
        |Primary:Daughter|
      And I mark the Additional member is pregnant as "No"
      And I click continue on Tell us about additional members page

      Then I validate I am on the "Add Address" page
      Then I select "Household" for Residential Address
      And I select "Yes" for CO Resident option
      And I select "No" for Federally Recognized Tribe option
      And I select "No" for Hardship Exemption option
      And I select "No" for Disability option
      And I select "No" to the recently denied medicaid question
      And I select "No" for Incarceration option

      And I select "No" for Fulltime Student option
      Then I select "No" for Foster care in state of Colorado

      And I click continue on the Add Address page

      Then I validate I am on the "Ethnicity and Race" page
      And I select "Prefer not to answer" for race and ethnicity for "Daughter"
      And I click continue on the Race and Ethnicity page

      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page

      Then I validate I am on the "Family Overview" page
      And I click on "Daughter" to edit information from household page

      Then I validate I am on the "Application Summary" page
      Then I select the Edit Income link

      Then I validate I am on the "Employment Info" page
      Then I select the option "Yes" to employment
      And I select the option "No" to self employment
      And I enter employment details with "<income2>" income at "Annually" frequency
      And I select the option "No" to seasonal employment
      And I select the option "No" to projected income
      And I click continue on the Employment Info Page

      Then I validate I am on the "Employment Summary" page
      And I click continue on the Employment Summary Page

      Then I validate I am on the "Additional income" page
      Then I click None of these as additional income option and continue

      Then I validate I am on the "Deductions" page
      Then I click None of these as deduction option and continue

      Then I validate I am on the "Income Summary" page
      Then I select the projected income option "No" and continue

      Then I validate I am on the "Tax status" page
      Then I select "No" for will you be claimed as dependent question
      Then I select "Yes" for will file tax return question
      Then I select the "Single" tax filing option on the Tax Status page
      Then I select "Yes" for will claim dependents question
      Then I select "Daughter" for who will be claimed as dependent question on the Tax Status page
      Then I click Save and Continue on Tax Status page

      And I validate I am on the "Other Health Coverage" page
      Then I click continue on the health coverage page

      And I validate I am on the "Other Health Coverage" page
      Then I select "None of these" as health coverage option
      Then I click continue on the health coverage page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page

      Then I validate I am on the "Tell us about life changes" page
      And  I select "LostCoverage" QLCE on tell us about life changes page
      Then I click on Save and Continue

      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear

      # Good News insert
      Then I validate I am on the "Good News" page
      Then I click on "No Thanks" on good news page

      Then I validate I am on the "Application History" page
      Then I click on view results and shop

      Then I validate I am on the "Application Results" page
      Then I validate that my Tax Household's 1 APTC value is "<expectedAptc2>"
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
      Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
      And I click continue on start shopping page

      Then I validate I am on the "Grouping Members Medical" page
      Then I click continue on grouping Members Medical page

      Then I validate I am on the "Medical Plan Results" page
      And I click continue on medical plan results page

      Then I validate I am on the "Grouping Members Dental" page
      Then I click continue on grouping Members Dental page

      Then I validate I am on the "Dental Plan Results" page
      And I click continue on dental plan results page

      Then I validate I am on the "Plan Summary" page
      And I validate the APTC Credit on the Summary page is "<aptc2>"
      And I click continue on plan summary page

      Then I validate I am on the "Financial Help Agreements" page
      And I click on Sign Out in the Header for "Portal"
      Examples:
        |City       |State    |DOB        |County   |Zipcode      |income1  |aptc1      |income2      |expectedAptc2   |aptc2       |DOBmember2 |
        |Leadville  |CO       |01011990   |Lake     |80461        |1500000  |$0.00      |5240000      |$362.74/mo      |-$362.74    |01012007   |

  @SLER-804
  Scenario Outline: SLER-804 -APTCRules - Add a daughter only on 2nd enrollmnent - primary income change
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    # Question not asked during Open Enrollment
    Then I validate I am on the "Report a life change" page
    And I report "Birth" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "<City>" in State "<State>" with dob "<DOB>" in county "<County>" with zipcode "<Zipcode>"
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help

    Then I validate I am on the "Employment Income" page
    Then I select the option "No" to employment

    And I click continue on the Employment Info Page


    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
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

    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the Insurance Company dropdown
    And I select "Rocky Mountain Health Plans / UHC" to filter for desired plan provider
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<aptc1>"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page

    Then I validate I am on the "Pay now" page
    Then I click all done from payment portal page

     # End of initial enrollment

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page

    Then I validate I am on the "Ethnicity and Race" page
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "<DOBmember2>", "Female" and applying "Yes"
      |Primary:Daughter|
    And I mark the Additional member is pregnant as "No"
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Daughter"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    And I click on "Daughter" to edit information from household page

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "<income2>" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    And I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Head of household" tax filing option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Daughter" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I click continue on the health coverage page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's 1 APTC value is "<expectedAptc2>"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<aptc2>"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Portal"
    Examples:
      |City       |State    |DOB        |County   |Zipcode      |income1  |aptc1      |income2      |expectedAptc2   |aptc2       |DOBmember2 |
      |Granby     |CO       |01011990   |Grand    |80446        |1500000  |$0.00      |7500000      |$412.32/mo      |-$412.32    | 01012011  |

  @SLER-1007
  Scenario Outline: SLER-1007 -APTCRules - adding 4 dependents after 2nd enrollment - primary income is static 100K
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    Then I validate I am on the "Report a life change" page
    And I report "MovedToColorado" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "<City>" in State "<State>" with dob "<DOB>" in county "<County>" with zipcode "<Zipcode>"
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help

    # income is 100K
    Then I validate I am on the "Employment Income" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "10000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
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

    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the Insurance Company dropdown
    And I select "Rocky Mountain Health Plans / UHC" to filter for desired plan provider
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<aptc1>"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page

    Then I validate I am on the "Pay now" page
    Then I click all done from payment portal page

     # End of initial enrollment

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

     # Question not asked during Open Enrollment
    Then I validate I am on the "Report a life change" page
    And I report "Marriage" and click continue

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page

    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page

    Then I validate I am on the "Ethnicity and Race" page
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101990", "Female" and applying "Yes"
      |Primary:Spouse|
    And I mark the Additional member is pregnant as "No"
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "DaughterOne", "10102010", "Female" and applying "Yes"
      |Primary:Daughter  |
      |Spouse:Daughter   |
    And I mark the Additional member is pregnant as "No"
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "DaughterOne"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "DaughterTwo", "10102010", "Female" and applying "Yes"
      |Primary:Daughter    |
      |Spouse:Daughter     |
      |DaughterOne:Sister  |
    And I mark the Additional member is pregnant as "No"
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "DaughterTwo"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    #member2
    Then I validate I am on the "Family Overview" page
    And I click plus icon next to member on household page for "Spouse"
    And I click the edit income icon on household page for "Spouse"

    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
     # added member 3
    Then I validate I am on the "Family Overview" page
    And I click plus icon next to member on household page for "DaughterOne"
    And I click the edit income icon on household page for "DaughterOne"

    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue

    Then I validate I am on the "Family Overview" page
    And I click plus icon next to member on household page for "DaughterTwo"
    And I click the edit income icon on household page for "DaughterTwo"

    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
    Then I select "DaughterOne" for who will be claimed as dependent question on the Tax Status page
    Then I select "DaughterTwo" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page
    
    # member 1
    And I validate I am on the "Other Health Coverage" page
    #The question is skipped here because the primary member answered the question in initial enrollment
    Then I click continue on the health coverage page

    # member 2
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    # member 3
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    # member 4
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's 1 APTC value is "<expectedAptc2>"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<planSummaryaptc2>"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Portal"
    Examples:
      | City   | State | DOB      | County | Zipcode | income1 | aptc1 | income2 | expectedAptc2 | planSummaryaptc2 | DOBmember2 |
      | Granby | CO    | 01011990 | Grand  | 80446   | 1500000 | $0.00 | 7500000 | $1237.47/mo   | -$1,237.47        | 01012011   |


  @SLER-802 @SLER-803 @SLER-806 @SLER-809
    Scenario Outline: ELIG - APTCRules - SLER-802, SLER-803 @SLER-806, SLER-809
    # Add a spouse with income in 2nd enrollment - different zip code locations
      When I click create a new account on login page
      Then I click create my account from pre-screen page

      And I enter general mandatory data for "exchange" account creation
      Then I validate I am on the "Login" page
      And  I enter valid credentials to login

      Then I validate I am on the "Account Overview" page
      Then I apply for the current year

      Then I validate I am on the "Let us guide you" page
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button

      Then I validate I am on the "Before you begin" page
      Then I click on continue with  application button on Before you begin page

       # Question not asked during Open Enrollment
      Then I validate I am on the "Report a life change" page
      And I report "MovedToColorado" and click continue

      Then I validate I am on the "Who Are You" page
      Then I select "member" from the who are you question
      And I am a member with City "<City>" in State "<State>" with dob "<DOB>" in county "<County>" with zipcode "<Zipcode>"
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

      Then I validate I am on the "Ethnicity and Race" page
      And I select "Prefer not to answer" for race and ethnicity for "Primary"
      And I click continue on the Race and Ethnicity page
      
      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page

      Then I validate I am on the "Financial Help" page
      And I Apply for financial help
      
      Then I validate I am on the "Employment Info" page
      Then I select the option "No" to employment
      And I click continue on the Employment Info Page

      Then I validate I am on the "Additional income" page
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

      Then I select "Marriage" QLCE on tell us about life changes page
      Then I click on Save and Continue

      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear

      Then I validate I am on the "Good News" page
      Then I click on "No Thanks" on good news page

      Then I validate I am on the "Application History" page
      Then I click on view results and shop

      Then I validate I am on the "Application Results" page
      And I verify that the APTC amount does not appear on the app results page
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
      Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
      And I click continue on start shopping page

      Then I validate I am on the "Medical Plan Results" page
      And I select the Insurance Company dropdown
      And I select "Rocky Mountain Health Plans / UHC" to filter for desired plan provider
      And I select the first medical plan
      And I click continue on medical plan results page

      Then I validate I am on the "Dental Plan Results" page
      And I select first dental plan
      And I click continue on dental plan results page

      Then I validate I am on the "Plan Summary" page
      And I validate the APTC Credit on the Summary page is "<firstplanSummaryAPTC>"
      And I click continue on plan summary page

      Then I validate I am on the "Enrollment Agreements" page
      And I select "Acknowledgement" agreement checkbox
      And I select "Submit" agreement checkbox
      And I enter householder signature on the Enrollment Agreements page
      And I click submit enrollment on Enrollment Agreements page

      Then I validate I am on the "Pay now" page
      Then I click all done from payment portal page

      #end of initial enrollment

      Then I validate I am on the "Account Overview" page
      Then I click on make changes button

      Then I validate I am on the "Let us guide you" page
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button

      Then I validate I am on the "Before you begin" page
      Then I click on continue with  application button on Before you begin page

      # Question not asked during Open Enrollment
      Then I validate I am on the "Report a life change" page
      And I report "MovedToColorado" and click continue

      Then I validate I am on the "Find Expert Help" page
      Then I click Continue on my own button from Manage who helps you page

      Then I select "Male" as sex option
      And I select "Yes" to Are You Applying
      And I click continue on Tell us about yourself page

      Then I validate I am on the "Add Address" page
      And I select "Yes" for CO Resident option
      And I select "No" for Federally Recognized Tribe option
      And I select "No" for Hardship Exemption option
      And I select "No" for Disability option
      And I select "No" to the recently denied medicaid question
      And I select "No" for Incarceration option
      And I click continue on the Add Address page

      Then I validate I am on the "Ethnicity and Race" page
      And I click continue on the Race and Ethnicity page

      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page

      Then I validate I am on the "Family Overview" page
      Then I click Add Another Family Member

      Then I validate I am on the "Add Member" page
      Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101990", "Female" and applying "Yes"
        |Primary:Spouse|

      And I mark the Additional member is pregnant as "No"
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

      Then I validate I am on the "Ethnicity and Race" page
      And I select "Prefer not to answer" for race and ethnicity for "Spouse"
      And I click continue on the Race and Ethnicity page

      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page

      Then I validate I am on the "Family Overview" page

      And I click on "Primary" to edit information from household page

      Then I validate I am on the "Application Summary" page
      Then I select the Edit Income link

      Then I validate I am on the "Employment Info" page
      Then I select the option "No" to employment
      And I click continue on the Employment Info Page

      Then I validate I am on the "Additional income" page
      Then I click continue on the Additional Income page

      Then I validate I am on the "Deductions" page
      Then I click continue on the Deductions page

      Then I validate I am on the "Income Summary" page
      Then I click the save and continue button on the Income Summary Detail page

      Then I validate I am on the "Family Overview" page
      And I click on "Spouse" to edit information from household page

      Then I validate I am on the "Application Summary" page
      Then I select the Edit Income link

      Then I validate I am on the "Employment Info" page
      Then I select the option "Yes" to employment
      Then I select the option "No" to self employment
      Then I enter company details with addressline1 as "1234 test road" and city as "Denver" and state as "CO" and zipcode as "80205" and income "<incomeChange>" at frequency "Annually"
      And I select the option "No" to seasonal employment
      And I select the option "No" to projected income
      And I click continue on the Employment Info Page

      Then I validate I am on the "Employment Info" page
      Then I click continue on the Employment Summary Page

      Then I validate I am on the "Additional income" page
      Then I click None of these as additional income option and continue

      Then I validate I am on the "Deductions" page
      Then I click None of these as deduction option and continue

      Then I validate I am on the "Income Summary" page
      Then I select the projected income option "No" and continue


    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

      And I validate I am on the "Other Health Coverage" page
      Then I click continue on the health coverage page

      And I validate I am on the "Other Health Coverage" page
      And I select "None of these" as health coverage option
      Then I click continue on the health coverage page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page

      Then I validate I am on the "Tell us about life changes" page
      And  I select "MoveToCO" QLCE on tell us about life changes page
      Then I click on Save and Continue

      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear

      Then I validate I am on the "Application History" page
      Then I click on view results and shop

      Then I validate I am on the "Application Results" page
      Then I validate that my Tax Household's 1 APTC value is "<finalapplicationResultAPTC>"
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
      Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
      And I click continue on start shopping page

      Then I validate I am on the "Grouping Members Medical" page
      Then I click continue on grouping Members Medical page

      Then I validate I am on the "Medical Plan Results" page
      And I click continue on medical plan results page

      Then I validate I am on the "Grouping Members Dental" page
      Then I click continue on grouping Members Dental page

      Then I validate I am on the "Dental Plan Results" page
      And I click continue on dental plan results page

      Then I validate I am on the "Plan Summary" page
      And I validate the APTC Credit on the Summary page is "<finalplanSummaryAPTC>"

      And I click continue on plan summary page
      And I click on Sign Out in the Header for "Portal"
      Examples:
       |City     |State      |DOB        |County     |Zipcode   | incomeChange | firstplanSummaryAPTC | finalapplicationResultAPTC | finalplanSummaryAPTC |
       |NewTown  |CO         |01011958   |EAGLE      |81657     |  $7758000     |   $0.00              |   $1278.18/mo             |  -$1,278.18          |
       |NewTown  |CO         |01011958   |LARIMER    |80524     |  $8710000     |   $0.00              |   $868.41/mo              |  -$868.41            |
       |NewTown  |CO         |01011958   |WELD       |80634     |  $6997000     |   $0.00              |   $1073.83/mo             |  -$1,073.83          |
       |NewTown  |CO         |01011958   |PHILLIPS   |80731     |  $4300000     |   $0.00              |   $1676.82/mo             |  -$1,395.11          |

  @SLER-805 @SLER-808
  Scenario Outline: ELIG - APTCRules - SLER-805, SLER-808
    # Add a spouse with income in 2nd enrollment - different zip code locations
    When I click create a new account on login page
    Then I click create my account from pre-screen page

    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

       # Question not asked during Open Enrollment
    Then I validate I am on the "Report a life change" page
    And I report "MovedToColorado" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "<City>" in State "<State>" with dob "<DOB>" in county "<County>" with zipcode "<Zipcode>"
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help

    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page

    Then I validate I am on the "Additional income" page
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

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the Insurance Company dropdown
    And I select "Anthem" to filter for desired plan provider
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<firstplanSummaryAPTC>"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page

    Then I validate I am on the "Pay now" page
    Then I click all done from payment portal page

      #end of initial enrollment

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

      # Question not asked during Open Enrollment
    Then I validate I am on the "Report a life change" page
    And I report "MovedToColorado" and click continue

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page

    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page

    Then I validate I am on the "Ethnicity and Race" page
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101990", "Female" and applying "Yes"
      |Primary:Spouse|

    And I mark the Additional member is pregnant as "No"
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

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page

    And I click on "Primary" to edit information from household page

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Family Overview" page
    And I click on "Spouse" to edit information from household page

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    Then I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 test road" and city as "Denver" and state as "CO" and zipcode as "80205" and income "<incomeChange>" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Info" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I click continue on the health coverage page

    And I validate I am on the "Other Health Coverage" page
    And I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's 1 APTC value is "<finalapplicationResultAPTC>"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<finalplanSummaryAPTC>"

    And I click continue on plan summary page
    And I click on Sign Out in the Header for "Portal"
    Examples:
      |City     |State      |DOB        |County     |Zipcode   | incomeChange | firstplanSummaryAPTC | finalapplicationResultAPTC | finalplanSummaryAPTC |
      |NewTown  |CO         |01011958   |PARK       |80449     |  $6000000     |   $0.00              |   $1170.91/mo             |  -$1,158.37          |
      |NewTown  |CO         |01011958   |PROWERS    |81052     |  $5000000     |   $0.00              |   $1628.10/mo             |  -$1,399.66          |



