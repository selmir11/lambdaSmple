@SOLRegression
Feature:shopping and enrolling in a plan through Admin Portal "OBO"

@SLER-736
Scenario: Account creation, shopping and enrolling in a plan through Admin Portal "OBO"
  Given I open the login page on the "admin" portal
  And I refresh the page
  And I validate I am on the "Login" page
  When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
  And I validate I am on the "Admin search" page
  Then I click create account on admin portal
  And I enter general mandatory data for "exchange" account creation
  And I validate I am on the "Admin search" page
  And I select "individual" checkbox on Admin Portal Dashboard
  And I search for user and click email from search results
  And I click "On Behalf Of (OBO)" from application links dropdown
  Then I validate I am on the "Account Overview" page
  Then I apply for the current year
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
  Then I click Add Another Family Member
  Then I validate I am on the "Add Member" page
  Then I enter member details with "03051989" date of birth
  And I select "Female" as sex option
  And I select "No" as pregnancy option
  And I select "Spouse" as relationship option
  And I select "Yes" to Is Member Applying
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
  And I select "Prefer not to answer" for race and ethnicity
  And I click continue on the Race and Ethnicity page
  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page
  Then I click Add Another Family Member
  Then I validate I am on the "Add Member" page
  Then I enter member details with age as 10
  And I select "Male" as sex option
  And I select "Son" as relationship option
  And I select "Son" as relationship one option
  And I select "Yes" to Is Member Applying
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
  And I select "Prefer not to answer" for race and ethnicity
  And I click continue on the Race and Ethnicity page
  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page
  Then I click continue on family overview page
  And I Apply for no financial help
  Then I select "MoveToCO" QLCE on tell us about life changes page
  Then I click on Save and Continue
  Then I Declare as Tax Household 1
  And I click Continue on the Declarations And Signature Page
  And I wait for hold on content to disappear
  Then I click on view results and shop
  And I click continue on application results page
  Then I validate I am on the "Start Shopping" page
  Then I click continue on start shopping page
  Then I click continue on grouping Members Medical page
  And I select the first medical plan
  Then I click continue on medical plan results page
  Then I click continue on grouping Members Dental page
  And I select first dental plan
  Then I click continue on dental plan results page
  Then I validate I am on the "planSummaryMedicalDental" page
  And I continue on plan summary page
  And I validate I am on the "Enrollment Agreements" page
  And I select "Acknowledgement" agreement checkbox
  And I select "Submit" agreement checkbox
  And I enter householder signature on the Enrollment Agreements page
  And I click submit enrollment on Enrollment Agreements page
  Then I click all done from payment portal page
  Then I validate I am on the "Account Overview" page


  @SLER-746
  Scenario: Verifies plan summary page for "No plans are selected message" via Admin Portal
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
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
    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    Then I click skip on medical plan results page
    Then I validate I am on the "Dental Plan Results" page
    Then I click Skip on Dental Plan Results page
    And I verify no medical and dental plans are selected on plan summary page
    And I click on Sign Out in the Header for "Elmo"

    @SLER-765
    Scenario: Validate hard stop on plan summary page when no plans selected for FA via OBO
      Given I open the login page on the "admin" portal
      And I refresh the page
      And I validate I am on the "Login" page
      When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
      And I validate I am on the "Admin search" page
      Then I click create account on admin portal
      And I enter general mandatory data for "exchange" account creation
      And I validate I am on the "Admin search" page
      And I select "individual" checkbox on Admin Portal Dashboard
      And I search for user and click email from search results
      And I click "On Behalf Of (OBO)" from application links dropdown
      Then I validate I am on the "Account Overview" page
      Then I apply for the current year
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button
      Then I click on continue with  application button on Before you begin page
      And I report "MovedToColorado" and click continue
      Then I select "member" from the who are you question
  #PrimaryPerson
      And I am a member with City "Denver" in State "CO" with dob "01011991" in county "BOULDER" with zipcode "80502"
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
      Then I validate I am on the "Employment Info" page
      Then I select the option "Yes" to employment
      And I select the option "No" to self employment
      Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "4500000" at frequency "Annually"
      And I select the option "No" to seasonal employment
      And I select the option "No" to projected income
      And I click continue on the Employment Info Page
      Then I validate I am on the "Employment Summary" page
      Then I click continue on the Employment Summary Page
      Then I click None of these as additional income option and continue
      Then I validate I am on the "Deductions" page
      Then I click None of these as deduction option and continue
      Then I select the projected income option "No" and continue

      Then I validate I am on the "Tax status" page
      And I select the option "No" to claim as dependent
      And I select the option "No" to file federal income tax return next year
      And I click save and continue on tax status page

      And I validate I am on the "Elmo Other Health Coverage" page
      Then I select "None of these" as ELMO health coverage option
      Then I click continue on the ELMO health coverage page

      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page
      Then I validate I am on the "Tell us about life changes" page
      Then I select "MoveToCO" QLCE on tell us about life changes page
      Then I click on Save and Continue
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear
      Then I validate I am on the "Application History" page
      Then I click on view results and shop
      And I click continue on application results page
      Then I validate I am on the "Start Shopping" page
      Then I click continue on start shopping page
      Then I validate I am on the "Medical Plan Results" page
      Then I click skip on medical plan results page
      Then I validate I am on the "Dental Plan Results" page
      Then I click Skip on Dental Plan Results page
      Then I validate I am on the "Plan Summary" page
      And I verify no medical and dental plans are selected on plan summary page
      And I click on Sign Out in the Header for "Elmo"


  @SLER-796-WIP
  Scenario: Admin Portal OBO - FA - LCE Marriage
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Marriage" and click continue
    Then I select "member" from the who are you question
    #PrimaryPerson
    And I am a member with City "Denver" in State "CO" with dob "01011982" in county "BOULDER" with zipcode "80502"
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
  #Spouse
    Then I click Add Another Family Member
    Then I enter member details with "10101996" date of birth
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
    And I select "Prefer not to answer" for race and ethnicity
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page


    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 Main dr" and city as "Denver" and state as "CO" and zipcode as "80020" and income "1000000" at frequency "Annually"
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
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    Then I click continue on family overview page
    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I click continue on grouping Members Medical page
    And I select "Anthem Colorado Option Gold Pathway Essentials Std" medical plan
    Then I click continue on medical plan results page
    Then I click continue on grouping Members Dental page
    And I select "Anthem Dental Family Value" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I validate I am on the "Financial Help Agreements" page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    And I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page
    Then I validate I am on the "Initial Payment" page
    #And I click on Sign Out in the Header for "Elmo"