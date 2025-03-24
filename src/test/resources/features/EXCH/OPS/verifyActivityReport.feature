@OPS
Feature: verify Activity Report data on Admin portal

@SLER-2356
Scenario: Verify Activity Header, table names and event code with description [RT-1076]
Given I open the login page on the "admin" portal
And I refresh the page
And I validate I am on the "Login" page
When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
And I validate I am on the "Admin search" page
And I select "individual" checkbox on Admin Portal Dashboard
Then I enter an accountId in any Env "4006908635" "3676508660" to search user
And I click on Search button in AP dashboard page
And I click acct first row from Search Results table in admin portal
And I validate I am on the "Admin Portal individual dashboard" page
Then I click on view button for "Account Activity" report
And I switch to the tab number 1
Then I validate I am on the "Account Activity" page
Then I verify Primary account holder and account number displays on Activity Report
And I validate Account Activity title
Then I verify Activity report table column names
Then I validate "UI_ACCT_CREATED" event code and their description "Account created" in activity event report
Then I validate "BE_Q_AND_A_REQUESTED" event code and their description "Questions and Answers req.." in activity event report
Then I validate "SE_ENRLLMT_SUBMITTED.." event code and their description "Purchased and enrolled in.." in activity event report
Then I validate "BE_SES_RSSAP_REQ" event code and their description "Shared Eligibility Servic.." in activity event report
Then I validate "BE_ID_PROOFING_REQUE.." event code and their description "ID Proofing requested via.." in activity event report
    # if QA env,Comment below validation - description "Contact Upsert" line due to data mismatch
 #Then I validate "BE_ATL_CONTACT_UPSER.." event code and their description "Contact Upsert" in activity event report
  # if staging env,Comment below validation - description "Customer record is transf..  line due to data issue
Then I validate "BE_ATL_CONTACT_UPSER.." event code and their description "Customer record is transf.." in activity event report
Then I close current tab and switch back to previous tab
And I logout from Admin Portal
 