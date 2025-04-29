@SIR @SIREXCH @SIR-EXCH8 @EXCHEndToEnd
  # contains @SLER-1288, SLER-1289,

Feature: End to End testing - single enrollment

Background:
  Given I open the login page on the "login" portal
  And I validate I am on the "Login" page

@SLER-1289
Scenario: SLER-1289 - Familyof10PathSuccessfulToMedicalResultsPage
    #verify family of 10 scenario path to Medical Results page is successful - SIR-2586 scenario2
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
    And I report "MovedToColorado" and click continue

  Then I validate I am on the "Who Are You" page
  Then I select "member" from the who are you question
  And I am a member with City "Example" in State "CO" with dob "01011990" in county "Rio Grande" with zipcode "81144"
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
  Then I click Add Another Family Member

  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011990", "Female" and applying "Yes"
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

  And I select "Prefer not to answer" for race and ethnicity for "Spouse"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member

  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "SonOne", "01012010", "Male" and applying "Yes"
  |Primary:Son|
  |Spouse:Son |
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

  And I select "Prefer not to answer" for race and ethnicity for "SonOne"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member

  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "SonTwo", "01012010", "Male" and applying "Yes"
  |Primary:Son|
  |Spouse:Son |
  |SonOne:Brother|
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

  And I select "Prefer not to answer" for race and ethnicity for "SonTwo"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member
#member 3
  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "SonThree", "01012010", "Male" and applying "Yes"
  |Primary:Son|
  |Spouse:Son |
  |SonOne:Brother|
  |SonTwo:Brother|
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

  And I select "Prefer not to answer" for race and ethnicity for "SonThree"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member
#member 4
  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "SonFour", "01012010", "Male" and applying "Yes"
  |Primary:Son|
  |Spouse:Son |
  |SonOne:Brother|
  |SonTwo:Brother|
  |SonThree:Brother|
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

  And I select "Prefer not to answer" for race and ethnicity for "SonFour"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member

#member 5
  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "SonFive", "01012010", "Male" and applying "Yes"
    |Primary:Son|
    |Spouse:Son |
    |SonOne:Brother|
    |SonTwo:Brother|
    |SonThree:Brother|
    |SonFour:Brother|
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

  And I select "Prefer not to answer" for race and ethnicity for "SonFive"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member

#member 6
  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "SonSix", "01012010", "Male" and applying "Yes"
    |Primary:Son|
    |Spouse:Son |
    |SonOne:Brother|
    |SonTwo:Brother|
    |SonThree:Brother|
    |SonFour:Brother|
    |SonFive:Brother|
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

  And I select "Prefer not to answer" for race and ethnicity for "SonSix"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member

#member 7
  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "SonSeven", "01012010", "Male" and applying "Yes"
    |Primary:Son|
    |Spouse:Son |
    |SonOne:Brother|
    |SonTwo:Brother|
    |SonThree:Brother|
    |SonFour:Brother|
    |SonFive:Brother|
    |SonSix:Brother|
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

  And I select "Prefer not to answer" for race and ethnicity for "SonSeven"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member

#member 8
  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "SonEight", "01012010", "Male" and applying "Yes"
    |Primary:Son|
    |Spouse:Son |
    |SonOne:Brother|
    |SonTwo:Brother|
    |SonThree:Brother|
    |SonFour:Brother|
    |SonFive:Brother|
    |SonSix:Brother|
    |SonSeven:Brother|
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

  And I select "Prefer not to answer" for race and ethnicity for "SonEight"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member

#member 9
  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "SonNine", "01012010", "Male" and applying "Yes"
    |Primary:Son|
    |Spouse:Son |
    |SonOne:Brother|
    |SonTwo:Brother|
    |SonThree:Brother|
    |SonFour:Brother|
    |SonFive:Brother|
    |SonSix:Brother|
    |SonSeven:Brother|
    |SonEight:Brother|
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

  And I select "Prefer not to answer" for race and ethnicity for "SonNine"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member

#member 10
  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "SonTen", "01012010", "Male" and applying "Yes"
    |Primary:Son|
    |Spouse:Son |
    |SonOne:Brother|
    |SonTwo:Brother|
    |SonThree:Brother|
    |SonFour:Brother|
    |SonFive:Brother|
    |SonSix:Brother|
    |SonSeven:Brother|
    |SonEight:Brother|
    |SonNine:Brother|
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

  And I select "Prefer not to answer" for race and ethnicity for "SonTen"
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
And I enter employment details with "10000000" income at "Annually" frequency
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

#secondary member 1 below
Then I validate I am on the "Employment Info" page
Then I select the option "No" to employment
And I click continue on the Employment Info Page

Then I validate I am on the "Additional income" page
Then I click None of these as additional income option and continue

Then I validate I am on the "Deductions" page
Then I click None of these as deduction option and continue

Then I validate I am on the "Income Summary" page
Then I select the projected income option "No" and continue
#secondary member 2 below
Then I validate I am on the "Employment Info" page
Then I select the option "No" to employment
And I click continue on the Employment Info Page

Then I validate I am on the "Additional income" page
Then I click None of these as additional income option and continue

Then I validate I am on the "Deductions" page
Then I click None of these as deduction option and continue

Then I validate I am on the "Income Summary" page
Then I select the projected income option "No" and continue
#secondary member 3 below
Then I validate I am on the "Employment Info" page
Then I select the option "No" to employment
And I click continue on the Employment Info Page

Then I validate I am on the "Additional income" page
Then I click None of these as additional income option and continue

Then I validate I am on the "Deductions" page
Then I click None of these as deduction option and continue

Then I validate I am on the "Income Summary" page
Then I select the projected income option "No" and continue

#secondary member 4 below
Then I validate I am on the "Employment Info" page
Then I select the option "No" to employment
And I click continue on the Employment Info Page

Then I validate I am on the "Additional income" page
Then I click None of these as additional income option and continue

Then I validate I am on the "Deductions" page
Then I click None of these as deduction option and continue

Then I validate I am on the "Income Summary" page
Then I select the projected income option "No" and continue

#secondary member 4 below
Then I validate I am on the "Employment Info" page
Then I select the option "No" to employment
And I click continue on the Employment Info Page

Then I validate I am on the "Additional income" page
Then I click None of these as additional income option and continue

Then I validate I am on the "Deductions" page
Then I click None of these as deduction option and continue

Then I validate I am on the "Income Summary" page
Then I select the projected income option "No" and continue

#secondary member 5 below
  Then I validate I am on the "Employment Info" page
  Then I select the option "No" to employment
  And I click continue on the Employment Info Page

  Then I validate I am on the "Additional income" page
  Then I click None of these as additional income option and continue

  Then I validate I am on the "Deductions" page
  Then I click None of these as deduction option and continue

  Then I validate I am on the "Income Summary" page
  Then I select the projected income option "No" and continue

#secondary member 6 below
  Then I validate I am on the "Employment Info" page
  Then I select the option "No" to employment
  And I click continue on the Employment Info Page

  Then I validate I am on the "Additional income" page
  Then I click None of these as additional income option and continue

  Then I validate I am on the "Deductions" page
  Then I click None of these as deduction option and continue

  Then I validate I am on the "Income Summary" page
  Then I select the projected income option "No" and continue

#secondary member 7below
  Then I validate I am on the "Employment Info" page
  Then I select the option "No" to employment
  And I click continue on the Employment Info Page

  Then I validate I am on the "Additional income" page
  Then I click None of these as additional income option and continue

  Then I validate I am on the "Deductions" page
  Then I click None of these as deduction option and continue

  Then I validate I am on the "Income Summary" page
  Then I select the projected income option "No" and continue

#secondary member 8 below
  Then I validate I am on the "Employment Info" page
  Then I select the option "No" to employment
  And I click continue on the Employment Info Page

  Then I validate I am on the "Additional income" page
  Then I click None of these as additional income option and continue

  Then I validate I am on the "Deductions" page
  Then I click None of these as deduction option and continue

  Then I validate I am on the "Income Summary" page
  Then I select the projected income option "No" and continue

#secondary member 9 below
  Then I validate I am on the "Employment Info" page
  Then I select the option "No" to employment
  And I click continue on the Employment Info Page

  Then I validate I am on the "Additional income" page
  Then I click None of these as additional income option and continue

  Then I validate I am on the "Deductions" page
  Then I click None of these as deduction option and continue

  Then I validate I am on the "Income Summary" page
  Then I select the projected income option "No" and continue

  #secondary member 10 below
  Then I validate I am on the "Employment Info" page
  Then I select the option "No" to employment
  And I click continue on the Employment Info Page

  Then I validate I am on the "Additional income" page
  Then I click None of these as additional income option and continue

  Then I validate I am on the "Deductions" page
  Then I click None of these as deduction option and continue

  Then I validate I am on the "Income Summary" page
  Then I select the projected income option "No" and continue

# move to Tax Status
  Then I validate I am on the "Tax status" page
  Then I select "No" for will you be claimed as dependent question
  Then I select "Yes" for will file tax return question
  Then I select the "Married filing jointly" tax filing option on the Tax Status page
  Then I select "Spouse" as filing jointly with option on the Tax Status page
  Then I select "Yes" for will claim dependents question
  Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
  Then I select "SonOne" for who will be claimed as dependent question on the Tax Status page
  Then I select "SonTwo" for who will be claimed as dependent question on the Tax Status page
  Then I select "SonThree" for who will be claimed as dependent question on the Tax Status page
  Then I select "SonFour" for who will be claimed as dependent question on the Tax Status page
  Then I select "SonFive" for who will be claimed as dependent question on the Tax Status page
  Then I select "SonSix" for who will be claimed as dependent question on the Tax Status page
  Then I select "SonSeven" for who will be claimed as dependent question on the Tax Status page
  Then I select "SonEight" for who will be claimed as dependent question on the Tax Status page
  Then I select "SonNine" for who will be claimed as dependent question on the Tax Status page
  Then I select "SonTen" for who will be claimed as dependent question on the Tax Status page
  Then I click Save and Continue on Tax Status page

  #primary
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 1 below
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 2 below
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 3 below
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 4 below
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 5 below
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 6 below
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 7 below
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 8 below
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 9 below
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 10 below
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  #secondary member 11 below
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
  Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
  And I click continue on start shopping page

  Then I validate I am on the "Grouping Members Medical" page
  And I click continue on grouping Members Medical page

  Then I validate I am on the "Medical Plan Results" page
  Then I click on Sign Out in the Header for "Portal"

@SLER-1288
Scenario: SLER-1288 - Test out Smoker/Non-smoker divergence to the Medical Plan Results page - SIR-2586 scenario2
  # - SIR-2586 scenario2 - husband and spouse diverge on smoking selection
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

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

  Then I validate I am on the "Family Overview" page
  Then I click Add Another Family Member

  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011990", "Female" and applying "Yes"
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

  And I select "Prefer not to answer" for race and ethnicity for "Spouse"
  And I click continue on the Race and Ethnicity page

  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page

  Then I click continue on family overview page

  Then I validate I am on the "Financial Help" page
  And I Apply for financial help
  Then I select the option "Yes" to employment
  And I select the option "No" to self employment
  And I enter employment details with "50000.00" income at "Annually" frequency
  And I select the option "No" to seasonal employment
  And I select the option "No" to projected income
  And I click continue on the Employment Info Page
  Then I click continue on the Employment Summary Page
  Then I validate I am on the "Additional income" page
  Then I click None of these as additional income option and continue
  Then I validate I am on the "Deductions" page
  Then I click None of these as deduction option and continue
  Then I validate I am on the "Income Summary" page
  Then I select the projected income option "No" and continue

  Then I select the option "Yes" to employment
  And I select the option "No" to self employment
  Then I enter company details with addressline1 as "1234 town" and city as "Denver" and state as "CO" and zipcode as "80205" and income "50000.00" at frequency "Annually"
  And I select the option "No" to seasonal employment
  And I select the option "No" to projected income
  And I click continue on the Employment Info Page
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
  Then I select "Yes" for will claim dependents question
  Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
  Then I click Save and Continue on Tax Status page

  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page

  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page

  Then I validate I am on the "Family Overview" page
  Then I click continue on family overview page

  Then I validate I am on the "Tell us about life changes" page
  Then I select "MoveToCO" QLCE on tell us about life changes page
  Then I click on Save and Continue

  Then I validate I am on the "EXCH Declarations and Signature" page
  And I Declare as Tax Household 1
  And I click Continue on the Declarations And Signature Page
  And I wait for hold on content to disappear

  Then I validate I am on the "Application History" page
  Then I click on view results and shop

  Then I validate I am on the "Application Results" page
  And I click continue on application results page

  Then I validate I am on the "Start Shopping" page
  Then I click "Yes" to the Tobacco usage question on start shopping page for "Primary,Spouse"
  And I click continue on start shopping page

  Then I validate I am on the "Grouping Members Medical" page
  And I click continue on grouping Members Medical page

  Then I validate I am on the "Medical Plan Results" page
  And I click on Sign Out in the Header for "Portal"


