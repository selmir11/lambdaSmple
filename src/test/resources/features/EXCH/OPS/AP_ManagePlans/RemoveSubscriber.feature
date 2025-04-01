
Feature: OPS: MP: FA Removing Subscriber from policy
@SLER-2389 #WIP
  Scenario: [RT-2422] FA Removing Subscriber from policy

    Given I open the login page on the "admin" portal
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    Then I click create account on admin portal
    And I enter general mandatory data for "Admin exchange" account creation with email "MGC4testing"@outlook.com
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
  Then I select "No" option on the Let us guide you page
  And I click on save and continue button
  Then I click on continue with  application button on Before you begin page
  And I report "MovedToColorado" and click continue
  Then I select "member" from the who are you question
  And I am a member with City "Denver" in State "CO" with dob "11281990" in county "DENVER" with zipcode "80205"
  Then I answer all Id proofing questions and click continue
  And I click continue button on Congratulations page
  Then I validate I am on the "Find Expert Help" page
  Then I click Continue on my own button from Manage who helps you page
  Then I select "Male" as sex option
  And I select "Yes" to Are You Applying
  And I click continue on Tell us about yourself page
  Then I validate I am on the "Add Address" page
  Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80202" and county "DENVER"
  Then I select "Yes" for CO Resident option
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
  Then I click Add Another Family Member
  Then I validate I am on the "Add Member" page
  Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011991", "Female" and applying "Yes"
    |Primary:Spouse|
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
  Then I validate I am on the "Race and Ethnicity" page
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
  Then I enter company details with addressline1 as "1234 Uptown" and city as "Boulder" and state as "CO" and zipcode as "80020" and income "5500000" at frequency "Annually"
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
  Then I select "No" for will you be claimed as dependent question
  Then I select "Yes" for will file tax return question
  Then I select the "Married filing jointly" tax filing option on the Tax Status page
  Then I select "Spouse" as filing jointly with option on the Tax Status page
  Then I select "No" for will claim dependents question
  Then I click Save and Continue on Tax Status page

  Then I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  Then I validate I am on the "Other Health Coverage" page
  Then I select "None of these" as health coverage option
  Then I click continue on the health coverage page
  Then I validate I am on the "Family Overview" page

  Then I click continue on family overview page
  Then I validate I am on the "Tell us about life changes" page
  Then I select "Birth" QLCE on tell us about life changes page
  Then I click on Save and Continue
    # Declarations and signature
  Then I validate I am on the "EXCH Declarations and Signature" page
  And I Declare as Tax Household 1
  Then I click Continue on the Declarations And Signature Page
  Then I validate I am on the "Application History" page

  And I close current tab and switch back to previous tab
  And I click "Admin LCE" from application links dropdown
  And I look up with account id on admin tool page
  And I change effective date to "0101" of "current year" from admin portal


  And I click "On Behalf Of (OBO)" from application links dropdown
  Then I validate I am on the "Account Overview" page
  Then I click on ClickHere link for "My Eligibility"
  Then I validate I am on the "Application History" page

  Then I click on view results and shop
  Then I validate I am on the "Application Results" page
  Then I click continue on application results page
  Then I validate I am on the "Start Shopping" page
  Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
  Then I click continue on start shopping page
  Then I click continue on grouping Members Medical page
  And I validate I am on the "Medical Plan Results" page
  And I select "Cigna Connect Colorado Option Gold" medical plan
  Then I click continue on medical plan results page
  Then I validate I am on the "Grouping Members Dental" page
  Then I click continue on grouping Members Dental page
  And I validate I am on the "Dental Plan Results" page
  And I select "Anthem Dental Family" plan
  Then I click continue on dental plan results page
  Then I validate I am on the "planSummaryMedicalDental" page
  And I click continue on plan summary page
  And I validate I am on the "Financial Help Agreements" page
  And I select the terms and agreements checkbox
  And I enter householder signature on the Financial Help Agreements page
  And I click continue on Financial Help Agreements page
  And I select "Acknowledgement" agreement checkbox
  And I select "Submit" agreement checkbox
  And I enter householder signature on the Enrollment Agreements page
  And I click submit enrollment on Enrollment Agreements page
  Then I click all done from payment portal page
  Then I validate I am on the "Account Overview" page

  And I close current tab and switch back to previous tab

  Then I validate I am on the "Admin Portal individual dashboard" page
  Then I click on "Manage Plans" user dashboard button







