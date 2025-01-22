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
  And I initiate incoming page
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
  Then I validate I am on the "Elmo Race and Ethnicity" page
  And I select "Prefer not to answer" for race and ethnicity for "Primary"
  And I click continue on the Race and Ethnicity page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page
  Then I click Add Another Family Member
  Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "03051989", "Female" and applying "Yes"
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
  Then I validate I am on the "Elmo Race and Ethnicity" page
  And I select "Prefer not to answer" for race and ethnicity for "Spouse"
  And I click continue on the Race and Ethnicity page
  Then I validate I am on the "Citizenship" page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page
  Then I click Add Another Family Member
  Then I enter details on tell us about additional members of your household exch page and continue with "SonOne", "01012014", "Male" and applying "Yes"
    | Primary:Son |
    | Spouse:Son  |
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
  Then I validate I am on the "Elmo Race and Ethnicity" page
  And I select "Prefer not to answer" for race and ethnicity for "Son"
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
  Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
  Then I click continue on start shopping page
  Then I click continue on grouping Members Medical page
  And I select the first medical plan
  Then I click continue on medical plan results page
  Then I click continue on grouping Members Dental page
  And I select first dental plan
  Then I click continue on dental plan results page
  Then I validate I am on the "planSummaryMedicalDental" page
  And I click continue on plan summary page
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
    And I initiate incoming page
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
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
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
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
      And I initiate incoming page
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
      Then I validate I am on the "Elmo Race and Ethnicity" page
      And I select "Prefer not to answer" for race and ethnicity for "Primary"
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
      Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
      Then I click continue on start shopping page
      Then I validate I am on the "Medical Plan Results" page
      Then I click skip on medical plan results page
      Then I validate I am on the "Dental Plan Results" page
      Then I click Skip on Dental Plan Results page
      Then I validate I am on the "Plan Summary" page
      And I verify no medical and dental plans are selected on plan summary page
      And I click on Sign Out in the Header for "Elmo"


  @SLER-796
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
    And I initiate incoming page
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
  #Spouse
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "03051986", "Female" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
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
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
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
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page

  @SLER-1085-WIP @EnrollInAPlanCSRLevel3
  Scenario: Husband & Wife enroll in a plan with a CSR Level of 3
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the next year
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "03052000", "Female" and applying "Yes"
      | Primary:Daughter |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    Then I select "No" for Foster care in state of Colorado
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 New dr" and city as "Denver" and state as "CO" and zipcode as "80020" and income "2500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 Main dr" and city as "Denver" and state as "CO" and zipcode as "80020" and income "3200000" at frequency "Annually"
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
    And I select "Head of household" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I Declare as Tax Household 2
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    #Then I validate that there are 2 default groups
    Then I click continue on grouping Members Medical page
    And I select "Cigna Connect Colorado Option Silver" medical plan
    Then I click continue on medical plan results page
    #And I select "Cigna Connect Colorado Option Silver" medical plan
    #Then I click continue on medical plan results page
    #Then I validate that there are 2 default groups
    Then I click continue on grouping Members Dental page
    And I select "Anthem Dental Family Value" plan
    Then I click continue on dental plan results page
    #And I select "Anthem Dental Family Value" plan
    #Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter "taxHolder1" signature on the Financial Help Agreements page
    And I enter "taxHolder2" signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I select "Tax Household 2" under Eligibility

  @SLER-1160
    Scenario: AdminLCE Happy Path 2 'No' into 2 'Yes'
      Given I open the login page on the "login" portal
      And I validate I am on the "Login" page
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
      Then I validate I am on the "Elmo Race and Ethnicity" page
      And I select "Prefer not to answer" for race and ethnicity for "Primary"
      And I click continue on the Race and Ethnicity page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page
      Then I click Add Another Family Member
      Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "03051989", "Female" and applying "Yes"
        | Primary:Spouse |
      And I click continue on Tell us about additional members page
      Then I select "Household" for Residential Address
      And I select "Yes" for CO Resident option
      And I select "No" for Federally Recognized Tribe option
      And I select "No" for Hardship Exemption option
      And I select "No" for Disability option
      And I select "No" to the recently denied medicaid question
      And I select "No" for Incarceration option
      And I click continue on the Add Address page
      Then I validate I am on the "Elmo Race and Ethnicity" page
      And I select "Prefer not to answer" for race and ethnicity for "Spouse"
      And I click continue on the Race and Ethnicity page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page
      Then I click continue on family overview page
      And I Apply for financial help
      Then I select the option "Yes" to employment
      And I select the option "No" to self employment
      Then I enter company details with addressline1 as "101 New dr" and city as "Denver" and state as "CO" and zipcode as "80020" and income "2500000" at frequency "Annually"
      And I select the option "No" to seasonal employment
      And I select the option "No" to projected income
      And I click continue on the Employment Info Page
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
      Then I select "None of these" as ELMO health coverage option
      Then I click continue on the ELMO health coverage page
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
      And I click Back to App Results button on the pop up
      And I click on Sign Out in the Header for "NonElmo"

      Given I open the login page on the "admin" portal
      And I refresh the page
      And I validate I am on the "Login" page
      When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
      And I validate I am on the "Admin search" page
      And I select "individual" checkbox on Admin Portal Dashboard
      Then I enter an accountId in any Env "5910497910" "4007973601" to search user
      And I click on Search button in AP dashboard page
      Then I select the first record from the search results
      And I click "On Behalf Of (OBO)" from application links dropdown
      And I initiate incoming page
      And I apply for the current year
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button
      Then I click on continue with  application button on Before you begin page
      And I report "MovedToColorado" and click continue
      Then I click Continue on my own button from Manage who helps you page
      And I click continue on Tell us about yourself page
      And I click continue on the Add Address page

      Then I validate I am on the "Elmo Race and Ethnicity" page
      And I click continue on the Race and Ethnicity page
      And I click continue on the Citizenship page
      Then I click continue on family overview page
      Then I select "Marriage" QLCE on tell us about life changes page
      Then I click on Save and Continue
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear
      Then I click on view results and shop
      And I click continue on application results page
      Then I validate I am on the "Start Shopping" page

  @SLER-1241-WIP @EnrollAI/ANmemberwithCSRLevel3
  Scenario: Household with AI/AN member and Level 3 CSR eligibility member
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the next year
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "03052000", "Female" and applying "Yes"
      | Primary:Daughter |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    Then I select "No" for Foster care in state of Colorado
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 New dr" and city as "Denver" and state as "CO" and zipcode as "80020" and income "2500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 Main dr" and city as "Denver" and state as "CO" and zipcode as "80020" and income "3200000" at frequency "Annually"
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
    And I select "Head of household" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I Declare as Tax Household 2
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    #Then I validate that there are 2 default groups
    Then I click continue on grouping Members Medical page
    And I select "Cigna Connect Colorado Option Silver" medical plan
    Then I click continue on medical plan results page
    #And I select "Cigna Connect Colorado Option Silver" medical plan
    #Then I click continue on medical plan results page
    #Then I validate that there are 2 default groups
    Then I click continue on grouping Members Dental page
    And I select "Anthem Dental Family Value" plan
    Then I click continue on dental plan results page
    #And I select "Anthem Dental Family Value" plan
    #Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter "taxHolder1" signature on the Financial Help Agreements page
    And I enter "taxHolder2" signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I select "Tax Household 2" under Eligibility


  @SLER-1242-WIP @CSRLevel1andCSRLevel3
  Scenario: Household with one member at Level 1 CSR eligibility and one member at Level 3 CSR eligibility
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the next year
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "03052000", "Female" and applying "Yes"
      | Primary:Daughter |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    Then I select "No" for Foster care in state of Colorado
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 New dr" and city as "Denver" and state as "CO" and zipcode as "80020" and income "2500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 Main dr" and city as "Denver" and state as "CO" and zipcode as "80020" and income "3200000" at frequency "Annually"
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
    And I select "Head of household" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I Declare as Tax Household 2
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    #Then I validate that there are 2 default groups
    Then I click continue on grouping Members Medical page
    And I select "Cigna Connect Colorado Option Silver" medical plan
    Then I click continue on medical plan results page
    #And I select "Cigna Connect Colorado Option Silver" medical plan
    #Then I click continue on medical plan results page
    #Then I validate that there are 2 default groups
    Then I click continue on grouping Members Dental page
    And I select "Anthem Dental Family Value" plan
    Then I click continue on dental plan results page
    #And I select "Anthem Dental Family Value" plan
    #Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter "taxHolder1" signature on the Financial Help Agreements page
    And I enter "taxHolder2" signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I select "Tax Household 2" under Eligibility




