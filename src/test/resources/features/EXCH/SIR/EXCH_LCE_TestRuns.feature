@SIR @SIREXCH @SIR-EXCH9 @SIR-LCE
  # SLER-2011, SLER-2012, SLER-2013, SLER-2014, SLER-2015, SLER-2016, SLER-2017,
Feature: LCE Test Runs
  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-2017 @VerifyLCEBirth
  Scenario: SLER-2017 - VerifyLCEBirth
    When I click create a new account on login page

    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page

    Then I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation

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

    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "SonOne", "101012024", "Male" and applying "Yes"
      |Primary:Son    |

    Then I validate I am on the "Add Member" page
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

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "SonOne"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    And I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    And I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I click on Sign Out in the Header for "Portal"

  @SLER-2016 @VerifyLCEMarriage
  Scenario: SLER-2016 - VerifyLCEMarriage
    When I click create a new account on login page

    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page

    Then I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation

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

    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101991", "Female" and applying "Yes"
      |Primary:Spouse    |

    Then I validate I am on the "Add Member" page
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

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    And I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    And I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I click on Sign Out in the Header for "Portal"

  @SLER-2015 @VerifyLCEColorado
  Scenario: SLER-2015 - VerifyLCEColorado
    When I click create a new account on login page

    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page

    Then I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation

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

    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101991", "Female" and applying "Yes"
      |Primary:Spouse    |

    Then I validate I am on the "Add Member" page
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

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
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
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    And I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I click on Sign Out in the Header for "Portal"


  @SLER-2014 @VerifyLCEChangePrimaryResidence
  Scenario: SLER-2014 - VerifyLCEPrimaryResidence
    When I click create a new account on login page

    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page

    Then I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation

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

    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101991", "Female" and applying "Yes"
      |Primary:Spouse    |

    Then I validate I am on the "Add Member" page
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

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page


    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "ChangePrimaryResidence" QLCE on tell us about life changes page
    Then I click on Save and Continue

    And I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    And I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I click on Sign Out in the Header for "Portal"


  @SLER-2013 @VerifyLCEGainedLawfulPresence
  Scenario: SLER-2013 - VerifyLCEGainedLawfulPresence
    When I click create a new account on login page

    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page

    Then I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation

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

    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101991", "Female" and applying "Yes"
      |Primary:Spouse    |

    Then I validate I am on the "Add Member" page
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

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "GainedLawfulPresence" QLCE on tell us about life changes page
    Then I click on Save and Continue

    And I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    And I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I click on Sign Out in the Header for "Portal"

  @SLER-2012 @VerifyLCELostCoverage
  Scenario: SLER-2012 - VerifyLCELostCoverage
    When I click create a new account on login page

    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page

    Then I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation

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

    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101991", "Female" and applying "Yes"
      |Primary:Spouse    |

    Then I validate I am on the "Add Member" page
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

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page


    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    And I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click "No" to the Tobacco usage question on start shopping page for "Spouse" coco
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    And I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I click on Sign Out in the Header for "Portal"

  @SLER-2011 @VerifyLCEGainOfTribalStatus
  Scenario: SLER-2011 - VerifyLCEGainOfTribalStatus
    When I click create a new account on login page

    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page

    Then I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation

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

    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page

    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "10101991", "Female" and applying "Yes"
      |Primary:Spouse    |

    Then I validate I am on the "Add Member" page
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

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "GainOfTribalStatus" QLCE on tell us about life changes page
    Then I click on Save and Continue

    And I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click "No" to the Tobacco usage question on start shopping page for "Spouse" coco
    And I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    And I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I click on Sign Out in the Header for "Portal"



