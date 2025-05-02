@SIR @SIREXCH @SIR-EXCH20

  # SLER-2396, SLER-2398, SLER-2479
Feature: UI Tests related to green banner check after initial enrollment

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page


  @SLER-2396
  Scenario: SLER-2396 - one group green banner check - verify English green banner for individual who enrolled twice - includes Go Back navigation - 10k
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
    And I report "Marriage" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011981" in county "TELLER" with zipcode "80863"
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

    Then I validate I am on the "Race and Ethnicity" page
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
    And I enter employment details with "1000000" income at "Annually" frequency
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
#2nd enrollment with Green Banner verification

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

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

    #Primary
    Then I validate I am on the "Race and Ethnicity" page
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page

    And I click on "Primary" to edit information from household page

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Info" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "5160000"
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
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the current plan green banner "English" on the Medical Plan Results page
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I validate the current plan green banner "English" text on the Dental Plan Results page
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click Go Back on the Plan Summary page

    Then I validate I am on the "Dental Plan Results" page
    And I validate the current plan green banner "English" text on the Dental Plan Results page
    Then I click Go Back on Dental Plan Results page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the current plan green banner "English" on the Medical Plan Results page
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Portal"

  @SLER-2398
  Scenario: SLER-2398 - one group green banner check - verify Spanish green banner for individual who enrolled twice - includes Go Back navigation - 10k
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
    And I report "Marriage" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011981" in county "TELLER" with zipcode "80863"
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

    Then I validate I am on the "Race and Ethnicity" page
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
    And I enter employment details with "1000000" income at "Annually" frequency
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
#2nd enrollment with Green Banner verification

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

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

    #Primary
    Then I validate I am on the "Race and Ethnicity" page
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page

    And I click on "Primary" to edit information from household page

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Info" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "5160000"
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
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I change the language from header to "Spanish"
    And I validate the current plan green banner "Spanish" on the Medical Plan Results page
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I validate the current plan green banner "Spanish" text on the Dental Plan Results page
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click Go Back on the Plan Summary page

    Then I validate I am on the "Dental Plan Results" page
    And I validate the current plan green banner "Spanish" text on the Dental Plan Results page
    Then I click Go Back on Dental Plan Results page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the current plan green banner "Spanish" on the Medical Plan Results page
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Portal"

@SLER-2479
  Scenario: SLER-2479 - Green banner for Two Tax household grouping  - group of 2  - two different zip codes - mother/daughter (daughter is under 25) -two tax households
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
    #Then I validate I am on the "Report a life change" page
    And I report "MovedToColorado" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Example" in State "CO" with dob "01011980" in county "Rio Grande" with zipcode "81144"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page

    Then I select "Female" as sex option
    And I select "No" as pregnancy option
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

    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    #Age 23
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "10102000", "Female" and applying "Yes"
      |Primary:Daughter|
    And I mark the Additional member is pregnant as "No"
    And I click continue on Tell us about additional members page

    Then I validate I am on the "Add Address" page
    And I select "New" for Residential Address
    And I enter a new residential address with city "Example" state "CO" zip "80923" and county "EL PASO"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I select "No" for Foster care in state of Colorado
    And I click continue on the Add Address page

    And I select "Prefer not to answer" for race and ethnicity for "Daughter"
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
    And I enter employment details with "3000000" income at "Annually" frequency
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
    #2nd member
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "3000000" income at "Annually" frequency
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

    #member 1 - single
    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    #member 2 - single
    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    Then I Declare as Tax Household 2
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Daughter"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    #Then I validate that there are 2 default groups
    And I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    #Then I validate that there are 2 default groups
    And I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I wait for 2000 milliseconds
    And I select the terms and agreements checkbox
    And I enter "taxHolder1" signature on the Financial Help Agreements page
    And I enter "taxHolder2" signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page

    Then I validate I am on the "Pay now" page
    Then I click all done from payment portal page

  #2nd enrollment with Green Banner verification

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    Then I select new relationship of members to primary
    | Daughter:Father |
    And I click continue on Tell us about yourself page


    Then I validate I am on the "Add Address" page
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page

    #Primary
    Then I validate I am on the "Race and Ethnicity" page
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    Then I Declare as Tax Household 2
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Daughter"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    #Then I validate that there are 2 default groups
    And I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the current plan green banner "English" on the Medical Plan Results page
    And I change the language from header to "Spanish"
    And I validate the current plan green banner "Spanish" on the Medical Plan Results page
    And I change the language from header to "English"
    And I click continue on medical plan results page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the current plan green banner "English" on the Medical Plan Results page
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    And I wait for 2000 milliseconds
    #Then I validate that there are 2 default groups
    And I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I validate the current plan green banner "English" text on the Dental Plan Results page
    And I click continue on dental plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I validate the current plan green banner "English" text on the Dental Plan Results page
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Portal"
