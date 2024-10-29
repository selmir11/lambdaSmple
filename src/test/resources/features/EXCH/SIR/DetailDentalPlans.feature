@dentalPlanDetail @SIR
  # contains SLER-955,
Feature: Dental Plan Verification test

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-955 @VerifyDentalDetailNavigation
  Scenario: SLER-955 - VerifyDentalDetailNavigation - this is a breakaway from RT-1653
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    And I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    # Question not asked during Open Enrollment
    #And I report "MovedToColorado" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "DENVER" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"

    Then I validate I am on the "Identity Proofing - Initial Questions" page
    Then I answer all Id proofing questions and click continue

    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page

    Then I validate I am on the "Find Expert Help Exch" page
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
    And I Apply for no financial help
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    Then I click on the First Dental Detail button

    Then I validate I am on the "Dental Plan Detail" page
    And I click Go Back on the Dental Detail page
    And I click on Sign Out in the Header for "Elmo"


  @SLER-995-WIP @VerifyDentalDetailTextEnglish
  Scenario: SLER-995 - VerifyDentalDetailTextEnglish
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    And I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    # Question not asked during Open Enrollment
    #And I report "MovedToColorado" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"

    Then I validate I am on the "Identity Proofing - Initial Questions" page
    Then I answer all Id proofing questions and click continue

    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page

    Then I validate I am on the "Find Expert Help Exch" page
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
    And I Apply for no financial help
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    Then I click on the First Dental Detail button

    Then I validate I am on the "Dental Plan Detail" page
    And I select the InNetwork link on the Dental Detail page
    And I validate the text headers and subheaders for the InNetwork Dental Detail page
    And I select the OutNetwork link on the Dental Detail page
    And I validate the text headers and subheaders for the OutNetwork Dental Detail page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-996-WIP @VerifyDentalDetailTextSpanish
  Scenario: SLER-996 - VerifyDentalDetailTextSpanish
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    And I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    # Question not asked during Open Enrollment
    #And I report "MovedToColorado" and click continue

    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10012010" in county "DENVER" with zipcode "80205"

    Then I validate I am on the "Identity Proofing - Initial Questions" page
    Then I answer all Id proofing questions and click continue

    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page

    Then I validate I am on the "Find Expert Help Exch" page
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
    And I Apply for no financial help
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    Then I click on the First Dental Detail button

    Then I validate I am on the "Dental Plan Details" page


    # validate that pediatric plan appears due to minor age under 19 - we will verify from the plan title

    And I click on Sign Out in the Header for "Elmo"


