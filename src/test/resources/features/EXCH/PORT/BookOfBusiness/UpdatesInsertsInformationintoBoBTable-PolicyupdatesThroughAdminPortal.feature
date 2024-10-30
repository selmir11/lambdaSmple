@BrokerPortalBOB @port @SLER-1103
Feature:Updates/Inserts Information into BoB Table - Policy updates through Admin Portal

  Scenario: : Policy updates through Admin Portal
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Admin search" page
    And  I search for user and click email from search results
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

    And I verify the broker authorization in BoB DB is "Maggie Walker"
    And I click Continue with my application
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

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011980", "Female" and applying "Yes"
      |Primary:Spouse|
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
    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for no financial help

    Then I validate I am on the "Tell us about life changes" page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    And I verify the client application submission in BoB DB

    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Enrollment Groups" page
    And I click continue on grouping Members Medical page
    And I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Medical Enrollment Groups" page
    Then I click continue on grouping Members Dental page
    And I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I continue on plan summary page

    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    And I validate I am on the "Pay now" page

    Then I click all done from payment portal page
    And I close current tab and switch back to previous tab
    Then I click on manage plan button on admin portal Individual dashboard

    And I validate I am on the "Manage Plans" page
    And I click Make Changes Medical button
    Then I update the coverage end date
      |1:end of month|
      |2:end of month|
    And I update the financial end date
      |1:end of month|
      |2:end of month|
    And I click Save Button Medical
   Then I wait for 200 milliseconds
    And I select the reason to confirm the changes
    Then I close current tab and switch back to previous tab
    Then I logout from Admin Portal
    Then I wait for 200 milliseconds


    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+MWalkerSTG@outlook.com" password "ALaska12!" and "C4PortTesting+MaggieWalker@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I search for clients
    And I click on first client search result
    Then I verify that my client's current status is "ELIGIBILITY ONLY"
    And I verify there are no medical records for my client in BoB DB
    And I verify the client's policy submission in BoB DB has 1 expected records for coverage type 2







