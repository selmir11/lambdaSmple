Feature:  Unable to shop (not eligible for QHP)

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-28 @NVOExchRegression
  Scenario: Verify that user not able to shop (not Colorado resident)
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
    Then I select "New" for Residential Address
    And I enter a new residential address with city "Los Angeles" state "CA" zip "90005" and county "LOS ANGELES"
    Then I enter member with address line1 "1234 Road" in city "Los Angeles" in state "CA" with zipcode "90005" and county "LOS ANGELES"
    And I select "No" for CO Resident option
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
    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    Then I verify text that the member don't qualify for a health plan on the app results page
    And I click on Sign Out in the Header for "NonElmo"

  @SLER-29 @NVOExchRegression
  Scenario: Verify that user not able to shop (not applying for health coverage)
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
    And I report "LostCoverage" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "No" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    Then I verify text that the member don't qualify for a health plan on the app results page
    And I click on Sign Out in the Header for "NonElmo"

    @SLER-33  @NVOExchRegression
    Scenario: 1 member, no LCE, not allowed to shop during the Closed Enrollment period
      When I click create a new account on login page
      Then I click create my account from pre-screen page
      And I enter general mandatory data for "exchange" account creation
      Then I validate I am on the "Login" page
      And  I enter valid credentials to login
      Then I apply for the current year
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button
      Then I click on continue with  application button on Before you begin page
      And I report "Birth" and click continue
      Then I select "member" from the who are you question
      And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
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
      Then I click continue on family overview page
      Then I validate I am on the "Financial Help" page
      And I Apply for financial help
      Then I select the option "Yes" to employment
      And I select the option "No" to self employment
      And I enter employment details with "2800000" income at "Annually" frequency
      And I select the option "No" to seasonal employment
      And I select the option "No" to projected income
      And I click continue on the Employment Info Page
      Then I click continue on the Employment Summary Page
      Then I click None of these as additional income option and continue
      Then I validate I am on the "Deductions" page
      Then I click None of these as deduction option and continue
      Then I select the projected income option "No" and continue
      And I select the option "No" to claim as dependent
      And I select the option "Yes" to file federal income tax return next year
      And I select "Single" tax filing status
      And I select "No" to claim dependents
      And I click save and continue on tax status page
      Then I select "None of these" as ELMO health coverage option
      Then I click continue on the ELMO health coverage page
      Then I click continue on family overview page
      Then I select "NoneOfThese" QLCE on tell us about life changes page
      Then I click on Save and Continue
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear
      Then I click on view results and shop
      And I click continue on application results page
      And I verify pop up text on the application results page "English"
      And I click Back to App Results button on the pop up
      And I wait for 9000 milliseconds
      When I change the language from header to "Spanish NonElmo"
      And I click continue on application results page
      And I verify pop up text on the application results page "Spanish"
      And I click Back to App Results button on the pop up
      And I click on Sign Out in the Header for "NonElmo"
      Then I validate I am on the "Login" page