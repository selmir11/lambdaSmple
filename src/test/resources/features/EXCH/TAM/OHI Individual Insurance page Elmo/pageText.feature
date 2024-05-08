@TAM
Feature: Page Text-OHI Individual Insurance Elmo Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-275 @PageTextOhiIndividualInsuranceElmo
  Scenario: SLER-275 I can see Individual Insurance's Header and footer - English
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
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Find Expert Help page
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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "Individual Insurance" as health insurance option and continue

    And I change the C4 url to "Elmo Ohi Individual Insurance Page"
    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"

    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I click on the Username in the "Exch" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Find Expert Help page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Citizenship page
    And I click on the table dropdown
    And I click the edit income 1
    And I click continue on the Employment Info Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the Other Health Insurance page

    And I change the C4 url to "Elmo Ohi Individual Insurance Page"
    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-276 @PageTextOhiIndividualInsuranceElmo
  Scenario: SLER-276 I can see Individual Insurance's Header and footer - Spanish
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
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Find Expert Help page
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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "Individual Insurance" as health insurance option and continue

    And I change the C4 url to "Elmo Ohi Individual Insurance Page"
    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"

    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I validate I am on the "Spanish" page
    And I click on the Username in the "Exch" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Find Expert Help page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Citizenship page
    And I click on the table dropdown
    And I click the edit income 1
    And I click continue on the Employment Info Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the Other Health Insurance page

    And I change the C4 url to "Elmo Ohi Individual Insurance Page"
    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I validate I am on the "Spanish" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I validate I am on the "Spanish" page
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I validate I am on the "Spanish" page
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I validate I am on the "Spanish" page
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I validate I am on the "Spanish" page
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I validate I am on the "Spanish" page
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I validate I am on the "Spanish" page
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I validate I am on the "Spanish" page
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "Elmo Ohi Individual Insurance" page
    And I validate I am on the "Spanish" page


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page


  @SLER-265 @PageVerificationIndividualInsurancePage
  Scenario: SLER-265 I Validate the saved options persist on the Individual Insurance page
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
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Find Expert Help page
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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "2500000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "Individual Insurance" as health insurance option and continue

    And I change the C4 url to "Elmo Ohi Individual Insurance Page"
    And I validate I am on the "Elmo Ohi Individual Insurance" page
#Step 3
    And I verify the header for Primary Member on the Individual Insurance page
#Step 4
    And I click on Apply for Coverage in the "Elmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Find Expert Help page
    Then I update Full Name to new Name
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Citizenship page
    And I click on the table dropdown
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the Other Health Insurance page
    And I change the C4 url to "Elmo Ohi Individual Insurance Page"
    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I verify the header for Primary Member on the Individual Insurance page
#Step 5
    Then I click "No" for currently enrolled in Individual Insurance question
    Then I click continue on the Elmo OHI Individual Insurance page
#Step 6
    And I click on Apply for Coverage in the "Elmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Find Expert Help page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Citizenship page
    And I click on the table dropdown
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the Other Health Insurance page
    And I change the C4 url to "Elmo Ohi Individual Insurance Page"
    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I verify Currently Enrolled is "No" on the Individual Insurance page

    Then I click "Yes" for currently enrolled in Individual Insurance question
    Then I click "No" for insurance ending in 60 days in Individual Insurance question
    Then I click continue on the Elmo OHI Individual Insurance page

    And I click on Apply for Coverage in the "Elmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Find Expert Help page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Citizenship page
    And I click on the table dropdown
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the Other Health Insurance page
    And I change the C4 url to "Elmo Ohi Individual Insurance Page"
    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I verify Currently Enrolled is "Yes" on the Individual Insurance page
    And I verify Insurance Ending in 60 days is "No" on the Individual Insurance page

    Then I click "Yes" for insurance ending in 60 days in Individual Insurance question
    Then I enter the end date as "Current Month" on the Individual Insurance page
    Then I click "No" for insurance ending voluntary for Individual Insurance question
    Then I click continue on the Elmo OHI Individual Insurance page

    And I click on Apply for Coverage in the "Elmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Find Expert Help page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Citizenship page
    And I click on the table dropdown
    And I click the edit income 1
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the Other Health Insurance page
    And I change the C4 url to "Elmo Ohi Individual Insurance Page"
    And I validate I am on the "Elmo Ohi Individual Insurance" page
    And I verify Currently Enrolled is "Yes" on the Individual Insurance page
    And I verify Insurance Ending in 60 days is "Yes" on the Individual Insurance page
    And I verify end date is the last day of the month on the Individual Insurance page
    And I verify Voluntarily Ending is "No" on the Individual Insurance page

    And I click on Sign Out in the Header for "Elmo"

