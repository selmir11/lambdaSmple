@CRMNvo  @NVOExchRegression
Feature: Testing CRM (MD365) updates

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
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
    Then I validate I am on the "Find Expert Help Exch" page
    And I click on Find a Broker
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter member with address line1 "5678 Street" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    Then I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

  @SLER-1298 @NVOExchRegression
  Scenario: SLER-1298 Changing Primary Contact is shared with the CRM
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "12261991", "Female" and applying "Yes"
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
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Son", "12312021", "Male" and applying "Yes"
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
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "9000000" income at "Annually" frequency
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
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status Elmo" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
    Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
    Then I select "Yes" for will claim dependents question
    Then I select "Son" for who will be claimed as dependent question on the Tax Status Elmo page
    Then I click Save and Continue on Tax Status Elmo page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click "No" on Before you continue popup on the application history page
    And I click on the Username in the "Exch NonElmo" Header

    Then I validate I am on the "My Profile" page
    And I click change primary contact on my profile page
    Then I update "Spouse" as primary member
    And I wait for hold on content to disappear
    And I wait for 2000 milliseconds
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

    And I wait for 50000 milliseconds
    Then I log into the CRM system
    And I wait for 50000 milliseconds
    Then I search for user's Email
    Then I handle the search results page
    And I wait for 50000 milliseconds
    And I verify the Individual Contact data in the CRM
    Then I sign out of CRM

  @SLER-1334 @NVOExchRegression
  Scenario: SLER-1334 Changing Primary Contact data is shared with the CRM
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "3700000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status Elmo page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status Elmo page

    Then I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I wait for 90000 milliseconds
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on Sign Out in the Header for "NonElmo"

    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    And I wait for 1000 milliseconds
    And I verify the Individual Contact data in the CRM
    Then I open the "Details" Tab on contact page
    And I verify the Individual Details data in the CRM
    Then I sign out of CRM

    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    Then I update full name of member with prefix "Primary"
    And I click continue on Tell us about yourself page
    And I click Go back on the Add Address page
    Then I update DOB to new DOB of "11081986"
    Then I update SSN number to new SSN number "123456789"
    Then I click continue on Tell us about yourself page
    Then I select "New" for Residential Address
    And I enter the new residential address details for "Primary"
      | addressLine1           | addressLine2   | city              | state | zipcode | county  |
      | 101 Springs Drive      |                | Colorado Springs  | CO    | 80919   | EL PASO |
    Then I select the Different Mailing Address option
    Then I enter member with address line1 "202 Update Lane" in city "Colorado Springs" in state "CO" with zipcode "80919" and county "EL PASO"
    And I click continue on the Add Address page
    Then I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I wait for 90000 milliseconds
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on Sign Out in the Header for "NonElmo"

    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    And I verify the Individual Contact data in the CRM
    Then I open the "Details" Tab on contact page
    And I verify the Individual Details data in the CRM
    Then I sign out of CRM

  @SLER-1774 @NVOExchRegression
  Scenario: SLER-1774 Changing Primary Contact's email and phone is shared with the CRM
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "9000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status Elmo" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status Elmo page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status Elmo page

    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I wait for 90000 milliseconds
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I click on the Username in the "Exch NonElmo" Header

    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    And I update the contact email address on profile page
    And I update the contact home phone number on profile page
    And I click on Save Button
    And I wait for hold on content to disappear
    And I wait for 2000 milliseconds
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

    And I wait for 50000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    And I verify the Individual Contact data in the CRM
    Then I sign out of CRM