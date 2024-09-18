Feature: UI Tests related to APTC after initial enrollment

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

@SLER-1007-WIP
    # Income of 1001k for one then re-enroll to add 4 dependents
  Scenario: ELIG-APTC Eligible - APTCRules Adding Dependents - formerly RT-2345
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page

    And I report "MovedToColorado" and click continue

    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011990" in county "Denver" with zipcode "80205"
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

    Then I click continue on the Employment Summary Page
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

    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I validate that my APTC value is "$0.00/mo"
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I validate that my Tax Household's APTC value is "$0.00/mo"
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

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with Name "Spouse", DOB "10101990", Gender "Female" and applying status "Yes"
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

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click on Member Row 2

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

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
    And I click save and continue on tax status page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with Name "SonOne", DOB "10102019", Gender "Male" and applying status "Yes"
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

Then I validate I am on the "Citizenship" page
Then I select "Yes" for Citizen option
And I select "No" for Naturalized Immigrant option
And I click continue on the Citizenship page

Then I validate I am on the "Family Overview" page
Then I click on Member Row 3

Then I validate I am on the "Application Summary" page
Then I select the Edit Income link

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
And I click save and continue on tax status page

And I validate I am on the "Elmo Other Health Coverage" page
Then I click continue on the ELMO health coverage page
And I validate I am on the "Elmo Other Health Coverage" page
Then I click continue on the ELMO health coverage page


And I validate I am on the "Elmo Other Health Coverage" page
Then I select "None of these" as ELMO health coverage option
Then I click continue on the ELMO health coverage page

Then I validate I am on the "Family Overview" page
Then I click Add Another Family Member

Then I validate I am on the "Add Member" page
Then I enter details on tell us about additional members of your household exch page and continue with Name "SonTwo", DOB "10102021", Gender "Male" and applying status "Yes"
|Primary:Son      |
|Spouse:Son       |
|SonOne:Brother  |

Then I validate I am on the "Add Address" page
Then I select "Household" for Residential Address
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

Then I validate I am on the "Family Overview" page
Then I click on Member Row 4

Then I validate I am on the "Application Summary" page
Then I select the Edit Income link

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
    #And I select the second dependent
And I select the third dependent
    ## increased incrementally


And I click save and continue on tax status page
    ## tax status page for first minor appearing??


    # tax status dependant - minor
    #Then I validate I am on the "Tax status dependent" page
    #And I select the option "Yes" to claim as dependent
    #And I select the "1" option for Who Will Claim as Dependent
    #And I click save and continue on tax status page

     ##### transition stops
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page

### transition step is repeated for each new member  - 2nd re-enrollment
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
### transition step is repeated for each new member
##
##
    Then I validate I am on the "Family Overview" page
    Then I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with Name "SonThree", DOB "10102020", Gender "Male" and applying status "Yes"
    |Primary:Son      |
    |Spouse:Son       |
    |SonOne:Brother   |
    |SonTwo:Brother   |
    #And I mark the Additional member is pregnant as "No"
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

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click on Member Row 5

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    #Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    #Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue

    ## tax status page review here
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "Yes" to claim dependents
    ### transition step is repeated for each new member after each new member added - 2nd re-enrollment
    And I select the first dependent
    And I select the second dependent
    And I select the third dependent
    And I select the fourth dependent
    ## increased incrementally
    Then I validate I am on the "Household" page
    #And I click save and continue on tax status page


    # tax status
    Then I validate I am on the "Tax status dependent" page
    Then I will select the option "Yes" that I will be claimed as a dependent
    And I select the "1" option for Who Will Claim as Dependent
    And I click save and continue on tax status page
    #repeat?
    Then I validate I am on the "Tax status dependent" page
    Then I will select the option "Yes" that I will be claimed as a dependent
    And I select the "1" option for Who Will Claim as Dependent
    And I click save and continue on tax status page

    ##### transition stops
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
### transition step is repeated for each new member  - 2nd re-enrollment
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
### transition step is repeated for each new member
  # verify this section above - Primary was given a Click continue as opposed to being deactivate

    ##Tax status review here
    Then I validate I am on the "Family Overview" page
    Then I click Add Another Family Member

    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with Name "SonFour", DOB "10102022", Gender "Male" and applying status "Yes"
    |Primary:Son      |
    |Spouse:Son       |
    |SonOne:Brother   |
    |SonTwo:Brother   |
    |SonThree:Brother |
    #And I mark the Additional member is pregnant as "No"
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

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click on Member Row 5

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    #Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    #Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue

    ### tax status review

    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "Yes" to claim dependents
    ### transition step is repeated for each new member after each new member added - 2nd re-enrollment
    #pre-existing setting is honored
    #And I select the first dependent
    #pre-existing setting is honored
    #And I select the second dependent
    #pre-existing setting is honored
    #And I select the third dependent
    #pre-existing setting is honored
    #And I select the fourth dependent
    #pre-existing setting is honored
    And I select the fifth dependent
    ## increased incrementally
    And I click save and continue on tax status page

    # tax status dependant
    Then I validate I am on the "Tax status dependent" page
    Then I will select the option "Yes" that I will be claimed as a dependent
    And I select the "1" option for Who Will Claim as Dependent
    And I click save and continue on tax status page

##### transition stops
    #And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
    # deactivated the above function
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I click continue on the ELMO health coverage page
### transition step is repeated for each new member  - 2nd re-enrollment
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
### transition step is repeated for each new member

    #
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
    Then I validate that my APTC value is "$1134.70/mo"
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

