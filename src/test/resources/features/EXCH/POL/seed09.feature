Feature: Seed09 - Exchange

  Background: Seed 09 For Exchange- Minor Only - FA
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
    And I am a member with City "Denver" in State "CO" with dob "09052000" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I select "No" as pregnancy option
    And I select "No" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    Then I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Family Overview" page
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    And I enter member details with "05052019" date of birth
    And I select "Female" as member's sex option
    And I select "Daughter" as relationship option
    And I select "Yes" to Is Member Applying
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
    And I select "Prefer not to answer" for race and ethnicity
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "4500000" income at "Annually" frequency
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

    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Head of household" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "Yes" for will claim dependents question
    Then I select "Daughter" for who will be claimed as dependent question on the Tax Status page
    Then I click Save and Continue on Tax Status page

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
    Then I set data from application history page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    Then I select "KP Select CO Catastrophic" medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    And I select "Cigna Dental Pediatric" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
#    And I select the terms and agreements checkbox
#    And I enter householder signature on the Financial Help Agreements page
#    And I click continue on Financial Help Agreements page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"



