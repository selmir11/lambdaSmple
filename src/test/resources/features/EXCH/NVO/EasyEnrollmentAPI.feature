Feature: Easy Enrollment API
  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-1830 @EE_API @NVOExchRegression
  Scenario: Easy Enrollment API validation failure for invalid SSN
    Given I get Easy Enrollment API base URL
    When I send a request with the following data: adjustedGrossIncome:"40000", emailAddress:"random_email", filedByDeadline:"1", filingType:"1", firstName:"John", householdSize:"1", lastName:"Smith", mailingAddressLine1:"123 Street", zipCode:"80205", middleInitial:"M", phoneNumber:"7206574321", dateOfBirth:"11201994", ssn:"random"
    And I send the DOR to C4 API request
    Then response status code should be 400
    And validation message should be "{taxHouseholdMembers[0].ssn:: Must be 9 digits}"

@SLER-1934
  Scenario: ELIG-Easy Enrollment DOR to C4-QLCE granted, Shopping allowed, No notices triggered
    Given I get Easy Enrollment API base URL
    Then I send a request body with the following data: adjustedGrossIncome:"40000", emailAddress:"null", filedByDeadline:"1", filingType:"1", firstName:"Matt", householdSize:"1", lastName:"Gaetz", mailingAddressLine1:"null", mailingAddressLine2:"null", city:"Denver", zipCode:"80205", middleInitial:"M", phoneNumber:"7206661280", dateOfBirth:"11211984", ssn:"134251980", year:"2021"
    And I send the DOR to C4 API request
    Then response status code should be 200


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
    And I am a member with City "Denver" in State "CO" with dob "11211984" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter member with address line1 "1234 Street" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
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
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "4000000" income at "Annually" frequency
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
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Sign Out in the Header for "NonElmo"
    #Db steps
    Then I validate eventCD when no notices are sent

@SLER-1938
  Scenario: ELIG - Easy Enrollment: 1 member, QLCE is not granted, shopping is not allowed, only paper notice (EE 1-2) is triggered
  Given I click create a new account on login page
  Then I click create my account from pre-screen page
  And I enter general mandatory data for "exchange" account creation

    When I get Easy Enrollment API base URL
    Then I send a request body with out email and addressLine2 the following data: adjustedGrossIncome:"55000", filedByDeadline:"0", filingType:"1", householdSize:"1", mailingAddressLine1:"11 Stroh Road", city:"Denver", zipCode:"80205", middleInitial:"M", phoneNumber:"7206661280", dateOfBirth:"12011971", ssn:"653035280", year:"2025"
    And I send the DOR to C4 API request
    Then response status code should be 200

   Then I validate event_cd in easy enrollment event log in DB
     |PASSED_MEMBER_VALIDATION|
     |PASSED_POSTAL_ADDRESS_VALIDATION|
     |FAILED_EMAIL_ADDRESS_VALIDATION|
     |INITIAL_EE_12_NOTICE_SENT|

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Other" and click continue
    Then I click Continue button on Report a Life Change Page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "12011971" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter member with address line1 "11 Stroh Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
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
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "5500000" income at "Annually" frequency
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
    Then I select "TaxTimeEnrollmentPeriod" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Sign Out in the Header for "NonElmo"
    #DB steps
    Then I validate event_cd in easy enrollment event log in DB
    |PASSED_MEMBER_VALIDATION|
    |PASSED_POSTAL_ADDRESS_VALIDATION|
    |FAILED_EMAIL_ADDRESS_VALIDATION|
    |INITIAL_EE_12_NOTICE_SENT|
    |ACCOUNT_MATCH|
    And I verify the application result details in DB as "NO_TAX_TIME_ENROLLMENT_ELIGIBILITY" for "Primary"

  @RT-2199 @SLER-1987
  Scenario: ELIG - Easy Enrollment: 2 member, QLCE is not granted, no notices are triggered
    Given I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Other" and click continue
    Then I click Continue button on Report a Life Change Page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "12011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter member with address line1 "11 Stroh Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page


    Given I get Easy Enrollment API base URL
    Then I have the following API payload
      | key                 | value         |
      | adjustedGrossIncome | 40000         |
      | emailAddress        | null          |
      | filedByDeadline     | 1             |
      | filingType          | 1             |
      | firstName           | null          |
      | householdSize       | 2             |
      | lastName            | <PrimLName>   |
      | mailingAddressCity  | Denver        |
      | mailingAddressState | CO            |
      | mailingAddressZip   | 80205         |
      | middleInitial       | M             |
      | phoneNumber         | <RandomPhone> |
      | taxpayerKey         | <taxpayerKey> |
      | year                | 2022          |
    And I have the following tax household members
      | dateOfBirth | firstName | lastName    | middleInitial | ssn       |
      |             |           | <PrimLName> | M             |           |
      | 01012009    | <Random>  | <Random>    | E             | 787348251 |
    And I send the DOR to C4 API request
    Then response status code should be 200

#    Given I click create a new account on login page
#    Then I click create my account from pre-screen page
#    And I enter general mandatory data for "exchange" account creation
#    Then I validate I am on the "Login" page
#    And  I enter valid credentials to login
#    Then I apply for the current year
#    Then I select "No" option on the Let us guide you page
#    And I click on save and continue button
#    Then I click on continue with  application button on Before you begin page
#    And I report "Other" and click continue
#    Then I click Continue button on Report a Life Change Page
#    Then I select "member" from the who are you question
#    And I am a member with City "Denver" in State "CO" with dob "12011980" in county "DENVER" with zipcode "80205"
#    Then I answer all Id proofing questions and click continue
#    And I click continue button on Congratulations page
#    Then I validate I am on the "Find Expert Help" page
#    Then I click Continue on my own button from Manage who helps you page
#    Then I select "Male" as sex option
#    And I select "Yes" to Are You Applying
#    And I click continue on Tell us about yourself page
#    Then I enter member with address line1 "11 Stroh Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
#    And I select "Yes" for CO Resident option
#    And I select "No" for Federally Recognized Tribe option
#    And I select "No" for Hardship Exemption option
#    And I select "No" for Disability option
#    And I select "No" to the recently denied medicaid question
#    And I select "No" for Incarceration option
#    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "01012009", "Female" and applying "Yes"
      | Primary:Daughter |
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
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
    Then I enter company details with addressline1 as "1234 Uptown" and city as "Denver" and state as "CO" and zipcode as "80205" and income "4000000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Head of household" tax filing status
    And I select "Yes" to claim dependents
    And I select the first dependent
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "TaxTimeEnrollmentPeriod" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on "No Thanks" on good news page
    Then I click on view results and shop
    And I click on Sign Out in the Header for "NonElmo"

    Then I validate event_cd in easy enrollment event log in DB
      |FAILED_MEMBER_VALIDATION|
      |FAILED_POSTAL_ADDRESS_VALIDATION|
      |FAILED_EMAIL_ADDRESS_VALIDATION|
      |NOT_SENDING_NOTICE|

    And I verify the application result details in DB as "NO_TAX_TIME_ENROLLMENT_ELIGIBILITY" for "Primary"









