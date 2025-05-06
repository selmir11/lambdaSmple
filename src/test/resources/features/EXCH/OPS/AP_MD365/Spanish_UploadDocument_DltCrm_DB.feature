@OPS @MD365 @OPSDB
Feature: MD365: Upload document in Spanish, check DLT, CRM, and DB for that new document
  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
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
    And I am a member with City "Denver" in State "CO" with dob "01011990" in county "DENVER" with zipcode "80205"
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
    And I close current tab and switch back to previous tab
  @SLER-2369
  Scenario: SLER-2366  Upload new document, check DLT, CRM, and DB for new document
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    And I change the language from header to "Spanish"
    Then I wait for 10000 milliseconds
    And I click on verify Financial Help for Eligibility button is displaying for user
    Then I validate I am on the "Self Attestation" page
    And I select "No" for Household Income
    And I select "No" for Federal Income
    Then I click on Submit Self Attestation button
    Then I click on Finish
    Then I validate I am on the "My Document Spanish" page
    Then I click on upload another document
    And I upload another doc "TestMyDocs.docx" for category "Ingreso" and type "Formulario 8962" and verify success message "Spanish"
    And I close current tab and switch back to previous tab
    And I click "Document Lookup" from application links dropdown
    And I validate Document look Up page title is displaying on page
    And I click on Advanced search
    Then I select "Individual" from advanced search dropdown options
    And I enter the account number
    And I wait for 2000 milliseconds
    Then I click on submit button
    Then I verify Admin search results table columns
    Then I validate the document details with values
      | 7708      |
      | null      |
      | Form 8962 |
      | docx      |
     ####    CRM status verification
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
    Then I open the "Income" MVR
    Then I check the "Income" MVR title for "Primary"
    Then I check that the MVR has a status of "Open"
    And I wait for 5000 milliseconds
    Then I sign out of CRM