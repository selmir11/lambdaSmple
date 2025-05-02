@SIR @SIREXCH @SIR-EXCH15 @MedicalPDF
  # contains SLER-2009, 2400, 2401, 2402-WIP, 2403, 2404
Feature: Medical Plan Detail page related tests

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-2009
    # application properties - pdf testing row must be set to "yes" otherwise this will fail
  Scenario Outline: SLER-2009 - Validate the Anthem document download process (Medical)
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
    Then I select "MoveToCO" QLCE on tell us about life changes page
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
    And I select the Insurance Company dropdown
    And I select "<carrierOption>" to filter for desired plan provider
    And I select the first plan detail

    Then I validate I am on the "Medical Plan Detail" page
    And I validate the "<carrierDocs>" document upload links for the Medical Detail page
    Then I click on Sign Out in the Header for "Portal"
    Examples:
      | carrierOption | carrierDocs |
      | Anthem        | Anthem      |

  @SLER-2400
    # application properties - pdf testing row must be set to "yes" otherwise this will fail
  Scenario Outline: SLER-2400 - Validate the Rocky Mountain Health document download process (Medical)
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
    Then I select "MoveToCO" QLCE on tell us about life changes page
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
    And I select the Insurance Company dropdown
    And I select "<carrierOption>" to filter for desired plan provider
    And I select the first plan detail

    Then I validate I am on the "Medical Plan Detail" page

    And I validate the "<carrierDocs>" document upload links for the Medical Detail page
    Then I click on Sign Out in the Header for "Portal"
    Examples:
      | carrierOption                     | carrierDocs |
      | Rocky Mountain Health Plans / UHC | Rocky       |

  @SLER-2402-WIP
    # application properties - pdf testing row must be set to "yes" otherwise this will fail
  Scenario Outline: SLER-2402-WIP - Validate the Cigna document download process (Medical)
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
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare as Tax Household 1
    Then I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page

    Then I validate I am on the "Start Shopping" page

    Then I validate I am on the "Medical Plan Results" page
    And I select the Insurance Company dropdown
    And I select "<carrierOption>" to filter for desired plan provider
    And I select the first plan detail

    And I validate the "<carrierDocs>" document upload links for the Medical Detail page
    Then I click on Sign Out in the Header for "Portal"
    Examples:
      | carrierOption | carrierDocs |
      | Cigna Healthcare                  | Cigna       |

  @SLER-2403
    # application properties - pdf testing row must be set to "yes" otherwise this will fail
  Scenario Outline: SLER-2403 - Validate the Denver Health document download process (Medical)
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
    Then I select "MoveToCO" QLCE on tell us about life changes page
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
    And I select the Insurance Company dropdown
    And I select "<carrierOption>" to filter for desired plan provider
    And I select the first plan detail

    Then I validate I am on the "Medical Plan Detail" page

    And I validate the "<carrierDocs>" document upload links for the Medical Detail page
    Then I click on Sign Out in the Header for "Portal"
    Examples:
      | carrierOption       | carrierDocs |
      | Denver Health       | Denver      |

  @SLER-2401
    # application properties - pdf testing row must be set to "yes" otherwise this will fail
  Scenario Outline: SLER-2401 - Validate the Kaiser document download process (Medical)
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
    Then I select "MoveToCO" QLCE on tell us about life changes page
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
    And I select the Insurance Company dropdown
    And I select "<carrierOption>" to filter for desired plan provider
    And I select the first plan detail

    Then I validate I am on the "Medical Plan Detail" page

    And I validate the "<carrierDocs>" document upload links for the Medical Detail page
    Then I click on Sign Out in the Header for "Portal"
    Examples:
      | carrierOption         | carrierDocs |
      | Kaiser Permanente     | Kaiser      |



  @SLER-2404
    # application properties - pdf testing row must be set to "yes" otherwise this will fail
  Scenario Outline: SLER-2404 - Validate the Select Health document download process (Medical)
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
    Then I select "MoveToCO" QLCE on tell us about life changes page
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
    And I select the Insurance Company dropdown
    And I select "<carrierOption>" to filter for desired plan provider
    And I select the first plan detail

    Then I validate I am on the "Medical Plan Detail" page

    And I validate the "<carrierDocs>" document upload links for the Medical Detail page
    Then I click on Sign Out in the Header for "Portal"
    Examples:
      | carrierOption                     | carrierDocs |
      | Select Health                     | Select      |


