@SIRRegression
Feature:APTC recalculation tests

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question

  @SLER-802 @SLER-803 @SLER-804 @SLER-805 @SLER-806   @SLER-808-WIP-T-2405 @SLER-809-WIP-RT-2412
  Scenario Outline: APTC Re-Calculation with family of 2 - Husband+Wife
  #Husband
    And I am a member with City "Denver" in State "CO" with dob "<Dob1>" in county "<County>" with zipcode "<Zipcode>"
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
    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
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
    # ohi
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on No Thanks on good news page
    Then I validate I am on the "Application History" page
    Then I validate the aptc section doesn't exist on the application history page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    Then I click continue on dental plan results page
    Then I validate I am on the "Plan Summary" page
    Then I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page
    And I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I click all done from payment portal page

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
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
     #Wife
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "<Dob2>", "Female" and applying "Yes"
      | Primary:Spouse |
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
    And I click on "Primary" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "<income>" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page
    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Family Overview" page
    And I click on "Spouse" to edit information from household page
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
      # ohi
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I validate that my APTC value is "<expectedAptc>"
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "<expectedAptc>"
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    Then I validate the APTC Credit on the Summary page is "<aptc1>"
    And I click on Sign Out in the Header for "Elmo"
    # 6th scenario - 1116.97 -> after plan selection 1,010.92
    # 7th scenario - 1112.22 -> after plan selection 1,034.11

    Examples:
      | Dob1     | County   | Zipcode | Dob2     | income  | expectedAptc | aptc1     |
      | 01011981 | EAGLE    | 81657   | 01011983 | 7758000 | $700.01/mo   | -$700.01  |
      | 01011970 | Larimer  | 80524   | 01011973 | 8710000 | $757.66/mo   | -$757.66  |
      | 01011982 | Grand    | 80446   | 01012011 | 7500000 | $381.25/mo   | -$381.25  |
      | 01011970 | Phillips | 80731   | 01011973 | 4300000 | $1835.22/mo  | -$1,835.22 |
      | 01011983 | Weld     | 80634   | 01011989 | 6097000 | $524.94/mo   | -$524.94  |
        #  | 01011981 | Prowers  | 81052   | 01011983 | 5000000 | $1112.22/mo  | -$1112.22 |
       #   | 01011981 | Park     | 80449   | 01011958 | 6000000 | $1116.97/mo  | -$1116.97 |


  @SLER-807
  Scenario Outline: APTC Re-Calculation with family of 2 - Husband+Wife with medicaid
  #Husband
    And I am a member with City "Denver" in State "CO" with dob "<Dob1>" in county "<County>" with zipcode "<Zipcode>"
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
    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
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
    # ohi
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on No Thanks on good news page
    Then I validate I am on the "Application History" page
    Then I validate the aptc section doesn't exist on the application history page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    Then I click continue on dental plan results page
    Then I validate I am on the "Plan Summary" page
    Then I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page
    And I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I click all done from payment portal page

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
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
     #Wife
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "<Dob2>", "Female" and applying "Yes"
      | Primary:Spouse |
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
    And I click on "Primary" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "<income>" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page
    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Family Overview" page
    And I click on "Spouse" to edit information from household page
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
      # ohi
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on No Thanks on good news page
    Then I validate I am on the "Application History" page
    Then I validate that my APTC value is "<expectedAptc>"
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "<expectedAptc>"
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I validate that there are 1 default groups
    Then I click continue on grouping Members Medical page
    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    And I validate that there are 1 default dental groups
    Then I click continue on grouping Members Dental page
    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    Then I validate the APTC Credit on the Summary page is "<aptc1>"
    And I click on Sign Out in the Header for "Elmo"

    Examples:
      | Dob1     | County   | Zipcode | Dob2     | income  | expectedAptc | aptc1     |
      | 01011985 | Lake     | 80461   | 01012007 | 5240000 | $330.31/mo   | -$330.31  |









