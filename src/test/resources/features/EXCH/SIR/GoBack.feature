@SIR
Feature: Dental Plans page tests

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-35 @SLER-718 @SelectGoBackFromAgreementsToPreShopping
  Scenario: Navigation thru the SIR pages to the first Agreement page and back to the Pre-shopping page - individual
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
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
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    
    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    Then I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I continue on plan summary page
    
    Then I validate I am on the "Enrollment Agreements" page
    And I click Go Back on the Enrollment Agreements page

    Then I validate I am on the "Plan Summary" page
    And I click Go Back on the Plan Summary page

    Then I validate I am on the "Dental Plan Results" page
    Then I click Go Back on Dental Plan Results page
    
    Then I validate I am on the "Medical Plan Results" page
    Then I click Go Back on the medical plan results page

    Then I validate I am on the "Start Shopping" page
    And I click on Sign Out in the Header for "Elmo"

  @SelectGoBackFromAgreementsToPreShoppingSingleGrouping @SLER-734
  Scenario: Navigation thru the SIR pages to the first Agreement page and back to the Pre-shopping page - one group
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I enter member details with "10101981" date of birth
    And I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Spouse" as relationship option
    And I select "Yes" to Is Member Applying
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
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
    Then I click continue on start shopping page

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

    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I click Go Back on the Enrollment Agreements page

    Then I validate I am on the "Plan Summary" page
    And I click Go Back on the Plan Summary page

    Then I validate I am on the "Dental Plan Results" page
    Then I click Go Back on Dental Plan Results page

    Then I validate I am on the "Grouping Members Dental" page
    And I click Go Back on the Dental Grouping page

    Then I validate I am on the "Medical Plan Results" page
    Then I click Go Back on the medical plan results page

    Then I validate I am on the "Grouping Members Medical" page
    And I click Go Back on the Medical Grouping page

    Then I validate I am on the "Start Shopping" page
    And I click on Sign Out in the Header for "Elmo"

  @SelectGoBackFromAgreementsToPreShoppingMultiGrouping @SLER-735-WIP
  Scenario: Navigation thru the SIR pages to the first Agreement page and back to the Pre-shopping page - Multi groups
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I enter member details with "10101981" date of birth
    And I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Spouse" as relationship option
    And I select "Yes" to Is Member Applying
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
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

    Then I click Add Another Family Member
    Then I enter member details with "10101981" date of birth
    And I select "Male" as sex option

    And I select "Other" as relationship option
    And I select "Brother" as relationship one option

    And I select "Yes" to Is Member Applying
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
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

    Then I click Add Another Family Member
    Then I enter member details with "10101981" date of birth
    And I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"

    And I select "Spouse" as relationship option
    And I select "Other" as relationship one option
    And I select "Other" as relationship two option

    And I select "Yes" to Is Member Applying
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
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

    Then I click on the Member Row 3
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I select the option "No" to employment
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I click on the Member Row 3
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I select the option "No" to employment
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I click on the Member Row 4
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I select the option "No" to employment
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

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
    Then I click continue on start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page

    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page

    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    Then I click continue on dental plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    Then I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I click Go Back on the Enrollment Agreements page

    Then I validate I am on the "Plan Summary" page
    And I click Go Back on the Plan Summary page

    Then I validate I am on the "Dental Plan Results" page
    Then I click Go Back on Dental Plan Results page

    Then I validate I am on the "Dental Plan Results" page
    Then I click Go Back on Dental Plan Results page

    Then I validate I am on the "Grouping Members Dental" page
    And I click Go Back on the Dental Grouping page

    Then I validate I am on the "Medical Plan Results" page
    Then I click Go Back on the medical plan results page

    Then I validate I am on the "Medical Plan Results" page
    Then I click Go Back on the medical plan results page

    Then I validate I am on the "Grouping Members Medical" page
    And I click Go Back on the Medical Grouping page

    Then I validate I am on the "Start Shopping" page
    And I click on Sign Out in the Header for "Elmo"