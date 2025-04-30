@OPS @Exch @IndiviualDashboard
Feature: Admin Portal as OBO verify member data on the left
  @SLER-312
  Scenario: Verify member data
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "2425005563" "2425005563" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I validate Selected Member data on the far left side
    And logout from Admin Portal


  @SLER-2205
  Scenario: OPS: Change Account Details and Verify on Profile [RT-1932]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
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
    Then I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "37000.00" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I close current tab and switch back to previous tab

    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for the user with account id
    Then I select the first record from the search results
    Then I validate I am on the "Admin Portal individual dashboard" page

    #Validation for original data
    Then I verify Primary account holder and account number displays
    Then I validate Selected Member label and member data on the far left side
    Then I validate content from Account Summary Container
    Then I click on manage account details button on admin portal Individual dashboard
    Then I validate I am on the "account details" page
    Then I validate all details for primary holder on account details page
    Then I click on Edit Fields via OBO button on the account details page
    Then I close current tab and switch back to previous tab
    Then I switch to the tab number 1
    And I click on Make Changes Button

    # updating email, address, Contact method and language for the first time on same account
    Then I update the contact email address on profile page
    And I update the contact home phone number on profile page
    And I update the contact mobile phone number on profile page
    And I change the Preferred Contact Method to "Mail"
    And I update Preferred Written Language to "Spanish"
    And I click on the My Profile Save Button while OBO
    Then I click on Go back to Welcome page Button on My Profile Exch

    # updating full name and address for the second time on same account
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    Then I update full name of member with prefix "Primary"
    And I click continue on Tell us about yourself page
    Then I select "New" for Residential Address
    And I enter the new residential address details for "Primary"
      | addressLine1    | addressLine2 | city   | state | zipcode | county |
      | 101 Update Lane |              | Denver | CO    | 80205   | DENVER |
    Then I select the Different Mailing Address option
    Then I enter member with address line1 "101 Update Lane" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    Then I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    And I click on Apply for Coverage in the "NonElmo" Header


    # updating SSN and DOB for the third time on same account
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "NoneOfThese" and click continue
    And I click Continue With Application button on Report Life Change Page
    Then I click Continue on my own button from Manage who helps you page
    Then I update SSN number to new SSN number "123456798"
    Then I update DOB to new DOB of "02031995"
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    Then I verify the family overview table is present
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "NoneOfThese" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for the user with account id
    Then I select the first record from the search results
    Then I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I validate Selected Member label and member data on the far left side
    Then I validate content from Account Summary Container
    Then I click on manage account details button on admin portal Individual dashboard
    Then I validate I am on the "account details" page

    #validate  updated primary holder details
    Then I validate all details for primary holder on account details page
    Then I close current tab and switch back to previous tab

    #activity report validation
    And I click on view button for "Account Activity" report
    Then I validate I am on the "Account Activity" page
    Then I verify Primary account holder and account number displays on activity report
    And I validate Account Activity title row
    Then I verify "BE_ATL_CONTACT_UPSER.." and following events are displaying as "todays date within last 10 min timestamp"
    Then I verify event code "BE_ATL_CONTACT_UPSER.." and time and compare with previous update log event
    Then I verify and compare all "BE_ATL_CONTACT_UPSER.." event and their time on activity report
    Then I verify and compare all "UP_CHANGE_PRIMARY_CO.." event and their time on activity report
    Then I close current tab and switch back to previous tab
    And I logout from Admin Portal

