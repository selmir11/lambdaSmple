
Feature: Secondary User-Other Health Coverage Elmo Page
@SLER-2337
Scenario: [RT-2615]  CLONE - ELIG-As a Exchange user on the ESI page, I want to save and get the "No option to enroll" option for other members so that I can see this answer on the ESI page
Given I open the login page on the "login" portal
And I validate I am on the "Login" page
When I click create a new account on login page
Then I click create my account from pre-screen page
And I enter general mandatory data for "exchange" account creation
Then I validate I am on the "Login" page
And I enter valid credentials to login
Then I validate I am on the "Account Overview" page
Then I apply for the current year
Then I select "No" option on the Let us guide you page
And I click on save and continue button
Then I click on continue with  application button on Before you begin page
And I report "Birth" and click continue
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
And I get the Primary Member ID
And I click continue on the Citizenship page

Then I click Add Another Family Member
Then I validate I am on the "Add Member" page
Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011982", "Female" and applying "Yes"
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
And I select "Prefer not to answer" for race and ethnicity for "Spouse"
And I click continue on the Race and Ethnicity page
Then I validate I am on the "Citizenship" page
Then I select "Yes" for Citizen option
And I select "No" for Naturalized Immigrant option
And I click continue on the Citizenship page
  Then I click Add Another Family Member

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
  Then I click continue on family overview page

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

  Then I validate I am on the "Tax status" page
  Then I select "No" for will you be claimed as dependent question
  Then I select "Yes" for will file tax return question
  Then I select the "Married filing jointly" tax filing option on the Tax Status page
  Then I select "Spouse" as filing jointly with option on the Tax Status page
  Then I select "Yes" for will claim dependents question
  Then I select "Daughter" for who will be claimed as dependent question on the Tax Status page
  Then I click Save and Continue on Tax Status page

  And I validate I am on the "Other Health Coverage" page
  Then I select "job" as health coverage option

  Then I click continue on the health coverage page
  Then I validate I am on the "Ohc ESI" page
  Then I select the "0" employer for "Primary" member on the ESI page
  Then I select "Yes" for meet the Minimum Value Standard on the ESI page
  Then I enter "500.00" for employee amount question on the ESI page
  Then I select the Are you currently enrolled "No" button on the ESI page
  Then I click "Yes" for offer family plans question
  Then I enter "375.83" for offer family amount question
  Then I click continue on the ESI page
  Then I validate the health insurance enrollment status error message
  Then I click enrollment status for the members
    |      Spouse:NoAccess    |
    |      Daughter:NoAccess  |
  Then I click continue on the ESI page
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  And I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  Then I validate I am on the "Family Overview" page

  And I click plus icon next to member on household page for "Primary"
  And I click the edit income icon on household page for "Primary"
  Then I click continue on the Employment Summary Page
  Then I click continue on the Additional Income page
  Then I click continue on the Deductions page
  Then I select the projected income option "No" and continue
  Then I click Save and Continue on Tax Status page
  Then I click continue on the health coverage page
  Then I validate I am on the "Ohc ESI" page
  Then I verify enrollment status for the members
    |   enrollmentStatus    |
    |      No Option        |
    |      No Option        |
  And I click on Sign Out in the Header for "Elmo"






