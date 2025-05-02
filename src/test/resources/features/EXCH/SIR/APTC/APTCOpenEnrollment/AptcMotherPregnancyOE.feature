@APTCOpenEnrollment
  # SLER-1144
Feature:APTC tests by enrolling in a plan through Admin Portal "OBO"

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-1144
  Scenario Outline: SLER-1144 - ELIG -APTCRules  - mother with future newborn - Open Enrollment
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
    And I am a member with City "<City>" in State "<State>" with dob "<DOB>" in county "<County>" with zipcode "<Zipcode>"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    # pregnancy
    And I select "Yes" as pregnancy option
    Then I select the number of expected babies at "1"
    Then I select the expected birth due date at Future Date "Last Date of Current Month"
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
    And I enter employment details with "<income>" income at "Annually" frequency
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

    Then I validate I am on the "Tell us about life changes" page
    Then I set pregnancy date "First Date of Current Month" on elgibility for pregnancy coverage
    Then I select "Yes" on elgibility for pregnancy coverage
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I validate that my APTC value is "<applicationHistoryAPTC>"
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's 1 APTC value is "<applicationResultAPTC>"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I wait for 2000 milliseconds
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I wait for 2000 milliseconds
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<planSummaryAPTC>"
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
    And I click on Sign Out in the Header for "Portal"
    Examples:
      | City    | State | DOB      | County   | Zipcode | income   | applicationHistoryAPTC | applicationResultAPTC | planSummaryAPTC |
      | NewTown | CO    | 01011990 | EAGLE    | 81657   | $7758000 | $0.00/mo               | $0.00/mo              | $0.00           |

  @SLER-2451
  Scenario Outline: SLER-2451 - ELIG -APTCRules  - mother with future newborn - married - Open Enrollment
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
    And I am a member with City "<City>" in State "<State>" with dob "<DOB>" in county "<County>" with zipcode "<Zipcode>"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    # pregnancy
    And I select "Yes" as pregnancy option
    Then I select the number of expected babies at "1"
    Then I select the expected birth due date at Future Date "Last Date of Current Month"
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
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101990", "Male" and applying "Yes"
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

    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
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
  #income variance
    And I enter employment details with "<income>" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue

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
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
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

    Then I validate I am on the "Tell us about life changes" page
    Then I set pregnancy date "First Date of Current Month" on elgibility for pregnancy coverage
    Then I select "Yes" on elgibility for pregnancy coverage
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I validate that my APTC value is "<applicationHistoryAPTC>"
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's 1 APTC value is "<applicationResultAPTC>"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I wait for 2000 milliseconds
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I wait for 2000 milliseconds
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "<planSummaryAPTC>"
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
    And I click on Sign Out in the Header for "Portal"
    Examples:
      | City    | State | DOB      | County   | Zipcode | income   | income2   | applicationHistoryAPTC | applicationResultAPTC | planSummaryAPTC |
      | NewTown | CO    | 01011990 | EAGLE    | 81657   | $7758000 | $5000000 | $133.75/mo               | $133.75/mo              | -$133.75           |

