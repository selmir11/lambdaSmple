@OPS @Exch @MyDocs
Feature: IndDash: Verify Financial Help Eligibility button is displaying
  Background:
  Given I open the login page on the "admin" portal
And I validate I am on the "Login" page
When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
And I validate I am on the "Admin search" page

Then I click create account on admin portal
Then I enter general mandatory data for "exchange" account creation
And I validate I am on the "Admin search" page
Then I search for user and click email from search results
Then I validate I am on the "Admin Portal individual dashboard" page
Then I validate "Admin Portal Text Display" for Admin Portal
And I click "On Behalf Of (OBO)" from application links dropdown
Then I switch to the tab number 1
And I validate I am on the "Account Overview" page

And I apply for the current year
Then I select "No" option on the Let us guide you page
And I click on save and continue button
Then I click on continue with  application button on Before you begin page
And I report "Birth" and click continue
Then I select "member" from the who are you question
And I am a member with City "Denver" in State "CO" with dob "01011983" in county "DENVER" with zipcode "80205"
Then I answer all Id proofing questions and click continue
And I click continue button on Congratulations page
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

Then I validate I am on the "Add Address" page
And I enter member with address line1 "1234 Road " in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
And I select "Yes" for CO Resident option
And I select "No" for Federally Recognized Tribe option
Then I select "No" for Hardship Exemption option
Then I select "No" for Disability option
Then I select "No" to the recently denied medicaid question
Then I select "No" for Incarceration option
And I click continue on the Add Address page
Then I validate I am on the "Ethnicity and Race" page
And I select "Prefer not to answer" for race and ethnicity for "Primary"
And I click continue on the Race and Ethnicity page
Then I select "Yes" for Citizen option
And I select "No" for Naturalized Immigrant option
And I click continue on the Citizenship page

Then I click continue on family overview page
Then I validate I am on the "Financial Help" page
And I Apply for financial help

Then I select the option "Yes" to employment
And I select the option "No" to self employment
Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as " CO " and zipcode as "80205" and income "2400000" at frequency "Annually"
And I select the option "No" to seasonal employment
And I select the option "No" to projected income
And I click continue on the Employment Info Page
Then I click continue on the Employment Summary Page
Then I click None of these as additional income option and continue
Then I validate I am on the "Deductions" page
Then I click None of these as deduction option and continue
Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
Then I select "None of these" as health coverage option
Then I click continue on the health coverage page
Then I click continue on family overview page

Then I validate I am on the "Tell us about life changes" page
Then I select "Birth" QLCE on tell us about life changes page
Then I click on Save and Continue

Then I validate I am on the "EXCH Declarations and Signature" page
Then I Declare as Tax Household 1
And I click Continue on the Declarations And Signature Page
And I wait for hold on content to disappear

Then I validate I am on the "Application History" page
Then I click on view results and shop
Then I validate I am on the "Application Results" page
Then I click continue on application results page
Then I click continue on start shopping page

    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
  Then I click continue on start shopping page
And I validate I am on the "Medical Plan Results" page
And I select "Elevate Health Plans Colorado Option Bronze" medical plan
Then I click continue on medical plan results page
And I validate I am on the "Dental Plan Results" page
And I select "Delta Dental of Colorado Family Basic Plan" plan
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

And I validate I am on the "Pay now" page
Then I click all done from payment portal page OBO
And I close current tab and switch back to previous tab

  @SLER-1858
  Scenario: SLER-1858 Verify Financial Help Eligibility button and upload button is displaying for user(access from admin portal)
  And I click "On Behalf Of (OBO)" from application links dropdown
  Then I click link my docs on accountOverview page
  Then I validate I am on the "My Documents" page
  And I click on verify Financial Help for Eligibility button is displaying for user
  Then I validate I am on the "Self Attestation" page
  And I select "Yes" for Household Income
  And I select "Yes" for Federal Income
  And I select "No" for Tax Info
  Then I click on Submit Self Attestation button
  Then I verify the "Action Required" text on the Post Attestation page
  Then I click on Finish
  And I close current tab and switch back to previous tab

  And I click "On Behalf Of (OBO)" from application links dropdown
  Then I click link my docs on accountOverview page
  And I wait for 2000 milliseconds
  Then I upload MVR doc for "Financial Help Eligibility" on the My Documents page

    @SLER-1863
  Scenario: SLER-1863 Verify Financial Help Eligibility button and upload button is displaying for user(access from admin portal- Spanish) and then verify account activity
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I change the language from header to "Spanish"
    And I click on verify Financial Help for Eligibility button is displaying for user
    Then I validate I am on the "Self Attestation" page
    And I select "Yes" for Household Income
    And I select "Yes" for Federal Income
    And I select "No" for Tax Info
    Then I click on Submit Self Attestation button
      And I change the language from header to "English"
    Then I verify the "Action Required" text on the Post Attestation page
    Then I click on Finish
    And I close current tab and switch back to previous tab
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I upload MVR doc for "Financial Help Eligibility" on the My Documents page
    And I close current tab and switch back to previous tab
    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I verify "UI_INCOME_APTC_ATTES.." and following events are displaying as "todays date within last 10 min timestamp" "C4test.aduser12.." "C4testaduser123.." "User attested to Income" "AttestedToIncom.." "Attestation submitted: IN.."

  @SLER-2100
  Scenario: SLER-2100 Verify MVR status is open in CRM when user submit financial eligibilty
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I change the language from header to "Spanish"
    And I click on verify Financial Help for Eligibility button is displaying for user
    Then I validate I am on the "Self Attestation" page
    And I select "Yes" for Household Income
    And I select "Yes" for Federal Income
    And I select "No" for Tax Info
    Then I click on Submit Self Attestation button
    Then I click on Finish
    And I close current tab and switch back to previous tab
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I verify "Financial Help Eligibility" MRV needed on the My Documents page
#    CRM status verification
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
     Then I open the "Income" MVR
    Then I check the "Income" MVR title for "Primary"
    Then I check that the MVR has a status of "Open"

  @SLER-2111
  Scenario: SLER-2111 Verify MVR status is "Cancelled" in CRM when user submit financial eligibilty
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I change the language from header to "Spanish"
    And I click on verify Financial Help for Eligibility button is displaying for user
    Then I validate I am on the "Self Attestation" page
    And I select "Yes" for Household Income
    And I select "No" for Federal Income
    Then I click on Submit Self Attestation button
    Then I click on Finish
    And I close current tab and switch back to previous tab
#    CRM status verification
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
    Then I open the "Income" MVR
    Then I check the "Income" MVR title for "Primary"
    Then I check that the MVR has a status of "Canceled"