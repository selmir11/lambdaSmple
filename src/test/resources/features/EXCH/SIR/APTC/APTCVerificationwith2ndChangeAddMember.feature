@APTC,@APTC-SIR, @APTC-SIR-AddMember
  #SLER-325, @SLER-802, @SLER-803, SLER-804, @SLER-805, @SLER-806, SLER-807, @SLER-808, @SLER-809, SLER-998, SLER-999,
Feature: UI Tests related to APTC after second enrollment change

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-325
  Scenario: SLER-325- ELIG- APTCRules - formerly RT-2397 - born 1982 and 2011
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
#     And I report "Marriage" and click continue

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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
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

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

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
    #And I select "Prefer not to answer" for race and ethnicity for "Primary"
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
    Then I click save and continue on tax status page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page

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
    Then I validate that my Tax Household's 1 APTC value is "$1134.70/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$1,028.25"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Portal"


    @SLER-999
    Scenario Outline: SLER-999 - ELIG - APTCRules  - 1 member add enrollment - income change - formerly RT-2346
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
#     And I report "MovedToColorado" and click continue

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
      And I select the option "No" to claim as dependent
      And I select the option "Yes" to file federal income tax return next year
      And I select "Single" tax filing status
      And I select "No" to claim dependents
      And I click save and continue on tax status page

      And I validate I am on the "Elmo Other Health Coverage" page
      Then I select "None of these" as ELMO health coverage option
      Then I click continue on the ELMO health coverage page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page

      Then I select "Marriage" QLCE on tell us about life changes page
      Then I click on Save and Continue

      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear

      Then I validate I am on the "Good News" page
      And I click on No Thanks on good news page

      Then I validate I am on the "Application History" page
      Then I click on view results and shop

      Then I validate I am on the "Application Results" page

      And I verify that the APTC amount does not appear on the app results page
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
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
      # end of initial enrollment

      Then I validate I am on the "Account Overview" page
      Then I click on make changes button

      Then I validate I am on the "Let us guide you" page
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button

      Then I validate I am on the "Before you begin" page
      Then I click on continue with  application button on Before you begin page

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
      #And I select "Prefer not to answer" for race and ethnicity for "Primary"
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
      #
      Then I validate I am on the "Employment Info" page
      Then I select the option "Yes" to employment
      And I select the option "No" to self employment
      And I enter employment details with "<income2>" income at "Annually" frequency
      And I select the option "No" to seasonal employment
      And I select the option "No" to projected income
      And I click continue on the Employment Info Page
      #
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
      And I select the option "No" to claim as dependent
      And I select the option "Yes" to file federal income tax return next year
      And I select "Married filing jointly" tax filing status
      And I select spouse to file taxes jointly
      And I select "No" to claim dependents
      And I click save and continue on tax status page

      And I validate I am on the "Elmo Other Health Coverage" page
      Then I click continue on the ELMO health coverage page

      And I validate I am on the "Elmo Other Health Coverage" page
      Then I select "None of these" as ELMO health coverage option
      Then I click continue on the ELMO health coverage page

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
      And I click continue on start shopping page

      Then I validate I am on the "Grouping Members Medical" page
      Then I click continue on grouping Members Medical page

      Then I validate I am on the "Medical Plan Results" page
      And I select the Insurance Company dropdown
      And I select "Cigna Healthcare" to filter for desired plan provider
      And I select the first medical plan
      And I click continue on medical plan results page

      Then I validate I am on the "Grouping Members Dental" page
      Then I click continue on grouping Members Dental page

      Then I validate I am on the "Dental Plan Results" page
      And I select first dental plan
      And I click continue on dental plan results page

      Then I validate I am on the "Plan Summary" page
      And I validate the APTC Credit on the Summary page is "<postAPTCSummaryResult>"
      And I click continue on plan summary page

      Then I validate I am on the "Financial Help Agreements" page
      And I click on Sign Out in the Header for "Portal"
      Examples:
      |income1      |income2    | expectedInitialAPTCResult | initialAPTCSummaryResult |expectedPostAPTCResult| postAPTCSummaryResult |
      |1500000      |1500000    | $0.00/mo                  | $0.00                    | $878.11/mo           | -$853.40              |


  @SLER-998
  Scenario Outline: SLER-998 - ELIG - APTCRules - 1 member add enrollment - income change - formerly RT-2344
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

    #Not available during Open Enrollment
#    And I report "MovedToColorado" and click continue

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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

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

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

#    Then I validate I am on the "Report a life change" page
#    And I report "Marriage" and click continue

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
    #And I select "Prefer not to answer" for race and ethnicity option for "Primary"
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
      #
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "<income2>" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
      #
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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

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
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the Insurance Company dropdown
    And I select "Cigna Healthcare" to filter for desired plan provider
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<postAPTCSummaryResult>"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Portal"
    Examples:
      |income1      |income2    | expectedInitialAPTCResult | initialAPTCSummaryResult |expectedPostAPTCResult| postAPTCSummaryResult |
      |10000000     |1000000    | $0.00/mo                  | $0.00                     |  $101.07/mo         | -$101.07              |



  @SLER-807
      # ELIG-APTCRules - SLER - 807 - formerly RT-2400
    Scenario Outline: SLER-807 - APTCRules - formerly RT-2400 - Add a daughter on 2nd enrollmnent
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

      #Not available during Open Enrollment
#      And I report "MovedToColorado" and click continue

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
      And I select the option "No" to claim as dependent
      And I select the option "Yes" to file federal income tax return next year
      And I select "Single" tax filing status
      And I select "No" to claim dependents
      And I click save and continue on tax status page

      And I validate I am on the "Elmo Other Health Coverage" page
      Then I select "None of these" as ELMO health coverage option
      Then I click continue on the ELMO health coverage page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page

      Then I select "MoveToCO" QLCE on tell us about life changes page
      Then I click on Save and Continue

      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear

      Then I validate I am on the "Good News" page
      And I click on No Thanks on good news page

      Then I validate I am on the "Application History" page
      Then I click on view results and shop

      Then I validate I am on the "Application Results" page
      And I verify that the APTC amount does not appear on the app results page
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
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

#      Then I validate I am on the "Report a life change" page
#      And I report "Marriage" and click continue

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
      #And I select "Prefer not to answer" for race and ethnicity option for "Primary"
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
      And I select the option "No" to claim as dependent
      And I select the option "Yes" to file federal income tax return next year
      And I select "Married filing jointly" tax filing status
      And I select spouse to file taxes jointly
      And I select "Yes" to claim dependents
      And I select the first dependent
      And I click save and continue on tax status page

      And I validate I am on the "Elmo Other Health Coverage" page
      Then I click continue on the ELMO health coverage page

      And I validate I am on the "Elmo Other Health Coverage" page
      Then I select "None of these" as ELMO health coverage option
      Then I click continue on the ELMO health coverage page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page

      Then I validate I am on the "Tell us about life changes" page
      And  I select "LostCoverage" QLCE on tell us about life changes page
      Then I click on Save and Continue

      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear

      #### Good News insert
      Then I validate I am on the "Good News" page
      And I click on No Thanks on good news page

      Then I validate I am on the "Application History" page
      Then I click on view results and shop

      Then I validate I am on the "Application Results" page
      Then I validate that my Tax Household's 1 APTC value is "<expectedAptc2>"
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
      And I click continue on start shopping page

      Then I validate I am on the "Grouping Members Medical" page
      Then I click continue on grouping Members Medical page

      Then I validate I am on the "Medical Plan Results" page
      And I select the Insurance Company dropdown
      And I select "Rocky Mountain Health Plans / UHC" to filter for desired plan provider
      And I select the first medical plan
      And I click continue on medical plan results page

      Then I validate I am on the "Grouping Members Dental" page
      Then I click continue on grouping Members Dental page

      Then I validate I am on the "Dental Plan Results" page
      And I select first dental plan
      And I click continue on dental plan results page

      Then I validate I am on the "Plan Summary" page
      And I validate the APTC Credit on the Summary page is "<aptc2>"
      And I click continue on plan summary page

      Then I validate I am on the "Financial Help Agreements" page
      And I click on Sign Out in the Header for "Portal"
      Examples:
        |City       |State    |DOB        |County   |Zipcode      |income1  |aptc1      |income2      |expectedAptc2   |aptc2       |DOBmember2 |
        |Leadville  |CO       |01011990   |Lake     |80461        |1500000  |$0.00      |5240000      |$310.05/mo      |-$310.05    |01012007   |

  @SLER-804
  Scenario Outline: SLER-804 -APTCRules - formerly RT-2411 - Add a daughter on 2nd enrollmnent - primary income change
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
#    And I report "Birth" and click continue

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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
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

#    Then I validate I am on the "Report a life change" page
#    And I report "Marriage" and click continue

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
    #And I select "Prefer not to answer" for race and ethnicity for "Primary"
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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "Yes" to claim dependents
    And I select the first dependent
    And I click save and continue on tax status page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

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
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the Insurance Company dropdown
    And I select "Rocky Mountain Health Plans / UHC" to filter for desired plan provider
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<aptc2>"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Portal"
    Examples:
      |City       |State    |DOB        |County   |Zipcode      |income1  |aptc1      |income2      |expectedAptc2   |aptc2       |DOBmember2 |
      |Granby     |CO       |01011990   |Grand    |80446        |1500000  |$0.00      |7500000      |$334.42/mo      |-$334.42    | 01012011  |

  @SLER-1007
  Scenario Outline: SLER-1007 -APTCRules - adding 4 dependents after 2nd enrollment - primary income is static 100K - formerly RT-2345
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
#    And I report "MovedToColorado" and click continue

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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

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
    #And I select "Prefer not to answer" for race and ethnicity for "Primary"
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
    
    # edit income information
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

    # added member 2
    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown 3
    And I click the edit income 6


    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
        # added member 4
    Then I validate I am on the "Family Overview" page
    And I click plus icon next to member on household page for "DaughterTwo"
    And I click the edit income icon on household page for "DaughterTwo"

    # added member 3
    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown 4
    And I click the edit income 9


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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "Yes" to claim dependents
    And I select the first dependent
    And I select the second dependent
    And I select the third dependent
    And I click save and continue on tax status page
    
    # member 1
    And I validate I am on the "Elmo Other Health Coverage" page
    #The question is skipped here because the primary member answered the question in initial enrollment
    Then I click continue on the ELMO health coverage page

    # member 3
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    # member 4
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

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
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the Insurance Company dropdown
    And I select "Rocky Mountain Health Plans / UHC" to filter for desired plan provider
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<planSummaryaptc2>"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Portal"
    Examples:
      | City   | State | DOB      | County | Zipcode | income1 | aptc1 | income2 | expectedAptc2 | planSummaryaptc2 | DOBmember2 |
      | Granby | CO    | 01011990 | Grand  | 80446   | 1500000 | $0.00 | 7500000 | $1100.40/mo   | -$1100.40        | 01012011   |


  @SLER-802 @SLER-803 @SLER-805 @SLER-806 @SLER-808 @SLER-809
    Scenario Outline: ELIG - APTCRules - SLER-802/RT-2398, SLER-803/RT-2399, SLER-805/RT-2401, SLER-806/RT-2405, SLER-808/RT-2412, SLER-809/RT-2413
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

#      Then I validate I am on the "Report a life change" page
#      And I report "MovedToColorado" and click continue

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
      And I select the option "No" to claim as dependent
      And I select the option "Yes" to file federal income tax return next year
      And I select "Single" tax filing status
      And I select "No" to claim dependents
      And I click save and continue on tax status page

      And I validate I am on the "Elmo Other Health Coverage" page
      Then I select "None of these" as ELMO health coverage option
      Then I click continue on the ELMO health coverage page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page

      Then I select "Marriage" QLCE on tell us about life changes page
      Then I click on Save and Continue

      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear

      Then I validate I am on the "Good News" page
      And I click on No Thanks on good news page

      Then I validate I am on the "Application History" page
      Then I click on view results and shop

      Then I validate I am on the "Application Results" page
      And I verify that the APTC amount does not appear on the app results page
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
      And I click continue on start shopping page

      Then I validate I am on the "Medical Plan Results" page
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

      Then I validate I am on the "Account Overview" page
      Then I click on make changes button

      Then I validate I am on the "Let us guide you" page
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button

      Then I validate I am on the "Before you begin" page
      Then I click on continue with  application button on Before you begin page

#      Then I validate I am on the "Report a life change" page
#      And I report "MovedToColorado" and click continue

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
      #And I select "Prefer not to answer" for race and ethnicity for "Primary"
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
      And I select "Married filing jointly" tax filing status
      And I select spouse to file taxes jointly
      And I select "No" to claim dependents
      Then I click save and continue on tax status page

      And I validate I am on the "Elmo Other Health Coverage" page
      Then I click continue on the ELMO health coverage page

      And I validate I am on the "Elmo Other Health Coverage" page
      And I select "None of these" as ELMO health coverage option
      Then I click continue on the ELMO health coverage page

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
      Then I validate that my Tax Household's 1 APTC value is "<finalapplicationResultAPTC>"
      Then I click continue on application results page

      Then I validate I am on the "Start Shopping" page
      And I click continue on start shopping page

      Then I validate I am on the "Grouping Members Medical" page
      Then I click continue on grouping Members Medical page

      Then I validate I am on the "Medical Plan Results" page
      And I select the first medical plan
      And I click continue on medical plan results page

      Then I validate I am on the "Grouping Members Dental" page
      Then I click continue on grouping Members Dental page

      Then I validate I am on the "Dental Plan Results" page
      And I select first dental plan
      And I click continue on dental plan results page

      Then I validate I am on the "Plan Summary" page
      And I validate the APTC Credit on the Summary page is "<finalplanSummaryAPTC>"
      # -$265.98
      And I click continue on plan summary page

      #Then I validate I am on the "Financial Help Agreements" page
      #And I select the terms and agreements checkbox
      #And I enter householder signature on the Financial Help Agreements page
      #And I click continue on Financial Help Agreements page

      #Then I validate I am on the "Enrollment Agreements" page
      #And I select "Acknowledgement" agreement checkbox
      #And I select "Submit" agreement checkbox
      #And I enter householder signature on the Enrollment Agreements page
      #And I click submit enrollment on Enrollment Agreements page

      #Then I validate I am on the "Pay now" page
      And I click on Sign Out in the Header for "Portal"
      Examples:
        |City     |State      |DOB        |County     |Zipcode   | incomeChange | firstplanSummaryAPTC | finalapplicationResultAPTC | finalplanSummaryAPTC |
        |NewTown  |CO         |01011958   |EAGLE      |81657     |  $7758000     |   $0.00              |   $1424.52/mo             |  -$1,386.83          |
        |NewTown  |CO         |01011958   |LARIMER    |80524     |  $8710000     |   $0.00              |   $831.20/mo              |  -$831.20            |
        |NewTown  |CO         |01011958   |WELD       |80634     |  $6997000     |   $0.00              |   $975.10/mo              |  -$975.10            |
        |NewTown  |CO         |01011958   |PARK       |80449     |  $6000000     |   $0.00              |   $1070.29/mo             |  -$977.74          |
        |NewTown  |CO         |01011958   |PROWERS    |81052     |  $5000000     |   $0.00              |   $1863.58/mo             |  -$1,638.87          |
        |NewTown  |CO         |01011958   |PHILLIPS   |80731     |  $4300000     |   $0.00              |   $1938.62/mo             |  -$1,938.62          |


