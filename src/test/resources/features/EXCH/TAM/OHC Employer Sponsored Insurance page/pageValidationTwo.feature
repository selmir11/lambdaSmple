@TAM @TamExch
Feature: Page Text-Other Health Coverage Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
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
    And I report "Birth" and click continue
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
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101975", "Female" and applying "Yes"
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
    And I enter employment details with "2500000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    And I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "2000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    And I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    Then I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page

  @SLER-1077 @PageValidationOhiEsiElmo
  Scenario: SLER-1077 I want the family affordability flags aggregated on submitted application
#    Step 5
    Then I select the Go Back button on the ESI page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I select the "0" employer for "Secondary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "314.62" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click "Yes" for offer family plans question
    Then I enter "314.62" for offer family amount question
    Then I click enrollment status for the members
      |      Primary:TypeAccess    |
    Then I click continue on the ESI page
#    Step 6
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text does not display on the Application History page
    Then I validate that "Cost-Sharing Reductions" text does not display on the Application History page
    Then I validate the aptc section doesn't exist on the application history page
    Then I click on view results and shop
    Then I validate the member application results
      |      Primary:Qualified Health Plan   |
      |      Spouse:Qualified Health Plan    |
    And I verify that the APTC amount does not appear on the app results page
#    Step 7
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click on "Spouse" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    And I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I enter "314.63" for employee amount question on the ESI page
    Then I enter "314.63" for offer family amount question
    Then I click continue on the ESI page
#    Step 8
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text displays on the Application History page
    Then I validate that "Cost-Sharing Reductions" text displays on the Application History page
    Then I validate that my APTC value is "894.72/mo"
    Then I click on view results and shop
    Then I validate the member application results
      |      Primary:Premium Tax Credit, Cost-Sharing Reductions, Qualified Health Plan   |
      |      Spouse:Premium Tax Credit, Cost-Sharing Reductions, Qualified Health Plan    |
    Then I validate that my Tax Household's 1 APTC value is "$894.72/mo"
#    Step 9
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click on "Spouse" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    And I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "314.62" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click "Yes" for offer family plans question
    Then I enter "314.62" for offer family amount question
    Then I click enrollment status for the members
      |      Spouse:TypeAccess    |
    Then I click continue on the ESI page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I enter "314.63" for employee amount question on the ESI page
    Then I enter "314.63" for offer family amount question
    Then I click continue on the ESI page
#    Step 10
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text does not display on the Application History page
    Then I validate that "Cost-Sharing Reductions" text does not display on the Application History page
    Then I validate the aptc section doesn't exist on the application history page
    Then I click on view results and shop
    Then I validate the member application results
      |      Primary:Qualified Health Plan   |
      |      Spouse:Qualified Health Plan    |
    And I verify that the APTC amount does not appear on the app results page
#    Step 11
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click on "Spouse" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    And I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I enter "314.62" for employee amount question on the ESI page
    Then I enter "314.62" for offer family amount question
    Then I click continue on the ESI page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I enter "314.63" for employee amount question on the ESI page
    Then I enter "314.63" for offer family amount question
    Then I click continue on the ESI page
#    Step 12
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text does not display on the Application History page
    Then I validate that "Cost-Sharing Reductions" text does not display on the Application History page
    Then I validate the aptc section doesn't exist on the application history page
    Then I click on view results and shop
    Then I validate the member application results
      |      Primary:Qualified Health Plan  |
      |      Spouse:Qualified Health Plan   |
    And I verify that the APTC amount does not appear on the app results page
#    Step 13
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click on "Spouse" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    And I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I enter "314.63" for employee amount question on the ESI page
    Then I enter "314.63" for offer family amount question
    Then I click continue on the ESI page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I enter "314.63" for employee amount question on the ESI page
    Then I enter "314.63" for offer family amount question
    Then I click continue on the ESI page
#    Step 14
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text displays on the Application History page
    Then I validate that "Cost-Sharing Reductions" text displays on the Application History page
    Then I validate that my APTC value is "894.72/mo"
    Then I click on view results and shop
    Then I validate the member application results
      |      Primary:Premium Tax Credit, Cost-Sharing Reductions, Qualified Health Plan   |
      |      Spouse:Premium Tax Credit, Cost-Sharing Reductions, Qualified Health Plan    |
    Then I validate that my Tax Household's 1 APTC value is "$894.72/mo"
#    Step Extra 1
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click on "Spouse" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    And I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I enter "314.62" for employee amount question on the ESI page
    Then I enter "314.63" for offer family amount question
    Then I click continue on the ESI page
#    Step Extra 2
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text displays on the Application History page
    Then I validate that "Cost-Sharing Reductions" text displays on the Application History page
    Then I validate that my APTC value is "338.33/mo"
    Then I click on view results and shop
    Then I validate the member application results
      |      Primary:Premium Tax Credit, Cost-Sharing Reductions, Qualified Health Plan   |
      |      Spouse:Qualified Health Plan    |
    Then I validate that my Tax Household's 1 APTC value is "$338.33/mo"
#    Step Extra 3
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click on "Spouse" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    And I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "314.62" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click "Yes" for offer family plans question
    Then I enter "314.63" for offer family amount question
    Then I click enrollment status for the members
      |      Spouse:TypeAccess    |
    Then I click continue on the ESI page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    Then I enter "314.63" for employee amount question on the ESI page
    Then I enter "314.63" for offer family amount question
    Then I click continue on the ESI page
#    Step Extra 4
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I validate I am on the "Application History" page
    Then I validate that "Qualified Health Plan" text displays on the Application History page
    Then I validate that "Premium Tax Credit" text displays on the Application History page
    Then I validate that "Cost-Sharing Reductions" text displays on the Application History page
    Then I validate that my APTC value is "439.11/mo"
    Then I click on view results and shop
    Then I validate the member application results
      |      Primary:Qualified Health Plan   |
      |      Spouse:Premium Tax Credit, Cost-Sharing Reductions, Qualified Health Plan    |
    Then I validate that my Tax Household's 1 APTC value is "$439.11/mo"

    And I click on Sign Out in the Header for "NonElmo"
