Feature: Page Navigation for two members
@SLER-2271
Scenario: Navigation from Employment Income details page back to the calling Exch application page (Go Back Button is Enabled)
  Given I open the login page on the "login" portal
  And I validate I am on the "Login" page
  When I click create a new account on login page
  Then I click create my account from pre-screen page
  And I enter general mandatory data for "exchange" account creation
  Then I validate I am on the "Login" page
  And  I enter valid credentials to login
  Then I validate I am on the "Account Overview" page
  Then I apply for the current year
  Then I select "No" option on the Let us guide you page
  And I click on save and continue button
  Then I click on continue with  application button on Before you begin page
  And I report "Birth" and click continue
  Then I select "member" from the who are you question
  And I am a member with City "Denver" in State "CO" with dob "01011990" in county "DENVER" with zipcode "80205"
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
  Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "04051991", "Female" and applying "Yes"
    | Primary:Spouse |
  And I mark the Additional member is pregnant as "No"
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
  And I select "Prefer not to answer" for race and ethnicity for "Spouse"
  And I click continue on the Race and Ethnicity page
  Then I select "Yes" for Citizen option
  And I select "No" for Naturalized Immigrant option
  And I click continue on the Citizenship page
  Then I click continue on family overview page
  And I Apply for financial help
  And I validate I am on the "Employment Income" page
  Then I select the option "Yes" to employment
  And I select the option "No" to self employment
  And I enter employment details with "1500000" income at "Annually" frequency
  And I select the option "No" to seasonal employment
  And I select the option "No" to projected income
  And I click continue on the Employment Info Page
  Then I click continue on the Employment Summary Page
  Then I click None of these as additional income option and continue
  Then I validate I am on the "Deductions" page
  Then I click None of these as deduction option and continue
  Then I validate I am on the "Income Summary" page
  Then I select the projected income option "No" and continue
  And I click go back button on the Employment Info Page
  Then I validate I am on the "Family Overview" page
  And I click plus icon next to member on household page for "Spouse"
  And I click the edit income icon on household page for "Spouse"
  Then I validate I am on the "Employment Income" page
  Then I select the option "Yes" to employment
  And I select the option "No" to self employment
  And I enter employment details with "1500000" income at "Annually" frequency
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
  Then I select the "Married filing jointly" tax filing option on the Tax Status Elmo page
  Then I select "Spouse" as filing jointly with option on the Tax Status Elmo page
  Then I select "No" for will claim dependents question
  Then I click Save and Continue on Tax Status Elmo page

  Then I select "None of these" as ELMO health coverage option
  Then I click continue on the ELMO health coverage page
  Then I select "None of these" as ELMO health coverage option
  Then I click continue on the ELMO health coverage page
  Then I validate I am on the "Family Overview" page
#  Then I select "No" for will claim dependents question
#  Then I click Save and Continue on Tax Status Elmo page
#  Then I select "Yes" for will you be claimed as dependent question
#  Then I select "Primary" for who will claim as dependent question
#  Then I click Save and Continue on Tax Status Elmo page
#  And I validate I am on the "Elmo Other Health Coverage" page
#  Then I select "None of these" as ELMO health coverage option
#  Then I click continue on the ELMO health coverage page
#  And I validate I am on the "Elmo Other Health Coverage" page
#  Then I select "None of these" as ELMO health coverage option
#  Then I click continue on the ELMO health coverage page
