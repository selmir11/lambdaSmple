Feature: Seed06 - Exchange

  Background: Seed 06 For Exchange- Family of Four - FA
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "11281986" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "03051989", "Female" and applying "Yes"
      |Primary:Spouse|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    And I select "Household" for Residential Address
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
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "04212013", "Female" and applying "Yes"
      |Primary:Daughter|
      |Spouse:Daughter|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    And I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Daughter"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Son", "12222016", "Male" and applying "Yes"
      |Primary:Son|
      |Spouse:Son|
      |Daughter:Brother|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    And I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Son"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "8000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Daughter" for who will be claimed as dependent question on the Tax Status page
    Then I select "Son" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page

    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    And I click on Sign Out in the Header for "NonElmo"

    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin dashboard" page
    And I search for user and click email from search results
    And I click "Admin LCE" from application links dropdown
    And I look up with account id on admin tool page
    And I change effective date to "0101" of "current year" from admin portal
    Then logout from Admin Portal

    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Eligibility"
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    And I validate I am on the "Medical Plan Results" page
    And I select "Cigna Connect Colorado Option Bronze" medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    And I validate I am on the "Dental Plan Results" page
    And I select "Delta Dental of Colorado Family Comprehensive Plan" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

    @SLER-1834-WIP_@R4V
    Scenario: RT-2306 ENR-EXCH: USER INITIATED DISENROLLMENT (TERM) - DENTAL - ALL MEMBERS - ADMIN OBO
      Given I open the login page on the "admin" portal
      And I validate I am on the "Login" page
      When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
      And I validate I am on the "Admin dashboard" page
      And I search for user and click email from search results
      And I click "On Behalf Of (OBO)" from application links dropdown
      And I initiate incoming page
      Then I validate I am on the "Account Overview" page
      Then I click on ClickHere link for "My Plans"
      Then I validate I am on the "My Policies" page
      And I click on "Cancel Dental Plan" button
      And I validate I am on the "Cancellation Request" page
      Then I affirm and cancel the active plan
      Then I click continue on Cancellation Request page
      Then I click Okay on Thank you popup
      And I click on Sign Out in the Header for "Elmo"

  @SLER-2034-WIP-@R4V
    Scenario: RT-2322 ENR-EXCH: APPS - CHANGE OF SUBSCRIBER
      Given I open the login page on the "login" portal
      And I validate I am on the "Login" page
      And I enter valid credentials to login
      Then I validate I am on the "Account Overview" page
      Then I click on make changes button
      Then I select "No" option on the Let us guide you page
      And I click on save and continue button
      Then I click on continue with  application button on Before you begin page
      And I report "Other" and click continue
      And I click Continue With Application button on Report Life Change Page
      Then I validate I am on the "Find Expert Help" page
      Then I click Continue on my own button from Manage who helps you page
      Then I validate I am on the "Tell us about yourself" page
      Then I select "No" to Are You Applying
      Then I click continue on Tell us about yourself page
      Then I validate I am on the "Add Address" page
      Then I click continue on the Add Address page
      And I click continue on the Race and Ethnicity page
      Then I click continue on the Immigration Status page
      Then I validate I am on the "Family Overview" page
      Then I click continue on family overview page
      Then I validate I am on the "Tell us about life changes" page
      Then I select "NoneOfThese" QLCE on tell us about life changes page
      Then I click on Save and Continue
      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear
      Then I validate I am on the "Application History" page
      And I click on Sign Out in the Header for "NonElmo"




