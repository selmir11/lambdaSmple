@APTC,@APTC-SIR, @APTC-SIR-Single

  # SLER-1036,
Feature: UI Tests related to APTC after initial enrollment

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-1036
  Scenario: ELIG-APTCRules - verify initial APTC calculation - linked to EXCH Plan Load SIR-2505 - 10k - Good News path
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I click on continue with  application button on Before you begin page

    And I report "MovedToColorado" and click continue

    Then I select "member" from the who are you question
  # location change
    And I am a member with City "Denver" in State "CO" with dob "01011971" in county "DENVER" with zipcode "80220"
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

    And I select "Prefer not to answer" for race and ethnicity
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
    And I enter employment details with "1000000" income at "Annually" frequency
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

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
  # APTC variance
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
    And I click on Sign Out in the Header for "Portal"

  @SLER-1006
  Scenario Outline: ELIG -APTCRules - SLER-1006 - linked to EXCH Plan Load SIR-2505 - verify initial APTC calculations
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page

    #need to remove LCE step during OE
    And I report "MovedToColorado" and click continue

    Then I select "member" from the who are you question
  # location change
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

    And I select "Prefer not to answer" for race and ethnicity
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
    Then I validate that my APTC value is "<applicationHistoryAPTC>"
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's 1 APTC value is "<applicationResultAPTC>"
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
      | NewTown | CO    | 01011958 | EAGLE    | 81657   | $7758000 | $848.24/mo            | $848.24/mo             | -$848.24        |
      | NewTown | CO    | 01011958 | LARIMER  | 80524   | $8710000 | $414.00/mo            | $414.00/mo             | -$414.00        |
      | NewTown | CO    | 01011958 | WELD     | 80634   | $6997000 | $504.52/mo            | $504.52/mo             | -$504.52        |
      | NewTown | CO    | 01011958 | PARK     | 80449   | $6000000 | $554.32/mo            | $554.32/mo             | -$554.32        |
      | NewTown | CO    | 01011958 | PROWERS  | 81052   | $5000000 | $1154.84/mo           | $1154.84/mo            | -$1,028.25      |
      | NewTown | CO    | 01011958 | PHILLIPS | 80731   | $4300000 | $1241.85/mo           | $1241.85/m             | -$1,166.73      |

