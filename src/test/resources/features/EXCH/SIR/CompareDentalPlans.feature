@SIR-EXCH1 @Dental @DentalCompare
  # SLER-80, SLER-727, SLER-1037, SLER-1921, SLER-1927, SLER-2443
Feature: Medical Plan Results page related tests

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

   @SLER-80 @CompareDentalPlansLink
  Scenario: SLER-80 - Validate the Navigation and Functionality of Compare Plans Link (Dental)
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
     And I report "Birth" and click continue

    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    And I select "Male" as sex option
    Then I select "Yes" to Are You Applying
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
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I click on the compare links on the first 2 dental plans
    Then I click on the compare dental button

    Then I validate I am on the "Dental Plan Compare" page
    And I click Go Back on the Dental Compare page
    Then I click on Sign Out in the Header for "DentalPlanResults"

  @SLER-727 @DentalCompareTextValidation
  Scenario: SLER-727 - Validate the Text on Compare Plans page (Dental)
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
    And I select "Male" as sex option
    Then I select "Yes" to Are You Applying
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
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I click on the compare links on the first 2 dental plans
    Then I click on the compare dental button

    Then I validate I am on the "Dental Plan Compare" page
    And I validate the text headers and subheaders for the InNetwork Dental Compare page
    And I select the OutNetwork link on the Dental Compare page
    And I validate the text headers and subheaders for the OutNetwork Dental Compare page
    And I select the InNetwork link on the Dental Compare page
    And I click Go Back on the Dental Compare page

    Then I validate I am on the "Dental Plan Results" page
    Then I click on Sign Out in the Header for "DentalPlanResults"

   @SLER-1037 @DentalCompareNavigation
  Scenario: SLER-1037 - Validate the Navigation from the Dental Plan Results page to the Compare Plans page (Dental)
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
    And I select "Male" as sex option
    Then I select "Yes" to Are You Applying
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
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I click on the compare links on the first 2 dental plans
    Then I click on the compare dental button

    Then I validate I am on the "Dental Plan Compare" page
    And I click Go Back on the Dental Compare page

    Then I validate I am on the "Dental Plan Results" page
    And I click on the compare links on the first 2 dental plans
    Then I click on the compare dental button

    Then I validate I am on the "Dental Plan Compare" page
    And I click Go Back Link on the Dental Compare page

    Then I validate I am on the "Dental Plan Results" page
    Then I click on Sign Out in the Header for "DentalPlanResults"

  @SLER-1921 @DentalCompareHeaderExpandCollapse
  Scenario: SLER-1921 - Validate the Expand and Collapse Functionality for the Compare Plans page (Dental)
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
    And I select "Male" as sex option
    Then I select "Yes" to Are You Applying
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
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I click on the compare links on the first 2 dental plans
    Then I click on the compare dental button

    Then I validate I am on the "Dental Plan Compare" page
    And I click Go Back on the Dental Compare page

    Then I validate I am on the "Dental Plan Results" page
    And I click on the compare links on the first 2 dental plans
    Then I click on the compare dental button

    Then I validate I am on the "Dental Plan Compare" page
    And I will validate the expand all and collapse all header functionality for the Dental Compare page
    And I click Go Back Link on the Dental Compare page

    Then I validate I am on the "Dental Plan Results" page
    Then I click on Sign Out in the Header for "DentalPlanResults"

  @SLER-1927 @DentalCompareSpecificHeaderExpandCollapse
  Scenario: SLER-1927- Validate the Expand and Collapse Functionality for a specific header on the Compare Plans page (Dental)
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
    And I select "Male" as sex option
    Then I select "Yes" to Are You Applying
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
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I click on the compare links on the first 2 dental plans
    Then I click on the compare dental button

    Then I validate I am on the "Dental Plan Compare" page
    And I click Go Back on the Dental Compare page

    Then I validate I am on the "Dental Plan Results" page
    And I click on the compare links on the first 2 dental plans
    Then I click on the compare dental button

    Then I validate I am on the "Dental Plan Compare" page
    And I will validate the expand and collapse header functionality for a specific header on the Dental Compare page
    And I click Go Back Link on the Dental Compare page

    Then I validate I am on the "Dental Plan Results" page
    Then I click on Sign Out in the Header for "DentalPlanResults"


    @SLER-2443
    Scenario: SLER-2443 - Validate the Navigation and Functionality of Compare Page Detail Link (Dental)
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
      And I report "Birth" and click continue

      Then I select "member" from the who are you question
      And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
      Then I answer all Id proofing questions and click continue
      And I click continue button on Congratulations page

      Then I validate I am on the "Find Expert Help" page
      Then I click Continue on my own button from Manage who helps you page
      And I select "Male" as sex option
      Then I select "Yes" to Are You Applying
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
      Then I select "Birth" QLCE on tell us about life changes page
      Then I click on Save and Continue
      And I Declare as Tax Household 1
      Then I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear
      Then I click on view results and shop
      And I click continue on application results page

      Then I validate I am on the "Start Shopping" page
      Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
      Then I click continue on start shopping page

      Then I validate I am on the "Medical Plan Results" page
      And I select the first medical plan
      Then I click continue on medical plan results page

      Then I validate I am on the "Dental Plan Results" page
      And I wait for 2000 milliseconds
      And I click the Dental Insurance Company Dropdown
      And I select "Delta Dental" to filter for a Dental Insurance Company
      And I click on the compare links on the first 2 dental plans
      Then I click on the compare dental button

      Then I validate I am on the "Dental Plan Compare" page
      And I wait for 2000 milliseconds
      And I click detail link "1" on the Dental Compare page

      Then I validate I am on the "Dental Plan Detail" page
      And I wait for 2000 milliseconds
      Then I click Go Back on the Dental Detail page

      Then I validate I am on the "Dental Plan Results" page
      And I wait for 2000 milliseconds
      And I click the Dental Insurance Company Dropdown
      And I select "Delta Dental" to filter for a Dental Insurance Company
      And I click on the compare links on the first 2 dental plans
      Then I click on the compare dental button

      Then I validate I am on the "Dental Plan Compare" page
      And I wait for 2000 milliseconds
      And I click detail link "2" on the Dental Compare page

      Then I validate I am on the "Dental Plan Detail" page
      And I wait for 2000 milliseconds
      Then I click Go Back on the Dental Detail page

      Then I validate I am on the "Dental Plan Results" page
      Then I click on Sign Out in the Header for "DentalPlanResults"










